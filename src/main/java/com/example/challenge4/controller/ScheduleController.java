package com.example.challenge4.controller;

import com.example.challenge4.model.Schedule;
import com.example.challenge4.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping({"/challenge4/"})
public class ScheduleController {
    @Autowired
    ScheduleService scheduleService;

    public ScheduleController(){
    }

    @GetMapping({"/"})
    public ResponseEntity<String> index(){return ResponseEntity.ok("challenge 4");}

    @PostMapping({"/addSchedule"})
    public ResponseEntity<Schedule> addSchedule(@RequestBody Schedule schedule){
        Schedule schedule1 = scheduleService.addSchedule(schedule);
        return new ResponseEntity<Schedule>(schedule1, HttpStatus.CREATED);
    }
    //READ
    @GetMapping("/getSchedule")
    public ResponseEntity<List<Schedule>> getSchedule(){
        List<Schedule> schedules = ScheduleService.getAllSchedule();
        return ResponseEntity.ok(schedules);
    }

    @GetMapping("/getScheduleById")
    public ResponseEntity<Schedule> getScheduleById(@RequestParam(name ="scheduleId")Integer id){
        Schedule schedule = scheduleService.getScheduleById(id);
        return ResponseEntity.ok(schedule);
    }
    //update
    @PutMapping("/updateSchedule")
    public ResponseEntity<String> updateSchedule(@RequestParam(name = "scheduleId") Integer id, @RequestBody Schedule schedule){
        scheduleService.updateSchedule(id, schedule);
        return ResponseEntity.ok("Data berhasil di update");
    }

    //Delete
    @DeleteMapping("/deleteSchedule")
    public ResponseEntity<String> deleteSchedule(@RequestParam(name = "scheduleId")Integer id){
        scheduleService.deleteSchedule(id);
        return ResponseEntity.ok("Data berhasil di hapus");
    }

}
