package com.example.vokzalserver.repositories;

import com.example.vokzalserver.entities.DeviceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeviceRepository extends JpaRepository<DeviceEntity,Long> {

    @Query("select d from DeviceEntity d where d.type = ?1")
    List<DeviceEntity> findAllByType(String type);

}
