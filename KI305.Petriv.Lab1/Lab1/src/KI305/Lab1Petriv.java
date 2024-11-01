package KI305.Petriv.Lab1;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Клас Lab1Petriv реалізує лабораторну роботу №1
 */
public class Lab1Petriv {
    /**
     * Статичний метод main є точкою входу в програму
     *
     * @param args аргументи
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Ввід розміру матриці
        System.out.println("Введіть розмір матриці: ");
        int row = sc.nextInt();

        // Ввід символа заповнювача
        System.out.println("Введіть символ заповнювач: ");
        String symbol = sc.next();

        // Перевірка на валідність символа заповнювача
        if (symbol.length() != 1) {
            System.out.println("Введіть коректний символ заповнювач");
            return;
        }

        String[][] arr = createLengthOfEachSubArr(row);
        String fileName = "Lab1.txt";

        // Запуск бізнес-логіки для генерації зубчастого масиву (виводу в консоль і запису в файл)
        try {
            printMatrix(arr, symbol, row, fileName);
        } catch (IOException e) {
            // Обробка помилки під час запису в файл
            throw new RuntimeException("Сталася помилка під час запису в файл: " + e.getMessage());
        }
    }

    /**
     * Метод який генерує зубчастий масив (виводить в консоль і записує в файл)
     *
     * @param arr масив для заповнення
     * @param symbol символ заповнювач
     * @param row розмір масиву
     * @param file назва файлу
     * @throws IOException якщо сталася якась помилка при запису в файл
     */
    public static void printMatrix(String[][] arr, String symbol, int row, String file) throws IOException {
        System.out.println("Результат матриці: ");
        try (FileWriter writer = new FileWriter(file)) {
            // Логіка для формування зубчастого масиву за варіантом
            for (int i = 0; i < row; i++) {
                // Додаємо відступи перед символами
                for (int space = 0; space < i * 2; space++) {
                    System.out.print(" ");
                    writer.write(" ");
                }
                for (int j = 0; j < row - i; j++) {
                    arr[i][j] = symbol;
                    // Вивід в консоль і запис в файл
                    writer.write(arr[i][j] + " ");
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
                writer.write("\n");
            }
        }
    }

    /**
     * Метод який знаходить для кожного підмасива довжину
     *
     * @param row розмір масива
     * @return String[][] зубчастий масив з налаштованою довжиною підмасивів
     */
    public static String[][] createLengthOfEachSubArr(int row) {
        String[][] arr = new String[row][];
        for (int i = 0; i < row; i++) {
            arr[i] = new String[row - i];
        }
        return arr;
    }
}
