package com.example.vokzalserver.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "channel")
public class ChannelEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "device_id", nullable = false)
    private DeviceEntity device;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(cascade = CascadeType.ALL,
            mappedBy = "channel",
            fetch = FetchType.EAGER)
    private List<PublicationEntity> items;


    public ChannelEntity() {
    }

    public Long getId() {
        return id;
    }

    public DeviceEntity getDevice() {
        return device;
    }

    public String getName() {
        return name;
    }

    public List<PublicationEntity> getItems() {
        return items;
    }
}
