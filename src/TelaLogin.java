import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaLogin extends JFrame {
    private JTextField campoLogin;
    private JPasswordField campoSenha;
    private Login login;

    public TelaLogin() {
        try {
            this.login = new Login("contas");
        } catch (Exception e) {
            System.out.println(e);
        }
        setTitle("Tela de Login");
        setSize(390, 844);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        Dimension inputSize = new Dimension(238,25);
        JPanel painelPrincipal = new JPanel();
        painelPrincipal.setLayout(new BoxLayout(painelPrincipal, BoxLayout.Y_AXIS));
        painelPrincipal.add(Box.createVerticalGlue());
        JLabel labelUsuario = new JLabel("Usuário:");
        labelUsuario.setAlignmentX(Component.CENTER_ALIGNMENT);
        campoLogin = new JTextField(20);
        JPanel log = new JPanel();
        log.add(campoLogin);
        log.setSize(inputSize);
        JLabel labelSenha = new JLabel("Senha:");
        labelSenha.setAlignmentX(Component.CENTER_ALIGNMENT);
        campoSenha = new JPasswordField(20);
        JPanel sen = new JPanel();
        sen.add(campoSenha);
        sen.setSize(inputSize);
        JButton botaoLogin = new JButton("Login");
        botaoLogin.setAlignmentX(Component.CENTER_ALIGNMENT);
        botaoLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String usuario = campoLogin.getText();
                String senha = new String(campoSenha.getPassword());
                if (!login.usuarioExiste(usuario)) {
                    JOptionPane.showMessageDialog(TelaLogin.this, "Usuário não existe!");
                } else if (!login.login(usuario, senha)) {
                    JOptionPane.showMessageDialog(TelaLogin.this, "Credenciais inválidas!");
                } else {
                    JOptionPane.showMessageDialog(TelaLogin.this, "Login bem-sucedido!");
                    dispose();
                    abrirPrincipal();
                }
            }
        });
        JLabel labelCadastro = new JLabel("Novo por aqui?"); 
        JButton botaoCadastrar = new JButton("Cadastrar");
        botaoCadastrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TelaLogin.this.setVisible(false);
                abrirCadastro(login, TelaLogin.this);
            }
        });
        JPanel cadastro = new JPanel();
        cadastro.add(labelCadastro);
        cadastro.add(botaoCadastrar);
        painelPrincipal.add(labelUsuario);
        painelPrincipal.add(log);
        painelPrincipal.add(labelSenha);
        painelPrincipal.add(sen);
        painelPrincipal.add(botaoLogin);
        painelPrincipal.add(cadastro);
        painelPrincipal.add(Box.createVerticalGlue());
        add(painelPrincipal);
    }

    public void abrirPrincipal() {
        TelaPrincipal principal = new TelaPrincipal();
        principal.setVisible(true);
    }
    public void abrirCadastro (Login login, TelaLogin telaLogin) {
        TelaCadastro cadastro = new TelaCadastro(login, telaLogin);
        cadastro.setVisible(true);
    }
}
