package controller;

import entities.Account;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repositories.AccountRepository;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "admin",value = {"/admin"})
public class AdminController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        AccountRepository accountRepository = new AccountRepository();
        List<Account> accountList = accountRepository.getAllAccount();
        req.setAttribute("allAccount",accountList);
        req.getRequestDispatcher("/dashboard.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
