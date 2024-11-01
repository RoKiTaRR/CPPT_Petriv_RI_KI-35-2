package KI305.Petriv.Lab3;

/**
 * Клас Magazine представляє магазин пістолета, який зберігає кількість патронів і ємність.
 * Він надає методи для перезарядки, видалення патронів та доступу до кількості патронів і ємності магазину.
 */
public class Magazine {
    private int capacity;
    private int bulletsCount;

    /**
     * Конструктор створює магазин з вказаною ємністю.
     * Початкова кількість патронів у магазині дорівнює 0.
     *
     * @param capacity ємність магазину (максимальна кількість патронів)
     */
    public Magazine(int capacity) {
        this.capacity = capacity;
        this.bulletsCount = 0;
    }

    /**
     * Перезаряджає магазин новою кількістю патронів.
     * Кількість патронів не перевищує ємність магазину.
     *
     * @param count кількість патронів для перезарядки
     */
    public void reload(int count) {
        this.bulletsCount = Math.min(count, capacity);
    }

    /**
     * Видаляє один патрон з магазину.
     * Якщо магазин порожній, нічого не робить.
     */
    public void removeBullet() {
        if (bulletsCount > 0) {
            bulletsCount--;
        }
    }

    /**
     * Отримує ємність магазину.
     *
     * @return ємність магазину
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Встановлює нову ємність магазину.
     *
     * @param capacity нова ємність магазину
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    /**
     * Отримує кількість патронів у магазині.
     *
     * @return кількість патронів у магазині
     */
    public int getBulletsCount() {
        return bulletsCount;
    }
}
