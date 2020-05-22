package AdvanceObjectOrientedDesign.BaiTap.TrienKhaiInterfaceColorableChoCacLopHinhHoc;

import java.util.ArrayList;

public class TestColorable {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
          shapes[0] = new Circle(3.5);
          shapes[1] = new Rectangle(2.3, 5.8);
          shapes[2] = new Square();
          for(Shape element:shapes ){
              if(element instanceof Colorable){
                  ((Colorable)element).howToColor();
              }else if(element instanceof Circle){
                  System.out.println(((Circle) element).getArea());
              }else {
                  System.out.println(((Rectangle) element).getArea());
              }
          }
    }
}

