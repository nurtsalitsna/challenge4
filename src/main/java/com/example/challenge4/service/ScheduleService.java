package com.example.challenge4.service;

import com.example.challenge4.exception.ResourceNotFoundException;
import com.example.challenge4.model.Schedule;
import com.example.challenge4.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ScheduleService {
    @Autowired
    static
    ScheduleRepository scheduleRepository;

    public Schedule addSchedule(Schedule schedule){
        return scheduleRepository.save(schedule);
    }
    public static List<Schedule> getAllSchedule(){
        return scheduleRepository.findAll();
    }
    public Schedule getScheduleById(Integer id){
        return scheduleRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Film Not Found"+id));
    }
    public Schedule updateSchedule(Integer id, Schedule schedule){
        Schedule schedule1 = scheduleRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Film Not Found by id "+id));
        schedule1.setScheduleId(schedule1.getScheduleId());
        schedule1.setTanggalTayang(schedule1.getTanggalTayang());
        schedule1.setJadwalMulai(schedule1.getJadwalMulai());
        schedule1.setJadwalSelesai(schedule1.getJadwalSelesai());
        return scheduleRepository.save(schedule1);
    }
    public void deleteSchedule(Integer id){
        scheduleRepository.deleteById(id);
    }
}
