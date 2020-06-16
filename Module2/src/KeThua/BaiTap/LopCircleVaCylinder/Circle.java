package KeThua.BaiTap.LopCircleVaCylinder;

public class Circle {
    private double radius;
    private String color;
    public Circle(double radius,String color){
        this.radius = radius;
        this.color =color;
    }
    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public static void main(String[] args) {

    }
    public double area(){
        return Math.pow(this.radius,2)*Math.PI;
    }
    @Override
    public String toString(){
        return "A Circle with radius="
                + getRadius()
                + " color: "
                + getColor()
                +" area: "
                +area();


    }
}
