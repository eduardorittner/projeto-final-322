import java.util.*;

public abstract class Alimento {

    public final int id; // id final para que possamos referenciar o alimento em uma lista
    public String nome;
    public double prot;
    public double fat;
    public double carb;
    public double cal;

    private static ArrayList<Integer> listaIds = new ArrayList<Integer>();
    Random rand = new Random();

    /*
     * O alimento não tem um peso específico pois todos eles serão registrados
     * considerando 1g, assim seus macros sempre estarão relacionados a 1g do
     * alimento.
     * No construtor coloquei a variável peso para o caso de a entrada não ser 1g
     */

    // Constructor

    public Alimento(String nome, double prot, double fat, double carb, double cal, double peso) {
        this.nome = nome;
        if (peso != 1.0) {
            prot = prot / peso;
            fat = fat / peso;
            carb = carb / peso;
            cal = cal / peso;
        }
        this.nome = nome; // TODO validação do nome (somente letras)
        this.fat = fat;
        this.prot = prot;
        this.carb = carb;
        this.cal = cal;
        int temp = rand.nextInt(1000000); // Gerador de id único por alimento
        while (listaIds.contains(temp)) {
            temp = rand.nextInt(1000000);
        }
        this.id = temp;
    }

    // Getters e setters

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getProt() {
        return prot;
    }

    public void setProt(double prot) {
        this.prot = prot;
    }

    public double getFat() {
        return fat;
    }

    public void setFat(double fat) {
        this.fat = fat;
    }

    public double getCarb() {
        return carb;
    }

    public void setCarb(double carb) {
        this.carb = carb;
    }

    public double getCal() {
        return cal;
    }

    public void setCal(double cal) {
        this.cal = cal;
    }

    @Override
    public String toString() {
        // Nesse formato pra exportar pra csv válido diretamente
        return "\n" + nome + "," + id + "," + prot + "," + fat + "," + carb + "," + cal;
    }

    void calcularMacros() {
    };

}
