package KeThua.BaiTap.ThietKeVaTrienKhaiLopTriangle;

import java.util.Scanner;

public class TestTriangle {
    public static String input(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
    public static void main(String[] args) {
          Triangle triangle = new Triangle();
        System.out.println("Enter a side1: ");
          triangle.setSide1(Double.parseDouble(input()));
        System.out.println("Enter a side2: ");
          triangle.setSide2(Double.parseDouble(input()));
        System.out.println("Enter a side3: ");
          triangle.setSide2(Double.parseDouble(input()));
        System.out.println("Enter a color: ");
          triangle.setColor(input());
        System.out.println(triangle);
    }
}
