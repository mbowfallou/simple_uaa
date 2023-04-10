package com.groupeisi.repository;

import com.groupeisi.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStudentRepository extends JpaRepository<StudentEntity, Integer> {
}
