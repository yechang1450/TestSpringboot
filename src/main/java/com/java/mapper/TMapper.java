package com.java.mapper;

import com.java.entity.T;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TMapper {

    List<T> selectT();

    int deleteT(int id);

    int updateT(T t);

    int addT(T t);
}
