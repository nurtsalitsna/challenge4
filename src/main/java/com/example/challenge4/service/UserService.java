package com.example.challenge4.service;

import com.example.challenge4.exception.ResourceNotFoundException;
import com.example.challenge4.model.Schedule;
import com.example.challenge4.model.UserFilm;
import com.example.challenge4.repository.ScheduleRepository;
import com.example.challenge4.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService {
    @Autowired
    static
    UserRepository userRepository;

    public static UserFilm addUserFilm(UserFilm userFilms){
        return userRepository.save(userFilms);
    }
    public static List<UserFilm> getAllUserFilm(){
        return userRepository.findAll();
    }
    public UserFilm getUserFilmById(Integer id){
        return userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Film Not Found"+id));
    }
    public static UserFilm updateUserFilm(Integer id, UserFilm userFilm){
        UserFilm userFilm1 = userRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Film Not Found by id "+id));
        userFilm1.setUsername(userFilm1.getUsername());
        userFilm1.setPassword(userFilm1.getPassword());
        return userRepository.save(userFilm1);
    }
    public void deleteUserFilm(Integer id){
        userRepository.deleteById(id);
    }
}
