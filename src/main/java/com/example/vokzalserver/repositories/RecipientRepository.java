package com.example.vokzalserver.repositories;

import com.example.vokzalserver.entities.RecipientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RecipientRepository extends JpaRepository<RecipientEntity,Long> {
    @Query("SELECT DISTINCT g.group FROM GroupEntity g")
    List<RecipientEntity> findAllGroups();

    @Query("SELECT r FROM RecipientEntity r WHERE r.id NOT IN (SELECT g.group.id FROM GroupEntity g)")
    List<RecipientEntity> findAllPeople();
}
