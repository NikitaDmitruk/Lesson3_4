import java.util.Scanner;

public class TaskFour {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите простое целое число для задания размера массива: ");
        if (scanner.hasNextInt()) {
            int size = scanner.nextInt();
            if ((size % 2 == 0 && size != 2) || size < 2) {
                System.out.println("Вы ввели не простое число!");
                return;
            } else {
                for (int i = 3; i <= Math.sqrt(size); i = i + 2) {
                    if (size % i == 0) {
                        System.out.println("Вы ввели не простое число!");
                        return;
                    }
                }
            }
            System.out.println("Число " + size + " простое!");
            int[] inputNumbers = new int[size];
            System.out.println("Введите целые элементы массива размерностью " + size + ":");
                for (int i = 0; i < inputNumbers.length; i++) {
                    if (scanner.hasNextInt()) {
                    inputNumbers[i] = scanner.nextInt();
                } else {
                        System.out.println("Вы ввели не целое число!");
                        return;
                    }
            }
            int countZero = 0;
            for (int i = 0; i < inputNumbers.length; i++) {
                if (inputNumbers[i] == 0) {
                    countZero = countZero + 1;
                }
            }
            if (countZero == 0) {
                System.out.println("В массиве отсутствуют элементы равные нулю!");
            } else {
                System.out.println("Количество элементов равных нулю равно " + countZero);
            }
        } else System.out.println("Вы ввели не целое число!");
    }
}
