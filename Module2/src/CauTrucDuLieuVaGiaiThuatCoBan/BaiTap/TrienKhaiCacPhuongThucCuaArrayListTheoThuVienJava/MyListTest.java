package CauTrucDuLieuVaGiaiThuatCoBan.BaiTap.TrienKhaiCacPhuongThucCuaArrayListTheoThuVienJava;



public class MyListTest {
    public static void main(String[] args)  {
         MyList <String> myList = new MyList<>(4);
        myList.add(0,"abc");
        myList.add(1,"abc1");
        myList.add(2,"abc2");
        myList.add(3,"abc3");
        for(int i=0;i<myList.size();i++){
            System.out.println(myList.get(i));
        }
        System.out.println("-------------->");
        myList.add(4,"abc0");
        myList.add(5,"abc4");
        myList.add(6,"abc10");
        System.out.println(myList.size());
        myList.remote(0);


        for(int i=0;i<myList.size();i++){
            System.out.println(myList.get(i));
        }
        System.out.println(myList.contains("abc1"));
    }

}
