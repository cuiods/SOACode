package edu.nju.soa.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * score servlet
 */
@WebServlet("/scoreV2")
public class ScoreServletV2 extends HttpServlet{

    ScoreService service;

    @Override
    public void init() throws ServletException {
        service = new ScoreService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        System.out.println(request.getRequestURL());
        String sid =  request.getParameter("sid");
        String result = service.getScoresByStudentId(sid);
        response.setCharacterEncoding("UTF-8");
        response.setHeader("content-type","text/xml;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        writer.print(result);
    }
}
