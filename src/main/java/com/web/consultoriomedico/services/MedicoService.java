package com.web.consultoriomedico.services;

import com.web.consultoriomedico.dto.MedicoDTO;
import com.web.consultoriomedico.model.Medico;
import com.web.consultoriomedico.repositories.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MedicoService {

    @Autowired
    MedicoRepository repository;


    public Medico findOne(Integer id ){

        return repository.findOne(id);

    }

    public List<Medico> listar(){

        return repository.findAll();

    }

    public void deletar(Integer id){
        repository.delete(id);
    }

    public Medico salvar(Medico medico){
        return repository.save(medico);
    }

    public Medico atualizar(Medico medico){
        return repository.saveAndFlush(medico);
    }
    public Medico fromDTO(MedicoDTO objDto) {
        return new Medico(objDto.getCodigo(), objDto.getNome(), objDto.getCpf(), objDto.getEspecialidade(), objDto.getCrm(), objDto.getSenha() );
    }

}
