package com.clas15.clinica2.clinica.DaoRepository;

import com.clas15.clinica2.clinica.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPacienteRepository extends JpaRepository<Paciente, Integer>{
}
