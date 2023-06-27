import java.io.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;

public class Usuario implements Serializable {
    private String username;
    private String nome;
    private String idade;
    private String altura;
    private String peso;
    private String genero;
    private String email;
    private String caminhoFoto;
    private File bancoUsuario;
    
    //Construtor
    public Usuario(String username, String nome, String idade, String altura, String peso, String genero, String email) {
        try {
            this.bancoUsuario = new File("dados/" + username + ".csv");
        } catch (Exception e) {
        }
        this.username = username;
        this.nome = nome;
        this.idade = idade;
        this.altura = altura;
        this.peso = peso;
        this.genero = genero;
        this.email = email;
        this.caminhoFoto = ".";
    }

    //Métodos
    public void salvaUsuarios() {
        try {
        BufferedWriter escritor = new BufferedWriter(new FileWriter(this.bancoUsuario));
        escritor.append(username + "," + nome + "," + idade + "," + altura + "," + peso + "," + genero + "," + email + "," + caminhoFoto + "\n");
        escritor.close();
        } catch (IOException e) {
        }
    }

    public void salvarHistorico(Ingrediente ingrediente){
        try {
        BufferedWriter escritor = new BufferedWriter(new FileWriter(this.bancoUsuario, true));
        escritor.append(ingrediente.toString());
        escritor.close();
        } catch (IOException e) {
        }
    }
    public void salvarHistorico(Receita receita){
        try {
        BufferedWriter escritor = new BufferedWriter(new FileWriter(this.bancoUsuario, true));
        escritor.append(receita.toString());
        escritor.close();
        } catch (IOException e) {
        }
    }
    public void removeHistorico(Alimento alimento){
        try {
            String nomeArquivo = "dados/" + Usuario.this.getUsername() + ".csv";
            File atual = new File(nomeArquivo);
            File tempFile = new File("temp.csv");
            BufferedWriter escritor = new BufferedWriter(new FileWriter("temp.csv"));
            BufferedReader leitor = new BufferedReader(new FileReader(nomeArquivo));
            String linha;
            while ((linha = leitor.readLine()) != null) {
                if (!linha.split(",")[0].equals("Nome: "+alimento.getNome())) {
                    escritor.write(linha + "\n");
                }
            }
            escritor.close();
            leitor.close();
            atual.delete();
            tempFile.renameTo(atual);
    } catch (IOException es) {
    }
    }

    @Override
    public String toString() {
        return "Usuario [username=" + username + ", nome=" + nome + ", idade=" + idade + ", altura=" + altura
                + ", peso=" + peso + ", genero=" + genero + ", email=" + email
                + ", caminhoFoto=" + caminhoFoto + "]";
    }
    //Getters e setters
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdade() {
        return idade;
    }
    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getAltura() {
        return altura;
    }
    public void setAltura(String altura) {
        this.altura = altura;
    }

    public String getPeso() {
        return peso;
    }
    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public void setCaminhoFoto(String caminhoFoto) {
        this.caminhoFoto = caminhoFoto;
    }
    public String getCaminhoFoto() {
        return caminhoFoto;
    }

    /**
     * @return the bancoUsuario
     */
    public File getBancoUsuario() {
        return bancoUsuario;
    }

    /**
     * @param bancoUsuario the bancoUsuario to set
     */
    public void setBancoUsuario(File bancoUsuario) {
        this.bancoUsuario = bancoUsuario;
    }
}