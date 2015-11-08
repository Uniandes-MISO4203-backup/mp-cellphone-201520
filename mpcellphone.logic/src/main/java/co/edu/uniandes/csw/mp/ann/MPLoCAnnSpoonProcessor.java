package co.edu.uniandes.csw.mp.ann;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import spoon.processing.AbstractAnnotationProcessor;
import spoon.reflect.declaration.CtMethod;

/**
 * Procesador de la anotación utilizando Spoon
 *
 * @author Wilmar Fuquen y Juan David García
 */
public class MPLoCAnnSpoonProcessor extends AbstractAnnotationProcessor<MPLoCAnn, CtMethod<?>> {

    @Override
    public void process(MPLoCAnn annotation, CtMethod<?> element) {
        // Cuenta el número de líneas
        String body = element.getBody().toString();
        int numLineas = 0;
        for (int i = 0; i < body.length(); i++) {
            if (body.charAt(i) == '\n') {
                numLineas++;
            }
        }
        // Genera .csv con la información
        try {
            Calendar cal = Calendar.getInstance();
            // TODO modificar ruta si es necesario
            String ruta = "./data/LoC_Report_"
                    + (cal.get(Calendar.MONTH) + 1) + cal.get(Calendar.DAY_OF_MONTH) + "_" + cal.get(Calendar.HOUR_OF_DAY) + cal.get(Calendar.MINUTE) + ".csv";
            boolean existe = false;

            // Verifica si ya existe para imprimir el encabezado;
            File f = new File(ruta);
            if (f.exists()) {
                existe = true;
            }

            FileWriter fw = new FileWriter(ruta, true);
            PrintWriter pw = new PrintWriter(fw);

            if (!existe) {
                pw.println("Requerimiento;Nivel;Method;LoC");
            }
            pw.println(annotation.reqId() + ";" + annotation.tier() + ";" + element.getSimpleName() + ";" + numLineas);

            pw.close();
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(MPLoCAnnSpoonProcessor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
