package com.example.week10_lab9_10_javafx.dao;

import java.util.List;

public class DAOImpObj<T> implements DAOInterface<T> {


    @Override
    public List<T> getAll() {
        return List.of();
    }

    @Override
    public String findById(List<T> object) {
        return "";
    }

    @Override
    public T add(T id) {
        return null;
    }
}
