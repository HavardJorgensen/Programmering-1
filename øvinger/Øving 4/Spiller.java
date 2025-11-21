import java.util.Random;

public class Spiller {
    private final String navn;
    private final Random terning = new Random();
    private int sumPoeng = 0;

    public Spiller(String navn) {
        this.navn = navn;
    }

    public String getNavn() {
        return navn;
    }

    public int getSumPoeng() {
        return sumPoeng;
    }

    public boolean erFerdig() {
        return sumPoeng >= 100;
    }


    public int kastTerningen() {
        int kast = terning.nextInt(6) + 1; 

        if (kast == 1) {
            sumPoeng = 0;  
        } else {
            sumPoeng += kast;
        }

        return kast;
    }
}
