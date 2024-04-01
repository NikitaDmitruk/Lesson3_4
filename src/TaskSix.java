import java.util.Scanner;

public class TaskSix {
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
            int[] randomNumbers = new int[size];
            System.out.println("Введите целые элементы массива размерностью " + size + ":");
            for (int i = 0; i < randomNumbers.length; i++) {
                if (scanner.hasNextInt()) {
                    randomNumbers[i] = scanner.nextInt();
                } else {
                    System.out.println("Вы ввели не целое число!");
                    return;
                }
            }
            for (int i = 0; i < randomNumbers.length - 1; i++) {
                if (randomNumbers[i] >= randomNumbers[i + 1]) {
                    System.out.println("Массив не является возрастающей последовательностью!");
                    return;
                }
            }
            System.out.println("Массив является возрастающей последовательностью!");
        } else System.out.println("Вы ввели не целое число!");
    }
}