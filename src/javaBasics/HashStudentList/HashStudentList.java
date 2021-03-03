package javaBasics.HashStudentList;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class HashStudentList {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String scanData = "";
        Set<Student> setStudent = new HashSet<>();

        System.out.println("Привет!");
        Student newStudent;
        while (true) {
            System.out.println("Введите информацию о студенте ('ФИО, номер группы, номер студенческого билета').\nВведите 'end' для завершения работы");
            scanData = scan.nextLine();
            scanData = scanData.trim();

            if (scanData.equals("end")) {
                writeStudentSet(setStudent);
                break;
            }

            try {
                newStudent = detectStudent(scanData);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Неправильный формат ввода данных");
                continue;
            }
            addStudent(setStudent, newStudent);
        }

        scan.close();
    }

    public static Student detectStudent(String str) throws ArrayIndexOutOfBoundsException {
        String[] arrayIn = str.split("[,:;.]");
        String name = arrayIn[0].trim();
        String group = arrayIn[1].trim();
        String documentNumber = arrayIn[2].trim();
        Student newStudent = new Student(name, group, documentNumber);
        return newStudent;
    }

    public static void writeStudentSet(Set<Student> set) {
        System.out.println("Список студентов:");
        Iterator<Student> it = set.iterator();
        while (it.hasNext()) {
            Student student = it.next();
            System.out.println(student.toString());
        }
    }

    public static void addStudent(Set<Student> setStudent, Student newStudent) {
        if (!setStudent.add(newStudent))
            System.out.println("Студент с данным номером студенческого билета уже есть в базе");
    }

}
