
import java.util.*;

class øving2{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int subTasks = 1;
        
        while(subTasks!=0){
            System.out.println("Choose sub-task");
            System.out.println("1 = leap year check");
            System.out.println("2 = grocery weight to cost comparison");
            System.out.println("0 = exit");
            subTasks = scanner.nextInt();
            switch (subTasks) {
                case 1:
                    leapYearCheck();
                    break;
                case 2:
                    groceryCost();
                    break;
                case 0:
                    System.out.println("Goodbye");
                    break;

                default:
                    System.out.println("Invalid value");
                    break;
            }
        }
    }


    public static void leapYearCheck() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose year to test");
        int yearToTest = scanner.nextInt();

        boolean leapYear = false;

        if((yearToTest%4)==0){
            if((yearToTest%400)==0){
                leapYear = true;
            } else if((yearToTest%100)==0){
                leapYear = false;
            } else {
                leapYear = true;
            }
        } else {
            leapYear = false;
        }

        if(leapYear == true){
            System.out.println("Yes, the year "+yearToTest+" is a leap year");
        } else if(leapYear == false){
            System.out.println("No, the year "+yearToTest+" is not a leap year");  
        }




    }


    public static void groceryCost() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select number of groceries to compare");
        int groceriesToCompare = scanner.nextInt();

        float cost[] = new float[groceriesToCompare];//{0,0};
        float weight[] = new float[groceriesToCompare];
        float weightToCostNew;
        float weightToCostLowest=0;
        int groceryLowest=0;

        for (int i = 0; i < groceriesToCompare; i++) {
            System.out.println("Enter the cost of grocery "+(i+1)+" in NOK");
            cost[i] = scanner.nextFloat();
            System.out.println("Enter the weight of grocery "+(i+1)+" in kg");
            weight[i] = scanner.nextFloat();
        }

        for (int i = 0; i < groceriesToCompare; i++) {
            weightToCostNew = cost[i] / weight[i];
            System.out.println("Grocery " + (i+1) + " costs " + weightToCostNew + " NOK per kg");

            if(i==0){
                weightToCostLowest = weightToCostNew;
                groceryLowest = i+1;
            } else if(weightToCostNew<weightToCostLowest){
                weightToCostLowest=weightToCostNew;
                groceryLowest = i+1;
            }            
        }


        System.out.println("Grocery " + groceryLowest + " has the lowest cost, it costs " + weightToCostLowest + " NOK per kg");
    }

}