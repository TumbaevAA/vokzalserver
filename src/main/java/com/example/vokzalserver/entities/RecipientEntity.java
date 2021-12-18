package com.example.vokzalserver.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "recipient")
public class RecipientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "address", nullable = false)
    private String address;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "item_recipient",
            joinColumns = @JoinColumn(name = "recipient_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "item_id", nullable = false))
    private List<ItemEntity> items;

    @ManyToMany
    @JoinTable(name = "recipient_group",
            joinColumns = @JoinColumn(name = "recipient_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "group_id", nullable = false))
    private List<GroupEntity> groupsThatRecipientBelongsTo;


    public RecipientEntity() {
    }

    public Long getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public List<ItemEntity> getItems() {
        return items;
    }

    public List<GroupEntity> getGroupsThatRecipientBelongsTo() {
        return groupsThatRecipientBelongsTo;
    }
}
