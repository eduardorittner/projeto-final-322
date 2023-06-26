import java.util.ArrayList;

public class Usuario {
    private String username;
    private String nome;
    private int idade;
    private double altura;
    private double peso;
    private String genero;
    private String email;
    private static ArrayList<Usuario> listaUsuarios;
    private ArrayList<Refeicao> listaRefeicoes;
    private String caminhoFoto;
    
    //Construtor
    public Usuario(String username, String nome, int idade, double altura, double peso, String genero, String email) {
        this.username = username;
        this.nome = nome;
        this.idade = idade;
        this.altura = altura;
        this.peso = peso;
        this.genero = genero;
        this.email = email;
        listaUsuarios = new ArrayList<Usuario>();
        listaRefeicoes = new ArrayList<Refeicao>();
        this.caminhoFoto = "";
    }

    //Métodos
    public boolean adicionaUsuario(Usuario usuario) {
        try {
        listaUsuarios.add(usuario);
        return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean removeUsuario(Usuario usuario) {
        try {
        listaUsuarios.remove(usuario);
        return true;
        } catch (Exception e) {
            return false;
        }
    }
    
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

    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getAltura() {
        return altura;
    }
    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }
    public void setPeso(double peso) {
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

    public static ArrayList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

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