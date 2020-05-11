package MangVaPhuongThucTrongJava.BaiTap.TinhTongCuaCacSoOMotCotXacDinh;

import java.util.Scanner;

public class SumNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        float sum =0f;
        float [][] arr = new float[3][4];
        System.out.println("Enter a column: ");
        int input = Integer.parseInt(scanner.nextLine());
        for(int i=0;i<arr.length;i++){
            for(int j =0;j<arr[i].length;j++){
                System.out.println("Enter element "+i+j+" :");
                float element = Float.parseFloat(scanner.nextLine());
                arr[i][j]=element;
                if(j == input){
                    sum+=arr[i][j];
                }
            }
        }
        System.out.println("Sum the numbers in a given column: "+sum);
    }
}
