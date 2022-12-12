package com.example.BachEnd_Ses4.service.map;

import com.example.BachEnd_Ses4.model.MapData.PlayListInSchedule;
import com.example.BachEnd_Ses4.repositories.map.PlayListInScheduleRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PlayListInScheduleServiceImpl implements PlayListInScheduleService{
    @Autowired
    private PlayListInScheduleRepo playListInScheduleRepo;
    @Override
    public List<PlayListInSchedule> findAll() {
        return playListInScheduleRepo.findAll();
    }

    @Override
    public List<PlayListInSchedule> findByUsername(String username) {
        return playListInScheduleRepo.findByUsername(username);
    }

    @Override
    public List<PlayListInSchedule> findByScheduleName(String scheduleName) {
        return playListInScheduleRepo.findByScheduleName(scheduleName);
    }

    @Override
    public void addPlayListInSchedule(PlayListInSchedule playListInSchedule) {
        playListInScheduleRepo.save(playListInSchedule);
    }

    @Override
    public PlayListInSchedule detail(Long id) {
        return playListInScheduleRepo.findById(id).get();
    }
}
