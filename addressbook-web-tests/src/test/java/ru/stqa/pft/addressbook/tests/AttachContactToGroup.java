package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AttachContactToGroup extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {


    Contacts contacts = app.db().contacts();
    Groups groups = app.db().groups();

    int groupSize = app.db().groups().size();
    int contactSize = app.db().contacts().size();
    ContactData contact = app.contact().findContactThatCanBeAddedToSomeGroup(contacts, groupSize);

    GroupData group = app.group().findGroupThatDoesNotIncludeContact(groups, contactSize);

  }
//    if (app.db().groups().size() == 0) {
//      app.goTo().groupPage();
//      app.group().create(new GroupData().withName("groupForAttach"));
//    }
//
//    if(app.db().contacts().size() == 0) {
//      app.goTo().contactPage();
//      app.contact().create(new ContactData().withFirstName("Contact for attach").withMiddleName("Test middle name")
//              .withLastName("Test last name").withNickname("Test nickname").withTitle("Test title")
//              .withCompany("Test company").withAddress("Test address").withHomePhone("Test home").withMobilePhone("1234567890")
//              .withWorkPhone("Test work").withFax("Test fax").withFirstEmail("test1@test.com")
//              .withSecondEmail("test2@test.com").withThirdEmail("test3@test.com").withHomepage("www.homepage.com")
//              .withDayOfBirth("1").withMonthOfBirth("January").withYearOfBirth("1990").withAnniversaryDay("2")
//              .withAnniversaryMonth("February").withAnniversaryYear("2001"));
//    }
//
//    Long attachedGroups = app.db().contacts().stream().findAny().get().getGroups().stream().count();
//    int contactId = app.db().contacts().iterator().next().getId();
//
//    while (attachedGroups > 0) {
//      String groupName = app.db().contacts().stream().findAny().get().getGroups().iterator().next().getName();
//      app.contact().deleteAttachedGroup(contactId, groupName);
//      app.goHomePage();
//      attachedGroups = app.db().contacts().stream().findAny().get().getGroups().stream().count();
//    }

    @Test
    public void testAttachContactToGroup() {
      int contactId = app.db().contacts().iterator().next().getId();
      String groupName = app.db().groups().iterator().next().getName();
      Groups before = app.db().contacts().stream().findAny().get().getGroups();
      app.goTo().contactPage();
      app.contact().attachContactToGroup(contactId, groupName);
      Groups after = app.db().contacts().stream().findAny().get().getGroups();
      assertThat(before.stream().count() + 1, equalTo(after.stream().count()));
    }
}
