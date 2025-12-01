public class AssignmentTwo {
    public static void main(String[] args) {
        AssignmentTwo assignment = new AssignmentTwo();

        System.out.println("=== Part 3 Demonstration ===");
        assignment.partThree();

        System.out.println("\n=== Part 4A Demonstration ===");
        assignment.partFourA();

        System.out.println("\n=== Part 4B Demonstration ===");
        assignment.partFourB();

        System.out.println("\n=== Part 5 Demonstration ===");
        assignment.partFive();

        System.out.println("\n=== Part 6 Demonstration ===");
        assignment.partSix();

        System.out.println("\n=== Part 7 Demonstration ===");
        assignment.partSeven();
    }
    public void partThree() {
        // Establish facilities and operators
        Employee operator = new Employee("John Operator", 30, "EMP001", "E001", "Ride Operations");
        Ride rollerCoaster = new Ride("Thunder Bolt", "Roller Coaster", operator, 2);

        // Create a tourist and add them to the queue
        Visitor v1 = new Visitor("Alice", 25, "V001", "T001", "Gold");
        Visitor v2 = new Visitor("Bob", 30, "V002", "T002", "Silver");
        Visitor v3 = new Visitor("Charlie", 22, "V003", "T003", "Standard");
        Visitor v4 = new Visitor("Diana", 28, "V004", "T004", "Gold");
        Visitor v5 = new Visitor("Eve", 35, "V005", "T005", "Standard");

        // Add to the queue
        rollerCoaster.addVisitorToQueue(v1);
        rollerCoaster.addVisitorToQueue(v2);
        rollerCoaster.addVisitorToQueue(v3);
        rollerCoaster.addVisitorToQueue(v4);
        rollerCoaster.addVisitorToQueue(v5);

        // Print the queue
        rollerCoaster.printQueue();

        // Remove a visitor
        rollerCoaster.removeVisitorFromQueue();

        // Print the queue again
        rollerCoaster.printQueue();
    }

    public void partFourA() {
        // Establish facilities
        Ride waterRide = new Ride("Splash Mountain", "Water Ride", null, 4);

        // Create a tourist and add to the history record.
        Visitor v1 = new Visitor("Frank", 20, "V006", "T006", "Standard");
        Visitor v2 = new Visitor("Grace", 27, "V007", "T007", "Gold");
        Visitor v3 = new Visitor("Henry", 32, "V008", "T008", "Silver");
        Visitor v4 = new Visitor("Ivy", 19, "V009", "T009", "Standard");
        Visitor v5 = new Visitor("Jack", 40, "V010", "T010", "Platinum");

        waterRide.addVisitorToHistory(v1);
        waterRide.addVisitorToHistory(v2);
        waterRide.addVisitorToHistory(v3);
        waterRide.addVisitorToHistory(v4);
        waterRide.addVisitorToHistory(v5);

        // Check if there are any tourists present.
        waterRide.checkVisitorFromHistory(v2);
        waterRide.checkVisitorFromHistory(new Visitor("Unknown", 0, "X000", "T000", "Standard"));

        // Print the number of tourists.
        waterRide.numberOfVisitors();

        // Print the history record.
        waterRide.printRideHistory();

    }

    public void partFourB() {
        // Establish facilities
        Ride ferrisWheel = new Ride("Sky Wheel", "Ferris Wheel", null, 6);

        // Create a tourist and add to the history record.
        Visitor v1 = new Visitor("Oliver", 45, "V011", "T011", "Gold");
        Visitor v2 = new Visitor("Liam", 22, "V012", "T012", "Standard");
        Visitor v3 = new Visitor("Emma", 22, "V013", "T013", "Silver");
        Visitor v4 = new Visitor("Ava", 30, "V014", "T014", "Gold");
        Visitor v5 = new Visitor("Noah", 18, "V015", "T015", "Standard");

        ferrisWheel.addVisitorToHistory(v1);
        ferrisWheel.addVisitorToHistory(v2);
        ferrisWheel.addVisitorToHistory(v3);
        ferrisWheel.addVisitorToHistory(v4);
        ferrisWheel.addVisitorToHistory(v5);

        System.out.println("Before sorting:");
        ferrisWheel.printRideHistory();

        // Sort
        ferrisWheel.sortRideHistory(new VisitorComparator());

        System.out.println("After sorting:");
        ferrisWheel.printRideHistory();
    }

    public void partFive() {
        // Establish facilities and operate.
        Employee operator = new Employee("Sarah Operator", 28, "EMP002", "E002", "Ride Operations");
        Ride carousel = new Ride("Magic Carousel", "Carousel", operator, 3);

        // Create a tourist and add them to the queue.
        Visitor[] visitors = new Visitor[10];
        for (int i = 0; i < 10; i++) {
            visitors[i] = new Visitor("Visitor" + (i+1), 20 + i, "V" + (100 + i), "T" + (100 + i),
                    i % 2 == 0 ? "Gold" : "Standard");
            carousel.addVisitorToQueue(visitors[i]);
        }

        System.out.println("Initial queue:");
        carousel.printQueue();

        // Run one cycle.
        carousel.runOneCycle();

        System.out.println("Queue after one cycle:");
        carousel.printQueue();

        System.out.println("Ride history after one cycle:");
        carousel.printRideHistory();
    }

    public void partSix() {
        // Establish facilities
        Ride dropTower = new Ride("Free Fall", "Drop Tower", null, 4);

        // Create a tourist and add to the history record
        Visitor v1 = new Visitor("Michael", 25, "V101", "T101", "Gold");
        Visitor v2 = new Visitor("Sarah", 30, "V102", "T102", "Platinum");
        Visitor v3 = new Visitor("David", 22, "V103", "T103", "Standard");
        Visitor v4 = new Visitor("Lisa", 28, "V104", "T104", "Gold");
        Visitor v5 = new Visitor("Kevin", 35, "V105", "T105", "Silver");

        dropTower.addVisitorToHistory(v1);
        dropTower.addVisitorToHistory(v2);
        dropTower.addVisitorToHistory(v3);
        dropTower.addVisitorToHistory(v4);
        dropTower.addVisitorToHistory(v5);

        // Export to file
        dropTower.exportRideHistory("ride_history");
    }
    public void partSeven() {
        // Create new facilities (empty)
        Ride newRide = new Ride("New Adventure", "Adventure Ride", null, 4);

        // Import historical records from the file
        newRide.importRideHistory("ride_history");

        // Confirm the import results
        newRide.numberOfVisitors();
        newRide.printRideHistory();
    }
}