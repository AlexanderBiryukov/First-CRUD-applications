package springCourse.dao;

import org.springframework.stereotype.Component;
import springCourse.models.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int PERSON_ID;
    private final List<Person> personList;

    {
        personList = new ArrayList<>();
        personList.add(new Person("Mark", ++PERSON_ID,"mark@mail.ru",20));
        personList.add(new Person("Alex", ++PERSON_ID,"alex@gmail.com",18));
        personList.add(new Person("Katy", ++PERSON_ID, "katykaty@yandex.ru",26));
        personList.add(new Person("John", ++PERSON_ID, "john@as.com",23));
    }


    public List<Person> index() {
        return personList;
    }

    public Person show(int id) {
        return personList.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void addPerson(Person person) {
        person.setId(++PERSON_ID);
        personList.add(person);
    }

    public void updatePerson(Person person, int id) {
        Person foundPerson = show(id);
        foundPerson.setName(person.getName());
        foundPerson.setAge(person.getAge());
        foundPerson.setEmail(person.getEmail());
    }

    public void delete(int id) {
        personList.removeIf(p -> p.getId() == id);
    }

}
