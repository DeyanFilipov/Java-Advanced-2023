package JavaOOP.Encapsulation.Lab.FirstAndReserveTeam_04;

public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    public Person(String firstName, String lastName, int age, double salary) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setAge(age);
        this.setSalary(salary);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName.length() >= 3) {
            this.firstName = firstName;
        } else {
            throw new IllegalArgumentException("First name cannot be less than 3 symbols in length!");
        }
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName.length() >= 3) {
            this.lastName = lastName;
        } else {
            throw new IllegalArgumentException("Last name cannot be less than 3 symbols in length!");
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age > 0) {
            this.age = age;
        } else {
            throw new IllegalArgumentException("Age cannot be equal to or less than zero!");
        }
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary >= 460) {
            this.salary = salary;
        } else {
            throw new IllegalArgumentException("Salary cannot be less than 460.0 leva!");
        }
    }

    public void increaseSalary(double percentage) {
        if (this.age < 30) {
            percentage /= 2;
        }
        setSalary(getSalary() * (1 + percentage / 100));
    }

    @Override
    public String toString() {
        return String.format("%s %s gets %f leva", this.firstName, this.lastName, this.salary);
    }
}
