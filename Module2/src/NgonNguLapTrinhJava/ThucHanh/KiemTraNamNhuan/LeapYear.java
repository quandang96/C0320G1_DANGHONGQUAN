package NgonNguLapTrinhJava.ThucHanh.KiemTraNamNhuan;

import java.util.Scanner;

public class LeapYear {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a year: ");
        int year = Integer.parseInt(scanner.nextLine());
         boolean isLeapYear = false;
         boolean isDivisionBy4 = year % 4 ==0;
         if(isDivisionBy4){
             boolean isDivisionBy100 = year % 100 ==0;
             if(isDivisionBy100){
                 boolean isDivisionBy400 = year % 400 ==0;
                 if(isDivisionBy400){
                     isLeapYear =true;
                 }
             } else {
                 isLeapYear =true;
             }
         }
         if(isLeapYear){
             System.out.printf("%d is a leap year", year);
         }else {
             System.out.printf("%d is not a leap year", year);
         }
    }
}
