import java.util.*;
class øving3{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int subTasks=1;

        while(subTasks!=0){
            System.out.println("Choose subtask");
            System.out.println("1 = multiplication table");
            System.out.println("2 = prime numbers");
            System.out.println("0 = exit");
            subTasks = scanner.nextInt();

            switch(subTasks){
                case 1:
                    multiTable();
                    break;
                case 2:
                    primeNumbers();
                    break;
                case 0:
                    System.out.println("goodbye");
                    break;
                default:
                    System.out.println("Invalid number");
            }
        } 
    }



    static void multiTable(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose start of multiplication");
        int startX = scanner.nextInt();
        System.out.println("Choose end of multiplication");
        int endX = scanner.nextInt();
        System.out.println("Choose the first multiplier");
        int startY = scanner.nextInt();
        System.out.println("Choose the last multiplier");
        int endY = scanner.nextInt();
        System.out.println("Choose error handling. 1 = on, 0 = Off");
        int errorHadling = scanner.nextInt();

        if(errorHadling==1){
            int temp;
            if(startX>endX){
                temp = startX;
                startX = endX;
                endX = temp;
            }
            if(startY>endY){
                temp = startY;
                startY = endY;
                endY = temp;
            }
        }

        for (int i = startX; i < (endX+1); i++) {
            System.out.println("multiplication table for " + i + ":");

            for (int j = startY; j < (endY+1); j++) {
                System.out.println(i + " * " + j + " = " + (i*j));
                
            }
        }
    }




    static void primeNumbers(){

        boolean userSatisfied = false;

        while(userSatisfied == false){
            Scanner scanner = new Scanner(System.in);

            boolean primeEvaluated = false;

            

            while(primeEvaluated == false){
                System.out.println("Select a number above 2 to check if its a prime");
                int numberToCheck = scanner.nextInt();


                if(numberToCheck <= 1){
                    System.out.println("A number below 2 can't be a prime number, try again");
                    primeEvaluated = true;
                }

                for(int i=2; i<numberToCheck; i++){
                    if((numberToCheck%i) == 0){
                        System.out.println("The number " + numberToCheck + " is not a prime number");
                        primeEvaluated = true;
                        break;
                    }
                }

                if(primeEvaluated == false){
                    System.out.println("The number " + numberToCheck + " is a prime number");
                    primeEvaluated = true;
                }
            }

            System.out.println("Do you want to check if new number is prime? 1 = yes, 0 = no");
            int userSatisfaction = scanner.nextInt();
            if(userSatisfaction == 0){
                userSatisfied = true;
            }
        }
    }
}
