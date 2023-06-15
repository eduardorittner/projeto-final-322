import javax.swing.*;
import java.util.ArrayList;

public class App {
        public static void main(String args[]) {

                // Criando o Frame
                // JFrame frame = new JFrame("Testando");
                // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                // frame.setSize(500, 500);

                // // // Criando a barra de navegação
                // JMenuBar menuBar = new JMenuBar();
                // JMenu menuUsuario = new JMenu("Usuário");
                // JMenu menuIngredientes = new JMenu("Ingredientes");
                // JMenu menuPratos = new JMenu("Pratos");

                // JButton button = new JButton("Clique!");
                // frame.getContentPane().add(button);
                // frame.setVisible(true);

                Ingrediente ingrediente1 = new Ingrediente("banana", 1.0, 2.0, 3.0, 4.0, 1.0, 10);
                Ingrediente ingrediente2 = new Ingrediente("laranja", 1.0, 2.0, 3.0, 4.0, 1.0, 10);
                ArrayList<Ingrediente> lista = new ArrayList<>();
                lista.add(ingrediente1);
                lista.add(ingrediente2);
                try {
                        ExpoImpoCsv coisador = new ExpoImpoCsv("teste");
                        coisador.exportarIngredientes(lista);
                        coisador.importarIngredientes(lista);
                        System.out.println(lista);
                } catch (Exception e) {
                        System.out.println(e);
                }

        }
}
