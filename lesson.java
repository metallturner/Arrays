import java.util.Arrays;
import java.util.Scanner;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class lesson {
    public static void main(String[] args) {
        System.out.println("Введите целое число 'n'");
        Scanner console = new Scanner(System.in);
        if (console.hasNextInt()) {                 //делаем проверку на то, что введено целое число
            int n = console.nextInt();
            ToCreateTwoDimensionalArray(n);              //вызываем метод создания двумерного массива
        } else {
            System.out.println("Ведите целое число");

        }
    }

    private static void ToCreateTwoDimensionalArray(int n) {    //метод создания двумерного массива
        int[][] myArr = new int[n][];                    //создаем массив с известным количеством строк(n)
        List<Integer> L = new ArrayList<>();        //создаем список с числами, которые используем для генерации одномерного массива
        for (int i = 1; i < 50; i++) {                //цикл для заполнения списка
            L.add(i);                               // метод добавления элемента в список
        }
        Collections.shuffle(L);                   // применяем метод для перемешивания элементов
        for (int i = 0; i < n; i++) {              //создаем цикл для создания одномерных массивов
            myArr[i] = new int[L.get(i)];      //создаем массив с количеством элементов, которое берем из спика.
            // System.out.println(L.get(i));    // Закомментирована строка для вывода кол-ва элементов в каждом массиве
            ToCreateRandomArray(myArr[i]);        //вызываем метод для заполния массива случайными элементами
            if (i % 2 != 0) {                      //проверяем массив на порядковый номер
                Arrays.sort(myArr[i]);             //сортируем если порядковый номер четный
            } else                                 //иначе сортируем в обратном порядке если порядковый номер нечетный
                ReverseSort(myArr[i]);             //вызываем метод обратной сортировки
        }
        for (int i = 0; i < myArr.length; i++) {          //цикл для вывода двумерного массива
            for (int j = 0; j < myArr[i].length; j++)    //если нужно вывести массив в виде строки, то приеняем метод
                System.out.print(myArr[i][j] + " ");     //System.out.println(Arrays.deepToString(myArr));
            System.out.println();
        }
    }

    private static void ToCreateRandomArray(int[] array) { // метод заполнения одномерного массива случайными числами
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 1000);
        }
    }

    private static void ReverseSort(int[] array1) {        //т.к реверсивная сортровка работает только с обертками,
        Integer[] array = new Integer[array1.length];      //создаем новый массив типа Integer и копируем в него элементы
        for (int i = 0; i < array1.length; i++) {          //массива, который мы передали в параметр метода.
            array[i] = array1[i];                          //Далее после сортировки обратно заменяем элементы в массиве,
        }                                                  //который передавали в параметры.
        Arrays.sort(array, Collections.reverseOrder());
        for (int i = 0; i < array1.length; i++) {
            array1[i] = array[i];
        }
    }
}
//Если нужен больший диапазон количества одномерных массивов, то нужно изменить значение выхода из цикла
// в строке №23 на большее(i<50). По умолчанию значение 50
// Тоже самое касается диапазона случаных чисел в одномерных массивах. Если нужен больший диапазон или меньший
//нужно в строке №45 поменять множитель случайных чисел. По умолчанию значение 1000






