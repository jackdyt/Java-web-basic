package com.jackdyt.controller;

import com.jackdyt.entity.Book;
import com.jackdyt.entity.Borrow;
import com.jackdyt.entity.Reader;
import com.jackdyt.service.BookService;
import com.jackdyt.service.impl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/book")
public class BookServlet extends HttpServlet {
    private BookService bookService = new BookServiceImpl();

    /***
     * load book data
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        if (method == null){
            method = "findAll";
        }
        HttpSession httpSession = req.getSession();
        Reader reader = (Reader) httpSession.getAttribute("reader");
        switch (method){
            case "findAll":
                String pageStr = req.getParameter("page");
                Integer page = Integer.parseInt(pageStr);
                List<Book> books = bookService.findAll(page);
                req.setAttribute("list", books);
                req.setAttribute("dataPrePage", 6);
                req.setAttribute("currentPage", page);
                req.setAttribute("pages", bookService.getPages());
                req.getRequestDispatcher("index.jsp").forward(req,resp);
                break;
            case"addBorrow":

                String bookidstr = req.getParameter("bookid");
                Integer bookid = Integer.parseInt(bookidstr);

                // borrow request
                bookService.addBorrow(bookid, reader.getId());
                resp.sendRedirect("/book?method=findAllBorrow&page=1");
                break;
            case"findAllBorrow":
                //show the borrow record
                pageStr = req.getParameter("page");
                page = Integer.parseInt(pageStr);
                List<Borrow> borrowList = bookService.findAllBorrowByReaderId(reader.getId(), page);
                int i= 1;
                req.setAttribute("list", borrowList);
                req.setAttribute("dataPrePage", 6);
                req.setAttribute("currentPage", page);
                req.setAttribute("pages", bookService.getBorrowPages(reader.getId()));
                req.getRequestDispatcher("borrow.jsp").forward(req,resp);
                break;
        }




    }


}
