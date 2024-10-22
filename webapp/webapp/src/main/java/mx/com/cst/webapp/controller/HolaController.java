package mx.com.cst.webapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hola-mundo")
public class HolaController {

    @GetMapping("/saludar") // value es el parametro por defecto
    public String saludar(){
        return "Hola a todos desde una webapp con Spring Framework \uD83D\uDC2C";
    }

}
