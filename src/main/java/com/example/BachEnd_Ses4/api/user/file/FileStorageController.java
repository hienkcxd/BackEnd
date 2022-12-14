package com.example.BachEnd_Ses4.api.user.file;

import com.example.BachEnd_Ses4.model.File.FileStorage;
import com.example.BachEnd_Ses4.service.file.FileStorageService;
import com.example.BachEnd_Ses4.service.system.UserService;
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
@RequestMapping("/api/user/file-storage")
@RequiredArgsConstructor
@Slf4j
@PreAuthorize("hasAnyAuthority('ROLE_USER')")
public class FileStorageController {
    @Autowired
    private FileStorageService fileStorageService;

    @Autowired
    private UserService userService;

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
    public List<FileStorage> fileStorageList(){
        return fileStorageService.findByUsername(getPrincipal());
    }

    @GetMapping("/fileId={fileId}")
    public FileStorage detailFile(@PathVariable String fileId){
        FileStorage detailFile = fileStorageService.detail(Long.valueOf(fileId));
        if(getPrincipal().equals(detailFile.getUserWithFileStorage().getUserName())){
            return detailFile;
        }else {
            return (FileStorage) ResponseEntity.badRequest();
        }
    }

    @PostMapping("")
    public void saveFile(@RequestBody FileStorage fileStorage){
        fileStorage.setUserWithFileStorage(userService.getUser(getPrincipal()));
        fileStorageService.addFile(fileStorage);
    }

    @PutMapping("")
    public void updateFile(@RequestBody FileStorage fileStorage){
        FileStorage fileCheck = fileStorageService.detail(fileStorage.getId());
        if(getPrincipal().equals(fileCheck.getUserWithFileStorage().getUserName())){
            fileStorageService.update(fileStorage);
        }else {
            log.info("user filestorage controller - line 67: user n??y kh??ng c?? quy???n update file n??y");
            ResponseEntity.badRequest();
        }
    }

    @DeleteMapping("/fileId={fileId}")
    public void deleteFile(@PathVariable String fileId){
        FileStorage detailFile = fileStorageService.detail(Long.valueOf(fileId));
        if(getPrincipal().equals(detailFile.getUserWithFileStorage().getUserName())){
            fileStorageService.delete(Long.valueOf(fileId));
        }else {
            log.info("user filestorage controller - line 79: user n??y kh??ng c?? quy???n delete file na??y");
            ResponseEntity.badRequest();
        }
    }

}
