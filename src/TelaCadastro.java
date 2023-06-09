import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaCadastro extends JFrame {
    private JTextField campoLogin;
    private JPasswordField campoSenha;
    private JPasswordField campoSenhaConfirm;
    private Login login;
    private Usuario usuario;

    public TelaCadastro(Login login, TelaLogin telaLogin){
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
                String senha2 = new String(campoSenhaConfirm.getPassword());
                if (senha.equals("") || senha2.equals("") || usuario.equals("")){
                    JOptionPane.showMessageDialog(TelaCadastro.this, "Erro ao cadastrar!");
                } 
                else if (senha.equals(senha2) ) {
                    if (login.cadastrarUsuario(usuario, senha2)){
                        JOptionPane.showMessageDialog(TelaCadastro.this, "Cadastro feito com sucesso!");
                    } else{
                        JOptionPane.showMessageDialog(TelaCadastro.this, "Erro ao cadastrar!");
                    }
                    dispose();
                    telaLogin.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(TelaCadastro.this, "As senhas devem ser iguais!");
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
    public void abrirPrincipal (Usuario u){
        TelaPrincipal principal = new TelaPrincipal(u);
        principal.setVisible(true);
    }
    /**
     * @return the campoLogin
     */
    public JTextField getCampoLogin() {
        return campoLogin;
    }
    /**
     * @param campoLogin the campoLogin to set
     */
    public void setCampoLogin(JTextField campoLogin) {
        this.campoLogin = campoLogin;
    }
    /**
     * @return the campoSenha
     */
    public JPasswordField getCampoSenha() {
        return campoSenha;
    }
    /**
     * @param campoSenha the campoSenha to set
     */
    public void setCampoSenha(JPasswordField campoSenha) {
        this.campoSenha = campoSenha;
    }
    /**
     * @return the campoSenhaConfirm
     */
    public JPasswordField getCampoSenhaConfirm() {
        return campoSenhaConfirm;
    }
    /**
     * @param campoSenhaConfirm the campoSenhaConfirm to set
     */
    public void setCampoSenhaConfirm(JPasswordField campoSenhaConfirm) {
        this.campoSenhaConfirm = campoSenhaConfirm;
    }
    /**
     * @return the login
     */
    public Login getLogin() {
        return login;
    }
    /**
     * @param login the login to set
     */
    public void setLogin(Login login) {
        this.login = login;
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
