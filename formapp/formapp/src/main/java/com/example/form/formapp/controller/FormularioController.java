package com.example.form.formapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class FormularioController {

    @GetMapping("/formulario")
    public String showForm(Model model) {
        model.addAttribute("errores", new HashMap<String, String>());
        return "formulario"; // Nombre de la vista JSP
    }

    @PostMapping("/validacion-mejor")
    public String validateForm(@RequestParam(required = false) String username,
                               @RequestParam(required = false) String password,
                               @RequestParam(required = false) String email,
                               @RequestParam(required = false) String pais,
                               @RequestParam(required = false) String[] idioma,
                               Model model) {

        Map<String, String> errores = new HashMap<>();

        if (username == null || username.isEmpty()) {
            errores.put("username", "El nombre es obligatorio");
        }
        if (password == null || password.isEmpty()) {
            errores.put("password", "La contraseña es obligatoria");
        }
        if (email == null || email.isEmpty()) {
            errores.put("email", "El correo es obligatorio");
        } else if (!email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            errores.put("email", "El correo debe ser válido");
        }
        if (pais == null || pais.isEmpty()) {
            errores.put("pais", "El país es obligatorio");
        }
        if (idioma == null || idioma.length == 0) {
            errores.put("idioma", "Debes seleccionar al menos un idioma");
        }

        // Verificar si hay errores
        if (!errores.isEmpty()) {
            model.addAttribute("errores", errores);
            model.addAttribute("username", username);
            model.addAttribute("email", email);
            model.addAttribute("pais", pais);
            model.addAttribute("idioma", idioma);
            return "formulario"; // Regresa al formulario si hay errores
        }else{
            model.addAttribute("username", username);
            model.addAttribute("email", email);
            model.addAttribute("pais", pais);
            model.addAttribute("idioma", idioma);
            return "/validacion_exitosa";
        }
    }

}
