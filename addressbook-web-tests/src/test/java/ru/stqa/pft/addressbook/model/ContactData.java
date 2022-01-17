package ru.stqa.pft.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import java.io.File;

@XStreamAlias("group")
public class ContactData {
  @XStreamOmitField
  private int id = Integer.MAX_VALUE;
  @Expose
  private String firstName;
  @Expose
  private String middleName;
  @Expose
  private String lastName;
  @Expose
  private String nickname;
  @Expose
  private String title;
  @Expose
  private String company;
  @Expose
  private String address;
  @Expose
  private String homePhone;
  @Expose
  private String mobilePhone;
  @Expose
  private String workPhone;
  @Expose
  private String secondPhone;
  @Expose
  private String allPhones;
  @Expose
  private String fax;
  @Expose
  private String firstEmail;
  @Expose
  private String secondEmail;
  @Expose
  private String thirdEmail;
  @Expose
  private String allEmails;
  @Expose
  private String homepage;
  @Expose
  private String dayOfBirth;
  @Expose
  private String monthOfBirth;
  @Expose
  private String yearOfBirth;
  @Expose
  private String anniversaryDay;
  @Expose
  private String anniversaryMonth;
  @Expose
  private String anniversaryYear;
  @Expose
  private String group;

  public File getPhoto() { return photo; }

  public ContactData withPhoto(File photo) { this.photo = photo; return this; }

  private File photo;

  public int getId() { return id; }
  public String getFirstName() {
    return firstName;
  }
  public String getMiddleName() {
    return middleName;
  }
  public String getLastName() {
    return lastName;
  }
  public String getNickname() {
    return nickname;
  }
  public String getTitle() {
    return title;
  }
  public String getCompany() {
    return company;
  }
  public String getAddress() { return address; }
  public String getHomePhone() { return homePhone; }
  public String getMobilePhone() { return mobilePhone; }
  public String getWorkPhone() { return workPhone; }
  public String getSecondPhone() { return secondPhone; }
  public String getAllPhones() { return allPhones; }
  public String getFax() { return fax; }
  public String getFirstEmail() { return firstEmail; }
  public String getSecondEmail() { return secondEmail; }
  public String getThirdEmail() { return thirdEmail; }
  public String getAllEmails() { return allEmails; }
  public String getHomepage() { return homepage; }
  public String getDayOfBirth() { return dayOfBirth; }
  public String getMonthOfBirth() { return monthOfBirth; }
  public String getYearOfBirth() { return yearOfBirth; }
  public String getAnniversaryDay() { return anniversaryDay; }
  public String getAnniversaryMonth() { return anniversaryMonth; }
  public String getAnniversaryYear() { return anniversaryYear; }
  public String getGroup() { return group; }

  public ContactData withId(int id) { this.id = id;  return this; }
  public ContactData withFirstName(String firstName) { this.firstName = firstName; return this; }
  public ContactData withMiddleName(String middleName) { this.middleName = middleName; return this; }
  public ContactData withLastName(String lastName) { this.lastName = lastName; return this; }
  public ContactData withNickname(String nickname) { this.nickname = nickname; return this; }
  public ContactData withTitle(String title) { this.title = title; return this; }
  public ContactData withCompany(String company) { this.company = company; return this; }
  public ContactData withAddress(String address) { this.address = address; return this; }
  public ContactData withAllAddresses(String allAddresses) { this.address = allAddresses; return this; }
  public ContactData withHomePhone(String home) { this.homePhone = home; return this; }
  public ContactData withMobilePhone(String mobile) { this.mobilePhone = mobile; return this; }
  public ContactData withWorkPhone(String work) { this.workPhone = work; return this; }
  public ContactData withSecondPhone(String secondPhone) { this.secondPhone = secondPhone; return this; }
  public ContactData withAllPhones(String allPhones) { this.allPhones = allPhones; return this; }
  public ContactData withFax(String fax) { this.fax = fax; return this; }
  public ContactData withFirstEmail(String firstEmail) { this.firstEmail = firstEmail; return this; }
  public ContactData withSecondEmail(String secondEmail) { this.secondEmail = secondEmail; return this; }
  public ContactData withThirdEmail(String thirdEmail) { this.thirdEmail = thirdEmail; return this; }
  public ContactData withAllEmails(String allEmails) { this.allEmails = allEmails; return this; }
  public ContactData withHomepage(String homepage) { this.homepage = homepage; return this; }
  public ContactData withDayOfBirth(String dayOfBirth) { this.dayOfBirth = dayOfBirth; return this; }
  public ContactData withMonthOfBirth(String monthOfBirth) { this.monthOfBirth = monthOfBirth; return this; }
  public ContactData withYearOfBirth(String yearOfBirth) { this.yearOfBirth = yearOfBirth; return this; }
  public ContactData withAnniversaryDay(String anniversaryDay) { this.anniversaryDay = anniversaryDay; return this; }
  public ContactData withAnniversaryMonth(String anniversaryMonth) { this.anniversaryMonth = anniversaryMonth; return this; }
  public ContactData withAnniversaryYear(String anniversaryYear) { this.anniversaryYear = anniversaryYear; return this; }
  public ContactData withGroup(String group) { this.group = group; return this; }

  @Override
  public String toString() {
    return "ContactData{" +
            "id='" + id + '\'' +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;

    if (id != that.id) return false;
    if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
    return lastName != null ? lastName.equals(that.lastName) : that.lastName == null;
  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
    result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
    return result;
  }
}
