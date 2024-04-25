package com.moisesdias.teste.repositories;

import com.moisesdias.teste.models.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}
