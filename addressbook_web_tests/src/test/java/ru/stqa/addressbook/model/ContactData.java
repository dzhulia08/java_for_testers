package ru.stqa.addressbook.model;

public record ContactData(String id, String firstName, String middleName, String lastName,
                          String address, String photo, String home, String mobile,
                          String work, String secondary, String email1, String email2, String email3) {

    public ContactData(){
        this("", "", "", "", "",
                "", "", "", "", "", "", "", "");
    }

    public ContactData withId(String id) {
        return new ContactData(id, this.firstName, this.middleName, this.lastName, this.address,
                this.photo, this.home, this.mobile, this.work, this.secondary, this.email1, this.email2, this.email3);
    }

    public ContactData withName(String firstName, String lastName) {
        return new ContactData(this.id, firstName, this.middleName, lastName, this.address,
                this.photo, this.home, this.mobile, this.work, this.secondary, this.email1, this.email2, this.email3);
    }

    public ContactData withMiddleName(String middleName) {
        return new ContactData(this.id, this.firstName, middleName, this.lastName, this.address,
                this.photo, this.home, this.mobile, this.work, this.secondary, this.email1, this.email2, this.email3);
    }

    public ContactData withAddress(String address) {
        return new ContactData(this.id, this.firstName, this.middleName, this.lastName, address,
                this.photo, this.home, this.mobile, this.work, this.secondary, this.email1, this.email2, this.email3);
    }

    public ContactData withPhoto(String photo) {
        return new ContactData(this.id, this.firstName, this.middleName, this.lastName, this.address,
                photo, this.home, this.mobile, this.work, this.secondary, this.email1, this.email2, this.email3);
    }

    public ContactData withPhones(String home, String mobile, String work) {
        return new ContactData(this.id, this.firstName, this.middleName, this.lastName, this.address,
                this.photo, home, mobile, work, this.secondary, this.email1, this.email2, this.email3);
    }

    public ContactData withHome(String home) {
        return new ContactData(this.id, this.firstName, this.middleName, this.lastName, this.address,
                this.photo, home, this.mobile, this.work, this.secondary, this.email1, this.email2, this.email3);
    }

    public ContactData withMobile(String mobile) {
        return new ContactData(this.id, this.firstName, this.middleName, this.lastName, this.address,
                this.photo, this.home, mobile, this.work, this.secondary, this.email1, this.email2, this.email3);
    }

    public ContactData withWork(String work) {
        return new ContactData(this.id, this.firstName, this.middleName, this.lastName, this.address,
                this.photo, this.home, this.mobile, work, this.secondary, this.email1, this.email2, this.email3);
    }

    public ContactData withSecondary(String secondary) {
        return new ContactData(this.id, this.firstName, this.middleName, this.lastName, this.address,
                this.photo, this.home, this.mobile, this.work, secondary, this.email1, this.email2, this.email3);
    }

    public ContactData withEmail(String email1, String email2, String email3) {
        return new ContactData(this.id, this.firstName, this.middleName, this.lastName, this.address,
                this.photo, this.home, this.mobile, this.work, this.secondary, email1, email2, email3);
    }
}