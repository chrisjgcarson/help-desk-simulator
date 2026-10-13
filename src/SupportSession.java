public class SupportSession implements Comparable<SupportSession> {
    private Customer customer;
    private Tech tech;
    private double callLength;
    private int endTime;

    public SupportSession(Customer customer, Tech tech, double callLength, int endTime) {
        this.customer = customer;
        this.tech = tech;
        this.callLength = callLength;
        this.endTime = endTime;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Tech getTech() {
        return tech;
    }

    public double getCallLength() {
        return callLength;
    }

    public int getEndTime() {
        return endTime;
    }

    @Override
    public int compareTo(SupportSession o) {
        return Integer.compare(this.endTime, o.endTime);
    }

    @Override
    public String toString() {
        return "Session: " + tech.toString() + ", Call Length: " + callLength + ", End Time: " + endTime;
    }
}
