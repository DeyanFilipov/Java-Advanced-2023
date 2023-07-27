package p02_ExtendedDatabase;

import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class DatabaseTest {

    private static final Person[] PEOPLE = {new Person(1, "First"),
            new Person(2, "Second"),
            new Person(3, "Third"),
            new Person(4, "Fourth"),};
    private Database database;
    private static Person[] elementsInDatabase;

    @Before
    public void SetUp() throws OperationNotSupportedException {
        database = new Database(PEOPLE);
        elementsInDatabase = database.getElements();
    }

    //Constructor
    @Test
    public void testConstructorCreatesValidObject() {
        assertEquals("Count of elements is not correct", PEOPLE.length, elementsInDatabase.length);
        for (int i = 0; i < elementsInDatabase.length; i++) {
            assertEquals("People ids are not the same", PEOPLE[i].getId(), elementsInDatabase[i].getId());
            assertEquals("People names are not the same", PEOPLE[i].getUsername(), elementsInDatabase[i].getUsername());
        }
    }

    //Constructor
    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorThrowsExceptionWhenArrayHasMoreThanSixteenElements() throws OperationNotSupportedException {
        new Database(new Person[17]);
    }

    //Constructor
    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorThrowsExceptionWhenArrayHasLessThanOneElements() throws OperationNotSupportedException {
        new Database();
    }

    //GetElements
    @Test
    public void testGetElementsShouldReturnCorrectArray() {
        for (int i = 0; i < elementsInDatabase.length; i++) {
            assertEquals(PEOPLE[i], elementsInDatabase[i]);
        }
    }

    //Add
    @Test(expected = OperationNotSupportedException.class)
    public void testAddShouldThrowWhenParamNull() throws OperationNotSupportedException {
        database.add(null);
    }

    //Add
    @Test
    public void testAddShouldAddElementAtTheEnd() throws OperationNotSupportedException {
        Person person = new Person(5, "Fifth");
        database.add(person);
        elementsInDatabase = database.getElements();
        assertEquals(PEOPLE.length + 1, elementsInDatabase.length);
        assertEquals(person, elementsInDatabase[elementsInDatabase.length - 1]);
    }

    //Add
    @Test(expected = OperationNotSupportedException.class)
    public void testAddDuplicatePersonIdShouldThrow() throws OperationNotSupportedException {
        database.add(new Person(1, "Sixth"));
    }

    //Add
    @Test(expected = OperationNotSupportedException.class)
    public void testAddDuplicatePersonNameShouldThrow() throws OperationNotSupportedException {
        database.add(new Person(6, "First"));
    }

    //Add
    @Test(expected = OperationNotSupportedException.class)
    public void testAddPersonWithNegativeOrNullIdShouldThrow() throws OperationNotSupportedException {
        database.add(new Person(-1, "MinusOne"));
    }

    //Remove
    @Test(expected = OperationNotSupportedException.class)
    public void testRemoveShouldThrowIfDataBaseIsEmpty() throws OperationNotSupportedException {
        database = new Database(new Person[1]);
        database.remove();
        database.remove();
    }

    //Remove
    @Test
    public void testRemoveShouldRemoveTheLastElementWhenNotEmpty() throws OperationNotSupportedException {
        database.remove();
        elementsInDatabase = database.getElements();
        assertEquals(PEOPLE.length - 1, elementsInDatabase.length);
        for (int i = 0; i < elementsInDatabase.length; i++) {
            assertEquals(PEOPLE[i], elementsInDatabase[i]);
        }
    }

    //FindByUserName
    @Test(expected = OperationNotSupportedException.class)
    public void testFindPersonByUserNameShouldThrowNullUserName() throws OperationNotSupportedException {
        database.findByUsername(null);
    }

    //FindByUserName
    @Test(expected = OperationNotSupportedException.class)
    public void testFindPersonByUserNameShouldThrowForDuplicatedNames() throws OperationNotSupportedException {
        database = new Database(new Person(1, "First"),
                new Person(2, "First"),
                new Person(3, "Third"),
                new Person(4, "Fourth"));
        database.findByUsername("First");
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindPersonByUserNameThatIsNotInDatabaseShouldThrow() throws OperationNotSupportedException {

        database.findByUsername("Sixth");
    }

    //FindByUserName
    @Test
    public void testFindPersonByUserNameReturnsCorrectPerson() throws OperationNotSupportedException {
        Person personFound = database.findByUsername("Third");
        Person expected = Arrays.stream(PEOPLE).filter(p -> p.getUsername().equals("Third")).findFirst().get();
        assertEquals(expected, personFound);
    }

    //FindById
    @Test(expected = OperationNotSupportedException.class)
    public void testFindPersonByIdShouldThrowIfNotPresent() throws OperationNotSupportedException {
        database.findById(10);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindPersonByIdShouldThrowForDuplicatedIds() throws OperationNotSupportedException {
        database = new Database(new Person(1, "First"),
                new Person(1, "Second"),
                new Person(3, "Third"),
                new Person(4, "Fourth"));
        database.findById(1);
    }

    //FindById
    @Test
    public void testFindPersonByIdReturnsCorrectPerson() throws OperationNotSupportedException {
        Person personFound = database.findById(3);
        Person expected = Arrays.stream(PEOPLE).filter(p -> p.getId() == 3).findFirst().get();
        assertEquals(expected, personFound);
    }
}