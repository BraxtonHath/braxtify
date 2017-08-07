package io.braxton.braxtify.controllers;

import io.braxton.braxtify.models.Artist;
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

import java.util.List;

@Controller
public class ArtistController {

    @Autowired
    ArtistRepository artistRepo;

    @Autowired
    AlbumRepository albumRepo;

    @Autowired
    SongRepository songRepo;

    @RequestMapping(value = "/artist", method = RequestMethod.GET)
    public String Artist (Model model) {
        Iterable<Artist> artists = artistRepo.findAll();
        model.addAttribute("artists", artists);
        return "artist";
    }

    @RequestMapping(value = "/artist", method = RequestMethod.POST)
    public String Search (@RequestParam("searchArtist") String searchArtist,
                          Model model) {
        List<Artist> artists = artistRepo.ArtistName(searchArtist);
        model.addAttribute("artists", artists);
        return "artist";
    }

    @RequestMapping(value = "/artist/add", method = RequestMethod.GET)
    public String addArtist () {
        return "addArtist";
    }

    @RequestMapping(value = "/artist/add", method = RequestMethod.POST)
    public String addArtistPost (@RequestParam("artistName") String artistName) {
        Artist newArtist = new Artist();
        newArtist.setArtistName(artistName);
        artistRepo.save(newArtist);
        return "redirect:/artist";
    }


    @RequestMapping(value = "/artist/edit/{artistId}", method = RequestMethod.GET)
    public String editArtist (@PathVariable("artistId") long artistId,
                            Model model) {
        Artist artist = artistRepo.findOne(artistId);
        model.addAttribute("artist", artist);
        return "editArtist";
    }

    @RequestMapping(value = "/artist/edit/{artistId}", method = RequestMethod.POST)
    public String editArtistPost (@PathVariable("artistId") long artistId,
                                  @RequestParam("artistName") String artistName,
                                  Model model) {
        Artist artist = artistRepo.findOne(artistId);
        artist.setArtistName(artistName);
        artistRepo.save(artist);
        return "redirect:/artist";
    }
}