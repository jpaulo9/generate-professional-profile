package com.desafio.dio.Gerador.Curriculo.service;


import com.desafio.dio.Gerador.Curriculo.model.CursosExtraCurricular;
import com.desafio.dio.Gerador.Curriculo.repository.CursoExtraRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.desafio.dio.Gerador.Curriculo.config.ExceptionCustom.check;

@Service
public class CursoExtService {

    @Autowired
    CursoExtraRepository repository;

    public List<CursosExtraCurricular> listar(){
        return repository.findAll();
    }

    public CursosExtraCurricular novoCurso(CursosExtraCurricular curso) {
        return repository.save(curso);
    }

    public void excluir(Long id) {
        Optional<CursosExtraCurricular> curso = search(id);
        check(!curso.isPresent(), HttpStatus.NOT_FOUND,"Curso não encontrado, informe um id válido!");
        repository.deleteById(id);
    }

    public Optional<CursosExtraCurricular> search(Long id) {
        Optional<CursosExtraCurricular> curso = repository.findById(id);
        check(!curso.isPresent(), HttpStatus.NOT_FOUND,"Curso não encontrado, informe um id válido!");
        return curso;
    }

    public CursosExtraCurricular atualizar(Long id, CursosExtraCurricular newCurso){
        Optional<CursosExtraCurricular> oldCurso = repository.findById(id);
        CursosExtraCurricular curso = oldCurso.get();
        check(!oldCurso.isPresent(), HttpStatus.NOT_FOUND, "Profissional não encontrado, informe um id válido!");
        BeanUtils.copyProperties(newCurso, curso, "id");
        return repository.save(curso);
    }

}
