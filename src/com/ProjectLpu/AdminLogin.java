package com.ProjectLpu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminLogin extends JFrame implements ActionListener {
    JButton log_button;
    JButton adminlogin;
    JPanel heading, login;
    JLabel name;
    JTextField username;
    JPasswordField password;
    public static String username2, password2;
    public static String ADMIN_FULL_NAME;
    public static String ADMIN_IMAGE;
    AdminLogin(){
        Font f = new Font("Serif", Font.BOLD, 30);
        //HEADER
        heading = new JPanel();
        heading.setBackground(new Color(0, 0, 0, 80));
        heading.setBounds(0, 0, 1200, 100);
        heading.setLayout(null);

        name = new JLabel();
        name.setText("INSURANCE MANAGEMENT SYSTEM");
        name.setForeground(Color.WHITE);
        name.setBounds(0,20,1200,50);
        name.setHorizontalAlignment(JLabel.CENTER);
        name.setFont(new Font("Bradley Hand ITC",Font.BOLD,45));
        heading.add(name);


        //LOGIN PANEL
        login = new JPanel();
        login.setLayout(null);
        login.setBackground(new Color(0, 0, 0, 60));
        login.setBounds(100, 175, 400, 300);

        JLabel log = new JLabel("Login");
        log.setBounds(30,30,200,40);
        log.setFont(new Font("Century Gothic",Font.BOLD,32));
        log.setForeground(Color.WHITE);
        login.add(log);

        username = new JTextField();
        username.setBackground(new Color(250, 242, 244));
        username.setForeground(Color.BLACK);
        username.setBorder(null);
        username.setOpaque(true);
        username.setBounds(50, 90, 300, 40);
        username.setText("Enter Your Username");
        username.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(username.getText().equals("Enter Your Username")){
                    username.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(username.getText().equals("")){
                    username.setText("Enter Your Username");
                }

            }
        });
        login.add(username);

        password = new JPasswordField();
        password.setBackground(new Color(250, 242, 244));
        password.setForeground(Color.BLACK);
        password.setOpaque(true);
        password.setBorder(null);
        password.setBounds(50, 150, 300, 40);
        password.setText("Enter Your Password");
        password.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(password.getText().equals("Enter Your Password")){
                    password.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(password.getText().equals("")){
                    password.setText("Enter Your Password");
                }


            }
        });
        login.add(password);

        log_button = new JButton("Login");
        log_button.setBounds(140, 200, 100, 50);
        log_button.setBackground(new Color(234, 217, 238));
        log_button.setOpaque(true);
        log_button.setBorder(null);

        log_button.addActionListener(this);
        login.add(log_button);


        //FRAME
        setSize(1200, 650);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        ImageIcon imageIcon = new ImageIcon("Logo.png");
        setIconImage(imageIcon.getImage());
        setTitle("INSURANCE MANAGEMENT SYSTEM");

        //BACKGROUND
        ImageIcon background_image = new ImageIcon("src/com/ProjectLpu/Images/BackGround.png");
        Image img = background_image.getImage();
        Image temp_img = img.getScaledInstance(1200, 650, Image.SCALE_SMOOTH);
        background_image = new ImageIcon(temp_img);
        JLabel background = new JLabel("", background_image, JLabel.CENTER);


        adminlogin = new JButton("User Login");
        adminlogin.setBounds(950, 550, 200, 50);
        adminlogin.setBackground(new Color(153, 234, 23));
        adminlogin.setOpaque(true);
        adminlogin.setBorder(null);

        adminlogin.addActionListener(this);
        background.add(adminlogin);

        background.add(login);
        background.add(heading);
        background.setBounds(0, 0, 1200, 650);
        add(background);
        setVisible(true);

    }

    public static void main(String[] args) {
        new AdminLogin();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == log_button){
            loginx();
        }
        if (e.getSource() == adminlogin){
            new LoginPage();
            setVisible(false);
        }

    }

    void  loginx(){
        username2 = username.getText();
        password2 = password.getText();

        Conn conn = new Conn();

        String query = "Select * from adminsignup where username ='"+username2+"' and password = '"+password2+"'";
        try {
            ResultSet rs = conn.sta.executeQuery(query);
            if (rs.next()){

                //retriving full name of user
                String query1 = "select * from adminsignup where username = '"+username2+"' and password = '"+password2+"';";
                ResultSet rs1 = conn.sta.executeQuery(query1);
                if (rs1.next()){
                    ADMIN_FULL_NAME = rs1.getString(3   );
                    ADMIN_IMAGE = rs1.getString(4);
                }
                //end of retriving

                new AdminHome();
                setVisible(false);
            }else {
                JOptionPane.showMessageDialog(this, "Account doesn't exist", "Error",JOptionPane.ERROR_MESSAGE);
            }

        }catch (SQLException throwables){
            throwables.printStackTrace();
            JOptionPane.showMessageDialog(this, "Some Error Occurred...", "Error",JOptionPane.ERROR_MESSAGE);
        }


    }
}