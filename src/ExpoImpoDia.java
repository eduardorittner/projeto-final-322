import java.io.*;
import java.util.ArrayList;

public class ExpoImpoDia implements ExpoImpo {
    private File arquivo;
    private File arquivoEntrada;

    public ExpoImpoDia(String dia, String nomeUsuario) {
        this.arquivo = new File("dias/" + nomeUsuario + dia + ".csv");
        this.arquivoEntrada = new File("dados/" +nomeUsuario + ".csv");
    }

    public boolean setArquivo(String novoArquivo) {
        try {
            File arquivo = new File(novoArquivo);
            this.arquivo = arquivo;
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public File getArquivo() {
        return this.arquivo;
    }

    public boolean importar(ArrayList<?> listaObjetos) {
        return false;
    }

    public boolean exportar(ArrayList<?> listaObjetos) {
        try {
            BufferedReader leitor = new BufferedReader(new FileReader(arquivoEntrada));
            BufferedWriter escritor = new BufferedWriter(new FileWriter(arquivo, true));
            String linha = leitor.readLine();
            while ((linha = leitor.readLine()) != null) {
                escritor.write(linha);
            }
            leitor.close();
            escritor.close();
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

    /**
     * @param arquivo the arquivo to set
     */
    public void setArquivo(File arquivo) {
        this.arquivo = arquivo;
    }

    /**
     * @return the arquivoEntrada
     */
    public File getArquivoEntrada() {
        return arquivoEntrada;
    }

    /**
     * @param arquivoEntrada the arquivoEntrada to set
     */
    public void setArquivoEntrada(File arquivoEntrada) {
        this.arquivoEntrada = arquivoEntrada;
    }
}
