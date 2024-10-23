package mx.com.cst.webapp.controller;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Table;
import jakarta.servlet.http.HttpServletResponse;
import mx.com.cst.webapp.Model.Usuario;
import mx.com.cst.webapp.service.UsuarioService;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.List;

@Controller
public class PdfExcelController {

    @Autowired
    private UsuarioService usuarioService; // Suponiendo que tienes un servicio para manejar usuarios

    @GetMapping("/usuarios")
    public String listarUsuarios(Model model) {
        List<Usuario> usuarios = usuarioService.obtenerTodos(); // Método para obtener usuarios
        model.addAttribute("usuarios", usuarios);
        model.addAttribute("horaActual", System.currentTimeMillis()); // Puedes formatear la hora como desees
        return "usuarios"; // nombre de tu vista Thymeleaf
    }

    @GetMapping("/generate-pdf")
    @ResponseBody
    public void generatePdf(HttpServletResponse response) {
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=\"usuarios.pdf\"");

        try {
            List<Usuario> usuarios = usuarioService.obtenerTodos(); // Obtener los usuarios para incluir en el PDF

            PdfWriter writer = new PdfWriter(response.getOutputStream());
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf);

            Table table = new Table(4); // 4 columnas para nombre, apellido, teléfono y email
            table.addCell("Nombre");
            table.addCell("Apellido");
            table.addCell("Teléfono");
            table.addCell("Email");

            for (Usuario usuario : usuarios) {
                table.addCell(usuario.getNombre());
                table.addCell(usuario.getApellido());
                table.addCell(usuario.getTelefono());
                table.addCell(usuario.getEmail());
            }

            document.add(table);
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/generate-excel")
    public void generateExcel(HttpServletResponse response) throws IOException {
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=\"usuarios.xlsx\"");

        List<Usuario> usuarios = usuarioService.obtenerTodos();

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Usuarios");

        // Crear encabezados
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("Nombre");
        headerRow.createCell(1).setCellValue("Apellido");
        headerRow.createCell(2).setCellValue("Teléfono");
        headerRow.createCell(3).setCellValue("Email");

        // Agregar datos de usuarios
        int rowNum = 1;
        for (Usuario usuario : usuarios) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(usuario.getNombre());
            row.createCell(1).setCellValue(usuario.getApellido());
            row.createCell(2).setCellValue(usuario.getTelefono());
            row.createCell(3).setCellValue(usuario.getEmail());
        }

        // Escribir el archivo Excel en la respuesta
        workbook.write(response.getOutputStream());
        workbook.close();
    }

}
