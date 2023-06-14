import java.util.*;


public class Receita extends Alimento {

    public ArrayList<Ingrediente> listaIngredientes;


    // Constructor
    ArrayList<Ingrediente> aux = new ArrayList<Ingrediente>();

    public Receita(String nome, double prot, double fat, double carb, double cal, double peso) {
        super(nome, prot, fat, carb, cal, peso);
        this.listaIngredientes = aux;
    }

    // Getter e Setter

    public ArrayList<Ingrediente> getListaIngredientes() {
        return listaIngredientes;
    }

    public void setListaIngredientes(ArrayList<Ingrediente> listaIngredientes) {
        this.listaIngredientes = listaIngredientes;
    }

    

}