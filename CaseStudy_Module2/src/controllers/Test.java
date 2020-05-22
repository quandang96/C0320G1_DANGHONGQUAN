package controllers;

import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws IOException {

        while (true){
            String regexDate = "^(((([0-2][1-9]|(10))[/]([0][1-9]|[1][12]))|((30)[/](([0][13-9])|([1][12]))))|((31)[/]([0][13578]|(12))))[/][0-9]{4}$";
            Scanner scanner=new Scanner(System.in);
            String input=scanner.nextLine();
            if(input.matches(regexDate)){
                int date=Integer.parseInt(input.substring(0,2));
                int month=Integer.parseInt(input.substring(3,5));
                int year = Integer.parseInt(input.substring(6,10));
                String localDate= java.time.LocalDate.now().toString();
                if((Integer.parseInt(localDate.substring(0,4))-year)>18){
                    System.out.println(input);
                    break;
                }else if((Integer.parseInt(localDate.substring(0,4))-year)==18 && (month-Integer.parseInt(localDate.substring(5,7)))>0){
                    System.out.println(input);
                    break;
                }else if((month-Integer.parseInt(localDate.substring(5,7)))==0 && (date-Integer.parseInt(localDate.substring(8,10)))>=0){
                    System.out.println(input);
                    break;
                }else {
                    System.out.println("under 18 years old");
                }
            }else {
                System.out.println("Enter the wrong information");
            }

        }
    }
}





