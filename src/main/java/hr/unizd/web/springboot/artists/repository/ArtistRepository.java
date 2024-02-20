package hr.unizd.web.springboot.artists.repository;

import hr.unizd.web.springboot.artists.model.Artist;

import java.util.List;
import java.util.Optional;

public interface ArtistRepository {
    List<Artist> fetchAll();

    Optional<Artist> fetchDetails(Integer id);

    boolean create(Artist artist);

    void edit(Artist artist);

    void delete(Integer id);

}
