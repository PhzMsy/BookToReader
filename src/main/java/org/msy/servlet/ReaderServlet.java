package org.msy.servlet;

import com.alibaba.fastjson.JSON;
import org.msy.bean.Book;
import org.msy.bean.Reader;
import org.msy.service.ReaderService;
import org.msy.service.ReaderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author Msy
 * @date 2023/2/9  14:39
 */
@WebServlet("/reader")
public class ReaderServlet extends HttpServlet {
    ReaderService readerService = new ReaderServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        String m = req.getParameter("m");

        if ("query".equals(m)){
            query(req,resp);
        }else if ("insert".equals(m)){
            insert(req,resp);
        }else if ("queryCourseForAjax".equals(m)){
            queryCourseForAjax(req,resp);
        }else if ("queryById".equals(m)) {
            queryById(req, resp);
        }else if ("update".equals(m)) {
            update(req, resp);
        }else if ("delete".equals(m)) {
            delete(req, resp);
        }

    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String id = req.getParameter("id");
        int i = readerService.delete(id);
        resp.getWriter().print(i>0);
    }

    private void update(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String hobby = req.getParameter("hobby");
        String age = req.getParameter("age");
        String[] cids = req.getParameterValues("cids");
        Reader reader = new Reader(id, name, hobby, age);
        int i = readerService.update(reader,cids);
        resp.getWriter().print(i>0);
    }

    private void queryById(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Reader reader = readerService.queryById(id);
        String s = JSON.toJSONString(reader);
        resp.getWriter().print(s);
    }

    private void queryCourseForAjax(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        List<Book> list = readerService.queryCourse();
        String s = JSON.toJSONString(list);
        System.out.println(s);
        resp.getWriter().print(s);

    }

    private void insert(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("name");
        String hobby = req.getParameter("hobby");
        String age = req.getParameter("age");
        String[] cids = req.getParameterValues("cids");
        Reader reader = new Reader(null, name, hobby, age);
        int i = readerService.insertReader(reader,cids);
        resp.getWriter().print(i > 0);
    }

    private void query(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Reader> list = readerService.queryAll();
        req.setAttribute("list",list);
        req.getRequestDispatcher("reader/list.jsp").forward(req,resp);

    }
}
