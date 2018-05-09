package com.example.songsapi.repositories;

import com.example.songsapi.models.Songs;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface SongRepository extends CrudRepository<Songs, Long> {
@Query("SELECT s FROM Songs s WHERE LOWER(s.title) LIKE LOWER(CONCAT('%',:title,'%'))")
Iterable<Songs> findSongsBytitle(@Param("title") String title);

}