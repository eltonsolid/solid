package com.eltonsolid.solid.repository;

import com.eltonsolid.solid.model.Contato;
import com.eltonsolid.solid.model.Profissional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Integer> {

    @Query("FROM Contato where query like %:query% ")
    List<Contato> list(String query);

}
