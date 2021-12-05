package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointsTest {
  @Test
  public void testPoint() {
    Point p = new Point(3, 7, 1,11);
    Assert.assertEquals(p.distance(), 4.47213595499958);
  }

  @Test
  public void testCoordinates() {
    Point p = new Point(3,7,1,11);
    double x1 = p.x1;
    double x2 = p.x2;
    double y1 = p.y1;
    double y2 = p.y2;

    Assert.assertEquals(p.x1, 3);
    Assert.assertEquals(p.x2, 1);
    Assert.assertEquals(p.y1, 7);
    Assert.assertEquals(p.y2, 11);
  }

}
