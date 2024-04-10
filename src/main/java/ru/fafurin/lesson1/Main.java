package ru.fafurin.lesson1;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.fafurin.lesson1.domain.Person;

public class Main {
    public static void main(String[] args) {
        Person person = new Person().setFirstName("Person").setLastName("Personov").setAge(27);

        Gson gson = new GsonBuilder()
                    .setPrettyPrinting()
                    .create();

        String personToJson = gson.toJson(person);
        System.out.println(personToJson);

        Person personFromJson = gson.fromJson(personToJson, Person.class);
        System.out.println(personFromJson);
    }
}