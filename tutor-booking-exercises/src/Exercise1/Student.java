package Exercise1;

public class Student {

    static int totalStudents = 0;
    static int studentCounter = 1;
    final String studentId;
    String name;
    String email;

    public Student( String name, String email) {
        this.studentId = String.format("STU-%03d", studentCounter);
        this.name = name;
        this.email = email;

        studentCounter++;
        totalStudents++;

    }

    public String getDetails(){
        return ("Exercise1.Student created: " + studentId + ", " + name + ", " + email);

    }
    public static int getTotalStudents(){
        return totalStudents;
    }

}
