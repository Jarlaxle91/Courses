package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;


public class AddressBookEntry extends TestBase {

  @Test
  public void testAddressBookContact() throws Exception {
    app.getNavigationHelper().gotoContactPage();
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().addNewContact();
    ContactData contact = new ContactData("Test first name", "Test middle name",
            "Test last name", "Test nickname", "Test title",
            "Test company", "Test address", "Test home",
            "1234567890", "Test work", "Test fax", "test1@test.com",
            "test2@test.com", "test3@test.com", "www.homepage.com",
            "1", "January", "1990", "2",
            "February", "2001", "test1");
    app.getContactHelper().createContact(contact);
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() + 1);
    before.add(contact);
    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
    app.logout();
  }
}
