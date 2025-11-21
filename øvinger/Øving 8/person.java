class person{
    private final String firstName;
    private final String lastName;
    private final int birthYear;

    public person(String firstName, String lastName, int birthYear){
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthYear = birthYear;
    }

    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public int getBirthYear(){
        return birthYear;
    }

    public String getFullName(){
        return lastName + ", " + firstName;
    }


    @Override
    public String toString(){
        return ("\nFirst name: " +  firstName + "\nLast name: " +  lastName +"\nBirthyear: " +  birthYear);
    }

}