package ru.avalon.java.dev.j10.labs.initialization;

import ru.avalon.java.dev.j10.labs.Initializer;

/**
 * Инициализатор, выполняющий инициализацию массива
 * значениями последовательности случайных чисел.
 *
 * <p>Экземпляры класса можно использовать многократно для
 * инициализации любого числа массивов.
 *
 * <p>Диапазон, в пределах которого будут получены случайные
 * значения, передаётся в конструктор класса при
 * инициализации.
 */
public class RandomInitializer implements Initializer {

    /**
     * Выполняет инициализацию массива, значениями
     * последовательности случайных чисел.
     *
     * @param array массив, подлежащий инициализации
     */
    private int bottomLimit;
    private int topLimit;

    public RandomInitializer(int bottomLimit, int topLimit){
        this.bottomLimit = bottomLimit;
        this.topLimit = topLimit;
    }

    public void initialize(int[] array) {
        /*
         * TODO(Студент): Реализовать метод initialize класса RandomInitializer
         */
        if (array != null)
            for (int i = 0; i < array.length; i++)
                array[i] = generate();
    }

    private int generate(){
        int moduleOfBottomLimit = (bottomLimit < 0) ? -bottomLimit : bottomLimit;
        int moduleOfTopLimit = (topLimit < 0) ? -topLimit : topLimit;
        int sumOfLimits = moduleOfBottomLimit + moduleOfTopLimit;

        return (int)(Math.random()*(sumOfLimits + 1)) - moduleOfBottomLimit;
    }
}
