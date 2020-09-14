package controller;

import entity.Userinfo;
import factory.Factory;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "controller.UserServlet", urlPatterns = {"*.do"})
public class UserServlet extends HttpServlet {
    UserService userService;

    public UserServlet() throws IllegalAccessException, ClassNotFoundException, InstantiationException {
        userService = Factory.getInstance("userService");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String name = request.getParameter("username");
        String email = request.getParameter("email");
        String sex = request.getParameter("sex");
        String area = request.getParameter("area");
        String desc = request.getParameter("desc");
        String password = request.getParameter("pwd");
        Userinfo userinfo = new Userinfo(name, email, sex, area, desc);
        userinfo.setPassword(password);
        if (userService.register(userinfo) > 0) {
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else {
            response.sendRedirect("register.jsp");
        }

    }

    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String option = request.getParameter("option");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (option.equals("user")) {
            if (userService.login(username, password)) {

                request.getRequestDispatcher("welcome.jsp").forward(request, response);
            } else {
                response.sendRedirect("login.jsp");
            }
        } else if (option.equals("admin")) {
            if (userService.login1(username, password)) {
                request.getRequestDispatcher("admin.jsp").forward(request, response);
            } else {
                response.sendRedirect("login.jsp");
            }
        }
    }

    protected void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Userinfo> userinfoList = userService.getUsers();
        request.setAttribute("list", userinfoList);
        request.getRequestDispatcher("list.jsp").forward(request, response);
    }

    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String no = request.getParameter("user_id");
       // Integer id = Integer.parseInt(no);
        Userinfo userinfo = userService.findById(no);
        if (userinfo != null) {
            request.setAttribute("userinfo", userinfo);
            request.getRequestDispatcher("update.jsp").forward(request, response);
        } else {
            //提示没有该用户
            System.out.println("没有该用户");
        }
    }

    protected void modify(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String selvletPath = request.getServletPath();
        if (selvletPath.contains("register.do")) {
            register(request, response);
        } else if (selvletPath.contains("login.do")) {
            login(request, response);
        } else if (selvletPath.contains("query.do")) {
            query(request, response);
        } else if (selvletPath.contains("update.do")) {
            update(request, response);
        } else if (selvletPath.contains("modify.do")) {
            modify(request, response);
        }
    }
}
