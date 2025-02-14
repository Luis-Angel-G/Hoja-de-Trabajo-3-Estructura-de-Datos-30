import java.util.Arrays;

/**
 * Implementación del algoritmo de ordenamiento por inserción.
 * 
 * @param <T> Tipo de dato que debe ser comparable.
 */
public class InsertionSort<T extends Comparable<T>> implements IGenericSort<T> {

    /**
     * Ordena un arreglo utilizando el algoritmo de ordenamiento por inserción.
     * 
     * @param arr Arreglo de elementos a ordenar.
     * @return Arreglo ordenado.
     */
    @Override
    public T[] sort(T[] arr) {
        for (int i = 1; i < arr.length; i++) {
            T key = arr[i];
            int j = i - 1;

            // Desplazar elementos mayores a la derecha
            while (j >= 0 && arr[j].compareTo(key) > 0) {
                arr[j + 1] = arr[j];
                j--;
            }

            // Insertar el elemento en la posición correcta
            arr[j + 1] = key;
        }
        return arr;
    }
}
