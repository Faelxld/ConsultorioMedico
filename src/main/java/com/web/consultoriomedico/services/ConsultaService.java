package com.web.consultoriomedico.services;

import com.web.consultoriomedico.dto.ConsultaDTO;
import com.web.consultoriomedico.model.Consulta;
import com.web.consultoriomedico.repositories.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultaService{

    @Autowired
    ConsultaRepository repository;

    public Consulta findOne(Integer id ) {
        return repository.findOne(id);
    }

    public List<Consulta> listar() {
        return repository.findAll();
    }

    public void deletar(Integer id) {
        repository.delete(id);
    }

    public Consulta salvar(Consulta consulta) {
        return repository.save(consulta);
    }

    public Consulta atualizar(Consulta consulta) {
        return repository.saveAndFlush(consulta);
    }
    
    public Consulta fromDTO(ConsultaDTO objDto) {
        return new Consulta(objDto.getCodigo(), objDto.getTipo(), objDto.getData(), objDto.getHoraInicial(), objDto.getHoraFinal(), objDto.getObservacoes());
    }
}
