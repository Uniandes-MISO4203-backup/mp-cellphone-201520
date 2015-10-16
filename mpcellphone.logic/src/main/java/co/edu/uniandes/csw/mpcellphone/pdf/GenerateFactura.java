package co.edu.uniandes.csw.mpcellphone.pdf;

import co.edu.uniandes.csw.mpcellphone.dtos.OrderDTO;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;

import java.io.File;
import java.io.FileOutputStream;



public class GenerateFactura {
    
    private static final String FUENTE = "Comic Sans MS";

    public String generate(OrderDTO order) throws Exception {
        Document document = new Document();
        
        Paragraph title = new Paragraph("Factura de Compra",
                FontFactory.getFont(FUENTE, 20, Font.BOLD));
        title.setAlignment(Element.ALIGN_CENTER);

        Paragraph encabezado = new Paragraph("Usuario Gracias por tu compra!!!",
                FontFactory.getFont(FUENTE, 16, Font.BOLDITALIC));

        Paragraph parrafo = new Paragraph("Datos de la compra: ",
                FontFactory.getFont(FUENTE, 14, Font.ITALIC));

        PdfPTable datos = new PdfPTable(2);
        datos.addCell("Nombre: ");
        datos.addCell(order.getClient().getName());
        datos.addCell("Correo electr�nico");
        datos.addCell(order.getClient().getEmail());
        datos.addCell("Valor Impuestos");
        datos.addCell(order.getTotalTax());
        datos.addCell("Valor de Descuentos");
        datos.addCell(order.getTotalDiscount());
        datos.addCell("Valor Total de la compra");
        datos.addCell(order.getTotalSale());  

        File temp = File.createTempFile("recibo", ".pdf");
        PdfWriter.getInstance(document, new FileOutputStream(temp));
        document.open();
        document.add(title);
        document.add( Chunk.NEWLINE );
        document.add(encabezado);
        document.add( Chunk.NEWLINE );
        document.add(parrafo);
        document.add( Chunk.NEWLINE );
        document.add(datos);
        
        document.close();
        
        return temp.getAbsolutePath();
    }
}

