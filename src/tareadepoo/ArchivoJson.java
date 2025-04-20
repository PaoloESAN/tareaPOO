package tareadepoo;

import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import personal.Alumno;
import personal.Docente;

public class ArchivoJson {
    public static List<Alumno> leerAlumnos(File ruta){
        List<Alumno> resultado = new ArrayList<>();
                    
        File archivo = ruta;

        if (!archivo.exists()) {
            return new ArrayList<>();
        }
        
        JSONArray arreglo;
        
        try {
            String jsonStr = new String(java.nio.file.Files.readAllBytes(archivo.toPath()));
            JSONObject personas = new JSONObject(jsonStr);
            arreglo = personas.getJSONArray("alumnos");


            for (int i = 0; i < arreglo.length(); i++) {
                JSONObject persona = arreglo.getJSONObject(i);
                String dni = persona.getString("dni");
                String apellidosNombres = persona.getString("apellidosNombres");
                String fechaNac = persona.getString("fechaNacimiento");
                String telefono = persona.getString("telefono");
                String direccion = persona.getString("direccion");
                String sexo = persona.getString("sexo");
                Alumno a = new Alumno(dni, apellidosNombres, fechaNac, telefono, direccion, sexo);
                resultado.add(a);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            return resultado;
        }
    }
    
    
    public static List<Docente> leerDocentes(File ruta){
        List<Docente> resultado = new ArrayList<>();
                    
        File archivo = ruta;

        if (!archivo.exists()) {
            return new ArrayList<>();
        }
        
        JSONArray arreglo;
        
        try {
            String jsonStr = new String(java.nio.file.Files.readAllBytes(archivo.toPath()));
            JSONObject personas = new JSONObject(jsonStr);
            arreglo = personas.getJSONArray("docentes");


            for (int i = 0; i < arreglo.length(); i++) {
                JSONObject persona = arreglo.getJSONObject(i);
                String dni = persona.getString("dni");
                String apellidosNombres = persona.getString("apellidosNombres");
                String fechaNac = persona.getString("fechaNacimiento");
                String telefono = persona.getString("telefono");
                String direccion = persona.getString("direccion");
                String sexo = persona.getString("sexo");
                String profesion = persona.getString("profesion");
                Docente a = new Docente(dni, apellidosNombres, fechaNac, telefono, direccion, sexo,profesion);
                resultado.add(a);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            return resultado;
        }
    }
     
     public static void guardarJsonAlumnos(File filename, Alumno alumno) {
         JSONArray alumnos;
         JSONObject personas;

        try {
            File archivo = filename;
            
            if (archivo.exists() && archivo.length() > 0) {
                
                String contenido = new String(Files.readAllBytes(archivo.toPath()));
                
                personas = new JSONObject(contenido);
                alumnos = personas.getJSONArray("alumnos");
            } else {
                
                personas = new JSONObject();
                alumnos = new JSONArray();
                
            }

            JSONObject obj = new JSONObject();
            obj.put("dni", alumno.getDni());
            obj.put("apellidosNombres", alumno.getApeNom());
            obj.put("fechaNacimiento", alumno.getFechaNac());
            obj.put("telefono", alumno.getTelef());
            obj.put("direccion", alumno.getDireccion());
            obj.put("sexo", alumno.getSexo());
            alumnos.put(obj);
            if (!(archivo.exists() && archivo.length() > 0)){
                personas.put("alumnos",alumnos);
            }
            try (FileWriter file = new FileWriter(filename)) {
                file.write(personas.toString(4));
                file.flush();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     
     public static void guardarJsonDocentes(File filename, Docente docente) {
         JSONArray docentes;
         JSONObject personas;

        try {
            File archivo = filename;
            
            if (archivo.exists() && archivo.length() > 0) {
                
                String contenido = new String(Files.readAllBytes(archivo.toPath()));
                
                personas = new JSONObject(contenido);
                docentes = personas.getJSONArray("docentes");
            } else {
                
                personas = new JSONObject();
                docentes = new JSONArray();
                
            }

            JSONObject obj = new JSONObject();
            obj.put("dni", docente.getDni());
            obj.put("apellidosNombres", docente.getApeNom());
            obj.put("fechaNacimiento", docente.getFechaNac());
            obj.put("telefono", docente.getTelef());
            obj.put("direccion", docente.getDireccion());
            obj.put("sexo", docente.getSexo());
            obj.put("profesion", docente.getProfesion());
            docentes.put(obj);
            
            if (!(archivo.exists() && archivo.length() > 0)){
                personas.put("docentes",docentes);
            }
            try (FileWriter file = new FileWriter(filename)) {
                file.write(personas.toString(4));
                file.flush();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void actualizarAlumno(File filename, Alumno alumnoActu){
        try {
            String contenido = new String(Files.readAllBytes(filename.toPath()));
            JSONObject personas = new JSONObject(contenido);
            JSONArray alumnos = personas.getJSONArray("alumnos");

            for (int i = 0; i < alumnos.length(); i++) {
                JSONObject alumno = alumnos.getJSONObject(i);
                if (alumno.getString("dni").equals(alumnoActu.getDni())) {
                        alumno.put("apellidosNombres", alumnoActu.getApeNom());
                        alumno.put("fechaNacimiento", alumnoActu.getFechaNac());
                        alumno.put("telefono", alumnoActu.getTelef());
                        alumno.put("direccion", alumnoActu.getDireccion());
                        alumno.put("sexo", alumnoActu.getSexo());
                    break;
                }
            }

            FileWriter writer = new FileWriter(filename);
            writer.write(personas.toString(4));
            writer.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

     public static void actualizarDocente(File filename, Docente docenteActu){
        try {
            String contenido = new String(Files.readAllBytes(filename.toPath()));
            JSONObject personas = new JSONObject(contenido);
            JSONArray docentes = personas.getJSONArray("docentes");

            for (int i = 0; i < docentes.length(); i++) {
                JSONObject docente = docentes.getJSONObject(i);
                if (docente.getString("dni").equals(docenteActu.getDni())) {
                        docente.put("apellidosNombres", docenteActu.getApeNom());
                        docente.put("fechaNacimiento", docenteActu.getFechaNac());
                        docente.put("telefono", docenteActu.getTelef());
                        docente.put("direccion", docenteActu.getDireccion());
                        docente.put("sexo", docenteActu.getSexo());
                        docente.put("profesion", docenteActu.getProfesion());
                    break;
                }
            }

            FileWriter writer = new FileWriter(filename);
            writer.write(personas.toString(4));
            writer.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     
     public static void eliminarAlumno(File filename, String dni){
            try {
            String contenido = new String(Files.readAllBytes(filename.toPath()));
            JSONObject personas = new JSONObject(contenido);
            JSONArray alumnos = personas.getJSONArray("alumnos");

            for (int i = 0; i < alumnos.length(); i++) {
                JSONObject alumno = alumnos.getJSONObject(i);
                if (alumno.getString("dni").equals(dni)) {
                    alumnos.remove(i);
                    break;
                }
            }

            FileWriter writer = new FileWriter(filename);
            writer.write(personas.toString(4));
            writer.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
     }
     
     public static void eliminarDocente(File filename, String dni){
            try {
            String contenido = new String(Files.readAllBytes(filename.toPath()));
            JSONObject personas = new JSONObject(contenido);
            JSONArray docentes = personas.getJSONArray("docentes");

            for (int i = 0; i < docentes.length(); i++) {
                JSONObject docente = docentes.getJSONObject(i);
                if (docente.getString("dni").equals(dni)) {
                    docentes.remove(i);
                    break;
                }
            }

            FileWriter writer = new FileWriter(filename);
            writer.write(personas.toString(4));
            writer.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
     }
}

