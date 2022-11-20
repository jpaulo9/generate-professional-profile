package com.desafio.dio.Gerador.Curriculo.service;


import com.desafio.dio.Gerador.Curriculo.model.Endereco;
import com.desafio.dio.Gerador.Curriculo.model.Profissional;
import com.desafio.dio.Gerador.Curriculo.repository.EnderecoRepository;
import com.desafio.dio.Gerador.Curriculo.repository.ProfissionalRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.desafio.dio.Gerador.Curriculo.config.ExceptionCustom.check;

@Service
public class ProfissionalService {

    @Autowired
    ProfissionalRepository repository;
    @Autowired
    private EnderecoService enderecoService;
    @Autowired
    private EnderecoRepository enderecoRepository;

    public List<Profissional> listar(){
        return repository.findAll();
    }

    public Profissional novoProfissional(Profissional profissional) {

        String cep = profissional.getEndereco().getCep();
        Endereco end = enderecoRepository.findById(cep).orElseGet(() ->{
            Endereco newEnde = enderecoService.consultarCep(cep);
            enderecoRepository.save(newEnde);
            return newEnde;
        });
        profissional.setEndereco(end);
     return repository.save(profissional);
    }

    public void excluir(Long id) {
        Optional<Profissional> profissional = search(id);
        check(!profissional.isPresent(), HttpStatus.NOT_FOUND,"Profissional não encontrado, informe um id válido!");
        repository.deleteById(id);
    }

    public Optional<Profissional> search(Long id) {
        Optional<Profissional> profissional = repository.findById(id);
        check(!profissional.isPresent(), HttpStatus.NOT_FOUND,"Profissional não encontrado, informe um id válido!");


        return profissional;
    }

    public Profissional atualizar(Long id, Profissional newProfissional){
        Optional<Profissional> oldProfissional = repository.findById(id);

        check(!oldProfissional.isPresent(), HttpStatus.NOT_FOUND, "Profissional não encontrado, informe um id válido!");

        return repository.save(newProfissional);
    }
}
