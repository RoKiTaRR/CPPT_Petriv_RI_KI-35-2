package KI305.Petriv.Lab4;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * ExampleApp - головний клас для запуску програми
 */
public class ExampleApp {

    public static void main(String[] args) {
        Example eq = new Example();
        System.out.println("Введіть x у радіанах: ");
        try (Scanner in = new Scanner(System.in)) {
            eq.setX(in.nextDouble());
            try {
                eq.logActivity("Результат: " + eq.calculate());
            } catch (CalcException ex) {
                System.out.println(ex.getMessage());
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }

        } catch (InputMismatchException ex) {
            System.out.println("Помилка: Невірний тип введених даних, введіть число.");
        }
    }
}
