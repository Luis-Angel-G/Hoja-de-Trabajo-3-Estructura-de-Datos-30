import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LectorNumeros {
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

    public static void main(String[] args) {
        String nombreArchivo = "numeros.txt";
        List<Integer> numeros = leerNumeros(nombreArchivo);

        // Convertir a arreglo si lo necesitas
        int[] arreglo = numeros.stream().mapToInt(i -> i).toArray();
    }
}