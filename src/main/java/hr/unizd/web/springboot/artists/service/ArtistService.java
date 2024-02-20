package hr.unizd.web.springboot.artists.service;

import hr.unizd.web.springboot.artists.dto.ArtistCreateForm;
import hr.unizd.web.springboot.artists.dto.ArtistEditForm;
import hr.unizd.web.springboot.artists.model.Artist;

import java.util.List;

public interface ArtistService {

    List<Artist> fetchAll();

    Artist fetchDetails(Integer id);

    List<Artist> create(ArtistCreateForm artistCreateForm);

    List<Artist> edit(ArtistEditForm artistEditForm);

    List<Artist> delete(Integer id);
}
