package utilidades;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import personal.Alumno;
import personal.Docente;

public class ReportePdf {
    Document documento;
    FileOutputStream fileOutputStream;

    // fuentes de Titulo y párrafo
    Font fuenteTitulo = FontFactory.getFont(FontFactory.TIMES_ROMAN,16);
    Font fuenteParrafo = FontFactory.getFont(FontFactory.HELVETICA,12);

    public void crearDocumento(){

        try {
            // creación del documento con sus márgenes
            documento = new Document(PageSize.A4,35,30,50,50);
            
            // archivo pdf que vamos a generar
            String ruta = System.getProperty("user.dir");
            fileOutputStream = new FileOutputStream(ruta + "/Reporte.pdf");
            
            // obtener la instancia del PdfWriter
            PdfWriter.getInstance(documento,fileOutputStream);
        } catch (FileNotFoundException | DocumentException ex) {
            Logger.getLogger(ReportePdf.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void abrirDocumento(){
        documento.open();
    }

    public void agregarTitulo(String texto) {
        try {
            PdfPTable tabla = new PdfPTable(1);
            PdfPCell celda = new PdfPCell(new Phrase(texto,fuenteTitulo));
            celda.setColspan(5);
            celda.setBorderColor(BaseColor.WHITE);
            celda.setHorizontalAlignment(Element.ALIGN_CENTER);
            tabla.addCell(celda);
            documento.add(tabla);
        } catch (DocumentException ex) {
            Logger.getLogger(ReportePdf.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void agregarParrafo(String texto) {
        try {
            Paragraph parrafo = new Paragraph();
            parrafo.add(new Phrase(texto, fuenteParrafo));
            documento.add(parrafo);
        } catch (DocumentException ex) {
            Logger.getLogger(ReportePdf.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void agregarSaltosDeLinea(){
        try {
            Paragraph saltosdelinea = new Paragraph();
            saltosdelinea.add(new Phrase(Chunk.NEWLINE));
            saltosdelinea.add(new Phrase(Chunk.NEWLINE));
            documento.add(saltosdelinea);
        } catch (DocumentException ex) {
            Logger.getLogger(ReportePdf.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    public void agregarTablaAlumnos(File ruta) {
        try {
            PdfPTable tabla = new PdfPTable(6);
            tabla.addCell("DNI");
            tabla.addCell("Nombres y apellidos");
            tabla.addCell("Fecha de nacimiento");
            tabla.addCell("Telefono");
            tabla.addCell("Direccion");
            tabla.addCell("Sexo");
            
            List<Alumno> alumnos = ArchivoJson.leerAlumnos(ruta);
            
            for (Alumno alumno: alumnos) {
                tabla.addCell(alumno.getDni());
                tabla.addCell(alumno.getApeNom());
                tabla.addCell(alumno.getFechaNac());
                tabla.addCell(alumno.getTelef());
                tabla.addCell(alumno.getDireccion());
                tabla.addCell(alumno.getSexo());
            }
            documento.add(tabla);
        } catch (DocumentException ex) {
            Logger.getLogger(ReportePdf.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void agregarTablaAlumnos(SqlDatos datos) {
        try {
            PdfPTable tabla = new PdfPTable(6);
            tabla.addCell("DNI");
            tabla.addCell("Nombres y apellidos");
            tabla.addCell("Fecha de nacimiento");
            tabla.addCell("Telefono");
            tabla.addCell("Direccion");
            tabla.addCell("Sexo");
            
            List<Alumno> alumnos = TodoSql.obtenerAlumnos(datos);
            
            for (Alumno alumno: alumnos) {
                tabla.addCell(alumno.getDni());
                tabla.addCell(alumno.getApeNom());
                tabla.addCell(alumno.getFechaNac());
                tabla.addCell(alumno.getTelef());
                tabla.addCell(alumno.getDireccion());
                tabla.addCell(alumno.getSexo());
            }
            documento.add(tabla);
        } catch (DocumentException ex) {
            Logger.getLogger(ReportePdf.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void agregarTablaDocentes(File ruta){
        try {
            PdfPTable tabla = new PdfPTable(7);
            tabla.addCell("DNI");
            tabla.addCell("Nombres y apellidos");
            tabla.addCell("Fecha de nacimiento");
            tabla.addCell("Telefono");
            tabla.addCell("Direccion");
            tabla.addCell("Sexo");
            tabla.addCell("Profesion");
            
            List<Docente> docentes = ArchivoJson.leerDocentes(ruta);
            
            for (Docente docente: docentes) {
                tabla.addCell(docente.getDni());
                tabla.addCell(docente.getApeNom());
                tabla.addCell(docente.getFechaNac());
                tabla.addCell(docente.getTelef());
                tabla.addCell(docente.getDireccion());
                tabla.addCell(docente.getSexo());
                tabla.addCell(docente.getSexo());
            }
            documento.add(tabla);
        } catch (DocumentException ex) {
            Logger.getLogger(ReportePdf.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void agregarTablaDocentes(SqlDatos datos){
        try {
            PdfPTable tabla = new PdfPTable(7);
            tabla.addCell("DNI");
            tabla.addCell("Nombres y apellidos");
            tabla.addCell("Fecha de nacimiento");
            tabla.addCell("Telefono");
            tabla.addCell("Direccion");
            tabla.addCell("Sexo");
            tabla.addCell("Profesion");
            
            List<Docente> docentes = TodoSql.obtenerDocentes(datos);
            
            for (Docente docente: docentes) {
                tabla.addCell(docente.getDni());
                tabla.addCell(docente.getApeNom());
                tabla.addCell(docente.getFechaNac());
                tabla.addCell(docente.getTelef());
                tabla.addCell(docente.getDireccion());
                tabla.addCell(docente.getSexo());
                tabla.addCell(docente.getSexo());
            }
            documento.add(tabla);
        } catch (DocumentException ex) {
            Logger.getLogger(ReportePdf.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void cerrarDocumento(){
        documento.close();
    }

}