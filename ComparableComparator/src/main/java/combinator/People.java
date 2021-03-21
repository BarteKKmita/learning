package combinator;

public enum People {
  FOO(PersonComparator.compareByAge()),
  BARTEK(PersonComparator.compareByName());

  private PersonComparator comparator;

  People(PersonComparator compareByName) {
  }

  public PersonComparator getComparator() {
    return comparator;
  }
}
