import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

// TODO
// Encontrar um jeito de fechar o escritor e leitor quando o objeto for destruído
// Provavelmente com algum tipo de interface

public class ExpoImpoCsv implements ExpoImpo {

    private File arquivo;
    private FileWriter escritor;
    private BufferedReader leitor;

    public ExpoImpoCsv(String arquivoSaida) throws Exception {
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

    public boolean exportarIngredientes(ArrayList<Ingrediente> listaIngredientes) {
        // nome, porcao, prot, fat, carb, cal
        String colunas = "Nome,Porção,Proteínas,Gorduras,Carboidratos,Calorias";
        try {
            escritor.write(colunas);
            for (Ingrediente ingrediente : listaIngredientes) {
                escritor.append(ingrediente.toString());
            }
            escritor.flush();

        } catch (IOException e) {
            return false;
        }
        return true;
    }

    public boolean exportarReceitas() {
        return true;
    }

    public boolean exportarAlimentos(ArrayList<Alimento> listaAlimentos) {
        return true;
    }

    public boolean importarIngredientes(ArrayList<Ingrediente> listaIngredientes) {
        String line;
        try {
            // Le a primeira linha dos identificadores
            line = leitor.readLine();
            while ((line = leitor.readLine()) != null) {
                String[] valores = line.split(",");
                String nome = valores[0];
                int porcao = Integer.parseInt(valores[1]);
                double prot = Double.parseDouble(valores[2]);
                double fat = Double.parseDouble(valores[3]);
                double carb = Double.parseDouble(valores[4]);
                double cal = Double.parseDouble(valores[5]);
                double peso = 1.0;
                listaIngredientes.add(new Ingrediente(nome, prot, fat, carb, cal, peso, porcao));
            }
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    public boolean importarReceitas() {
        return true;
    }

    public boolean importarAlimentos(ArrayList<Alimento> listaAlimentos) {
        return true;
    }

    public boolean estaAtualizado() {
        return true;
    }

}
