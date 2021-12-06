package ru.stqa.pft.sandbox;

public class MyFirstProgram {

  public static void main(String[] args) {
    hello("world");
    hello("user");
    hello("Alexei");

    Point p1 = new Point(3,7);
    System.out.println("Точка P1 с координатами X = " + p1.x + " и Y = " + p1.y);

    Point p2 = new Point(10,9);
    System.out.println("Точка P2 с координатами X = " + p2.x + " и Y = " + p2.y);

    Square s = new Square(5);
    System.out.println("Площадь квадрата со стороной " + s.l + " = " + s.area());

    Rectangle r = new Rectangle(4, 6);
    System.out.println("Площадь прямоугольника со сторонами " + r.a + " и " + r.b + " = " + r.area());

    distance(p1, p2);

  }

  public static double distance(Point p1, Point p2) {

    double dis = p1.distance(p2);
    System.out.println("Расстояние между точками = " + dis);
    return dis;
  }

  public static void hello(String somebody) {
    System.out.println("Hello, " + somebody + "!");
  }
  
}