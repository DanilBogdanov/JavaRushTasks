package com.javarush.task.task29.task2909.human;

import java.util.List;
import java.util.ArrayList;

public class University {
    private String name;
    private int age;
    private List<Student> students = new ArrayList<>();

    public University(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Student> getStudents() {
        return students;
    }

    public Student getStudentWithAverageGrade(double averageGrade) {
        for (Student student : students) {
            if (student.getAverageGrade() == averageGrade) {
                return student;
            }
        }
        return null;
    }

    public Student getStudentWithMaxAverageGrade() {
        Student student = null;
        for (Student studentIter : students) {
            if (student == null || studentIter.getAverageGrade() > student.getAverageGrade()) {
                    student = studentIter;
            }
        }
        return student;
    }

    public Student getStudentWithMinAverageGrade() {
        Student student = null;
        for (Student studentIter : students) {
            if (student == null || studentIter.getAverageGrade() < student.getAverageGrade()) {
                    student = studentIter;
            }
        }
        return student;
    }

    public void expel(Student student) {
        students.remove(student);
    }
}