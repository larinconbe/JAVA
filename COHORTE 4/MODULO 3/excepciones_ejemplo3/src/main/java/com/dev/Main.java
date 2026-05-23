package com.dev;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
//import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
//import java.nio.Buffer;

public class Main {
    public static void main(String[] args) {
        // Ejecutar el metodo leerArchivo ---> Recibe parametro nombre del archivo
        // Uso de try catch para controlar el error que se puede generar al no encontrar
        // el archivo
        try {
            // Metodo con el parametro nombre de archivo
            leerArchivo("datos.txt");
            // Si lo lee correctamente imprime las lineas en la terminal y muestra
            // confirmacion de lectura correcta
            System.out.println("Archivo leido correctamente");
            // De lo contrario lanza la excepcion e imprime el mensaje de error
        } catch (IOException e) {
            System.out.println("Error al leer el archivo, " + e.getMessage());
        }
        // Muestra fin del programa
        System.out.println("Fin del programa");

    }

    // Metodo leerArchivo - Parametro Stirng nombreArchivo / Se crea la excepcion en
    // caso de errores:
    // IOException controla errores de: lectura - errores de escritura - errores
    // al cerrar el archivo - permisos
    public static void leerArchivo(String nombreArchivo) throws IOException {

        // Obtener el archivo desde resources
        // Main.class --> Hace referencia a la clase Main.
        // getClassLoader() Obtiene el cargador de clases del proyecto.
        // Ese cargador también sabe buscar archivos dentro de resources.
        // getResourceAsStream(nombreArchivo)
        // Busca el archivo y lo abre como flujo de datos (InputStream). --> permite leer bytes
        // Si encuentra el archivo ---> input != null
        // si no encuentra el archivo --> input == null

        InputStream input = Main.class.getClassLoader().getResourceAsStream(nombreArchivo);
        // Valida si el archivo existe --> input == null 
        if (input == null) {
        // Si no encuentra el archivo lanza la excepcion con el mensaje
            throw new FileNotFoundException("Archivo no encontrado en resources");
        }
        // Si encuentra el archivo --> Crear el lector del archivo
        // InputStreamReader --> Convierte bytes en caracteres.
        // BufferedReader Permite leer texto línea por línea usando readLine()
        BufferedReader lector = new BufferedReader(new InputStreamReader(input));
        // Variable para guardar cada linea --> String linea
        String linea;
        // Lector del archivo linea por linea mientras no sea null
        // Cuando encuentra null, el lector se detiene
        while ((linea = lector.readLine()) != null) {
        // Imprime el contenido
            System.out.println(linea);
        }
        // Cierra el lector
        lector.close();
    }
}