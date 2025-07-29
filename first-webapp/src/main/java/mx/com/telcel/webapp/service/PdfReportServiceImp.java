package mx.com.telcel.webapp.service;

import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.SolidBorder;
import com.itextpdf.layout.element.*;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.UnitValue;
import mx.com.telcel.webapp.model.Usuario;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

@Service
public class PdfReportServiceImp implements PdfReportService {

    @Override
    public void generarListaUsuariosPdf(OutputStream outputStream, List<Usuario> usuarios) throws IOException {

        PdfWriter writer = new PdfWriter(outputStream);
        PdfDocument pdf = new PdfDocument(writer);
        pdf.getDocumentInfo().setTitle("Lista de Usuarios");

        Document document = new Document(pdf);

        PdfFont font = PdfFontFactory.createFont(StandardFonts.HELVETICA);
        PdfFont boldFont = PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD);

        Paragraph title = new Paragraph("Lista de Usuarios")
                .setFont(boldFont)
                .setFontSize(18)
                .setTextAlignment(TextAlignment.CENTER)
                .setMarginBottom(20);

        document.add(title);

        Table table = new Table(UnitValue.createPercentArray(3)).useAllAvailableWidth();

        // Encabezados
        table.addHeaderCell(createHeaderCell("Nombre", boldFont));
        table.addHeaderCell(createHeaderCell("Teléfono", boldFont));
        table.addHeaderCell(createHeaderCell("Correo", boldFont));

        // Datos
        for (Usuario usuario : usuarios) {
            table.addCell(createDataCell(usuario.getNombre(), font));
            table.addCell(createDataCell(usuario.getTelefono(), font));
            table.addCell(createDataCell(usuario.getCorreo(), font));
        }

        document.add(table);
        document.close();
    }

    private Cell createHeaderCell(String text, PdfFont font) {
        return new Cell()
                .add(new Paragraph(text).setFont(font).setFontSize(12).setFontColor(ColorConstants.WHITE))
                .setBackgroundColor(ColorConstants.BLUE)
                .setTextAlignment(TextAlignment.CENTER)
                .setBorder(new SolidBorder(ColorConstants.BLACK, 1));
    }

    private Cell createDataCell(String text, PdfFont font) {
        return new Cell()
                .add(new Paragraph(text).setFont(font).setFontSize(11))
                .setTextAlignment(TextAlignment.LEFT)
                .setBorder(new SolidBorder(ColorConstants.GRAY, 0.5f));
    }
}
