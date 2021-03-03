package javaBasics.HashStudentList;

import java.util.Objects;

public class Student {
    private String name;
    private String group;
    private String studentId;

    public Student(String name, String group, String studentId) {
        this.name = name;
        this.group = group;
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;

        return Objects.equals(studentId, student.studentId);
    }

    @Override
    public int hashCode() {
        return studentId.hashCode();
    }

    @Override
    public String toString() {
        return String.format("  Имя: %s, Группа: %s, Номер студенческого билета: %s", name, group, studentId);
    }
}
