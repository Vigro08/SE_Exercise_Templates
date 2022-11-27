package de.uni.koeln.sse.se;

public interface Visitor {

    public void visitCost(Glass glass);

    public void visitCost(Electronic electronic);

    public void visitCost(Furniture furniture);
    
    public void visitInstructions(Glass glass);

    public void visitInstructions(Electronic electronice);

    public void visitInstructions(Furniture furniture);
}
