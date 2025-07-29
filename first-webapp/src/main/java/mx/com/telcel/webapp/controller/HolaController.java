package mx.com.telcel.webapp.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // @Controller + @ResponseBody
@RequestMapping("/saludo")
public class HolaController {

    @GetMapping("/hola")
    public String hola(Model model){
        return "Hola a todos desde Spring Framework 🚀";
    }

}
