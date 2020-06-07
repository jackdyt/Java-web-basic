package com.jackdyt.repository;

import com.jackdyt.entity.Reader;

public interface ReaderRepository {
    public Reader login(String username, String password);
}
