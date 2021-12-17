package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointsTest {

  @Test
  public void testPoint() {
    Point p1 = new Point(6, 9);
    Point p2 = new Point(13, 4);
    Assert.assertEquals(MyFirstProgram.distance(p1, p2), 8.602325267042627); //Позитивный тест
  }

  @Test
  public void anotherTestPoint() {
    Point p1 = new Point(11, 12);
    Point p2 = new Point(16, 24);
    Assert.assertNotEquals(MyFirstProgram.distance(p1, p2), 10); //Негативный тест
  }
}
