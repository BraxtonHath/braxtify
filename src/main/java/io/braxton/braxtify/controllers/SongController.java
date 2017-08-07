package io.braxton.braxtify.controllers;

import io.braxton.braxtify.models.Album;
import io.braxton.braxtify.models.Artist;
import io.braxton.braxtify.models.Song;
import io.braxton.braxtify.repository.AlbumRepository;
import io.braxton.braxtify.repository.ArtistRepository;
import io.braxton.braxtify.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.util.List;

@Controller
public class SongController {

    @Autowired
    ArtistRepository artistRepo;

    @Autowired
    AlbumRepository albumRepo;

    @Autowired
    SongRepository songRepo;

    @RequestMapping(value = "/song", method = RequestMethod.GET)
    public String songs(Model model) {
        Iterable<Song> songs = songRepo.findAll();
        model.addAttribute("songs", songs);
        return "song";
    }

    @RequestMapping(value = "/songs", method = RequestMethod.POST)
    public String Search(@RequestParam("searchSong") String searchSong,
                         Model model) {
        List<Song> songs = songRepo.SongName(searchSong);
        model.addAttribute("songs", songs);
        return "song";
    }

    @RequestMapping(value = "/song/add", method = RequestMethod.GET)
    public String addSong(Model model) {
        Iterable<Artist> bands = artistRepo.findAll();
        model.addAttribute("bands", bands);

        Iterable<Album> albums = albumRepo.findAll();
        model.addAttribute("albums", albums);

        return "addSong";
    }

    @RequestMapping(value = "/song/add", method = RequestMethod.POST)
    public String addSongsPost(
//            @RequestParam("artist") long artistId,
                               @RequestParam("album") long albumId,
                               @RequestParam("songName") String songName,
                               @RequestParam("featured") String featured,
                               @RequestParam("length") int length,
                               @RequestParam("yearReleasedSong") java.sql.Date yearReleasedSong,
                               @RequestParam("genre") String genre) {
//        Artist artist = artistRepo.findOne(artistId);
        Album album = albumRepo.findOne(albumId);

        Song newSong = new Song();
//        newSong.setArtist(artist);
        newSong.setAlbum(album);
        newSong.setSongName(songName);
        newSong.setFeatured(featured);
        newSong.setLength(length);
        newSong.setYearReleasedSong(yearReleasedSong);
        newSong.setGenre(genre);


        songRepo.save(newSong);

        return "redirect:/song";
    }
}
