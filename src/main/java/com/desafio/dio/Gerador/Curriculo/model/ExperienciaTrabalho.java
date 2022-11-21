package com.desafio.dio.Gerador.Curriculo.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
public class ExperienciaTrabalho {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String empresa;
    private String mesAnoInicio;
    private String mesAnoFinal;
    private String cargo;
    private String atividadesDesenvolvidas;

}
