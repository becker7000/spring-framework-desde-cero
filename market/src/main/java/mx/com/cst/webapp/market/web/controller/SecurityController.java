package mx.com.cst.webapp.market.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SecurityController {

    @GetMapping("/publica")
    @ResponseBody
    public String home() {
        return "¡Bienvenido a la página pública!";
    }

    @GetMapping("/segura")
    @ResponseBody
    public String secure() {
        return "¡Bienvenido a la página segura!";
    }

}
