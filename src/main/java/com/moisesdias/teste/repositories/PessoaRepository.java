package com.moisesdias.teste.repositories;

import com.moisesdias.teste.models.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
