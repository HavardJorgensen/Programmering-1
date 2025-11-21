import java.util.*;

public class arrangementClient{

    private static void writeList(List<arrangement> list) {
        if (list.isEmpty()) {
            System.out.println("No arrangements found.");
        } else {
            for (arrangement a : list) {
                System.out.println(a);
            }
        }
        System.out.println();
    }

    private static void writeMenu() {
        System.out.println("==== MENU ====");
        System.out.println("1. Register new arrangement");
        System.out.println("2. Find arrangement on location");
        System.out.println("3. find arrangement on date");
        System.out.println("4. find arrangement between two dates");
        System.out.println("5. List all arrangements");
        System.out.println("6. List arrangements sorted by Location");
        System.out.println("7. List arrangements sorted by type");
        System.out.println("8. List arrangements sorted by timestamp");
        System.out.println("0. exit");
        System.out.print("Choice: ");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        arrangementRegistration register = new arrangementRegistration();

        boolean complete = false;
        while (!complete) {
            writeMenu();
            int Choice;
            try {
                Choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid Choice.\n");
                continue;
            }

            switch (Choice) {
                case 1 -> {
                    System.out.print("Number: ");
                    int nr = Integer.parseInt(scanner.nextLine());
                    System.out.print("Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Location: ");
                    String Location = scanner.nextLine();
                    System.out.print("Organizer: ");
                    String organizer = scanner.nextLine();
                    System.out.print("Type: ");
                    String type = scanner.nextLine();
                    System.out.print("Timestamp (yyyyMMddHHmm): ");
                    long timestamp = Long.parseLong(scanner.nextLine());

                    arrangement a = new arrangement(nr, name, Location, organizer, type, timestamp);
                    register.registrer(a);
                    System.out.println("Arrangement registered.\n");
                }
                case 2 -> {
                    System.out.print("Location: ");
                    String Location = scanner.nextLine();
                    writeList(register.findOnlocation(Location));
                }
                case 3 -> {
                    System.out.print("date (yyyyMMdd): ");
                    int date = Integer.parseInt(scanner.nextLine());
                    writeList(register.findOnDate(date));
                }
                case 4 -> {
                    System.out.print("From date (yyyyMMdd): ");
                    int from = Integer.parseInt(scanner.nextLine());
                    System.out.print("To date (yyyyMMdd): ");
                    int to = Integer.parseInt(scanner.nextLine());
                    writeList(register.findBetweenDates(from, to));
                }
                case 5 -> writeList(register.getall());
                case 6 -> writeList(register.sortedBylocation());
                case 7 -> writeList(register.sortedByType());
                case 8 -> writeList(register.sortedByTimestamp());
                case 0 -> {
                    System.out.println("exitting.");
                    complete = true;
                }
                default -> System.out.println("Invalid Choice.\n");
            }
        }

        scanner.close();
    }
}
