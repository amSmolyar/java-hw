package EmployeesList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class EmployeeList {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String scanData = "";
        List<Employee> employeeList = new ArrayList<Employee>();

        System.out.println("Привет!");
        while (true) {
            System.out.println("Введите информацию о сотруднике "
                    + "(фамилия, имя, возраст, пол, возраст, образование, должность, отдел). "
                    + "\nИли введите 'end' для завершения работы.");
            scanData = scan.nextLine();

            scanData = scanData.trim();
            if (scanData.equals("end")) {
                writeEmployeeList(employeeList);
                break;
            }

            String[] arrayIn = scanData.split("(\\p{Punct}*)(\\s+)");
            if (arrayIn.length == 7) {
                try {
                    Employee emp = new Employee(arrayIn[0], arrayIn[1], Integer.parseInt(arrayIn[2]), arrayIn[3], arrayIn[4], arrayIn[5], arrayIn[6]);
                    employeeList.add(emp);
                } catch (NumberFormatException e) {
                    System.out.println("Формат введенных данных не верный\n");
                }
            } else
                System.out.println("Формат введенных данных не верный\n");
        }

        // Изменение атрибутов сотрудника:
        while (true) {
            System.out.println("Введите фамилию и имя работника, для которого хотите изменить данные");
            System.out.println("Если не хотите менять данные, введите end");
            scanData = scan.nextLine();

            scanData = scanData.trim();
            if (scanData.equals("end")) {
                writeEmployeeList(employeeList);
                break;
            }

            String[] arrayIn = scanData.split("(\\p{Punct}*)(\\s+)");
            if (arrayIn.length == 2) {
                int empIndex = searchEmployee(employeeList, arrayIn[0], arrayIn[1]);
                if (empIndex >= 0) {
                    int cntAttribute = 0;
                    while (cntAttribute < 4) {
                        switch (cntAttribute) {
                            case 0:
                                System.out.println("Меняем возраст? (введите yes или no):");
                                scanData = scan.nextLine();
                                if (scanData.equals("yes")) {
                                    System.out.println("Введите новый возраст сотрудника:");
                                    scanData = scan.nextLine();
                                    try {
                                        employeeList.get(empIndex).setAge(Integer.parseInt(scanData));
                                    } catch (NumberFormatException e) {
                                        System.out.println("Формат введенных данных не верный\n");
                                    }
                                }
                                break;

                            case 1:
                                System.out.println("Меняем образование? (введите yes или no):");
                                scanData = scan.nextLine();
                                if (scanData.equals("yes")) {
                                    System.out.println("Введите текущее образование сотрудника:");
                                    scanData = scan.nextLine();
                                    employeeList.get(empIndex).setEducation(scanData);
                                }
                                break;

                            case 2:
                                System.out.println("Меняем должность сотрудника? (введите yes или no):");
                                scanData = scan.nextLine();
                                if (scanData.equals("yes")) {
                                    System.out.println("Введите новую должность:");
                                    scanData = scan.nextLine();
                                    employeeList.get(empIndex).setFunction(scanData);
                                }
                                break;

                            case 3:
                                System.out.println("Меняем отдел? (введите yes или no):");
                                scanData = scan.nextLine();
                                if (scanData.equals("yes")) {
                                    System.out.println("Введите новый отдел:");
                                    scanData = scan.nextLine();
                                    employeeList.get(empIndex).setDepartment(scanData);
                                }
                                break;

                            default:
                                break;
                        }
                        cntAttribute++;
                    }
                } else
                    System.out.println("Этот сотрудник не найден в списке\n");
            } else
                System.out.println("Формат введенных данных не верный\n");

            writeEmployeeList(employeeList);
        }

        scan.close();
    }

    public static void writeEmployeeList(List<Employee> list) {
        Iterator<Employee> it = list.iterator();
        System.out.println("Список сотрудников:");
        System.out.printf("%15s %15s %15s %15s %15s %15s %15s\n", "Фамилия", "Имя", "Возраст", "Пол", "Образование", "Должность", "Отдел");
        while (it.hasNext()) {
            Employee emp = it.next();
            System.out.printf(emp.toString());
        }
    }

    public static int searchEmployee(List<Employee> list, String surname, String name) {
        if (list == null || surname == null || name == null)
            return -1;

        for (Employee employee : list) {
            if (surname.equals(employee.getSurname())) {
                if (name.equals(employee.getName())) {
                    return list.indexOf(employee);
                }
            }
        }

        return -1;
    }
}
