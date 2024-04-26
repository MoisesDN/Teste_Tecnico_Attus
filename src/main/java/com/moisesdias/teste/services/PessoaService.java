package com.moisesdias.teste.services;

import com.moisesdias.teste.models.Pessoa;
import com.moisesdias.teste.repositories.PessoaRepository;
import jakarta.transaction.Transactional;
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

    @Transactional
    public Pessoa insert(Pessoa obj) {
        return repository.save(obj);
    }

    @Transactional
    public Pessoa update(Long id, Pessoa obj) {
        Pessoa p1 = repository.getReferenceById(id);
        updateData(p1, obj);
        return repository.save(p1);
    }

    private void updateData(Pessoa entity, Pessoa obj) {
        entity.setNome(obj.getNome());
        entity.setDataDeNascimento(obj.getDataDeNascimento());
    }
}
