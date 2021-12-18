package com.example.vokzalserver.entities;

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

    /*Если эта связь не null, то контент является плейлистом.
     *Связь нужна, чтобы получать доступ к содержанию плейлиста*/
    @OneToMany(mappedBy = "playlist")
    private List<PlaylistEntity> playlist;

    /*Через эту связь в таблице playlist указывается, какой контент входит в плейлист.
     * То есть, если эта связь не null, то этот контент входит в плейлист(ы) из списка*/
    @OneToMany(mappedBy = "content")
    private List<PlaylistEntity> playlistsThatContentBelongsTo;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "duration")
    private Duration duration;

    @Column(name = "status", nullable = false)
    private int status;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "content")
    List<ItemEntity> items;

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
