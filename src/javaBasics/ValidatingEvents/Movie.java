package javaBasics.ValidatingEvents;

public class Movie extends Event {
    public Movie(String title, int releaseYear, int age) {
        super(title, releaseYear, age);
    }

    @Override
    public String toString() {
        return ("Movie " + super.toString());
    }
}
