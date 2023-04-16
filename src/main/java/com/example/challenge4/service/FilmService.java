package com.example.challenge4.service;

import com.example.challenge4.exception.ResourceNotFoundException;
import com.example.challenge4.model.films;
import com.example.challenge4.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmService {
    @Autowired
    static
    FilmRepository filmRepository;

    public films addFilm(films film){
        return filmRepository.save(film);
    }
    public static List<films> getAllFilm(){
        return filmRepository.findAll();
    }
    public films getFilmById(Integer id){
       return filmRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Film Not Found"+id));
    }
    public films updateFilm(Integer id, films film){
        films film1 = filmRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Film Not Found by id "+id));
        film1.setFilmId(film1.getFilmId());
        film1.setFilmName(film1.getFilmName());
        film1.setStatusFilm(film1.getStatusFilm());
        return filmRepository.save(film1);
    }
    public void deleteFilm(Integer id){
        filmRepository.deleteById(id);
    }

}
