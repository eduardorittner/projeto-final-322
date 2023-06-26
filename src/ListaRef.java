
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.*;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ListaRef extends JPanel {
    private DefaultListModel<Ingrediente> modelo;
    private JList<Ingrediente> lista;
    public ListaRef() {
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
                // removeRefeicao();
            }
        });
        add(new JScrollPane(lista), BorderLayout.CENTER);
        JPanel botoes = new JPanel();
        botoes.setLayout(new BoxLayout(botoes, BoxLayout.X_AXIS));
        botoes.add(add);
        botoes.add(remove);
        add(botoes);
    }

    public void setLista (DefaultListModel<Ingrediente> modelo){
        this.modelo = modelo;
    }
    public DefaultListModel<Ingrediente> getListaModel() {
        return this.modelo;
    }
}
