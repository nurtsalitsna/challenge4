package com.example.challenge4.controller;

import com.example.challenge4.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.example.challenge4.model.films;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/challenge4/"})
public class FilmController {

    @Autowired
    FilmService filmService;

    public FilmController(){
    }

    @GetMapping({"/"})
    public ResponseEntity<String> index(){return ResponseEntity.ok("challenge 4");}

    @PostMapping({"/addFilm"})
    public ResponseEntity<films> addFilms(@RequestBody films film){
        films films1 = filmService.addFilm(film);
        return new ResponseEntity<films>(films1, HttpStatus.CREATED);
    }
    //READ
    @GetMapping("/getFilm")
    public ResponseEntity<List<films>> getFilm(){
        List<films> film = FilmService.getAllFilm();
        return ResponseEntity.ok(film);
    }

    @GetMapping("/getFilmById")
    public ResponseEntity<films> getFilmById(@RequestParam(name ="filmId")Integer id){
        films film = filmService.getFilmById(id);
        return ResponseEntity.ok(film);
    }
    //update
    @PutMapping("/updateFilm")
    public ResponseEntity<String> updateFilm(@RequestParam(name = "filmId") Integer id, @RequestBody films Film){
        filmService.updateFilm(id, Film);
        return ResponseEntity.ok("Data berhasil di update");
    }

    //Delete
    @DeleteMapping("/deleteFilm")
    public ResponseEntity<String> deleteFilm(@RequestParam(name = "filmId")Integer id){
        filmService.deleteFilm(id);
        return ResponseEntity.ok("Data berhasil di hapus");
    }


}
