package NgonNguLapTrinhJava.BaiTap.UngDungChuyenDoiTienTe;

import java.util.Scanner;

public class MoneyConversion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rate =23000;
        System.out.println("Enter VND: ");
        double input = Double.parseDouble(scanner.nextLine());
        double pay = input*rate;
        System.out.printf("%.2f USD = %.2f VND",input,pay);
    }
}
