import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

// TODO
// Encontrar um jeito de fechar o escritor e leitor quando o objeto for destruído
// Provavelmente com algum tipo de interface

// TODO
// Fazer com que quando ele importa uma receita,
// importa os ingredientes não so como percentes à receita,
// mas também como ingredientes que podem ser utilizados em outra receitas.
// pra isso precisamos ter algum lugar pra armazenar todos os ingredientes
// disponíveis, talvez uma lista estática da classe

public class ExpoImpoAlimentos implements ExpoImpo, AutoCloseable {

    private File arquivo;
    private FileWriter escritor;
    private BufferedReader leitor;

    public ExpoImpoAlimentos(String arquivoSaida) throws Exception {
        // Precisa do try catch pq ele pode não achar o arquivo
        try {
            this.arquivo = new File(arquivoSaida + ".csv");
            escritor = new FileWriter(arquivo);
            leitor = new BufferedReader(new FileReader(arquivo));
        } catch (Exception e) {
            throw e;
        }
    }

    public boolean setArquivo(String novoArquivo) {
        try {
            File novo = new File(novoArquivo + ".csv");
            FileWriter novoEscritor = new FileWriter(arquivo);
            BufferedReader novoLeitor = new BufferedReader(new FileReader(arquivo));
            this.arquivo = novo;
            this.escritor = novoEscritor;
            this.leitor = novoLeitor;
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public File getArquivo() {
        return arquivo;
    }

    public void close() {
        try {
            escritor.close();
            leitor.close();
        } catch (IOException e) {
            return;
        }
    }

    public boolean exportarIngredientes(ArrayList<Ingrediente> listaIngredientes) {
        String colunas = "Nome,Proteínas,Gorduras,Carboidratos,Calorias,Porção";
        try {
            escritor.write(colunas);
            for (Ingrediente ingrediente : listaIngredientes) {
                escritor.append("\n" + ingrediente.toString());
            }
            escritor.flush();

        } catch (IOException e) {
            return false;
        }
        return true;
    }

    public boolean exportar(ArrayList<?> listaObjetos) {
        ArrayList<Receita> listaReceitas = (ArrayList<Receita>) listaObjetos;
        return exportarReceitas(listaReceitas);
    }

    public boolean exportarReceitas(ArrayList<Receita> listaReceitas) {
        int atual, max = 0;
        String receitas = "";
        String colunas = "Nome,Proteinas,Gorduras,Carboídratos,Calorias,Porção";
        for (Receita receita : listaReceitas) {
            receitas += "\n" + receita.toString();
            atual = receita.getListaIngredientes().size();
            if (max < atual) {
                max = atual;
            }
        }
        for (int i = 0; i < max; i++) {
            String ingrediente = "Nome_" + i + ",Proteínas_" + i + ",Gorduras_" + i + ",Carboídratos_" + i
                    + ",Calorias_" + i + ",Porção_" + i;
            colunas = colunas + ingrediente;
        }
        try {
            escritor.write(colunas + receitas);
            escritor.flush();
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    public boolean exportarAlimentos(ArrayList<Alimento> listaAlimentos) {
        return true;
    }

    public boolean importarIngredientes(ArrayList<Ingrediente> listaIngredientes) {
        // Essa função recebe uma lista de ingredientes por referência e modifica ela
        // dentro da função

        String line;
        try {
            // Le a primeira linha dos identificadores
            line = leitor.readLine();
            while ((line = leitor.readLine()) != null) {
                String[] valores = line.split(",");
                String nome = valores[0];
                double prot = Double.parseDouble(valores[1]);
                double fat = Double.parseDouble(valores[2]);
                double carb = Double.parseDouble(valores[3]);
                double cal = Double.parseDouble(valores[4]);
                double porcao = Double.parseDouble(valores[5]);
                listaIngredientes.add(new Ingrediente(nome, prot, fat, carb, cal, porcao));
            }
        } catch (IOException e) {
            // Se deu erro, não temos como saber o estado da lista, por isso limpamos ela
            listaIngredientes.clear();
            return false;
        }
        return true;
    }

    public boolean importar(ArrayList<?> listaObjetos) {
        ArrayList<Receita> listaReceitas = (ArrayList<Receita>) listaObjetos;
        return importarReceitas(listaReceitas);
    }

    public boolean importarReceitas(ArrayList<Receita> listaReceitas) {
        String linha;
        Receita receita;
        Ingrediente ingrediente;
        int atual;
        try {
            linha = leitor.readLine();
            while ((linha = leitor.readLine()) != null) {
                String[] valores = linha.split(",");
                int qtdIngredientes = (valores.length / 6) - 1;
                String nome = valores[0];
                double prot = Double.parseDouble(valores[1]);
                double fat = Double.parseDouble(valores[2]);
                double carb = Double.parseDouble(valores[3]);
                double cal = Double.parseDouble(valores[4]);
                double porcao = Double.parseDouble(valores[5]);
                receita = new Receita(nome, prot, fat, carb, cal, porcao);

                for (int j = 1; j <= qtdIngredientes; j++) {
                    atual = j * 6;
                    nome = valores[atual];
                    prot = Double.parseDouble(valores[1 + atual]);
                    fat = Double.parseDouble(valores[2 + atual]);
                    carb = Double.parseDouble(valores[3 + atual]);
                    cal = Double.parseDouble(valores[4 + atual]);
                    porcao = Double.parseDouble(valores[5 + atual]);

                    // Precisamos fazer assim pois a porção que é passada pro ingrediente também
                    // influencia nos macros
                    ingrediente = new Ingrediente(nome, prot, fat, carb, cal, 1.0);
                    // TODO poderiamos armazenar esse ingrediente numa lista estática, por exemplo,
                    // pra poder ser usado em novas receitas pelo usuário
                    receita.adicionarIngrediente(ingrediente, porcao);
                }
                listaReceitas.add(receita);
            }

        } catch (IOException e) {
            // Como deu erro e não temos como saber o estado da lista de receitas, limpamos
            // ela
            listaReceitas.clear();
            return false;
        } catch (CloneNotSupportedException e) {
            listaReceitas.clear();
            return false;
        }
        return true;
    }

    public boolean importarAlimentos(ArrayList<Alimento> listaAlimentos) {
        return true;
    }

    public boolean estaAtualizado() {
        return true;
    }

}
