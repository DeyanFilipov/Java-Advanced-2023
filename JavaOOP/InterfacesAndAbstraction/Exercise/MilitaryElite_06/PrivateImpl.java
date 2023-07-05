package JavaOOP.InterfacesAndAbstraction.Exercise.MilitaryElite_06;

public class PrivateImpl extends SoldierImpl implements Private {
    private final double salary;

    public PrivateImpl(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName);
        this.salary = salary;
    }

    @Override
    public double getSalary() {
        return this.salary;
    }


    @Override
    public String toString() {
        return String.format("%s Salary: %.2f", super.toString(), this.salary);
    }
}
