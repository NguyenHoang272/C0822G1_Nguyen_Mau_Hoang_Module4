package com.example.ontap_thi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class QuestionType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @OneToMany(mappedBy = "questionTypeId")
    @JsonBackReference
    private Set<QuestionContent> questioncontents;

    public QuestionType() {
    }

    public QuestionType(int id, String name, Set<QuestionContent> questioncontents) {
        this.id = id;
        this.name = name;
        this.questioncontents = questioncontents;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<QuestionContent> getQuestioncontents() {
        return questioncontents;
    }

    public void setQuestioncontents(Set<QuestionContent> questioncontents) {
        this.questioncontents = questioncontents;
    }
}
