package io.braxton.braxtify.models;

import javax.persistence.*;
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
    private int yearReleased;

    @ManyToOne
    @JoinColumn(name = "artist_id")
    private Artist artist;

    @OneToMany(mappedBy = "album", cascade = CascadeType.ALL)
    private List<Song> songs;


    public Album() {
    }

    public Album(String albumName, int yearReleased, Artist artist, List<Song> songs) {
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

    public void setName(String name) {
        this.albumName = albumName;
    }

    public int getYearReleased() {
        return yearReleased;
    }

    public void setYearReleased(int yearReleased) {
        this.yearReleased = yearReleased;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }
}