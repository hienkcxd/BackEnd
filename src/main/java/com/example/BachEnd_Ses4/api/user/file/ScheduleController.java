package com.example.BachEnd_Ses4.api.user.file;

import com.example.BachEnd_Ses4.model.File.FileSchedule;
import com.example.BachEnd_Ses4.service.file.FileScheduleService;
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
@RequestMapping("/api/user/schedule")
@RequiredArgsConstructor
@Slf4j
@PreAuthorize("hasAnyAuthority('ROLE_USER')")
public class ScheduleController {

    @Autowired
    private FileScheduleService fileScheduleService;

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
    public List<FileSchedule> findByUsername(){
        return fileScheduleService.findbyUsername(getPrincipal());
    }
    @GetMapping("/{id}")
    public FileSchedule findByUsername(@PathVariable String id){
        FileSchedule fileScheduleDb = fileScheduleService.detail(Long.valueOf(id));
        if(getPrincipal().equals(fileScheduleDb.getUserName())){
            return fileScheduleDb;
        }else {
            return (FileSchedule) ResponseEntity.badRequest();
        }
    }

    @PostMapping("")
    public void addSchedule(@RequestBody FileSchedule fileSchedule){
        fileScheduleService.addSchedule(fileSchedule);
    }

    @PutMapping("")
    public void updateSchedule(@RequestBody FileSchedule fileSchedule){
        FileSchedule fileScheduleDb = fileScheduleService.detail(fileSchedule.getId());
        if(getPrincipal().equals(fileScheduleDb.getUserName())){
            fileScheduleService.update(fileSchedule);
        }else {
            ResponseEntity.badRequest();
        }
    }

    @DeleteMapping("/{id}")
    public void deleteSchedule(@PathVariable String id){
        FileSchedule fileScheduleDb = fileScheduleService.detail(Long.valueOf(id));
        if(getPrincipal().equals(fileScheduleDb.getUserName())){
            fileScheduleService.delete(Long.valueOf(id));
        }else {
            ResponseEntity.badRequest();
        }
    }
}
