package KI305.Petriv.Lab3;

/**
 * Клас Barrel представляє ствол пістолета.
 * Він зберігає довжину ствола та надає методи для доступу та зміни цієї довжини.
 */
public class Barrel {
    private int length;

    /**
     * Конструктор створює ствол з вказаною довжиною.
     *
     * @param length довжина ствола в одиницях виміру (наприклад, в сантиметрах)
     */
    public Barrel(int length) {
        this.length = length;
    }

    /**
     * Отримує довжину ствола.
     *
     * @return довжина ствола в одиницях виміру
     */
    public int getLength() {
        return length;
    }

    /**
     * Встановлює нову довжину ствола.
     *
     * @param length нова довжина ствола в одиницях виміру
     */
    public void setLength(int length) {
        this.length = length;
    }
}
