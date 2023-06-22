import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaLogin extends JFrame {
    private JTextField campoLogin;
    private JPasswordField campoSenha;

    public TelaLogin(){
        setTitle("Tela de Login");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        JPanel painelPrincipal = new JPanel();
        painelPrincipal.setLayout(new BoxLayout(painelPrincipal, BoxLayout.Y_AXIS));
        JLabel labelUsuario = new JLabel("Usuário:");
        campoLogin = new JTextField(10);
        JLabel labelSenha = new JLabel("Senha:");
        campoSenha = new JPasswordField(10);
        JButton botaoLogin = new JButton("Login");
        botaoLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String usuario = campoLogin.getText();
                String senha = new String(campoSenha.getPassword());
                if (usuario.equals("admin") && senha.equals("admin")) {
                    JOptionPane.showMessageDialog(TelaLogin.this, "Login bem-sucedido!");
                    dispose();
                    abrirPrincipal();
                } else {
                    JOptionPane.showMessageDialog(TelaLogin.this, "Credenciais inválidas!");
                }
            }
        });
        painelPrincipal.add(labelUsuario);
        painelPrincipal.add(campoLogin);
        painelPrincipal.add(labelSenha);
        painelPrincipal.add(campoSenha);
        painelPrincipal.add(botaoLogin);
        add(painelPrincipal);
    }
    public void abrirPrincipal (){
        TelaPrincipal principal = new TelaPrincipal();
        principal.setVisible(true);
    }

}