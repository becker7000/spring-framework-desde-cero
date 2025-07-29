package mx.com.telcel.webapp.service;

import mx.com.telcel.webapp.model.Usuario;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

public interface PdfReportService {

    void generarListaUsuariosPdf(OutputStream outputStream, List<Usuario> usuarios) throws IOException;

}
