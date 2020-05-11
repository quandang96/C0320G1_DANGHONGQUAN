package MangVaPhuongThucTrongJava.BaiTap.SuDungLopIllegalTriangleException;

import java.util.Scanner;

public class Triangle {
    static void canh(int a) throws IllegalTriangleException{

        if(a<=0){
            throw new IllegalTriangleException(a);
        }
        System.out.println("đúng");
    }
    public static void main(String[] args) {

try{
    Scanner scanner = new Scanner(System.in);
    System.out.println("Nhập cạnh thứ 1: ");

    int a = Integer.parseInt(scanner.nextLine());
    canh(a);
    System.out.println("Nhập cạnh thứ 2: ");
    int b = Integer.parseInt(scanner.nextLine());
    canh(b);
    System.out.println("Nhập cạnh thứ 3: ");
    int c = Integer.parseInt(scanner.nextLine());
    canh(c);


}catch (NullPointerException | IllegalTriangleException e){
    System.out.println("Không đúng");
}
    }
}
