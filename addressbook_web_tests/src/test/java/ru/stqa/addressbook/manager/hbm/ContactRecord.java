package ru.stqa.addressbook.manager.hbm;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="addressbook")
public class ContactRecord {
    @Id
    @Column(name = "id")
    public int id;
    @Column(name = "firstname")
    public String firstname;
    @Column(name = "middlename")
    public String middlename;
    @Column(name = "lastname")
    public String lastname;
    @Column(name = "address")
    public String address;
    @Column(name = "home")
    public String home;
    @Column(name = "mobile")
    public String mobile;
    @Column(name = "work")
    public String work;
    @Column(name = "phone2")
    public String phone2;
    @Column(name = "email")
    public String email;
    @Column(name = "email2")
    public String email2;
    @Column(name = "email3")
    public String email3;

    public String deprecated = "2025-08-25 22:47:39";

    public String nickname = "nickname";

    public String company = "company";

    public String title = "title";

    public String fax = "79000000000";

    public String homepage = "homepage";

    public String photo = "src/test/resources/images/avatar.png";

    public ContactRecord() {
    }

    public ContactRecord(int id, String firstname, String middlename, String lastname,
                         String address, String home, String mobile, String work, String phone2,
                         String email, String email2, String email3) {
        this.id = id;
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.address = address;
        this.home = home;
        this.mobile = mobile;
        this.phone2 = phone2;
        this.work = work;
        this.email = email;
        this.email2 = email2;
        this.email3 = email3;
    }

}
