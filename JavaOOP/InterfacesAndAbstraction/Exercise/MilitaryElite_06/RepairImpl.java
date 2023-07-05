package JavaOOP.InterfacesAndAbstraction.Exercise.MilitaryElite_06;

public class RepairImpl implements Repair {
    private final String partName;
    private final int hoursWorked;

    public RepairImpl(String name, int hoursWorked) {
        this.partName = name;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public String getName() {
        return partName;
    }

    @Override
    public int getHoursWorked() {
        return hoursWorked;
    }

    @Override
    public String toString() {
        return String.format("Part Name: %s Hours Worked: %d", this.partName, this.hoursWorked);
    }
}
