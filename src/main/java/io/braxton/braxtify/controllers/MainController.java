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
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @Autowired
    ArtistRepository artistRepo;

    @Autowired
    AlbumRepository albumRepo;

    @Autowired
    SongRepository songRepo;


    @RequestMapping("/")
    public String index (Model model) {
        Iterable<Artist> artists = artistRepo.findAll();
        model.addAttribute("artists", artists);

        Iterable<Album> albums = albumRepo.findAll();
        model.addAttribute("albums", albums);

        Iterable<Song> songs = songRepo.findAll();
        model.addAttribute("songs", songs);

        return "index";
    }
}
