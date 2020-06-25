package com.keke.service;

import com.keke.domain.Admin;
import com.keke.domain.Highadmin;
import com.keke.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired
    AdminMapper adminMapper;

    public Admin adminLogin(String ano, String apassword){
        return adminMapper.adminLogin(ano, apassword);
    }

    public Highadmin highadminLogin(String ano, String apassword){
        return adminMapper.highadminLogin(ano, apassword);
    }
}
