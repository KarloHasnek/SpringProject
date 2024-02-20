package hr.unizd.web.springboot.artists.service;

import hr.unizd.web.springboot.artists.dto.ArtistCreateForm;
import hr.unizd.web.springboot.artists.dto.ArtistEditForm;
import hr.unizd.web.springboot.artists.exception.EntityNotFoundException;
import hr.unizd.web.springboot.artists.model.Artist;
import hr.unizd.web.springboot.artists.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArtistServiceImpl implements ArtistService {

    private final ArtistRepository artistRepository;

    @Autowired
    public ArtistServiceImpl(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    public List<Artist> fetchAll() {
        return artistRepository.fetchAll();
    }

    public Artist fetchDetails(Integer id) {
        Optional<Artist> artistOptional = artistRepository.fetchDetails(id);
        if (artistOptional.isEmpty()) {
            throw new EntityNotFoundException("Entity with id " + id + " not found!");
        }

        return artistOptional.get();
    }

    public List<Artist> create(ArtistCreateForm artistCreateForm) {
        List<Artist> artistList = artistRepository.fetchAll();

        Artist artist = new Artist();
        artist.setId(artistList.size() + 1);
        artist.setName(artistCreateForm.getName());
        artist.setAlbum(artistCreateForm.getAlbum());

        artistRepository.create(artist);

        return artistRepository.fetchAll();
    }

    public List<Artist> edit(ArtistEditForm artistEditForm) {
        Artist artist = fetchDetails(artistEditForm.getId());
        artist.setName(artistEditForm.getName());
        artist.setAlbum(artistEditForm.getAlbum());

        artistRepository.edit(artist);

        return artistRepository.fetchAll();
    }

    public List<Artist> delete(Integer id) {
        artistRepository.delete(id);
        return artistRepository.fetchAll();
    }
}
