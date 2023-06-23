import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaCadastro extends JFrame {
    private JTextField campoLogin;
    private JPasswordField campoSenha;
    private JPasswordField campoSenhaConfirm;

    public TelaCadastro(){
        setTitle("Tela de Cadastro");
        setSize(390, 844);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        Dimension inputSize = new Dimension(238,25);
        JPanel painelPrincipal = new JPanel();
        painelPrincipal.setLayout(new BoxLayout(painelPrincipal, BoxLayout.Y_AXIS));
        painelPrincipal.add(Box.createVerticalGlue());
        JLabel labelUsuario = new JLabel("Insira um username:");
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
        JLabel labelSenhaConfirm = new JLabel("Confirmar Senha:");
        labelSenhaConfirm.setAlignmentX(Component.CENTER_ALIGNMENT);
        campoSenhaConfirm = new JPasswordField(20);
        JPanel senConfirm = new JPanel();
        senConfirm.add(campoSenhaConfirm);
        senConfirm.setSize(inputSize);
        JButton botaoCadastro = new JButton("Cadastre!");
        botaoCadastro.setAlignmentX(Component.CENTER_ALIGNMENT);
        botaoCadastro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String usuario = campoLogin.getText();
                String senha = new String(campoSenha.getPassword());
                if (usuario.equals("admin") && senha.equals("admin")) {
                    JOptionPane.showMessageDialog(TelaCadastro.this, "Login bem-sucedido!");
                    dispose();
                    abrirPrincipal();
                } else {
                    JOptionPane.showMessageDialog(TelaCadastro.this, "Credenciais inválidas!");
                }
            }
        });
        painelPrincipal.add(labelUsuario);
        painelPrincipal.add(log);
        painelPrincipal.add(labelSenha);
        painelPrincipal.add(sen);
        painelPrincipal.add(labelSenhaConfirm);
        painelPrincipal.add(senConfirm);
        painelPrincipal.add(botaoCadastro);
        painelPrincipal.add(Box.createVerticalGlue());
        add(painelPrincipal);
    }
    public void abrirPrincipal (){
        TelaPrincipal principal = new TelaPrincipal();
        principal.setVisible(true);
    }

}
