package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class AddressBookEntryDeletion extends TestBase {

  @Test
  public void testContactDeletion() {
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
    app.getContactHelper().deleteSelectedContact();
    app.getContactHelper().submitDeletionContact();
    app.getNavigationHelper().gotoContactPage();
    app.logout();
  }
}
