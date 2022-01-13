package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AddressBookEntry extends TestBase {

  @Test
  public void testAddressBookContact() throws Exception {
    app.goTo().contactPage();
    Contacts before = app.contact().all();
    ContactData contact = new ContactData().withFirstName("Test first name").withMiddleName("Test middle name")
            .withLastName("Test last name").withNickname("Test nickname").withTitle("Test title")
            .withCompany("Test company").withAddress("Test address").withHomePhone("Test home").withMobilePhone("1234567890")
            .withWorkPhone("Test work").withFax("Test fax").withFirstEmail("test1@test.com")
            .withSecondEmail("test2@test.com").withThirdEmail("test3@test.com").withHomepage("www.homepage.com")
            .withDayOfBirth("1").withMonthOfBirth("January").withYearOfBirth("1990").withAnniversaryDay("2")
            .withAnniversaryMonth("February").withAnniversaryYear("2001").withGroup("test1");

    app.contact().addNewContact();
    app.contact().create(contact);
    Contacts after = app.contact().all();
    assertThat(after.size(), equalTo(before.size() + 1));

    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
  }
}
