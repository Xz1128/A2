import java.util.*;
import java.io.*;

public class Ride implements RideInterface {
    // The attributes of the facilities
    private String rideName;
    private String rideType;
    private Employee operator;
    private int maxRider;
    private int numOfCycles;


    private Queue<Visitor> waitingLine;
    private LinkedList<Visitor> rideHistory;

    // Default constructor
    public Ride() {
        this.rideName = "Unknown Ride";
        this.rideType = "Unknown Type";
        this.operator = null;
        this.maxRider = 2;
        this.numOfCycles = 0;

    }

    // Parameterized constructor
    public Ride(String rideName, String rideType, Employee operator, int maxRider) {
        this.rideName = rideName;
        this.rideType = rideType;
        this.operator = operator;
        this.maxRider = maxRider;
        this.numOfCycles = 0;

    }

    // Getters and Setters
    public String getRideName() {
        return rideName;
    }

    public void setRideName(String rideName) {
        this.rideName = rideName;
    }

    public String getRideType() {
        return rideType;
    }

    public void setRideType(String rideType) {
        this.rideType = rideType;
    }

    public Employee getOperator() {
        return operator;
    }

    public void setOperator(Employee operator) {
        this.operator = operator;
    }

    public int getMaxRider() {
        return maxRider;
    }

    public void setMaxRider(int maxRider) {
        this.maxRider = maxRider;
    }

    public int getNumOfCycles() {
        return numOfCycles;
    }

    public void setNumOfCycles(int numOfCycles) {
        this.numOfCycles = numOfCycles;
    }

    // Part3
    @Override
    public void addVisitorToQueue(Visitor visitor) {
        if (visitor != null) {
            waitingLine.add(visitor);
            System.out.println("Success: " + visitor.getName() + " added to the queue for " + rideName);
        } else {
            System.out.println("Failure: Cannot add null visitor to queue");
        }
    }

    @Override
    public void removeVisitorFromQueue() {
        if (!waitingLine.isEmpty()) {
            Visitor removed = waitingLine.poll();
            System.out.println("Success: " + removed.getName() + " removed from the queue");
        } else {
            System.out.println("Failure: Queue is empty, cannot remove visitor");
        }
    }

    @Override
    public void printQueue() {
        if (waitingLine.isEmpty()) {
            System.out.println("Queue for " + rideName + " is empty");
            return;
        }

        System.out.println("Waiting queue for " + rideName + ":");
        int position = 1;
        for (Visitor visitor : waitingLine) {
            System.out.println(position + ". " + visitor);
            position++;
        }
    }

    // Part 4A
    @Override
    public void addVisitorToHistory(Visitor visitor) {
        if (visitor != null) {
            rideHistory.add(visitor);
            System.out.println("Success: " + visitor.getName() + " added to ride history");
        } else {
            System.out.println("Failure: Cannot add null visitor to history");
        }
    }

    @Override
    public boolean checkVisitorFromHistory(Visitor visitor) {
        if (visitor == null) {
            System.out.println("Failure: Cannot check null visitor");
            return false;
        }

        boolean found = rideHistory.contains(visitor);
        System.out.println("Check result for " + visitor.getName() + ": " + (found ? "Found in history" : "Not found in history"));
        return found;
    }

    @Override
    public int numberOfVisitors() {
        int count = rideHistory.size();
        System.out.println("Number of visitors in history: " + count);
        return count;
    }

    @Override
    public void printRideHistory() {
        if (rideHistory.isEmpty()) {
            System.out.println("Ride history for " + rideName + " is empty");
            return;
        }

        System.out.println("Ride history for " + rideName + " (using Iterator):");
        Iterator<Visitor> iterator = rideHistory.iterator();
        int count = 1;
        while (iterator.hasNext()) {
            System.out.println(count + ". " + iterator.next());
            count++;
        }
    }

    // Run the ride for one cycle (move visitors from queue to history)
    @Override
    public void runOneCycle() {
        if (!waitingLine.isEmpty()) {
            Visitor visitor = waitingLine.poll();
            addVisitorToHistory(visitor);
            System.out.println(visitor.getName() + " has taken the ride.");
        } else {
            System.out.println("No visitors in the queue to run the ride.");
        }
    }
}


