package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class form extends JDialog{
    private JPanel formPanel;
    private JTextField fieldUsernameR;
    private JTextField fieldUsernameL;
    private JTextField fieldPasswordL;
    private JTextField fieldPasswordR;
    private JButton REGISTERButton;
    private JButton LOGINButton;


    public form(JFrame parent){
    super (parent);
    setTitle("Form");
    setVisible(true);
    setMinimumSize(new Dimension(450,474));
    setModal(true);
    setLocationRelativeTo(parent);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    setContentPane(formPanel);
        REGISTERButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userRegister();
                fieldUsernameR.setText("");
                fieldPasswordR.setText("");
            }
        });
        LOGINButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userLogin();
                fieldUsernameL.setText("");
                fieldPasswordL.setText("");
            }
        });
    }


    private void userRegister(){
String username = fieldUsernameR.getText();
String password = fieldPasswordR.getText();


        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Please enter all fields",
                    "Try again",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        user = addUserToDatabase(username, password);
        if (user != null) {
            JOptionPane.showMessageDialog(this,
                    "registered new user"
            );
        }
        else {
            JOptionPane.showMessageDialog(this,
                    "Failed to register new user",
                    "Try again",
                    JOptionPane.ERROR_MESSAGE);
        }

    }

    private void userLogin(){
        String username = fieldUsernameL.getText();
        String password = fieldPasswordL.getText();

        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Please enter all fields",
                    "Try again",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        user = getAuthenticatedUser(username,password);
        if (user != null) {

            JOptionPane.showMessageDialog(this,
                    user.username+" succeed to login!"
            );
        }
        else {
            JOptionPane.showMessageDialog(this,
                    "Failed to Login",
                    "Try again",
                    JOptionPane.ERROR_MESSAGE);
        }



    }
    public User user;
    private User getAuthenticatedUser(String username, String password){
        final String DB_URL = "jdbc:mysql://localhost/tugasjdbc";
        final String USERNAME = "root";
        final String PASSWORD = "";

        try{
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            // Connected to database successfully...

            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM users WHERE username=? AND password=?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                user = new User();
                user.username = resultSet.getString("username");
                user.password = resultSet.getString("password");
            }


            stmt.close();
            conn.close();

        }catch(Exception e){
            e.printStackTrace();
        }


        return user;
    }








    private User addUserToDatabase(String username, String password) {
        User user = null;

        final String DB_URL = "jdbc:mysql://localhost/tugasjdbc";
        final String USERNAME = "root";
        final String PASSWORD = "";

        try{
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            // Connected to database successfully...

            Statement stmt = conn.createStatement();
            String sql = "INSERT INTO users (username, password) " +
                    "VALUES (?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            //Insert row into the table
            int addedRows = preparedStatement.executeUpdate();
            if (addedRows > 0) {
                user = new User();
                user.username = username;

                user.password = password;

            }



            stmt.close();
            conn.close();

        }catch(Exception e){
            e.printStackTrace();
            System.out.println("gagal konek db");
        }
        System.out.println("Successful registration of: " + user.username);
        return user;
    }
    public static void main(String[] args) {
    form Userform = new form(null);

    }


}


