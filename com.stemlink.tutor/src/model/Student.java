package model;

import util.IdGenerator;

public final class Student {

    private final String studentId;
    private final String name;

    public Student(String name) {
        this.studentId = IdGenerator.generateStudentId();
        this.name = name;
    }

    public String getStudentId() { return studentId; }
    public String getName() { return name; }

    @Override
    public String toString() {
        return studentId + " - " + name;
    }
}
