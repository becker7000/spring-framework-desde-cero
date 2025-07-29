package mx.com.telcel.webapp.service;

import mx.com.telcel.webapp.model.Usuario;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UsuarioServiceImp implements UsuarioService {

    @Override
    public List<Usuario> listarUsuarios() {
        return Arrays.asList(
                new Usuario("Laura","5512341234","lau100@gmail.com"),
                new Usuario("Pedro","5512341234","pedro200@gmail.com"),
                new Usuario("Karla","5512341234","karl300@gmail.com"),
                new Usuario("Ulises","5512341234","ulises400@gmail.com")
        );
    }
}
