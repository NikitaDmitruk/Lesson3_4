import java.util.Scanner;

public class TaskFive {
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
            for (int i = 0; i < size; i++) {
                randomNumbers[i] = (int) (Math.random() * 100 + 1);
            }
            for (int line : randomNumbers) {
                System.out.print(line + " ");
            }
            System.out.println();
            for (int i = 0; i < randomNumbers.length/2; i++) {
                int buffer = randomNumbers[i];
                randomNumbers[i] = randomNumbers[randomNumbers.length-i-1];
                randomNumbers[randomNumbers.length-i-1] = buffer;
            }
            for (int line: randomNumbers) {
                System.out.print(line+" ");
            }
        } else System.out.println("Вы ввели не целое число!");
    }
}