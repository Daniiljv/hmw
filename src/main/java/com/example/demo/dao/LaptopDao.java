package com.example.demo.dao;

import com.example.demo.entity.Laptop;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@Service
public class LaptopDao {
    private String URL = "jdbc:postgresql://localhost:5432/bookStore";
    private String USER = "postgres";
    private String PASSWORD = "postgres";

    public Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public void updateLaptop(Integer id, Laptop laptop) {
        String sql = "UPDATE laptops SET brand = ?, model = ?, price = ?, laptop_photo = ? WHERE id = ?";
        try (Connection conn = connect();
             PreparedStatement statement = conn.prepareStatement(sql)) {

            statement.setInt(4,id);

            statement.setString(1, laptop.getBrand());
            statement.setString(2, laptop.getModel());
            statement.setBigDecimal(3, laptop.getPrice());
            statement.setBytes(4, laptop.getLaptopPhoto());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


