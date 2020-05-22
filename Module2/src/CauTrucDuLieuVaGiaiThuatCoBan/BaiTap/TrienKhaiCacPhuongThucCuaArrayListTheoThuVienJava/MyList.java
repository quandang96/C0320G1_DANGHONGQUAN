package CauTrucDuLieuVaGiaiThuatCoBan.BaiTap.TrienKhaiCacPhuongThucCuaArrayListTheoThuVienJava;

import java.util.Arrays;

public class MyList<E> {
    private int size =0;
    private static final int DEFAULT_CAPACITY =10;
    private Object[] element;

    public MyList(int capacity) {
        element = new Object[capacity];
    }
    public void ensureCapacity(int minCapacity){
            int newCapacity= minCapacity+1;
            element = Arrays.copyOf(element,newCapacity );
    }

    public E get(int i) {
        return (E) element[i];
    }

    public MyList(){
        element = new Object[DEFAULT_CAPACITY];

    }
    public void add(int index,E element){
            ensureCapacity(this.element.length);
        for (int i=this.element.length-1;i>index;i--){
            this.element[i]=this.element[i-1];
        }
        this.element[index]=element;
        size++;

    }
    public E remote(int index){
        if(index>=size||index<0){
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + index );
        }
       for(int i=index;i<size;i++){
               element[i]=element[i+1];
           }

       size--;
       return (E) element;
    }
    public int size(){
        return this.size;
    }
public boolean contains(E o){
      for(int i=0;i<size;i++){
          if(o.equals(element[i])) {
              return true;
          }
      }
      return false;
}
public int indexOf(E o){
        for(int i=0;i<size;i++){
            if (o.equals(element[i])){
                return i;
            }
        }
    return -1;
}
    public void clear(){
        element = (E[]) new Object[DEFAULT_CAPACITY];
        size=0;
    }
    public E clone(){
        MyList myList = new MyList();

        for (int i = 0; i < size; i++) {
            myList.element[i] = element[i];
        }

        myList.size = size;

        return (E) myList;
    }


}

