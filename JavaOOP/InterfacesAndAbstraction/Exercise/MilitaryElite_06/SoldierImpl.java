package JavaOOP.InterfacesAndAbstraction.Exercise.MilitaryElite_06;

public abstract class SoldierImpl implements Soldier {
    private final int id;
    private final String firstName;
    private final String lastName;

    public SoldierImpl(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public int getId() {
        return id;
    }
    @Override
    public String getFirstName() {
        return firstName;
    }
    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return String.format("Name: %s %s Id: %d", this.getFirstName(), this.getLastName(), this.getId());
    }
}
