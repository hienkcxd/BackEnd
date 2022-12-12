package com.example.BachEnd_Ses4.converter.MapConverter;

import com.example.BachEnd_Ses4.DTO.MapDTO.PlayListInScheduleDTO;
import com.example.BachEnd_Ses4.model.MapData.PlayListInSchedule;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PlayListInScheduleDTOConverter {
    public PlayListInScheduleDTO entityToDTO(PlayListInSchedule playListInSchedule){
        PlayListInScheduleDTO dto = new PlayListInScheduleDTO();
        String[] arr = null;
        arr = playListInSchedule.getPlayListName().substring(1, playListInSchedule.getPlayListName().length()-1).split(", ");
        dto.setId(playListInSchedule.getId());
        dto.setUsername(playListInSchedule.getUsername());
        dto.setScheduleName(playListInSchedule.getScheduleName());
        dto.setPlayListName(arr);
        return dto;
    }

    public List<PlayListInScheduleDTO> listEntityToDTO(List<PlayListInSchedule> ent){
        return ent.stream().map(x ->entityToDTO(x)).collect(Collectors.toList());
    }

    public PlayListInSchedule dtoToEntity(PlayListInScheduleDTO dto){
        PlayListInSchedule ent = new PlayListInSchedule();
        String playListName = new String();
        playListName = Arrays.toString(dto.getPlayListName());
        ent.setId(dto.getId());
        ent.setUsername(dto.getUsername());
        ent.setScheduleName(dto.getScheduleName());
        ent.setPlayListName(playListName);
        return ent;
    }

    public List<PlayListInSchedule> dtoToEntity(List<PlayListInScheduleDTO> dto){
        return dto.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
    }
}
