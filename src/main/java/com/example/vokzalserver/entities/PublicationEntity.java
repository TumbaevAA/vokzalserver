package com.example.vokzalserver.entities;

import com.example.vokzalserver.models.Date;
import com.example.vokzalserver.models.PublicationPosting;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "publication")
public class PublicationEntity {
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

    @ManyToOne
    @JoinColumn(name = "recipient_id")
    private RecipientEntity recipient;

    @Column(name = "date_time_playback", nullable = false)
    private LocalDateTime dateTimePlayback;

    @Column(name = "status", nullable = false)
    private int status;

    public static PublicationEntity toEntity(ChannelEntity channel, ContentEntity content,
                                             RecipientEntity recipient, PublicationPosting publication){
        PublicationEntity entity = new PublicationEntity();

        entity.channel = channel;
        entity.content = content;
        entity.recipient = recipient;

        Date date = publication.getDate();
        entity.dateTimePlayback = LocalDateTime.parse(date.getYear() + "-" + date.getMonth() + "-" + date.getDay() + "T" + date.getTime());

        entity.status = publication.getStatus();

        return entity;
    }

    public PublicationEntity() {
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

    public RecipientEntity getRecipient() {
        return recipient;
    }

    public LocalDateTime getDateTimePlayback() {
        return dateTimePlayback;
    }

    public int getStatus() {
        return status;
    }

}
