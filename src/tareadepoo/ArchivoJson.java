package tareadepoo;

import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.json.JSONArray;
import org.json.JSONObject;

public class ArchivoJson {
     public static void guardarJson(String filename, DatosPersona persona, String tipo) {
         JSONArray alumnos;
         JSONArray docentes;
         JSONObject personas;

        try {
            File archivo = new File(filename);
            
            if (archivo.exists() && archivo.length() > 0) {
                
                String contenido = new String(Files.readAllBytes(Paths.get(filename)));
                
                personas = new JSONObject(contenido);
                alumnos = personas.getJSONArray("alumnos");
                docentes = personas.getJSONArray("docentes");
            } else {
                
                personas = new JSONObject();
                docentes = new JSONArray();
                alumnos = new JSONArray();
                
            }

            JSONObject obj = new JSONObject();
            obj.put("dni", persona.Obtener_DNI());
            obj.put("apellidosNombres", persona.Obtener_APENOM());
            obj.put("fechaNacimiento", persona.Obtener_FECNAC());
            obj.put("telefono", persona.Obtener_TELEFONO());
            obj.put("direccion", persona.Obtener_DIRECCION());
            obj.put("sexo", persona.Obtener_SEXO());
            if (tipo.equals("docentes")) {
                obj.put("profesion", persona.Obtener_PROFESION());
                docentes.put(obj);
            }else{
                alumnos.put(obj);
            }
            if (!(archivo.exists() && archivo.length() > 0)){
                personas.put("alumnos",alumnos);
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
}
