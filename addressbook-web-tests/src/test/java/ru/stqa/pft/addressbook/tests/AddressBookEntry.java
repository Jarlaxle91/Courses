package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;


public class AddressBookEntry extends TestBase {

  @Test
  public void testAddressBookContact() throws Exception {
    app.getNavigationHelper().gotoContactPage();
    app.getContactHelper().addNewContact();
    app.getContactHelper().createContact(new ContactData("Test first name", "Test middle name",
            "Test last name", "Test nickname", "Test title",
            "Test company", "Test address", "Test home",
            "1234567890", "Test work", "Test fax", "test1@test.com",
            "test2@test.com", "test3@test.com", "www.homepage.com",
            "1", "January", "1990", "2",
            "February", "2001", "test1"), true);
    app.logout();
  }
}
