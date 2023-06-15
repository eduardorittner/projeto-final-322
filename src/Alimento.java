import java.util.*;


public abstract class Alimento {

    private final int id;        // id final para que possamos referenciar o alimento em uma lista
    private String nome;
    private Macros macros;

    private static ArrayList<Integer> listaIds = new ArrayList<Integer>();
    Random rand = new Random();

    /* O alimento não tem um peso específico pois todos eles serão registrados
    considerando 1g, assim seus macros sempre estarão relacionados a 1g do alimento.
    No construtor coloquei a variável peso para o caso de a entrada não ser 1g*/

    // Constructor 

    public Alimento(String nome, double prot, double fat, double carb, double cal, double porcao) {
        this.nome = nome;
        if (porcao == 0) {  // Evita divisão por zero
            System.out.println("Porção de 0g inválida.\nCorrigido para 1g");
            porcao = 1;
        }
        prot = prot/porcao;     // Normaliza as grandezas registradas para 1g do alimento
        fat = fat/porcao;
        carb = carb/porcao;
        cal = cal/porcao;
        
        this.nome = nome; // TODO validação do nome (somente letras)
        this.macros = new Macros(prot, fat, carb, cal);

        int temp = rand.nextInt(1000000);   // Gerador de id único por alimento
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

    public Macros getMacros() {
        return macros;
    }

    public void setMacros(Macros macros) {
        this.macros = macros;
    }

    @Override
    public String toString() {
        return nome + "\n" + macros;
    }

    // Métodos 

    public boolean calcularMacros() {
        return true;
    }

}   