package co.edu.uniandes.csw.mpcellphone.pdf;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;

import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;

public class GenerateFactura {

    public void generate() throws Exception {
        Document document = new Document();
        Calendar cal = Calendar.getInstance();
        Date fecha = new Date(cal.getTimeInMillis());
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

        Paragraph title = new Paragraph("Factura de Compra",
                FontFactory.getFont("Comic Sans MS", 20, Font.BOLD));
        title.setAlignment(Element.ALIGN_CENTER);

        Paragraph encabezado = new Paragraph("Usuario Gracias por tu compra!!!",
                FontFactory.getFont("Comic Sans MS", 16, Font.BOLDITALIC));

        Paragraph parrafo = new Paragraph("Datos de la compra: ",
                FontFactory.getFont("Comic Sans MS", 14, Font.ITALIC));

        PdfPTable datos = new PdfPTable(2);
        datos.addCell("Nombre: ");
        datos.addCell("Nombre de la persona");
        datos.addCell("Correo electrónico");
        datos.addCell("Correo de la persona");
        datos.addCell("Valor Impuestos");
        datos.addCell("Total Tax");
        datos.addCell("Valor de Descuentos");
        datos.addCell("Total Discount");
        datos.addCell("Valor Total de la compra");
        datos.addCell("Total Sale");  

        PdfWriter.getInstance(document, new FileOutputStream("recibo.pdf"));
        document.open();
        document.add(title);
        document.add( Chunk.NEWLINE );
        document.add(encabezado);
        document.add( Chunk.NEWLINE );
        document.add(parrafo);
        document.add( Chunk.NEWLINE );
        document.add(datos);
        
        document.close();

    }

    public static void main(String args[]) {
        try {
            GenerateFactura p = new GenerateFactura();
            p.generate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

