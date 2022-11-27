package de.uni.koeln.sse.se;

public class ElementVisitor implements Visitor {

    @Override
    public void visitCost(Electronic e) {

        if (e.getFragile()) {
            
            Double cost = (double) (e.getWeight() / 2);
            System.out.println("Total Cost for " + e.getName() + " is: " + cost + " Euros");

        } else {
            Double cost = (double) (e.getWeight() / 3);
            System.out.println("Total Cost for " + e.getName() + " is: " + cost + " Euros");
        }
            
    }

    @Override
    public void visitCost(Furniture e) {
        Double cost = (double) (e.getWeight() / 4);
        System.out.println("Total Cost for " + e.getName() + " is: " + cost + " Euros");

    }

    @Override
    public void visitCost(Glass e) {

        if (e.getTickness() == 1) {
            Double cost = (double) (e.getLenght()) / 50;
            System.out.println("Total Cost for " + e.getName() + " is: " + cost + " Euros");

        } else if (e.getTickness() == 2) {
            Double cost = (double) (e.getLenght()) / 100 * 1.2;
            System.out.println("Total Cost for " + e.getName() + " is: " + cost + " Euros");

        } else if (e.getTickness() == 3) {
            Double cost = (double) (e.getLenght()) / 100 * 0.7;
            System.out.println("Total Cost for " + e.getName() + " is: " + cost + " Euros");

        } else {

            System.out.println("Error calculating Cost of: " + e.getName());
        }

    }

    @Override
    public void visitInstructions(Electronic e) {

        System.out.println("Should be covered with Polyethylene foam film and packed in a box with dimension: " + (e.getHeight() + 1) + "x" + (e.getLenght() + 1) + "x" + (e.getWidth() + 1));
    }

    @Override
    public void visitInstructions(Glass e) {

        System.out.println("Should be wrapped with Bubble wraps and packed in a box with dimension: " + (e.getHeight() + 1) + "x" + (e.getLenght() + 1) + "x" + (e.getWidth() + 1));
    }

    @Override
    public void visitInstructions(Furniture e) {

        System.out.println("Should be covered with waterproof covers with area of: " + (e.getLenght()) + "x" + (e.getWidth()));
    }

}