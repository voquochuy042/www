package com.example.week_1.controllers;

import com.example.week_1.entities.*;
import com.example.week_1.services.AccountServices;
import com.example.week_1.services.GrantAccessServices;
import com.example.week_1.services.LogServices;
import com.example.week_1.services.RoleServices;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.constraints.NotNull;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@WebServlet(urlPatterns = {"/ControlServlet"})
public class ControlServlet extends HttpServlet {
    private AccountServices accountServices;
    private LogServices logServices;
    private GrantAccessServices grantAccessServices;
    private RoleServices roleServices;

    @Override
    public void init() {
        logServices = new LogServices();
        accountServices = new AccountServices();
        grantAccessServices = new GrantAccessServices();
        roleServices = new RoleServices();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String action = req.getParameter("action");

        if (action == null)
            action = "";

        switch (action) {
            case "dashboard":
                handleGetDashboard(req, resp);
                break;
            case "update-account":
                handleGetUpdateAccount(req, resp);
                break;
            case "account-detail":
                handleGetDetailAccount(req, resp);
                break;
            case "update-grant-access":
                handleGetUpdateGrantAccess(req, resp);
                break;
            case "role-manage":
                handleRoleManage(req, resp);
                break;
            case "user":
                handleGetUser(req, resp);
                break;
            case "account-by-role":
                handleGetAccountByRole(req, resp);
                break;
            case "update-role":
                handleGetUpdateRole(req, resp);
                break;
            case "add-grant-access":
                handleGetAddGrantAccess(req, resp);
                break;
            default:
                req.getRequestDispatcher("notFound.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String action = req.getParameter("action");

        switch (action) {
            case "login":
                handleLogin(req, resp);
                break;
            case "logout":
                handleLogout(req, resp);
                break;
            case "add-account":
                handleAddAccount(req, resp);
                break;
            case "delete-account":
                handleSoftDeleteAccount(req, resp);
                break;
            case "update-account":
                handlePostUpdateAccount(req, resp);
                break;
            case "disable-grant-account":
                handleDisableGrantAccount(req, resp);
                break;
            case "delete-role":
                handleSoftDeleteRole(req, resp);
                break;
            case "update-grant-account":
                handlePostUpdateGrantAccess(req, resp);
                break;
            case "add-role":
                handlePostAddRole(req, resp);
                break;
            case "update-role":
                handlePostUpdateRole(req, resp);
                break;
            case "add-grant-account":
                handlePostAddGrantAccount(req, resp);
                break;
            default:
                req.getRequestDispatcher("notFound.jsp").forward(req, resp);
        }
    }

    private void handleLogin(@NotNull HttpServletRequest req, @NotNull HttpServletResponse resp) throws IOException {
        req.getSession(true).invalidate();

        String destination = "index.jsp";
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        Optional<Account> account = accountServices.isLogin(username, password);

        if (account.isEmpty()) {
            HttpSession session = req.getSession(true);
            session.setAttribute("message", "Invalid email, phone or password");
            session.setAttribute("username", username);
            session.setAttribute("password", password);
        } else {
            Account acc = account.get();
            destination = "user.jsp";

            Log log = new Log(acc.getId(), LocalDateTime.now(), LocalDateTime.now(), "");

            List<GrantAccess> grantAccesses = grantAccessServices.getGrantAccessByAccount(acc.getId());
            HttpSession httpSession = req.getSession(true);
            httpSession.invalidate();

            httpSession = req.getSession(true);
            httpSession.setAttribute("account", account.get());
            httpSession.setAttribute("grantAccesses", grantAccesses);
            httpSession.setAttribute("log", log);
            httpSession.setAttribute("isAdmin", false);

            for (GrantAccess ga : grantAccesses)
                if (ga.getRole().getId().equalsIgnoreCase("admin")) {
                    destination = "ControlServlet?action=dashboard";
                    httpSession.setAttribute("isAdmin", true);
                    break;
                }

            logServices.add(log);
        }
        resp.sendRedirect(destination);
    }

    private void handleLogout(@NotNull HttpServletRequest req, @NotNull HttpServletResponse resp) throws IOException {
        HttpSession httpSession = req.getSession(true);
        Object log = httpSession.getAttribute("log");

        if (log != null) {
            Log l = (Log) log;
            l.setLogoutTime(LocalDateTime.now());
            logServices.update(l);
        }

        httpSession.invalidate();
        resp.sendRedirect("index.jsp");
    }

    private void handleAddAccount(@NotNull HttpServletRequest req, @NotNull HttpServletResponse resp) throws IOException {
        Account newAccount = getAccount(req);
        boolean add = accountServices.add(newAccount);
        HttpSession session = req.getSession(true);

        if (add) {
            session.setAttribute("toast-message", "Add account successfully!");
            session.setAttribute("toast-type", "success");

            resp.sendRedirect("ControlServlet?action=dashboard");
        }
        else{
            session.setAttribute("newAccount", newAccount);
            session.setAttribute("toast-message", "Add account failed.");
            session.setAttribute("toast-type", "danger");

            resp.sendRedirect("addAccount.jsp");
        }
    }

    private Account findAccount(@NotNull HttpServletRequest req, @NotNull HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        Boolean isAdmin = (Boolean) session.getAttribute("isAdmin");

        if (isAdmin == null || !isAdmin) {
            req.getRequestDispatcher("forbidden.jsp").forward(req, resp);
            return null;
        }

        String id = req.getParameter("id");

        if (id == null) {
            req.getRequestDispatcher("notFound.jsp").forward(req, resp);
            return null;
        }

        Optional<Account> account = accountServices.findById(id);

        if (account.isEmpty()) {
            req.getRequestDispatcher("notFound.jsp").forward(req, resp);
            return null;
        }

        return account.get();
    }

    private Role findRoleById(@NotNull HttpServletRequest req, @NotNull HttpServletResponse resp) throws ServletException, IOException {
        String roleId = req.getParameter("id");

        if (roleId == null) {
            req.getRequestDispatcher("notFound.jsp").forward(req, resp);
            return null;
        }

        Optional<Role> role = roleServices.findById(roleId);

        if (role.isEmpty()) {
            req.getRequestDispatcher("notFound.jsp").forward(req, resp);
            return null;
        }

        return role.get();
    }

    private void handleGetDashboard(@NotNull HttpServletRequest req, @NotNull HttpServletResponse resp) throws IOException {
        HttpSession httpSession = req.getSession(true);

        List<Account> accountMember = accountServices.getAccountMember();
        httpSession.setAttribute("accountMember", accountMember);

        resp.sendRedirect("dashboard.jsp");
    }

    private void handleSoftDeleteAccount(@NotNull HttpServletRequest req, @NotNull HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession(true);

        Object isAdmin = session.getAttribute("isAdmin");

        if (isAdmin == null || !(Boolean) isAdmin)
            return;

        String id = req.getParameter("id");
        Optional<Boolean> b = accountServices.softDelete(id);

        if (b.isPresent() && b.get()) {
            session.setAttribute("toast-message", "Delete account successfully!");
            session.setAttribute("toast-type", "success");
        } else {
            session.setAttribute("toast-message", "Delete account failed.");
            session.setAttribute("toast-type", "danger");
        }

        resp.sendRedirect("ControlServlet?action=dashboard");
    }

    private void handleGetUpdateAccount(@NotNull HttpServletRequest req, @NotNull HttpServletResponse resp) throws ServletException, IOException {
        Account account = findAccount(req, resp);

        if (account == null)
            return;

        HttpSession session = req.getSession(true);
        session.setAttribute("account-update", account);
        resp.sendRedirect("updateAccount.jsp?id=" + account.getId());
    }

    private void handlePostUpdateAccount(@NotNull HttpServletRequest req, @NotNull HttpServletResponse resp) throws IOException, ServletException {
        Account account = getAccount(req);

        Optional<Boolean> update = accountServices.update(account);
        HttpSession session = req.getSession(true);

        if (update.isPresent() && update.get()) {
            session.setAttribute("toast-message", "Update account successfully!");
            session.setAttribute("toast-type", "success");

            resp.sendRedirect("ControlServlet?action=dashboard");
        } else {
            session.setAttribute("account-update", account);
            session.setAttribute("toast-message", "Update account failed.");
            session.setAttribute("toast-type", "danger");

            resp.sendRedirect("updateAccount.jsp");
        }
    }

    private @NotNull Account getAccount(@NotNull HttpServletRequest req) {
        String id = req.getParameter("id");
        String fullName = req.getParameter("full-name");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String status = req.getParameter("status");
        Status st = status == null ? Status.deactive : Status.active;

        return new Account(id, fullName, password, email, phone, st);
    }

    private void handleGetDetailAccount(@NotNull HttpServletRequest req, @NotNull HttpServletResponse resp) throws ServletException, IOException {
        Account acc = findAccount(req, resp);

        if (acc == null)
            return;

        List<GrantAccess> grantAccesses = grantAccessServices.getAllGrantAccessByAccount(acc.getId());
        HttpSession session = req.getSession(true);

        session.setAttribute("account-detail", acc);
        session.setAttribute("grant-accesses-detail", grantAccesses);

        resp.sendRedirect("accountDetail.jsp?id=" + acc.getId());
    }

    private void handleDisableGrantAccount(@NotNull HttpServletRequest req, @NotNull HttpServletResponse resp) throws IOException {
        String id = req.getParameter("id");
        String roleId = req.getParameter("role-id");
        HttpSession session = req.getSession(true);

        Optional<Boolean> b = grantAccessServices.updateGrant(id, roleId, false);

        if (b.isPresent() && b.get()) {
            session.setAttribute("toast-message", "Disable role successfully!");
            session.setAttribute("toast-type", "success");
        } else {
            session.setAttribute("toast-message", "Disable role failed.");
            session.setAttribute("toast-type", "danger");
        }

        resp.sendRedirect("ControlServlet?action=account-detail&id=" + id);
    }

    private void handleRoleManage(@NotNull HttpServletRequest req, @NotNull HttpServletResponse resp) throws IOException {
        List<Role> roles = roleServices.getRoleNotDeleted();

        HttpSession session = req.getSession(true);

        session.setAttribute("roles", roles);

        resp.sendRedirect("roleManage.jsp");
    }

    private void handleSoftDeleteRole(@NotNull HttpServletRequest req, @NotNull HttpServletResponse resp) throws IOException {
        String id = req.getParameter("id");

        Optional<Boolean> b = roleServices.softDelete(id);
        HttpSession session = req.getSession(true);

        if (b.isPresent() && b.get()) {
            session.setAttribute("toast-message", "Delete role successfully!");
            session.setAttribute("toast-type", "success");
        } else {
            session.setAttribute("toast-message", "Delete role failed.");
            session.setAttribute("toast-type", "danger");
        }

        resp.sendRedirect("ControlServlet?action=role-manage");
    }

    private void handleGetUpdateGrantAccess(@NotNull HttpServletRequest req, @NotNull HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String roleId = req.getParameter("role-id");

        if (id == null || roleId == null) {
            req.getRequestDispatcher("notFound.jsp").forward(req, resp);
            return;
        }

        Optional<Account> account = accountServices.findById(id);

        if (account.isEmpty()) {
            req.getRequestDispatcher("notFound.jsp").forward(req, resp);
            return;
        }

        Optional<GrantAccess> grantAccess = grantAccessServices.getGrantAccess(id, roleId);

        if (grantAccess.isEmpty()) {
            req.getRequestDispatcher("notFound.jsp").forward(req, resp);
            return;
        }

        HttpSession session = req.getSession(true);

        session.setAttribute("accountGrantAccess", account.get());
        session.setAttribute("grantAccess", grantAccess.get());
        resp.sendRedirect(String.format("updateGrantAccount.jsp?id=%s&role-id=%s", id, roleId));
    }

    private void handlePostUpdateGrantAccess(@NotNull HttpServletRequest req, @NotNull HttpServletResponse resp) throws IOException, ServletException {
        String id = req.getParameter("id");
        String roleId = req.getParameter("role-id");
        String grant = req.getParameter("grant");
        boolean isGrant = grant != null && grant.equals("active");
        String note = req.getParameter("note");

        GrantAccess grantAccess = new GrantAccess(new Role(roleId), new Account(id), isGrant, note);

        Optional<Boolean> update = grantAccessServices.update(grantAccess);
        HttpSession session = req.getSession(true);

        if (update.isPresent() && update.get()) {
            session.setAttribute("toast-message", "Update grant account successfully!");
            session.setAttribute("toast-type", "success");

            resp.sendRedirect(String.format("ControlServlet?action=account-detail&id=%s", id));
        } else {
            session.setAttribute("grantAccess", grantAccess);
            session.setAttribute("toast-message", "Update grant account failed.");
            session.setAttribute("toast-type", "danger");

            resp.sendRedirect(String.format("updateGrantAccount.jsp?id=%s&role-id=%s", id, roleId));
        }
    }

    private void handleGetUser(@NotNull HttpServletRequest req, @NotNull HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession(true);
        Object accountObject = session.getAttribute("account");

        if (accountObject == null) {
            resp.sendRedirect("index.jsp");
            return;
        }

        Account account = (Account) accountObject;
        Optional<Account> acc = accountServices.findById(account.getId());

        if (acc.isEmpty()){
            resp.sendRedirect("notFound.jsp");
            return;
        }

        List<GrantAccess> grantAccesses = grantAccessServices.getGrantAccessByAccount(acc.get().getId());
        session.setAttribute("account", acc.get());
        session.setAttribute("grantAccesses", grantAccesses);
        resp.sendRedirect("user.jsp");
    }

    private void handleGetAccountByRole(@NotNull HttpServletRequest req, @NotNull HttpServletResponse resp) throws ServletException, IOException {
        Role role = findRoleById(req, resp);

        assert role != null;
        List<Account> accounts = accountServices.getAccountByRole(role.getId());
        HttpSession session = req.getSession(true);
        session.setAttribute("role", role);
        session.setAttribute("accounts", accounts);
        resp.sendRedirect("accountsOfRole.jsp?id=" + role.getId());
    }

    private @NotNull Role getRole(@NotNull HttpServletRequest req) {
        String id = req.getParameter("id");
        String name = req.getParameter("role-name");
        String description = req.getParameter("description");
        String status = req.getParameter("status");
        Status st = status == null ? Status.deactive : Status.active;

        return new Role(id, name, description, st);
    }

    private void handlePostAddRole(@NotNull HttpServletRequest req, @NotNull HttpServletResponse resp) throws IOException {
        Role role = getRole(req);
        boolean b = roleServices.addRole(role);
        HttpSession session = req.getSession(true);

        if (b) {
            session.setAttribute("toast-message", "Add role successfully!");
            session.setAttribute("toast-type", "success");

            resp.sendRedirect("ControlServlet?action=role-manage");
        }
        else{
            session.setAttribute("newRole", role);
            session.setAttribute("toast-message", "Add role failed.");
            session.setAttribute("toast-type", "danger");

            resp.sendRedirect("addRole.jsp");
        }
    }

    private void handleGetUpdateRole(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Role role = findRoleById(req, resp);

        HttpSession session = req.getSession(true);

        session.setAttribute("role", role);
        assert role != null;
        resp.sendRedirect("updateRole.jsp?id=" + role.getId());
    }

    private void handlePostUpdateRole(@NotNull HttpServletRequest req, @NotNull HttpServletResponse resp) throws IOException {
        Role role = getRole(req);

        Optional<Boolean> b = roleServices.update(role);
        HttpSession session = req.getSession(true);

        if (b.isPresent() && b.get()) {
            session.setAttribute("toast-message", "Update role successfully!");
            session.setAttribute("toast-type", "success");

            resp.sendRedirect("ControlServlet?action=role-manage");
        }
        else{
            session.setAttribute("role", role);
            session.setAttribute("toast-message", "Update role failed.");
            session.setAttribute("toast-type", "danger");

            resp.sendRedirect("updateRole.jsp?id=" + role.getId());
        }
    }

    private void handleGetAddGrantAccess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Account account = findAccount(req, resp);

        if (account == null)
            return;

        HttpSession session = req.getSession(true);
        List<Role> roles = roleServices.getNewRoleForAccount(account.getId());

        if (roles.isEmpty()) {
            session.setAttribute("toast-message", "Account already has all roles!");
            session.setAttribute("toast-type", "info");
            resp.sendRedirect("ControlServlet?action=account-detail&id=" + account.getId());
        } else {
            session.setAttribute("accountRole", account);
            session.setAttribute("roles", roles);
            resp.sendRedirect("addGrantAccess.jsp?id=" + account.getId());
        }
    }

    private void handlePostAddGrantAccount(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String id = req.getParameter("id");
        String roleId = req.getParameter("role-id");
        String note = req.getParameter("note");

        GrantAccess grantAccess = new GrantAccess(new Role(roleId), new Account(id), true, note);

        boolean b = grantAccessServices.add(grantAccess);
        HttpSession session = req.getSession(true);

        if (b) {
            session.setAttribute("toast-message", "Add role successfully!");
            session.setAttribute("toast-type", "success");
            resp.sendRedirect("ControlServlet?action=account-detail&id=" + id);
        } else {
            session.setAttribute("toast-message", "Add role failed.");
            session.setAttribute("toast-type", "danger");
            session.setAttribute("role-id", roleId);
            session.setAttribute("note", note);
            resp.sendRedirect("ControlServlet?action=add-grant-access&id=" + id);
        }
    }
}
