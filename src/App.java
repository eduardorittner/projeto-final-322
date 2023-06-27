import java.util.ArrayList;

public class App {
        public static void main(String args[]) throws Exception {
                Login bancoLogins = new Login("contas");
                TelaLogin telaLogin = new TelaLogin(bancoLogins);
                telaLogin.setVisible(true);

        }
}
