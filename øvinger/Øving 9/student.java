class student{
    private String name;
    private int taskAmount;

    public student(String name, int taskAmount){
        this.name = name;
        this.taskAmount = taskAmount;
    }

    public String getName(){
        return name;
    }

    public int getTaskAmount(){
        return taskAmount;
    }

    public void increaseTaskAmount(int increaseTaskAmount){
        taskAmount = taskAmount + increaseTaskAmount;
    }

    @Override
    public String toString(){
        return "\nStudent: " + name + "\nNumber of tasks: " + taskAmount;
    }

}