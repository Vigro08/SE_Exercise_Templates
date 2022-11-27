import java.util.ArrayList;
import java.util.List;

public class Composite implements Component {
    


    private String name;
    List<Component> components = new ArrayList<>();

    public Composite(String name) {
        this.name = name;
    }
    
    public void addComponent(Component c) {
        components.add(c);
    }

    public void printNameAndAthletes() {
        
        System.out.println("Team: " + this.name + ", Number of Athletes: " + getNumberAthletes());
    }

    public void printNameAndGold() {

        System.out.println("Team: " + this.name + ", Number of Gold Medals: " + getNumberGold());
    }

    public int getNumberGold() {
        int number = 0;
        for(Component c : components) {
           number += c.getNumberGold();
        }
        return number;
    }

    public int getNumberAthletes() {
        int number = 0;
        for(Component c : components) {
            number += c.getNumberAthletes();
        }
        return number;
    }
}
