package io.braxton.braxtify.controllers;

import io.braxton.braxtify.models.Artist;
import io.braxton.braxtify.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @Autowired
    ArtistRepository artistRepo;

    @RequestMapping("/")
    public String index (Model model) {
        Iterable<Artist> artist = artistRepo.findAll();
        model.addAttribute("artist", artist);
        return "index";
    }
}
