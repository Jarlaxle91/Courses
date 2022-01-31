package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class DeleteAttachedGroup extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().groups().size() == 0) {
      app.goTo().groupPage();
      app.group().create(new GroupData().withName("groupForDelete"));
    }

    if(app.db().contacts().size() == 0) {
      app.goTo().contactPage();
      app.contact().create(new ContactData().withFirstName("Contact for delete group").withMiddleName("Test middle name")
              .withLastName("Test last name").withNickname("Test nickname").withTitle("Test title")
              .withCompany("Test company").withAddress("Test address").withHomePhone("Test home").withMobilePhone("1234567890")
              .withWorkPhone("Test work").withFax("Test fax").withFirstEmail("test1@test.com")
              .withSecondEmail("test2@test.com").withThirdEmail("test3@test.com").withHomepage("www.homepage.com")
              .withDayOfBirth("1").withMonthOfBirth("January").withYearOfBirth("1990").withAnniversaryDay("2")
              .withAnniversaryMonth("February").withAnniversaryYear("2001"));
    }

    Long attachedGroups = app.db().contacts().stream().findAny().get().getGroups().stream().count();
    int contactId = app.db().contacts().iterator().next().getId();
    String groupName;

    if (attachedGroups == 0) {
      groupName = app.db().groups().iterator().next().getName();
      app.contact().attachContactToGroup(contactId, groupName);
      app.goHomePage();
    }
  }

  @Test
  public void deleteAttachedGroup() {
    int contactId = app.db().contacts().iterator().next().getId();
    String groupName = app.db().groups().iterator().next().getName();
    Groups before = app.db().contacts().stream().findAny().get().getGroups();
    app.goTo().contactPage();
    app.contact().deleteAttachedGroup(contactId, groupName);
    Groups after = app.db().contacts().stream().findAny().get().getGroups();
    assertThat(before.stream().count() - 1, equalTo(after.stream().count()));
  }


}
