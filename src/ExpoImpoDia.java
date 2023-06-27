import java.io.*;
import java.util.ArrayList;

public class ExpoImpoDia implements ExpoImpo {
    private File arquivo;

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

        return false;

    }
}
