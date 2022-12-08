package com.example.BachEnd_Ses4.service.system;

import com.example.BachEnd_Ses4.model.System.UserLog;

import java.util.Date;
import java.util.List;

public interface UserLogService {
    public void addUserLog(UserLog userLog);
    public List<UserLog>  listUserLogByTime(String username, Date startDate, Date endDate);
    public List<UserLog> listUserLogByUsername(String username);
    public List<UserLog> listUserLog();
}
