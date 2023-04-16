package com.example.challenge4.controller;

import com.example.challenge4.model.UserFilm;
import com.example.challenge4.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/challenge4/"})
public class UserController {
    @Autowired
    UserService userService;

    public UserController(){
    }

    @GetMapping({"/"})
    public ResponseEntity<String> index(){return ResponseEntity.ok("challenge 4");}

    @PostMapping({"/addUser"})
    public ResponseEntity<UserFilm> addUserFilm(@RequestBody UserFilm userFilm){
        UserFilm userFilm1 = UserService.addUserFilm(userFilm);
        return new ResponseEntity<UserFilm>(userFilm1, HttpStatus.CREATED);
    }
    //READ
    @GetMapping("/getUserFilm")
    public ResponseEntity<List<UserFilm>> getAllUserFilm(){
        List<UserFilm> userFilms = userService.getAllUserFilm();
        return ResponseEntity.ok(userFilms);
    }

    @GetMapping("/getUserFilmById")
    public ResponseEntity<UserFilm> getUserFilmById(@RequestParam(name ="userId")Integer id){
        UserFilm userFilm = userService.getUserFilmById(id);
        return ResponseEntity.ok(userFilm);
    }
    //update
    @PutMapping("/updateUserFilm")
    public ResponseEntity<String> updateUserFilm(@RequestParam(name = "userId") Integer id, @RequestBody UserFilm userFilm){
        UserService.updateUserFilm(id, userFilm);
        return ResponseEntity.ok("Data berhasil di update");
    }

    //Delete
    @DeleteMapping("/deleteUserFilm")
    public ResponseEntity<String> deleteUserFilm(@RequestParam(name = "userId")Integer id){
        userService.deleteUserFilm(id);
        return ResponseEntity.ok("Data berhasil di hapus");
    }

}