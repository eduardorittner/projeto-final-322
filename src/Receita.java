import java.util.*;


public class Receita extends Alimento {

    private ArrayList<Ingrediente> listaIngredientes;
    private double porcao;

    // Constructor
    ArrayList<Ingrediente> aux = new ArrayList<Ingrediente>();

    // Os macros da receita estão relacionados com o peso, logo
    // Seria cal/porção, não por 1g

    public Receita(String nome, double prot, double fat, double carb, double cal, double porcao) {
        super(nome, prot, fat, carb, cal, porcao);
        this.porcao = porcao;
        this.listaIngredientes = aux;
    }

    // Getter e Setter

    public ArrayList<Ingrediente> getListaIngredientes() {
        return listaIngredientes;
    }

    public void setListaIngredientes(ArrayList<Ingrediente> listaIngredientes) {
        this.listaIngredientes = listaIngredientes;
    }

    public double getPorcao() {
        return porcao;
    }

    public void setPorcao(double porcao) {
        this.porcao = porcao;
    }

    @Override
    public String toString() {
        return super.getNome() + " (porção de " + porcao + " g)\n" + super.getMacros();
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

        for (Ingrediente i:listaIngredientes) {
            peso += i.getPorcao();
            aux = Macros.macrosPorPorcao(i.getMacros(), i.getPorcao());
            novo = Macros.somaMacros(aux, novo);
        }
        this.setMacros(novo);       // Atualiza os macros e o peso da receita
        this.porcao = peso;
        return true;
    }

    public boolean adicionarIngrediente(Ingrediente ingrediente, double peso) throws CloneNotSupportedException {
        Ingrediente novo = ingrediente.clone(); // crio uma cópia do ingrediente para mudar sua porção 
        novo.setPorcao(peso);                   // de acordo com a receita                 
        listaIngredientes.add(novo);
        calcularMacros();                       // Atualiza os macros dessa Receita
        return true;
    }


    // Métodos auxiliares

    public void encontrarAlimento() {
        // TODO
    }

    public void imprimirAlimentos() {
        System.out.println("Ingredientes da receita " + super.getNome());
        int i = 0;
        for (Ingrediente en:listaIngredientes) {
            System.out.println(i + ") " + en.getNome() + "(" + en.getPorcao() + "g)");
            i++;
        }
    }

}