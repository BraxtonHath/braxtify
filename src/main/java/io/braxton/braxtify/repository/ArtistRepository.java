package io.braxton.braxtify.repository;

import io.braxton.braxtify.models.Artist;
import org.springframework.data.repository.CrudRepository;

public interface ArtistRepository extends CrudRepository<Artist, Long> {
}
