public class Leaf implements Component {

    private String name;
    private int numberGold;
    private int numberAthletes;

    public Leaf(String name, int numberGold, int numberAthletes) {
        this.name = name;
        this.numberGold = numberGold;
        this.numberAthletes = numberAthletes;
    }
    
    public void printNameAndAthletes() {
        System.out.println("Team: " + this.name + ", Number of Athletes: " + getNumberAthletes());
    }

    public void printNameAndGold() {

        System.out.println("Team: " + this.name + ", Number of Gold Medals: " + getNumberGold());
    }
    
    public int getNumberAthletes() {
        return this.numberAthletes;
    }

    public int getNumberGold() {
        return this.numberGold;
    }
}
