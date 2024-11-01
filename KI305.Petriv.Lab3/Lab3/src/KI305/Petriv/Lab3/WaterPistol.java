package KI305.Petriv.Lab3;

import java.io.IOException;

/**
 * Клас WaterPistol розширює клас {@link Pistol} та реалізує інтерфейс {@link Fillable}.
 * Він представляє водяний пістолет з можливістю стріляти водою та наповнювати резервуар водою.
 */
public class WaterPistol extends Pistol implements Fillable {
    private int waterCapacity;
    private int currentWaterLevel;

    /**
     * Конструктор для створення водяного пістолета з вказаною моделлю та ємністю для води.
     *
     * @param model        Модель водяного пістолета
     * @param waterCapacity Ємність для води (в мілілітрах)
     * @throws IOException Якщо виникає помилка при створенні або запису в логер
     */
    public WaterPistol(String model, int waterCapacity) throws IOException {
        super(model);
        this.waterCapacity = waterCapacity;
        this.currentWaterLevel = 0;
        logger.log(String.format("Водяний пістолет %s створено з ємністю %d мл.", this.toString(), waterCapacity));
    }

    /**
     * Виконує постріл водою, якщо в пістолеті є вода.
     *
     * @return true, якщо постріл відбувся успішно; false - якщо немає води або проблема зі спусковим механізмом
     * @throws IOException Якщо виникає помилка при записі в лог-файл
     */
    @Override
    public boolean shoot() throws IOException {
        logger.log("Спроба зробити водяний постріл");
        System.out.println("Спроба зробити водяний постріл");

        if (currentWaterLevel > 0 && trigger.pull()) {
            currentWaterLevel--;
            logger.log("Водяний постріл зроблено успішно");
            System.out.println("Водяний постріл зроблено успішно");
            return true;
        }

        logger.log("Водяний постріл невдалий (немає води або проблема зі спусковим механізмом)");
        System.out.println("Водяний постріл невдалий (немає води або проблема зі спусковим механізмом)");
        return false;
    }

    /**
     * Наповнює водяний пістолет водою.
     *
     * @param amount Кількість води для наповнення (в мілілітрах)
     * @return true, якщо пістолет успішно наповнено; false - якщо кількість води некоректна
     * @throws IOException Якщо виникає помилка при записі в лог-файл
     */
    @Override
    public boolean fill(int amount) throws IOException {
        if (amount <= 0) {
            System.out.println("Кількість води для наповнення має бути більше нуля");
            return false;
        }

        int newWaterLevel = Math.min(currentWaterLevel + amount, waterCapacity);
        int actuallyFilled = newWaterLevel - currentWaterLevel;
        currentWaterLevel = newWaterLevel;

        logger.log(String.format("Додано %d мл води. Поточний рівень: %d мл", actuallyFilled, currentWaterLevel));
        System.out.printf("Додано %d мл води. Поточний рівень: %d мл\n", actuallyFilled, currentWaterLevel);
        return true;
    }

    /**
     * Отримує поточний рівень води у пістолеті.
     *
     * @return Поточний рівень води
     */
    public int getCurrentWaterLevel() {
        return currentWaterLevel;
    }

    /**
     * Отримує ємність водяного пістолета.
     *
     * @return Ємність для води (в мілілітрах)
     */
    public int getWaterCapacity() {
        return waterCapacity;
    }
}
