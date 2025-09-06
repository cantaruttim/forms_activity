package br.com.atividades.atividades.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serializable;
import java.util.Objects;


@JsonPropertyOrder({"id", "Nome", "Email", "Matrícula", "Módulo", "Question_One", "Question_Two"})
public class FormsActivitiesCollegeDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("Nome")
    private String name;

    @JsonProperty("Email")
    private String email;

    @JsonProperty("Matrícula")
    private String registrationNumber;

    @JsonProperty("Módulo")
    private String module;

    @JsonProperty("Question_One")
    private String questionOne;

    @JsonProperty("Question_Two")
    private String questionTwo;

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
        return Objects.equals(getName(), that.getName()) && Objects.equals(getEmail(), that.getEmail()) && Objects.equals(getRegistrationNumber(), that.getRegistrationNumber()) && Objects.equals(getModule(), that.getModule()) && Objects.equals(getQuestionOne(), that.getQuestionOne()) && Objects.equals(getQuestionTwo(), that.getQuestionTwo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getEmail(), getRegistrationNumber(), getModule(), getQuestionOne(), getQuestionTwo());
    }
}
