package LopVaDoiTuongTrongJava.BaiTap.XayDungLopFan;

public class Fan {
    final int slow = 1;
    final int medium = 2;
    final  int fast = 3;
    private int speed = slow;
    private boolean on =false;
    private double radius =5;
    private String color ="blue";

    public int getSpeed() {
        return speed;
    }

    public boolean isOn() {
        return on;
    }

    public double getRadius() {
        return radius;
    }

    public String getColor() {
        return color;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setColor(String color) {
        this.color = color;
    }
   public String toString(){
       if(isOn()){
           return "Speed: "+getSpeed() +"\tColor: "+getColor() +"\tRadius: "+ getRadius() +"\t fan is on";
       }else {
           return "Color: "+getColor() +"\tRadius: "+ getRadius() +" \tfan is off";
       }

   }
    public static void main(String[] args) {
        Fan fan1 = new Fan();
        Fan fan2 = new Fan();
        fan1.setOn(true);
        fan1.setSpeed(fan1.fast);
        fan1.setRadius(10);
        fan1.setColor("yellow");
        System.out.println(fan1.toString());
        fan2.setOn(false);
        fan2.setSpeed(fan2.medium);
        fan2.setRadius(5);
        fan2.setColor("blue");
        System.out.println(fan2.toString());

    }
}
