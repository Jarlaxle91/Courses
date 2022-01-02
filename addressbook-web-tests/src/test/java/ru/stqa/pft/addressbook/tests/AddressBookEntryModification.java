package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

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
              "February", "2001", "test1"), true);
    }
    app.getContactHelper().selectContact();
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillEntryForm(new ContactData("Test first name edited", "Test middle name edited",
            "Test last name edited", "Test nickname edited", "Test title edited",
            "Test company edited", "Test address edited", "Test home edited",
            "01234567890", "Test work edited", "Test fax edited", "editedtest1@test.com",
            "editedtest2@test.com", "editedtest3@test.com", "www.editedhomepage.com",
            "10", "July", "1994", "20",
            "March", "2010", null), false);
    app.getContactHelper().submitContactModification();
    app.getNavigationHelper().gotoContactPage();
    app.logout();
  }
}
