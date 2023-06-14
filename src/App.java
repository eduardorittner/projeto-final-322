import javax.swing.*;

public class App {
        public static void main(String args[]) {

                // Criando o Frame
                JFrame frame = new JFrame("Testando");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(500, 500);

                // // Criando a barra de navegação
                JMenuBar menuBar = new JMenuBar();
                JMenu menuUsuario = new JMenu("Usuário");
                JMenu menuIngredientes = new JMenu("Ingredientes");
                JMenu menuPratos = new JMenu("Pratos");

                JButton button = new JButton("Clique!");
                frame.getContentPane().add(button);
                frame.setVisible(true);

                
        
        }
}
