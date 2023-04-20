
package conexion_http;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class ConexionHTTP {

    // Este método obtiene en un String la respuesta html completa
    public static String peticionHttpGet(String stringUrl) throws IOException {
        StringBuilder texto = new StringBuilder();
        URL url = new URL(stringUrl);
        
        HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
        conexion.setRequestMethod("GET");
        
        try (Scanner flujo = new Scanner(new InputStreamReader(conexion.getInputStream()))){
            while (flujo.hasNextLine()) {                
                texto.append(flujo.nextLine()).append( "\n");
            }
        }
        
        return texto.toString();
    }
}
