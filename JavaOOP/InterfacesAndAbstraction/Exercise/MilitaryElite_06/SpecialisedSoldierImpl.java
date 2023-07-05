package JavaOOP.InterfacesAndAbstraction.Exercise.MilitaryElite_06;

public class SpecialisedSoldierImpl extends PrivateImpl implements SpecialisedSoldier {
    private final Corps corps;

    public SpecialisedSoldierImpl(int id, String firstName, String lastName, double salary, Corps corps) {
        super(id, firstName, lastName, salary);
        this.corps = corps;
    }

    @Override
    public String getCorps() {
        return this.corps.getCorpsName();
    }

    @Override
    public String toString() {
        return String.format("%s\nCorps: %s", super.toString(), this.getCorps());
    }
}
