package mx.com.telcel.webapp.controller;

import jakarta.servlet.http.HttpServletResponse;
import mx.com.telcel.webapp.model.Usuario;
import mx.com.telcel.webapp.service.ExcelReportService;
import mx.com.telcel.webapp.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ExcelReportController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private ExcelReportService excelReportService;

    @GetMapping("/generar-excel")
    @ResponseBody
    public void generarExcel(HttpServletResponse response) {
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=\"lista_usuarios.xlsx\"");

        try {
            List<Usuario> usuarios = usuarioService.listarUsuarios();
            excelReportService.exportarUsuariosExcel(response.getOutputStream(), usuarios);
        } catch (Exception e) {
            e.printStackTrace(); // En producción usar logger
        }
    }
}
