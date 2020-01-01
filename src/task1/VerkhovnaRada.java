package task1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class VerkhovnaRada {
    private Collection<Faction> factions = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public Collection<Faction> getFactions() {
        return factions;
    }

    public void setFactions(Collection<Faction> factions) {
        this.factions = factions;
    }

    @Override
    public String toString() {
        return "VerkhovnaRada{" +
                "factions=" + factions +
                '}';
    }

    void addFaction(){
        System.out.println("Напишіть ім'я фракції");
        String factionName = sc.nextLine();
        factions.add(new Faction(factionName));
    }

    void removeFaction() {
        System.out.println("Напишіть ім'я фракції, яку хочете видалити");
        String factionName = sc.nextLine();
        setFactions(getFactions().stream().filter(faction -> faction.getName().equalsIgnoreCase(factionName)==false)
                .collect(Collectors.toList()));
    }

    void allFactions() {
        System.out.println("Всі фракції:");
        getFactions().stream().forEach(faction -> System.out.println(faction.getName()));
    }

    void addDeputyToFaction() {
        System.out.println("Напишіть ім'я фракції, в яку хочете добавити депутата");
        String factionName = sc.nextLine();
        Optional<Faction> faction = getFactions().stream().filter(faction1 -> faction1.getName().equalsIgnoreCase(factionName))
                .findFirst();
        if (faction.isPresent()) {
            faction.get().addDeputy();
        } else {
            System.out.println("Такої фракції не існує");
        }
    }

    void removeDeputyFromFraction(){
        System.out.println("Напишіть ім'я фракції, з якої хочете видалити депутата");
        String factionName = sc.nextLine();
        Optional<Faction> faction = getFactions().stream().filter(faction1 -> faction1.getName().equalsIgnoreCase(factionName))
                .findFirst();
        if (faction.isPresent()) {
            faction.get().removeDeputy();
        } else {
            System.out.println("Такої фракції не існує");
        }

    }

    void allBribeTakersFromFaction() {
        System.out.println("Введіть назву фракції");
        String factionName = sc.nextLine();
        Optional<Faction> faction = getFactions().stream().filter(faction1 -> faction1.getName().equalsIgnoreCase(factionName))
                .findFirst();
        if (faction.isPresent()) {
            faction.get().bribeTakers();
        } else {
            System.out.println("Такої фракції не існує");
        }
    }

    void deputyWithLargestBribeInFaction(){
        System.out.println("Введіть назву фракції");
        String factionName=sc.nextLine();
        Optional<Faction> faction = getFactions().stream().filter(faction1 -> faction1.getName().equalsIgnoreCase(factionName))
                .findFirst();
        if (faction.isPresent()) {
            faction.get().deputyWithLargestBribe();
        } else {
            System.out.println("Такої фракції не існує");
        }
    }

    void allDeputiesOfFaction(){
        System.out.println("Введіть назву фракції");
        String factionName=sc.nextLine();
        Optional<Faction> faction = getFactions().stream().filter(faction1 -> faction1.getName().equalsIgnoreCase(factionName))
                .findFirst();
        if (faction.isPresent()) {
            faction.get().allDeputiesOfFaction();
        } else {
            System.out.println("Такої фракції не існує");
        }
    }

    void removeAllDeputiesOfFaction(){
        System.out.println("Введіть назву фракції");
        String factionName=sc.nextLine();
        Optional<Faction> faction = getFactions().stream().filter(faction1 -> faction1.getName().equalsIgnoreCase(factionName))
                .findFirst();
        if (faction.isPresent()) {
            faction.get().removeAllDeputies();
        } else {
            System.out.println("Такої фракції не існує");
        }
    }
}
