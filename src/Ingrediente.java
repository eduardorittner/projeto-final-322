//import java.util.*;


public class Ingrediente extends Alimento implements Cloneable{

    private double porcao; // a porção será usada na receita e na refeição

    // Seria o tamanho de uma porção "normal" em gramas
    // Até onde pensei o constructor vai ser o mesmo, assim como as variáveis de class
    // Deixei a variável porção para alterar quando colocar dentro de uma receita.
    // A princípio não vai alterar os macros, esses continuam sendo referentes a 1g do alimento

    // Constructor

    public Ingrediente(String nome, double prot, double fat, double carb, double cal, double porcao) {
        super(nome, prot, fat, carb, cal, porcao);
        this.porcao = porcao;
    }

    // Getters e setters

    public double getPorcao() {
        return porcao;
    }

    public void setPorcao(double porcao) {
        this.porcao = porcao;
    }

    @Override
    public String toString() {
        return super.getNome() + " - Porção de " + porcao + "g\n" + super.getMacros();
    }

    @Override
    public Ingrediente clone() throws CloneNotSupportedException {
        return (Ingrediente) super.clone();
    }

    // Métodos 
    
    public Macros CalcularMacrosPorcao() {
        Macros novo = Macros.macrosPorPorcao(this.getMacros(), porcao);
        return novo;
    }   
}