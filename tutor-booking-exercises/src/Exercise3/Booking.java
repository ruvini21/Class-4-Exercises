package Exercise3;
import java.time.LocalDateTime;

public final class Booking {
    private static int bookingCounter = 0;

    private final String bookingId;
    private final String studentId;
    private final String mentorId;
    private final String subject;
    private final LocalDateTime scheduledTime;
    private final int durationHours;
    private final LocalDateTime createdAt;
    private final String status;

    public Booking(String studentId, String mentorId, String subject, LocalDateTime scheduledTime, int durationHours) {

        bookingCounter++;
        this.bookingId = String.format("BK-%03d", bookingCounter);

        this.studentId = studentId;
        this.mentorId = mentorId;
        this.subject = subject;
        this.scheduledTime = scheduledTime;
        this.durationHours = durationHours;

        this.createdAt = LocalDateTime.now();
        this.status = "PENDING"; // always pending for new bookings
    }

    public String getBookingId() { return bookingId; }
    public String getStudentId() { return studentId; }
    public String getMentorId() { return mentorId; }
    public String getSubject() { return subject; }
    public LocalDateTime getScheduledTime() { return scheduledTime; }
    public int getDurationHours() { return durationHours; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public String getStatus() { return status; }

    public String getBookingDetails() {
        return "Booking ID: " + bookingId + "\n" +
                "Student: " + studentId + " | Mentor: " + mentorId + "\n" +
                "Subject: " + subject + "\n" +
                "Scheduled: " + scheduledTime + "\n" +
                "Duration: " + durationHours + " hours\n" +
                "Status: " + status + "\n" +
                "Created: " + createdAt;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Booking other)) return false;

        return this.bookingId.equals(other.bookingId);
    }

    @Override
    public int hashCode() {
        return bookingId.hashCode();
    }
}
