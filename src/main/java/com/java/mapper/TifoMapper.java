package com.java.mapper;

import com.java.entity.Tifo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TifoMapper {
    
    List<Tifo> selectTifo();

    int deleteTifo(int id);

    int updateTifo(Tifo tifo);

    int addTifo(Tifo tifo);
}
