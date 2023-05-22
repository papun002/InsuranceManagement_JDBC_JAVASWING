package com.ProjectLpu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminPolicy extends JFrame implements ActionListener {
    JLabel dashboard, applyPolicy,histroy,askQuestion,questionHistroy, avaPolicy,appedPolicy, n1,n2, heading;
    JPanel sidepanel, smpanel1,smpanel2,toppanel,sp1,sp2,sp3,sp4,sp5;
    Conn conn = new Conn();
    AdminPolicy(){
        Font f = new Font("Serif", Font.BOLD, 30);
        Font smpf = new Font("Serif", Font.BOLD, 18);
        Font nf = new Font("Serif", Font.BOLD, 30);
        Font smf = new Font("Bell MT", Font.BOLD, 14);

        //frame

        setSize(1200,650);
        setTitle("AdminPolicy - "+AdminLogin.ADMIN_FULL_NAME);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);



//        background
        ImageIcon bg=new ImageIcon("src/com/ProjectLpu/Images/bg111.png");
        Image img= bg.getImage();
        Image temp_img=img.getScaledInstance(1200,650,Image.SCALE_SMOOTH);
        bg= new ImageIcon(temp_img);
        JLabel background =new JLabel("",bg,JLabel.CENTER);

        toppanel=new JPanel();
        toppanel.setBounds(0,0,1200,60);
        toppanel.setBackground(new Color(14, 13, 13, 169));
        toppanel.setLayout(new BorderLayout());

        heading= new JLabel("INSURANCE MANAGEMENT SYSTEM",JLabel.CENTER);
        heading.setForeground(Color.WHITE);
        heading.setFont(f);
        heading.setBounds(150,0, 600,60);
        toppanel.add(heading, BorderLayout.CENTER);



        sidepanel =new JPanel();
        sidepanel.setBounds(0,58,250,555);
        sidepanel.setBackground(new Color(10, 206, 241));
        sidepanel.setLayout(null);

        //side Content panel
        sp1= new JPanel();
        sp1.setBounds(50,80,170,40);
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
            public void mouseClicked(MouseEvent e) {
                if (e.getSource() == sp1){
                    new AdminHome();
                    setVisible(false);
                }
            }
        });
        sidepanel.add(sp1);

        sp2= new JPanel();
        sp2.setBounds(50,140,170,40);
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
                if (e.getSource() == sp2){
                    new AdminCustomer();
                    setVisible(false);
                }
            }
        });
        sidepanel.add(sp2);

        sp3= new JPanel();
        sp3.setBounds(50,200,170,40);
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
                if (e.getSource() == sp3){
                    new AdminCategory();
                    setVisible(false);
                }
            }
        });
        sidepanel.add(sp3);

        sp4= new JPanel();
        sp4.setBounds(50,260,170,40);
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
        });
        sidepanel.add(sp4);

        sp5= new JPanel();
        sp5.setBounds(50,320,170,40);
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
                if (e.getSource() == sp5){
                    new AdminQuestion();
                    setVisible(false);
                }
            }
        });
        sidepanel.add(sp5);


        dashboard = new JLabel("Dashboard");
        dashboard.setBounds(50,9,100,20);
        dashboard.setBackground(new Color(0, 0, 44, 0));
        dashboard.setFont(smf);
        dashboard.setForeground(new Color(0, 0, 0, 181));
        sp1.add(dashboard);

        applyPolicy = new JLabel("Customer");
        applyPolicy.setBounds(50,9,100,20);
        applyPolicy.setFont(smf);
        applyPolicy.setBackground(new Color(0x000002C, true));
        applyPolicy.setForeground(new Color(0, 0, 0, 181));
        sp2.add(applyPolicy);

        histroy = new JLabel("Category");
        histroy.setBounds(50,9,100,20);
        histroy.setFont(smf);
        histroy.setBackground(new Color(0x000002C, true));
        histroy.setForeground(new Color(0, 0, 0, 181));
        sp3.add(histroy);

        askQuestion = new JLabel("Policy");
        askQuestion.setBounds(50,9,100,20);
        askQuestion.setBackground(new Color(0x000002C, true));
        askQuestion.setFont(smf);
        askQuestion.setForeground(new Color(0, 0, 0, 181));
        sp4.add(askQuestion);

        questionHistroy = new JLabel("Question");
        questionHistroy.setBounds(50,9,150,20);
        questionHistroy.setFont(smf);
        questionHistroy.setBackground(new Color(0x000002C, true));
        questionHistroy.setForeground(new Color(0, 0, 0, 181));
        sp5.add(questionHistroy);
        //end of Side bar

//        small panel 1 details
        smpanel1 = new JPanel();
        smpanel1.setVisible(true);
        smpanel1.setBounds(260,100,200,100);
        smpanel1.setBackground(Color.blue);
        smpanel1.setLayout(null);
        smpanel1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new AdminAddPolicy();
                setVisible(false);

            }
        });
        background.add(smpanel1);

        avaPolicy= new JLabel("Add Policy");
        avaPolicy.setBounds(5,10,150,40);
        avaPolicy.setForeground(Color.WHITE);
        avaPolicy.setFont(smpf);
        smpanel1.add(avaPolicy);


//          small panel 2 details
        smpanel2 = new JPanel();
        smpanel2.setVisible(true);
        smpanel2.setBounds(480,100,200,100);
        smpanel2.setBackground(Color.blue);
        smpanel2.setLayout(null);
        smpanel2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new AdminViewPolicy();
                setVisible(false);

            }
        });
        background.add(smpanel2);

        appedPolicy= new JLabel("View Policy");
        appedPolicy.setBounds(5,10,150,40);
        appedPolicy.setForeground(Color.WHITE);
        appedPolicy.setFont(smpf);
        smpanel2.add(appedPolicy);

        n2 = new JLabel();
        n2.setBounds(110,40,70,60);
        n2.setForeground(Color.WHITE);
        n2.setHorizontalAlignment(JLabel.RIGHT);
        n2.setFont(nf);
        String myquery4 = "select * from information_schema.tables where table_schema='ims' and table_name='adminaddpolicy';";
        try {
            ResultSet rs4 = conn.sta.executeQuery(myquery4);
            if (rs4.next()){
                String query3 ="select count(*) from adminaddpolicy;";
                try {
                    ResultSet rs = conn.sta.executeQuery(query3);
                    if (rs.next()){
                        int i = Integer.parseInt(rs.getString(1));
                        n2.setText(String.valueOf(i));
                    }
                } catch (Exception e) {
                        e.printStackTrace();


                }
            }else {
                    n2.setText(String.valueOf(0));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        smpanel2.add(n2);


        add(background);
        background.add(toppanel);
        background.add(sidepanel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new AdminPolicy();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
