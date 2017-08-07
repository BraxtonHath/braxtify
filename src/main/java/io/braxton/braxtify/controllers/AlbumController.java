package io.braxton.braxtify.controllers;

import io.braxton.braxtify.models.Album;
import io.braxton.braxtify.models.Artist;
import io.braxton.braxtify.repository.AlbumRepository;
import io.braxton.braxtify.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Controller
public class AlbumController {

    @Autowired
    ArtistRepository artistRepo;

    @Autowired
    AlbumRepository albumRepo;


    @RequestMapping(value = "/album", method = RequestMethod.GET)
    public String albums(Model model) {
        Iterable<Album> albums = albumRepo.findAll();
        model.addAttribute("albums", albums);
        return "album";
    }

    @RequestMapping(value = "/album", method = RequestMethod.POST)
    public String Search(@RequestParam("searchAlbum") String searchAlbum,
                         Model model) {
        List<Album> albums = albumRepo.AlbumName(searchAlbum);
        model.addAttribute("albums", albums);
        return "album";
    }

    @RequestMapping(value = "/album/add", method = RequestMethod.GET)
    public String addAlbum(Model model) {
        Iterable<Artist> artists = artistRepo.findAll();
        model.addAttribute("artists", artists);
        return "addAlbum";
    }

    @RequestMapping(value = "/album/add", method = RequestMethod.POST)
    public String addAlbumPost(@RequestParam("artist") long artistId,
                                @RequestParam("albumName") String albumName,
                                @RequestParam("yearReleased") java.sql.Date yearReleased) {
        Artist artist = artistRepo.findOne(artistId);
        Album newAlbum = new Album();
        newAlbum.setArtist(artist);
        newAlbum.setAlbumName(albumName);
        newAlbum.setYearReleased(yearReleased);
        albumRepo.save(newAlbum);
        return "redirect:/album";

    }

    @RequestMapping(value = "/album/edit/{albumId}", method = RequestMethod.GET)
    public String editAlbum (@PathVariable("albumId") long albumId,
                              Model model) {
        Album album = albumRepo.findOne(albumId);
        model.addAttribute("album", album);
        return "editAlbum";
    }

    @RequestMapping(value = "/album/edit/{albumId}", method = RequestMethod.POST)
    public String editAlbumPost (@PathVariable("albumId") long albumId,
                                  @RequestParam("albumName") String albumName,
                                  @RequestParam("yearReleased") java.sql.Date yearReleased,
                                  Model model) {
        Album album = albumRepo.findOne(albumId);
        album.setAlbumName(albumName);
        album.setYearReleased(yearReleased);
        albumRepo.save(album);
        return "redirect:/album";
    }
}
