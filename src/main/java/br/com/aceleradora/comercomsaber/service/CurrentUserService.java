package br.com.aceleradora.comercomsaber.service;

import br.com.aceleradora.comercomsaber.model.CurrentUser;
import br.com.aceleradora.comercomsaber.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class CurrentUserService implements UserDetailsService {

    @Autowired
    UsuarioService userService;

    @Override
    public CurrentUser loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario user = userService.buscaPorEmail(email);
        return new CurrentUser(user);
    }
}