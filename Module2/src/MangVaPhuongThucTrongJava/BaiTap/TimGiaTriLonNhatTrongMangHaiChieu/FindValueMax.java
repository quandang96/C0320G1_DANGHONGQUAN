package MangVaPhuongThucTrongJava.BaiTap.TimGiaTriLonNhatTrongMangHaiChieu;

import java.util.Scanner;

public class FindValueMax {
    public static void main(String[] args) {
        int position1 =0;
        int position2 = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a index1: ");
        int index1 = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter a index2: ");
        int index2 = Integer.parseInt(scanner.nextLine());
        float [][] array = new float[index1][index2];
        for(int i=0;i<array.length;i++){
            for(int j=0;j<array[i].length;j++){
                System.out.println("Enter element "+i+j+" :");
                float number = Float.parseFloat(scanner.nextLine());
                array[i][j]=number;
            }
        }
        float max= array[0][0];
        for(int i=0;i<array.length;i++){
            for(int j=1;j<array[i].length;j++){
                if(array[i][j] > max){
                    max =array[i][j];
                    position1 = i;
                    position2 = j;
                }
            }
        }
        System.out.println("Greatest value: "+max+ " at position: "+position1+position2);
    }
}
