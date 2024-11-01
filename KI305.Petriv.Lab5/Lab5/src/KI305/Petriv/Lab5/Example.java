package KI305.Petriv.Lab5;

/**
 * Клас Example - обчислює функцію y = sin(3x - 5) / ctg(2x) для введеного значення x.
 */
public class Example {
    private int x;

    // Конструктор за замовчуванням
    public Example() {
        this.x = 0;
    }

    // Конструктор з параметром x
    public Example(int x) {
        this.x = x;
    }

    // Метод для встановлення значення x
    public void setX(int x) {
        this.x = x;
    }

    // Метод для обчислення функції y = sin(3x - 5) / ctg(2x)
    public double calculate() throws ArithmeticException {
        // Перевірка на ділення на нуль
        if (Math.sin(2 * this.x) == 0) {
            throw new ArithmeticException("Помилка: ділення на нуль");
        }
        return Math.sin(3 * this.x - 5) / Math.tan(2 * this.x);
    }
}
