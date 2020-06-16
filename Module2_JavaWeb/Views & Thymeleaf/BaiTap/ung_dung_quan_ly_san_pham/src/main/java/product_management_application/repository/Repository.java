package product_management_application.repository;

import java.util.List;

public interface Repository <T> {
    List<T> findAll();
    void save(T t);
    T findId(int id);
    void update (int id ,T t );
    void remove (int id);
    List<T> findName(String name);

}
