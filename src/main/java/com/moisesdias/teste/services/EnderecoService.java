package com.moisesdias.teste.services;

import com.moisesdias.teste.models.Endereco;
import com.moisesdias.teste.repositories.EnderecoRepository;
import jakarta.transaction.Transactional;
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

    @Transactional
    public Endereco insert(Endereco obj) {
        return repository.save(obj);
    }

    @Transactional
    public Endereco update(Long id, Endereco obj) {
        Endereco p1 = repository.getReferenceById(id);
        updateData(p1, obj);
        return repository.save(p1);
    }

    private void updateData(Endereco entity, Endereco obj) {
        entity.setCep(obj.getCep());
        entity.setCidade(obj.getCidade());
        entity.setNumero(obj.getNumero());
        entity.setLogradouro(obj.getLogradouro());
        entity.setEstado(obj.getEstado());
        entity.setPrincipal(obj.getPrincipal());
    }
}
