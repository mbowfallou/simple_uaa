package com.groupeisi.repository;

import com.groupeisi.entity.ProfessorEntity;
import com.groupeisi.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProfessorRepository extends JpaRepository<ProfessorEntity, Integer> {
}
