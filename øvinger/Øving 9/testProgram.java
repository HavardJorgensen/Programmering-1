class testProgram{
    public static void main(String[] args) {

        // Test student
        student s = new student("Anna", 3);
        System.out.println(s);           // 3 tasks.
        s.increaseTaskAmount(2);
        System.out.println(s);           // 5 tasks.

        // Test taskOvervies
        taskOverview overview = new taskOverview(5);

        overview.registerStudent("Anna", 5);
        overview.registerStudent("Bjørn", 2);
        overview.registerStudent("Clara", 7);

        System.out.println("Student count: " + overview.getStudentCount());

        System.out.println("Anna has: " +
                overview.getTaskAmount("Anna") + " tasks");

        boolean ok = overview.increaseTaskForStudent("Bjørn", 3);
        System.out.println("Increase for Bjørn succesfull? " + ok);

        System.out.println("\nThe whole overview:");
        System.out.println(overview);
    }
}