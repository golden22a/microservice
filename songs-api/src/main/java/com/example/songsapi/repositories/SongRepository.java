package com.example.songsapi.repositories;

import com.example.songsapi.models.Song;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.persistence.Table;
import java.util.List;
public interface SongRepository extends CrudRepository<Song, Long> {

}