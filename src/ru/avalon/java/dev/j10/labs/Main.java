package ru.avalon.java.dev.j10.labs;

import ru.avalon.java.dev.j10.labs.initialization.FibonacciInitializer;
import ru.avalon.java.dev.j10.labs.initialization.RandomInitializer;
import ru.avalon.java.dev.j10.labs.sort.BubbleSort;
import ru.avalon.java.dev.j10.labs.sort.SelectionSort;
import ru.avalon.java.dev.j10.labs.sort.ShellSort;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] array = new int[20];

	    /*
	     * TODO(Студент): Выполнить действия над массивом чисел
	     *
	     * 0. Создать массив из 20 целых чисел и адресовать
	     *    его с сохранить ссылку в переменную array.
	     *
	     * 1. Проинициализировать массив значениями
	     *    последовательности чисел Фибоначчи.
	     *
	     * 2. Найти сумму элементов массива.
	     *
	     * 3. Проинициализировать массив последовательностью
	     *    случайных чисел в диапазоне от -50 до 50.
	     *
	     * 4. Отсортировать массив с использованием
	     *    пузырьковой сортировки.
	     *
         * 5. Проинициализировать массив последовательностью
         *    случайных чисел в диапазоне от -50 до 50.
         *
         * 6. Отсортировать массив с использованием
         *    сортировки выбором.
         *
         * 7. Проинициализировать массив последовательностью
         *    случайных чисел в диапазоне от -50 до 50.
         *
         * 8. Отсортировать массив с использованием
         *    сортировки Шелла.
	     */

	    // 1
		new FibonacciInitializer().initialize(array);
		System.out.println("Array was initialized by Fibonacci numbers: " + Arrays.toString(array));

		// 2
		System.out.println("Sum of array's elements: " + sumOfArray(array));

		// 3
		initializeByRandomNumbers(array);

		// 4
		new BubbleSort().sort(array);
		System.out.println("Array was sorted by bubble sort: " + "\t\t\t" + Arrays.toString(array));

		// 5
		initializeByRandomNumbers(array);

		// 6
		new SelectionSort().sort(array);
		System.out.println("Array was sorted by selection sort:" + "\t\t\t" + Arrays.toString(array));

		// 7
		initializeByRandomNumbers(array);

		// 8
		new ShellSort().sort(array);
		System.out.println("Array was sorted by Shell sort: " + "\t\t\t" + Arrays.toString(array));
    }

    public static int sumOfArray(int[] array){
    	if (array == null)
    		return -1;

    	int sum = 0;
    	for (int currentValue: array)
    		sum += currentValue;

    	return sum;
	}

	public static void initializeByRandomNumbers(int[] array){
		new RandomInitializer(-50, 50).initialize(array);
		System.out.println("\nArray was initialized by random numbers: " + "\t" + Arrays.toString(array));
	}
}
