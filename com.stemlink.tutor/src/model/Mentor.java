package model;

import util.IdGenerator;

public final class Mentor {

    private final String mentorId;
    private final String name;
    private final String specialization;
    private final double hourlyRate;
    private final double rating;

    public Mentor(String name, String specialization, double hourlyRate, double rating) {
        this.mentorId = IdGenerator.generateMentorId();
        this.name = name;
        this.specialization = specialization;
        this.hourlyRate = hourlyRate;
        this.rating = rating;
    }

    public String getMentorId() { return mentorId; }
    public String getName() { return name; }
    public String getSpecialization() { return specialization; }
    public double getHourlyRate() { return hourlyRate; }
    public double getRating() { return rating; }

    @Override
    public String toString() {
        return mentorId + " - " + name + " (" + specialization + ", LKR " + hourlyRate + "/hr, ⭐" + rating + ")";
    }
}
