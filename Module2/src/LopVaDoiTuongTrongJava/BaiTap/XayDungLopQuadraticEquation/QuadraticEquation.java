package LopVaDoiTuongTrongJava.BaiTap.XayDungLopQuadraticEquation;

import java.util.Scanner;

public class QuadraticEquation {
    private double a,b,c;
    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }
    public double getDiscriminant(){
        return Math.pow(this.b,2)-4* this.a* this.c;
    }
    public double getRoot1(){

        return (-this.b + Math.sqrt(getDiscriminant()))/2* this.a;
    }
    public double getRoot2(){
        return (-this.b - Math.sqrt(getDiscriminant()))/2* this.a;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a: ");
        double a = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter b: ");
        double b = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter c: ");
        double c = Double.parseDouble(scanner.nextLine());
        QuadraticEquation account = new  QuadraticEquation(a,b,c);
        if(account.getDiscriminant()> 0){
            System.out.println("The equation has two roots" +account.getRoot1() + " and "+account.getRoot2());
        }else if(account.getDiscriminant()==0){
            System.out.println("The equation has two roots " +account.getRoot1());
        } else {
            System.out.println("The equation has no roots");
        }
    }
}
