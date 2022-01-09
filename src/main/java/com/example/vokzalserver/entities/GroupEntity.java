package com.example.vokzalserver.entities;

import javax.persistence.*;

/*Группа является получателем. Эта табличка нужна, чтобы показать
в какую группу входит получатель*/
@Entity
@Table(name = "\"group\"")
public class GroupEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "useless_pk", nullable = false)
    private Long uselessPK;


    /*group_id это id получателя, который является группой*/
    @ManyToOne
    @JoinColumn(name = "group_id")
    private RecipientEntity group;

    /*recipient_id это id получателя, который входит в данную группу*/
    @ManyToOne
    @JoinColumn(name = "recipient_id")
    private RecipientEntity recipient;


    public GroupEntity() {
    }

    public Long getUselessPKDontUse() {
        return uselessPK;
    }

    public RecipientEntity getGroup() {
        return group;
    }

    public RecipientEntity getRecipient() {
        return recipient;
    }
}
