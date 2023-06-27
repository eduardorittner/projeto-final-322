import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public class Usuario implements Serializable {
    private String username;
    private String nome;
    private String idade;
    private String altura;
    private String peso;
    private String genero;
    private String email;
    //private static ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
    private ArrayList<Refeicao> listaRefeicoes;
    private String caminhoFoto;
    private File bancoUsuario;
    
    //Construtor
    public Usuario(String username, String nome, String idade, String altura, String peso, String genero, String email) {
        try {
            this.bancoUsuario = new File(username + ".csv");
        } catch (Exception e) {
        }
        this.username = username;
        this.nome = nome;
        this.idade = idade;
        this.altura = altura;
        this.peso = peso;
        this.genero = genero;
        this.email = email;
        this.listaRefeicoes = new ArrayList<Refeicao>();
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

    @Override
    public String toString() {
        return "Usuario [username=" + username + ", nome=" + nome + ", idade=" + idade + ", altura=" + altura
                + ", peso=" + peso + ", genero=" + genero + ", email=" + email + ", listaRefeicoes=" + listaRefeicoes
                + ", caminhoFoto=" + caminhoFoto + "]";
    }

    // public static Usuario procuraUsuario(String username) {
    //     for (Usuario u : listaUsuarios) {
    //         if (u.getUsername().equals(username))
    //             return u;
    //     }
    //     return null;
    // }

    // public static boolean adicionaUsuario(Usuario usuario) {
    //     return listaUsuarios.add(usuario);
    // }

    // public static boolean removeUsuario(String username) {
    //     try {
    //     Usuario u = procuraUsuario(username);
    //     listaUsuarios.remove(u);
    //     return true;
    //     } catch (Exception e) {
    //         return false;
    //     }
    // }
    
    public void listaRefeicoes() {
        for (Refeicao r : listaRefeicoes) {
            r.listaAlimentos();
        }
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

    // public static ArrayList<Usuario> getListaUsuarios() {
    //     return listaUsuarios;
    // }

    public ArrayList<Refeicao> getListaRefeicoes() {
        return listaRefeicoes;
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
}