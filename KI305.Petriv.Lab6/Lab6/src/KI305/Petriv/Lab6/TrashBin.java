package KI305.Petriv.Lab6;

import java.util.ArrayList;

/**
 * Параметризований клас TrashBin для зберігання об'єктів сміття.
 */
public class TrashBin<T extends Waste> {
    private ArrayList<T> wasteItems;

    /**
     * Конструктор
     */
    public TrashBin() {
        wasteItems = new ArrayList<>();
    }

    /**
     * Метод для додавання елемента
     * @param item об'єкт для додавання
     */
    public void addWaste(T item) {
        wasteItems.add(item);
    }

    /**
     * Метод для видалення елемента
     */
    public T removeWaste() {
        if (!wasteItems.isEmpty()) {
            return wasteItems.remove(0);
        }
        return null;
    }

    /**
     * Метод для перевірки наявності елементів
     */
    public boolean hasWaste() {
        return !wasteItems.isEmpty();
    }

    /**
     * Метод для пошуку мінімального елементу
     */
    public T findMinWaste() {
        if (wasteItems.isEmpty()) {
            return null;
        }

        T min = wasteItems.get(0);
        for (T item : wasteItems) {
            if (item.getSize() < min.getSize()) {
                min = item;
            }
        }
        return min;
    }

    /**
     * Метод для отримання кількості елементів
     */
    public int getWasteCount() {
        return wasteItems.size();
    }
}
