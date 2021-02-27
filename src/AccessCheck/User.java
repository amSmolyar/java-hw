package AccessCheck;

public class User {
    private String email;
    private String login;
    private String password;
    private int age;

    public User(String email, String login, String password, int age) {
        this.email = email;
        this.login = login;
        this.password = password;
        this.age = age;
    }

    public String getLogin() {
        return this.login;
    }

    public String getPassword() {
        return this.password;
    }

    public int getAge() {
        return this.age;
    }

    @Override
    public String toString() {
        return "[User: email " + this.email +
                ", login " + this.login +
                ", password " + this.password +
                ", age " + this.age + "]";
    }
}
