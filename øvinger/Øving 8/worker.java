import java.util.*;

class worker{
    private person personalia;
    private int workerNumber;
    private int yearOfEmployment;
    private int monthlySalary;
    private double taxRate;

    public worker(person personalia, int workerNumber, int yearOfEmployment, int monthlySalary, int taxRate){
        this.personalia = personalia;
        this.workerNumber = workerNumber;
        this.yearOfEmployment = yearOfEmployment;
        this.monthlySalary = monthlySalary;
        this.taxRate = taxRate;
    }

    public person getPersonalia(){
        return personalia;
    }

    public int getWorkerNumber(){
        return workerNumber;
    }

    public int getYearOfEmployment(){
        return yearOfEmployment;
    }

    public int getMonthlySalary(){
        return monthlySalary;
    }

    public double getTaxRate(){
        return taxRate;
    }

    public double getTaxes(){
        return (monthlySalary * (taxRate / 100));
    }

    public int getGrossSalary(){
        return (monthlySalary*12);
    }

    public double getYearlyTaxes(){
        return (getTaxes()*10.5);
    }

    public String getFullName(){
        return personalia.getFullName();
    }

    public int getAge(){
        return GregorianCalendar.YEAR - personalia.getBirthYear();
    }

    public int getYearsInEmployment(){
        return GregorianCalendar.YEAR - yearOfEmployment;
    }

    public boolean yearsEmployedLimit(int yearsEmployedLimit){
        if((GregorianCalendar.YEAR - yearsEmployedLimit) >= yearsEmployedLimit){
            return true;
        }
        return false;
    }

    @Override 
    public String toString(){
        return "Employee: " + getFullName() +
        "\nAge: " + getAge() +
        "\nYears emplyed: " + getYearsInEmployment() +
        "\nSalary: " + getMonthlySalary()+
        "\nTaxes: " + getTaxes();
    }


}
