package com.kaivix.iamjustleason.repository;

import com.kaivix.iamjustleason.model.Grade;
import com.kaivix.iamjustleason.model.Student;
import com.kaivix.iamjustleason.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GradeRepository extends JpaRepository<Grade, Integer> {
    List<Grade> findBySubjectAndAndStudent(Subject subject, Student student);
}
