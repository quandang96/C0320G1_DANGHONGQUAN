package KeThua.BaiTap.LopPoint2DVaLopPoint3D;

public class Point3D extends Point2D{
    private float z=0.0f;

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }
    public float[] getXYZ(float x,float y,float z) {
        float[] array = {x,y,z};
        return array;
    }

    public void setXYZ(float x,float y,float z) {
        setXY(x,y);
        this.z = z;
    }

    @Override
    public String toString() {
        return super.toString()+
                 " z=" + z ;
    }

}
