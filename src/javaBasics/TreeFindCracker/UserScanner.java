package javaBasics.TreeFindCracker;

import java.io.File;
import java.util.Scanner;

public class UserScanner {
    private Scanner scan;
    private File file;

    public UserScanner(String fileName) {
        try {
            file = new File(fileName);
            scan = new Scanner(file);
        } catch (java.io.FileNotFoundException e) {
            System.out.println(e.getMessage());
            System.out.println("Не нашли файл. Ошибка");
        }
    }

    public void closeScanner() {
        scan.close();
    }

    public void readDBFile(UserDataBase userDB) {
        User newUser;
        String ip;
        String name;
        String id;
        String address;
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            String[] arrayIn = line.split(";");
            ip = arrayIn[0].trim();
            id = arrayIn[1].trim();
            name = arrayIn[2].trim();
            address = arrayIn[3].trim();
            newUser = new User(name, address, id);
            userDB.addUserBD(newUser);
            userDB.addUserIP(id, ip);
        }
    }

    public void readLogFile(UserDataBase log) {
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            String[] arrayIn = line.split(":");
            log.addVisit(arrayIn[0].trim());
        }
    }
}
