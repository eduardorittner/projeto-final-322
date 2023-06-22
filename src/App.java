import java.util.ArrayList;
//import javax.swing.*;

public class App {
        public static void main(String args[]) throws Exception {

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

                TelaLogin telaLogin = new TelaLogin();
                telaLogin.setVisible(true);

                Ingrediente maca = new Ingrediente("Maçã", 0, 10, 10, 60, 100);
                Ingrediente banana = new Ingrediente("Banana", 0, 0, 30, 120, 100);
                Ingrediente frango = new Ingrediente("Frango", 30, 0, 0, 120, 100);
                // System.out.println(maca);
                // System.out.println(banana);
                // System.out.println(frango);
                Receita receita1 = Receita.novaReceita("Receita 1");
                Receita receita2 = Receita.novaReceita("Receita 2");
                receita1.adicionarIngrediente(frango, 200);
                receita1.adicionarIngrediente(banana, 100);
                receita2.adicionarIngrediente(frango, 200);
                receita2.adicionarIngrediente(banana, 100);
                receita2.adicionarIngrediente(maca, 200);
                System.out.println(receita1);

                Refeicao almoco = Refeicao.novaRefeicao("Almoço");
                almoco.adicionarAlimento(maca, 200);
                almoco.adicionarAlimento(receita1, 1);
                System.out.println(almoco);
                System.out.println(receita2);

                ArrayList<Ingrediente> lista = new ArrayList<>();
                lista.add(banana);
                lista.add(maca);
                lista.add(frango);
                ArrayList<Receita> listaReceitas = new ArrayList<>();
                listaReceitas.add(receita1);
                listaReceitas.add(receita2);
                try {
                        System.out.println("===========");
                        System.out.println("Testando exportador e importador:");
                        System.out.println("Cheque o arquivo 'teste.csv'");
                        ExpoImpoCsv coisador = new ExpoImpoCsv("teste");

                        System.out.println("Lista de receitas exportadas:");
                        System.out.println(listaReceitas);
                        coisador.exportarReceitas(listaReceitas);
                        listaReceitas.clear();
                        coisador.importarReceitas(listaReceitas);
                        System.out.println("Lista de receitas importadas:");
                        System.out.println(listaReceitas);
                } catch (Exception e) {
                        System.out.println(e);
                }
        }
}
