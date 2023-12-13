package controller;

import entities.Account;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repositories.AccountRepository;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "hello",value = {"/hello"})
public class ControllerServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        AccountRepository accountRepository = new AccountRepository();
        Account c =accountRepository.login(userName,password);
        List<Account> list = accountRepository.getAdminAccount();

        if (c==null){
            request.setAttribute("error","Tài khoản không tồn tại");
            response.setCharacterEncoding("UTF-8");
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }
        else if (accountRepository.isAccountExists(list,c)){
            request.setAttribute("user",c);
            request.getRequestDispatcher("admin").forward(request,response);
        }
        else {
            request.setAttribute("user",c);
            request.getRequestDispatcher("user.jsp").forward(request,response);
        }

    }

    public void destroy() {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("post");
        doGet(req,resp);
    }
}
