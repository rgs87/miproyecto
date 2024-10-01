/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebaword;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
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

        // Crear un párrafo
        XWPFParagraph parrafo = documento.createParagraph();
        XWPFRun run = parrafo.createRun();
        run.setText("Este es un documento de ejemplo creado con Apache POI en Java.");
        run.setFontSize(14);

        // Guardar el documento en el disco C:
        try (FileOutputStream out = new FileOutputStream("C:/ejemplo.docx")) {
            documento.write(out);
            System.out.println("Documento creado exitosamente en C:/ejemplo.docx");
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
