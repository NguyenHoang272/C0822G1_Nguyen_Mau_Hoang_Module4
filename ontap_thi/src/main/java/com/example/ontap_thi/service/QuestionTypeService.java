package com.example.ontap_thi.service;

import com.example.ontap_thi.model.QuestionType;
import com.example.ontap_thi.repository.QuestionTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionTypeService implements IQuestionTypeService{

    @Autowired
    private QuestionTypeRepository questionTypeRepository;
    @Override
    public List<QuestionType> findAllQuestionType() {
        return questionTypeRepository.findAll();
    }
}
