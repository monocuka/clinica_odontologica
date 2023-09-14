package com.clas15.clinica2.DaoRepository.securityIDao;


import com.clas15.clinica2.model.security.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public interface IRolRepository extends JpaRepository<Rol, Integer> {
}
