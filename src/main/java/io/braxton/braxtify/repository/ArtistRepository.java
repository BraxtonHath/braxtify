package io.braxton.braxtify.repository;

import io.braxton.braxtify.models.Artist;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistRepository extends CrudRepository<Artist, Long> {
}
