package com.ProjectLpu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class AdminAnswerForm extends JFrame implements ActionListener {
    JLabel dashboard, applyPolicy,histroy,askQuestion,questionHistroy,heading,hhead;
    JButton tapply , back;
    JTextArea text, text2;
    JTextField mcode;
    JPanel sidepanel, toppanel,hpanel, sp1,sp2,sp3,sp4,sp5;

    String tname = AdminQuestion.tuser;
//    Integer tqid = AdminQuestion.tqid;
    String tqcode = AdminQuestion.tmcode;


    Conn conn = new Conn();
    JFrame frame;

    AdminAnswerForm(){
        Font f = new Font("Serif", Font.BOLD, 30);
        Font smf = new Font("Bell MT", Font.BOLD, 14);
        Font nf = new Font("Serif", Font.BOLD, 30);

        //frame

        setSize(1200,650);
        setTitle("Admin Answer Form - "+AdminLogin.ADMIN_FULL_NAME);
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

//
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
                    new Home();
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
                sp2.setBackground(Color.yellow);// change the color to green when mouse over a button
            }
            public void mouseExited(MouseEvent me) {
                sp2.setBackground(color);
            }
            public void mouseClicked(MouseEvent e) {
                if (e.getSource() == sp2){
                    new ApplyPolicy();
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
                    new Histroy();
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

        applyPolicy = new JLabel("Apply Policy");
        applyPolicy.setBounds(50,9,100,20);
        applyPolicy.setFont(smf);
        applyPolicy.setBackground(new Color(0x000002C, true));
        applyPolicy.setForeground(new Color(0, 0, 0, 181));
        sp2.add(applyPolicy);

        histroy = new JLabel("History");
        histroy.setBounds(50,9,100,20);
        histroy.setFont(smf);
        histroy.setBackground(new Color(0x000002C, true));
        histroy.setForeground(new Color(0, 0, 0, 181));
        sp3.add(histroy);

        askQuestion = new JLabel("Ask Question");
        askQuestion.setBounds(50,9,100,20);
        askQuestion.setBackground(new Color(0x000002C, true));
        askQuestion.setFont(smf);
        askQuestion.setForeground(new Color(0, 0, 0, 181));
        sp4.add(askQuestion);

        questionHistroy = new JLabel("Question History");
        questionHistroy.setBounds(50,9,150,20);
        questionHistroy.setFont(smf);
        questionHistroy.setBackground(new Color(0x000002C, true));
        questionHistroy.setForeground(new Color(0, 0, 0, 181));
        sp5.add(questionHistroy);

        //end of Side bar

        mcode = new JTextField();
        mcode.setBounds(1000,160,120,30);
        mcode.setText(tqcode);
        mcode.setEditable(false);
        mcode.setFont(smf);
        background.add(mcode);

        text2 = new JTextArea();
        text2.setBounds(270,200,900,60);
        text2.setBorder(BorderFactory.createDashedBorder(Color.BLACK));
        text2.setFont(new Font("poppins",Font.PLAIN,15));
        text2.setEditable(false);
        String query1 ="Select question from questionask Where questionmcode = '"+tqcode+"' and username ='"+tname+"' ";
        try {
            ResultSet rs1 = conn.sta.executeQuery(query1);
            if (rs1.next()){
                String que = rs1.getString(1);
                text2.setText(que);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        background.add(text2);

        text = new JTextArea();
        text.setBounds(270,300,900,200);
        text.setBorder(BorderFactory.createDashedBorder(Color.BLACK));
        text.setFont(new Font("poppins",Font.PLAIN,16));
        text.setText("Give Answer regarding Question!");
        text.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                if (text.getText().equals("")){
                    text.setText("Give Answer regarding Question!");
                }
            }
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                if (text.getText().equals("Give Answer regarding Question!")){
                    text.setText("");
                }

            }
        });
        background.add(text);

        tapply = new JButton("Update");
        tapply.setBounds(1020,520,120,40);
        tapply.setBackground(Color.GREEN);
        tapply.setBorder(null);
        tapply.addActionListener(this);
        background.add(tapply);

        back = new JButton("Back");
        back.setBounds(880,520,120,40);
        back.setBackground(Color.RED);
        back.setForeground(Color.WHITE);
        back.setBorder(null);
        back.addActionListener(this);
        background.add(back);



        //breadcrum

        hpanel = new JPanel();
        hpanel.setBounds(280,70,970,50);
        hpanel.setLayout(null);
        hpanel.setBackground(new Color(12, 170, 199));
        background.add(hpanel);

        hhead = new JLabel("ASK QUESTION");
        hhead.setForeground(Color.WHITE);
        hhead.setFont(new Font("Times New Roman",Font.PLAIN,28));
        hhead.setBounds(20,0,300,50);
        hpanel.add(hhead);





        add(background);
        background.add(toppanel);
        background.add(sidepanel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new  AdminAnswerForm();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == tapply){
            read();
        }
        if (e.getSource() == back){
            new AdminQuestion();
            setVisible(false);
        }

    }
    void  read() {
        if (text.getText().equals("Give Answer regarding Question!") || text.getText()==null){
            JOptionPane.showMessageDialog(frame, "Please give Answer", "Error", JOptionPane.ERROR_MESSAGE);
        }else {
            String answer = text.getText();
            String mcode2 = tqcode;

            String query2 = "update questionask set questionans = '"+answer+"' where questionmcode= '"+mcode2+"' and username = '"+tname+"';";
            try {
                int UpdateQuery = conn.sta.executeUpdate(query2);
                System.out.println(UpdateQuery + "row/s Updated");
                JOptionPane.showMessageDialog(frame, "Sent Successfully", "", JOptionPane.PLAIN_MESSAGE);

            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Sorry, data not inserted..");
                JOptionPane.showMessageDialog(this, "Sorry data not inserted", "Error", JOptionPane.ERROR_MESSAGE);

            }
        }
    }
}
