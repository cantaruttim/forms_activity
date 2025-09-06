package br.com.atividades.atividades.data.dto;

import java.io.Serializable;
import java.util.Objects;

public class FormsActivitiesCollegeDTO implements Serializable {

    private static final long serialVersionUID = 1L;


    private Long id;
    private String name;
    private String email;
    private String registrationNumber;
    private String module;
    private String questionOne;
    private String questionTwo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getQuestionOne() {
        return questionOne;
    }

    public void setQuestionOne(String questionOne) {
        this.questionOne = questionOne;
    }

    public String getQuestionTwo() {
        return questionTwo;
    }

    public void setQuestionTwo(String questionTwo) {
        this.questionTwo = questionTwo;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof FormsActivitiesCollegeDTO that)) return false;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getName(), that.getName()) && Objects.equals(getEmail(), that.getEmail()) && Objects.equals(getRegistrationNumber(), that.getRegistrationNumber()) && Objects.equals(getModule(), that.getModule()) && Objects.equals(getQuestionOne(), that.getQuestionOne()) && Objects.equals(getQuestionTwo(), that.getQuestionTwo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getEmail(), getRegistrationNumber(), getModule(), getQuestionOne(), getQuestionTwo());
    }
}
