import java.util.*;

class øving1{

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);   
        int subTasks=1;
        while(subTasks!=0){
            System.out.println("Choose program");
            System.out.println("1 = inches to cm");
            System.out.println("2 = time into seconds");
            System.out.println("3 = seconds into time");
            System.out.println("0 = exit");
            subTasks= scanner.nextInt();

            switch (subTasks) {
                case 1:
                    oppgaveEn();
                    break;
                case 2:
                    oppgaveTo();
                    break;
                case 3:
                    oppgaveTre();
                    break;
                case 0:
                    System.out.println("goodbye");
                    break;

                default:
                    System.out.println("Pick a number between 0 and 3");
                    break;
            }
        }
    }
    public static void oppgaveEn() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input length in inches");
        double length_inch = scanner.nextDouble();
        double length_cm = length_inch * 2.54;
        System.out.println("The length in cm is: " + length_cm);
    }
    public static void oppgaveTo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input hours");
        Integer hours = scanner.nextInt();
        System.out.println("Input minutes");
        Integer minutes = scanner.nextInt();                
        System.out.println("Input seconds");
        Integer seconds = scanner.nextInt();
        Integer totalSeconds = (hours*3600 + minutes * 60 + seconds);
        System.out.println("total time in seconds equals: " + totalSeconds);

    }
    public static void oppgaveTre() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input seconds to calculate");
        Integer totalTime = scanner.nextInt();
        Integer seconds = totalTime%60;
        Integer minutes = (totalTime/60)%60;
        Integer hours = totalTime/3600;
        System.out.println("seconds: " + seconds);
        System.out.println("minutes: " + minutes);
        System.out.println("hours: " + hours);
    }
}