package com.eltonsolid.solid.controller;

import com.eltonsolid.solid.model.Contato;
import com.eltonsolid.solid.repository.ContatoRepository;
import com.eltonsolid.solid.repository.ProfissionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ContatoController {

    @Autowired
    private ContatoRepository repository;

    @Autowired
    private ProfissionalRepository profissionalRepository;

    @GetMapping("/contatos")
    public ResponseEntity<List<Contato>> list(@RequestParam(required = false, defaultValue = "") String query, @RequestParam(required = false, defaultValue = "") List<String> fields) throws Exception {
        List<Contato> items = repository.list(query);
        if (!fields.isEmpty()) {
            for (Contato contato : items) {
                contato.keepField(fields);
            }
        }
        return ResponseEntity.status(HttpStatus.OK).body(items);
    }

    @GetMapping("/contatos/{id}")
    public ResponseEntity<Contato> find(@PathVariable Integer id) {
        Optional<Contato> optional = repository.findById(id);
        return optional.isPresent() ? ResponseEntity.ok(optional.get()) : ResponseEntity.notFound().build();
    }

    @PostMapping("/contatos")
    public ResponseEntity<String> save(@RequestBody Contato contato) {
        if (profissionalRepository.findById(contato.getProfissional()).isEmpty()) return ResponseEntity.badRequest().body("Professional Nao encontrado");
        Contato saved = repository.save(contato);
        return ResponseEntity.status(HttpStatus.CREATED).body("Sucesso! Contato com ID " + saved.getId() + " cadastrado");
    }

    @PutMapping("/contatos/{id}")
    public ResponseEntity<String> update(@PathVariable Integer id, @RequestBody Contato contato) {
        Optional<Contato> optional = repository.findById(id);
        if (optional.isEmpty()) return ResponseEntity.notFound().build();
        if (profissionalRepository.findById(contato.getProfissional()).isEmpty()) return ResponseEntity.badRequest().body("Profissional nao existe");

        contato.setId(id);
        repository.save(contato);
        return ResponseEntity.ok("Sucesso cadastro alterado");
    }

    @DeleteMapping("/contatos/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        if (repository.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(id);
        return ResponseEntity.ok("Sucesso contato excluído");
    }

}
