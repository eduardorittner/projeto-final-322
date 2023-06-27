import java.io.File;
import java.util.ArrayList;

public interface ExpoImpo {

    abstract public boolean setArquivo(String novoArquivo);

    public File getArquivo();

    abstract public boolean exportar(ArrayList<?> listaObjetos);

    abstract public boolean importar(ArrayList<?> listaObjetos);
}
