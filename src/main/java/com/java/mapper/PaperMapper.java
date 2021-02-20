package com.java.mapper;

import com.java.entity.Paper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaperMapper {

    List<Paper> selectAllPaperHead();

    int deletePaper(int id);

    int updatePaper(Paper paper);

    int addPaper(Paper paper);

    int changePaperStatus(Paper paper);
}
