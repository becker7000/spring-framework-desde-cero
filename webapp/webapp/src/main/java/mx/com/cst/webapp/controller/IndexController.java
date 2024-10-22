package mx.com.cst.webapp.controller;

import mx.com.cst.webapp.Model.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController {

    //@RequestMapping(value="/saludar") // Por defecto usa el método GET
    //@RequestMapping(value="/saludar",method = RequestMethod.GET) // Especifica el método
    //@GetMapping({"/saludar","/inicio","/"})
    // value es un alias de path
    //@GetMapping(value = "/saludar") // Forma directa
    /*
    @GetMapping("/index") // value es el parametro por defecto
    public String index(Model model){ // También se puede usar ModelMap y con Map<String,Object> y put
        // Primero realizar sin el Model model y sin el atributo
        model.addAttribute("mensaje","Hola a todos desde un atributo con Model");
        return "index";
    } // Esta forma es la más usada
     */

    @GetMapping({"/index","/"}) // value es el parametro por defecto
    public ModelAndView index(ModelAndView mv){
        mv.addObject("mensaje","Hola a todos desde con un ModelAndView");
        mv.setViewName("index");
        return mv;
    }

    @RequestMapping("/perfil")
    public String perfil(Model model){
        Usuario usuario = new Usuario();
        usuario.setNombre("Erick");
        usuario.setTelefono("5601928374");
        // usuario.setEmail("erick@gmail.com"); // Agregar despues de if
        model.addAttribute("usuario",usuario);
        return "perfil";
    }

    @RequestMapping("/listar")
    public String listar(Model model){
        List<Usuario> usuarios = new ArrayList<>(); // Primero mostrar vacía
        usuarios.add(new Usuario("Laura","Sanchez","5577112233","lau22@gmail.com"));
        usuarios.add(new Usuario("Zeus","Rodriguez","5712342345","zeus10@gmail.com"));
        usuarios.add(new Usuario("Arely","Castillo","7709890767","are80cas@gmail.com"));
        usuarios.add(new Usuario("Eduardo","Rojas","5634512673","edu01ro@gmail.com"));
        usuarios.add(new Usuario("Osvany","Ceballos","7712328977","os23ceb@gmail.com"));
        model.addAttribute("usuarios",usuarios);
        return "listar";
    }

    @ModelAttribute("horaActual")
    public String horaActual(){
        LocalTime localTime = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        return formatter.format(localTime);
    }

}
