
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ListaRef extends JPanel {
    private DefaultListModel<Refeicao> modelo;
    private JList<Refeicao> lista;

    public ListaRef() {
        modelo = new DefaultListModel<>();
        lista = new JList<>(modelo);
        setLayout(new BoxLayout(ListaRef.this, BoxLayout.Y_AXIS));
        JButton add = new JButton("Add");
        add.addActionListener((ActionListener) new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame input = new JFrame();
                // Jlabel 
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

    public void setLista (DefaultListModel<Refeicao> modelo){
        this.modelo = modelo;
    }
    public DefaultListModel<Refeicao> getListaModel() {
        return this.modelo;
    }

    private void addRefeicao () {
        
    }
    private void removeRefeicao (Refeicao refeicao) {
        int indice = lista.getSelectedIndex();
        if (indice != -1) {
            lista.remove(indice);
        }
    }
}
