package com.ProjectLpu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class AdminAddPolicy extends JFrame implements ActionListener {
    JLabel dashboard, applyPolicy, histroy, askQuestion, questionHistroy, heading, lcategory, lpolicyname, lsumAss, lpremium, ltenure, hhead, lpcode;
    JPanel sidepanel, toppanel, sp1, sp2, sp3, sp4, sp5, bpanel, hpanel;
    JComboBox category;
    JTextField tpolicyname, tsumAss, tpremium, ttenure, tpcode;

    JButton save, back;
    String randomString;
    Conn conn = new Conn();
    String date;
    String username2 = AdminLogin.username2;
    JFrame frame;

    AdminAddPolicy() {
        Font f = new Font("Serif", Font.BOLD, 30);
        Font smpf = new Font("Georgia", Font.BOLD, 15);
        Font nf = new Font("Serif", Font.BOLD, 30);
        Font smf = new Font("Bell MT", Font.BOLD, 14);

        //frame

        setSize(1200, 650);
        setTitle("Admin Add Policy Section - "+AdminLogin.ADMIN_FULL_NAME);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);


//        background
        ImageIcon bg = new ImageIcon("src/com/ProjectLpu/Images/bg111.png");
        Image img = bg.getImage();
        Image temp_img = img.getScaledInstance(1200, 650, Image.SCALE_SMOOTH);
        bg = new ImageIcon(temp_img);
        JLabel background = new JLabel("", bg, JLabel.CENTER);

        toppanel = new JPanel();
        toppanel.setBounds(0, 0, 1200, 60);
        toppanel.setBackground(new Color(14, 13, 13, 169));
        toppanel.setLayout(new BorderLayout());

        heading = new JLabel("INSURANCE MANAGEMENT SYSTEM", JLabel.CENTER);
        heading.setForeground(Color.WHITE);
        heading.setFont(f);
        heading.setBounds(150, 0, 600, 60);
        toppanel.add(heading, BorderLayout.CENTER);


        sidepanel = new JPanel();
        sidepanel.setBounds(0, 58, 250, 555);
        sidepanel.setBackground(new Color(10, 206, 241));
        sidepanel.setLayout(null);

        //side Content panel
        sp1 = new JPanel();
        sp1.setBounds(50, 80, 170, 40);
        sp1.setLayout(null);
        sp1.setBackground(Color.ORANGE);
        sp1.addMouseListener(new MouseAdapter() {
            Color color = sp1.getBackground();

            public void mouseEntered(MouseEvent me) {
                color = sp1.getBackground();
                sp1.setBackground(Color.yellow);// change the color to green when mouse over a button
            }

            public void mouseExited(MouseEvent me) {
                sp1.setBackground(color);
            }
        });
        sidepanel.add(sp1);

        sp2 = new JPanel();
        sp2.setBounds(50, 140, 170, 40);
        sp2.setBackground(Color.ORANGE);
        sp2.setLayout(null);
        sp2.addMouseListener(new MouseAdapter() {
            Color color = sp2.getBackground();

            public void mouseEntered(MouseEvent me) {
                color = sp2.getBackground();
                sp2.setBackground(Color.yellow); // change the color to green when mouse over a button
            }

            public void mouseExited(MouseEvent me) {
                sp2.setBackground(color);
            }

            public void mouseClicked(MouseEvent e) {
                if (e.getSource() == sp2) {
//                    new ApplyPolicy();
                    setVisible(false);
                }
            }
        });
        sidepanel.add(sp2);

        sp3 = new JPanel();
        sp3.setBounds(50, 200, 170, 40);
        sp3.setBackground(Color.ORANGE);
        sp3.setLayout(null);
        sp3.addMouseListener(new MouseAdapter() {
            Color color = sp3.getBackground();

            public void mouseEntered(MouseEvent me) {
                color = sp3.getBackground();
                sp3.setBackground(Color.yellow);// change the color to green when mouse over a button
            }

            public void mouseExited(MouseEvent me) {
                sp3.setBackground(color);
            }

            public void mouseClicked(MouseEvent e) {
                if (e.getSource() == sp3) {
//                    new Histroy();
                    setVisible(false);
                }
            }
        });
        sidepanel.add(sp3);

        sp4 = new JPanel();
        sp4.setBounds(50, 260, 170, 40);
        sp4.setBackground(Color.ORANGE);
        sp4.setLayout(null);
        sp4.addMouseListener(new MouseAdapter() {
            Color color = sp4.getBackground();

            public void mouseEntered(MouseEvent me) {
                color = sp4.getBackground();
                sp4.setBackground(Color.yellow);// change the color to green when mouse over a button
            }

            public void mouseExited(MouseEvent me) {
                sp4.setBackground(color);
            }

            public void mouseClicked(MouseEvent e) {
                if (e.getSource() == sp4) {
                    new AdminPolicy();
                    setVisible(false);
                }
            }
        });
        sidepanel.add(sp4);

        sp5 = new JPanel();
        sp5.setBounds(50, 320, 170, 40);
        sp5.setBackground(Color.ORANGE);
        sp5.setLayout(null);
        sp5.addMouseListener(new MouseAdapter() {
            Color color = sp5.getBackground();

            public void mouseEntered(MouseEvent me) {
                color = sp5.getBackground();
                sp5.setBackground(Color.yellow);// change the color to green when mouse over a button
            }

            public void mouseExited(MouseEvent me) {
                sp5.setBackground(color);
            }

            public void mouseClicked(MouseEvent e) {
                if (e.getSource() == sp5) {
                    new AdminQuestion();
                    setVisible(false);
                }
            }
        });
        sidepanel.add(sp5);


        dashboard = new JLabel("Dashboard");
        dashboard.setBounds(50, 9, 100, 20);
        dashboard.setBackground(new Color(0, 0, 44, 0));
        dashboard.setFont(smf);
        dashboard.setForeground(new Color(0, 0, 0, 181));
        sp1.add(dashboard);

        applyPolicy = new JLabel("Customer");
        applyPolicy.setBounds(50, 9, 100, 20);
        applyPolicy.setFont(smf);
        applyPolicy.setBackground(new Color(0x000002C, true));
        applyPolicy.setForeground(new Color(0, 0, 0, 181));
        sp2.add(applyPolicy);

        histroy = new JLabel("Category");
        histroy.setBounds(50, 9, 100, 20);
        histroy.setFont(smf);
        histroy.setBackground(new Color(0x000002C, true));
        histroy.setForeground(new Color(0, 0, 0, 181));
        sp3.add(histroy);

        askQuestion = new JLabel("Policy");
        askQuestion.setBounds(50, 9, 100, 20);
        askQuestion.setBackground(new Color(0x000002C, true));
        askQuestion.setFont(smf);
        askQuestion.setForeground(new Color(0, 0, 0, 181));
        sp4.add(askQuestion);

        questionHistroy = new JLabel("Question");
        questionHistroy.setBounds(50, 9, 150, 20);
        questionHistroy.setFont(smf);
        questionHistroy.setBackground(new Color(0x000002C, true));
        questionHistroy.setForeground(new Color(0, 0, 0, 181));
        sp5.add(questionHistroy);
        //end of Side bar

        //body start panel

        bpanel = new JPanel();
        bpanel.setBounds(260, 150, 920, 300);
        bpanel.setLayout(null);
        background.add(bpanel);

        //JLabel Body
        lcategory = new JLabel("Category : ");
        lcategory.setBounds(10, 10, 100, 40);
        lcategory.setFont(smpf);
        bpanel.add(lcategory);

        lpolicyname = new JLabel("Policy Name : ");
        lpolicyname.setBounds(450, 10, 200, 40);
        lpolicyname.setFont(smpf);
        bpanel.add(lpolicyname);

        lsumAss = new JLabel("Sum Assurance : ");
        lsumAss.setBounds(10, 70, 200, 40);
        lsumAss.setFont(smpf);
        bpanel.add(lsumAss);

        lpremium = new JLabel("Premium : ");
        lpremium.setBounds(450, 70, 200, 40);
        lpremium.setFont(smpf);
        bpanel.add(lpremium);

        ltenure = new JLabel("Tenure : ");
        ltenure.setBounds(10, 130, 100, 40);
        ltenure.setFont(smpf);
        bpanel.add(ltenure);

        lpcode = new JLabel("Policy Code : ");
        lpcode.setBounds(450, 130, 200, 40);
        lpcode.setFont(smpf);
        bpanel.add(lpcode);


        //JText and Combo
        category = new JComboBox();
        category.setBounds(120, 15, 300, 40);
        category.setBackground(Color.white);
        category.addItem("Select Category");
        bpanel.add(category);

        //Combo box fetch sql query
        String query = "select * from adminaddcategory";
        try {
            ResultSet rs = conn.sta.executeQuery(query);
            while (rs.next()) {
                String cname = rs.getString(3);
                category.addItem(cname);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        //end of fetching

        tpolicyname = new JTextField();
        tpolicyname.setBounds(580, 15, 300, 40);
        bpanel.add(tpolicyname);

        tsumAss = new JTextField();
        tsumAss.setBounds(160, 75, 260, 40);
        bpanel.add(tsumAss);

        tpremium = new JTextField();
        tpremium.setBounds(580, 75, 300, 40);
        bpanel.add(tpremium);

        ttenure = new JTextField();
        ttenure.setBounds(120, 135, 300, 40);
        bpanel.add(ttenure);

        tpcode = new JTextField();
        tpcode.setBounds(580, 135, 300, 40);
        tpcode.setEditable(false);
        TextFieldUpdater.updateTextField(tpcode, "New Text");
        bpanel.add(tpcode);

        save = new JButton("Add");
        save.setBounds(30, 190, 830, 40);
        save.setBorder(null);
        save.setBackground(Color.green);
        save.setForeground(Color.black);
        save.addActionListener(this);
        save.setFont(smpf);
        bpanel.add(save);

        back = new JButton("Back");
        back.setBounds(30, 240, 830, 40);
        back.setBorder(null);
        back.setBackground(Color.red);
        back.setForeground(Color.white);
        back.addActionListener(this);
        back.setFont(smpf);
        bpanel.add(back);


        //breadcrum

        hpanel = new JPanel();
        hpanel.setBounds(280, 70, 970, 50);
        hpanel.setLayout(null);
        hpanel.setBackground(new Color(12, 170, 199));
        background.add(hpanel);

        hhead = new JLabel("ADD POLICY");
        hhead.setForeground(Color.WHITE);
        hhead.setFont(new Font("Times New Roman", Font.PLAIN, 28));
        hhead.setBounds(20, 0, 300, 50);
        hpanel.add(hhead);

        add(background);
        background.add(toppanel);
        background.add(sidepanel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new AdminAddPolicy();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            new AdminPolicy();
            setVisible(false);
        }
        if (e.getSource() == save) {
            read();
        }
    }
    void read(){
        String cate = (String) category.getSelectedItem();
        if (cate.equals("Select Category") || tpolicyname.getText().equals("") || ttenure.getText().equals("") || tpremium.getText().equals("") || tsumAss.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Please fill the details", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            String pname = tpolicyname.getText();
            String ptenure = ttenure.getText();
            String ppre = tpremium.getText();
            String psum = tsumAss.getText();
            String pcode = tpcode.getText();

            LocalDateTime datex = LocalDateTime.now();
            DateTimeFormatter datel = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            date = datex.format(datel);

            String query = "select * from information_schema.tables where table_schema='ims' and table_name='adminaddpolicy';";
            try {
                ResultSet rs = conn.sta.executeQuery(query);
                if (rs.next()) {
                    String query1 = "insert into adminaddpolicy values( NULL,'" + date + "','" + pcode + "','" + pname + "','" + cate + "','" + ptenure + "','" + psum + "','" + ppre + "','" + username2 + "')";
                    int insertQuery = conn.sta.executeUpdate(query1);
                    System.out.println(insertQuery + " row/s Inserted");
                    JOptionPane.showMessageDialog(this, "Data Added Successfully...", "Message", JOptionPane.PLAIN_MESSAGE);
                    TextFieldUpdater.updateTextField(tpcode, "New Text");
                    bpanel.revalidate();
                    tpolicyname.setText("");
                    ttenure.setText("");
                    tsumAss.setText("");
                    tpremium.setText("");
                } else {
                    String query2 = "create table adminaddpolicy(pid int AUTO_INCREMENT primary key, date varchar(50),pcode varchar(20) not null ,pname varchar(100),pcategory varchar(50),tenure varchar(30),sumass varchar(20),premium varchar(30),adminusername varchar(100) not null);";
                    try {
                        int rs2 = conn.sta.executeUpdate(query2);
                        System.out.println(rs2 + " Table created");
                        String query1 = "insert into adminaddpolicy values( NULL,'" + date + "','" + pcode + "','" + pname + "','" + cate + "','" + ptenure + "','" + psum + "','" + ppre + "','" + username2 + "')";
                        try {
                            int insertQuery = conn.sta.executeUpdate(query1);
                            System.out.println(insertQuery + " row/s Inserted");
                            JOptionPane.showMessageDialog(this, "Data Added Successfully...", "Message", JOptionPane.PLAIN_MESSAGE);
                            TextFieldUpdater.updateTextField(tpcode, "New Text");
                            tpolicyname.setText("");
                            ttenure.setText("");
                            tsumAss.setText("");
                            tpremium.setText("");
                        } catch (Exception ez) {
                            ez.printStackTrace();
                            System.out.println("Sorry, data not inserted..");
                            JOptionPane.showMessageDialog(this, "Sorry Data Not inserted", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (Exception ep) {
                        ep.printStackTrace();
                        System.out.println("Sorry, table not Created..");
                        JOptionPane.showMessageDialog(this, "Sorry Data Not inserted", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }

        }
    }
}
