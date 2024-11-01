package KI305.Petriv.Lab2;

import java.io.IOException;
/**
 * Клас PistolDriver є точкою входу для запуску програми, яка демонструє роботу класу Pistol.
 * Головний метод виконує серію дій, що демонструють функціональність пістолета.
 */
public class PistolDriver {
    /**
     * Головний метод.
     *
     * @param args аргументи командного рядка (не використовуються).
     */
    public static void main(String[] args) {
        try {
            Pistol pistol = new Pistol("Glock 17");
            pistol.shoot();
            pistol.reload(2);
            pistol.getModel();
            pistol.changeModel("Glock 19");
            pistol.getBarrelLength();
            pistol.changeBarrelLength(6);
            pistol.getMagazineCapacity();
            pistol.setMagazineCapacity(10);
            pistol.isMagazineEmpty();
            pistol.cleanTrigger();

            pistol.closeLogger();
        } catch (IOException e) {
            // Обробка помилок, що виникають під час запису в файл
            throw new RuntimeException("Сталася помилка при записі в файл: " + e.getMessage());
        }
    }
}
