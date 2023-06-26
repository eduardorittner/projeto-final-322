import java.awt.*;

import javax.swing.*;

public class Item extends JPanel{
    private Refeicao ref;
    public Item(Refeicao ref) {
        this.ref = ref;
        setPreferredSize(new Dimension(290, 66));
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setLayout(new FlowLayout(FlowLayout.LEFT,10,0));
        JLabel nome = new JLabel(ref.getNome());
        JLabel data = new JLabel(ref.getData().toString());
        JLabel macros = new JLabel(ref.getMacros().toString());
        JLabel peso = new JLabel(Double.toString(ref.getPeso()));
        JLabel alimentos = new JLabel(ref.getAlimentos().toString());
        add(nome);
        add(data);
        add(macros);
        add(peso);
        add(alimentos);
    }
    
}
