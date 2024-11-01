package KI305.Petriv.Lab3;

import java.io.IOException;
/**
 * Клас PistolDriver є точкою входу для запуску програми, яка демонструє роботу класу Pistol.
 * Головний метод виконує серію дій, що демонструють функціональність пістолета.
 */
public class WaterPistolDriver {
    /**
     * Головний метод.
     *
     * @param args аргументи командного рядка (не використовуються).
     */
    public static void main(String[] args) {
        try {
            WaterPistol waterPistol = new WaterPistol("Super Soaker", 500);

            System.out.println("Початковий рівень води: " + waterPistol.getCurrentWaterLevel());

            waterPistol.fill(300);
            System.out.println("Рівень води після наповнення: " + waterPistol.getCurrentWaterLevel());

            for (int i = 0; i < 5; i++) {
                boolean shotResult = waterPistol.shoot();
                System.out.println("Результат пострілу " + (i+1) + ": " + shotResult);
            }

            System.out.println("Рівень води після пострілів: " + waterPistol.getCurrentWaterLevel());

            waterPistol.fill(1000);
            System.out.println("Рівень води після спроби переповнення: " + waterPistol.getCurrentWaterLevel());

            waterPistol.closeLogger();
        } catch (IOException e) {
            // Обробка помилок, що виникають під час запису в файл
            throw new RuntimeException("Сталася помилка при записі в файл: " + e.getMessage());
        }
    }
}

