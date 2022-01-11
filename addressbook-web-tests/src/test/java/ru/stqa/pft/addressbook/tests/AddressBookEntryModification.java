package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class AddressBookEntryModification extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().contactPage();
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactData().withFirstName("Test first name").withMiddleName("Test middle name")
              .withLastName("Test last name").withNickname("Test nickname").withTitle("Test title")
              .withCompany("Test company").withAddress("Test address").withHome("Test home").withMobile("1234567890")
              .withWork("Test work").withFax("Test fax").withFirstEmail("test1@test.com")
              .withSecondEmail("test2@test.com").withThirdEmail("test3@test.com").withHomepage("www.homepage.com")
              .withDayOfBirth("1").withMonthOfBirth("January").withYearOfBirth("1990").withAnniversaryDay("2")
              .withAnniversaryMonth("February").withAnniversaryYear("2001").withGroup("test1"));
    }
  }

  @Test
  public void testContactModification() {
    Contacts before = app.contact().all();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData().withId(modifiedContact.getId())
            .withFirstName("Test first name edited").withMiddleName("Test middle name edited")
            .withLastName("Test last name edited").withNickname("Test nickname edited")
            .withTitle("Test home edited").withCompany("Test company edited").withAddress("Test address edited")
            .withHome("Test home").withMobile("01234567890").withWork("Test work edited").withFax("Test fax edited")
            .withFirstEmail("editedtest1@test.com").withSecondEmail("editedtest2@test.com")
            .withThirdEmail("editedtest3@test.com").withHomepage("www.editedhomepage.com")
            .withDayOfBirth("10").withMonthOfBirth("July").withYearOfBirth("1994").withAnniversaryDay("20")
            .withAnniversaryMonth("March").withAnniversaryYear("2010").withGroup(null);

    app.contact().modify(contact);
    Contacts after = app.contact().all();
    assertEquals(after.size(), before.size());
    assertThat(after, equalTo(before.withoutAdded(modifiedContact).withAdded(contact)));
  }
}
