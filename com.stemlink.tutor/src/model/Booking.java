package model;

import util.IdGenerator;

import java.time.LocalDateTime;

public final class Booking {

    private final String bookingId;
    private final String studentId;
    private final String mentorId;
    private final String subject;
    private final LocalDateTime scheduledTime;
    private final int durationHours;

    public Booking(String studentId, String mentorId, String subject, LocalDateTime scheduledTime, int duration) {
        this.bookingId = IdGenerator.generateBookingId();
        this.studentId = studentId;
        this.mentorId = mentorId;
        this.subject = subject;
        this.scheduledTime = scheduledTime;
        this.durationHours = duration;
    }

    public String getBookingId() { return bookingId; }
    public String getStudentId() { return studentId; }
    public String getMentorId() { return mentorId; }
    public String getSubject() { return subject; }
    public LocalDateTime getScheduledTime() { return scheduledTime; }
    public int getDurationHours() { return durationHours; }
}
