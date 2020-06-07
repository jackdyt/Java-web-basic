package com.jackdyt.service.impl;

import com.jackdyt.entity.Book;
import com.jackdyt.entity.Borrow;
import com.jackdyt.repository.BookRepository;
import com.jackdyt.repository.BorrowRepository;
import com.jackdyt.repository.impl.BookRepositoryImpl;
import com.jackdyt.repository.impl.BorrowRepositoryImpl;
import com.jackdyt.service.BookService;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class BookServiceImpl implements BookService {
    private BookRepository bookRepository =  new BookRepositoryImpl();
    private BorrowRepository borrowRepository = new BorrowRepositoryImpl();

    private final int LIMIT = 6;
    @Override
    public List<Book> findAll(int page) {
        int index = (page -1) * LIMIT;
        return bookRepository.findAll(index, LIMIT);
    }

    @Override
    public int getPages() {
        int count = bookRepository.count();
        int page =0;
        if (count % LIMIT == 0){
            page = count/LIMIT;
        }else{
            page = count/LIMIT + 1;
        }
        return page;
    }

    @Override
    public void addBorrow(Integer bookid, Integer readerid) {
        //borrow time
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String borrowTime = simpleDateFormat.format(date);
        //return time
        Calendar calendar = Calendar.getInstance();
        int dates = calendar.get(Calendar.DAY_OF_YEAR) + 14;
        calendar.set(Calendar.DAY_OF_YEAR, dates);
        Date date2 = calendar.getTime();
        String returnTime = simpleDateFormat.format(date2);
        borrowRepository.insert(bookid,readerid,borrowTime,returnTime,null,0);

    }

    @Override
    public List<Borrow> findAllBorrowByReaderId(Integer id, Integer page) {
        //convert page to index and limit
        int index = (page -1) * LIMIT;

        return borrowRepository.findAllByReaderId(id,index, LIMIT);
    }

    @Override
    public int getBorrowPages(Integer readerid) {
        int count = borrowRepository.count(readerid);
        int page =0;
        if (count % LIMIT == 0){
            page = count/LIMIT;
        }else{
            page = count/LIMIT + 1;
        }
        return page;
    }

    @Override
    public List<Borrow> findAllBorrowByState(Integer state, Integer page) {
        int index = (page -1) * LIMIT;

        return borrowRepository.findAllByState(state, index, LIMIT);
    }

    @Override
    public int getBorrowPagesByState(Integer state) {
        int count = borrowRepository.coutByState(state);
        int page =0;
        if (count % LIMIT == 0){
            page = count/LIMIT;
        }else{
            page = count/LIMIT + 1;
        }
        return page;

    }

    @Override
    public void handleBorrow(Integer borrowId, Integer state, Integer adminId) {
        borrowRepository.handle(borrowId, state,adminId);
    }
}
