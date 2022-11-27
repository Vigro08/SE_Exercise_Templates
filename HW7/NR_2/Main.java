public class Main {

    public static void main(String[] args) {
        Leaf Taekwando = new Leaf("Taekwando", 0, 0);
        Leaf Waterpolo = new Leaf("Waterpolo", 10, 0);
        Leaf Artistic_Gymnastics = new Leaf("Artistic_Gymnastics", 0, 0);
        Leaf Shooting = new Leaf("Shooting", 0, 0);
        Leaf Cycling = new Leaf("Cycling", 3, 2);
        Leaf Tennis = new Leaf("Tennis", 0, 0);
        Leaf Table_Tennis = new Leaf("Table_Tennis", 4, 1);
        Leaf Footbal_1 = new Leaf("Footbal_1", 0, 0);
        Leaf Alpine_Sky = new Leaf("Alpine_Sky", 0, 0);
        Leaf Footbal_2 = new Leaf("Footbal_2", 0, 0);
        Leaf Swimming_Team = new Leaf("Swimming_Team", 0, 0);

        Composite China_Women = new Composite("China_Women");
        Composite China_Men = new Composite("China_Men");
        Composite Germany_Women = new Composite("Germany_Women");
        Composite Germany_Men = new Composite("Germany_Men");
        Composite Italy_Women = new Composite("Italy_Women");
        Composite Italy_Men = new Composite("Italy_Men");

        Composite China_Team = new Composite("China_Team");
        Leaf Afghanistan_Team = new Leaf("Afghanistan_Team", 0, 0);
        Composite Germany_Team = new Composite("Germany_Team");
        Composite Italy_Team = new Composite("Italy_Team");
        
        Composite Asia_Team = new Composite("Asia_Team");
        Leaf Africa_Team = new Leaf("Africa_Team", 0 , 0);
        Composite Europe_Team = new Composite("Europe_Team");
        Leaf South_America_Team = new Leaf("South_America_Team", 0, 0);

        Composite Olympics_Teams = new Composite("Olympics_Teams");

        Olympics_Teams.addComponent(Asia_Team);
        Olympics_Teams.addComponent(Africa_Team);
        Olympics_Teams.addComponent(Europe_Team);
        Olympics_Teams.addComponent(South_America_Team);

        Asia_Team.addComponent(China_Team);
        Asia_Team.addComponent(Afghanistan_Team);

        Europe_Team.addComponent(Germany_Team);
        Europe_Team.addComponent(Italy_Team);

        China_Team.addComponent(China_Women);
        China_Team.addComponent(China_Men);

        Germany_Team.addComponent(Germany_Women);
        Germany_Team.addComponent(Germany_Men);

        Italy_Team.addComponent(Italy_Women);
        Italy_Team.addComponent(Italy_Men);

        China_Women.addComponent(Taekwando);
        China_Women.addComponent(Waterpolo);
        China_Women.addComponent(Artistic_Gymnastics);

        China_Men.addComponent(Shooting);

        Germany_Women.addComponent(Cycling);
        Germany_Women.addComponent(Tennis);

        Germany_Men.addComponent(Table_Tennis);
        Germany_Men.addComponent(Footbal_1);

        Italy_Women.addComponent(Alpine_Sky);

        Italy_Men.addComponent(Footbal_2);
        Italy_Men.addComponent(Swimming_Team);

        Germany_Men.printNameAndAthletes();
        Germany_Team.printNameAndGold();
        Asia_Team.printNameAndGold();
        Olympics_Teams.printNameAndAthletes();


    }
    
}
