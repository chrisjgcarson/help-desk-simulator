import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;

public class Simulation {
    private HashSetQueue<Customer> customerQueue;
    private HashSetQueue<Tech> techQueue;
    private PriorityQueue<SupportSession> sessionQueue;
    private List<Customer> customers;

    private int simulationLength;
    private int updateInterval;
    private int callRate;
    private double meanCallTime;
    private double stdDevCallTime;

    private int currentTime;
    private int nextCallTime;
    private int nextReportTime;

    private Random rand;

    public Simulation(List<Customer> allCustomers, List<Tech> workingTechs, int simulationLength,
                      int updateInterval, int callRate, double meanCallTime, double stdDevCallTime) {
        this.customers = allCustomers;

        customerQueue = new HashSetQueue<>();
        techQueue = new HashSetQueue<>();
        sessionQueue = new PriorityQueue<>();

        for (Tech tech : workingTechs) {
            techQueue.add(tech);
        }

        this.simulationLength = simulationLength * 60;
        this.updateInterval = updateInterval;
        this.callRate = callRate;
        this.meanCallTime = meanCallTime;
        this.stdDevCallTime = stdDevCallTime;
        this.currentTime = 0;
        this.nextCallTime = callRate;
        this.nextReportTime = updateInterval;
        this.rand = new Random();
    }

    public void simulate() {
        System.out.println("Starting simulation");

        while (currentTime < simulationLength) {
            endSessions();
            newCalls();
            newSessions();
            showReports();
            currentTime++;

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Simulation done");
    }

    public void addCustomers(List<Customer> customers) {
        for (Customer customer : customers) {
            customerQueue.add(customer);
        }
    }

    private void newCalls() {
        if (currentTime >= nextCallTime) {
            Customer newCustomer = null;

            do {
                int index = rand.nextInt(customers.size());
                newCustomer = customers.get(index);
            } while (!customerQueue.add(newCustomer));

            System.out.println("Incoming call from Customer: " + newCustomer.getFirstName() + " " +
                    newCustomer.getLastName() + " " +
                    newCustomer.getCustomerNumber());

            nextCallTime = currentTime + callRate;
        }
    }

    private void newSessions() {
        while (customerQueue.size() > 0 && techQueue.size() > 0) {
            Customer customer = customerQueue.remove();
            Tech tech = techQueue.remove();

            double callLength = rand.nextGaussian() * stdDevCallTime + meanCallTime;

            if (callLength < 1.0) {
                callLength = 1.0;
            }

            int endTime = currentTime + (int) Math.ceil(callLength);
            SupportSession session = new SupportSession(customer, tech, callLength, endTime);
            sessionQueue.add(session);

            int startHour = currentTime / 60;
            int startMinute = currentTime % 60;
            int endHour = endTime / 60;
            int endMinute = endTime % 60;

            System.out.println("New session has begun | Tech: " + tech.getFirstName() + " "
                    + tech.getLastName() + " " + tech.getId() + " with Customer: " + customer.getFirstName() +
                    " " + customer.getLastName() + " " + customer.getCustomerNumber() + " | Duration: " +
                    String.format("%.1f", callLength) + " minutes" +
                    String.format(" | Call starts at: %02d:%02d", startHour, startMinute) +
                    String.format(" | Ends at: %02d:%02d", endHour, endMinute));
        }
    }

    private void endSessions() {
        while (!sessionQueue.isEmpty() && sessionQueue.peek().getEndTime() <= currentTime) {
            SupportSession session = sessionQueue.poll();
            techQueue.add(session.getTech());

            int endHour = currentTime / 60;
            int endMinute = currentTime % 60;

            System.out.println("Session Ended | Tech: " + session.getTech().getFirstName() + " " + session.getTech().getLastName() + " " + session.getTech().getId() +
                    " | Customer: " + session.getCustomer().getFirstName() + " " + session.getCustomer().getLastName() + " " + session.getCustomer().getCustomerNumber() +
                    " | Duration: " + String.format("%.1f", session.getCallLength()) + " minutes" +
                    String.format(" | Ended at: %02d:%02d", endHour, endMinute));
        }
        System.out.println();
    }


    private void showReports() {
        if (currentTime >= nextReportTime) {
            System.out.println();
            System.out.println("Report time at minute: " + currentTime);
            System.out.println("Customers waiting: " + customerQueue.size());
            System.out.println("Techs available: " + techQueue.size());
            System.out.println("Sessions in progress: " + sessionQueue.size());
            System.out.println();

            nextReportTime = currentTime + updateInterval;
        }
    }
}
