package NgonNguLapTrinhJava.BaiTap.HienThiCacSoNguyenNhoHon100;

public class Display {
     static boolean isPrime( int number){
        if(number < 2){
            return false;
        } else {
            for(int i=2;i<Math.sqrt(number);i++){

                if(number % i==0){
                    return false;
                }
            }
            return true;
        }
    }
    public static void main(String[] args) {
     for(int i=1;i<100;i++){
         if(isPrime(i)){
             System.out.println(i);
         }
     }

    }
}
