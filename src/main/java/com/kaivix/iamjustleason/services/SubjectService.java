package com.kaivix.iamjustleason.services;

import com.kaivix.iamjustleason.model.Grade;
import com.kaivix.iamjustleason.model.Student;
import com.kaivix.iamjustleason.model.Subject;
import com.kaivix.iamjustleason.repository.SubjectRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectService {
    final SubjectRepo subjectRepo;

    public SubjectService(SubjectRepo diaryRepo) {
        this.subjectRepo = diaryRepo;
    }

    public List<Subject> getAllDiaries(){
        return subjectRepo.findAll();
    }

    public Subject getSubjectById(int id){
        Optional<Subject> ss =  subjectRepo.findById(id);
        return ss.orElse(null);
    }

    public void saveDiary(Subject subject){
        subjectRepo.save(subject);
    }

    public void deleteDiary(Subject subject){
        subjectRepo.delete(subject);
    }
}
