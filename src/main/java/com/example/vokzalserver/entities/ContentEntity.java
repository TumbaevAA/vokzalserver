package com.example.vokzalserver.entities;

import com.example.vokzalserver.models.ContentPosting;

import javax.persistence.*;
import java.time.Duration;
import java.util.List;

@Entity
@Table(name = "content")
public class ContentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "content", nullable = false)
    private String content;                    //содержание контента, либо описание плейлиста

    @Column(name = "duration")
    private Duration duration;

    @Column(name = "status", nullable = false)
    private int status;

    /*Если эта связь не null, то контент является плейлистом.
     *Связь нужна, чтобы получать доступ к содержанию плейлиста*/
    @OneToMany(mappedBy = "playlist")
    private List<PlaylistEntity> playlist;

    /*Через эту связь в таблице playlist указывается, какой контент входит в плейлист.
     * То есть, если эта связь не null, то этот контент входит в плейлист(ы) из списка*/
    @OneToMany(mappedBy = "content")
    private List<PlaylistEntity> playlistsThatContentBelongsTo;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "content")
    List<ItemEntity> items;


    public static ContentEntity toEntity(ContentPosting model){
        ContentEntity entity = new ContentEntity();

        if (model.getId() != null) entity.id = model.getId();
        entity.name = model.getName();
        entity.type = model.getType();
        entity.content = model.getContent();
        entity.status = model.getStatus();
        entity.duration = model.getDuration();

        return entity;
}




    public ContentEntity() {
    }

    public Long getId() {
        return id;
    }

    public List<PlaylistEntity> getPlaylist() {
        return playlist;
    }

    public List<PlaylistEntity> getPlaylistsThatContentBelongsTo() {
        return playlistsThatContentBelongsTo;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getContent() {
        return content;
    }

    public Duration getDuration() {
        return duration;
    }

    public int getStatus() {
        return status;
    }

    public List<ItemEntity> getItems() {
        return items;
    }
}
