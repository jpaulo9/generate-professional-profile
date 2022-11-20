package com.desafio.dio.Gerador.Curriculo.controller;


import com.desafio.dio.Gerador.Curriculo.model.CursosExtraCurricular;
import com.desafio.dio.Gerador.Curriculo.model.Profissional;
import com.desafio.dio.Gerador.Curriculo.service.CursoExtService;
import com.desafio.dio.Gerador.Curriculo.service.ProfissionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cursos")
public class CursoExtraController {

    @Autowired
    CursoExtService service;

    @GetMapping("/listar")
    public ResponseEntity<?> listar() {
        return new ResponseEntity<>(service.listar(), HttpStatus.OK);
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<?> selecionarId(@PathVariable Long id) {
        return new ResponseEntity<>(service.search(id), HttpStatus.OK);
    }
    @PostMapping("/novo")
    public ResponseEntity<?> salvar(@RequestBody CursosExtraCurricular curso) {
        return new ResponseEntity<>(service.novoCurso(curso), HttpStatus.CREATED);
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterar(@PathVariable Long id, @RequestBody CursosExtraCurricular curso) {
        return new ResponseEntity<>(service.atualizar(id, curso), HttpStatus.OK);
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<?> excluir(@PathVariable Long id) {
        service.excluir(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
