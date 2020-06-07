package com.jackdyt.repository;

import com.jackdyt.entity.Admin;

public interface AdminRepository {
    public Admin login(String username, String password);
}
