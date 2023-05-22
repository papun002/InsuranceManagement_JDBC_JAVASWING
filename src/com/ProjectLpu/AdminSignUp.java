package com.ProjectLpu;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class AdminSignUp extends JFrame implements ActionListener {
    JButton log_button, photo;
    JButton signup;
    JPanel heading, login;
    JLabel name;
    JTextField username, fullname, mob, address;
    JPasswordField password;
    JFrame frame;
    String date, path;
    Conn conn = new Conn();
    File file;
    InputStream inputImage;

    AdminSignUp() {
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

        JLabel log = new JLabel("SignUp");
        log.setBounds(30, 30, 200, 40);
        log.setFont(new Font("Century Gothic", Font.BOLD, 32));
        log.setForeground(Color.WHITE);
        login.add(log);

        username = new JTextField();
        username.setBackground(new Color(250, 242, 244));
        username.setForeground(Color.BLACK);
        username.setBorder(null);
        username.setOpaque(true);
        username.setBounds(50, 90, 150, 40);
        username.setText("Enter Your UserName");
        username.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {

            }

            @Override
            public void focusLost(FocusEvent e) {
                if (username.getText().equals("")) {
                    username.setText("Enter Your UserName");
                }

            }
        });
        login.add(username);

        password = new JPasswordField();
        password.setBackground(new Color(250, 242, 244));
        password.setForeground(Color.BLACK);
        password.setOpaque(true);
        password.setBorder(null);
        password.setBounds(220, 90, 150, 40);
        password.setText("Enter Your Password");
        password.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (password.getText().equals("Enter Your Password")) {
                    password.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (password.getText().equals("")) {
                    password.setText("Enter Your Password");
                }


            }
        });
        login.add(password);

        fullname = new JTextField();
        fullname.setBackground(new Color(250, 242, 244));
        fullname.setForeground(Color.BLACK);
        fullname.setOpaque(true);
        fullname.setBorder(null);
        fullname.setBounds(390, 90, 200, 40);
        fullname.setText("Enter Your Name");
        fullname.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (fullname.getText().equals("Enter Your Name")) {
                    fullname.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (fullname.getText().equals("")) {
                    fullname.setText("Enter Your Name");
                }


            }
        });
        login.add(fullname);

        mob = new JTextField();
        mob.setBackground(new Color(250, 242, 244));
        mob.setForeground(Color.BLACK);
        mob.setOpaque(true);
        mob.setBorder(null);
        mob.setBounds(610, 90, 200, 40);
        mob.setText("Enter Your Mobile No");
        mob.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (mob.getText().equals("Enter Your Mobile No")) {
                    mob.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (mob.getText().equals("")) {
                    mob.setText("Enter Your Mobile No");
                }
            }
        });
        login.add(mob);

        address = new JTextField();
        address.setBackground(new Color(250, 242, 244));
        address.setForeground(Color.BLACK);
        address.setBorder(null);
        address.setOpaque(true);
        address.setBounds(50, 150, 750, 40);
        address.setText("Enter Your Address");
        address.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (address.getText().equals("Enter Your Address")) {
                    address.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (address.getText().equals("")) {
                    address.setText("Enter Your Address");
                }

            }
        });
        login.add(address);

        log_button = new JButton("SIGN UP");
        log_button.setBounds(250, 200, 400, 50);
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

        background.add(login);
        background.add(heading);
        background.setBounds(0, 0, 1200, 650);
        add(background);
        setVisible(true);

    }

    public static void main(String[] args) {
        new AdminSignUp();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == log_button) {
            signup();
        }
    }

    void signup() {
        if (mob.getText().matches("[A-Za-z]+")) {
            JOptionPane.showMessageDialog(frame, "Mobile Number Cannot be Alphabet", "Error", JOptionPane.ERROR_MESSAGE);
        }else  if (username.getText().equals("Enter Your UserName") || fullname.getText().equals("Enter Your Name") || mob.getText().equals("Enter Your Mobile No") || address.getText().equals("Enter Your Address") || password.getPassword().equals("Enter Your Password")) {
            JOptionPane.showMessageDialog(frame, "Please fill Up the Details", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            String uname = username.getText();
            String fname = fullname.getText();
            String pass = Arrays.toString(password.getPassword());
            String mobl = mob.getText();
            Long mobile = Long.parseLong(mobl);
            String add = address.getText();

            String myquery = "select * from information_schema.tables where table_schema='ims' and table_name='adminsignup';";
            try {
                ResultSet rs = conn.sta.executeQuery(myquery);
                System.out.println(rs + " row/s Updated");
                if (rs.next()) {
                    String password2 = JOptionPane.showInputDialog(frame, "Re-Enter Password:");
                    String p = Arrays.toString(password2.toCharArray());

                    if (!pass.equals(p)) {
                        JOptionPane.showMessageDialog(frame, "Password does not Match", "Error", JOptionPane.ERROR_MESSAGE);
                    } else if (uname.equals(password2)) {
                        JOptionPane.showMessageDialog(frame, "Username can't be same as password , set any other unique username", "Error", JOptionPane.ERROR_MESSAGE);
                    } else if (password2.equals(mobl)) {
                        JOptionPane.showMessageDialog(frame, "Password can't be same as mobile number, set a strong password ", "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        //username validation
                        String query1 = "select * from adminsignup where username='" + uname + "';";
                        ResultSet rs1 = conn.sta.executeQuery(query1);
                        if (rs1.next()) {
                            JOptionPane.showMessageDialog(frame, "Username Already exist", "Error", JOptionPane.ERROR_MESSAGE);
                            //End of Username Validation
                        } else {
                            //date impliment
                            LocalDateTime datex = LocalDateTime.now();
                            DateTimeFormatter datel = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                            date = datex.format(datel);
                            String query = "insert into adminsignup values( NULL,'"+date+"','" + fname + "','"+path+"','" + mobile + "','" + add + "', '" + uname + "','" + password2 + "')";
                            try {
                                int insertQuery = conn.sta.executeUpdate(query);
                                System.out.println(insertQuery + "row/s updated");
                                JOptionPane.showMessageDialog(frame, "Sign Up Successfully", "", JOptionPane.PLAIN_MESSAGE);
                                new AdminLogin();
                                setVisible(false);

                            }catch (Exception e) {
                                e.printStackTrace();
                                System.out.println("Sorry, data not inserted..");
                                JOptionPane.showMessageDialog(this, "Sorry data not inserted", "Error", JOptionPane.ERROR_MESSAGE);
                            }


                        }
                    }
                }else {
                    String query5 = "create table adminsignup(adminid int AUTO_INCREMENT primary key,date varchar(50) not null,name varchar(100) not null,image varchar(300),mobile varchar(10) not null,address varchar(200) not null,username varchar(100) not null, password varchar(20) not null);";
                    try {
                        int insertQuery1 = conn.sta.executeUpdate(query5);
                        System.out.println(insertQuery1+"Admin table created");
                        String password2 = JOptionPane.showInputDialog(frame, "Re-Enter Password:");
                        String p = Arrays.toString(password2.toCharArray());

                        if (!pass.equals(p)) {
                            JOptionPane.showMessageDialog(frame, "Password does not Match", "Error", JOptionPane.ERROR_MESSAGE);
                        } else if (uname.equals(password2)) {
                            JOptionPane.showMessageDialog(frame, "Username can't be same as password , set any other unique username", "Error", JOptionPane.ERROR_MESSAGE);
                        } else if (password2.equals(mobl)) {
                            JOptionPane.showMessageDialog(frame, "Password can't be same as mobile number, set a strong password ", "Error", JOptionPane.ERROR_MESSAGE);
                        } else {
                            //username validation
                            String query1 = "select * from adminsignup where username='" + uname + "';";
                            ResultSet rs1 = conn.sta.executeQuery(query1);
                            if (rs1.next()) {
                                JOptionPane.showMessageDialog(frame, "Username Already exist", "Error", JOptionPane.ERROR_MESSAGE);
                                //End of Username Validation
                            } else {
                                //date impliment
                                LocalDateTime datex = LocalDateTime.now();
                                DateTimeFormatter datel = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                                date = datex.format(datel);
                                String query = "insert into adminsignup values( NULL,'"+date+"','" + fname + "','"+path+"','" + mobile + "','" + add + "', '" + uname + "','" + password2 + "')";
                                try {
                                    int insertQuery = conn.sta.executeUpdate(query);
                                    System.out.println(insertQuery + "row/s updated");
                                    JOptionPane.showMessageDialog(frame, "Sign Up Successfully", "", JOptionPane.PLAIN_MESSAGE);
                                    new AdminLogin();
                                    setVisible(false);

                                } catch (Exception e) {
                                    e.printStackTrace();
                                    System.out.println("Sorry, data not inserted..");
                                    JOptionPane.showMessageDialog(this, "Sorry data not inserted", "Error", JOptionPane.ERROR_MESSAGE);
                                }
                            }
                        }
                            }catch (Exception e){
                        e.printStackTrace();
                    }
                }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
    class ImageFilter extends FileFilter {
        public final static String JPEG = "jpeg";
        public final static String JPG = "jpg";
        public final static String GIF = "gif";
        public final static String PNG = "png";

        @Override
        public boolean accept(File f) {
            if (f.isDirectory()) {
                return true;
            }

            String extension = getExtension(f);
            if (extension != null) {
                if (extension.equals(GIF) ||
                        extension.equals(JPEG) ||
                        extension.equals(JPG) ||
                        extension.equals(PNG)) {
                    return true;
                } else {
                    return false;
                }
            }
            return false;
        }

        @Override
        public String getDescription() {
            return "Image Only";
        }

        String getExtension(File f) {
            String ext = null;
            String s = f.getName();
            int i = s.lastIndexOf('.');

            if (i > 0 &&  i < s.length() - 1) {
                ext = s.substring(i+1).toLowerCase();
            }
            return ext;
        }
    }
}
