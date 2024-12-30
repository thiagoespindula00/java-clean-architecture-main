package br.com.alura.codechella.domain.entities.usuario;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class UsuarioTeste {
    @Test
    public void naoDeveCadastrarUsuarioComCPFNoFormatoInvalido() {
        Assertions.assertThrows(IllegalArgumentException.class,
            () -> new Usuario("123.456.789-101", "A", LocalDate.now(), "")
        );

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Usuario("123456.789-01", "A", LocalDate.now(), "")
        );
    }

    @Test
    public void deveCriarUsuarioComAFabrica() {
        FabricaDeUsuario fabricaDeUsuario = new FabricaDeUsuario();
        Usuario usuario = fabricaDeUsuario.comCpfNomeNascimento("123.456.789-10", "Jonas", LocalDate.now());

        Assertions.assertEquals("Jonas", usuario.getNome());

        usuario = fabricaDeUsuario.incluiEndereco("89110110", 100, "Prédio do TOP");

        Assertions.assertEquals("Prédio do TOP", usuario.getEndereco().getComplemento());
    }
}
