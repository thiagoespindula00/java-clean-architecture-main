package br.com.alura.codechella.config;

import br.com.alura.codechella.application.gateways.RepositorioDeUsuario;
import br.com.alura.codechella.application.usecases.CriarUsuario;
import br.com.alura.codechella.infra.controller.UsuarioController;
import br.com.alura.codechella.infra.gateways.RepositorioDeUsuarioJpa;
import br.com.alura.codechella.infra.gateways.UsuarioEntityMapper;
import br.com.alura.codechella.infra.persistence.UsuarioRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UsuarioConfig {
    @Bean
    public CriarUsuario instanciaCriarUsuario(RepositorioDeUsuario repositorioDeUsuario) {
        return new CriarUsuario(repositorioDeUsuario);
    }

    @Bean
    public RepositorioDeUsuarioJpa instanciaRepositorioDeUsuarioJpa(UsuarioEntityMapper mapper, UsuarioRepository usuarioRepository) {
        return new RepositorioDeUsuarioJpa(mapper, usuarioRepository);
    }

    @Bean
    public UsuarioEntityMapper instanciaUsuarioEntityMapper() {
        return new UsuarioEntityMapper();
    }
}
