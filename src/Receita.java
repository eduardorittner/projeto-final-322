import java.util.*;

public class Receita extends Alimento {

    private ArrayList<Ingrediente> listaIngredientes;

    // Constructor
    ArrayList<Ingrediente> aux = new ArrayList<Ingrediente>();

    // Os macros da receita estão relacionados com o peso, logo
    // Seria cal/porção, não por 1g

    public Receita(String nome, double prot, double fat, double carb, double cal, double porcao) {
        super(nome, prot, fat, carb, cal, porcao);
        this.listaIngredientes = aux;
    }

    // Getter e Setter

    public ArrayList<Ingrediente> getListaIngredientes() {
        return listaIngredientes;
    }

    public void setListaIngredientes(ArrayList<Ingrediente> ßßlistaIngredientes) {
        this.listaIngredientes = listaIngredientes;
    }

    // Métodos


    public static Receita novaReceita(String nome) {
        Receita novo = new Receita(nome, 0.0, 0.0, 0.0, 0.0, 1.0);
        return novo;
    }

    @Override
    public boolean calcularMacros() { // Atualiza os macros da receita com os ingredientes da lista
        Macros novo = new Macros(0.0, 0.0, 0.0, 0.0);
        Macros aux = new Macros(0.0, 0.0, 0.0, 0.0);
        double peso = 0;
        super.setMacros(Macros.macrosPorPorcao(super.getMacros(), 0)); // Zera a contagem atual

        for (Ingrediente i : listaIngredientes) {

            peso += i.getPorcao();
            aux = Macros.macrosPorPorcao(i.getMacros(), i.getPorcao());
            novo = Macros.somaMacros(aux, novo);
        }
        this.setMacros(novo); // Atualiza os macros e o peso da receita

        super.setPorcao(peso);
        return true;
    }

    public boolean adicionarIngrediente(Ingrediente ingrediente, double peso) throws CloneNotSupportedException {
        Ingrediente novo = ingrediente.clone(); // crio uma cópia do ingrediente para mudar sua porção
        novo.setPorcao(peso); // de acordo com a receita
        listaIngredientes.add(novo);
        calcularMacros(); // Atualiza os macros dessa Receita
        return true;
    }

    public boolean adicionarIngrediente(Ingrediente ingrediente) throws CloneNotSupportedException {
        // Essa função só é chamada quando o ingrediente é importado do csv, já que ele
        // vem com o peso correto.
        Ingrediente novo = ingrediente.clone(); // crio uma cópia do ingrediente para mudar sua porção
        listaIngredientes.add(ingrediente);
        calcularMacros(); // Atualiza os macros dessa Receita
        return true;
    }

    // Métodos auxiliares

    public void imprimirAlimentos() {
        System.out.println("Ingredientes da receita " + super.getNome());
        int i = 0;
        for (Ingrediente en : listaIngredientes) {

            System.out.println(i + ") " + en.getNome() + "(" + en.getPorcao() + "g)");
            i++;
        }
    }

    public String listaAlimentos() {
        String string = "";
        int i = 1;
        for (Ingrediente en : listaIngredientes) {

            string += i + ") " + en.getNome() + " (" + en.getPorcao() + "g)\n";
            i++;
        }
        return string;
    }

    /**
     * @return the aux
     */
    public ArrayList<Ingrediente> getAux() {
        return aux;
    }

    /**
     * @param aux the aux to set
     */
    public void setAux(ArrayList<Ingrediente> aux) {
        this.aux = aux;
    }

}

