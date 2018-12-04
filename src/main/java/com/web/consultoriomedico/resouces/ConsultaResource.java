package com.web.consultoriomedico.resouces;

import com.web.consultoriomedico.dto.ConsultaDTO;
import com.web.consultoriomedico.model.Consulta;
import com.web.consultoriomedico.services.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping(value="/consultas")
public class ConsultaResource {

    @Autowired
    private ConsultaService service;

    @RequestMapping(value="/{id}", method= RequestMethod.GET)
    public ResponseEntity<Consulta> find(@PathVariable Integer id) {
        Consulta obj = service.findOne(id);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(method=RequestMethod.POST)
    public ResponseEntity<Void> insert(@Valid @RequestBody ConsultaDTO objDto) {
        Consulta obj = service.fromDTO(objDto);
        obj = service.salvar(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getCodigo()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public ResponseEntity<Void> update(@Valid @RequestBody ConsultaDTO objDto, @PathVariable Integer id) {
        Consulta obj = service.fromDTO(objDto);
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
    public ResponseEntity<List<ConsultaDTO>> findAll() {
        List<Consulta> list = service.listar();
        List<ConsultaDTO> listDto = list.stream().map(obj -> new ConsultaDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }



}
