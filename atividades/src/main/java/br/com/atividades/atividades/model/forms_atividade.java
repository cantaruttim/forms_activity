package br.com.atividades.atividades.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "forms_atividade")
public class forms_atividade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "matricula", nullable = false)
    private String matricula;

    @Column(name = "modulo", nullable = false)
    private String modulo;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "QUm", nullable = false)
    private String QUm;

    @Column(name = "QDois", nullable = false)
    private String QDois;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getModulo() {
        return modulo;
    }

    public void setModulo(String modulo) {
        this.modulo = modulo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getQUm() {
        return QUm;
    }

    public void setQUm(String QUm) {
        this.QUm = QUm;
    }

    public String getQDois() {
        return QDois;
    }

    public void setQDois(String QDois) {
        this.QDois = QDois;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof forms_atividade that)) return false;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getNome(), that.getNome()) && Objects.equals(getMatricula(), that.getMatricula()) && Objects.equals(getModulo(), that.getModulo()) && Objects.equals(getEmail(), that.getEmail()) && Objects.equals(getQUm(), that.getQUm()) && Objects.equals(getQDois(), that.getQDois());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNome(), getMatricula(), getModulo(), getEmail(), getQUm(), getQDois());
    }
}
