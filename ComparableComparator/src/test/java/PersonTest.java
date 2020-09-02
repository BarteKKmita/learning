import combinator.Person;
import combinator.PersonComparator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PersonTest {

    @TestFactory
    Stream<DynamicTest> shouldPeopleBeInNameOrder() {
        //Given
        List<Person> peopleList = getPeopleList();
        List<String> expectedOrder = getPeopleInNameOrder();
        //When
        peopleList.sort(new PersonByName());
        //Then
        return peopleList.stream()
                .map(person -> DynamicTest.dynamicTest("Checking: " + person.getName(), () -> {
                    int id = peopleList.indexOf(person);
                    assertEquals(expectedOrder.get(id), person.getName());
                }));
    }

    @Test
    @DisplayName("Better name comparator")
    void shouldPeopleBeInNameOrder2() {
        //Given
        List<Person> peopleList = getPeopleList();
        //When
        peopleList.sort(PersonComparator.compareByName());
        //Then
        peopleList.equals(getPeopleInNameOrder());
    }

    @TestFactory
    Stream<DynamicTest> shouldPeopleBeSortedInAgeOrder() {
        //Given
        List<Person> peopleList = getPeopleList();
        List<Integer> correctAgeOrder = getPeopleInAgeOrder();
        //When
        peopleList.sort(new PersonByAge());
        //Then
        return peopleList.stream()
                .map(person -> DynamicTest.dynamicTest("Checking age of " + person.getName(), () -> {
                    int id = peopleList.indexOf(person);
                    assertEquals(correctAgeOrder.get(id), person.getAge());
                }));
    }

    @Test
    @DisplayName("Better age comparator")
    void shouldPeopleBeSortedInAgeOrder2() {
        //Given
        List<Person> peopleList = getPeopleList();
        //When
        peopleList.sort(PersonComparator.compareByAge());
        //Then
        peopleList.equals(getPeopleInAgeOrder());
    }

    private List<Integer> getPeopleInAgeOrder() {
        return Arrays.asList(12, 15, 19, 22);
    }

    private List<String> getPeopleInNameOrder() {
        List<String> peopleList = new ArrayList<>();
        peopleList.add("Agness");
        peopleList.add("David");
        peopleList.add("Filip");
        peopleList.add("Nelson");
        return peopleList;
    }

    private List<Person> getPeopleList() {
        List<Person> peopleList = new ArrayList();
        peopleList.add(new Person("Agness", 15, 170, 3.4));
        peopleList.add(new Person("David", 19, 180, 2.8));
        peopleList.add(new Person("Nelson", 12, 140, 5.2));
        peopleList.add(new Person("Filip", 22, 190, 4.3));
        return peopleList;
    }
}