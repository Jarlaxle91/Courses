package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void submitContactCreation() {
    wd.findElement(By.name("submit")).click();
  }

  public void fillEntryForm(ContactData contactData, boolean creation) {
    checkExistanceAndSelectGroup(contactData.getGroup());
    type(By.name("firstname"), contactData.getFirstName());
    type(By.name("middlename"), contactData.getMiddleName());
    type(By.name("lastname"), contactData.getLastName());
    type(By.name("nickname"), contactData.getNickname());
    type(By.name("title"), contactData.getTitle());
    type(By.name("company"), contactData.getCompany());
    type(By.name("address"), contactData.getAddress());
    type(By.name("home"), contactData.getHome());
    type(By.name("mobile"), contactData.getMobile());
    type(By.name("work"), contactData.getWork());
    type(By.name("fax"), contactData.getFax());
    type(By.name("email"), contactData.getFirstEmail());
    type(By.name("email2"), contactData.getSecondEmail());
    type(By.name("email3"), contactData.getThirdEmail());
    type(By.name("homepage"), contactData.getHomepage());
    selectElementDropDownList("bday", contactData.getDayOfBirth());
    selectElementDropDownList("bmonth", contactData.getMonthOfBirth());
    type(By.name("byear"), contactData.getYearOfBirth());
    selectElementDropDownList("aday", contactData.getAnniversaryDay());
    selectElementDropDownList("amonth", contactData.getAnniversaryMonth());
    type(By.name("ayear"), contactData.getAnniversaryYear());

    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }

  private void checkExistanceAndSelectGroup(String groupName) {
    wd.findElement(By.name("new_group")).click();

    if (isElementPresent(By.xpath("//select[@name='new_group']//option[text()='" + groupName + "']"))) {
      wd.findElement(By.name("new_group")).click();
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(groupName);
    } else {
      wd.findElement(By.name("theform")).click();
      wd.findElement(By.linkText("groups")).click();
      wd.findElement(By.name("new")).click();
      wd.findElement(By.name("group_name")).click();
      wd.findElement(By.name("group_name")).clear();
      wd.findElement(By.name("group_name")).sendKeys(groupName);
      wd.findElement(By.name("group_header")).click();
      wd.findElement(By.name("group_header")).clear();
      wd.findElement(By.name("group_header")).sendKeys("test2");
      wd.findElement(By.name("group_footer")).click();
      wd.findElement(By.name("group_footer")).clear();
      wd.findElement(By.name("group_footer")).sendKeys("test3");
      wd.findElement(By.xpath("//form[@action='/addressbook/group.php']")).click();
      wd.findElement(By.name("submit")).click();
      wd.findElement(By.linkText("add new")).click();
    }
  }

  private void returnToContactPage() {
    click(By.linkText("home"));
  }

  private void selectElementDropDownList(String locator, String selectedValue) {
    wd.findElement(By.name(locator)).click();
    new Select(wd.findElement(By.name(locator))).selectByVisibleText(selectedValue);
  }

  public void addNewContact() {
    click(By.linkText("add new"));
  }

  public void selectContact() {
    click(By.name("selected[]"));
  }

  public void initContactModification() {
    click(By.xpath("//img[@alt='Edit']"));
  }

  public void submitContactModification() {
    click(By.name("update"));
  }

  public void deleteSelectedContact() {
    click(By.xpath("//input[@value='Delete']"));
  }

  public void submitDeletionContact() {
    clickInActionConfirmationWindow(By.xpath("//input[@value='Delete']"));
  }

  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public void createContact(ContactData contact) {
    addNewContact();
    fillEntryForm(contact, true);
    submitContactCreation();
    returnToContactPage();
  }
}
