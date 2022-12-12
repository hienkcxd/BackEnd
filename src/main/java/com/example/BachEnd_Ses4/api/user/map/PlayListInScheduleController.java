package com.example.BachEnd_Ses4.api.user.map;

import com.example.BachEnd_Ses4.DTO.MapDTO.PlayListInScheduleDTO;
import com.example.BachEnd_Ses4.converter.MapConverter.PlayListInScheduleDTOConverter;
import com.example.BachEnd_Ses4.model.MapData.PlayListInSchedule;
import com.example.BachEnd_Ses4.service.map.PlayListInScheduleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user/playlist-in-schedule")
@Slf4j
public class PlayListInScheduleController {
    @Autowired
    private PlayListInScheduleService playListInScheduleService;
    @Autowired
    private PlayListInScheduleDTOConverter converter;
    private String getPrincipal(){
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            userName = ((UserDetails)principal).getUsername();
        } else {
            userName = principal.toString();
        }

        return userName;
    }
    @GetMapping("")
    public List<PlayListInScheduleDTO> findByUsername(){
        List<PlayListInSchedule> list = playListInScheduleService.findByUsername(getPrincipal());
        return converter.listEntityToDTO(list);
    }
    @GetMapping("/schedule={scheduleName}")
    public List<PlayListInScheduleDTO> findByUsername(@PathVariable String scheduleName){
        List<PlayListInSchedule> list = playListInScheduleService.findByScheduleName(scheduleName);
        return converter.listEntityToDTO(list);
    }
    @GetMapping("/{scheduleId}")
    public PlayListInScheduleDTO detail(@PathVariable String scheduleId){
        PlayListInSchedule detail = playListInScheduleService.detail(Long.valueOf(scheduleId));
        return converter.entityToDTO(detail);
    }
    @PostMapping
    public PlayListInScheduleDTO saveSchedule(@RequestBody PlayListInScheduleDTO dto){
        PlayListInSchedule ent = converter.dtoToEntity(dto);
        playListInScheduleService.addPlayListInSchedule(ent);
        return dto;
    }
}
