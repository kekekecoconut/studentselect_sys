package com.keke.mapper;

import com.keke.domain.Admin;
import com.keke.domain.Highadmin;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminMapper {

    public Admin adminLogin(String ano, String apassword);

    public Highadmin highadminLogin(String ano,String apassword);




}
