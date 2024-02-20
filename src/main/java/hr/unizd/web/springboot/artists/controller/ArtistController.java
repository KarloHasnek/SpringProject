package hr.unizd.web.springboot.artists.controller;

import hr.unizd.web.springboot.artists.dto.ArtistCreateForm;
import hr.unizd.web.springboot.artists.dto.ArtistEditForm;
import hr.unizd.web.springboot.artists.model.Artist;
import hr.unizd.web.springboot.artists.service.ArtistService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ArtistController {

    private final ArtistService artistService;

    @Autowired
    public ArtistController(ArtistService artistService) {
        this.artistService = artistService;
    }

    @GetMapping("artists")
    public String fetchAll(Model model) {
        model.addAttribute("artistList", artistService.fetchAll());

        return "artistListTemplate";
    }

    @GetMapping("/artists/{id}")
    public String fetchDetails(Model model, @PathVariable Integer id) {
        Artist artist = artistService.fetchDetails(id);
        model.addAttribute("artistDetails", artist);

        return "artistTemplate";
    }

    @GetMapping("artists/create")
    public String fetchCreateForm(Model model) {
        model.addAttribute("artist", new Artist());
        return "artistCreateTemplate";
    }

    @PostMapping("/artists")
    public String create(@ModelAttribute(name = "artist") @Valid ArtistCreateForm artist, BindingResult validationResult) {
        if (validationResult.hasErrors()) {
            return "artistCreateTemplate";
        }

        artistService.create(artist);

        return "redirect:/artists";
    }

    @GetMapping("artists/edit/{id}")
    public String fetchEditForm(Model model, @PathVariable Integer id) {
        Artist artist = artistService.fetchDetails(id);
        model.addAttribute("artist", artist);

        return "artistEditTemplate";
    }

    @PostMapping("/artists/edit")
    public String edit(@ModelAttribute(name="artist") @Valid ArtistEditForm artist, BindingResult validationResult) {
        if (validationResult.hasErrors()) {
            return "artistEditTemplate";
        }

        artistService.edit(artist);

        return "redirect:/artists";
    }

    @GetMapping("/artists/delete/{id}")
    public String delete(@PathVariable Integer id) {
        artistService.delete(id);

        return "redirect:/artists";
    }
}
