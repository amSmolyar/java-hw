package Notebook;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Notebook {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String scanData = "";
        int cmdCnt;

        List<String> taskList = new ArrayList<String>();

        System.out.println("Привет!");
        while (true) {
            System.out.println("\nВыберите действие:\n" +
                    "1. Добавить задачу;\n" +
                    "2. Вывести список задач;\n" +
                    "3. Удалить задачу.\n\n" +
                    "Или введите 'end' для завершения составления списка задач\n");

            scanData = scan.nextLine();
            if (scanData.equals("end")) {
                writeTaskList(taskList);
                break;
            }

            if (scanData.matches("(\\s*)[1-3]{1}(\\s*)")) {
                cmdCnt = Integer.parseInt(scanData);
                switch (cmdCnt) {
                    case 1:
                        System.out.println("Введите задачу для планирования:");
                        scanData = scan.nextLine();
                        taskList.add(scanData);
                        break;
                    case 2:
                        writeTaskList(taskList);
                        break;
                    case 3:
                        writeTaskList(taskList);
                        System.out.println("\nВведите номер задачи, которую нужно удалить:");
                        scanData = scan.nextLine();
                        if (scanData.matches("(\\s*)\\d(\\s*)"))
                            removeOneTask(taskList, (Integer.parseInt(scanData) - 1));
                        else
                            System.out.println("Вы промахнулись. Может, в другой раз повезет");
                        break;
                    default:
                        break;
                }
            }
        }

        while (true) {
            System.out.println("\nВведите номер задачи, которую нужно удалить. \nИли введите 'end' для завершения работы");
            scanData = scan.nextLine();

            if (scanData.equals("end")) {
                writeTaskList(taskList);
                break;
            }

            if (scanData.matches("(\\s*)\\d(\\s*)"))
                removeOneTask(taskList, (Integer.parseInt(scanData) - 1));
            else
                System.out.println("Вы промахнулись. Может, в другой раз повезет");

            writeTaskList(taskList);
        }

        scan.close();
    }

    public static void writeTaskList(List<String> list) {
        Iterator<String> it = list.iterator();
        int cnt = 1;
        System.out.println("Список задач:");
        while (it.hasNext()) {
            String task = it.next();
            System.out.println(cnt + ". " + task);
            cnt++;
        }
    }

    public static void removeOneTask(List<String> list, int indexRemove) {
        if ((indexRemove <= (list.size() - 1)) || (indexRemove < 0))
            list.remove(indexRemove);
        else
            System.out.println("Задачи с таким индексом не существует");
    }
}
