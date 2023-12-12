package com.kaivix.iamjustleason.services;

import com.kaivix.iamjustleason.model.Grade;
import com.kaivix.iamjustleason.model.Student;
import com.kaivix.iamjustleason.model.Subject;
import com.kaivix.iamjustleason.repository.GradeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GradeService {
    final GradeRepository gradeRepository;

    public GradeService(GradeRepository gradeRepository) {
        this.gradeRepository = gradeRepository;
    }

    public Grade getOne(int id){
        Optional<Grade> one = gradeRepository.findById(id);
        return one.orElse(null);
    }

    public List<Grade> getGradesBySubjectAndStudent(Subject subject, Student student) {
        return gradeRepository.findBySubjectAndAndStudent(subject, student);
    }

    public List<Grade> findAll(){
        return gradeRepository.findAll();
    }
}
