import java.util.Scanner;

public class TaskWithStar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите целое положительное число для задания размера массива: ");
        if (scanner.hasNextInt()) {
            int size = scanner.nextInt();
            if (size < 1) {
                System.out.println("Вы ввели 0 или отрицательное число!");
                return;
            }
            int[] randomNumbers = new int[size];
            System.out.println("Введите целые элементы массива размерностью " + size + ":");
            for (int i = 0; i < randomNumbers.length; i++) {
                if (scanner.hasNextInt()) {
                    randomNumbers[i] = scanner.nextInt();
                    if (randomNumbers[i] < 0) {
                        System.out.println("Вы ввели отрицательное число!");
                        return;
                    }
                } else {
                    System.out.println("Вы ввели не целое число!");
                    return;
                }
            }
            /* В этой части задаем начальное значение счетчика, который определяет в скольких элементах массива меняется
            разряд числа, если мы прибавим к нему единицу */
            int count = 0;
            for (int i = 0; i < randomNumbers.length; i++) {
                if ((randomNumbers[randomNumbers.length - i - 1] + 1) % 10 == 0) {
                    count = count + 1;
                } else {
                    break;
                }
            }
            /*  В этой части формируем массив с данными, в которых хранится разрядность чисел в массиве, которые сменили
             разряд */
            int[] placeNumber = new int[count];
            int sizeNew = 0;
            for (int i = 0; i < count; i++) {
                int dec = (randomNumbers[randomNumbers.length - i - 1] + 1);
                while (dec != 1) {
                    dec = dec / 10;
                    if (dec == 0) {
                        break;
                    }
                    placeNumber[placeNumber.length - 1 - i] = placeNumber[placeNumber.length - 1 - i] + 1;
                }
            }
            // На сколько нужно увеличить новый массив, для того, чтобы вписать туда 0
            for (int i = 0; i < count; i++) {
                sizeNew = sizeNew + placeNumber[i];
            }
            // Вывод результатов, в зависимости от исходной конструкции массива и данных, которые нужно изменить
            if (count == randomNumbers.length) {
                int[] biggerRandomNumbers = new int[sizeNew + 1];
                biggerRandomNumbers[0] = 1;
                for (int i = 1; i < biggerRandomNumbers.length; i++) {
                    biggerRandomNumbers[i] = 0;
                }
                for (int line : biggerRandomNumbers) {
                    System.out.println(line);
                }
            } else if (count == 0) {
                randomNumbers[randomNumbers.length - 1] = randomNumbers[randomNumbers.length - 1] + 1;
                for (int line : randomNumbers) {
                    System.out.println(line);
                }
            } else {
                int[] biggerRandomNumbers = new int[randomNumbers.length - count + sizeNew];
                for (int i = 0; i < sizeNew; i++) {
                    biggerRandomNumbers[biggerRandomNumbers.length - i - 1] = 0;
                }
                if (randomNumbers.length - count - 1 >= 0)
                    System.arraycopy(randomNumbers, 0, biggerRandomNumbers, 0, randomNumbers.length - count - 1);
                biggerRandomNumbers[randomNumbers.length - count - 1] = randomNumbers[randomNumbers.length - count - 1] + 1;
                for (int line : biggerRandomNumbers) {
                    System.out.println(line);
                }
            }
        } else System.out.println("Вы ввели не целое число!");
    }
}
