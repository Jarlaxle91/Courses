package ru.stqa.pft.addressbook.model;

public class ContactData {
  private int id = Integer.MAX_VALUE;
  private String firstName;
  private String middleName;
  private String lastName;
  private String nickname;
  private String title;
  private String company;
  private String address;
  private String home;
  private String mobile;
  private String work;
  private String fax;
  private String firstEmail;
  private String secondEmail;
  private String thirdEmail;
  private String homepage;
  private String dayOfBirth;
  private String monthOfBirth;
  private String yearOfBirth;
  private String anniversaryDay;
  private String anniversaryMonth;
  private String anniversaryYear;
  private String group;

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
  public String getAddress() {
    return address;
  }
  public String getHome() {
    return home;
  }
  public String getMobile() {
    return mobile;
  }
  public String getWork() {
    return work;
  }
  public String getFax() {
    return fax;
  }
  public String getFirstEmail() {
    return firstEmail;
  }
  public String getSecondEmail() {
    return secondEmail;
  }
  public String getThirdEmail() {
    return thirdEmail;
  }
  public String getHomepage() {
    return homepage;
  }
  public String getDayOfBirth() {
    return dayOfBirth;
  }
  public String getMonthOfBirth() {
    return monthOfBirth;
  }
  public String getYearOfBirth() {
    return yearOfBirth;
  }
  public String getAnniversaryDay() {
    return anniversaryDay;
  }
  public String getAnniversaryMonth() {
    return anniversaryMonth;
  }
  public String getAnniversaryYear() {
    return anniversaryYear;
  }
  public String getGroup() {
    return group;
  }

  public ContactData withId(int id) { this.id = id;  return this; }
  public ContactData withFirstName(String firstName) { this.firstName = firstName; return this; }
  public ContactData withMiddleName(String middleName) { this.middleName = middleName; return this; }
  public ContactData withLastName(String lastName) { this.lastName = lastName; return this; }
  public ContactData withNickname(String nickname) { this.nickname = nickname; return this; }
  public ContactData withTitle(String title) { this.title = title; return this; }
  public ContactData withCompany(String company) { this.company = company; return this; }
  public ContactData withAddress(String address) { this.address = address; return this; }
  public ContactData withHome(String home) { this.home = home; return this; }
  public ContactData withMobile(String mobile) { this.mobile = mobile; return this; }
  public ContactData withWork(String work) { this.work = work; return this; }
  public ContactData withFax(String fax) { this.fax = fax; return this; }
  public ContactData withFirstEmail(String firstEmail) { this.firstEmail = firstEmail; return this; }
  public ContactData withSecondEmail(String secondEmail) { this.secondEmail = secondEmail; return this; }
  public ContactData withThirdEmail(String thirdEmail) { this.thirdEmail = thirdEmail; return this; }
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
