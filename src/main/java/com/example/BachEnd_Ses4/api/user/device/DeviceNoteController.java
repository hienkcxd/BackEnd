package com.example.BachEnd_Ses4.api.user.device;

import com.example.BachEnd_Ses4.service.device.DeviceNoteService;
import com.example.BachEnd_Ses4.service.device.DeviceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user/device-note")
@RequiredArgsConstructor
@Slf4j
@PreAuthorize("hasAnyAuthority('ROLE_USER')")
public class DeviceNoteController {
    @Autowired
    private DeviceNoteService deviceNoteService;
    @Autowired
    private DeviceService deviceService;

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

}
