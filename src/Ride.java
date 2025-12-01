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
        this.waitingLine = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
    }

    // Parameterized constructor
    public Ride(String rideName, String rideType, Employee operator, int maxRider) {
        this.rideName = rideName;
        this.rideType = rideType;
        this.operator = operator;
        this.maxRider = maxRider;
        this.numOfCycles = 0;
        this.waitingLine = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
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

    // Part 4B
    public void sortRideHistory(Comparator<Visitor> comparator) {
        if (rideHistory.size() > 1) {
            Collections.sort(rideHistory, comparator);
            System.out.println("Success: Ride history sorted");
        } else {
            System.out.println("Info: Not enough visitors to sort");
        }
    }


    // Part 5
    @Override
    public void runOneCycle() {
        // Check if there is an operator.
        if (operator == null) {
            System.out.println("Failure: No operator assigned to the ride. Cannot run.");
            return;
        }

        // Check if the queue is empty.
        if (waitingLine.isEmpty()) {
            System.out.println("Failure: No visitors in the queue. Cannot run.");
            return;
        }

        // Calculate the number of tourists that can be carried this time.
        int visitorsToTake = Math.min(maxRider, waitingLine.size());
        System.out.println("Running one cycle of " + rideName + ". Taking " + visitorsToTake + " visitors.");

        // Remove from the queue and add to the history record.
        for (int i = 0; i < visitorsToTake; i++) {
            Visitor visitor = waitingLine.poll();
            if (visitor != null) {
                rideHistory.add(visitor);
                System.out.println("  - " + visitor.getName() + " has taken the ride");
            }
        }

        // Increase the cycle count
        numOfCycles++;
        System.out.println("Cycle completed. Total cycles run: " + numOfCycles);
    }

    // Part 6
    public void exportRideHistory(String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (Visitor visitor : rideHistory) {
                // format: name,age,id,ticketNumber,membershipLevel
                writer.println(visitor.getName() + "," +
                        visitor.getAge() + "," +
                        visitor.getId() + "," +
                        visitor.getTicketNumber() + "," +
                        visitor.getMembershipLevel());
            }
            System.out.println("Success: Ride history exported to " + filename);
        } catch (IOException e) {
            System.out.println("Failure: Error exporting ride history - " + e.getMessage());
        }
    }

    // Part 7
    public void importRideHistory(String filename) {
        int importedCount = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 5) {
                    try {
                        String name = parts[0];
                        int age = Integer.parseInt(parts[1]);
                        String id = parts[2];
                        String ticketNumber = parts[3];
                        String membershipLevel = parts[4];

                        Visitor visitor = new Visitor(name, age, id, ticketNumber, membershipLevel);
                        rideHistory.add(visitor);
                        importedCount++;
                    } catch (NumberFormatException e) {
                        System.out.println("Warning: Skipping invalid line - " + line);
                    }
                }
            }
            System.out.println("Success: Imported " + importedCount + " visitors from " + filename);
        } catch (IOException e) {
            System.out.println("Failure: Error importing ride history - " + e.getMessage());
        }
    }
}


