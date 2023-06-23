import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Login implements AutoCloseable {

    private File arquivo;
    private BufferedWriter escritor;
    private BufferedReader leitor;

    public Login(String arquivo) throws IOException {
        this.arquivo = new File(arquivo);
        try {
            this.escritor = new BufferedWriter(new FileWriter(arquivo));
            this.leitor = new BufferedReader(new FileReader(arquivo));
        } catch (IOException e) {
            throw e;
        }
    }

    public void close() {
        try {
            this.leitor.close();
            this.escritor.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public boolean cadastrarUsuario(String usuario, String senha) {
        try {
            escritor.append(usuario + "," + senha);
            escritor.flush();
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    public boolean removerUsuario(String usuario, String senha) {
        String linha;
        try {
            File tempFile = new File("temp");
            BufferedWriter escritor = new BufferedWriter(new FileWriter(tempFile));
            while ((linha = leitor.readLine()) != null) {
                if (!linha.split(",")[0].equals(usuario)) {
                    escritor.write(linha);
                }
            }
            escritor.close();
            this.arquivo.delete();
            tempFile.renameTo(this.arquivo);
        } catch (IOException e) {
            return true;
        }
        return false;
    }

    public boolean usuarioExiste(String usuario) {
        String linha;
        try {
            while ((linha = leitor.readLine()) != null) {
                if (linha.split(",")[0].equals(usuario)) {
                    return true;
                }
            }
        } catch (IOException e) {
            return true;
        }
        return false;
    }

    public boolean login(String usuario, String senha) {
        String linha;
        String info[];
        try {
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
