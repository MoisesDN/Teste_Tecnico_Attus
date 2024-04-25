package com.moisesdias.teste.services;

import com.moisesdias.teste.models.Pessoa;
import com.moisesdias.teste.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository repository;

    public List<Pessoa> findAll() {
        return repository.findAll();
    }

    public Pessoa findById(Long id) {
        Optional<Pessoa> obj = repository.findById(id);
        return obj.get();
    }
}
