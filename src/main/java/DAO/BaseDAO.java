package DAO;

import java.sql.Connection;
import java.util.ArrayList;

public interface BaseDAO <T, ID>{
    T findById(ID id, Connection conn);

    ArrayList<T> findAll();

    int insert (T type, Connection conn);


}
