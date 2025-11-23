package model;

public final class Subject {

    private final String subjectCode;
    private final String title;
    private final int creditHours;

    public Subject(String code, String title, int hours) {
        this.subjectCode = code;
        this.title = title;
        this.creditHours = hours;
    }

    public String getSubjectCode() { return subjectCode; }
    public String getTitle() { return title; }
    public int getCreditHours() { return creditHours; }

    @Override
    public String toString() {
        return subjectCode + " - " + title + " (" + creditHours + " hrs)";
    }
}
