package ru.stqa.pft.sandbox;

public class Point {
  public double x1;
  public double y1;
  public double x2;
  public double y2;

//  public double x; //ToDo Это задание 3
//  public double y;

//  public Point(double x, double y) {
//    this.x = x;
//    this.y = y;
//  }

  public Point(double x1, double y1, double x2, double y2) { //ToDo Это задание 4
    this.x1 = x1;
    this.y1 = y1;
    this.x2 = x2;
    this.y2 = y2;
  }

  public double distance() { //ToDo Это задание 4
    double d = Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
    return d;
  }

}