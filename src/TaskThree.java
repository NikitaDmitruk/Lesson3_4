import java.util.Scanner;

public class TaskThree {
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
            int[] randomNumbers = new int[size];
            for (int i = 0; i < size; i++) {
                randomNumbers[i] = (int) (Math.random() * 100 + 1);
            }
            for (int line : randomNumbers) {
                System.out.print(line + " ");
            }
            int max = randomNumbers[0];
            int indexMaxElement = 0;
            for (int i = 0; i < randomNumbers.length; i++) {
                if (randomNumbers[i] > max) {
                    max = randomNumbers[i];
                    indexMaxElement = i;
                }
            }
            System.out.println("\nМаксимальный элемент массива = " + max + ". Его индекс = " + indexMaxElement);
            int min = randomNumbers[0];
            int indexMinElement = 0;
            for (int i = 0; i < randomNumbers.length; i++) {
                if (randomNumbers[i] < min) {
                    min = randomNumbers[i];
                    indexMinElement = i;
                }
            }
            System.out.println("Минимальный элемент массива = " + min + ". Его индекс = " + indexMinElement);
        } else System.out.println("Вы ввели не целое число!");
    }
}
