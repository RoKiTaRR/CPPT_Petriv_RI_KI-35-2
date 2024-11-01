package KI305.Petriv.Lab2;

import java.io.IOException;
import java.util.Random;

/**
 * Клас Pistol представляє пістолет з такими компонентами, як ствол, магазин і спусковий механізм.
 * Пістолет має можливість робити постріли, перезаряджати магазин, очищати спусковий механізм та управляти його моделлю.
 * Клас також використовує логер для запису інформації про різні дії та стани пістолета.
 */
public class Pistol {
    private Barrel barrel;
    private Magazine magazine;
    private Trigger trigger;
    private Logger logger;
    private String model;

    /**
     * Конструктор створює пістолет з вказаною моделлю та стандартними компонентами (ствол, магазин, спусковий механізм).
     * Ініціалізує логер для запису дій пістолета.
     *
     * @param model модель пістолета
     * @throws IOException якщо виникає помилка при створенні або запису в логер
     */
    public Pistol(String model) throws IOException {
        this.model = model;
        this.barrel = new Barrel(5);
        this.magazine = new Magazine(5);
        this.trigger = new Trigger();

        this.logger = new Logger("pistol_log.txt");
        logger.log(String.format("Пістолет %s створено.", this.toString()));
    }

    /**
     * Конструктор створює пістолет з заданими компонентами (ствол, магазин, спусковий механізм) та моделлю.
     * Ініціалізує логер для запису дій пістолета.
     *
     * @param barrel ствол пістолета
     * @param magazine магазин пістолета
     * @param trigger спусковий механізм пістолета
     * @param model модель пістолета
     * @throws IOException якщо виникає помилка при створенні або запису в логер
     */
    public Pistol(Barrel barrel, Magazine magazine, Trigger trigger, String model) throws IOException {
        this.barrel = barrel;
        this.magazine = magazine;
        this.trigger = trigger;
        this.model = model;

        this.logger = new Logger("pistol_log.txt");
        logger.log(String.format("Пістолет %s створено.", this.toString()));
    }

    /**
     * Робить постріл, перевіряючи працездатність спускового механізму та наявність патронів у магазині.
     *
     * @return true, якщо постріл успішний, false в іншому випадку
     * @throws IOException якщо виникає помилка при запису в логер
     */
    public boolean shoot() throws IOException {
        logger.log("Спроба зробити постріл");
        System.out.println("Спроба зробити постріл");

        if (!trigger.isOperational()) {
            logger.log("Постріл неможливий: несправний спусковий механізм");
            System.out.println("Постріл неможливий: несправний спусковий механізм");
            return false;
        }

        if (magazine.getBulletsCount() > 0 && trigger.pull()) {
            magazine.removeBullet();
            logger.log("Постріл зроблено успішно");
            System.out.println("Постріл зроблено успішно");
            return true;
        }

        logger.log("Постріл невдалий (немає патронів або осічка)");
        System.out.println("Постріл невдалий (немає патронів або осічка)");
        return false;
    }

    /**
     * Перезаряджає пістолет, додаючи в магазин вказану кількість патронів.
     *
     * @param bulletsCount кількість патронів для перезарядки
     * @throws IllegalArgumentException якщо кількість патронів менше або дорівнює нулю
     * @throws IOException якщо виникає помилка при запису в логер
     */
    public void reload(int bulletsCount) throws IOException {
        if (bulletsCount < 0) {
            logger.log(String.format("Спроба перезарядки з некоректною кількістю патронів: %s", bulletsCount));
            System.out.printf("Спроба перезарядки з некоректною кількістю патронів: %s\n", bulletsCount);
            return;
        }

        logger.log(String.format("Спроба перезарядки з %s патронами", bulletsCount));
        System.out.printf("Спроба перезарядки з %s патронами\n", bulletsCount);

        magazine.reload(bulletsCount);
        logger.log(String.format("Перезарядка завершена. Поточна кількість патронів: %s", magazine.getBulletsCount()));
        System.out.printf("Перезарядка завершена. Поточна кількість патронів: %s\n", magazine.getBulletsCount());
    }

    /**
     * Отримує модель пістолета.
     *
     * @return модель пістолета
     * @throws IOException якщо виникає помилка при запису в логер
     */
    public String getModel() throws IOException {
        logger.log(String.format("Отримано модель пістолета: %s", model));
        System.out.printf("Отримано модель пістолета: %s\n", model);
        return model;
    }

