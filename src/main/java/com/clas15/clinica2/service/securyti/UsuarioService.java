package com.clas15.clinica2.service.securyti;

import com.clas15.clinica2.DaoRepository.securityIDao.IRolRepository;
import com.clas15.clinica2.DaoRepository.securityIDao.IUsuarioRepository;
import com.clas15.clinica2.model.security.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.clas15.clinica2.exceptions.BadRequestException;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UsuarioService implements UserDetailsService {
  private final IUsuarioRepository usuarioRepository;
  private final IRolRepository rolRepository;
  private final PasswordEncoder passwordEncoder;

  
  public Usuario guardar(Usuario user) throws BadRequestException {
    if (user == null)
      throw new BadRequestException("El usuario no puede ser null");
    rolRepository.saveAll(user.getRoles());
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    return usuarioRepository.save(user);
  }
  
  @Override
  @Transactional(readOnly = true)
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    return usuarioRepository.findByUsername(username)
        .map(usuario -> User.builder()
            .username(usuario.getUsername())
            .password(usuario.getPassword())
            .authorities(usuario.getRoles().stream()
                .map(rol -> new SimpleGrantedAuthority(rol.getName()))
                .collect(Collectors.toSet()))
            .build())
        .orElseThrow(() -> new UsernameNotFoundException("No existe el usuario con username: " + username));
  }
}
