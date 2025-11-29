public class AssignmentTwo {
    public static void main(String[] args) {}
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
    public void partFourA() {}
    public void partFourB() {}
    public void partFive() {}
    public void partSix() {}
    public void partSeven() {}
}