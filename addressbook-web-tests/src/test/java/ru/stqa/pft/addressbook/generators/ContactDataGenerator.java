package ru.stqa.pft.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.stqa.pft.addressbook.model.ContactData;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ContactDataGenerator {

  @Parameter(names = "-c", description = "Contacts count")
  public int count;

  @Parameter(names = "-f", description = "Target file")
  public String file;

  @Parameter(names = "-d", description = "Data format")
  public String format;

  public static void main(String[] args) throws IOException {
    ContactDataGenerator generator = new ContactDataGenerator();
    JCommander jCommander = new JCommander(generator);
    try {
      jCommander.parse(args);
    } catch (ParameterException ex) {
      jCommander.usage();
      return;
    }
    generator.run();
  }

  private void run() throws IOException {
    List<ContactData> contacts = genetateContacts(count);
    if (format.equals("json")) {
      saveAsJson(contacts, new File(file));
    } else {
      System.out.println("Your format " + format + " does not match with JSON");
    }
  }

  private void saveAsJson(List<ContactData> contacts, File file) throws IOException {
    Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
    String json = gson.toJson(contacts);
    Writer writer = new FileWriter(file);
    writer.write(json);
    writer.close();
  }

  private List<ContactData> genetateContacts(int count) {
    List<ContactData> contacts = new ArrayList<ContactData>();
    for (int i = 0; i < count; i++) {
      contacts.add(new ContactData().withFirstName(String.format("first_name %s", i))
              .withMiddleName(String.format("middle_name %s", i)).withLastName(String.format("last_name %s", i))
              .withNickname(String.format("nickname %s", i)).withTitle(String.format("test_title %s", i))
              .withCompany(String.format("test_company %s", i)).withAddress(String.format("test_address %s", i))
              .withHomePhone("test_home").withMobilePhone("123456789").withWorkPhone("123456789").withFax("123456789")
              .withFirstEmail("test1@test.com").withSecondEmail("test2@test.com").withThirdEmail("test3@test.com")
              .withHomepage("www.homepage.com").withDayOfBirth("1").withMonthOfBirth("January").withYearOfBirth("1990")
              .withAnniversaryDay("2").withAnniversaryMonth("February").withAnniversaryYear("2001"));
    }
    return contacts;
  }
}
