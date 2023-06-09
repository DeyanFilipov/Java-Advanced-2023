package JavaAdvanced.IteratorsAndComparators.Lab.ComparableBook_03;

public class Main {
    public static void main(String[] args) {
        ComparableBook comparableBookOne = new ComparableBook("Animal Farm", 2003, "George Orwell");
        ComparableBook comparableBookThree = new ComparableBook("The Documents in the Case", 2002);
        ComparableBook comparableBookTwo = new ComparableBook("The Documents in the Case", 1930, "Dorothy Sayers", "Robert Eustace");
        if (comparableBookOne.compareTo(comparableBookTwo) > 0) {
            System.out.println(String.format("%s is before %s", comparableBookOne.getTitle(), comparableBookTwo.getTitle()));
        } else if (comparableBookOne.compareTo(comparableBookTwo) < 0) {
            System.out.println(String.format("%s is before %s", comparableBookTwo.getTitle(), comparableBookOne.getTitle()));
        } else {
            System.out.println("ComparableBook are equal");
        }
    }
}
