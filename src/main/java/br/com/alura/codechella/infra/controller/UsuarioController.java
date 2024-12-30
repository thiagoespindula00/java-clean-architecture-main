package br.com.alura.codechella.infra.controller;

import br.com.alura.codechella.application.usecases.CriarUsuario;
import br.com.alura.codechella.application.usecases.ListarUsuarios;
import br.com.alura.codechella.domain.entities.usuario.Usuario;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    private final CriarUsuario criarUsuario;
    private final ListarUsuarios listarUsuarios;
    public UsuarioController(CriarUsuario criarUsuario, ListarUsuarios listarUsuarios) {
        this.criarUsuario = criarUsuario;
        this.listarUsuarios = listarUsuarios;
    }
    @PostMapping
    public UsuarioDto cadastrarUsuario(@RequestBody UsuarioDto usuarioDto) {
        Usuario usuarioCriado = criarUsuario.cadastrarUsuario(new Usuario(usuarioDto.cpf(), usuarioDto.nome(), usuarioDto.nascimento(), usuarioDto.email()));

        return new UsuarioDto(usuarioCriado.getCpf(), usuarioCriado.getNome(), usuarioCriado.getNascimento(), usuarioCriado.getEmail());
    }

    @GetMapping
    public List<UsuarioDto> listarUsuarios() {
        return listarUsuarios.listarTodosUsuarios().stream()
                .map(u -> new UsuarioDto(u.getCpf(), u.getNome(), u.getNascimento(), u.getEmail()))
                .collect(Collectors.toList());
    }
}
