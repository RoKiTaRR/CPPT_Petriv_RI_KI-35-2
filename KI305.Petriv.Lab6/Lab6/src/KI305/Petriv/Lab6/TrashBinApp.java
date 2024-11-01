package KI305.Petriv.Lab6;

/**
 * Клас TrashBinApp для тестування TrashBin.
 */
public class TrashBinApp {
    public static void main(String[] args) {
        TrashBin<PlasticBottle> bottleBin = new TrashBin<>();
        bottleBin.addWaste(new PlasticBottle(500));
        bottleBin.addWaste(new PlasticBottle(750));
        bottleBin.addWaste(new PlasticBottle(250));

        TrashBin<PaperWaste> paperBin = new TrashBin<>();
        paperBin.addWaste(new PaperWaste("Newspaper", 200));
        paperBin.addWaste(new PaperWaste("Magazine", 150));
        paperBin.addWaste(new PaperWaste("Cardboard", 500));

        Waste minBottle = bottleBin.findMinWaste();
        System.out.println(minBottle.info());

        Waste minPaper = paperBin.findMinWaste();
        System.out.println(minPaper.info());
    }
}
