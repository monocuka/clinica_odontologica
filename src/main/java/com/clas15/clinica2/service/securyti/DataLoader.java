package com.clas15.clinica2.service.securyti;


import com.clas15.clinica2.exceptions.BadRequestException;
import com.clas15.clinica2.model.security.Rol;
import com.clas15.clinica2.model.security.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@RequiredArgsConstructor
public class DataLoader implements ApplicationRunner {
  private final UsuarioService usuarioService;
  
  @Override
  public void run(ApplicationArguments args) throws BadRequestException {
    usuarioService.guardar(
        Usuario.builder()
        .username("admin")
        .email("admin@gmail.com")
        .password("admin")
        .roles(Set.of(new Rol("ADMIN")))
        .build()
    );
    usuarioService.guardar(
        Usuario.builder()
            .username("user")
            .email("user@gmail.com")
            .password("user")
            .roles(Set.of(new Rol("USER")))
            .build()
    );
  }
}
