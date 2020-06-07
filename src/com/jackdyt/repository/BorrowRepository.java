package com.jackdyt.repository;

import com.jackdyt.entity.Borrow;

import java.util.List;

public interface BorrowRepository {
    public void insert(Integer bookid, Integer readerid, String borrowtime, String returntime, String adminId,Integer state);
    public List<Borrow> findAllByReaderId(Integer id, Integer index, Integer limit);
    public int count(Integer id);
    public List<Borrow> findAllByState(Integer state,Integer index,Integer limit);
    public int coutByState(Integer state);
    public void handle(Integer borrowId, Integer state, Integer adminId);
}
