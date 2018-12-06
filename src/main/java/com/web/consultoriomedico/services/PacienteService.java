package com.web.consultoriomedico.services;


import com.web.consultoriomedico.dto.PacienteDTO;
import com.web.consultoriomedico.model.Paciente;
import com.web.consultoriomedico.repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PacienteService {
    @Autowired
    PacienteRepository repository;


    public Paciente findOne(Integer id ){

        return repository.findOne(id);

    }

    public List<Paciente> listar(){

        return repository.findAll();

    }

    public void deletar(Integer id){
        repository.delete(id);
    }

    public Paciente salvar(Paciente paciente){
        return repository.save(paciente);
    }

    public Paciente atualizar(Paciente paciente){
        return repository.saveAndFlush(paciente);
    }
    public Paciente fromDTO(PacienteDTO objDto) {
        return new Paciente(objDto.getCodigo(),objDto.getNome(), objDto.getCpf(), objDto.getTelefone(),objDto.getEmail(),objDto.getSenha());
    }
}
