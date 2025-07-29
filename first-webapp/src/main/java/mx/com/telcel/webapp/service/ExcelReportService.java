package mx.com.telcel.webapp.service;

import mx.com.telcel.webapp.model.Usuario;

import java.io.OutputStream;
import java.util.List;

public interface ExcelReportService {
    void exportarUsuariosExcel(OutputStream outputStream, List<Usuario> usuarios) throws Exception;
}
