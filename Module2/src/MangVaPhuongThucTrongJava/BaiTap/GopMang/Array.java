package MangVaPhuongThucTrongJava.BaiTap.GopMang;

import java.util.Scanner;

public class Array {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array1 = new int[2];
        int[] array2 = new int[3];
        for(int i=0;i<array1.length;i++){
            System.out.println("Enter element  "+i+ " array1:");
            int number = Integer.parseInt(scanner.nextLine());
            array1[i]=number;
        }
        for(int i=0;i<array2.length;i++){
            System.out.println("Enter element  "+i+ " array2:");
            int input = Integer.parseInt(scanner.nextLine());
            array2[i]=input;
        }
        int sum = array1.length + array2.length;
        int[] array3= new int[sum];
        for(int i=0;i<array3.length;i++){
            if(i<array1.length){
                array3[i]=array1[i];
            } else {
                array3[i] = array2[i -( array2.length-1)];
            }
            System.out.print(array3[i]+"\t");
        }
    }
}
