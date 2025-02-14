import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Clase para leer números desde un archivo de texto.
 */
public class LectorNumeros {

    /**
     * Lee los números de un archivo y los almacena en una lista.
     * 
     * @param nombreArchivo Nombre del archivo a leer.
     * @return Lista de números enteros leídos del archivo.
     */
    public static List<Integer> leerNumeros(String nombreArchivo) {
        List<Integer> numeros = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File(nombreArchivo))) {
            while (scanner.hasNextInt()) {
                numeros.add(scanner.nextInt());
            }
            System.out.println("Se han leído " + numeros.size() + " números del archivo.");
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }

        return numeros;
    }

    /**
     * Método principal para probar la lectura de números desde un archivo.
     * 
     * @param args Argumentos de la línea de comandos.
     */
    public static void main(String[] args) {
        String nombreArchivo = "numeros.txt";
        List<Integer> numeros = leerNumeros(nombreArchivo);

        // Convertir la lista a un arreglo si es necesario
        int[] arreglo = numeros.stream().mapToInt(i -> i).toArray();
    }
}
