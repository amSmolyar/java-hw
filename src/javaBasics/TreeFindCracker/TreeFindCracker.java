package javaBasics.TreeFindCracker;

public class TreeFindCracker {
    public static void main(String[] args) {
        String fileDB = "d:/JAVA/HomeWorks/src/TreeFindCracker/users.db";
        String fileLog = "d:/JAVA/HomeWorks/src/TreeFindCracker/server.log";
        UserDataBase userDataBase = new UserDataBase();

        //Читаем данные пользователей:
        UserScanner scan = new UserScanner(fileDB);
        scan.readDBFile(userDataBase);
        scan.closeScanner();

        //Читаем log-файл:
        UserScanner scanLog = new UserScanner(fileLog);
        scanLog.readLogFile(userDataBase);
        scanLog.closeScanner();

        //id нарушителя:
        String crackerId = userDataBase.findCrackerId();
        //Нарушитель:
        User user = userDataBase.findUser(crackerId);

        System.out.println("Нарушитель:\n" +
                user.toString() + "\n" +
                "Количество входов : " + userDataBase.getMaxVisiting());
    }
}
