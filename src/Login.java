import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Login {

    private File arquivo;

    public Login(String arquivo) {
        this.arquivo = new File(arquivo + ".csv");
    }

    public boolean cadastrarUsuario(String usuario, String senha) {
        try {
            BufferedWriter escritor = new BufferedWriter(new FileWriter(this.arquivo, true));
            if (!usuarioExiste(usuario)) {
                escritor.append("\n");
                escritor.append(usuario + "," + senha + "\n");
                escritor.close();
            }
            else {
                escritor.close();
                throw new IOException("Usuário ja existente!");
            }
            Usuario usuarioObjeto = new Usuario(usuario, usuario, ".", ".", ".", ".", ".");
            usuarioObjeto.salvaUsuarios();
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    public boolean removerUsuario(String usuario, String senha) {
        String linha;
        try {
            File tempFile = new File("temp.csv");
            BufferedWriter escritor = new BufferedWriter(new FileWriter(tempFile));
            BufferedReader leitor = new BufferedReader(new FileReader(this.arquivo));
            while ((linha = leitor.readLine()) != null) {
                if (!linha.split(",")[0].equals(usuario)) {
                    escritor.write(linha);
                }
            }
            escritor.close();
            leitor.close();
            this.arquivo.delete();
            tempFile.renameTo(this.arquivo);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public boolean usuarioExiste(String usuario) {
        String linha;
        try {
            BufferedReader leitor = new BufferedReader(new FileReader(this.arquivo));
            while ((linha = leitor.readLine()) != null) {
                if (linha.split(",")[0].equals(usuario)) {
                    leitor.close();
                    return true;
                }
            }
            leitor.close();
        } catch (IOException e) {
            return true;
        }
        return false;
    }

    public boolean login(String usuario, String senha) {
        String linha;
        String info[];
        try {
            BufferedReader leitor = new BufferedReader(new FileReader(this.arquivo));
            while ((linha = leitor.readLine()) != null) {
                info = linha.split(",");
                if (info[0].equals(usuario)) {
                    if (info[1].equals(senha)) {
                        return true;
                    }
                    return false;
                }
            }
        } catch (IOException e) {
            return false;
        }
        return false;
    }
}
