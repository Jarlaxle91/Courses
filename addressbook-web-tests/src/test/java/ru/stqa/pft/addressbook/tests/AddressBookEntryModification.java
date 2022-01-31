package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AddressBookEntryModification extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    if(app.db().contacts().size() == 0) {
      app.goTo().contactPage();
      app.contact().create(new ContactData().withFirstName("Test first name").withMiddleName("Test middle name")
              .withLastName("Test last name").withNickname("Test nickname").withTitle("Test title")
              .withCompany("Test company").withAddress("Test address").withHomePhone("Test home").withMobilePhone("1234567890")
              .withWorkPhone("Test work").withFax("Test fax").withFirstEmail("test1@test.com")
              .withSecondEmail("test2@test.com").withThirdEmail("test3@test.com").withHomepage("www.homepage.com")
              .withDayOfBirth("1").withMonthOfBirth("January").withYearOfBirth("1990").withAnniversaryDay("2")
              .withAnniversaryMonth("February").withAnniversaryYear("2001"));
    }
  }

  @Test
  public void testContactModification() {
    Contacts before = app.db().contacts();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData().withId(modifiedContact.getId())
            .withFirstName("Test first name edited").withMiddleName("Test middle name edited")
            .withLastName("Test last name edited").withNickname("Test nickname edited")
            .withTitle("Test home edited").withCompany("Test company edited").withAddress("Test address edited")
            .withHomePhone("Test home").withMobilePhone("01234567890").withWorkPhone("Test work edited").withFax("Test fax edited")
            .withFirstEmail("editedtest1@test.com").withSecondEmail("editedtest2@test.com")
            .withThirdEmail("editedtest3@test.com").withHomepage("www.editedhomepage.com")
            .withDayOfBirth("10").withMonthOfBirth("July").withYearOfBirth("1994").withAnniversaryDay("20")
            .withAnniversaryMonth("March").withAnniversaryYear("2010");

    app.contact().modify(contact);
    assertThat(app.group().count(), equalTo(before.size()));
    Contacts after = app.db().contacts();
    assertThat(after, equalTo(before.withoutAdded(modifiedContact).withAdded(contact)));

  }

}
