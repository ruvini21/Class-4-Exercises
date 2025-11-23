package Exercise4;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

class SessionRequest {

    private final String studentId;
    private final String mentorId;
    private final String subject;

    private final String sessionNotes;
    private final List<String> materialsNeeded;
    private final boolean isUrgent;
    private final LocalDateTime preferredTime;
    private final int maxStudents;

    // Private constructor
    private SessionRequest(String studentId, String mentorId, String subject,
                           String sessionNotes, List<String> materialsNeeded,
                           boolean isUrgent, LocalDateTime preferredTime, int maxStudents) {

        this.studentId = studentId;
        this.mentorId = mentorId;
        this.subject = subject;
        this.sessionNotes = sessionNotes;
        this.materialsNeeded = materialsNeeded;
        this.isUrgent = isUrgent;
        this.preferredTime = preferredTime;
        this.maxStudents = maxStudents;
    }

    // Getters
    public String getStudentId() { return studentId; }
    public String getMentorId() { return mentorId; }
    public String getSubject() { return subject; }
    public String getSessionNotes() { return sessionNotes; }
    public List<String> getMaterialsNeeded() { return materialsNeeded; }
    public boolean isUrgent() { return isUrgent; }
    public LocalDateTime getPreferredTime() { return preferredTime; }
    public int getMaxStudents() { return maxStudents; }

    @Override
    public String toString() {
        return "SessionRequest {" +
                "\n  studentId='" + studentId + '\'' +
                ",\n  mentorId='" + mentorId + '\'' +
                ",\n  subject='" + subject + '\'' +
                ",\n  sessionNotes='" + sessionNotes + '\'' +
                ",\n  materialsNeeded=" + materialsNeeded +
                ",\n  isUrgent=" + isUrgent +
                ",\n  preferredTime=" + preferredTime +
                ",\n  maxStudents=" + maxStudents +
                "\n}";
    }

    // BUILDER CLASS
    public static class Builder {

        // Required fields
        private final String studentId;
        private final String mentorId;
        private final String subject;

        // Optional fields with defaults
        private String sessionNotes = "";
        private List<String> materialsNeeded = new ArrayList<>();
        private boolean isUrgent = false;
        private LocalDateTime preferredTime = null;
        private int maxStudents = 1;

        // Required fields constructor
        public Builder(String studentId, String mentorId, String subject) {
            this.studentId = studentId;
            this.mentorId = mentorId;
            this.subject = subject;
        }

        // Optional setters (fluent methods)
        public Builder sessionNotes(String notes) {
            this.sessionNotes = notes;
            return this;
        }

        public Builder materialsNeeded(List<String> materials) {
            this.materialsNeeded = materials;
            return this;
        }

        public Builder isUrgent(boolean urgent) {
            this.isUrgent = urgent;
            return this;
        }

        public Builder preferredTime(LocalDateTime time) {
            this.preferredTime = time;
            return this;
        }

        public Builder maxStudents(int count) {
            this.maxStudents = count;
            return this;
        }

        // VALIDATION
        public SessionRequest build() {

            // 1. Validate subject
            if (subject == null || subject.trim().isEmpty()) {
                throw new IllegalArgumentException("Subject cannot be empty.");
            }

            // 2. Validate group size
            if (maxStudents > 1 && maxStudents < 2) {
                throw new IllegalArgumentException("Group session must have at least 2 students.");
            }

            // 3. Urgent session cannot schedule beyond 7 days
            if (isUrgent && preferredTime != null) {
                LocalDateTime now = LocalDateTime.now();
                if (preferredTime.isAfter(now.plusDays(7))) {
                    throw new IllegalArgumentException("Urgent sessions cannot be scheduled more than 7 days in advance.");
                }
            }

            return new SessionRequest(
                    studentId,
                    mentorId,
                    subject,
                    sessionNotes,
                    materialsNeeded,
                    isUrgent,
                    preferredTime,
                    maxStudents
            );
        }
    }
}
