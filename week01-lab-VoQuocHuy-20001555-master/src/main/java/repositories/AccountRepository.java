package repositories;

import db.ConnectDB;
import entities.Account;
import entities.Status;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AccountRepository {
    Connection connection =null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    public List<Account> getAllAccount(){
        List<Account> accounts = new ArrayList<>();
        String query = "SELECT * FROM account";
        try {
            connection = new ConnectDB().getConnection();
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                accounts.add(new Account(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        Status.fromCode(resultSet.getInt("status"))
                ));
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return accounts;
    }
    public boolean insertAccount(String name, String password, String email, String phone, int statusCode) {
        String sql = "INSERT INTO account (account_id, full_name, password, email, phone, status) VALUES (?, ?, ?, ?, ?, ?)";
        String id = "id" + (getAllAccount().size() + 1); // Tạo một ID mới

        try {
            connection = new ConnectDB().getConnection();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, id);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, password);
            preparedStatement.setString(4, email);
            preparedStatement.setString(5, phone);

            // Chuyển đổi statusCode thành enum Status
            Status accountStatus = Status.fromCode(statusCode);

            preparedStatement.setInt(6, accountStatus.getCode());

            int rowsAffected = preparedStatement.executeUpdate();

            return rowsAffected > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            // Đóng kết nối và các tài nguyên khác tại đây nếu cần.
        }
    }



    public List<Account> getAdminAccount(){
        String query ="select a.account_id\n" +
                "from account a join grant_access g on a.account_id = g.account_id join role r on g.role_id = r.role_id\n" +
                "where r.role_id ='admin'";
        List<Account> accountList = new ArrayList<>();
        try {
            connection = new ConnectDB().getConnection();
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                accountList.add(new Account(
                        resultSet.getString(1)
                ));
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return accountList;
    }
    public Account login(String email, String password){
        String query = "SELECT * FROM account WHERE EMAIL = ? AND PASSWORD = ?";
        try {
            connection = new ConnectDB().getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Account account = new Account(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        Status.fromCode(resultSet.getInt("status"))
                );

                return account;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }
    public boolean isAccountExists(List<Account> accountList, Account accountToCheck) {
        for (Account account : accountList) {
            if (account.getAccountId().equals(accountToCheck.getAccountId())) {
                // Tài khoản đã tồn tại trong danh sách
                return true;
            }
        }
        // Tài khoản không tồn tại trong danh sách
        return false;
    }
        public static void main(String[] args) {
        AccountRepository accountRepository = new AccountRepository();
//        List<Account> accounts = accountRepository.getAllAccount();
//        for (Account as: accounts) {
//            System.out.println(as);
//        }
//            System.out.println(accounts.size());
//        Account c = accountRepository.login("met@gmail.com","123");
//        System.out.println(c);

//            List<Account> listAdmin = accountRepository.getAdminAccount();
//
//            for (Account as: listAdmin) {
//            System.out.println(as);


            System.out.println(accountRepository.insertAccount("lcd","111","khoa@gmail.com","0123456789",1));
        }
    }

