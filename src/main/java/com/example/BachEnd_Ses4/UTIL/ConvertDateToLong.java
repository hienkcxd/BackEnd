package com.example.BachEnd_Ses4.UTIL;

import org.springframework.stereotype.Component;

import java.security.Timestamp;
import java.util.Date;

@Component
public class ConvertDateToLong {
    public Long ConvertDate(Date date){
        return date.getTime()/1000;
    }
}
