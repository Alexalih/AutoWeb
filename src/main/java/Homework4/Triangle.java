package Homework4;

import java.util.Scanner;

public class Triangle {
    private static double a;
    private static double b;
    private static double c;
    private static double p;
    private static double s;
    private static Scanner scanner = new Scanner(System.in);


    public static double s(double a, double b, double c) throws MyException {
        if ((a >= b + c) || (b >= a + c) || (c >= a + b)){
            throw new MyException ("Такого треуголника не существует!");
        }
        p = (a + b + c) / 2;
        s = Math.sqrt(p * (p - a) * (p - b) * (p - c));
        return s;
    }

//    public static boolean isTriangle(double a, double b, double c) {
//        if (a >= b + c) {
//            return false;
//        }
//        if (b >= a + c) {
//            return false;
//        }
//        if (c >= a + b) {
//            return false;
//        }
//        return true;
//    }
    public static double getValue(){
        while (true) {
            System.out.println("Введите число");
            if (scanner.hasNextDouble()){
                double n =scanner.nextDouble();
               return n;
            } else {
                System.out.println("Это не число!");
                scanner.next();
            }
        }

    }

    public static void main(String[] args) {

            System.out.print("Сторона а. ");
            a = getValue();

            System.out.print("Сторона b. ");
            b = getValue();

            System.out.print("Сторона c. ");
            c = getValue();

        try {
            System.out.println(s(a, b, c));
        } catch (MyException e) {
            e.printStackTrace();
        }



    }
}
