/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import conexion_http.ConexionHTTP;
import java.io.IOException;
import modelos.Carbono;
import serviciojson.JsonService;

/**
 *
 * @author alejandro
 */
public class Main {
    public static void main(String[] args) throws  IOException {
        final String LINK = "https://api.websitecarbon.com/site?url=";
        //Hay que pedirlo por teclado bobo
        String enlace = "maralboran.eu";
        
        //Link que nos dará el fichero json
        String ultimo = LINK + enlace;
        
        String ruta = ConexionHTTP.peticionHttpGet(ultimo);
        System.out.println(ruta);
        
        Carbono carbono = (Carbono) JsonService.stringToPojo(ruta, Carbono.class);
        System.out.println(carbono);
    }
}
