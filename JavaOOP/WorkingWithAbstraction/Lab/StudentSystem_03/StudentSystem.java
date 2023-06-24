package JavaOOP.WorkingWithAbstraction.Lab.StudentSystem_03;

import java.util.*;

public class StudentSystem {
    private Map<String, Student> repo;

    public StudentSystem() {
        this.repo = new HashMap<>();
    }

    public Map<String, Student> getRepo() {
        return this.repo;
    }

    public void parseCommand(String[] args) {

        if ("Create".equals(args[0])) {
            CreateCommand createCommand = new CreateCommand(this);
            createCommand.execute(Arrays.stream(args).skip(1).toArray(String[]::new));
        } else if ("Show".equals(args[0])) {
            ShowCommand showCommand = new ShowCommand(this);
            showCommand.execute(args[1]);
        }
    }
}