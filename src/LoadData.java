import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LoadData {

    public static List<Customer> loadCustomers(String filename) throws FileNotFoundException {
        List<Customer> customers = new ArrayList<>();
        Scanner scanner = new Scanner(new File(filename));

        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.split(",");
            int customerNumber = Integer.parseInt(parts[0].trim());
            String firstName = parts[1].trim();
            String lastName = parts[2].trim();
            String email = parts[3].trim();
            String phone = parts[4].trim();
            customers.add(new Customer(customerNumber, firstName, lastName, email, phone));
        }

        scanner.close();
        return customers;
    }

    public static List<Tech> loadTechs(String filename) throws FileNotFoundException {
        List<Tech> techs = new ArrayList<>();
        Scanner scanner = new Scanner(new File(filename));

        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.split(",");
            int id = Integer.parseInt(parts[0].trim());
            String firstName = parts[1].trim();
            String lastName = parts[2].trim();
            String username = parts[3].trim();
            techs.add(new Tech(id, firstName, lastName, username));
        }

        scanner.close();
        return techs;
    }
}
