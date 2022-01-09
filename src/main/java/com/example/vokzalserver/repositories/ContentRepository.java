package com.example.vokzalserver.repositories;

import com.example.vokzalserver.entities.ContentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ContentRepository extends JpaRepository<ContentEntity, Long> {
    @Query("SELECT DISTINCT p.playlist FROM PlaylistEntity p")
    List<ContentEntity> findAllPlaylists();

}
