package com.example.BachEnd_Ses4.service.map;

import com.example.BachEnd_Ses4.model.MapData.PlayListInSchedule;

import java.util.List;

public interface PlayListInScheduleService {
    public List<PlayListInSchedule> findAll();
    public List<PlayListInSchedule> findByUsername(String username);
    public List<PlayListInSchedule> findByScheduleName(String scheduleName);
    public void addPlayListInSchedule(PlayListInSchedule playListInSchedule);
    public PlayListInSchedule detail(Long id);
}
