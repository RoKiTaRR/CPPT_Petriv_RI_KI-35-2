package KI305.Petriv.Lab3;

import java.io.IOException;

/**
 * Інтерфейс для об'єктів, які можна наповнювати рідиною.
 */
public interface Fillable {
    /**
     * Наповнює об'єкт рідиною.
     *
     * @param amount кількість рідини для наповнення
     * @return true, якщо наповнення успішне, false в іншому випадку
     */
    boolean fill(int amount) throws IOException;
}
