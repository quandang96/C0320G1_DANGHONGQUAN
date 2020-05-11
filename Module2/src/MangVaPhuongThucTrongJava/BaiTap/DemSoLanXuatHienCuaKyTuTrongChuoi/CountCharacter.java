package MangVaPhuongThucTrongJava.BaiTap.DemSoLanXuatHienCuaKyTuTrongChuoi;

import java.util.Scanner;

public class CountCharacter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String  str ="HELLO WORLD";
        int count =0;
        System.out.println("Enter the character to Search: ");
        String input = scanner.nextLine();
        for(int i =0;i<str.length();i++){
            if(str.substring(i,i+1).equals(input) ){
                 count++;
            }
        }
        System.out.println("The number of occurrences of a character in the string : "+count );
    }
}
