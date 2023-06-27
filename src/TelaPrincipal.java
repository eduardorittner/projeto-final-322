import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TelaPrincipal extends JFrame {
    private Usuario usuario;

    public TelaPrincipal(Usuario u){
        this.usuario = u;
        setTitle("Tela Principal");
        setSize(390, 844);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        JPanel painelPrincipal = new JPanel();
        CardLayout cardLayout = new CardLayout();
        painelPrincipal.setLayout(cardLayout);
        TelaUsuario telaUsuario = new TelaUsuario(u);
        TelaHistorico telaHistorico = new TelaHistorico(u);
        painelPrincipal.add(telaUsuario, "Tela Usuario");
        painelPrincipal.add(telaHistorico, "Tela Historico");
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
        getContentPane().add(painelPrincipal);
        pack();
        setLocationRelativeTo(null);

    }

    /**
     * @return the usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
