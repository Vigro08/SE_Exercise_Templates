package de.uni.koeln.sse.se;

public interface HouseholdItem {

    public void getCost(Visitor visitor);

    public void getInstructions(Visitor visitor);

}
