package com.example.vokzalserver.repositories;

import com.example.vokzalserver.entities.ContentEntity;
import com.example.vokzalserver.entities.RecipientEntity;
import org.springframework.boot.web.server.Cookie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ContentRepository extends JpaRepository<ContentEntity, Long> {

    @Query("SELECT DISTINCT p.playlist FROM PlaylistEntity p")
    List<ContentEntity> findAllPlaylists();

    @Query("SELECT c FROM ContentEntity c WHERE c.id NOT IN (SELECT p.playlist.id FROM PlaylistEntity p)")
    List<ContentEntity> findAllContent();

}
