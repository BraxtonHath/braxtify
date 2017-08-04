package io.braxton.braxtify.models;

import javax.persistence.*;

@Entity
@Table(name = "song")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "songname")
    private String songName;
    private String featured;
    private int length;
    @Column(name = "yearreleasedsong")
    private int yearReleasedSong;
    private String genre;

    @ManyToOne
    @JoinColumn(name = "artist_id")
    private Artist artist;

    @ManyToOne
    @JoinColumn(name = "album_id")
    private Album album;

    public Song() {
    }

    public Song(String songName, String featured, int length, int yearReleasedSong, String genre, Artist artist, Album album) {
        this.songName = songName;
        this.featured = featured;
        this.length = length;
        this.yearReleasedSong = yearReleasedSong;
        this.genre = genre;
        this.artist = artist;
        this.album = album;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getFeatured() {
        return featured;
    }

    public void setFeatured(String featured) {
        this.featured = featured;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getYearReleasedSong() {
        return yearReleasedSong;
    }

    public void setYearReleasedSong(int yearReleasedSong) {
        this.yearReleasedSong = yearReleasedSong;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }
}