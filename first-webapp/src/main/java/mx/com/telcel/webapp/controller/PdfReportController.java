package mx.com.telcel.webapp.controller;

import jakarta.servlet.http.HttpServletResponse;
import mx.com.telcel.webapp.model.Usuario;
import mx.com.telcel.webapp.service.PdfReportService;
import mx.com.telcel.webapp.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class PdfReportController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private PdfReportService pdfReportService;

    @GetMapping("/generar-pdf")
    @ResponseBody
    public void generarPdf(HttpServletResponse response) {

        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=\"lista_usuarios.pdf\"");

        try {
            List<Usuario> usuarios = usuarioService.listarUsuarios();
            pdfReportService.generarListaUsuariosPdf(response.getOutputStream(), usuarios);
        } catch (Exception e) {
            e.printStackTrace(); // En producción se recomienda logging con SLF4J o Logback
        }

    }

}
