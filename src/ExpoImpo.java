import java.io.File;

public abstract class ExpoImpo {
    private File arquivoSaida;

    public ExpoImpo(String arquivoSaida) throws Exception {
        this.arquivoSaida = new File(arquivoSaida);
        try {
            this.arquivoSaida.createNewFile();
        } catch (Exception e) {
            throw e;
        }
    }

    public boolean setArquivoSaida(String arquivoSaida) {
        this.arquivoSaida = new File(arquivoSaida);
        return true;
    }

    public File getArquivoSaida() {
        return arquivoSaida;
    }

    abstract public boolean exportarIngredientes();

    abstract public boolean exportarReceitas();

    abstract public boolean exportarAlimentos();

    abstract public boolean importarIngredientes();

    abstract public boolean importarReceitas();

    abstract public boolean importarAlimentos();

    abstract boolean estaAtualizado();

}
