package com.example.BachEnd_Ses4.api.admin.system;

import com.example.BachEnd_Ses4.model.System.UserLog;
import com.example.BachEnd_Ses4.service.system.UserLogService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/user-log")
@RequiredArgsConstructor
@Slf4j
//@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
public class AdminUserLogController {
    @Autowired
    private UserLogService userLogService;

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
    public ResponseEntity<List<UserLog>> userLogList(){
        return ResponseEntity.ok(userLogService.listUserLogByUsername(getPrincipal()));
    }

    @PostMapping("")
    public void addUserLog(@RequestBody UserLog userLog){
        userLogService.addUserLog(userLog);
    }


}
