package MangVaPhuongThucTrongJava.BaiTap.TinhTongCacSoODuongCheoChinhCuaMaTranVuong;

import java.util.Scanner;

public class Sum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        float sum = 0f;
        float [][] array = new float[3][3];
        for(int i=0;i<array.length;i++){
            for(int j=0;j<array[i].length;j++){
                System.out.println("Enter element "+i+j+" :");
                float input = Float.parseFloat(scanner.nextLine());
                array[i][j]=input;
                if(i==j){
                  sum+=array[i][j];
                }
            }
        }
        System.out.println("Sum the numbers in the main diagonal of the square matrix: "+sum);
    }
}
