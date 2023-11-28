package com.eltonsolid.solid.controller;

import com.eltonsolid.solid.model.Profissional;
import com.eltonsolid.solid.repository.ProfissionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProfissionalController {

    @Autowired
    private ProfissionalRepository repository;


    @GetMapping("/profissionais")
    public ResponseEntity<List<Profissional>> list(@RequestParam String query, @RequestParam List<String> fields) throws Exception {
        List<Profissional> items = repository.list(query);
        if (!fields.isEmpty()) {
            for (Profissional profissional : items) {
                profissional.keepField(fields);
            }
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(items);
    }

    @GetMapping("/profissionais/{id}")
    public ResponseEntity<Profissional> find(@PathVariable Integer id) {
        Optional<Profissional> optional = repository.findById(id);
        return optional.isPresent() ? ResponseEntity.ok(optional.get()) : ResponseEntity.notFound().build();
    }

    @PostMapping("/profissionais")
    public ResponseEntity<String> save(@RequestBody Profissional profissional) {
        if (!profissional.validate().isEmpty()) return ResponseEntity.badRequest().body(profissional.validate());
        Profissional saved = repository.save(profissional);
        return ResponseEntity.status(HttpStatus.CREATED).body("Sucesso! Profissional com ID " + saved.getId() + " cadastrado");
    }

    @PutMapping("/profissionais/{id}")
    public ResponseEntity<String> update(@PathVariable Integer id, @RequestBody Profissional profissional) {
        Optional<Profissional> optional = repository.findById(id);
        if (optional.isEmpty()) return ResponseEntity.notFound().build();
        if (!profissional.validate().isEmpty()) return ResponseEntity.badRequest().body(profissional.validate());

        profissional.setId(id);
        repository.save(profissional);
        return ResponseEntity.ok("Sucesso cadastrado alterado");
    }

    @DeleteMapping("/profissionais/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        if (repository.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(id);
        return ResponseEntity.ok("Sucesso profissional excluído");
    }
}
