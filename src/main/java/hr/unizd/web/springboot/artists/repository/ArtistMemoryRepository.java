package hr.unizd.web.springboot.artists.repository;

import hr.unizd.web.springboot.artists.model.Artist;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ArtistMemoryRepository implements ArtistRepository {

    private List<Artist> artistList = new ArrayList<>(
            List.of(
                    new Artist(1, "2Pac", "All Eyez On Me", "2pac.jpg"),
                    new Artist(2, "50 Cent", "Get Rich Or Die Tryin'", "50cent.jpg"),
                    new Artist(3, "Dr. Dre", "2001", "DrDre-2001.jpg"),
                    new Artist(4, "Snoop Dogg", "Doggystyle", "SnoopDoggyDoggDoggystyle.jpg")
            )
    );

    public List<Artist> fetchAll() {
        return artistList;
    }

    public Optional<Artist> fetchDetails(Integer id) {
        return artistList.stream()
                .filter(artist -> artist.getId().equals(id))
                .findFirst();
    }

    public boolean create(Artist artist) {
        return artistList.add(artist);
    }

    public void edit(Artist newArtist) {
        int listIndex = fetchObjectListIndex(newArtist.getId());
        artistList.set(listIndex, newArtist);
    }

    public void delete(Integer id) {
        int listIndex = fetchObjectListIndex(id);
        artistList.remove(listIndex);
    }

    private Integer fetchObjectListIndex(Integer id) {
        int index = -1;

        for (int i = 0; i < artistList.size(); i++) {
            if (artistList.get(i).getId().equals(id)) {
                index = i;
                break;
            }
        }

        return index;
    }
}
