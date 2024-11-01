package KI305.Petriv.Lab6;

/**
 * Клас PaperWaste реалізує паперові відходи як об'єкт для викидання.
 */
public class PaperWaste implements Waste {
    private String type;
    private int weight;

    /**
     * Конструктор
     * @param type тип паперу
     * @param weight вага
     */
    public PaperWaste(String type, int weight) {
        this.type = type;
        this.weight = weight;
    }

    @Override
    public int getSize() {
        return weight;
    }

    @Override
    public String info() {
        return "PaperWaste: type=" + type + ", weight=" + weight;
    }
}
