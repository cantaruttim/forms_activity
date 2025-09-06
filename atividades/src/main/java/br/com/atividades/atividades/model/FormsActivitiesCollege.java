package br.com.atividades.atividades.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "activities")
public class FormsActivitiesCollege implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "registrationNumber")
    private String registrationNumber;

    @Column(name = "module")
    private String module;

    @Column(name = "questionOne")
    private String questionOne;

    @Column(name = "questionTwo")
    private String questionTwo;

    @Column(name = "sentAt")
    private LocalDateTime sentAt;

    public FormsActivitiesCollege() {}

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

    public String getQuestionOne() {
        return questionOne;
    }

    public void setQuestionOne(String questionOne) {
        this.questionOne = questionOne;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getQuestionTwo() {
        return questionTwo;
    }

    public void setQuestionTwo(String questionTwo) {
        this.questionTwo = questionTwo;
    }

    public LocalDateTime getSentAt() {
        return sentAt;
    }

    public void setSentAt(LocalDateTime sentAt) {
        this.sentAt = sentAt;
    }

    @PrePersist
    public void prePersist() {
        if (sentAt == null) {
            sentAt = LocalDateTime.now();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof FormsActivitiesCollege that)) return false;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getName(), that.getName()) && Objects.equals(getEmail(), that.getEmail()) && Objects.equals(getRegistrationNumber(), that.getRegistrationNumber()) && Objects.equals(getModule(), that.getModule()) && Objects.equals(getQuestionOne(), that.getQuestionOne()) && Objects.equals(getQuestionTwo(), that.getQuestionTwo()) && Objects.equals(getSentAt(), that.getSentAt());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getEmail(), getRegistrationNumber(), getModule(), getQuestionOne(), getQuestionTwo(), getSentAt());
    }
}
