package NgonNguLapTrinhJava.BaiTap.HienThiLoiChao;

import java.util.Scanner;

public class Display {
    public static void main(String[] args) {
        System.out.println("Enter Your name:");
        Scanner scanner =new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println("Hello: "+input);

    }
}
