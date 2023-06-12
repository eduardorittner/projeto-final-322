import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("O que você quer fazer?");
        System.out.println("Montar uma refeição: r");
        System.out.println("Cadastrar um novo ingrediente: i");

        Scanner scanner = new Scanner(System.in);
        String entrada = scanner.nextLine();
        if (entrada.equals("i")) {
            // Para adicionar um novo ingrediente, recebe o nome e calorias por grama e cria
            // uma nova instância do objeto ingrediente, e depois adiciona ele no arquivo
            // calcount/data/ingredientes.txt

            System.out.println("Qual o nome do ingrediente?");
            String nome = scanner.nextLine();
            System.out.println("Quantas calorias por grama ele tem?");
            int calorias = Integer.parseInt(scanner.nextLine());
            Ingrediente novoIngrediente = new Ingrediente(nome, calorias);
            System.out.println("Novo ingrediente adicionado:");
            System.out.println("Nome: " + novoIngrediente.getNome());
            System.out.println("Calorias por grama " + novoIngrediente.getCalorias());
            // FileManager.criarArquivo("ingredientes.txt", "porra nenhuma");
            FileManager.AdicionarIngrediente(novoIngrediente);
        }
        scanner.close();
    }
}
