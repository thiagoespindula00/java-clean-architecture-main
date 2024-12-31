package br.com.alura.codechella;

import br.com.alura.codechella.domain.entities.usuario.Usuario;
import br.com.alura.codechella.infra.gateways.RepositorioDeUsuarioEmArquivo;

import java.time.LocalDate;

public class UsaUsuariosComArquivos {
    public static void main(String[] args) {
        RepositorioDeUsuarioEmArquivo repositorioDeUsuarioEmArquivo = new RepositorioDeUsuarioEmArquivo();

        repositorioDeUsuarioEmArquivo.cadastrarUsuario(new Usuario("999.888.777-66", "João", LocalDate.now(), "jao@gmail.com"));
        repositorioDeUsuarioEmArquivo.cadastrarUsuario(new Usuario("999.888.777-40", "Pedro", LocalDate.now(), "pedro@gmail.com"));
        repositorioDeUsuarioEmArquivo.cadastrarUsuario(new Usuario("999.888.777-40", "Vinicius", LocalDate.now(), "vinicius@gmail.com"));

        repositorioDeUsuarioEmArquivo.gravaEmArquivo("usuarios.txt");

        //System.out.println(repositorioDeUsuarioEmArquivo.listarTodos());

    }
}
