public class managerProgram {
    public static void main(String[] args) {
        person p = new person("Berit", "Johnsen", 1990);
        worker a = new worker(p, 123, 2015, 50000, 25);

        System.out.println(a);
        System.out.println("Tax per month: " + a.getTaxes());
        System.out.println("Gross yearly salary: " + a.getGrossSalary());
        System.out.println("Tax per year: " + a.getYearlyTaxes());
        System.out.println("Has worked more than 5 years? " + a.yearsEmployedLimit(5));
    }
}