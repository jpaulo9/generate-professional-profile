package com.desafio.dio.Gerador.Curriculo.controller;


import com.desafio.dio.Gerador.Curriculo.model.ExperienciaTrabalho;
import com.desafio.dio.Gerador.Curriculo.model.Profissional;
import com.desafio.dio.Gerador.Curriculo.service.ExperienciaTrabalhoService;
import com.desafio.dio.Gerador.Curriculo.service.ProfissionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/experiencia")
public class ExperienciaController {

    @Autowired
    ExperienciaTrabalhoService service;

    @GetMapping("/listar")
    public ResponseEntity<?> listar() {
        return new ResponseEntity<>(service.listar(), HttpStatus.OK);
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<?> selecionarId(@PathVariable Long id) {
        return new ResponseEntity<>(service.search(id), HttpStatus.OK);
    }
    @PostMapping("/novo")
    public ResponseEntity<?> salvar(@RequestBody ExperienciaTrabalho exper) {
        return new ResponseEntity<>(service.novaExperiencia(exper), HttpStatus.CREATED);
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterar(@PathVariable Long id, @RequestBody ExperienciaTrabalho exper) {
        return new ResponseEntity<>(service.atualizar(id, exper), HttpStatus.OK);
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<?> excluir(@PathVariable Long id) {
        service.excluir(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
