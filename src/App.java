import java.util.ArrayList;

//import javax.swing.*;

public class App {
        public static void main(String args[]) throws Exception {
                Login bancoLogins = new Login("contas");
                TelaLogin telaLogin = new TelaLogin(bancoLogins);
                telaLogin.setVisible(true);


        }
}
