public class Tech {
    private int id;
    private String firstName;
    private String lastName;
    private String userName;

    public Tech(int id, String firstName, String lastName, String userName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUserName() {
        return userName;
    }

    @Override
    public String toString() {
        return "Tech ID: " + id + ", First Name: " + firstName + ", Last Name: " + lastName  + ", User Name: " + userName;
    }
}
