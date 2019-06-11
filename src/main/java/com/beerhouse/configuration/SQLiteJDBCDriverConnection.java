package com.beerhouse.configuration;
import java.sql.*;

public class SQLiteJDBCDriverConnection {

    private static void connect() {
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:beerhouse.db")) {

            System.out.println("Conexão realizada com Sucesso!");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        connect();
    }
}