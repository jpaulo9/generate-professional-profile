package com.desafio.dio.Gerador.Curriculo.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
public class Profissional {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;
    private String CPF;
    private int RG;
    private LocalDate dataNasc;
    private int idade;

    @ManyToOne
    @JoinColumn(name = "cep")
    @JsonIgnoreProperties("profissional")
    private Endereco endereco;

    @ManyToOne
    @JoinColumn(name = "formacao_academica_id")
    @JsonIgnoreProperties("profissional")
    private FormacaoAcademica formacaoAcademica;

    @ManyToOne
    @JoinColumn(name = "curso_extra_curricular_id")
    @JsonIgnoreProperties("profissional")
    private CursosExtraCurricular cursosExtraCurricular;

    @ManyToOne
    @JoinColumn(name = "experiencia_trabalho_id")
    @JsonIgnoreProperties("profissional")
    private ExperienciaTrabalho experienciaTrabalho;




}
