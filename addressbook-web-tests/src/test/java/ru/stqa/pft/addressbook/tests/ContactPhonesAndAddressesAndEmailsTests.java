package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import java.util.Arrays;
import java.util.stream.Collectors;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactPhonesAndAddressesAndEmailsTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().contactPage();
    if (app.db().contacts().size() == 0) {
      app.contact().create(new ContactData().withFirstName("Test first name").withMiddleName("Test middle name")
              .withLastName("Test last name").withNickname("Test nickname").withTitle("Test title")
              .withCompany("Test company").withAddress("Test address").withHomePhone("+7(111)").withMobilePhone("")
              .withWorkPhone("33-33").withSecondPhone("42-42").withFax("Test fax").withFirstEmail("test1@test.com")
              .withSecondEmail("test2@test.com").withThirdEmail("test 3 - () @test.com").withHomepage("www.homepage.com")
              .withDayOfBirth("1").withMonthOfBirth("January").withYearOfBirth("1990").withAnniversaryDay("2")
              .withAnniversaryMonth("February").withAnniversaryYear("2001").withGroup("test1"));
    }
  }

  @Test
  public void contactPhonesAndAddressesAndEmailsTests() {
    app.goTo().contactPage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

    assertThat(contact.getAddress(), equalTo(contactInfoFromEditForm.getAddress()));
    assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm)));
    assertThat(contact.getAllEmails(), equalTo(mergeEmails(contactInfoFromEditForm)));
  }

  private String mergePhones(ContactData contact) {
    return Arrays.asList(contact.getHomePhone(), contact.getMobilePhone(), contact.getWorkPhone(),
             contact.getSecondPhone()).stream().filter((s) -> !s.equals(""))
            .map(ContactPhonesAndAddressesAndEmailsTests:: cleaned)
            .collect(Collectors.joining("\n"));
  }

  private String mergeEmails(ContactData contact) {
    return Arrays.asList(contact.getFirstEmail(), contact.getSecondEmail(), contact.getThirdEmail())
            .stream().filter((s) -> !s.equals(""))
            .collect(Collectors.joining("\n"));
  }

  public static String cleaned(String phone) {
    return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
  }
}
