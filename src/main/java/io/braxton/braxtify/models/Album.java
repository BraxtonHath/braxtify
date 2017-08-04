package io.braxton.braxtify.models;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "album")
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "albumname")
    private String albumName;
    @Column(name = "yearreleased")
    private java.sql.Date yearReleased;

    @ManyToOne
    @JoinColumn(name = "artist_id")
    private Artist artist;

    @OneToMany(mappedBy = "album", cascade = CascadeType.ALL)
    private List<Song> songs;


    public Album() {
    }

    public Album(String albumName, java.sql.Date yearReleased, Artist artist, List<Song> songs) {
        this.albumName = albumName;
        this.yearReleased = yearReleased;
        this.artist = artist;
        this.songs = songs;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public Date getYearReleased() {
        return yearReleased;
    }

    public void setYearReleased(java.sql.Date yearReleased) {
        this.yearReleased = yearReleased;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }
}