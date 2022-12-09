package com.example.BachEnd_Ses4.api.user.map;

import com.example.BachEnd_Ses4.DTO.MapDTO.FileInPlayListDTO;
import com.example.BachEnd_Ses4.converter.MapConverter.FileInPlayListConverter;
import com.example.BachEnd_Ses4.model.MapData.FileInPlayList;
import com.example.BachEnd_Ses4.service.map.FileInPlayListService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user/file-playlist")
@Slf4j
public class FileInPlayListController {
    @Autowired
    private FileInPlayListService fileInPlayListService;

    @Autowired
    private FileInPlayListConverter converter;

    @GetMapping("")
    public List<FileInPlayListDTO> findAll(){
        List<FileInPlayList> list = fileInPlayListService.findAll();
        return converter.ListEntityToDTO(list);
    }

    @GetMapping("/{idList}")
    public FileInPlayListDTO findById(@PathVariable String idList){
        FileInPlayList ent = fileInPlayListService.detail(Long.valueOf(idList));
        return converter.entityToDTO(ent);
    }

    @PostMapping("")
    public FileInPlayListDTO savePlayList(@RequestBody FileInPlayListDTO dto){
        FileInPlayList ent = converter.dtoToEntity(dto);
        fileInPlayListService.addFileInPlaylist(ent);
        log.info(String.valueOf(dto.getFileName()));
        return dto;
    }
}
