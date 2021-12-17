package com.example.vokzalserver.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "device")
public class DeviceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "status", nullable = false)
    private int status;

    @OneToMany(cascade = CascadeType.ALL,
            mappedBy = "device",
            fetch = FetchType.EAGER)
    private List<ChannelEntity> channels;


    public DeviceEntity() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getType() {
        return type;
    }

    public int getStatus() {
        return status;
    }

    public List<ChannelEntity> getChannels() {
        return channels;
    }
}
