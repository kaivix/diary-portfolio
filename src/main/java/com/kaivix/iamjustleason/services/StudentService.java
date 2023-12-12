package com.kaivix.iamjustleason.services;

import com.kaivix.iamjustleason.model.Student;
import com.kaivix.iamjustleason.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> findAll(){
        return studentRepository.findAll();
    }
    
    public Student findOne(int id){
        Optional<Student> st =  studentRepository.findById(id);
        return st.orElse(null);
    }
    public void save(Student student){
        studentRepository.save(student);
    }

    public void update(int id, Student updStudent){
        updStudent.setId(id);
        studentRepository.save(updStudent);
    }

    public void delete(int id){
        studentRepository.deleteById(id);
    }
}
