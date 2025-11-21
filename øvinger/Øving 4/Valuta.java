
class Valuta {
    private final String navn;
    private final double nokPerEnhet;

    public Valuta(String navn, double nokPerEnhet) {
        this.navn = navn;
        this.nokPerEnhet = nokPerEnhet;
    }

    public String getNavn() { return navn; }

    public double tilNok(double belop) {
        return belop * nokPerEnhet;
    }

    public double fraNok(double belop) {
        return belop / nokPerEnhet;
    }
}
