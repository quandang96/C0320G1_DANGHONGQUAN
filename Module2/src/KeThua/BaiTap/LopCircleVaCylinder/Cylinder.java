package KeThua.BaiTap.LopCircleVaCylinder;

public class Cylinder extends Circle{
    private double height ;
    public Cylinder(double radius, String color, double height) {
        super(radius, color);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    public double volume (){
        return area()*this.height;
    }

    @Override
    public String toString() {
        return "height= " + height
                + "Volume: "
                +volume();
    }
}
