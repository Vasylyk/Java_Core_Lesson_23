package task1;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Faction {
    private String name;
    private Collection<Deputy> deputies = new ArrayList();
    Scanner sc = new Scanner(System.in);

    public Faction(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Deputy> getDeputies() {
        return deputies;
    }

    public void setDeputies(Collection<Deputy> deputies) {
        this.deputies = deputies;
    }

    @Override
    public String toString() {
        return "Faction{" +
                "name='" + name + '\'' +
                ", deputies=" + deputies +
                '}';
    }

    Supplier<Deputy> createDeputy = ()->{
        System.out.println("Введіть ім'я депутата");
        String name = sc.nextLine();
        System.out.println("Фамілію");
        String secondName = sc.nextLine();
        System.out.println("Вік");
        int age = sc.nextInt();
        System.out.println("Масу");
        int weight = sc.nextInt();
        System.out.println("Ріст");
        int height = sc.nextInt();
        System.out.println("Чи бере взятки (1-так, 2-ні)");
        int bribeTaker = sc.nextInt();
        String nextInt = sc.nextLine();
        boolean bribe=true;
        if (bribeTaker==1){
            bribe=true;
        } else if (bribeTaker==2) {
            bribe = false;
        }
        return new Deputy(weight,height,secondName,name,age,bribe);
    };

    void addDeputy(){
        deputies.add(createDeputy.get());
    }

    void removeDeputy(){
        System.out.println("Введіть фамілію депутата, якого хочете видалити");
        String secondName = sc.nextLine();
        setDeputies(getDeputies().stream().filter(d->d.getSecondName().equalsIgnoreCase(secondName)==false).collect(Collectors.toList()));
    }

    void bribeTakers(){
        System.out.println("Депутати, які беруть хабарі:");
        getDeputies().stream().filter(deputy -> deputy.isBribeTaker()).forEach(deputy -> System.out.println(deputy.getSecondName()
                +" "+deputy.getFirstName()));
    }

    void deputyWithLargestBribe(){
        System.out.println("Депутат з найбільшою взяткою:");
        Iterator<Deputy> iterator=deputies.iterator();
        int sizeOfBribe = 0;
        Deputy deputyWithLargestBribe=new Deputy(0,0,null,null,0,false);
        while (iterator.hasNext()){
            Deputy next = iterator.next();
            if (next.getBribe()>sizeOfBribe){
                deputyWithLargestBribe=next;
            }
        }
        System.out.println(deputyWithLargestBribe.toString());
    }

    void allDeputiesOfFaction(){
        System.out.println("Всі депутати фракції:");
        getDeputies().stream().forEach(deputy -> System.out.println(deputy.toString()));
    }

    void removeAllDeputies() {
        Iterator<Deputy> iterator = deputies.iterator();
        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        }
    }
}
