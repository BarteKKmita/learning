package combinator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class Person {

    private String name;

    private int age;

    private int height;

    private double gradeAverage;
}
