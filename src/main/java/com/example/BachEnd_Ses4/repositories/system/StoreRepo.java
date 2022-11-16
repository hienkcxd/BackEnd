package com.example.BachEnd_Ses4.repositories.system;

import com.example.BachEnd_Ses4.model.System.Store;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StoreRepo extends JpaRepository<Store, Long> {
        public List<Store> findByUsername(String username);
}
