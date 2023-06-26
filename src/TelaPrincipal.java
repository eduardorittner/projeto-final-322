import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.border.EmptyBorder;

public class TelaPrincipal extends JFrame {
    public TelaPrincipal(){
        setTitle("Tela Principal");
        setSize(390, 844);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        // setLayout(new GridLayout(FRAMEBITS, ERROR, ALLBITS, ABORT));
        JPanel painelPrincipal = new JPanel();
        CardLayout cardLayout = new CardLayout();
        painelPrincipal.setLayout(cardLayout);
        TelaUsuario telaUsuario = new TelaUsuario();
        TelaHistorico telaHistorico = new TelaHistorico();
        painelPrincipal.add(telaUsuario, "Tela Usuario");
        painelPrincipal.add(telaHistorico, "Tela Historico");
        // painelPrincipal.add(Box.createVerticalGlue());
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        JMenuItem item1 = new JMenuItem("Tela Usuario");
        JMenuItem item2 = new JMenuItem("Tela Historico");
        menu.add(item1);
        menu.add(item2);
        menuBar.add(menu);
        item1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(painelPrincipal, "Tela Usuario");
            }
        });

        item2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(painelPrincipal, "Tela Historico");
            }
        });
        setJMenuBar(menuBar);
        // //Passar os macros como o formato de string (MUDAR COM .FORMAT OU .TOSTRING)
        // JPanel macros = new JPanel();
        // macros.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 0));
        // //Painel de proteinas
        // JPanel proteina = new JPanel();
        // proteina.setLayout(new BoxLayout(proteina, BoxLayout.Y_AXIS));
        // PainelCircular proteinas = new PainelCircular("100 g");
        // JLabel pro = new JLabel("Proteínas");
        // pro.setAlignmentX(Component.CENTER_ALIGNMENT);
        // pro.setBorder(new EmptyBorder(0, 5, 0, 0));
        // proteina.add(proteinas);
        // proteina.add(pro);
        // //Painel de carboidratos
        // JPanel carboidratos = new JPanel();
        // carboidratos.setLayout(new BoxLayout(carboidratos, BoxLayout.Y_AXIS));
        // PainelCircular carbo = new PainelCircular("200 g");
        // JLabel carb = new JLabel("Carboidratos");
        // carb.setAlignmentX(Component.CENTER_ALIGNMENT);
        // carb.setBorder(new EmptyBorder(0, 5, 0, 0));
        // carboidratos.add(carbo);
        // carboidratos.add(carb);
        // //Painel de gorduras
        // JPanel gordura = new JPanel();
        // gordura.setLayout(new BoxLayout(gordura, BoxLayout.Y_AXIS));
        // PainelCircular gorduras = new PainelCircular("300 g");
        // JLabel gor = new JLabel("Gorduras");
        // gor.setAlignmentX(Component.CENTER_ALIGNMENT);
        // gor.setBorder(new EmptyBorder(0, 5, 0, 0));
        // gordura.add(gorduras);
        // gordura.add(gor);
        // JPanel painelHistorico = new JPanel();
        // painelHistorico.setLayout(new FlowLayout(FlowLayout.CENTER,0, 50));
        // painelHistorico.setPreferredSize(new Dimension(290, 500));
        // painelHistorico.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        // // Criação do painel de histórico
        // ListaRef listaRefeicoes = new ListaRef();
        // //Adicionando na Panel geral dos macros
        // macros.add(proteina);
        // macros.add(carboidratos);
        // macros.add(gordura);
        // painelPrincipal.add(macros);
        // painelPrincipal.add(listaRefeicoes);
        // painelPrincipal.add(painelHistorico);
        getContentPane().add(painelPrincipal);
        pack();
        setLocationRelativeTo(null);

    }
}
