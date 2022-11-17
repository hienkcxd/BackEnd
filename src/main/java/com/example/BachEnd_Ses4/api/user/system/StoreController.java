package com.example.BachEnd_Ses4.api.user.system;

import com.example.BachEnd_Ses4.model.System.Store;
import com.example.BachEnd_Ses4.service.system.StoreService;
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
@RequestMapping("/api/user/store")
@RequiredArgsConstructor
@Slf4j
@PreAuthorize("hasAnyAuthority('ROLE_USER')")
public class StoreController {
    @Autowired
    private StoreService storeService;
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
    public List<Store> storeList(){
        return storeService.listStoreByUsername(getPrincipal());
    }

    @GetMapping("/storeid={id}")
    public Store storeDetail(@PathVariable String id){
        Store detailStore = storeService.detailStore(Long.valueOf(id));
        if(getPrincipal().equals(detailStore.getUserWithStore().getUserName())){
            return detailStore;
        }else {
            log.info("StoreController - live 48: user này không có quyền truy cập cửa hàng này");
            return (Store) ResponseEntity.badRequest();
        }
    }

    @PostMapping("")
    public void addStore(@RequestBody Store store){
        store.setStoreName(getPrincipal());
        storeService.addStore(store);
    }

    @PutMapping("")
    public void updateStore(@RequestBody Store store){
        Store detailStore = storeService.detailStore(store.getId());
        if(getPrincipal().equals(detailStore.getUserWithStore().getUserName())){
            storeService.update(store);
        }else {
            log.info("StoreController - live 48: user này không có quyền cập nhập cửa hàng này");
            ResponseEntity.badRequest();
        }
    }

    @DeleteMapping("/deleteId={idStore}")
    public void deleteStore(@PathVariable String idStore){
        Store detailStore = storeService.detailStore(Long.valueOf(idStore));
        if(getPrincipal().equals(detailStore.getUserWithStore().getUserName())){
            storeService.delete(Long.valueOf(idStore));
        }else {
            log.info("StoreController - live 48: user này không có quyền xóa cửa hàng này");
            ResponseEntity.badRequest();
        }
    }
}
