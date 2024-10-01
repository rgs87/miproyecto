/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebaword;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

/**
 *
 * @author Ruben
 */
public class PruebaWord {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       // Crear un nuevo documento de Word
        XWPFDocument documento = new XWPFDocument();
        
        // Crear un título
        XWPFParagraph titulo = documento.createParagraph();
        titulo.setAlignment(ParagraphAlignment.CENTER); // Centrar el título
        XWPFRun runTitulo = titulo.createRun();
        runTitulo.setText("Título del Documento");
        runTitulo.setBold(true); // Establecer el texto en negrita
        runTitulo.setFontSize(20); // Establecer tamaño de fuente para el título
        titulo.setSpacingAfter(200); // Espacio después del título


        // Crear un párrafo
        XWPFParagraph parrafo = documento.createParagraph();
        XWPFRun run = parrafo.createRun();
        run.setText("Este es un documento de ejemplo creado con Apache POI en Java.");
        run.setFontSize(14);
         // Obtener la fecha y hora del sistema
        String formato = "yyyy-MM-dd_HH-mm-ss"; // Formato de fecha y hora
        SimpleDateFormat sdf = new SimpleDateFormat(formato);
        String fechaYHora = sdf.format(new Date());
        
        // Crear el nombre del archivo
        String nombreArchivo = "C:/ejemplo_" + fechaYHora + ".docx";
        

        // Guardar el documento en el disco C:
        try (FileOutputStream out = new FileOutputStream(nombreArchivo)) {
            documento.write(out);
            System.out.println("Documento creado exitosamente en " + nombreArchivo);
        } catch (IOException e) {
            System.err.println("Error al crear el documento: " + e.getMessage());
        } finally {
            // Cerrar el documento
            try {
                documento.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
         System.out.println("Presiona Enter para cerrar el programa...");

        // Crear un objeto Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);

        // Esperar a que el usuario presione Enter
        scanner.nextLine();

        // Cerrar el scanner
        scanner.close();
    }
    
}
