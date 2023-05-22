package com.ProjectLpu;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminViewPolicy extends JFrame implements ActionListener {
    JLabel dashboard, applyPolicy,histroy,askQuestion,questionHistroy, heading,hhead;
    JPanel sidepanel, toppanel,sp1,sp2,sp3,sp4,sp5,hpanel,panel;
    JButton back;
    public  static  String value;
    DefaultTableModel model;
    String username2 = AdminLogin.username2;
    Conn conn = new Conn();
    AdminViewPolicy(){
        Font f = new Font("Serif", Font.BOLD, 30);
        Font smpf = new Font("Serif", Font.BOLD, 18);
        Font nf = new Font("Serif", Font.BOLD, 30);
        Font smf = new Font("Bell MT", Font.BOLD, 14);

        //frame

        setSize(1200,650);
        setTitle("AdminPolicy");
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
            public void mouseClicked(MouseEvent e) {
                if (e.getSource() == sp4){
                    new AdminPolicy();
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

        //Jtable start
        panel = new JPanel();
        panel.setBounds(255,150,900,400);
        panel.setBackground(new Color(22,33,22, 0));
        panel.setLayout(null);
        background.add(panel);


//        String data[][]={{"1","Syska Insurance", "Mobile Insurance","50000","2000","10", "May 9,2021","Edit"},
//                {"2","Syska Insurance", "Mobile Insurance","50000","2000","10", "May 9,2021","Edit"},
//                {"3","Syska Insurance", "Mobile Insurance","50000","2000","10", "May 9,2021","Edit"},
//                {"4","Syska Insurance", "Mobile Insurance","50000","2000","10", "May 9,2021","Edit"},
//                {"5","Syska Insurance", "Mobile Insurance","50000","2000","10", "May 9,2021","Edit"},
//        };

        String[] col = {"Sl No.", "Policy Name","PCode","Category","Sum Assurance","Premium","Tenure","Creation Date","Action"};
        model = new DefaultTableModel();
        JTable table = new JTable(model){
            public Class getColumnClass(int column)
            {
                return getValueAt(0, column).getClass();
            }
        };
        model.setColumnIdentifiers(col);

        // sets row height
        table.setRowHeight(40);

        TableColumnModel columnModel = table.getColumnModel();

        columnModel.getColumn(0).setPreferredWidth(50);
        columnModel.getColumn(1).setPreferredWidth(250);
        columnModel.getColumn(2).setPreferredWidth(100);
        columnModel.getColumn(3).setPreferredWidth(250);
        columnModel.getColumn(4).setPreferredWidth(100);
        columnModel.getColumn(5).setPreferredWidth(120);
        columnModel.getColumn(6).setPreferredWidth(100);
        columnModel.getColumn(7).setPreferredWidth(180);
        columnModel.getColumn(8).setPreferredWidth(100);

        JScrollPane pane = new JScrollPane(table);
        pane.setBounds(10,10,870,380);
        panel.add(pane , BorderLayout.CENTER);

        //create button column
        ButtonColumn buttonColumn = new ButtonColumn( table ,8);



        //breadcrum

        hpanel = new JPanel();
        hpanel.setBounds(280,70,970,50);
        hpanel.setLayout(null);
        hpanel.setBackground(new Color(12, 170, 199));
        background.add(hpanel);

        hhead = new JLabel("VIEW POLICY");
        hhead.setForeground(Color.WHITE);
        hhead.setFont(new Font("Times New Roman",Font.PLAIN,28));
        hhead.setBounds(20,0,300,50);
        hpanel.add(hhead);

        back = new JButton("Back");
        back.setBackground(Color.red);
        back.setBounds(270,550,850,40);
        back.setBorder(null);
        back.addActionListener(this);
        background.add(back);

        //Jtable implimentaion query
        int count =1;
        String query1 ="select * from adminaddpolicy where adminusername = '"+username2+"'" ;
        try {
            ResultSet rs1= conn.sta.executeQuery(query1);
            int i =1;
            while (rs1.next()){
                int sl= count;
                String pname= rs1.getString(4);
                String date = rs1.getString(2);
                String pcode = rs1.getString(3);
                String pcat = rs1.getString(5);
                String pten = rs1.getString(6);
                String psum = rs1.getString(7);
                String ppre = rs1.getString(8);

                model.addRow(new Object[]{sl,pname,pcode,pcat,psum,ppre,pten,date,"Edit"});
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
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

        }


        add(background);
        background.add(toppanel);
        background.add(sidepanel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new AdminViewPolicy();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back){
            new AdminPolicy();
            setVisible(false);
        }

    }
    class ButtonColumn extends AbstractCellEditor implements TableCellRenderer, TableCellEditor, ActionListener{
        JTable table;
        JButton renderButton;
        JButton editButton;
        String text;

        public ButtonColumn(JTable table, int column) {
            super();
            this.table = table;
            renderButton = new JButton();

            editButton = new JButton();
            editButton.setFocusPainted( false );
            editButton.addActionListener( this );

            TableColumnModel columnModel = table.getColumnModel();
            columnModel.getColumn(column).setCellRenderer( this );
            columnModel.getColumn(column).setCellEditor( this );
        }
        public Component getTableCellRendererComponent(
                JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
        {
            if (hasFocus)
            {
                renderButton.setForeground(Color.BLACK);
                renderButton.setBackground(Color.ORANGE);
            }
            else if (isSelected)
            {
                renderButton.setForeground(Color.BLACK);
                renderButton.setBackground(Color.ORANGE);
            }
            else
            {
                renderButton.setForeground(Color.BLACK);
                renderButton.setBackground(Color.RED);
            }

            renderButton.setText( (value == null) ? "" : value.toString() );
            return renderButton;
        }

        public Component getTableCellEditorComponent(
                JTable table, Object value, boolean isSelected, int row, int column)
        {
            text = (value == null) ? "" : value.toString();
            editButton.setText( text );
            return editButton;
        }

        public Object getCellEditorValue()
        {
            return text;
        }

        public void actionPerformed(ActionEvent e)
        {
            fireEditingStopped();
            System.out.println( e.getActionCommand() + " : " + table.getSelectedRow());

            int rowcount = table.getSelectedRow();
            int column  = 2;
            value = table.getModel().getValueAt(rowcount,column).toString();
            System.out.println(value);
            new EditPolicy();
        }
    }
}
