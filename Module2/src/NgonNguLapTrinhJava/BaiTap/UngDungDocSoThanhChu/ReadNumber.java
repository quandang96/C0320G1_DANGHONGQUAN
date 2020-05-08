package NgonNguLapTrinhJava.BaiTap.UngDungDocSoThanhChu;

import java.util.Scanner;

public class ReadNumber {
    public static String number1(String a){
        switch (a) {
            case "0":
                return "Zero";
            case "1":
                return "One";

            case "2":
                return "Two";
            case "3":
                return "Three";
            case "4":
                return "Four";
            case "5":
                return "Five";
            case "6":
                return "Six";
            case "7":
                return "Seven";
            case "8":
                return "Eight";
            case "9":
                return "Nine";
            default:
                return "out of ability";
        }
    }
    public static String number2(String b){
        switch (b){
            case "10":
                return"Ten";

            case "11":
                return "Eleven";
            case "12":
                return "twelve";

            case "13":
                return "thirteen";
            case "15":
                return "Fifteen";
            case "20":
                return "Twenty";
            case "30":
                return "Thirty";
            case "50":
                return "Fifty";

            default:
                String element1 = b.substring(0,1);
                if(element1.equals("1")){
                    return number1(element1) +"teen "+ number1(b.substring(1,2));
                } else if(element1.equals("2")||element1.equals("3")||element1.equals("5")){
                        String test = element1 +"0";
                    return number2(test) + number1(b.substring(1,2));
                }else
                    return number1(element1) +"ty "+ number1(b.substring(1,2));
                }
        }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number: ");
        String input = scanner.nextLine();
        if(input.length()==1){
            System.out.print(number1(input));
        }
        if(input.length()==2 ){
        System.out.println(number2(input));
        }
        if(input.length() ==3 ) {
            if (input.equals("100")) {
                System.out.print("One hundred");

            } else if (input.substring(1, 2).equals("0")) {
                System.out.println(number1(input.substring(0, 1)) + " hundred and " + number1(input.substring(2, 3))); }
            else {
                System.out.println(number1(input.substring(0, 1)) + " hundred " + number2(input.substring(1, 3)));
            }
        }
}
}

