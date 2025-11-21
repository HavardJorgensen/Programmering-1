public class Hundre {
    public static void main(String[] args) {
        Spiller a = new Spiller("A");
        Spiller b = new Spiller("B");

        int runde = 1;
        while (true) {
            System.out.printf("Runde %d%n", runde++);

            spillTrekk(a);
            if (a.erFerdig()) {
                System.out.printf("Spiller %s har vunnet!%n", a.getNavn());
                break;
            }

            spillTrekk(b);
            if (b.erFerdig()) {
                System.out.printf("Spiller %s har vunnet!%n", b.getNavn());
                break;
            }

            System.out.println();
        }
    }

    private static void spillTrekk(Spiller navn) {
        int kast = navn.kastTerningen();
        System.out.printf("Spiller %s kaster %d → sum=%d%n", navn.getNavn(), kast, navn.getSumPoeng());
    }
}
