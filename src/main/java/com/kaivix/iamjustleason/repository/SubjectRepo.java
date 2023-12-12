package com.kaivix.iamjustleason.repository;

import com.kaivix.iamjustleason.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepo extends JpaRepository<Subject, Integer> {
}
