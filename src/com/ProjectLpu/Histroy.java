package com.ProjectLpu;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Histroy extends JFrame implements ActionListener {
    JLabel dashboard, applyPolicy,histroy,askQuestion,questionHistroy,heading, hhead;
    JPanel sidepanel, toppanel, panel , hpanel, sp1,sp2,sp3,sp4,sp5;
    DefaultTableModel model;

    private JTable table = new JTable();

    String username2 = LoginPage.username2;
    Conn conn = new Conn();

    Histroy(){
        Font f = new Font("Serif", Font.BOLD, 30);
        Font smf = new Font("Bell MT", Font.BOLD, 14);
        Font nf = new Font("Serif", Font.BOLD, 30);

        //frame

        setSize(1200,650);
        setTitle("History - " +LoginPage.FULL_NAME);
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
            public void mouseClicked(MouseEvent e) {
                if (e.getSource() == sp4){
                    new askQue();
                    setVisible(false);
                }
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
                    new QuestionHis();
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



        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(22,33,22, 0));
        panel.setBounds(255,150,920,400);
        background.add(panel);

        String[] col = {"Sl No.", "Policy Name","Applied Date","Status"};
        model = new DefaultTableModel();
        table.setModel(model);
        model.setColumnIdentifiers(col);
        table.setEnabled(false);

        // sets row height
        table.setRowHeight(40);

        TableColumnModel columnModel = table.getColumnModel();

        columnModel.getColumn(0).setPreferredWidth(100);
        columnModel.getColumn(1).setPreferredWidth(100);
        columnModel.getColumn(2).setPreferredWidth(100);
        columnModel.getColumn(3).setPreferredWidth(100);

        JScrollPane pane = new JScrollPane(table);
        pane.setBounds(10,10,890,390);
        panel.add(pane , BorderLayout.CENTER);



        //breadcrum

        hpanel = new JPanel();
        hpanel.setBounds(280,70,970,50);
        hpanel.setLayout(null);
        hpanel.setBackground(new Color(12, 170, 199));
        background.add(hpanel);

        hhead = new JLabel("HISTORY");
        hhead.setForeground(Color.WHITE);
        hhead.setFont(new Font("Times New Roman",Font.PLAIN,28));
        hhead.setBounds(20,0,300,50);
        hpanel.add(hhead);



        //table query JDBC
        String query1 = "Select * from applypolicy where username ='"+username2+"'";
        try {
            ResultSet rs1 = conn.sta.executeQuery(query1);
            int i=0;
            int count =1;
            while (rs1.next()){
                int slno = count;
                String pname = rs1.getString(4);
                String date =rs1.getString(2);
                String status = rs1.getString(11);
                model.addRow(new Object[]{slno,pname,date,status});
                i++;
                count++;
            }
            if (i < 1) {
                JOptionPane.showMessageDialog(null, "No Record Found", "Error", JOptionPane.ERROR_MESSAGE);
            }
            if (i == 1) {
                System.out.println(i + " Record Found");
            } else {
                System.out.println(i + " Records Found");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        add(background);
        background.add(toppanel);
        background.add(sidepanel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new  Histroy();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
