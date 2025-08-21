package ru.stqa.addressbook.model;

public record ContactData(String id, String firstName, String middleName, String lastName,
                          String address, String photo, String phone1, String phone2,
                          String phone3, String email1, String email2, String email3) {

    public ContactData(){
        this("", "", "", "", "", "", "", "", "", "", "", "");
    }

    public ContactData withId(String id) {
        return new ContactData(id, this.firstName, this.middleName, this.lastName, this.address,
                this.photo, this.phone1, this.phone2, this.phone3, this.email1, this.email2, this.email3);
    }

    public ContactData withName(String firstName, String lastName) {
        return new ContactData(this.id, firstName, this.middleName, lastName, this.address,
                this.photo, this.phone1, this.phone2, this.phone3, this.email1, this.email2, this.email3);
    }

    public ContactData withMiddleName(String middleName) {
        return new ContactData(this.id, this.firstName, middleName, this.lastName, this.address,
                this.photo, this.phone1, this.phone2, this.phone3, this.email1, this.email2, this.email3);
    }

    public ContactData withAddress(String address) {
        return new ContactData(this.id, this.firstName, this.middleName, this.lastName, address,
                this.photo, this.phone1, this.phone2, this.phone3, this.email1, this.email2, this.email3);
    }

    public ContactData withPhoto(String photo) {
        return new ContactData(this.id, this.firstName, this.middleName, this.lastName, this.address,
                photo, this.phone1, this.phone2, this.phone3, this.email1, this.email2, this.email3);
    }

    public ContactData withPhones(String phone1, String phone2, String phone3) {
        return new ContactData(this.id, this.firstName, this.middleName, this.lastName, this.address,
                this.photo, phone1, phone2, phone3, this.email1, this.email2, this.email3);
    }

    public ContactData withEmail(String email1, String email2, String email3) {
        return new ContactData(this.id, this.firstName, this.middleName, this.lastName, this.address,
                this.photo, this.phone1, this.phone2, this.phone3, email1, email2, email3);
    }
}