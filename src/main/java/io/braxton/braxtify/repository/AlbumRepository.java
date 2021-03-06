package io.braxton.braxtify.repository;


import io.braxton.braxtify.models.Album;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlbumRepository extends CrudRepository<Album, Long> {
    List<Album> AlbumName(String albumName);

}
