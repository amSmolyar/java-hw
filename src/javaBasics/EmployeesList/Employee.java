package javaBasics.EmployeesList;

public class Employee {
    private String surname;
    private String name;
    private int age;
    private String sex;
    private String education;
    private String function;
    private String department;

    public Employee(String surname, String name, int age, String sex, String education, String function, String department) {
        this.surname = surname;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.education = education;
        this.function = function;
        this.department = department;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return String.format("%15s %15s %15s %15s %15s %15s %15s\n",surname, name, age, sex, education, function, department);
    }
}
