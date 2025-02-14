import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 * Clase que genera un archivo de texto con una cantidad determinada de números
 * aleatorios.
 */
public class GeneradorNumeros {
    public static void main(String[] args) {
        int cantidad = 3000; // Número de valores a generar
        String nombreArchivo = "numeros.txt";

        try (FileWriter writer = new FileWriter(nombreArchivo)) {
            Random rand = new Random();

            // Generar números aleatorios y escribirlos en el archivo
            for (int i = 0; i < cantidad; i++) {
                writer.write(rand.nextInt(10000) + "\n"); // Números entre 0 y 9999
            }

            System.out.println("Archivo generado con éxito: " + nombreArchivo);
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo: " + e.getMessage());
        }
    }
}
