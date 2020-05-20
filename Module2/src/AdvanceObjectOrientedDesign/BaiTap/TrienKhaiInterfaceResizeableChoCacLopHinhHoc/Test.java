package AdvanceObjectOrientedDesign.BaiTap.TrienKhaiInterfaceResizeableChoCacLopHinhHoc.TrienKhaiInterfaceResizeableChoCacLopHinhHoc;


import AdvanceObjectOrientedDesign.BaiTap.TrienKhaiInterfaceResizeableChoCacLopHinhHoc.Circle;
import AdvanceObjectOrientedDesign.BaiTap.TrienKhaiInterfaceResizeableChoCacLopHinhHoc.Rectangle;
import AdvanceObjectOrientedDesign.BaiTap.TrienKhaiInterfaceResizeableChoCacLopHinhHoc.Resizeable;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        Resizeable[] resizeable = new Resizeable[2];
        resizeable[0] = new Circle(3.5);
        resizeable[1] = new Rectangle(2.3, 5.8);
        for(Resizeable shape:resizeable) {

            if(shape instanceof Circle){
                System.out.println("Area Circle Before: "+shape.getArea());
                System.out.print("Area Circle After: ");
            }else {
                System.out.println("Area Rectangle Before: "+shape.getArea());
                System.out.print("Area Rectangle After: ");
            }
            shape.resize(Math.random()*100/100);
        }
    }
}