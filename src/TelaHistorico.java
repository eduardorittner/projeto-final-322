import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class TelaHistorico extends JPanel{
    public TelaHistorico() {
        JPanel painelPrincipal = new JPanel();
        painelPrincipal.setLayout(new BoxLayout(painelPrincipal, BoxLayout.Y_AXIS));
        //Passar os macros como o formato de string (MUDAR COM .FORMAT OU .TOSTRING)
        JPanel macros = new JPanel();
        macros.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 0));
        //Painel de proteinas
        JPanel proteina = new JPanel();
        proteina.setLayout(new BoxLayout(proteina, BoxLayout.Y_AXIS));
        PainelCircular proteinas = new PainelCircular("100 g");
        JLabel pro = new JLabel("Proteínas");
        pro.setAlignmentX(Component.CENTER_ALIGNMENT);
        pro.setBorder(new EmptyBorder(0, 5, 0, 0));
        proteina.add(proteinas);
        proteina.add(pro);
        //Painel de carboidratos
        JPanel carboidratos = new JPanel();
        carboidratos.setLayout(new BoxLayout(carboidratos, BoxLayout.Y_AXIS));
        PainelCircular carbo = new PainelCircular("200 g");
        JLabel carb = new JLabel("Carboidratos");
        carb.setAlignmentX(Component.CENTER_ALIGNMENT);
        carb.setBorder(new EmptyBorder(0, 5, 0, 0));
        carboidratos.add(carbo);
        carboidratos.add(carb);
        //Painel de gorduras
        JPanel gordura = new JPanel();
        gordura.setLayout(new BoxLayout(gordura, BoxLayout.Y_AXIS));
        PainelCircular gorduras = new PainelCircular("300 g");
        JLabel gor = new JLabel("Gorduras");
        gor.setAlignmentX(Component.CENTER_ALIGNMENT);
        gor.setBorder(new EmptyBorder(0, 5, 0, 0));
        gordura.add(gorduras);
        gordura.add(gor);
        JPanel painelHistorico = new JPanel();
        painelHistorico.setLayout(new FlowLayout(FlowLayout.CENTER,0, 50));
        painelHistorico.setPreferredSize(new Dimension(290, 500));
        painelHistorico.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        //Painel de calorias
    

        // Criação do painel de histórico
        ListaRef listaRefeicoes = new ListaRef();
        //Adicionando na Panel geral dos macros
        macros.add(proteina);
        macros.add(carboidratos);
        macros.add(gordura);
        painelPrincipal.add(macros);
        painelPrincipal.add(listaRefeicoes);
        painelPrincipal.add(painelHistorico);
        add(painelPrincipal);
    }
}
