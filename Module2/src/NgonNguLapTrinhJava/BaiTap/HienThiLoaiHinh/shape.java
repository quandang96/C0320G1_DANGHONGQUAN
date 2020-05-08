package NgonNguLapTrinhJava.BaiTap.HienThiLoaiHinh;

import java.util.Scanner;

public class shape {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Menu:");
        System.out.println("1.Print the rectangle");
        System.out.println("2.Print the square triangle (The corner is square at 4 different angles: top-left, top-right, botton-left, botton-right)");
        System.out.println("3.Print isosceles triangle");
        System.out.println("4.Exit");
        System.out.println("Enter a number: ");
        String input = scanner.nextLine();
        switch (input){
            case "1":
       for(int i=0;i<3;i++){
           System.out.println();
           for(int j = 0; j<7; j++){
               System.out.print("*  ");
           }
       }
       break;
            case "2":
       for(int i=1;i<=5;i++){
           System.out.println();
           for(int j=1;j<=i;j++){
               System.out.print("* ");
           }
       }

       for(int i=7;i>=1;i--){
           System.out.println();
           for(int j=1;j<=i;j++){
               System.out.print("* ");
           }
       }
       break;
            case "3":
                for(int i=1;i<6;i++){
                    System.out.println();
                  for(int j=5;j>=i;j--){
                        System.out.print(" ");
                    }
                    for (int k=0;k<2*i-1;k++){
                        System.out.print("*");
                    }
                    System.out.println();
                }
                break;
        }
    }
}
