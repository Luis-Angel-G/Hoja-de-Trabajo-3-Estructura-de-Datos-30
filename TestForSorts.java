import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * Clase de prueba que compara el rendimiento de diferentes algoritmos de
 * ordenamiento
 * sobre una lista de números leída desde un archivo. Los algoritmos comparados
 * son:
 * MergeSort, QuickSort, BucketSort, InsertionSort y RadixSort.
 * Los tiempos de ejecución se guardan en un archivo CSV para su posterior
 * análisis.
 */
public class TestForSorts {

    /**
     * Lee una lista de números enteros desde un archivo de texto.
     * Cada número en el archivo debe estar separado por espacios, saltos de línea o
     * tabulaciones.
     * 
     * @param nombreArchivo El nombre del archivo que contiene los números.
     * @return Una lista de números enteros leídos desde el archivo.
     */
    public static List<Integer> leerNumeros(String nombreArchivo) {
        List<Integer> numeros = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(nombreArchivo))) {
            // Leemos cada número entero del archivo y lo agregamos a la lista.
            while (scanner.hasNextInt()) {
                numeros.add(scanner.nextInt());
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
        return numeros;
    }

    /**
     * Mide el tiempo que tarda en ejecutar el algoritmo de ordenamiento en el
     * arreglo proporcionado.
     * 
     * @param sortAlgorithm El algoritmo de ordenamiento a medir.
     * @param array         El arreglo de elementos a ordenar.
     * @param <T>           El tipo de los elementos del arreglo.
     * @return El tiempo en nanosegundos que tardó en ejecutar el algoritmo de
     *         ordenamiento.
     */
    public static <T extends Comparable<T>> long medirTiempo(IGenericSort<T> sortAlgorithm, T[] array) {
        T[] copia = array.clone();
        long startTime = System.nanoTime();
        sortAlgorithm.sort(copia); // Ordenamos el arreglo.
        return (System.nanoTime() - startTime); // Calculamos el tiempo transcurrido.
    }

    /**
     * Método principal que ejecuta las pruebas de rendimiento de los algoritmos de
     * ordenamiento.
     * Lee los números desde un archivo, ejecuta los algoritmos y guarda los tiempos
     * de ejecución en un archivo CSV.
     * 
     * @param args Argumentos de la línea de comandos (no utilizados en este caso).
     */
    public static void main(String[] args) {
        // Nombre del archivo que contiene los números.
        String nombreArchivo = "numeros.txt";
        List<Integer> numerosOriginal = leerNumeros(nombreArchivo);

        // Diferentes tamaños de arreglos para las pruebas de rendimiento.
        int[] tamaños = { 10, 100, 500, 1000, 1500, 2000, 3000 };

        // Instanciamos los diferentes algoritmos de ordenamiento.
        MergeSort<Integer> mergeSort = new MergeSort<>();
        QuickSort<Integer> quickSort = new QuickSort<>();
        BucketSort<Integer> bucketSort = new BucketSort<>();
        InsertionSort<Integer> insertionSort = new InsertionSort<>();
        RadixSort<Integer> radixSort = new RadixSort<>();

        // Construimos el encabezado del archivo CSV con los nombres de las columnas.
        StringBuilder csvData = new StringBuilder();
        csvData.append(
                "Cantidad de Números,MergeSort Desordenado,MergeSort Ordenado,QuickSort Desordenado,QuickSort Ordenado,BucketSort Desordenado,BucketSort Ordenado,InsertionSort Desordenado,InsertionSort Ordenado,RadixSort Desordenado,RadixSort Ordenado\n");

        // Realizamos las pruebas para cada tamaño de arreglo.
        for (int tamaño : tamaños) {
            Integer[] array = numerosOriginal.subList(0, tamaño).toArray(new Integer[0]);
            Integer[] arrayOrdenado = array.clone();
            Arrays.sort(arrayOrdenado); // Ordenamos el arreglo para la prueba de algoritmo ordenado.

            // Medimos los tiempos de ejecución para los arreglos desordenados y ordenados.
            long tiempoMergeDesordenado = medirTiempo(mergeSort, array);
            long tiempoMergeOrdenado = medirTiempo(mergeSort, arrayOrdenado);

            long tiempoQuickDesordenado = medirTiempo(quickSort, array);
            long tiempoQuickOrdenado = medirTiempo(quickSort, arrayOrdenado);

            long tiempoBucketDesordenado = medirTiempo(bucketSort, array);
            long tiempoBucketOrdenado = medirTiempo(bucketSort, arrayOrdenado);

            long tiempoInsertionDesordenado = medirTiempo(insertionSort, array);
            long tiempoInsertionOrdenado = medirTiempo(insertionSort, arrayOrdenado);

            long tiempoRadixDesordenado = medirTiempo(radixSort, array);
            long tiempoRadixOrdenado = medirTiempo(radixSort, arrayOrdenado);

            // Agregamos los resultados de los tiempos al CSV.
            csvData.append(tamaño).append(",")
                    .append(tiempoMergeDesordenado).append(",").append(tiempoMergeOrdenado).append(",")
                    .append(tiempoQuickDesordenado).append(",").append(tiempoQuickOrdenado).append(",")
                    .append(tiempoBucketDesordenado).append(",").append(tiempoBucketOrdenado).append(",")
                    .append(tiempoInsertionDesordenado).append(",").append(tiempoInsertionOrdenado).append(",")
                    .append(tiempoRadixDesordenado).append(",").append(tiempoRadixOrdenado).append("\n");
        }

        // Guardamos los resultados en un archivo CSV.
        guardarCSV(csvData.toString(), "tiempos.csv");
    }

    /**
     * Guarda los datos proporcionados en un archivo CSV.
     * 
     * @param data          Los datos a guardar en formato CSV.
     * @param nombreArchivo El nombre del archivo CSV donde se guardarán los datos.
     */
    public static void guardarCSV(String data, String nombreArchivo) {
        try (FileWriter writer = new FileWriter(nombreArchivo)) {
            writer.write(data); // Escribimos los datos en el archivo.
            System.out.println("Tiempos guardados en " + nombreArchivo);
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo CSV: " + e.getMessage());
        }
    }
}
