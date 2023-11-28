package com.eltonsolid.solid.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ProfissionalTest {

    @Test
    public void keepFieldNome() throws Exception {
        Profissional profissional = new Profissional();
        profissional.setNome("Doctor1");
        profissional.setCargo("Suporte");
        profissional.keepField(List.of("nome"));
        assertEquals("Doctor1", profissional.getNome());
        assertNull(profissional.getCargo());
    }

    @Test
    public void keepFieldCargo() throws Exception {
        Profissional profissional = new Profissional();
        profissional.setNome("Doctor1");
        profissional.setCargo("Suporte");
        profissional.keepField(List.of("cargo"));
        assertEquals("Suporte", profissional.getCargo());
        assertNull(profissional.getNome());
    }

    @Test
    public void validateOnError() throws Exception {
        Profissional profissional = new Profissional();
        profissional.setCargo("Suporte1");
        assertEquals("O campo 'cargo' deve ser Desenvolvedor, Designer, Suporte ou Tester", profissional.validate());
    }

    @Test
    public void validate() throws Exception {
        Profissional profissional = new Profissional();
        profissional.setCargo("Suporte");
        assertTrue(profissional.validate().isEmpty());
    }
}