    /**
     * Змінює модель пістолета на нову.
     *
     * @param model нова модель пістолета
     * @throws IOException якщо виникає помилка при запису в логер
     */
    public void changeModel(String model) throws IOException {
        logger.log(String.format("Зміна моделі пістолета з %s на %s", this.model, model));
        System.out.printf("Зміна моделі пістолета з %s на %s\n", this.model, model);
        this.model = model;
    }

    /**
     * Отримує довжину ствола пістолета.
     *
     * @return довжина ствола
     * @throws IOException якщо виникає помилка при запису в логер
     */
    public int getBarrelLength() throws IOException {
        logger.log(String.format("Отримано довжину ствола: %s", barrel.getLength()));
        System.out.printf("Отримано довжину ствола: %s\n", barrel.getLength());
        return barrel.getLength();
    }

    /**
     * Змінює довжину ствола на нову.
     *
     * @param length нова довжина ствола
     * @throws IOException якщо виникає помилка при запису в логер
     */
    public void changeBarrelLength(int length) throws IOException {
        if (length <= 0) {
            logger.log(String.format("Спроба встановити некоректну довжину ствола: %s", length));
            System.out.printf("Спроба встановити некоректну довжину ствола: %s\n", length);
            return;
        }

        logger.log(String.format("Зміна довжини ствола з %s на %s", barrel.getLength(), length));
        System.out.printf("Зміна довжини ствола з %s на %s\n", barrel.getLength(), length);
        barrel.setLength(length);
    }

    /**
     * Отримує ємність магазину пістолета.
     *
     * @return ємність магазину
     * @throws IOException якщо виникає помилка при запису в логер
     */
    public int getMagazineCapacity() throws IOException {
        logger.log(String.format("Отримано ємність магазину: %s", magazine.getCapacity()));
        System.out.printf("Отримано ємність магазину: %s\n", magazine.getCapacity());
        return magazine.getCapacity();
    }

    /**
     * Змінює ємність магазину на нову.
     *
     * @param capacity нова ємність магазину
     * @throws IOException якщо виникає помилка при запису в логер
     */
    public void setMagazineCapacity(int capacity) throws  IOException {
        if (capacity <= 0) {
            logger.log(String.format("Спроба встановити некоректну ємність магазину: %s", capacity));
            System.out.printf("Спроба встановити некоректну ємність магазину: %s\n", capacity);
            return;
        }

        logger.log(String.format("Зміна ємності магазину з %s на %s", magazine.getCapacity(), capacity));
        System.out.printf("Зміна ємності магазину з %s на %s\n", magazine.getCapacity(), capacity);
        magazine.setCapacity(capacity);
    }

    /**
     * Перевіряє, чи є магазин пістолета порожнім.
     *
     * @return true, якщо магазин порожній, false в іншому випадку
     * @throws IOException якщо виникає помилка при запису в логер
     */
    public boolean isMagazineEmpty() throws IOException {
        boolean isEmpty = magazine.getBulletsCount() == 0;
        logger.log(String.format("Перевірка чи магазин порожній: %s", isEmpty));
        System.out.printf("Перевірка чи магазин порожній: %s\n", isEmpty);
        return isEmpty;
    }

    /**
     * Очищає спусковий механізм пістолета.
     *
     * @return true, якщо очищення пройшло успішно, false в іншому випадку
     * @throws IOException якщо виникає помилка при запису в логер
     */
    public boolean cleanTrigger() throws IOException {
        logger.log("Очищення спускового механізму");
        System.out.println("Очищення спускового механізму");

        Random rand = new Random();
        if (rand.nextDouble() < 0.99) {
            trigger.setDirtyLevel(0);
            logger.log("Спусковий механізм успішно очищено");
            System.out.println("Спусковий механізм успішно очищено");
            return true;
        } else {
            logger.log("Виявлено проблеми зі спусковим механізмом під час очищення");
            System.out.println("Виявлено проблеми зі спусковим механізмом під час очищення");
            return false;
        }
    }

    /**
     * Закриває логер для збереження даних у файл.
     *
     * @throws IOException якщо виникає помилка під час закриття логера
     */
    public void closeLogger() throws IOException {
        logger.close();
    }
}
