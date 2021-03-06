package stream.populationCensus;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");

        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10_000_000; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }

        System.out.printf("Количество несовершеннолетних: ");
        minorsNumber(persons);

        // список фамилий призывников (мужчин от 18 до 27):
        List<String> conscriptsSurnameList = getConscriptsSurnameList(persons);
        System.out.println("\nСписок фамилий призывников: ");
        conscriptsSurnameList.stream()
                .forEach(System.out::println);

        // список людей с высшим образованием от 18 до 60 лет для женщин и до 65 лет для мужчин:
        List<Person> ableBodiedPeopleList = getAbleBodiedPeopleList(persons);
        System.out.println("\nСписок дееспособных людей с высшим образованием: ");
        ableBodiedPeopleList.stream()
                .forEach(System.out::println);

    }

    public static void minorsNumber(Collection<Person> persons) {
        long cntMinor = persons.stream()
                                .filter((x) -> x.getAge() < 18)
                                .count();
        System.out.println(cntMinor);
    }

    public static List<String> getConscriptsSurnameList(Collection<Person> persons) {
        return persons.stream()
                .filter((x) -> (x.getSex() == Sex.MAN))
                .filter((x) -> (x.getAge() >= 18))
                .filter((x) -> (x.getAge() <= 27))
                .map(x -> x.getFamily())
                .collect(Collectors.toList());
    }

    public static List<Person> getAbleBodiedPeopleList (Collection<Person> persons) {
        return persons.stream()
                .filter(x -> (x.getEducation() == Education.HIGHER))
                .filter(x -> (x.getAge() >= 18))
                .filter(x -> (((x.getSex() == Sex.MAN) && (x.getAge() <= 65)) || ((x.getSex() == Sex.WOMAN) && (x.getAge() <= 60))))
                .sorted(Comparator.comparing(x -> x.getFamily()))
                .collect(Collectors.toList());
    }
}
