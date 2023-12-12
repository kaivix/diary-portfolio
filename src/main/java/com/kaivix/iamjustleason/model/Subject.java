package com.kaivix.iamjustleason.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Subject")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "subject_name")
    private String subjectname;

    public Subject() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubjectname() {
        return subjectname;
    }

    public void setSubjectname(String subjectname) {
        this.subjectname = subjectname;
    }

    public Subject(int id, String subjectname) {
        this.id = id;
        this.subjectname = subjectname;
    }
}
