import java.io.File;
import java.util.ArrayList;

public interface ExpoImpo {

    abstract public boolean setArquivo(String novoArquivo);

    public File getArquivo();

    abstract public boolean exportarIngredientes(ArrayList<Ingrediente> listaIngredientes);

    abstract public boolean exportarReceitas();

    abstract public boolean exportarAlimentos(ArrayList<Alimento> listaAlimentos);

    abstract public boolean importarIngredientes(ArrayList<Ingrediente> listaIngredientes);

    abstract public boolean importarReceitas();

    abstract public boolean importarAlimentos(ArrayList<Alimento> listaAlimentos);

    abstract boolean estaAtualizado();

}
