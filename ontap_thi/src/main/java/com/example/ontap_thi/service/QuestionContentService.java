package com.example.ontap_thi.service;

import com.example.ontap_thi.model.QuestionContent;
import com.example.ontap_thi.repository.QuestionContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionContentService implements IQuestionContentService {
    @Autowired
    private QuestionContentRepository questionContentRepository;

    @Override
    public Page<QuestionContent> search(String date, String title, String questionType, Pageable pageable) {
        return questionContentRepository.search(date, title, questionType, pageable) ;
    }

    @Override
    public void save(QuestionContent questionContent) {
        questionContentRepository.save(questionContent);
    }

    @Override
    public void delete(int id) {
        questionContentRepository.delete(id);
    }

    @Override
    public List<QuestionContent> findAll() {
        return questionContentRepository.findAll();
    }

    @Override
    public QuestionContent findById(int id) {
        return questionContentRepository.findById(id).orElse(null);
    }
}
