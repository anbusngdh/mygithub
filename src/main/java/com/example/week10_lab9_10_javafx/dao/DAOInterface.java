package com.example.week10_lab9_10_javafx.dao;

import java.util.List;

public interface DAOInterface<T>{
    List<T> getAll();
    String findById(List<T> object);
    T add(T id);


}
