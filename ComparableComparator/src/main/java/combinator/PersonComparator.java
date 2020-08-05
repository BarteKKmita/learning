package combinator;

import java.util.Comparator;

public interface PersonComparator extends Comparator<Person> {

    static PersonComparator compareByAge(){
        return (o1,o2)-> {
            if (o1.getAge() > o2.getAge()) {
            return 1;
        } else if (o1.getAge() == o2.getAge()) {
            return 0;
        } else {
            return -1;
        }
        };
    }

    static PersonComparator compareByName(){
        return (o1,o2)-> o1.getName().compareTo(o2.getName());
    }
}
