package LopVaDoiTuongTrongJava.BaiTap.XayDungLopStopWatch;

import java.util.Arrays;

public class StopWatch {
    private long startTime;
    private long endTime;
    double[] sort(double arr[])
    {
        int n = arr.length;

        for (int i = 0; i < n-1; i++) {
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (arr[j] < arr[min_idx])
                    min_idx = j;
            double temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }

    public StopWatch() {
        System.currentTimeMillis();
    }

    public long getStartTime() {
        return startTime;
    }

    public long getEndTime() {
        return endTime;
    }
    public void start(){
        this.startTime = System.currentTimeMillis();
    }
    public void  stop(){
        this.endTime = System.currentTimeMillis();
    }
    public long getElapsedTime(){
        return this.endTime - this.startTime;
    }

    public static void main(String[] args) {
       double [] array = new double[100000];
        StopWatch stopWatch = new StopWatch();

        stopWatch.start();
       for(int i=0;i<array.length;i++){
           double a =  Math.random();
           array[i]= a;
       }
        stopWatch.sort(array);
        System.out.println(Arrays.toString(array));
       stopWatch.stop();
        System.out.println("Thời gian thực hiện: "+stopWatch.getElapsedTime());
    }
}
