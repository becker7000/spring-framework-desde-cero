package mx.com.telcel.webapp.controller;

import mx.com.telcel.webapp.model.Usuario;
import mx.com.telcel.webapp.service.UsuarioService;
import mx.com.telcel.webapp.service.UsuarioServiceImp;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
public class IndexController {

    // @GetMapping("/index")
    // @RequestMapping(value="/index") // Por defecto usa GET
    // @RequestMapping(value="/index", method= RequestMethod.GET) // Pero podemos especificar el mé_todo HTTP
    // @GetMapping(value = "/index") // Forma directa
    // @GetMapping({"/index","/home","/inicio"}) // Ajustando varios path
    // @GetMapping("/index")
    /*public String index(Model model){
        model.addAttribute(
                "mensaje",
                "Hola a todos desde un controller de Spring"
        );
        return "index";
    }*/

    @GetMapping("/index")
    public ModelAndView index(ModelAndView modelAndView){
        modelAndView.addObject("mensaje","Hola a todos usando un objeto de ModelAndView");
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping("/perfil")
    public String perfil(Model model){
        Usuario usuario = new Usuario();
        usuario.setNombre("Erick");
        usuario.setTelefono("5512341234"); // Primero sin email
        usuario.setCorreo("erick8000@gmail.com");
        model.addAttribute("usuario",usuario);
        return "perfil";
    }

    // Ajustando un atributo en el model
    @ModelAttribute("horaActual")
    public String horaActual(){
        LocalTime localTime = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        return localTime.format(formatter);
    }

    @RequestMapping("/listar-usuarios")
    public String listar(Model model){
        UsuarioService usuarioService = new UsuarioServiceImp();
        List<Usuario> usuarios = usuarioService.listarUsuarios();
        model.addAttribute("usuarios",usuarios);
        return "listar-usuarios";
    }

}
