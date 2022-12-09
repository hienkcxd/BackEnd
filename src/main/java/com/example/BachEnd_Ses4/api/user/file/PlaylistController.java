package com.example.BachEnd_Ses4.api.user.file;

import com.example.BachEnd_Ses4.model.File.PlayList;
import com.example.BachEnd_Ses4.service.file.FilePlaylistService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user/playlist")
@RequiredArgsConstructor
@Slf4j
//@PreAuthorize("hasAnyAuthority('ROLE_USER')")
public class PlaylistController {
    @Autowired
    private FilePlaylistService filePlaylistService;

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
    public List<PlayList> findByUsername(){
        return filePlaylistService.findByUsername(getPrincipal());
    }
    @GetMapping("/{id}")
    public PlayList findById(@PathVariable String id){
        PlayList playListDetail = filePlaylistService.detail(Long.valueOf(id));
        if(getPrincipal().equals(playListDetail.getUsername())){
            return playListDetail;
        }else {
            log.info("Playlist controller - line 48: user này không được xem play list này - " + getPrincipal());
            return (PlayList) ResponseEntity.badRequest();
        }
    }

    @PostMapping("")
    public void addPlayList(@RequestBody PlayList playList){
        playList.setUsername(getPrincipal());
        filePlaylistService.addPlaylist(playList);
    }

    @PutMapping("")
    public void updatePlayList(@RequestBody PlayList playList){
        PlayList playListDetail = filePlaylistService.detail(playList.getId());
        if(getPrincipal().equals(playListDetail.getUsername())){
            filePlaylistService.update(playList);
        }else {
            log.info("Playlist controller - line 65: user này không được update play list này - " + getPrincipal());
            ResponseEntity.badRequest();
        }
    }

    @DeleteMapping("/{id}")
    public void deletePlayList(@PathVariable String id){
        PlayList playListDetail = filePlaylistService.detail(Long.valueOf(id));
        if(getPrincipal().equals(playListDetail.getUsername())){
            filePlaylistService.delete(Long.valueOf(id));
        }else {
            log.info("Playlist controller - line 76: user này không được delete play list này - " + getPrincipal());
            ResponseEntity.badRequest();
        }
    }
}
