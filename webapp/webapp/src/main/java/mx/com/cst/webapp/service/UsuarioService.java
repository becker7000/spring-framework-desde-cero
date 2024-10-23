package mx.com.cst.webapp.service;

import mx.com.cst.webapp.Model.Usuario;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService {

    // Para fines de demostración, utilizaremos una lista en memoria
    private List<Usuario> usuarios = new ArrayList<>();

    public UsuarioService() {
        // Agregar algunos usuarios de ejemplo
        usuarios.add(new Usuario("Juan", "Pérez", "123456789", "juan@example.com"));
        usuarios.add(new Usuario("María", "González", "987654321", "maria@example.com"));
        usuarios.add(new Usuario("Pedro", "Martínez", "456789123", "pedro@example.com"));
    }

    public List<Usuario> obtenerTodos() {
        return usuarios;
    }

    // Aquí podrías agregar otros métodos como guardar, eliminar, buscar, etc.
}
