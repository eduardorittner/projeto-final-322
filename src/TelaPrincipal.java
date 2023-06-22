import java.awt.GridLayout;

import javax.swing.*;

public class TelaPrincipal extends JFrame {
    public TelaPrincipal(){
        setTitle("Tela Principal");
        setSize(1280, 720);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(FRAMEBITS, ERROR, ALLBITS, ABORT));
        JMenuBar menuBar = new JMenuBar();
        JMenu usuario = new JMenu("Usuário");
        JMenu historico = new JMenu("Histórico");
        menuBar.add(usuario);
        menuBar.add(historico);
        setJMenuBar(menuBar);
    }
}
