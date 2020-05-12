package MangVaPhuongThucTrongJava.BaiTap.SuDungLopIllegalTriangleException;

import java.util.Scanner;

public class Triangle {
    static void check(int a) throws IllegalTriangleException{

        if(a<=0){
            throw new IllegalTriangleException("Wrong value entered");
        }
    }
    static  void checkTriangleEdge(int a,int b,int c) throws IllegalTriangleException{
        if(a+b<c||a+c<b||b+c<a){
            throw new IllegalTriangleException("The three-sided value of the triangle is incorrect");
        }
    }
    public static void main(String[] args) {

try{
    Scanner scanner = new Scanner(System.in);
    System.out.println("Nhập cạnh thứ 1: ");

    int a = Integer.parseInt(scanner.nextLine());
    check(a);
    System.out.println("Nhập cạnh thứ 2: ");
    int b = Integer.parseInt(scanner.nextLine());
    check(b);
    System.out.println("Nhập cạnh thứ 3: ");
    int c = Integer.parseInt(scanner.nextLine());
    check(c);
    checkTriangleEdge(a,b,c);

}catch ( IllegalTriangleException e){
    System.out.println(e.getMessage());
}
    }
}
