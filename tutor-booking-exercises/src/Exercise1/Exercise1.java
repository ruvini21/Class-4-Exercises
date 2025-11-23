package Exercise1;

public class Exercise1 {
    public static void main(String[] args) {
        System.out.println("Creating students...");
        Student student1 = new Student( "Alice Johnson" , "alice@email.com");
        Student student2 = new Student("Bob Smith", "bob@email.com");
        Student student3 = new Student("Carol White", "carol@email.com");

        System.out.println(student1.getDetails());
        System.out.println(student2.getDetails());
        System.out.println(student3.getDetails());

        System.out.println("\nTotal students registered: " + Student.getTotalStudents());

        Student student4 = new Student("Ruvini", "ruviniuthpala2@gmail.com");
        System.out.println("New " + student4.getDetails());
        System.out.println("New Total students registered: " + Student.getTotalStudents());




    }
}
