import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
        Valuta[] valutaer = {
            new Valuta("dollar", 10.50),
            new Valuta("euro",   11.20),
            new Valuta("svenske kroner", 0.93)
        };

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nVelg valuta:");
            System.out.println("1: dollar");
            System.out.println("2: euro");
            System.out.println("3: svenske kroner");
            System.out.println("4: avslutt");
            System.out.print("Ditt valg: ");
            
            int valg;

            do{
                valg = scanner.nextInt();

                if (valg < 1 || valg > 4) {
                    System.out.println("Ugyldig valg.");
                }

            }while(valg < 1 || valg > 4);

            if (valg == 4) {
                System.out.println("Ha det!");
                break;
            }

            Valuta valgtValuta = valutaer[valg - 1];

            System.out.println("\n1) Regn til NOK");
            System.out.println("2) Regn fra NOK");
            System.out.print("Ditt valg: ");
            int retning = scanner.nextInt();

            if (retning == 1) {
                System.out.print("Beløp i " + valgtValuta.getNavn() + ": ");
                double belop = scanner.nextDouble();
                double nok = valgtValuta.tilNok(belop);
                System.out.printf("%.2f %s = %.2f NOK%n", belop, valgtValuta.getNavn(), nok);
            } else if (retning == 2) {
          System.out.println("a");      System.out.print("Beløp i NOK: ");
                double nok = scanner.nextDouble();
                double belop = valgtValuta.fraNok(nok);
                System.out.printf("%.2f NOK = %.2f %s%n", nok, belop, valgtValuta.getNavn());
            } else {
                System.out.println("Ugyldig valg.");
            }
        }
    }
}
