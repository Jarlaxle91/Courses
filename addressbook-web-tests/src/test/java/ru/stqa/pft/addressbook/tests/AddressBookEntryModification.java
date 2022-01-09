package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class AddressBookEntryModification extends TestBase {

  @Test
  public void testContactModification() {
    app.getNavigationHelper().gotoContactPage();
    if (!app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("Test first name", "Test middle name",
              "Test last name", "Test nickname", "Test title",
              "Test company", "Test address", "Test home",
              "1234567890", "Test work", "Test fax", "test1@test.com",
              "test2@test.com", "test3@test.com", "www.homepage.com",
              "1", "January", "1990", "2",
              "February", "2001", "test1"));
    }

    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().selectContact(before.size() - 1);
    app.getContactHelper().initContactModification( before.size() - 1);
    ContactData contact = new ContactData(before.get(before.size() - 1).getId(),"Test first name edited", "Test middle name edited",
            "Test last name edited", "Test nickname edited", "Test title edited",
            "Test company edited", "Test address edited", "Test home edited",
            "01234567890", "Test work edited", "Test fax edited", "editedtest1@test.com",
            "editedtest2@test.com", "editedtest3@test.com", "www.editedhomepage.com",
            "10", "July", "1994", "20",
            "March", "2010", null);
    app.getContactHelper().fillEntryForm(contact, false);
    app.getContactHelper().submitContactModification();
    app.getNavigationHelper().gotoContactPage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());
    before.remove(before.size() - 1);
    before.add(contact);
    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
    app.logout();
  }
}
