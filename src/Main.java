import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            List<Customer> customers = LoadData.loadCustomers("customers.txt");
            List<Tech> techs = LoadData.loadTechs("techs.txt");

            int queueSize = BPInput.getNumInRange("Enter number of customers in queue between 0-1000:", 0, customers.size());
            int workingTechs = BPInput.getNumInRange("Enter number of techs currently working between 0-50:", 0, techs.size());
            int hours = BPInput.getNumInRange("Enter number of hours to simulate:", 1, 1000);
            int updateInterval = BPInput.getNumInRange("Enter update interval in minutes:", 1, 60);
            int callRate = BPInput.getNumInRange("Enter call rate in minutes:", 1, 60);
            double meanCallTime = BPInput.getDoubleMin("Enter average call time in minutes:", 0.1);
            double stdDev = BPInput.getDoubleMin("Enter standard deviation of call time:", 0.0);

            List<Customer> initialCustomers = Selector.pickRandom(customers, queueSize);
            List<Tech> initialTechs = Selector.pickRandom(techs, workingTechs);

            Simulation simulation = new Simulation(customers, initialTechs,
                    hours, updateInterval, callRate, meanCallTime, stdDev);

            simulation.addCustomers(initialCustomers);
            simulation.simulate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}