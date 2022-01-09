package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

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
              "February", "2001", "test1"));
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().selectContact(before.size() - 1);
    app.getContactHelper().deleteSelectedContact();
    app.getContactHelper().submitDeletionContact();
    app.getNavigationHelper().gotoContactPage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() - 1);
    before.remove(before.size() - 1);
    Assert.assertEquals(before, after);
    app.logout();
  }
}
