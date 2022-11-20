package com.desafio.dio.Gerador.Curriculo.controller;


import com.desafio.dio.Gerador.Curriculo.model.FormacaoAcademica;
import com.desafio.dio.Gerador.Curriculo.service.FormacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/formacao")
public class FormacaoController {



    @Autowired
    FormacaoService service;

    @GetMapping("/listar")
    public ResponseEntity<?> listar() {
        return new ResponseEntity<>(service.listar(), HttpStatus.OK);
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<?> selecionarId(@PathVariable Long id) {
        return new ResponseEntity<>(service.search(id), HttpStatus.OK);
    }
    @PostMapping("/novo")
    public ResponseEntity<?> salvar(@RequestBody FormacaoAcademica formacao) {
        return new ResponseEntity<>(service.novaFormacao(formacao), HttpStatus.CREATED);
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterar(@PathVariable Long id, @RequestBody FormacaoAcademica formacao) {
        return new ResponseEntity<>(service.atualizar(id, formacao), HttpStatus.OK);
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<?> excluir(@PathVariable Long id) {
        service.excluir(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
