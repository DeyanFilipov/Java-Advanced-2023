package JavaOOP.WorkingWithAbstraction.Lab.StudentSystem_03;

public class ShowCommand {

    public StudentSystem studentSystem;

    public ShowCommand(StudentSystem studentSystem) {
        this.studentSystem = studentSystem;
    }
    public void execute(String name) {
        if (this.studentSystem.getRepo().containsKey(name)) {
            var student = this.studentSystem.getRepo().get(name);
            System.out.println(student);
        }
    }
}
