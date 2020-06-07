package com.jackdyt.service.impl;

import com.jackdyt.entity.Admin;
import com.jackdyt.entity.Reader;
import com.jackdyt.repository.ReaderRepository;
import com.jackdyt.repository.AdminRepository;
import com.jackdyt.repository.impl.AdminRepositoryImpl;
import com.jackdyt.repository.impl.ReaderRepositoryImpl;
import com.jackdyt.service.LoginService;

public class LoginServiceImpl implements LoginService {
    private ReaderRepository readerRepository = new ReaderRepositoryImpl();
    private AdminRepository adminRepository = new AdminRepositoryImpl();
    @Override
    public Object login(String username, String password, String type) {
        Object object = null;
        switch (type){
            case"reader":
                object = readerRepository.login(username, password);

                break;
            case"admin":
                object = adminRepository.login(username, password);

                break;
        }
        return object;
    }
}
