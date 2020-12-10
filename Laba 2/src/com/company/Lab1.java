package com.company;

import java.util.Scanner;

public class Lab1 {
    public static void main(String inputString){
        System.out.println("Введите поочередно координаты трех трехмерных точек");
        Scanner scan = new Scanner(System.in);
        /* Ввод координат трех точек */
        String coord1 = scan.nextLine();
        String coord2 = scan.nextLine();
        String coord3 = scan.nextLine();
        /* Присвоение значений переменным, отвечающим за координаты X, Y, Z */
        double x1 = Double.parseDouble(coord1.split(" ")[0]);
        double y1 = Double.parseDouble(coord1.split(" ")[1]);
        double z1 = Double.parseDouble(coord1.split(" ")[2]);
        double x2 = Double.parseDouble(coord2.split(" ")[0]);
        double y2 = Double.parseDouble(coord2.split(" ")[1]);
        double z2 = Double.parseDouble(coord2.split(" ")[2]);
        double x3 = Double.parseDouble(coord3.split(" ")[0]);
        double y3 = Double.parseDouble(coord3.split(" ")[1]);
        double z3 = Double.parseDouble(coord3.split(" ")[2]);
        /* Создание трех экземпляров класса Point3D */
        Point3d point1 = new Point3d(x1, y1, z1);
        Point3d point2 = new Point3d(x2, y2, z2);
        Point3d point3 = new Point3d(x3, y3, z3);
        scan.close();
        /* Вычисление площади треугольника с вершинами в созданных точках при условии что точки не равны */
        if (point1.Is_Equal(point2) || point1.Is_Equal(point3) || point2.Is_Equal(point3)){
            System.out.println("Встречены равнозначные точки. Попробуйте снова");
        } else {
            System.out.printf("(%.3f; %.3f; %.3f)" +
                            " \n(%.3f; %.3f; %.3f)" +
                            " \n(%.3f; %.3f; %.3f) \nПлощадь треугольника с координатами вершин равна %.3f",
                    point1.getX(), point1.getY(), point1.getZ(),
                    point2.getX(), point2.getY(), point2.getZ(),
                    point3.getX(), point3.getY(), point3.getZ(),
                    Lab1.computeArea(point1, point2, point3));
        }
    }
    /* Вычисление площади треугольника по трем точкам */
    public static double computeArea (Point3d point1, Point3d point2, Point3d point3){
        double halfPerimeter = (point1.Distance_To(point2) + point2.Distance_To(point3) + point3.Distance_To(point1)) / 2;
        return Math.sqrt(halfPerimeter *
                (halfPerimeter - point1.Distance_To(point2)) *
                (halfPerimeter - point2.Distance_To(point3)) *
                (halfPerimeter - point3.Distance_To(point1)));
    }
}
