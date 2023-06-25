import java.awt.*;

import javax.swing.*;


public class PainelCircular extends JPanel {
    private String data;

    public PainelCircular(String data){
        this.data = data;
        setPreferredSize(new Dimension(100, 100));
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);

        //Pega os valores de largura e altura do painel e seta a metade do menor deles como o raio
        int width = getWidth();
        int height = getHeight();
        int radius = Math.min(width, height) / 2;

        int x = (width - radius) / 2;
        int y = (height - radius) / 2;

        //Setou a cor do pincel como vermelho e pintuou o círculo com este pincel
        g.setColor(Color.RED);
        g.fillOval(x, y, radius, radius);

        //Setou o pincel como branco e pintou a informação (data) desse painel
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 16));
        FontMetrics fontMetrics = g.getFontMetrics();
        int textWidth = fontMetrics.stringWidth(data);
        int textHeight = fontMetrics.getAscent();
        int textX = x + (radius - textWidth) / 2;
        int textY = y + (radius + textHeight) / 2;

        g.drawString(data, textX, textY);
    }
}
