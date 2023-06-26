
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.*;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ListaRef extends JPanel {
    private DefaultListModel<Ingrediente> modelo;
    private JList<Ingrediente> lista;
    public ListaRef(TelaHistorico historico) {
        modelo = new DefaultListModel<>();
        lista = new JList<>(modelo);
        setLayout(new BoxLayout(ListaRef.this, BoxLayout.Y_AXIS));
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
                        historico.setProt(ListaRef.this.getProtTotais());
                        historico.setCarb(ListaRef.this.getCarbsTotais());
                        historico.setGor(ListaRef.this.getGordTotais());
                        historico.repaint()
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
                                historico.setProt(ListaRef.this.getProtTotais());
                                historico.setCarb(ListaRef.this.getCarbsTotais());
                                historico.setGor(ListaRef.this.getGordTotais());
                            }
                        }
                        if (!entrou){
                            JOptionPane.showMessageDialog(ListaRef.this, "Ingrediente não encontrado!");
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
