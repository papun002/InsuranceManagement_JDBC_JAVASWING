package com.ProjectLpu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;

import com.ProjectLpu.LoginPage.*;

public class ApplyForm extends JFrame implements ActionListener {
    JButton log_button, back;
    JPanel heading, login;
    JLabel name;
    JTextField fullname, mob, address, email,amobile, aadhaar, insurance;
    JFrame frame;
    Conn conn = new Conn();
    String username2= LoginPage.username2;
    String datex;
    String pcodex = ApplyPolicy.pcode;
    String pcat = ApplyPolicy.pcat;
    String pname = ApplyPolicy.pname;

    ApplyForm() {
        Font f = new Font("Serif", Font.BOLD, 30);

        //HEADER
        heading = new JPanel();
        heading.setBackground(new Color(0, 0, 0, 80));
        heading.setBounds(0, 0, 1200, 100);
        heading.setLayout(null);

        name = new JLabel();
        name.setText("INSURANCE MANAGEMENT SYSTEM");
        name.setForeground(Color.WHITE);
        name.setBounds(0, 20, 1200, 50);
        name.setHorizontalAlignment(JLabel.CENTER);
        name.setFont(new Font("Bradley Hand ITC", Font.BOLD, 45));
        heading.add(name);


        //LOGIN PANEL
        login = new JPanel();
        login.setLayout(null);
        login.setBackground(new Color(0, 0, 0, 60));
        login.setBounds(130, 175, 900, 300);

        JLabel date = new JLabel();
        date.setBounds(30,10,300,20);
        date.setFont(new Font("Century Gothic",Font.ITALIC,14));

        //date impliment
        LocalDateTime datey = LocalDateTime.now();
        DateTimeFormatter datel = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        datex = datey.format(datel);
        date.setText(" Today Date: "+datex);
        login.add(date);

        JLabel pcode = new  JLabel();
        pcode.setHorizontalAlignment(JLabel.RIGHT);
        pcode.setBounds(640,10,200,20);
        pcode.setFont(new Font("Century Gothic",Font.ITALIC,14));
        pcode.setText("Policy Code: "+pcodex);
        login.add(pcode);


        JLabel log = new JLabel("Insurance Name: "+ pname);
        log.setBounds(30, 30, 600, 40);
        log.setFont(new Font("Century Gothic", Font.BOLD, 32));
        log.setForeground(Color.WHITE);
        login.add(log);

        insurance = new JTextField();
        insurance.setBackground(new Color(250, 242, 244));
        insurance.setForeground(Color.BLACK);
        insurance.setBorder(null);
        insurance.setOpaque(true);
        insurance.setEditable(false);
        insurance.setBounds(50, 90, 150, 40);
        insurance.setText(pname);
        login.add(insurance);

        fullname = new JTextField();
        fullname.setBackground(new Color(250, 242, 244));
        fullname.setForeground(Color.BLACK);
        fullname.setBorder(null);
        fullname.setOpaque(true);
        fullname.setEditable(false);
        fullname.setBounds(220, 90, 150, 40);
        String s1 = "select signup.name from signup where signup.username='"+username2+"';";
        try {
            ResultSet rs1 = conn.sta.executeQuery(s1);
            if(rs1.next()) {
                String r1 = rs1.getString(1);
                fullname.setText(r1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        login.add(fullname);

        email = new JTextField();
        email.setBackground(new Color(250, 242, 244));
        email.setForeground(Color.BLACK);
        email.setOpaque(true);
        email.setBorder(null);
        email.setBounds(610, 90, 200, 40);
        email.setText("Enter Your Email");
        email.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (email.getText().equals("Enter Your Email")) {
                    email.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (email.getText().equals("")) {
                    email.setText("Enter Your Email");
                }


            }
        });
        login.add(email);

        amobile = new JTextField();
        amobile.setBackground(new Color(250, 242, 244));
        amobile.setForeground(Color.BLACK);
        amobile.setOpaque(true);
        amobile.setBorder(null);
        amobile.setEditable(false);
        amobile.setBounds(390, 90, 200, 40);
        String s2 = "select signup.mobile from signup where signup.username='"+username2+"';";
        try {
            ResultSet rs2 = conn.sta.executeQuery(s2);
            if(rs2.next()) {
                String r2 = rs2.getString(1);
                Long l = Long.parseLong(r2);
                amobile.setText(String.valueOf(l));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        login.add(amobile);

        mob = new JTextField();
        mob.setBackground(new Color(250, 242, 244));
        mob.setForeground(Color.BLACK);
        mob.setOpaque(true);
        mob.setBorder(null);
        mob.setBounds(50, 150, 200, 40);
        mob.setText("Enter Your Alternate Mobile No");
        mob.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (mob.getText().equals("Enter Your Alternate Mobile No")) {
                    mob.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (mob.getText().equals("")) {
                    mob.setText("Enter Your Alternate Mobile No");
                }


            }
        });
        login.add(mob);

        address = new JTextField();
        address.setBackground(new Color(250, 242, 244));
        address.setForeground(Color.BLACK);
        address.setBorder(null);
        address.setOpaque(true);
        address.setEditable(false);
        address.setBounds(270, 150, 250, 40);
        String s3 = "select signup.address from signup where signup.username='"+username2+"';";
        try {
            ResultSet rs3 = conn.sta.executeQuery(s3);
            if(rs3.next()) {
                String r3 = rs3.getString(1);
                address.setText(r3);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        login.add(address);

        aadhaar = new JTextField();
        aadhaar.setBackground(new Color(250, 242, 244));
        aadhaar.setForeground(Color.BLACK);
        aadhaar.setBorder(null);
        aadhaar.setOpaque(true);
        aadhaar.setBounds(560, 150, 250, 40);
        aadhaar.setText("Enter Your Aadhar Number");
        aadhaar.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (aadhaar.getText().equals("Enter Your Aadhar Number")) {
                    aadhaar.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (aadhaar.getText().equals("")) {
                    aadhaar.setText("Enter Your Aadhar Number");
                }

            }
        });
        login.add(aadhaar);

        log_button = new JButton("Apply");
        log_button.setBounds(250, 200, 400, 50);
        log_button.setBackground(new Color(234, 217, 238));
        log_button.setOpaque(true);
        log_button.setBorder(null);

        log_button.addActionListener(this);
        login.add(log_button);

         back= new JButton("Back");
        back.setBounds(700, 200, 100, 50);
        back.setBackground(new Color(229, 62, 45));
        back.setForeground(Color.WHITE);
        back.setOpaque(true);
        back.setBorder(null);

        back.addActionListener(this);
        login.add(back);


        //FRAME
        setSize(1200, 650);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        ImageIcon imageIcon = new ImageIcon("Logo.png");
        setIconImage(imageIcon.getImage());
        setTitle("Apply Policy Form - "+ LoginPage.FULL_NAME);

        //BACKGROUND
        ImageIcon background_image = new ImageIcon("src/com/ProjectLpu/Images/bg111.png");
        Image img = background_image.getImage();
        Image temp_img = img.getScaledInstance(1200, 650, Image.SCALE_SMOOTH);
        background_image = new ImageIcon(temp_img);
        JLabel background = new JLabel("", background_image, JLabel.CENTER);

        background.add(login);
        background.add(heading);
        background.setBounds(0, 0, 1200, 650);
        add(background);
        setVisible(true);

    }

    public static void main(String[] args) {
        new ApplyForm();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == log_button) {
            save();
        }
        if (e.getSource() == back){
            new ApplyPolicy();
            setVisible(false);
        }

    }
    void save(){
        if (mob.getText().matches("[A-Za-z]+")) {
            JOptionPane.showMessageDialog(frame, "Mobile Number Cannot be Alphabet", "Error", JOptionPane.ERROR_MESSAGE);
        }else if (mob.getText().length()>10){
            JOptionPane.showMessageDialog(frame, "Mobile Number Length Cannot be Greater than 10.. Please Enter Vaild Mobile Number", "Error", JOptionPane.ERROR_MESSAGE);
        }else if (mob.getText().equals("Enter Your Alternate Mobile No") || aadhaar.getText().equals("Enter Your Aadhar Number") || email.getText().equals("Enter Your Email")) {
            JOptionPane.showMessageDialog(frame, "Please fill Up the Details", "Error", JOptionPane.ERROR_MESSAGE);
        }else {
            String name =fullname.getText();
            String mobl = mob.getText();
            String address1 = address.getText();
            String email1 = email.getText();
            String amob = amobile.getText();
            String aadhar1 = aadhaar.getText();
            String insurance1 = insurance.getText();

            //date impliment
            LocalDateTime datex = LocalDateTime.now();
            DateTimeFormatter datel = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String date = datex.format(datel);
            String status = "Pending";

            //checking table
            String myquery = "select * from information_schema.tables where table_schema='ims' and table_name='applypolicy';";
            try {
                ResultSet rs = conn.sta.executeQuery(myquery);
                System.out.println(rs + " row/s Updated");
                if (rs.next()) {
                        String query2 = "insert into applypolicy values( NULL,'" + date + "','" + pcodex + "','" + insurance1 + "','" + name + "','" + mobl + "','" + email1 + "','" + amob + "','" + address1 + "','" + aadhar1 + "','" + status + "','" + username2 + "')";
                        try {
                            int insertQuerty = conn.sta.executeUpdate(query2);
                            System.out.println(insertQuerty + " row/s Updated");
                            JOptionPane.showMessageDialog(this, "Data Added Successfully...", "Message", JOptionPane.PLAIN_MESSAGE);
                            new Histroy();
                            setVisible(false);

                        } catch (Exception e) {
                            e.printStackTrace();
                            System.out.println("Sorry, data not inserted..");
                            JOptionPane.showMessageDialog(this, "Data Added Failure..", "Message", JOptionPane.PLAIN_MESSAGE);
                        }
                }
            }catch (SQLException e) {
                throw new RuntimeException(e);
            }
            }
        }
    }