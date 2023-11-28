package com.eltonsolid.solid.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import org.hibernate.annotations.Formula;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "contato")
public class Contato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Integer id = -1;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String nome = "";

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String contato = "";

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private LocalDateTime createdDate = LocalDateTime.now();

    private Integer profissional;

    @Formula("CONCAT(nome, ' ', contato, ' ', to_char(created_date, 'YYYY-MM-DD HH:MM') , ' ', profissional)")
    private String query = "";

    public void keepField(List<String> fields) throws NoSuchFieldException, IllegalAccessException {
        List<String> keys = new ArrayList<>(List.of("nome", "contato", "profissional", "createdDate"));
        keys.removeAll(fields);
        for (String field : keys) {
            this.getClass().getDeclaredField(field).set(this, null);
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public Integer getProfissional() {
        return profissional;
    }

    public void setProfissional(Integer profissional) {
        this.profissional = profissional;
    }
}
