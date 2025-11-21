class taskOverview{
    private student[] students;
    private int studentCount = 0;

    public taskOverview(int capacity){
        students = new student[capacity];
    }



    private int findStudentIndex(String name) {
        for (int i = 0; i < studentCount; i++) {
            if (students[i].getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    private void increaseCapacity() {
        student[] newArray = new student[students.length * 2];
        for (int i = 0; i < students.length; i++) {
            newArray[i] = students[i];
        }
        students = newArray;
    }

    public int getStudentCount(){
        return studentCount;
    }

    public int getTaskAmount(String name) {
        int index = findStudentIndex(name);
        if (index >= 0) {
            return students[index].getTaskAmount();
        } else {
            return -1;
        }
    }

    public void registerStudent(String name, int initialTasks) {
        // check if array is full
        if (studentCount == students.length) {
            increaseCapacity();
        }

        // add new student to array
        students[studentCount] = new student(name, initialTasks);
        studentCount++;
    }


    public boolean increaseTaskForStudent(String name, int increase) {
        int index = findStudentIndex(name);
        if (index >= 0 && increase > 0) {
            students[index].increaseTaskAmount(increase);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        String result = "Task Overview:\n";
        for (int i = 0; i < studentCount; i++) {
            result += students[i].toString() + "\n";
        }
        return result;
    }

}