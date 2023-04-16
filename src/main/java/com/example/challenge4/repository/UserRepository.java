package com.example.challenge4.repository;

import com.example.challenge4.model.UserFilm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserFilm, Integer> {
}
