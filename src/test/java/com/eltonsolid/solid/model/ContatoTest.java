package com.eltonsolid.solid.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ContatoTest {

    @Test
    public void keepFieldNome() throws Exception {
        Contato contato = new Contato();
        contato.setNome("Casa Fixo");
        contato.setContato("22334455");
        contato.keepField(List.of("nome"));
        assertEquals("Casa Fixo", contato.getNome());
        assertNull(contato.getContato());
    }

    @Test
    public void keepFieldContato() throws Exception {
        Contato contato = new Contato();
        contato.setNome("Doctor1");
        contato.setContato("Suporte");
        contato.keepField(List.of("contato"));
        assertEquals("Suporte", contato.getContato());
        assertNull(contato.getNome());
    }

}
