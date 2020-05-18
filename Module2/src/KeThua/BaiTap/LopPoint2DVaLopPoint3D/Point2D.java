package KeThua.BaiTap.LopPoint2DVaLopPoint3D;

public class Point2D {
    private float x=0.0f;
    private float y=0.0f;

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }
    public float[] getXY(float x, float y) {
        float[] array ={x,y};
        return array;
    }

    public void setXY(float x,float y) {
        this.y = y;
        this.x =x;
    }
    public void print(){
        System.out.println("hyhyhyhyhy");
    }
    @Override
    public String toString() {
        return "x= " + x +
                " y= " + y ;
    }

}
