import java.util.*;
class randomIntCount{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int numberCount [] = new int[10];
        System.out.println("Select number of random integers to test");
        int testCount = scanner.nextInt();
        for(int i = 0; i<testCount; i++){
            int randomInt = random.nextInt(10);
            numberCount[randomInt] += 1;
        }
        String star = "*";
        System.out.println("Here are the numbers");
        for (int i = 0; i < 10; i++) {
            System.out.print("Number of " + i + "'s: " + numberCount[i]);
            int starNumber = numberCount[i] / (testCount / 100);
            for(int j = 0; j < starNumber; j++){
                System.out.print(star);
            }
            System.out.println(" starnumber: " + starNumber);
        }
    }
}