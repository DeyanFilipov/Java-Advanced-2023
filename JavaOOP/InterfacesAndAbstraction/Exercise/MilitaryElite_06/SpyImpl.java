package JavaOOP.InterfacesAndAbstraction.Exercise.MilitaryElite_06;

public class SpyImpl extends SoldierImpl implements Spy {
    private final String codeNumber;

    public SpyImpl(int id, String firstName, String lastName, String codeNumber) {
        super(id, firstName, lastName);
        this.codeNumber = codeNumber;
    }

    @Override
    public String getCodeNumber() {
        return this.codeNumber;
    }

    @Override
    public String toString() {
        return String.format("%s\nCode Number: %s",
                super.toString(), this.codeNumber);
    }
}
