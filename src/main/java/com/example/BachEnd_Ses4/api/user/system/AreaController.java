package com.example.BachEnd_Ses4.api.user.system;

import com.example.BachEnd_Ses4.model.System.Area;
import com.example.BachEnd_Ses4.service.system.AreaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user/area")
@RequiredArgsConstructor
@Slf4j
@PreAuthorize("hasAnyAuthority('ROLE_USER')")
public class AreaController {
    @Autowired
    private AreaService areaService;

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
    public List<Area> listArea(){
        return areaService.areaByUsername(getPrincipal());
    }

    @PostMapping("")
    public Area addArea(@RequestBody Area area){
        areaService.addArea(area);
        return area;
    }
}
