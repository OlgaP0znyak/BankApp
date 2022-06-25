package com.it_academy;

import java.sql.*;

import static java.lang.String.format;

public class DatabaseQuery {
    private PreparedStatement preparedStatement;
    private String query;


    protected void addUser(User user) throws SQLException {
        Connection connection = JDBC.openConnection();
        query = "INSERT INTO Users (name, address) VALUES('%s', '%s')";

        if (connection != null) {
            Statement statement = connection.createStatement();
            statement.executeUpdate(format(query,
                    user.getName(), user.getAddress()));

            statement.close();
            connection.close();
            query = null;
        }
    }

    protected void addAccount(Account account) throws SQLException {
        Connection connection = JDBC.openConnection();
        query = "INSERT INTO Accounts (userid, balance, currency) VALUES(?, ?, ?)";

        if (connection != null) {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, account.getUserId());
            preparedStatement.setBigDecimal(2, account.getBalance());
            preparedStatement.setString(3, account.getCurrency());
            preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();
            query = null;
        }
    }

    protected void addTransaction(Transaction transaction) throws SQLException {
        Connection connection = JDBC.openConnection();
        query = "INSERT INTO Transactions (accountId, amount) VALUES (?, ?)";

        if (connection != null) {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, transaction.getAccountId());
            preparedStatement.setBigDecimal(2, transaction.getAmount());
            preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();
            query = null;
        }
    }

    protected int getLastUserId() throws SQLException {
        Connection connection = JDBC.openConnection();
        query = "SELECT MAX(userId) FROM Users";
        int max = 0;

        if (connection != null) {
            preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            max = resultSet.getInt(1);
            preparedStatement.close();
            connection.close();
            query = null;
        }
        return max;
    }

    protected boolean isUserIdExists(int userId) throws SQLException {
        Connection connection = JDBC.openConnection();
        query = "SELECT EXISTS(SELECT userId FROM Users WHERE userId = '%d')";
        boolean isExist = false;

        if (connection != null) {
            preparedStatement = connection.prepareStatement(format(query, userId));
            ResultSet resultSet = preparedStatement.executeQuery();

            isExist = resultSet.getBoolean(1);
            preparedStatement.close();
            connection.close();
            query = null;
        }
        return isExist;
    }

    protected boolean isAccountIdExists(int userId, int accountId) throws SQLException {
        Connection connection = JDBC.openConnection();
        query = "SELECT EXISTS(SELECT accountId FROM Accounts WHERE userId = '%d' AND accountId = '%d')";
        boolean isExist = false;

        if (connection != null) {
            preparedStatement = connection.prepareStatement(format(query, userId, accountId));
            ResultSet resultSet = preparedStatement.executeQuery();

            isExist = resultSet.getBoolean(1);
            preparedStatement.close();
            connection.close();
            query = null;
        }
        return isExist;
    }
}
