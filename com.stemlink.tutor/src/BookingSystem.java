import model.*;
import util.BookingValidator;
import util.FeeCalculator;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BookingSystem {

    private static final List<Student> students = new ArrayList<>();
    private static final List<Mentor> mentors = new ArrayList<>();
    private static final List<Subject> subjects = new ArrayList<>();
    private static final List<Booking> bookings = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║   STEM Link Tutor Booking System     ║");
        System.out.println("╚════════════════════════════════════════╝\n");

        initializeSubjects();
        registerUsers();
        createBookings();
        displayStatistics();
    }

    private static void initializeSubjects() {
        subjects.add(new Subject("JAVA-01", "Core Java OOP", 40));
        subjects.add(new Subject("SPR-01", "Spring Boot Basics", 32));
        subjects.add(new Subject("DB-01", "Database Design", 24));
        subjects.add(new Subject("REACT-01", "React Fundamentals", 36));
        subjects.add(new Subject("DSA-01", "Data Structures", 48));

        System.out.println("📚 Initializing subjects...");
        for (Subject s : subjects) {
            System.out.println("  ✅ Added: " + s.getSubjectCode() + " - " + s.getTitle() + " (" + s.getCreditHours() + " hrs)");
        }
    }

    private static void registerUsers() {
        students.add(new Student("Alice Johnson"));
        students.add(new Student("Bob Smith"));
        students.add(new Student("Carol White"));

        mentors.add(new Mentor("Dr. Sarah Ahmed", "Java", 2000, 4.8));
        mentors.add(new Mentor("Prof. John Doe", "Spring Boot", 2500, 4.9));
        mentors.add(new Mentor("Ms. Emily Chen", "React", 1800, 4.7));

        System.out.println("\n👥 Registering users...");
        for (Student s : students)
            System.out.println("  👨‍🎓 Student registered: " + s);

        System.out.println();
        for (Mentor m : mentors)
            System.out.println("  👨‍🏫 Mentor registered: " + m);
    }

    private static void createBookings() {
        System.out.println("\n📅 Creating bookings...");

        attemptBooking(students.get(0), mentors.get(0), subjects.get(0), LocalDateTime.of(2025, 11, 20, 14, 0), 2);
        attemptBooking(students.get(1), mentors.get(1), subjects.get(1), LocalDateTime.of(2025, 11, 18, 10, 0), 3);
        attemptBooking(students.get(0), mentors.get(2), subjects.get(3), LocalDateTime.of(2025, 11, 15, 16, 0), 5); // invalid
    }

    private static void attemptBooking(Student student, Mentor mentor, Subject subject, LocalDateTime time, int duration) {
        System.out.println("\n  Attempting booking:");
        System.out.println("    Student: " + student.getStudentId());
        System.out.println("    Mentor: " + mentor.getMentorId());
        System.out.println("    Subject: " + subject.getTitle());
        System.out.println("    Time: " + time);
        System.out.println("    Duration: " + duration + " hours");

        if (!BookingValidator.isValidBookingTime(time)) {
            System.out.println("    ❌ Invalid booking time (must be in future)");
            return;
        }
        if (!BookingValidator.isValidDuration(duration)) {
            System.out.println("    ❌ Invalid duration (must be 1-4 hours)");
            return;
        }

        Booking booking = new Booking(student.getStudentId(), mentor.getMentorId(), subject.getTitle(), time, duration);
        bookings.add(booking);

        double base = FeeCalculator.calculateBaseFee(mentor.getHourlyRate(), duration);
        double platform = FeeCalculator.calculatePlatformFee(base);
        double total = base + platform;

        System.out.println("    ✅ Booking created: " + booking.getBookingId());
        System.out.println("    💰 Fees - Base: LKR " + base + " | Platform: LKR " + platform + " | Total: LKR " + total);
    }

    private static void displayStatistics() {
        System.out.println("\n📊 System Statistics");
        System.out.println("═══════════════════════════════════════");
        System.out.println("  Total Students: " + students.size());
        System.out.println("  Total Mentors: " + mentors.size());
        System.out.println("  Total Subjects: " + subjects.size());
        System.out.println("  Total Bookings: " + bookings.size());

        double totalRevenue = bookings.stream()
                .mapToDouble(b -> FeeCalculator.calculateTotal(2000, b.getDurationHours())) // approximate revenue
                .sum();

        double avgDuration = bookings.stream()
                .mapToInt(Booking::getDurationHours)
                .average().orElse(0);

        System.out.printf("  Total Revenue: LKR %.2f\n", totalRevenue);
        System.out.printf("  Average Duration: %.1f hours\n", avgDuration);
    }
}
