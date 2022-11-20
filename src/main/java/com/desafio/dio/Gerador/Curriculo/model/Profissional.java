package com.desafio.dio.Gerador.Curriculo.model;


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
    private Endereco endereco;



}
