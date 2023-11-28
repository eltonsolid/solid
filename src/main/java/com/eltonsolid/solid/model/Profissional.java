package com.eltonsolid.solid.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import org.hibernate.annotations.Formula;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "profissional")
public class Profissional {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Integer id = -1;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String nome = "";

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String cargo = "";

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private LocalDate nascimento = LocalDate.now();

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private LocalDateTime createdDate = LocalDateTime.now();

    @Formula("CONCAT(nome, ' ', cargo, ' ', to_char(nascimento, 'YYYY-MM-DD'), ' ',to_char(created_date, 'YYYY-MM-DD HH:MM'))")
    private String query = "";

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

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public void keepField(List<String> fields) throws NoSuchFieldException, IllegalAccessException {
        List<String> keys = new ArrayList<>(List.of("nome", "cargo", "nascimento", "createdDate"));
        keys.removeAll(fields);
        for (String field : keys) {
            this.getClass().getDeclaredField(field).set(this, null);
        }
    }

    public String validate() {
        if (!cargo.matches("^(Desenvolvedor|Designer|Suporte|Tester)$")) {
            return "O campo 'cargo' deve ser Desenvolvedor, Designer, Suporte ou Tester";
        }
        return "";
    }
}
