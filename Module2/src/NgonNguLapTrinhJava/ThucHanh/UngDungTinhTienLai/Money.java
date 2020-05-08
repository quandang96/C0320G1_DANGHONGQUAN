package NgonNguLapTrinhJava.ThucHanh.UngDungTinhTienLai;

import java.util.Scanner;

public class Money {
    public static void main(String[] args) {
        double money ;
        int month;
        double interest_rate ;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter investment amount: ");
        money = Double.parseDouble(input.nextLine());
        System.out.println("Enter number of months: ");
        month = Integer.parseInt(input.nextLine());
        System.out.println("Enter annual interest rate in percentage: ");
        interest_rate = Double.parseDouble(input.nextLine());
        double total_interest ;
        for(int i=0;i<month;i++){
            total_interest = money * (interest_rate/100)/12*3;
            System.out.println("Total of interest: " + total_interest);
        }


    }
}
