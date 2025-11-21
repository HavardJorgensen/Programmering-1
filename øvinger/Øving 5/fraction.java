import java.util.*;

public class fraction{

    private int numerator;
    private int denominator;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int choiceA;
        do{
            System.out.println("Do you want to do an operation to fractions");
            System.out.println("1 = yes");
            System.out.println("0 = no");
            choiceA = scanner.nextInt();
            if(choiceA == 1){
                System.out.println("Enter first numerator");
                int numA = scanner.nextInt();
                System.out.println("Enter first denominator");
                int denomA = scanner.nextInt();
                System.out.println("Enter second numerator");
                int numB = scanner.nextInt();
                System.out.println("Enter second denominator");
                int denomB = scanner.nextInt();

                fraction a = new fraction(numA, denomA);
                fraction b = new fraction(numB, denomB);

                System.out.println("You chose the fraction" + a + "and" + b);

                int choiceB;
                do{
                    System.out.println("what do you want to do with the fractions?");
                    System.out.println("1 = add the second fraction to the first fraction");
                    System.out.println("2 = subtract the second fraction from the first fraction");
                    System.out.println("3 = multiply the first fraction with the second fraction");
                    System.out.println("4 = nume the first fraction by the second fraction");
                    choiceB = scanner.nextInt();
                    if(choiceB >= 5 || choiceB <= 0 ){
                        System.out.println("Enter a valid option");
                    }
                }while(choiceB >= 5 || choiceB <= 0);

                switch(choiceB){
                    case 1:
                        a.add(b);
                        break;
                    case 2:
                        a.sub(b);
                        break;
                    case 3:
                        a.mult(b);
                        break;
                    case 4:
                        a.div(b);
                        break;
                    default:
                        break;
                }
                System.out.println("The result of the operation is " + a);

            } else if(choiceA == 0){
                System.out.println("Goodbye");
            } else {
                System.out.println("Select a valid option");
            }
        }while(choiceA != 0);
    }


    public fraction(int numerator, int denominator){
        if(denominator == 0){
            throw new IllegalArgumentException("denominator cannot be 0");
        }

        this.numerator = numerator;
        this.denominator = denominator;
        simplify();

    }

    public fraction(int numerator){
        this(numerator, 1);
    }
    
    public int getnumerator(){return numerator;}
    public int getdenominator(){return denominator;}

    private void normalizeSign(){
        if(this.denominator < 0){
            this.numerator = -this.numerator;
            this.denominator = -this.denominator;
        }
    }

    static private int greatestCommonDenominator(int a, int b){
        if(a < 0){
            a = - a;
        }
        if(b < 0){
            b = - b;
        }

        while(b != 0){
            int r = a % b;
            a = b;
            b = r; 
        }
        return a;
    }

    public void simplify(){
        normalizeSign();
        int gcd = greatestCommonDenominator(this.numerator, this.denominator);
        this.numerator = this.numerator / gcd;
        this.denominator = this.denominator / gcd;
    }

    public void add(fraction other){
        this.numerator = this.numerator * other.denominator + other.numerator * this.denominator;
        this.denominator = this.denominator * other.denominator;
        simplify();
    }

    public void sub(fraction other){
        this.numerator = this.numerator * other.denominator - other.numerator * this.denominator;
        this.denominator = this.denominator * other.denominator;     
        simplify();   
    }

    public void mult(fraction other){
        this.numerator = this.numerator * other.numerator;
        this.denominator = this.denominator * other.denominator;   
        simplify();     
    }

    public void div(fraction other){
        this.numerator = this.numerator * other.denominator;
        this.denominator = this.denominator * other.numerator; 
        simplify();
    }

    @Override
    public String toString(){
        if(numerator == 0){
            return "0";
        } else if(denominator == 1){
            return Integer.toString(this.numerator);
        } else {
        return numerator + "/" + denominator;
        }
    }
}