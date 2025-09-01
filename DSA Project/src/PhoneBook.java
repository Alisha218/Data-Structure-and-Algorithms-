import java.sql.*;


public class PhoneBook {
    private Contacts[] Array;
    private int size;
    private Connection connection;

    public PhoneBook(int size) {
        this.size = size;
        this.Array = new Contacts[size];

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/phonebook", "root", "alisha");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private boolean isValidPhoneNumber(String phoneNumber) {
        // Validates if the phone number is exactly 10 digits long
        return phoneNumber != null && phoneNumber.matches("\\d{10}");
    }


    private void isValidContact(Contacts contact) {
        // Validate Contact ID: Ensure it is positive and not null
        try {
            if (contact.getContactId() <= 0  ) {
                System.out.println("Invalid Contact ID: It must be a positive integer.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid Contact ID: It must be a valid number.");
        }

        // Validate Phone Number: Ensure it's exactly 10 digits
        if (!isValidPhoneNumber(contact.getPhoneNumber())) {
            System.out.println("Invalid Phone Number: It must be exactly 10 digits.");
        }
    }

    private int count = 0;
    // Method to insert a new contact
    public void insert(Contacts contact) {
        // Validate the contact
        isValidContact(contact);

        // If there are validation errors, don't proceed with inserting the contact
        if (!isValidPhoneNumber(contact.getPhoneNumber())) {
            return; // Exit if invalid
        }

        // Check if array is full
        if (Array.length == count) {
            // Resize the array (double its size)
            Contacts[] newArray = new Contacts[count * 2];
            for (int i = 0; i < count; i++) {
                newArray[i] = Array[i]; // Copy items from old array to new array

                Array = newArray;
            }
        }

        // Add the new contact to the array
        Array[++count] = contact;

        // Database insertion (assuming 'connection' is a valid database connection)
        String sql = "INSERT INTO contacts (contactId, name, phoneNumber, address, emailAddress, isFavorite) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, contact.getContactId());
            statement.setString(2, contact.getName());
            statement.setString(3, contact.getPhoneNumber());
            statement.setString(4, contact.getAddress());
            statement.setString(5, contact.getEmailAddress());
            statement.setString(6, contact.isFavorite());

            // Execute the update to insert the contact into the database
            statement.executeUpdate();
            System.out.println("Contact Added Successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }




    public void delete(int Contactid){
        int index=-1;
        for(int i=0;i<count;i++){
            if(Array[i].getContactId()==Contactid){
                index=i;
                break;
            }
            if(index==-1){
                System.out.println("ID don't found.");
                return;
            }
        }
        for(int i=index;i<count-1;i++){//iterate from index to count-1
            Array[i]=Array[i+1]; // assign index an increment index value
        }
        count--;

        String sql="Delete from contacts where contactId=?";
        try(PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1,Contactid);
            int rowsAffected = statement.executeUpdate(); // Returns the number of rows affected

            if (rowsAffected > 0) {
                System.out.println("Contact Deleted Successfully");
            } else {
                System.out.println("No contact found with the specified ID.");
            }

        }
        catch(SQLException e){
            e.printStackTrace();

        }



    }


    public void display(){
        String sql="select * from contacts ";
        try(Statement statement=connection.createStatement()){
            ResultSet rs= statement.executeQuery(sql);
            System.out.printf("%-10s %-20s %-15s %-25s %-30s%n", "ID", "Name", "Phone Number", "Address", "Email Address");
            System.out.println("----------------------------------------------------------------------------");

            while(rs.next()){
                int contactId=rs.getInt("contactId");
                String name=rs.getString("name");
                String PhoneNumber =rs.getString("PhoneNumber");
                String address=rs.getString("address");
                String emailAddress=rs.getString("emailAddress");

                System.out.printf("%-10d %-20s %-15s %-25s %-30s%n", contactId, name, PhoneNumber, address, emailAddress);


            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // Method to sort contacts by name
    public void loadContactsFromDatabase() {
        count = 0; // Reset the count
        Array = new Contacts[size]; // Clear the array and reset size
        String sql = "SELECT * FROM contacts";
        try (Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                if (count == Array.length)  {
                    // Resize the array (double its size)
                    Contacts[] newArray = new Contacts[count * 2];
                    for (int i = 0; i < count; i++) {
                        newArray[i] = Array[i]; // Copy items from old array to new array
                    }
                    Array = newArray;

                }


                int contactId = rs.getInt("contactId");
                String name = rs.getString("name");
                String phoneNumber = rs.getString("phoneNumber");
                String address = rs.getString("address");
                String emailAddress = rs.getString("emailAddress");
                String isFavorite = rs.getString("isFavorite");

                // Create a new Contacts object and add it to the array
                Array[count++] = new Contacts(contactId, name, phoneNumber, address, emailAddress,isFavorite);


            }
            System.out.println("Contacts loaded successfully from database.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to sort contacts by name using Bubble Sort
    public void sortContactsByName() {
        loadContactsFromDatabase();
        for (int i = 0; i < count - 1; i++) {
            for (int j = 0; j < count - i - 1; j++) {
                if (Array[j].getName().compareToIgnoreCase(Array[j + 1].getName()) > 0) {
                    // Swap contacts
                    Contacts temp = Array[j];
                    Array[j] = Array[j + 1];
                    Array[j + 1] = temp;
                }
            }
        }
        System.out.println("Contacts sorted by name.");
        System.out.println("------------------------------------------------------ PHONEBOOK ----------------------------------------------");
        System.out.printf("%-10s %-20s %-15s %-25s %-30s%n", "ID", "Name", "Phone Number", "Address", "Email Address");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------");

        for (int i = 0; i < count; i++) {
            Array[i].print();
        }
    }
    // Method to search for a contact by name
    public void searchByName(String name) {
        loadContactsFromDatabase();
        boolean found = false;
        for (int i = 0; i < count; i++) {
            if (Array[i].getName().equalsIgnoreCase(name)) {
                System.out.println("Contact Found:");
                Array[i].print();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No contact found with the name: " + name);
        }
    }

    // Method to search for a contact by phone number
    public void searchByPhoneNumber(String phoneNumber) {
        loadContactsFromDatabase();
        boolean found = false;
        for (int i = 0; i < count; i++) {
            if (Array[i].getPhoneNumber().equals(phoneNumber)) {
                System.out.println("Contact Found:");
                Array[i].print();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No contact found with the phone number: " + phoneNumber);
        }
    }

    public void updateContact(int id, String name, String phoneNumber, String address, String emailAddress) {

        loadContactsFromDatabase();
        boolean found = false;

        // Update in-memory array
        for (int i = 0; i < count; i++) {
            if (Array[i].getContactId() == id) {
                found = true;

                // Update fields only if new values are provided (not null)
                if (name != null) Array[i].setName(name);
                if (phoneNumber != null) Array[i].setPhoneNumber(phoneNumber);
                if (address != null) Array[i].setAddress(address);
                if (emailAddress != null) Array[i].setEmailAddress(emailAddress);

                // Update in database
                String sql = "UPDATE contacts SET name = ?, phoneNumber = ?, address = ?, emailAddress = ? WHERE contactId = ?";
                try (PreparedStatement statement = connection.prepareStatement(sql)) {
                    statement.setString(1, Array[i].getName());
                    statement.setString(2, Array[i].getPhoneNumber());
                    statement.setString(3, Array[i].getAddress());
                    statement.setString(4, Array[i].getEmailAddress());
                    statement.setInt(5, id);

                    statement.executeUpdate();
                    System.out.println("Contact updated successfully in database.");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            }
        }

        if (!found) {
            System.out.println("Contact with ID " + id + " not found.");
        }
    }

    public void displayFavorites() {
        loadContactsFromDatabase();
        System.out.println("Favorite Contacts:");
        boolean found = false;

        for (int i = 0; i < count; i++) {
            if ("true".equals(Array[i].isFavorite())) {
                Array[i].print();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No favorite contacts found.");
        }
    }



}


