package com.desafio.dio.Gerador.Curriculo.repository;

import com.desafio.dio.Gerador.Curriculo.model.CursosExtraCurricular;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoExtraRepository extends JpaRepository<CursosExtraCurricular, Long> {
}
