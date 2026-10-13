public class Customer {
    private int customerNumber;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;

    public Customer(int customerNumber, String firstName, String lastName, String email, String phone) {
        this.customerNumber = customerNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "Customer number: " + customerNumber + ", First Name: " + firstName + ", Last Name: " +
                lastName + ", Email: " + email + ", Phone: " + phone;
    }
}
