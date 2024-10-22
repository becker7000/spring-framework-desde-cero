package mx.com.cst.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Controller
@RequestMapping("/ajax")
public class AjaxController {

    @GetMapping("/texto")
    public String mostrarTexto(){
        return "ajax/doc_texto";
    }


    @GetMapping("/api")
    public String mostrarUsuarios(){
        return "ajax/usuarios_api";
    }

    @GetMapping("/reloj_ajax")
    public String mostrarRelojAjax(){
        return "ajax/reloj";
    }

    @GetMapping("/reloj")
    @ResponseBody
    public String mostrarReloj(){
        LocalTime ahora = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        return ahora.format(formatter);
    }


}
