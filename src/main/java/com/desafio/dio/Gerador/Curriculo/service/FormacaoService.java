package com.desafio.dio.Gerador.Curriculo.service;


import com.desafio.dio.Gerador.Curriculo.model.FormacaoAcademica;
import com.desafio.dio.Gerador.Curriculo.model.Profissional;
import com.desafio.dio.Gerador.Curriculo.repository.FormacaoAcademicaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.desafio.dio.Gerador.Curriculo.config.ExceptionCustom.check;

@Service
public class FormacaoService {


    @Autowired
    FormacaoAcademicaRepository repository;

    public List<FormacaoAcademica> listar(){
        return repository.findAll();
    }

    public FormacaoAcademica novaFormacao(FormacaoAcademica formacao) {
        return repository.save(formacao);
    }

    public void excluir(Long id) {
        Optional<FormacaoAcademica> formacao = search(id);
        check(!formacao.isPresent(), HttpStatus.NOT_FOUND,"Formação não encontrada, informe um id válido!");
        repository.deleteById(id);
    }

    public Optional<FormacaoAcademica> search(Long id) {
        Optional<FormacaoAcademica> formacao = repository.findById(id);
        check(!formacao.isPresent(), HttpStatus.NOT_FOUND,"Formação não encontrada, informe um id válido!");
        return formacao;
    }

    public FormacaoAcademica atualizar(Long id, FormacaoAcademica newFormacao){
        Optional<FormacaoAcademica> oldFormacao = repository.findById(id);
        FormacaoAcademica formacaoAcademica = oldFormacao.get();
        check(!oldFormacao.isPresent(), HttpStatus.NOT_FOUND, "Formação não encontrada, informe um id valido!");
        BeanUtils.copyProperties(newFormacao, formacaoAcademica, "id");
        return repository.save(formacaoAcademica);
    }
}
