package com.web.consultoriomedico.repositories;

import com.web.consultoriomedico.model.Medico;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MedicoRepository extends JpaRepository<Medico, Integer> {

}
