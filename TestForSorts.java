import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class TestForSorts {

    public static List<Integer> leerNumeros(String nombreArchivo) {
        List<Integer> numeros = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(nombreArchivo))) {
            while (scanner.hasNextInt()) {
                numeros.add(scanner.nextInt());
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
        return numeros;
    }

    public static <T extends Comparable<T>> long medirTiempo(IGenericSort<T> sortAlgorithm, T[] array) {
        T[] copia = array.clone();
        long startTime = System.nanoTime();
        sortAlgorithm.sort(copia);
        return (System.nanoTime() - startTime);
    }

    public static void main(String[] args) {
        String nombreArchivo = "numeros.txt";
        List<Integer> numerosOriginal = leerNumeros(nombreArchivo);

        int[] tamaños = { 10, 100, 500, 1000, 1500, 2000, 3000 };

        MergeSort<Integer> mergeSort = new MergeSort<>();
        QuickSort<Integer> quickSort = new QuickSort<>();
        BucketSort<Integer> bucketSort = new BucketSort<>();
        InsertionSort<Integer> insertionSort = new InsertionSort<>();
        RadixSort<Integer> radixSort = new RadixSort<>();

        StringBuilder csvData = new StringBuilder();
        csvData.append(
                "Cantidad de Números,MergeSort Desordenado,MergeSort Ordenado,QuickSort Desordenado,QuickSort Ordenado,BucketSort Desordenado,BucketSort Ordenado,InsertionSort Desordenado,InsertionSort Ordenado,RadixSort Desordenado,RadixSort Ordenado\n");

        for (int tamaño : tamaños) {
            Integer[] array = numerosOriginal.subList(0, tamaño).toArray(new Integer[0]);
            Integer[] arrayOrdenado = array.clone();
            Arrays.sort(arrayOrdenado);

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

            csvData.append(tamaño).append(",")
                    .append(tiempoMergeDesordenado).append(",").append(tiempoMergeOrdenado).append(",")
                    .append(tiempoQuickDesordenado).append(",").append(tiempoQuickOrdenado).append(",")
                    .append(tiempoBucketDesordenado).append(",").append(tiempoBucketOrdenado).append(",")
                    .append(tiempoInsertionDesordenado).append(",").append(tiempoInsertionOrdenado).append(",")
                    .append(tiempoRadixDesordenado).append(",").append(tiempoRadixOrdenado).append("\n");
        }

        guardarCSV(csvData.toString(), "tiempos.csv");
    }

    public static void guardarCSV(String data, String nombreArchivo) {
        try (FileWriter writer = new FileWriter(nombreArchivo)) {
            writer.write(data);
            System.out.println("Tiempos guardados en " + nombreArchivo);
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo CSV: " + e.getMessage());
        }
    }
}
