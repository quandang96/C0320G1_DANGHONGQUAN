package MangVaPhuongThucTrongJava.BaiTap.ThemPhanTuVaoMang;

import java.util.Scanner;

public class AddElement {
    public static void main(String[] args) {
       int[] array = new int[10];
       int index;
        Scanner scanner = new Scanner(System.in);
       while(true) {
           System.out.println("Enter a number: ");
           int input = Integer.parseInt(scanner.nextLine());
           while (true) {
               System.out.println("Enter a index: ");
               index = Integer.parseInt(scanner.nextLine());
               if (index >= 1 && index <= array.length - 1) {
                   break;
               }
           }
           for (int i = array.length - 1; i > index; i--) {
               array[i] = array[i - 1];
           }
           array[index] = input;
           for (int value : array) {
               System.out.print(value + "\t");
           }
           String stop = scanner.nextLine();
           if(stop.equals("0")){
               System.exit(0);
           }
       }

        }

    }

