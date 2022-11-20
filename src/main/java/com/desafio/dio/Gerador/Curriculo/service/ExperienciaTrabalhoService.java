package com.desafio.dio.Gerador.Curriculo.service;


import com.desafio.dio.Gerador.Curriculo.model.ExperienciaTrabalho;
import com.desafio.dio.Gerador.Curriculo.repository.ExperienciaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.desafio.dio.Gerador.Curriculo.config.ExceptionCustom.check;

@Service
public class ExperienciaTrabalhoService {

    @Autowired
    ExperienciaRepository repository;


    public List<ExperienciaTrabalho> listar(){
        return repository.findAll();
    }

    public ExperienciaTrabalho novaExperiencia(ExperienciaTrabalho experienciaTrabalho) {
        return repository.save(experienciaTrabalho);
    }

    public void excluir(Long id) {
        Optional<ExperienciaTrabalho> experienciaTrabalho = search(id);
        check(!experienciaTrabalho.isPresent(), HttpStatus.NOT_FOUND,"Experiência não encontrada, informe um id valido!");
        repository.deleteById(id);
    }

    public Optional<ExperienciaTrabalho> search(Long id) {
        Optional<ExperienciaTrabalho> experienciaTrabalho = repository.findById(id);
        check(!experienciaTrabalho.isPresent(), HttpStatus.NOT_FOUND,"Experiência não encontrada, informe um id valido!");
        return experienciaTrabalho;
    }

    public ExperienciaTrabalho atualizar(Long id, ExperienciaTrabalho newExperiencia){
        Optional<ExperienciaTrabalho> oldExperiencia = repository.findById(id);
        ExperienciaTrabalho experienciaTrabalho = oldExperiencia.get();
        check(!oldExperiencia.isPresent(), HttpStatus.NOT_FOUND, "Experiência não encontrada, informe um id valido!");
        BeanUtils.copyProperties(newExperiencia, experienciaTrabalho, "id");
        return repository.save(experienciaTrabalho);
    }
}
