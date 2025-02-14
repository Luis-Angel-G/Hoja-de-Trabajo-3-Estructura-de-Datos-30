/**
 * Interfaz genérica para algoritmos de ordenamiento.
 * 
 * @param <T> Tipo de dato que debe ser comparable.
 */
public interface IGenericSort<T extends Comparable<T>> {

    /**
     * Ordena un arreglo de elementos comparables.
     * 
     * @param arr Arreglo de elementos a ordenar.
     * @return Arreglo ordenado.
     */
    T[] sort(T[] arr);
}
