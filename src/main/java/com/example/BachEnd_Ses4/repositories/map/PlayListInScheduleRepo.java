package com.example.BachEnd_Ses4.repositories.map;

import com.example.BachEnd_Ses4.model.MapData.PlayListInSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PlayListInScheduleRepo extends JpaRepository<PlayListInSchedule, Long> {
    public List<PlayListInSchedule> findByUsername(String username);
    @Query(value = "select s from PlayListInSchedule s where s.scheduleName=?1")
    public List<PlayListInSchedule> findByScheduleName(String scheduleName);
}
