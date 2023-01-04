package com.example.ontap_thi.service;

import com.example.ontap_thi.model.QuestionContent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IQuestionContentService {
    Page<QuestionContent> search(String date, String title,String questionType, Pageable pageable);
    void save(QuestionContent questionContent);
    void delete(int id);
    List<QuestionContent> findAll();
    QuestionContent findById(int id);

}
