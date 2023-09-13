package com.clas15.clinica2.DaoRepository;

import com.clas15.clinica2.model.Turno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITurnoRepository extends JpaRepository<Turno, Integer> {
}
