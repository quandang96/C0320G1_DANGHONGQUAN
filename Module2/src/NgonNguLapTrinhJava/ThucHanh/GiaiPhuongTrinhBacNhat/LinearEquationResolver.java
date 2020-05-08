package NgonNguLapTrinhJava.ThucHanh.GiaiPhuongTrinhBacNhat;

import java.util.Scanner;

public class LinearEquationResolver {
    public static void main(String[] args) {
        System.out.println("Linear Equation Resolver");
        System.out.println("Given a equation as 'a * x + b = 0', please enter constants: ");
        Scanner scanner = new Scanner(System.in);
        System.out.print("a: ");
        double a = scanner.nextDouble();
        System.out.println("b: ");
        double b =scanner.nextDouble();
        System.out.println("c: ");
        double c =scanner.nextDouble();
        if (a !=0){
            double solution = -b/a;
            System.out.printf("The solution is: x= %f!", solution);
        }
        if(a!=0){
            double answer = (c-b)/a;
            System.out.printf("Equation pas with x= %f!\n", answer);
        }else{
            if(b==0){
                System.out.print("No solution!");
            }
        }
    }
}
