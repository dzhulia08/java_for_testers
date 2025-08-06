package model;

public record ContactData(String firstName, String middleName, String lastName, String address, String phone1, String phone2, String phone3, String email1, String email2, String email3) {

    public ContactData(){
        this("", "", "", "", "", "", "", "", "", "");
    }

    public ContactData withName(String firstName, String lastName) {
        return new ContactData(firstName, this.middleName, lastName, this.address,
                this.phone1, this.phone2, this.phone3, this.email1, this.email2, this.email3);
    }

    public ContactData withAddress(String address) {
        return new ContactData(this.firstName, this.middleName, this.lastName, address,
                this.phone1, this.phone2, this.phone3, this.email1, this.email2, this.email3);
    }

    public ContactData withPhones(String phone1, String phone2, String phone3) {
        return new ContactData(this.firstName, this.middleName, this.lastName, this.address,
                phone1, phone2, phone3, this.email1, this.email2, this.email3);
    }

    public ContactData withEmail(String email1, String email2, String email3) {
        return new ContactData(this.firstName, this.middleName, this.lastName, this.address,
                this.phone1, this.phone2, this.phone3, email1, email2, email3);
    }
}