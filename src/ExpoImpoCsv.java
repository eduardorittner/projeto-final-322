import java.io.PrintWriter;

public class ExpoImpoCsv extends ExpoImpo {

    private PrintWriter escritor;

    public ExpoImpoCsv(String arquivoSaida) throws Exception {
        super(arquivoSaida);
        // Precisa do try catch pq ele pode não achar o arquivo
        try {
            escritor = new PrintWriter(super.getArquivoSaida());
        } catch (Exception e) {
            throw e;
        }
    }

    public boolean exportarIngredientes() {
        return true;
    }

    public boolean exportarReceitas() {
        return true;
    }

    public boolean exportarAlimentos() {
        return true;
    }

    public boolean importarIngredientes() {
        return true;
    }

    public boolean importarReceitas() {
        return true;
    }

    public boolean importarAlimentos() {
        return true;
    }

    boolean estaAtualizado() {
        return true;
    }

}
