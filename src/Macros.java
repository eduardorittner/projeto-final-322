

public class Macros {
    
    /* Estrutura que armazena as constantes macros de um alimento
    A ideia dessa classe é simplificar o código e o retorno de algumas funções
    */

    private double prot;
    private double fat;
    private double carb;
    private double cal;

    // Constructor

    public Macros(double prot, double fat, double carb, double cal) {
        this.prot = prot;
        this.fat = fat;
        this.carb = carb;
        this.cal = cal;
    }

    // Getters e setters

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
        return "Macros - Calorias: " + cal + " kCal; Prot: " + prot + "g; Carb: " + carb + "g; Fat: " + fat + "g;\n";
    }
    
    public static Macros macrosPorPorcao(Macros macros, double porcao) {

        /* Cria novos macros onde seus valores são ajustados a uma porção (unidade grama) 
        A unidade de "porcao" deve ser grama */

        double prot = macros.getProt() * porcao;
        double fat = macros.getFat() * porcao;
        double carb = macros.getCarb() * porcao;
        double cal = macros.getCal() * porcao;
        Macros novo = new Macros(prot, fat, carb, cal);

        return novo;
    }

    public static Macros somaMacros(Macros macro1, Macros macro2) {
        double prot = macro1.getProt() + macro2.getProt();
        double fat = macro1.getFat() + macro2.getFat();
        double carb = macro1.getCarb() + macro2.getCarb();
        double cal = macro1.getCal() + macro2.getCal();
        Macros novo = new Macros(prot, fat, carb, cal);

        return novo;
    }

}
