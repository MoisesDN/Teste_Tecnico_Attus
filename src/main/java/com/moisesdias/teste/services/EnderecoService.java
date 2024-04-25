package com.moisesdias.teste.services;

import com.moisesdias.teste.models.Endereco;
import com.moisesdias.teste.repositories.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository repository;

    public List<Endereco> findAll() {
        return repository.findAll();
    }

    public Endereco findById(Long id) {
        Optional<Endereco> obj = repository.findById(id);
        return obj.get();
    }
}
