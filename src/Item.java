import java.awt.*;

import javax.swing.*;

public class Item extends JPanel{

    public Item(String nome1,double prots1,double gords1,double carbs1,double cal1,double  peso1) {
        JPanel painelPrincipal = new JPanel();
        setPreferredSize(new Dimension(290, 66));
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        painelPrincipal.setLayout(new FlowLayout(FlowLayout.LEFT,10,0));
        JLabel nome = new JLabel(nome1);
        //JLabel data = new JLabel(ingrediente.getData().toString());
        JLabel prot = new JLabel(String.format("%.2f", prots1));
        JLabel gord = new JLabel(String.format("%.2f", gords1));
        JLabel carb = new JLabel(String.format("%.2f", carbs1));
        JLabel peso = new JLabel(String.format("%.2f", peso1));
        painelPrincipal.add(nome);
        painelPrincipal.add(prot);
        painelPrincipal.add(gord);
        painelPrincipal.add(carb);
        painelPrincipal.add(peso);
        add(painelPrincipal);
    }
}
