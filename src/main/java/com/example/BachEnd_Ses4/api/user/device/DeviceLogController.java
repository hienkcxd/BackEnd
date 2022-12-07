package com.example.BachEnd_Ses4.api.user.device;

import com.example.BachEnd_Ses4.model.Device.Device;
import com.example.BachEnd_Ses4.model.Device.DeviceLog;
import com.example.BachEnd_Ses4.service.device.DeviceLogService;
import com.example.BachEnd_Ses4.service.device.DeviceService;
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
@RequestMapping("/api/user/device-log")
@RequiredArgsConstructor
@Slf4j
@CrossOrigin("http://localhost:4200")
@PreAuthorize("hasAnyAuthority('ROLE_USER')")
public class DeviceLogController {
    @Autowired
    private DeviceLogService deviceLogService;

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

    @GetMapping("")
    public List<DeviceLog> findByUsername(){
        return deviceLogService.findByUsername(getPrincipal());
    }

    @GetMapping("/{deviceName}")
    public List<DeviceLog> findByDeviceName(@PathVariable String deviceName){
        Device deviceDB = deviceService.detailByDeviceName(deviceName);
        if(getPrincipal().equals(deviceDB.getUsername())){
            return deviceLogService.findByDeviceName(deviceName);
        }else {
            return null;
        }
    }

    @GetMapping("/start={startTime}&end={endTime} ")
    public List<DeviceLog> findByDeviceName(@PathVariable String startTime, @PathVariable String endTime){
        //chuaw hoan thien
            return deviceLogService.findByTime(Long.valueOf(startTime), Long.valueOf(endTime));
    }

    @PostMapping("")
    public void addDeviceLog(@RequestBody DeviceLog deviceLog){
        deviceLogService.addDeviceLog(deviceLog);
    }


}
