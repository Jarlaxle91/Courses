package ru.stqa.pft.sandbox;

public class MyFirstProgram {

  public static void main(String[] args) {
    hello("world");
    hello("user");
    hello("Alexei");

    Square s = new Square(5);
    System.out.println("Площадь квадрата со стороной " + s.l + " = " + s.area());

    Rectangle r = new Rectangle(4, 6);
    System.out.println("Площадь прямоугольника со сторонами " + r.a + " и " + r.b + " = " + r.area());

    Point p = new Point(3, 7, 1,11); //ToDo это задание 4
    System.out.println("Расстояние между точками = " + p.distance());

//    Point p1 = new Point(3, 7); //ToDo Это задание 3
//    System.out.println("Точка P1 с координатами X = " + p1.x + " и Y = " + p1.y);
//
//    Point p2 = new Point(1, 11);
//    System.out.println("Точка P2 с координатами X = " + p2.x + " и Y = " + p2.y);
//    System.out.println("Расстояние между точками = " +  distance(p1, p2));
  }
//  public static double distance(Point p1, Point p2) { //ToDo Это задание 3
//  double d = Math.sqrt((p2.x-p1.x)*(p2.x-p1.x) + (p2.y-p1.y)*(p2.y-p1.y));
//  return d;
//  }

  public static void hello(String somebody) {
    System.out.println("Hello, " + somebody + "!");
  }
  
}