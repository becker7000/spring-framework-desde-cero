package mx.com.cst.webapp.controller;

import mx.com.cst.webapp.Model.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/params")
public class ParamsController {

    // Un solo parametro:

    @GetMapping("/formulario")
    public String mostrarFormulario() {
        return "form_params";
    }

    @GetMapping("/cadena")
    public String params(@RequestParam String texto, Model model) {
        model.addAttribute("resultado", "Mensaje: " + texto);
        return "params/datos";
    }

    // Varios parametros:

    @GetMapping("/formulario-multi")
    public String mostrarFormularioMulti() {
        return "form_multi";
    }

    @GetMapping("/usuario")
    public String mostrarUsuario(
            @RequestParam String nombre,
            @RequestParam String apellido,
            @RequestParam String telefono,
            @RequestParam String email,
            Model model
    ) {
        Usuario usuario = new Usuario(nombre,apellido,telefono,email);
        model.addAttribute("usuario",usuario);
        return "params/datos_usuario";
    }

}
