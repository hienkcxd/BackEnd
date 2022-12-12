package com.example.BachEnd_Ses4.converter.MapConverter;

import com.example.BachEnd_Ses4.DTO.MapDTO.FileInPlayListDTO;
import com.example.BachEnd_Ses4.model.MapData.FileInPlayList;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class FileInPlayListConverter {

    public FileInPlayListDTO entityToDTO(FileInPlayList fileInPlayList){
        FileInPlayListDTO dto = new FileInPlayListDTO();
        String[] arr = null;
        arr=fileInPlayList.getFileName().substring(1, fileInPlayList.getFileName().length()-1).split(", ");
        dto.setId(fileInPlayList.getId());
        dto.setUsername(fileInPlayList.getUsername());
        dto.setPlayListName(fileInPlayList.getPlayListName());
        dto.setFileName(arr);
        return dto;
    }

    public List<FileInPlayListDTO> ListEntityToDTO(List<FileInPlayList> ent){
        return ent.stream().map(x ->entityToDTO(x)).collect(Collectors.toList());
    }

    public FileInPlayList dtoToEntity(FileInPlayListDTO dto){
        FileInPlayList ent = new FileInPlayList();
        String filename = new String();
        filename = Arrays.toString(dto.getFileName());
        ent.setId(dto.getId());
        ent.setUsername(dto.getUsername());
        ent.setPlayListName(dto.getPlayListName());
        ent.setFileName(filename);
        return ent;
    }

    public List<FileInPlayList> ListDtoToEntity(List<FileInPlayListDTO> dto){
        return dto.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
    }
}
