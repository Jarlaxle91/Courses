package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


 public class ApplicationManager {
   WebDriver wd;

   private SessionHelper sessionHelper;
   private NavigationHelper navigationHelper;
   private GroupHelper groupHelper;
   private ContactHelper contactHelper;

   public void init() {
    System.setProperty("webdriver.chrome.driver", "c:/windows/system32/chromedriver.exe");
    wd = new ChromeDriver();
    wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    wd.get("http://localhost/addressbook/");
    groupHelper = new GroupHelper(wd);
    contactHelper = new ContactHelper(wd);
    navigationHelper = new NavigationHelper(wd);
    sessionHelper = new SessionHelper(wd);
    sessionHelper.login("admin", "secret");
  }

  public void logout() {
    wd.findElement(By.linkText("Logout")).click();
  }

   public void stop() {
    wd.quit();
  }

   public GroupHelper getGroupHelper() {
    return groupHelper;
  }

   public NavigationHelper getNavigationHelper() { return navigationHelper; }

   public ContactHelper getContactHelper() { return contactHelper; }

 }
