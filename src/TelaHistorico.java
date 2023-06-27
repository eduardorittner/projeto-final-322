import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class TelaHistorico extends JPanel{
    private String prot = "0";
    private String carb = "0";
    private String gor= "0";
    private DefaultListModel<Ingrediente> modelo;
    private JList<Ingrediente> lista;

    public TelaHistorico() {
        JPanel painelPrincipal = new JPanel();
        painelPrincipal.setLayout(new BoxLayout(painelPrincipal, BoxLayout.Y_AXIS));
        //Passar os macros como o formato de string (MUDAR COM .FORMAT OU .TOSTRING)
        //ListaRef listaRefeicoes = new ListaRef(TelaHistorico.this);
        JPanel macros = new JPanel();
        macros.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 0));
        //Painel de proteinas
        JPanel proteina = new JPanel();
        proteina.setLayout(new BoxLayout(proteina, BoxLayout.Y_AXIS));
        //this.prot = getProtTotais();
        PainelCircular proteinas = new PainelCircular(prot);
        JLabel pro = new JLabel("Proteínas");
        pro.setAlignmentX(Component.CENTER_ALIGNMENT);
        pro.setBorder(new EmptyBorder(0, 5, 0, 0));
        proteina.add(proteinas);
        proteina.add(pro);
        //Painel de carboidratos
        JPanel carboidratos = new JPanel();
        carboidratos.setLayout(new BoxLayout(carboidratos, BoxLayout.Y_AXIS));
        //this.carb = getCarbsTotais();
        PainelCircular carbo = new PainelCircular(carb);
        JLabel carb = new JLabel("Carboidratos");
        carb.setAlignmentX(Component.CENTER_ALIGNMENT);
        carb.setBorder(new EmptyBorder(0, 5, 0, 0));
        carboidratos.add(carbo);
        carboidratos.add(carb);
        //Painel de gorduras
        JPanel gordura = new JPanel();
        gordura.setLayout(new BoxLayout(gordura, BoxLayout.Y_AXIS));
        //this.gor = getGordTotais();
        PainelCircular gorduras = new PainelCircular(gor);
        JLabel gor = new JLabel("Gorduras");
        gor.setAlignmentX(Component.CENTER_ALIGNMENT);
        gor.setBorder(new EmptyBorder(0, 5, 0, 0));
        gordura.add(gorduras);
        gordura.add(gor);
        JPanel painelHistorico = new JPanel();
        painelHistorico.setLayout(new FlowLayout(FlowLayout.CENTER,0, 50));
        painelHistorico.setPreferredSize(new Dimension(290, 500));
        painelHistorico.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        //Adicionando na Panel geral dos macros
        macros.add(proteina);
        macros.add(carboidratos);
        macros.add(gordura);
        painelPrincipal.add(macros);
        //painelPrincipal.add(listaRefeicoes);
        add(painelPrincipal);
        modelo = new DefaultListModel<>();
        lista = new JList<>(modelo);
        setLayout(new BoxLayout(TelaHistorico.this, BoxLayout.Y_AXIS));
        JButton add = new JButton("Add");
        add.addActionListener((ActionListener) new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame input = new JFrame();
                input.setSize(390, 844);
                JPanel painelPrincipal = new JPanel();
                painelPrincipal.setLayout(new BoxLayout(painelPrincipal, BoxLayout.Y_AXIS));
                JLabel nome = new JLabel("Nome");
                JTextField nomeInput = new JTextField(20);
                JLabel peso = new JLabel("Peso");
                JTextField pesoInput = new JTextField(20);
                JLabel carbs = new JLabel("Carboidratos");
                JTextField carbInput = new JTextField(20);
                JLabel prots = new JLabel("Proteínas");
                JTextField protsInput = new JTextField(20);
                JLabel gord = new JLabel("Gorduras");
                JTextField gordInput = new JTextField(20);
                JLabel cal = new JLabel("Calorias");
                JTextField calInput = new JTextField(20);
                painelPrincipal.add(nome);
                painelPrincipal.add(nomeInput);
                painelPrincipal.add(peso);
                painelPrincipal.add(pesoInput);
                painelPrincipal.add(carbs);
                painelPrincipal.add(carbInput);
                painelPrincipal.add(prots);
                painelPrincipal.add(protsInput);
                painelPrincipal.add(gord);
                painelPrincipal.add(gordInput);
                painelPrincipal.add(cal);
                painelPrincipal.add(calInput);
                painelPrincipal.setVisible(true);
                JButton ok = new JButton("OK");
                ok.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        String nome1 = nomeInput.getText();
                        double peso1 = Double.parseDouble(pesoInput.getText());
                        double carbs1 = Double.parseDouble(carbInput.getText());
                        double prots1 = Double.parseDouble(protsInput.getText());
                        double gords1 = Double.parseDouble(gordInput.getText());
                        double cal1 = Double.parseDouble(calInput.getText());
                        Ingrediente alimento = new Ingrediente(nome1, prots1, gords1, carbs1,cal1, peso1);
                        modelo.addElement(alimento);
                        input.dispose();
                        alimento.calcularMacros();
                        proteinas.setData(TelaHistorico.this.getProtTotais());
                        carbo.setData(TelaHistorico.this.getCarbsTotais());
                        gorduras.setData(TelaHistorico.this.getGordTotais());
                        proteinas.repaint();
                        carbo.repaint();
                        gorduras.repaint();
                    }
                });
                painelPrincipal.add(ok);
                input.add(painelPrincipal);
                input.setVisible(true);
            }   
        });
        JButton remove = new JButton("Remove");
        remove.addActionListener((ActionListener) new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame input = new JFrame();
                input.setSize(300, 300);
                JPanel painelPrincipal = new JPanel();
                painelPrincipal.setLayout(new BoxLayout(painelPrincipal, BoxLayout.Y_AXIS));
                JLabel nome = new JLabel("Insira o nome do ingrediente a ser removido: ");
                JTextField nomeInput = new JTextField(20);
                JButton ok = new JButton("OK");
                ok.addActionListener(new ActionListener() {
                    boolean entrou = false;
                    public void actionPerformed(ActionEvent e) {
                        for (int i = 0; i < modelo.size(); i++){
                            if (modelo.get(i).getNome().equals(nomeInput.getText())){
                                modelo.removeElement(modelo.get(i));
                                entrou = true;
                                input.dispose();
                                modelo.get(i).calcularMacros();
                                proteinas.setData(TelaHistorico.this.getProtTotais());
                                carbo.setData(TelaHistorico.this.getCarbsTotais());
                                gorduras.setData(TelaHistorico.this.getGordTotais());
                                proteinas.repaint();
                                carbo.repaint();
                                gorduras.repaint();
                                }
                        }
                        if (!entrou){
                            JOptionPane.showMessageDialog(TelaHistorico.this, "Ingrediente não encontrado!");
                        }
                    }
                });
                painelPrincipal.add(nome);
                painelPrincipal.add(nomeInput);
                painelPrincipal.add(ok);
                input.add(painelPrincipal);
                input.setVisible(true);
            }
        });
        add(new JScrollPane(lista), BorderLayout.CENTER);
        JPanel botoes = new JPanel();
        botoes.setLayout(new BoxLayout(botoes, BoxLayout.X_AXIS));
        botoes.add(add);
        botoes.add(remove);
        add(botoes);

    }


    /**
     * @return the prot
     */
    public String getProt() {
        return prot;
    }


    /**
     * @param prot the prot to set
     */
    public void setProt(String prot) {
        this.prot = prot;
    }


    /**
     * @return the carb
     */
    public String getCarb() {
        return carb;
    }


    /**
     * @param carb the carb to set
     */
    public void setCarb(String carb) {
        this.carb = carb;
    }


    /**
     * @return the gor
     */
    public String getGor() {
        return gor;
    }


    /**
     * @param gor the gor to set
     */
    public void setGor(String gor) {
        this.gor = gor;
    }

    public String getProtTotais(){
        double total = 0.00;
        for (int i = 0; i < modelo.size(); i++){
            total += modelo.get(i).getMacros().getProt();
        }
        return String.format("%.2f", total);
    }
    public String getGordTotais(){
        double total = 0.00;
        for (int i = 0; i < modelo.size(); i++){
            total += modelo.get(i).getMacros().getFat();
        }
        return String.format("%.2f", total);
    }
    public String getCarbsTotais(){
        double total = 0.00;
        for (int i = 0; i < modelo.size(); i++){
            total += modelo.get(i).getMacros().getCarb();
        }
        return String.format("%.2f", total);
    }
    
}
