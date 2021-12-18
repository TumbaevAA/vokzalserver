package com.example.vokzalserver.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "\"group\"")
public class GroupEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToMany
    @JoinTable(name = "recipient_group",
            joinColumns = @JoinColumn(name = "group_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "recipient_id", nullable = false))
    private List<RecipientEntity> recipients;


    public GroupEntity() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<RecipientEntity> getRecipients() {
        return recipients;
    }
}
