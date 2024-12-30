package br.com.alura.codechella.infra.gateways;

import br.com.alura.codechella.domain.entities.usuario.Usuario;
import br.com.alura.codechella.infra.persistence.UsuarioEntity;

public class UsuarioEntityMapper {
    public UsuarioEntity toEntity(Usuario usuarioDomain) {
        return new UsuarioEntity(usuarioDomain.getCpf(),
                usuarioDomain.getNome(),
                usuarioDomain.getNascimento(),
                usuarioDomain.getEmail()
        );
    }

    public Usuario toDomain(UsuarioEntity usuarioEntity) {
        return new Usuario(usuarioEntity.getCpf(),
                usuarioEntity.getNome(),
                usuarioEntity.getNascimento(),
                usuarioEntity.getEmail()
        );
    }
}
