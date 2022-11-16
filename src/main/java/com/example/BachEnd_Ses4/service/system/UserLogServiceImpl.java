package com.example.BachEnd_Ses4.service.system;

import com.example.BachEnd_Ses4.model.System.User;
import com.example.BachEnd_Ses4.model.System.UserLog;
import com.example.BachEnd_Ses4.repositories.system.UserLogRepo;
import com.example.BachEnd_Ses4.repositories.system.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserLogServiceImpl implements UserLogService{

    @Autowired
    private UserLogRepo userLogRepo;



    @Override
    public void addUserLog(UserLog userLog) {
        userLogRepo.save(userLog);
    }

    @Override
    public List<UserLog> listUserLogByTime(String username, Date startDate, Date enDate) {
        return null;
    }

    @Override
    public List<UserLog> listUserLogByUsername(String username) {
        return userLogRepo.findUserLogByUsername(username);
    }

    @Override
    public List<UserLog> listUserLog() {
        log.info("user log service - line 41: get all log");
        return userLogRepo.findAll();
    }
}
