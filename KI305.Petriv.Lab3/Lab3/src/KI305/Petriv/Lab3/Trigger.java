package KI305.Petriv.Lab3;

/**
 * Клас Trigger представляє спусковий механізм пістолета.
 * Він містить інформацію про працездатність механізму та його рівень забруднення.
 */
public class Trigger {
    private boolean operational;
    private int dirtyLevel;

    /**
     * Конструктор створює спусковий механізм, який за замовчуванням працездатний і не забруднений.
     */
    public Trigger() {
        this.operational = true;
        this.dirtyLevel = 0;
    }

    /**
     * Імітує спробу спуску.
     * Метод повертає true, якщо спроба успішна, і false з ймовірністю 5%.
     *
     * @return true, якщо спроба спуску успішна, false - якщо ні
     */
    public boolean pull() {
        return Math.random() > 0.05;
    }

    /**
     * Перевіряє, чи спусковий механізм працездатний.
     *
     * @return true, якщо спусковий механізм працездатний, false - якщо ні
     */
    public boolean isOperational() {
        return operational;
    }

    /**
     * Встановлює новий рівень забруднення спускового механізму.
     *
     * @param dirtyLevel новий рівень забруднення
     */
    public void setDirtyLevel(int dirtyLevel) {
        this.dirtyLevel = dirtyLevel;
    }
}
