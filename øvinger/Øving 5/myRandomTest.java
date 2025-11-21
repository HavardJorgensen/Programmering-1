public class myRandomTest{
    public static void main(String[] args) {
        myRandom myRand = new myRandom();

        for (int i = 0; i < 10; i++) {
            int tall = myRand.nextInteger(10, 20);
            System.out.println(tall);
        }
        for (int i = 0; i < 10; i++) {
            double tall = myRand.nextDecimal(0.0, 5.0);
            System.out.println(tall);
        }
    }
}