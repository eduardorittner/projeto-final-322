import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class TelaLogin extends JFrame {
    private JTextField campoLogin;
    private JPasswordField campoSenha;

    public TelaLogin(Login login) {
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
                    try {
                        BufferedReader leitor = new BufferedReader(new FileReader(usuario + ".csv"));
                        String linhaw = leitor.readLine();
                        String[] linha = linhaw.split(",");
                        if (linha[0].equals(usuario)) {
                            Usuario u = new Usuario(linha[0], linha[1], linha[2], linha[3], linha[4], linha[5], linha[6]);
                            u.setCaminhoFoto(linha[7]);
                            abrirPrincipal(u);
                            leitor.close();
                        }
                        leitor.close();
                    } catch (IOException ex) {
                    }
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

    public void abrirPrincipal(Usuario u) {
        TelaPrincipal principal = new TelaPrincipal(u);
        principal.setVisible(true);
    }
    public void abrirCadastro (Login login, TelaLogin telaLogin) {
        TelaCadastro cadastro = new TelaCadastro(login, telaLogin);
        cadastro.setVisible(true);
    }
}
