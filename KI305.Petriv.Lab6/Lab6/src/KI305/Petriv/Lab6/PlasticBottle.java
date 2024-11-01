package KI305.Petriv.Lab6;

/**
 * Клас PlasticBottle реалізує пластикову пляшку як об'єкт для викидання.
 */
public class PlasticBottle implements Waste {
    private int volume;

    /**
     * Конструктор
     * @param volume об'єм пляшки
     */
    public PlasticBottle(int volume) {
        this.volume = volume;
    }

    @Override
    public String info() {
        return "PlasticBottle: volume=" + volume;
    }

    @Override
    public int getSize() {
        return volume;
    }
}
