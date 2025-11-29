public class Ride {
    // The attributes of the facilities
    private String rideName;
    private String rideType;
    private Employee operator;
    private int maxRider;
    private int numOfCycles;


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

}