package ru.avalon.java.dev.j10.labs.sort;

import ru.avalon.java.dev.j10.labs.Sort;

/**
 * Сортировка Шелла (англ. Shell sort).
 *
 * <p>Алгоритм сортировки, являющийся усовершенствованным
 * вариантом сортировки вставками. Идея метода Шелла состоит
 * в сравнении элементов, стоящих не только рядом, но и на
 * определённом расстоянии друг от друга. Иными словами —
 * это сортировка вставками с предварительными «грубыми»
 * проходами. Аналогичный метод усовершенствования
 * пузырьковой сортировки называется сортировка расчёской.
 *
 * @see <a href="https://ru.wikipedia.org/wiki/%D0%A1%D0%BE%D1%80%D1%82%D0%B8%D1%80%D0%BE%D0%B2%D0%BA%D0%B0_%D0%A8%D0%B5%D0%BB%D0%BB%D0%B0">Сортировка Шелла</a>
 */
public class ShellSort implements Sort {

    /**
     * {@inheritDoc}
     */
    private int currentPositionInInputArray; // Текущая позиция во входном массиве
    private int distance; // Промежуток между сортируемыми элементами
    private int[] array;  // Ссылка на входной массив

    public void sort(int[] inputArray) {
        /*
         * TODO(Студент): Реализовать метод sort класса ShellSort
         */
        array = inputArray;
        if (array == null)
            return;

        distance = array.length/2;

        while (distance > 1){
            makeOneIteration();
            distance /= 2;
        }

        new SelectionSort().sort(array); // Процесс завершается обычной сортировкой вставками получившегося массива.
    }

    // Выполняем один шаг
    private void makeOneIteration(){
        int[][] subarrays = splitIntoSortingSubarrays(); // Разбиваем входной массив на отсортированные подмассивы.
        mergeSubbarays(subarrays); // Объединяем подмассивы в один
    }

    private int[][] splitIntoSortingSubarrays(){
        int[][] subarrays = new int[distance][];

        for (int i = 0; i < distance; i++){
            subarrays[i] = createSubarrays(i); // Определяем размер подмассива и создаем его
            initializeSubarray(subarrays[i]); // Инициализируем подмассив

            new SelectionSort().sort(subarrays[i]); // Сортируем методом вставок
        }

        return subarrays;
    }

    // Определяем размер подмассива и создаем его
    private int[] createSubarrays(int numberOfSubarray){
        int sizeOfSubarray = (array.length - currentPositionInInputArray) / distance;
        currentPositionInInputArray = numberOfSubarray;

        return new int[sizeOfSubarray];
    }

    // Инициализируем подмассив
    private void initializeSubarray(int[] subarray){
        for (int j = 0; j < subarray.length; j++) {
            subarray[j] = array[currentPositionInInputArray];
            currentPositionInInputArray += distance;
        }
    }

    // Объединяем подмассивы в один
    private void mergeSubbarays(int[][] subarrays){
        currentPositionInInputArray = 0;

        for (int i = 0; i < subarrays.length; i++) {
            for (int j = 0; j < subarrays[i].length; j++)
                array[currentPositionInInputArray++] = subarrays[i][j];
        }
    }
}
