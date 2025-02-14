import java.util.Arrays;

/**
 * Implementación del algoritmo de ordenamiento Radix Sort para una lista de
 * elementos genéricos.
 * Este algoritmo ordena los elementos basándose en sus dígitos, desde el menos
 * significativo hasta el más significativo.
 * Funciona bien con números enteros representados como objetos comparables.
 *
 * @param <T> El tipo de los elementos del arreglo, debe ser Comparable.
 */
public class RadixSort<T extends Comparable<T>> implements IGenericSort<T> {

    /**
     * Ordena un arreglo usando el algoritmo Radix Sort.
     * 
     * @param arr El arreglo de elementos a ordenar.
     * @return El arreglo ordenado.
     */
    @Override
    public T[] sort(T[] arr) {
        // Si el arreglo está vacío, no es necesario ordenar.
        if (arr.length == 0)
            return arr;

        int n = arr.length;
        // Encontramos el valor máximo en el arreglo para determinar el número de
        // dígitos.
        T max = findMax(arr);

        // Realizamos el conteo por cada dígito (exp es el exponente que va de menos
        // significativo a más significativo).
        for (int exp = 1; Integer.parseInt(max.toString()) / exp > 0; exp *= 10) {
            // Ordenamos los elementos por el dígito actual usando el método countSort.
            countSort(arr, n, exp);
        }

        return arr;
    }

    /**
     * Encuentra el valor máximo en el arreglo.
     * 
     * @param arr El arreglo de elementos en el que buscamos el máximo.
     * @return El valor máximo encontrado en el arreglo.
     */
    private T findMax(T[] arr) {
        // Inicializamos el máximo con el primer elemento del arreglo.
        T max = arr[0];
        // Iteramos por todos los elementos del arreglo para encontrar el máximo.
        for (T num : arr) {
            if (num.compareTo(max) > 0) {
                max = num;
            }
        }
        return max;
    }

    /**
     * Ordena el arreglo por un dígito específico usando el algoritmo de
     * ordenamiento de conteo (Counting Sort).
     * 
     * @param arr El arreglo de elementos a ordenar.
     * @param n   El tamaño del arreglo.
     * @param exp El exponente que representa el dígito a ordenar (1 para el primer
     *            dígito, 10 para el siguiente, etc.).
     */
    private void countSort(T[] arr, int n, int exp) {
        // Creamos un arreglo de salida para almacenar los elementos ordenados.
        T[] output = Arrays.copyOf(arr, n);
        // Creamos un arreglo de conteo para las 10 posibles cifras (0-9).
        int[] count = new int[10];

        // Llenamos el arreglo de conteo según el dígito en el exponente actual.
        for (T num : arr) {
            // Obtenemos el dígito correspondiente al exponente actual.
            int index = (Integer.parseInt(num.toString()) / exp) % 10;
            count[index]++;
        }

        // Modificamos el arreglo de conteo para que cada posición contenga la cantidad
        // acumulada de elementos.
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Construimos el arreglo de salida de forma ordenada de acuerdo a los dígitos
        // procesados.
        for (int i = n - 1; i >= 0; i--) {
            // Obtenemos el dígito correspondiente al exponente actual.
            int index = (Integer.parseInt(arr[i].toString()) / exp) % 10;
            output[count[index] - 1] = arr[i];
            count[index]--;
        }

        // Copiamos los elementos ordenados de vuelta al arreglo original.
        System.arraycopy(output, 0, arr, 0, n);
    }

}
