package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class AddressBookEntryDeletion extends TestBase {

  @Test
  public void testContactDeletion() {
    app.getNavigationHelper().gotoContactPage();
    app.getContactHelper().selectContact();
    app.getContactHelper().deleteSelectedContact();
    app.getContactHelper().submitDeletionContact();
    app.getNavigationHelper().gotoContactPage();
    app.logout();
  }

}
