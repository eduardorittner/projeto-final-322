import java.util.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;


public class Refeicao {

    private String nome;
    private Date data;      // TODO mudar para um horário
    private Macros macros;
    private ArrayList<Alimento> alimentos;
    private double peso;

    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyy");

    // Constructor

    public Refeicao(String nome, Date data, Macros macros, ArrayList<Alimento> alimentos, double peso) {
        this.nome = nome; // TODO validar
        this.data = data; 
        this.macros = macros;
        this.alimentos = alimentos;
        this.peso = peso;
    }

    // Getter e Setters

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Macros getMacros() {
        return macros;
    }

    public void setMacros(Macros macros) {
        this.macros = macros;
    }

    public ArrayList<Alimento> getAlimentos() {
        return alimentos;
    }

    public void setAlimentos(ArrayList<Alimento> alimentos) {
        this.alimentos = alimentos;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        return nome + " - Peso: " + peso + "g\n" + macros + listaAlimentos();
    }

    // Métodos

    public static Refeicao novaRefeicao(String nome) {
        ArrayList<Alimento> novo = new ArrayList<Alimento>();
        Macros macros = new Macros(0, 0, 0, 0);
        LocalDate aux = LocalDate.now();    // Depois a gente muda isso, só coloquei pra ter uma data qualquer
        Date hoje = Date.from(aux.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Refeicao nova = new Refeicao(nome, hoje, macros, novo, 0);
        return nova;
    }
    
    public boolean calcularMacros() { // Atualiza os macros da receita com os ingredientes da lista
        Macros novo = new Macros(0.0, 0.0, 0.0, 0.0);
        Macros aux = new Macros(0.0, 0.0, 0.0, 0.0);
        double peso = 0;
        macros = Macros.macrosPorPorcao(macros, 0); // Zera a contagem atual

        for (Alimento al: alimentos) {
            peso += al.getPorcao();
            aux = Macros.macrosPorPorcao(al.getMacros(), al.getPorcao());
            novo = Macros.somaMacros(aux, novo);
        }
        this.macros = novo;       // Atualiza os macros e o peso da receita
        this.peso = peso;
        return true;
    }

    public String listaAlimentos() {
        String string = "";     
        int i = 1;
        for (Alimento al:alimentos) {
            string += i + ") " + al.getNome() + " (" + al.getPorcao() + "g)\n";
            i++;
        }
        return string;
    }

    public boolean adicionarAlimento(Alimento alimento, double peso) throws CloneNotSupportedException {
        Alimento novo = alimento.clone();
        novo.setPorcao(peso);
        alimentos.add(novo);
        calcularMacros();
        return true;
    }

}