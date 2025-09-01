public class Contacts {
    private int contactId;
    private String name;
    private String phoneNumber;
    private String address;
    private String emailAddress;
    private String isFavorite;

    public Contacts(int contactId,String name,String phoneNumber,String address,String emailAddress, String isFavorite){
        this.contactId=contactId;
        this.name=name;
        this.phoneNumber=phoneNumber;
        this.address=address;
        this.emailAddress=emailAddress;
        this.isFavorite = isFavorite;
    }
    public void print(){
        System.out.println(contactId+"      "+name+"     "+phoneNumber+"           "+address+"        "+emailAddress);
        System.out.println("--------------------------------------------------------------------------------------");
    }

    public void setContactId(int contactId) {
        this.contactId = contactId;
    }

    public int getContactId() {
        return contactId;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setName(String name) {
        this.name = name;
    }


    // Setter for address
    public void setAddress(String address) {
        this.address = address;
    }


    // Setter for phone number
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmailAddress(String emailAddress) {
     this.emailAddress=emailAddress;
    }
    public String isFavorite() {
        return isFavorite;
    }

    public void setFavorite(String favorite) {
        isFavorite = favorite;
    }

}
