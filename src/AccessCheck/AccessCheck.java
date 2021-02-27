package AccessCheck;

import java.util.ArrayList;
import java.util.Scanner;

public class AccessCheck {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String login = "";
        String password = "";

        System.out.println("Привет!");

        int cntAttempt = 10;
        while (cntAttempt > 0) {
            cntAttempt--;

            System.out.println("\nВведите логин:");
            login = scan.nextLine();
            System.out.println("\nВведите пароль:");
            password = scan.nextLine();

            try {
                User user = checkByLoginPassword(login, password);
                if (checkByAge(user, 18))
                    System.out.println("Предоставлен доступ пользователю:\n" + user.toString());
            } catch (UserNotFoundException | AccessDeniedException e) {
                System.out.println(e.getMessage());
                System.out.println("Исключение обработано");
            }
        }

        scan.close();
    }

    public static User checkByLoginPassword(String login, String password) throws UserNotFoundException {
        ArrayList<User> allUser = getUserList();
        if (allUser == null || login == null || password == null)
            throw new UserNotFoundException("Ошибка");

        for (User ii : allUser) {
            if (login.equals(ii.getLogin())) {
                if (password.equals(ii.getPassword())) {
                    return ii;
                } else {
                    throw new UserNotFoundException("Пароль не верный");
                }
            }
        }
        throw new UserNotFoundException("Пользователь с таким логином не зарегистрирован");
    }

    public static boolean checkByAge(User user, int age) throws AccessDeniedException {
        if (user.getAge() >= age)
            return true;
        else
            throw new AccessDeniedException("Возраст пользователя слишком мал");
    }

    public static ArrayList<User> getUserList() {
        ArrayList<User> allUser = new ArrayList<User>();
        allUser.add(new User("pavlik@gmail.com", "pavlik", "123", 37));
        allUser.add(new User("jack@gmail.com", "jack", "parol", 30));
        allUser.add(new User("antoshka@yandex.ru", "antosha", "behappy", 14));
        allUser.add(new User("zorka@gmail.com", "zarya", "wantcake", 26));

        return allUser;
    }
}
