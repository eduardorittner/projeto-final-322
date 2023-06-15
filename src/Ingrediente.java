//import java.util.*;

public class Ingrediente extends Alimento {

    public int porcao; // Seria o tamanho de uma porção "normal" em gramas
    // Até onde pensei o constructor vai ser o mesmo, assim como as variáveis de
    // classe

    // Constructor

    public Ingrediente(String nome, double prot, double fat, double carb, double cal, double peso, int porcao) {
        super(nome, prot, fat, carb, cal, peso);
        this.porcao = porcao;
    }

    // Getter e Setter

    public int getPorcao() {
        return porcao;
    }

    public void setPorcao(int porcao) {
        this.porcao = porcao;
    }

    @Override
    public String toString() {
        return "\n" + nome + "," + porcao + "," + prot + "," + fat + "," + carb + "," + cal;
    }

    @Override
    public void calcularMacros() {

    }

}
