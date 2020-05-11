package NgonNguLapTrinhJava.ThucHanh.TimUocSoChung;

import java.util.Scanner;

public class Find {
    public static void main(String[] args) {
int a,b;
        Scanner nhap = new Scanner(System.in);
        System.out.println("Enter a: ");
        a= Integer.parseInt(nhap.nextLine());
        System.out.println("Enter b: ");
        b= Integer.parseInt(nhap.nextLine());
        a=Math.abs(a);
        b=Math.abs(b);
        if(a==0||b==0) {
            System.out.println("No greatest common factor ");
        }else {
            while(a!=b){
                if (a>b){
                    a=a-b;
                }else {
                    b=b-a;
                }
            }
            System.out.println("Greatest common factor: "+a);
        }
    }
}
