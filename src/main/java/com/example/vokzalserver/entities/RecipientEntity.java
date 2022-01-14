package com.example.vokzalserver.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "recipient")
public class RecipientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "address", nullable = false)
    private String address;                      //Адрес получателя или название группы


    /*Если связь не null, то получатель является группой.
    *Связь нужна, чтобы доставать получателей группы */
    @OneToMany(mappedBy = "group")
    private List<GroupEntity> group;

    /*Через эту связь в таблице group указывается, какие получатели входят в группу.
     * То есть, если эта связь не null, то этот получатель входит в группы из списка*/
    @OneToMany(mappedBy = "recipient")
    private List<GroupEntity> groupsThatRecipientBelongsTo;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipient")
    private List<PublicationEntity> publications;


    public RecipientEntity() {
    }


    public Long getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public List<GroupEntity> getGroup() {
        return group;
    }

    public List<GroupEntity> getGroupsThatRecipientBelongsTo() {
        return groupsThatRecipientBelongsTo;
    }
}
