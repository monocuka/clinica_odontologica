package com.clas15.clinica2.DaoRepository.securityIDao;


import com.clas15.clinica2.model.security.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {
  Optional<Usuario> findByUsername(String name);
}
