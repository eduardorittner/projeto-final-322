//import javax.swing.*;

public class App {
        public static void main(String args[]) throws Exception {

                /*// Criando o Frame
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

                // sou muito inteligente*/

                Ingrediente maca = new Ingrediente("Maçã", 0, 10, 10, 60, 100);
                Ingrediente banana = new Ingrediente("Banana", 0, 0, 30, 120, 100);
                Ingrediente frango = new Ingrediente("Frango", 30, 0, 0, 120, 100);
                //System.out.println(maca);
                //System.out.println(banana);
                //System.out.println(frango);
                Receita receita1 = Receita.novaReceita("Receita 1");
                //Receita receita2 = Receita.novaReceita("Receita 2");
                receita1.adicionarIngrediente(frango, 200);
                receita1.adicionarIngrediente(banana, 100);
                receita1.adicionarIngrediente(maca, 100);
                receita1.imprimirAlimentos();
                System.out.println(receita1);


        }
}
