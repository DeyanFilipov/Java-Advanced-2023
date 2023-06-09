package JavaAdvanced.IteratorsAndComparators.Lab.Library_02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Book implements Comparable<Book> {
    private String title;
    private int year;
    private List<String> authors;

    public Book(String title, int year, String... authors) {
        this.title = title;
        this.year = year;
        this.authors = new ArrayList<>(Arrays.asList(authors));
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getTitle() {
        return title;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public List<String> getAuthors() {
        return authors;
    }
    public void setAuthors(String[] authors) {
        this.authors = Arrays.asList(authors);
    }
    @Override
    public String toString() {
        return String.format("%s -> %d -> %s", getTitle(), getYear(), getAuthors().toString());
    }
    @Override
    public int compareTo(Book o) {
        int result = this.getTitle().compareTo(o.getTitle());

        if (result == 0) {
            result = Integer.compare(this.getYear(), o.getYear());
        }
        return result;
    }
}