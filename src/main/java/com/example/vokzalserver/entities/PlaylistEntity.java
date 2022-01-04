package com.example.vokzalserver.entities;

import javax.persistence.*;

/*Плейлист является контентом. Эта табличка нужна, только чтобы показать, какой контент
 * в какой плейлист входит и указать порядковый номер контента в плейлисте
 * */
@Entity
@Table(name = "playlist")
public class PlaylistEntity {
/*Первичный ключ не нужен, потому что плейлист является контентом.
 * id контента, с которым связан данный плейлист, и есть id плейлиста*/
    @Id
    @Column(name = "useless_pk", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uselessPK;

/*playlist_id это id контента, который является плейлистом*/
    @ManyToOne
    @JoinColumn(name = "playlist_id")
    private ContentEntity playlist;

/*content_id это id контента, который входит в данный плейлист*/
    @ManyToOne
    @JoinColumn(name = "content_id")
    private ContentEntity content;

/*Номер контента в плейлисте*/
    @Column(name = "serial_number")
    private int contentSerialNumber;


    public PlaylistEntity() {
    }

    public Long getUselessPKDontUse() {
        return uselessPK;
    }

    public ContentEntity getPlaylist() {
        return playlist;
    }

    public ContentEntity getContent() {
        return content;
    }

    public int getContentSerialNumber() {
        return contentSerialNumber;
    }
}
