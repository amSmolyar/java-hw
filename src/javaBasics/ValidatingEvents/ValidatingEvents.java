package javaBasics.ValidatingEvents;

import java.util.ArrayList;

public class ValidatingEvents {
    public static void main(String[] args) {
        ArrayList<Movie> allMovies = getMovieList();
        for (Movie mov : allMovies)
            checkEvent(mov);

        ArrayList<Theatre> allTheatres = getTheatreList();
        for (Theatre theatre : allTheatres)
            checkEvent(theatre);

        System.out.println("Все события корректны");
    }

    public static void checkEvent(Event event) {
        if (event.getTitle() == null || event.getReleaseYear() == 0 || event.getAge() == 0) {
            System.out.println(event.toString());
            throw new RuntimeException("Событие не корректно");
        }
    }

    public static ArrayList<Movie> getMovieList() {
        ArrayList<Movie> allMovies = new ArrayList<Movie>();
        allMovies.add(new Movie("Последний рассвет", 2017, 16));
        allMovies.add(new Movie("Король лев", 2019, 6));
        allMovies.add(new Movie(null, 1971, 12));

        return allMovies;
    }

    public static ArrayList<Theatre> getTheatreList() {
        ArrayList<Theatre> allTheatres = new ArrayList<Theatre>();
        allTheatres.add(new Theatre("Вишневый сад", 2013, 16));
        allTheatres.add(new Theatre("Анна Каренина", 0, 18));
        allTheatres.add(new Theatre("Евгений Онегин", 2005, 12));

        return allTheatres;
    }
}
