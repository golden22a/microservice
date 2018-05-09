package com.example.songsapi.controllers;

import com.example.songsapi.models.Songs;
import com.example.songsapi.repositories.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class SongsController {
    @Autowired
    private SongRepository songRepository;
    @GetMapping("/")
    public Iterable<Songs> findAllSongs() {
        return songRepository.findAll();
    }
    @GetMapping("/{songsId}")
    public Songs findSongById(@PathVariable Long songId) {
        return songRepository.findOne(songId);
    }
    @DeleteMapping("/{songId}")
    public HttpStatus deleteUserById(@PathVariable Long songId) {
        songRepository.delete(songId);
        return HttpStatus.OK;
    }
    @PostMapping("/")
    public Songs createNewUser(@RequestBody Songs newSongs) {
        return songRepository.save(newSongs);
    }
    @PatchMapping("/{songId}")
    public Songs updateUserById(@PathVariable Long songId, @RequestBody Songs songsRequest) {

        Songs songsFromDb = songRepository.findOne(songId);
        songsFromDb.setTitle(songsRequest.getTitle());
        songsFromDb.setLength(songsRequest.getLength());
        return songRepository.save(songsFromDb);
    }
    @GetMapping("/search/{title}")
    public Iterable<Songs> findByTitle(@PathVariable String title){
        return songRepository.findSongsBytitle(title);

    }

}