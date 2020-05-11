package MangVaPhuongThucTrongJava.BaiTap.TimGiaTriNhoNhatTrongMang;

import java.util.Scanner;

public class FindMin {
    public static int minValue(int [] input){

        int min = input[0];

        for (int i = 1; i < input.length; i++){
            if(input[i] < min) {
                min = input[i];
            }
        }

        return min;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[5];
        for(int i= 0; i<array.length;i++){
            System.out.println("Enter element "+i+ " :");
            int number = Integer.parseInt(scanner.nextLine());
            array[i]=number;
        }
        System.out.println("Smallest Value: "+minValue(array));


    }
}
