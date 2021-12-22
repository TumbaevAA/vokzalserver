package com.example.vokzalserver.entities;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "item")
public class ItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "channel_id", nullable = false)
    private ChannelEntity channel;

    @ManyToOne(optional = false)
    @JoinColumn(name = "content_id", nullable = false)
    private ContentEntity content;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "item_recipient",
            joinColumns = @JoinColumn(name = "item_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "recipient_id", nullable = false))
    private List<RecipientEntity> recipients;

    @Column(name = "date_time_playback", nullable = false)
    private LocalDateTime dateTimePlayback;

    @Column(name = "status", nullable = false)
    private int status;


    public ItemEntity() {
    }

    public Long getId() {
        return id;
    }

    public ChannelEntity getChannel() {
        return channel;
    }

    public ContentEntity getContent() {
        return content;
    }

    public List<RecipientEntity> getRecipients() {
        return recipients;
    }

    public GroupEntity getGroup(){
        if(this.getRecipients().size() == 1){
            return null;
        }
        else{
//TODO Алгоритм, который будет брать группы всех получателей и среди них искать одинаковую для всех
            return this.getRecipients().get(0).getGroupsThatRecipientBelongsTo().get(0);
        }
    }

    public LocalDateTime getDateTimePlayback() {
        return dateTimePlayback;
    }

    public int getStatus() {
        return status;
    }

}
