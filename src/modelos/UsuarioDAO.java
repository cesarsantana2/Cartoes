package modelos;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.EOFException;

public class UsuarioDAO {
    private static final String ARQUIVO = "C:\\Users\\Dell\\Desktop\\Cartoes\\Cartoes\\src\\usuarios.txt";

    public static void salvarUsuario(Aprendiz usuario) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(ARQUIVO, true))) {
            outputStream.writeObject(usuario);
            System.out.println("Usuário salvo com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao salvar o usuário: " + e.getMessage());
        }
    }

    public static Aprendiz buscarUsuarioPorEmail(String email) {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(ARQUIVO))) {
            while (true) {
                try {
                    Aprendiz usuario = (Aprendiz) inputStream.readObject();
                    if (usuario.getEmail().equals(email)) {
                        return usuario;
                    }
                } catch (EOFException e) {
                    break; // Chegou ao final do arquivo
                }
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Classe do usuário não encontrada: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Arquivo não encontrado: " + e.getMessage());
        }
        return null;
    }
    

    public static Aprendiz logarUsuario(String email, String senha) {
        Aprendiz usuario = buscarUsuarioPorEmail(email);
        if (usuario != null && usuario.compararSenha(senha)) {
            return usuario;
        }
        return null;
    }
    
    public static void atualizarUsuario(Aprendiz usuario) {
        Aprendiz usuarioExistente = buscarUsuarioPorEmail(usuario.getEmail());
        if (usuarioExistente != null) {
            usuarioExistente.setIdUsuario(usuario.getIdUsuario());
            usuarioExistente.setNome(usuario.getNome());
            usuarioExistente.setColecao(usuario.getColecao());
            salvarUsuario(usuarioExistente);
            System.out.println("Usuário atualizado com sucesso!");
        } else {
            System.out.println("Usuário não encontrado. Nenhum usuário foi atualizado.");
        }
    }
}
