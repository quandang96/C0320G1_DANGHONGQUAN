package MangVaPhuongThucTrongJava.BaiTap.XoaPhanTuKhoiMang;

import java.util.Scanner;

public class DeleteElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int [] array = {10,4,6,7,8,6,0,0,0,0};
        System.out.println("Enter a number to delete: ");
        int input = Integer.parseInt(scanner.nextLine());
        for(int i=0 ; i<array.length;i++){
            if(array[i] == input){
                for(int j =i;j<array.length-1;j++){
                    array[j]=array[j+1];
                }
                array[array.length-1]=0;
            }
        }
        System.out.print("New array: ");
        for(int i=0;i<array.length;i++){
          System.out.print(array[i]+"\t");
        }
    }
}
