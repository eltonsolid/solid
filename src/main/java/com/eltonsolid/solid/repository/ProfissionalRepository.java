package com.eltonsolid.solid.repository;

import com.eltonsolid.solid.model.Profissional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfissionalRepository extends JpaRepository<Profissional, Integer> {


    @Query("FROM Profissional where query like %:query% ")
    List<Profissional> list(String query);

}
