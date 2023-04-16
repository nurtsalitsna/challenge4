package com.example.challenge4.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.challenge4.model.films;

public interface FilmRepository extends JpaRepository<films, Integer> {
}
