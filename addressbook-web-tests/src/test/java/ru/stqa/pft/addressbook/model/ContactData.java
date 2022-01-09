package ru.stqa.pft.addressbook.model;

public class ContactData {
  private int id;
  private final String firstName;
  private final String middleName;
  private final String lastName;
  private final String nickname;
  private final String title;
  private final String company;
  private final String address;
  private final String home;
  private final String mobile;
  private final String work;
  private final String fax;
  private final String firstEmail;
  private final String secondEmail;
  private final String thirdEmail;
  private final String homepage;
  private final String dayOfBirth;
  private final String monthOfBirth;
  private final String yearOfBirth;
  private final String anniversaryDay;
  private final String anniversaryMonth;
  private final String anniversaryYear;
  private final String group;


  public ContactData(int id, String firstName, String middleName, String lastName, String nickname, String title,
                     String company, String address, String home, String mobile, String work, String fax,
                     String firstEmail, String secondEmail, String thirdEmail, String homepage, String dayOfBirth,
                     String monthOfBirth, String yearOfBirth, String anniversaryDay, String anniversaryMonth,
                     String anniversaryYear, String group) {
    this.id = id;
    this.firstName = firstName;
    this.middleName = middleName;
    this.lastName = lastName;
    this.nickname = nickname;
    this.title = title;
    this.company = company;
    this.address = address;
    this.home = home;
    this.mobile = mobile;
    this.work = work;
    this.fax = fax;
    this.firstEmail = firstEmail;
    this.secondEmail = secondEmail;
    this.thirdEmail = thirdEmail;
    this.homepage = homepage;
    this.dayOfBirth = dayOfBirth;
    this.monthOfBirth = monthOfBirth;
    this.yearOfBirth = yearOfBirth;
    this.anniversaryDay = anniversaryDay;
    this.anniversaryMonth = anniversaryMonth;
    this.anniversaryYear = anniversaryYear;
    this.group = group;
  }

  public ContactData(String firstName, String middleName, String lastName, String nickname, String title,
                     String company, String address, String home, String mobile, String work, String fax,
                     String firstEmail, String secondEmail, String thirdEmail, String homepage, String dayOfBirth,
                     String monthOfBirth, String yearOfBirth, String anniversaryDay, String anniversaryMonth,
                     String anniversaryYear, String group) {
    this.id = Integer.MAX_VALUE;
    this.firstName = firstName;
    this.middleName = middleName;
    this.lastName = lastName;
    this.nickname = nickname;
    this.title = title;
    this.company = company;
    this.address = address;
    this.home = home;
    this.mobile = mobile;
    this.work = work;
    this.fax = fax;
    this.firstEmail = firstEmail;
    this.secondEmail = secondEmail;
    this.thirdEmail = thirdEmail;
    this.homepage = homepage;
    this.dayOfBirth = dayOfBirth;
    this.monthOfBirth = monthOfBirth;
    this.yearOfBirth = yearOfBirth;
    this.anniversaryDay = anniversaryDay;
    this.anniversaryMonth = anniversaryMonth;
    this.anniversaryYear = anniversaryYear;
    this.group = group;
  }

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

    if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
    return lastName != null ? lastName.equals(that.lastName) : that.lastName == null;
  }

  @Override
  public int hashCode() {
    int result = firstName != null ? firstName.hashCode() : 0;
    result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
    return result;
  }

  public void setId(int id) {
    this.id = id;
  }
}
