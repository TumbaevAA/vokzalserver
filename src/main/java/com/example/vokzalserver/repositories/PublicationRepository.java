package com.example.vokzalserver.repositories;

import com.example.vokzalserver.entities.PublicationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublicationRepository extends JpaRepository<PublicationEntity, Long> {
}
