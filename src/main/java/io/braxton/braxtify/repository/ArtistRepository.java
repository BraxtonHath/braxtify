package io.braxton.braxtify.repository;

import io.braxton.braxtify.models.Artist;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArtistRepository extends CrudRepository<Artist, Long> {
    List<Artist> ArtistName(String artistName);
}
