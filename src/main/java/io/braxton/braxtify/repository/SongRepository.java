package io.braxton.braxtify.repository;

import io.braxton.braxtify.models.Song;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepository extends CrudRepository<Song, Long>{
}
