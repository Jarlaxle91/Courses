package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class AddressBookEntryDeletion extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().contactPage();
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactData().withFirstName("Test first name").withMiddleName("Test middle name")
              .withLastName("Test last name").withNickname("Test nickname").withTitle("Test title")
              .withCompany("Test company").withAddress("Test address").withHomePhone("Test home").withMobilePhone("1234567890")
              .withWorkPhone("Test work").withFax("Test fax").withFirstEmail("test1@test.com")
              .withSecondEmail("test2@test.com").withThirdEmail("test3@test.com").withHomepage("www.homepage.com")
              .withDayOfBirth("1").withMonthOfBirth("January").withYearOfBirth("1990").withAnniversaryDay("2")
              .withAnniversaryMonth("February").withAnniversaryYear("2001").withGroup("test1"));
    }
  }

  @Test
  public void testContactDeletion() {
    Contacts before = app.contact().all();
    ContactData deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    Contacts after = app.contact().all();
    assertEquals(after.size(), before.size() - 1);
    assertThat(after, equalTo(before.withoutAdded(deletedContact)));
  }
}
