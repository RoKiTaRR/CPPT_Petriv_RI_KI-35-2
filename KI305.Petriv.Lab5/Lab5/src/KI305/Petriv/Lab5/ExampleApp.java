package KI305.Petriv.Lab5;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Клас ExampleApp - основний клас для запуску програми та взаємодії з користувачем.
 */
public class ExampleApp {
    public static void main(String[] args) {
        Example eq = new Example();
        System.out.println("Введіть значення x: ");
        try (Scanner in = new Scanner(System.in)) {
            eq.setX(in.nextInt());
            try {
                // Створення об'єкта Writer для збереження результатів
                Writer wr = new Writer(eq.calculate());

                // Запис результату у двійковий файл і зчитування його
                wr.wrBin("Res.bin");
                System.out.println("Результат з двійкового файлу: " + wr.rdBin("Res.bin"));

                // Запис результату у текстовий файл і зчитування його
                wr.wrTxt("Res.txt");
                System.out.println("Результат з текстового файлу: " + wr.rdTxt("Res.txt"));
            } catch (ArithmeticException | IOException ex) {
                System.out.println("Помилка: " + ex.getMessage());
            }
        } catch (InputMismatchException ex) {
            System.out.println("Помилка: введено невірний тип числа");
        }
    }
}
