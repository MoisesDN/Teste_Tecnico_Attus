package com.moisesdias.teste.resources;

import com.moisesdias.teste.models.Pessoa;
import com.moisesdias.teste.services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/pessoas")
public class PessoaResource {

    @Autowired
    private PessoaService service;

    @GetMapping
    public ResponseEntity<List<Pessoa>> findAll() {
        List<Pessoa> list = service.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Pessoa> findById(@PathVariable Long id) {
        Pessoa obj = service.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(obj);
    }

    @PostMapping
    public ResponseEntity<Pessoa> insert(@RequestBody Pessoa obj) {
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.status(HttpStatus.CREATED).body(obj);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Pessoa> update(@PathVariable Long id, @RequestBody Pessoa obj) {
        obj = service.update(id, obj);
        return ResponseEntity.status(HttpStatus.OK).body(obj);
    }
}
