package com.example.ontap_thi.model;

import javax.persistence.*;

@Entity
public class QuestionContent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String content;
    private String answer;
    private String date;
    private String status;
    private int deleteStatus = 1;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "questionTypeId", referencedColumnName = "id")
    private QuestionType questionTypeId;
    public QuestionContent() {
    }

    public QuestionContent(int id, String title, String content, String answer, String date, String status, int deleteStatus, QuestionType questionTypeId) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.answer = answer;
        this.date = date;
        this.status = status;
        this.deleteStatus = deleteStatus;
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

    public int getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(int deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public QuestionType getQuestionTypeId() {
        return questionTypeId;
    }

    public void setQuestionTypeId(QuestionType questionTypeId) {
        this.questionTypeId = questionTypeId;
    }


}
