package com.example.BachEnd_Ses4.api.user.device;

import com.example.BachEnd_Ses4.DTO.Device.DeviceDTO;
import com.example.BachEnd_Ses4.converter.Device.DeviceDTOConverter;
import com.example.BachEnd_Ses4.model.Device.Device;
import com.example.BachEnd_Ses4.model.File.FileStorage;
import com.example.BachEnd_Ses4.service.device.DeviceService;
import com.example.BachEnd_Ses4.service.file.FileStorageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Path;
import java.util.List;

@RestController
@RequestMapping("/api/user/device")
@RequiredArgsConstructor
@Slf4j
@CrossOrigin("http://localhost:4200")
//@PreAuthorize("hasAnyAuthority('ROLE_USER')")
public class DeviceController {
    @Autowired
    private DeviceService deviceService;

    @Autowired
    private FileStorageService fileStorageService;

    @Autowired
    private DeviceDTOConverter converter;

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
    public List<Device> findByUsername(){
        return deviceService.findByUsername(getPrincipal());
    }

    @GetMapping("/dto={id}")
    public DeviceDTO findByUsernameV2(@PathVariable String id){
        Device ent =  deviceService.detail(Long.valueOf(id));
        DeviceDTO dto = converter.entityToDTO(ent);
        dto.setFileStorage(fileStorageService.findByFileName(dto.getFileName()));
        return dto;
    }

    @GetMapping("/device-no-group")
    public List<Device> deviceNoGroup(){
        return deviceService.deviceNoGroup(getPrincipal());
    }

    @GetMapping("/{deviceId}")
    public Device detailDevice(@PathVariable String deviceId){
        Device deviceCur = deviceService.detail(Long.valueOf(deviceId));
        if(getPrincipal().equals(deviceCur.getUsername())){
            return deviceCur;
        }else {
            return (Device) ResponseEntity.badRequest();
        }
    }

    @PostMapping("")
    public DeviceDTO addDevice(@RequestBody DeviceDTO dto){
        Device device = converter.dtoToEntity(dto);
        if(device.getGroupName()==null){
            device.setGroupName("No_Group");
        }
        deviceService.addDevice(device);
        return dto;
    }

    @PutMapping("/name-device")
    public void updDesDevice(@RequestBody Device device){
        Device deviceCur = deviceService.detail(device.getId());
        if (getPrincipal().equals(deviceCur.getUsername())){
            deviceService.updateDesDevice(device);
        }else {
            log.info("device controller - line 65: user khong co quyen update ten va khu vuwjc hoat dong thiet bi nay");
            ResponseEntity.badRequest();
        }
    }

    @PutMapping("/schedule-device")
    public void updScheduleDevice(@RequestBody Device device){
        Device deviceCur = deviceService.detail(device.getId());
        if (getPrincipal().equals(deviceCur.getUsername())){
            deviceService.updateSchedule(device);
        }else {
            log.info("device controller - line 76: user khong co quyen update lich phat nay");
            ResponseEntity.badRequest();
        }
    }

    @PutMapping("/active-device")
    public void updActiveDevice(@RequestBody Device device){
        Device deviceCur = deviceService.detail(device.getId());
        if (getPrincipal().equals(deviceCur.getUsername())){
            deviceService.updateActiveDevice(device);
        }else {
            log.info("device controller - line84: user khong co quyen active thiet bi nay");
            ResponseEntity.badRequest();
        }
    }

    @DeleteMapping("/{deleteId}")
    public void deleteDevice(@PathVariable String deleteId){
        Device deviceCur = deviceService.detail(Long.valueOf(deleteId));
        if (getPrincipal().equals(deviceCur.getUsername())){
            deviceService.delete(Long.valueOf(deleteId));
        }else {
            log.info("device controller - line 95: user khong co quyen xoa device nay");
            ResponseEntity.badRequest();
        }
    }
}
