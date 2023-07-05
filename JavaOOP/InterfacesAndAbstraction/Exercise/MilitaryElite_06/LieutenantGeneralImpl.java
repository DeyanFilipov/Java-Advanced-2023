package JavaOOP.InterfacesAndAbstraction.Exercise.MilitaryElite_06;

import java.util.Comparator;

import java.util.Set;
import java.util.TreeSet;

public class LieutenantGeneralImpl extends PrivateImpl implements LieutenantGeneral {
    private final Set<Private> privates;

    public LieutenantGeneralImpl(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName, salary);
        this.privates = new TreeSet<>(Comparator.comparing(Private::getId).reversed());
    }


    @Override
    public void addPrivate(Private privateSoldier) {
        this.privates.add(privateSoldier);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Name: %s %s Id: %d Salary: %.2f\nPrivates:\n", getFirstName(), getLastName(), getId(), getSalary()));
        privates.forEach(p -> sb.append("  ").append(p).append(System.lineSeparator()));
        return sb.toString().trim();
    }
}
