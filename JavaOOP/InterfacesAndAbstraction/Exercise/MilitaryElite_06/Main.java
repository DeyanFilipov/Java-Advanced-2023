package JavaOOP.InterfacesAndAbstraction.Exercise.MilitaryElite_06;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = "";
        List<PrivateImpl> privates = new ArrayList<>();
        List<Soldier> soldiers = new ArrayList<>();
        while (!(input = scan.nextLine()).equals("End")) {
            CreateSoldier(input, privates, soldiers);
        }
        soldiers.forEach(System.out::println);
    }

    private static void CreateSoldier(String input, List<PrivateImpl> privates, List<Soldier> soldiers) {
        String[] info = input.split("\\s+");
        int id = Integer.parseInt(info[1]);
        String firstName = info[2];
        String lastName = info[3];

        switch (info[0]) {
            case "Private":
                double salary = Double.parseDouble(info[4]);
                privates.add(new PrivateImpl(id, firstName, lastName, salary));
                soldiers.add(new PrivateImpl(id, firstName, lastName, salary));
                break;
            case "LieutenantGeneral":
                salary = Double.parseDouble(info[4]);
                LieutenantGeneralImpl lieutenantGeneral = createLieutenantGeneral(privates, info, id, firstName, lastName, salary);
                soldiers.add(lieutenantGeneral);
                break;
            case "Engineer":
                salary = Double.parseDouble(info[4]);
                String corps = info[5];
                if (Corps.contains(corps)) {
                    EngineerImpl eng = createEngineer(info, id, firstName, lastName, salary, corps);
                    soldiers.add(eng);
                }
                break;
            case "Commando":
                salary = Double.parseDouble(info[4]);
                corps = info[5];
                if (Corps.contains(corps)) {
                    CommandoImpl comm = createCommando(info, id, firstName, lastName, salary, corps);
                    soldiers.add(comm);
                }
                break;
            case "Spy":
                String codeNumber = info[4];
                soldiers.add(new SpyImpl(id, firstName, lastName, codeNumber));
                break;
        }
    }

    private static CommandoImpl createCommando(String[] info, int id, String firstName, String lastName,
                                               double salary, String corps) {
        CommandoImpl comm = new CommandoImpl(id, firstName, lastName, salary, Corps.valueOf(corps.toUpperCase()));
        for (int i = 6; i < info.length; i += 2) {
            String codeName = info[i];
            String state = info[i + 1];
            if (State.contains(state)){
                comm.addMission(new MissionImpl(codeName, state));
            }
        }
        return comm;
    }

    private static EngineerImpl createEngineer(String[] info, int id, String firstName,
                                               String lastName, double salary, String corps) {
        EngineerImpl eng = new EngineerImpl(id, firstName, lastName, salary, Corps.valueOf(corps.toUpperCase()));
        for (int i = 6; i < info.length; i += 2) {
            String partName = info[i];
            int repairHours = Integer.parseInt(info[i + 1]);
            eng.addRepair(new RepairImpl(partName, repairHours));
        }
        return eng;
    }

    private static LieutenantGeneralImpl createLieutenantGeneral(List<PrivateImpl> privates,
                                                                 String[] info, int id,
                                                                 String firstName, String lastName, double salary) {
        LieutenantGeneralImpl lieutenantGeneral = new LieutenantGeneralImpl(id, firstName, lastName, salary);
        for (int i = 5; i < info.length; i++) {
            int privateId = Integer.parseInt(info[i]);
            privates.stream().filter(p -> p.getId() == privateId)
                    .findFirst().ifPresent(lieutenantGeneral::addPrivate);
        }
        return lieutenantGeneral;
    }
}
