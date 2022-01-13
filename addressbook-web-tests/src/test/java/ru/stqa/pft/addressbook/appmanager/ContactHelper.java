package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.List;

public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void submitContactCreation() {
    wd.findElement(By.name("submit")).click();
  }

  public void fillEntryForm(ContactData contactData, boolean creation) {
    if (creation) {
      checkExistanceAndSelectGroup(contactData.getGroup());
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
    type(By.name("firstname"), contactData.getFirstName());
    type(By.name("middlename"), contactData.getMiddleName());
    type(By.name("lastname"), contactData.getLastName());
    type(By.name("nickname"), contactData.getNickname());
    type(By.name("title"), contactData.getTitle());
    type(By.name("company"), contactData.getCompany());
    type(By.name("address"), contactData.getAddress());
    type(By.name("home"), contactData.getHomePhone());
    type(By.name("mobile"), contactData.getMobilePhone());
    type(By.name("work"), contactData.getWorkPhone());
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

  public void selectContact(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
  }

  private void selectContactById(int id) {
    wd.findElement(By.cssSelector("input[value = '" + id + "']")).click();
  }

  public void initContactModification(int id) {
    click(By.xpath("//a[@href='edit.php?id="+ id +"']"));
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

  public void create(ContactData contact) {
    addNewContact();
    fillEntryForm(contact, true);
    submitContactCreation();
    returnToContactPage();
  }

  public void modify(ContactData contact) {
    selectContactById(contact.getId());
    initContactModification(contact.getId());
    fillEntryForm(contact, false);
    submitContactModification();
    returnToContactPage();
  }

  public void delete(ContactData contact) {
    selectContactById(contact.getId());
    deleteSelectedContact();
    submitDeletionContact();
    returnToContactPage();
  }

  public int getContactCount() {
    return wd.findElements(By.xpath("//tr[@name='entry']")).size();
  }

  public Contacts all() {
    Contacts contacts = new Contacts();
    List<WebElement> records = wd.findElements(By.xpath("//tr[@name='entry']"));

    for (WebElement element : records) {
      List<WebElement> cells = element.findElements(By.tagName("td"));
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      String firstName = cells.get(2).getText();
      String lastName = cells.get(1).getText();
      String allAddresses = cells.get(3).getText();
      String[] addresses = allAddresses.split("\n");
      String allPhones = cells.get(5).getText();
      String allEmails = cells.get(4).getText();
      contacts.add(new ContactData().withId(id).withFirstName(firstName).withLastName(lastName)
              .withAllAddresses(allAddresses).withAllPhones(allPhones).withAllEmails(allEmails));
    }
    return contacts;
  }

  public ContactData infoFromEditForm(ContactData contact) {
    initContactModificationById(contact.getId());
    String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
    String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
    String home = wd.findElement(By.name("home")).getAttribute("value");
    String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
    String work = wd.findElement(By.name("work")).getAttribute("value");
    String address = wd.findElement(By.name("address")).getAttribute("value");
    String firstEmail = wd.findElement(By.name("email")).getAttribute("value");
    String secondEmail = wd.findElement(By.name("email2")).getAttribute("value");
    String thirdEmail = wd.findElement(By.name("email3")).getAttribute("value");

    wd.navigate().back();
    return new ContactData().withId(contact.getId()).withFirstName(firstname).withLastName(lastname)
            .withAddress(address).withHomePhone(home).withMobilePhone(mobile).withWorkPhone(work)
            .withFirstEmail(firstEmail).withSecondEmail(secondEmail).withThirdEmail(thirdEmail);
  }

  private void initContactModificationById(int id) {
    WebElement checkbox = wd.findElement(By.cssSelector(String.format("input[value='%s']", id)));
    WebElement row = checkbox.findElement(By.xpath("./../.."));
    List<WebElement> cells = row.findElements(By.tagName("td"));
    cells.get(7).findElement(By.tagName("a")).click();
  }


}
