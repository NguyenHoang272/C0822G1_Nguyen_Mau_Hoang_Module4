package com.example.ontap_thi.dto;


import com.example.ontap_thi.model.QuestionType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class QuestionContentDTO implements Validator {

    private int id;
    @NotBlank(message = "Not empty")
    @Size(min = 5,max = 500)
    private String title;
    private String content;
    private String answer;
    @NotBlank(message = "Not empty")
    private String date;
    private String status;
    private QuestionType questionTypeId;

    public QuestionContentDTO() {
    }

    public QuestionContentDTO(int id, String title, String content, String answer, String date, String status, QuestionType questionTypeId) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.answer = answer;
        this.date = date;
        this.status = status;
        this.questionTypeId = questionTypeId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public QuestionType getQuestionTypeId() {
        return questionTypeId;
    }

    public void setQuestionTypeId(QuestionType questionTypeId) {
        this.questionTypeId = questionTypeId;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        QuestionContentDTO questionContentDTO = (QuestionContentDTO) target;

    }
}
