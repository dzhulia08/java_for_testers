package ru.stqa.addressbook.manager;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.cfg.Configuration;
import ru.stqa.addressbook.manager.hbm.ContactRecord;
import ru.stqa.addressbook.manager.hbm.GroupRecord;
import ru.stqa.addressbook.model.ContactData;
import ru.stqa.addressbook.model.GroupData;

import java.util.ArrayList;
import java.util.List;

public class HibernateHelper extends HelperBase {

    private SessionFactory sessionFactory;

    public HibernateHelper(ApplicationManager manager) {

        super(manager);

        sessionFactory = new Configuration()
//                .addAnnotatedClass(Book.class)
                .addAnnotatedClass(GroupRecord.class)
                .addAnnotatedClass(ContactRecord.class)
                .setProperty(AvailableSettings.URL, "jdbc:mysql://localhost/addressbook?zeroDateTimeBehavior=convertToNull")
                .setProperty(AvailableSettings.USER, "root")
                .setProperty(AvailableSettings.PASS, "")
                .buildSessionFactory();
    }

    static List<GroupData> convertList(List<GroupRecord> records) {
        List<GroupData> result = new ArrayList<>();
        for (var record : records) {
            result.add(convert(record));
        }
        return result;
    }

    static List<ContactData> convertContactList(List<ContactRecord> records) {
        List<ContactData> result = new ArrayList<>();
        for (var record : records) {
            result.add(convert(record));
        }
        return result;
    }

    private static GroupData convert(GroupRecord record) {
        return new GroupData("" + record.id, record.name, record.header, record.footer);
    }

    private static ContactData convert(ContactRecord record) {
        return new ContactData("" + record.id, record.firstname, record.middlename,
                record.lastname, record.address, "src/test/resources/images/avatar.png",
                record.home, record.mobile, record.work,
                record.email, record.email2, record.email3);
    }

    private static GroupRecord convert(GroupData data) {
        var id = data.id();
        if ("".equals(id)) {
            id = "0";
        }
        return new GroupRecord(Integer.parseInt(id), data.name(), data.header(), data.footer());
    }

    private static ContactRecord convert(ContactData data) {
        var id = data.id();
        if ("".equals(id)) {
            id = "0";
        }
        return new ContactRecord(Integer.parseInt(id), data.firstName(), data.middleName(),
                data.lastName(), data.address(), data.phone1(), data.phone2(),
                data.phone3(), data.email1(), data.email2(), data.email3());
    }

    public List<GroupData> getGroupList() {
        return convertList(sessionFactory.fromSession(session -> {
            return session.createQuery("from GroupRecord", GroupRecord.class).list();
        }));
    }

    public List<ContactData> getContactList() {
        return convertContactList(sessionFactory.fromSession(session -> {
            return session.createQuery("from ContactRecord", ContactRecord.class).list();
        }));
    }

    public long getGroupCount() {
        return sessionFactory.fromSession(session -> {
            return session.createQuery("select count (*) from GroupRecord", Long.class).getSingleResult();
        });
    }

    public long getContactCount() {
        return sessionFactory.fromSession(session -> {
            return session.createQuery("select count (*) from ContactRecord", Long.class).getSingleResult();
        });
    }

    public void createGroup(GroupData groupData) {
        sessionFactory.inSession(session -> {
            session.getTransaction().begin();
            session.persist(convert(groupData));
            session.getTransaction().commit();
        });
    }

    public void createContact(ContactData contactData) {
        sessionFactory.inSession(session -> {
            session.getTransaction().begin();
            session.persist(convert(contactData));
            session.getTransaction().commit();
        });
    }

    public List<ContactData> getContactsInGroup(GroupData group) {
        return sessionFactory.fromSession(session -> {
            return convertContactList(session.get(GroupRecord.class, group.id()).contacts);
        });
    }
}
