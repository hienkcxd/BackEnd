package com.example.BachEnd_Ses4.api.user.file;

import com.example.BachEnd_Ses4.model.File.FileLog;
import com.example.BachEnd_Ses4.service.file.FileLogService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user/file-log")
@RequiredArgsConstructor
@Slf4j
//@PreAuthorize("hasAnyAuthority('ROLE_USER')")
public class FileLogController {
    @Autowired
    private FileLogService fileLogService;
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
    public List<FileLog> findbyUsername(){
        return fileLogService.findByUsername(getPrincipal());
    }

    @PostMapping("")
    public void addFilelog(@RequestBody FileLog fileLog){
        fileLogService.addFileLog(fileLog);
    }
}
