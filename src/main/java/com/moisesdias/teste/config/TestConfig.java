package com.moisesdias.teste.config;

import com.moisesdias.teste.models.Endereco;
import com.moisesdias.teste.models.Pessoa;
import com.moisesdias.teste.models.enums.Estado;
import com.moisesdias.teste.repositories.EnderecoRepository;
import com.moisesdias.teste.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Override
    public void run(String... args) throws Exception {

        Pessoa p1 = new Pessoa(null, "Moises Dias", Instant.parse("1988-12-25T19:53:07Z"));
        Pessoa p2 = new Pessoa(null, "Joaquin Torres", Instant.parse("1990-01-19T00:23:09Z"));

        Endereco e1 = new Endereco( null, "Rua Osvaldo", 45, "Campinas", Estado.SP, 13060774, true, p1);
        Endereco e2 = new Endereco( null, "Rua Francisco", 450, "Atiabaia", Estado.SP, 17097721, false, p1);
        Endereco e3 = new Endereco( null, "Avenida Brasil", 1920, "Sao Paulo", Estado.SP, 12091521, false, p2);
        Endereco e4 = new Endereco( null, "Rua Jose", 129, "Sao Joao", Estado.PR, 21097561, true, p2);

        pessoaRepository.saveAll(Arrays.asList(p1, p2));
        enderecoRepository.saveAll(Arrays.asList(e1, e2, e3, e4));
    }
}
