package com.web.consultoriomedico.resouces;

import com.web.consultoriomedico.dto.PacienteDTO;
import com.web.consultoriomedico.model.Paciente;
import com.web.consultoriomedico.services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;


@RestController
@RequestMapping(value="/pacientes")
public class PacienteResource {

    @Autowired
    private PacienteService service;

    @RequestMapping(value="/{id}", method= RequestMethod.GET)
    public ResponseEntity<Paciente> find(@PathVariable Integer id) {
        Paciente obj = service.findOne(id);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(method=RequestMethod.POST)
    public ResponseEntity<Void> insert(@Valid @RequestBody PacienteDTO objDto) {
        Paciente obj = service.fromDTO(objDto);
        obj = service.salvar(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getCodigo()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public ResponseEntity<Void> update(@Valid @RequestBody PacienteDTO objDto, @PathVariable Integer id) {
        Paciente obj = service.fromDTO(objDto);
        obj.setCodigo(id);
        obj = service.atualizar(obj);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method=RequestMethod.GET)
    public ResponseEntity<List<PacienteDTO>> findAll() {
        List<Paciente> list = service.listar();
        List<PacienteDTO> listDto = list.stream().map(obj -> new PacienteDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }
}
