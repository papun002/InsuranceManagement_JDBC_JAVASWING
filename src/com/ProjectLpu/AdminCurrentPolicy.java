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
import java.nio.channels.ScatteringByteChannel;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.ProjectLpu.AdminLogin.username2;
import static com.ProjectLpu.ApplyPolicy.pcode;

public class AdminCurrentPolicy extends JFrame implements ActionListener {
    JLabel dashboard, applyPolicy, histroy, askQuestion, questionHistroy, hhead, heading;
    JPanel sidepanel, hpanel, toppanel, sp1, sp2, sp3, sp4, sp5, panel;
    DefaultTableModel model;

    Conn conn = new Conn();

    AdminCurrentPolicy() {
        Font f = new Font("Serif", Font.BOLD, 30);
        Font smpf = new Font("Serif", Font.BOLD, 18);
        Font nf = new Font("Serif", Font.BOLD, 30);
        Font smf = new Font("Bell MT", Font.BOLD, 14);

        //frame

        setSize(1200, 650);
        setTitle("Admin Current Policy Section - " + AdminLogin.ADMIN_FULL_NAME);
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

            public void mouseClicked(MouseEvent e) {
                if (e.getSource() == sp1) {
                    new AdminHome();
                    setVisible(false);
                }
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
                    new AdminCustomer();
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
                    new AdminCategory();
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

        //breadcrum

        hpanel = new JPanel();
        hpanel.setBounds(280, 70, 970, 50);
        hpanel.setLayout(null);
        hpanel.setBackground(new Color(12, 170, 199));
        background.add(hpanel);

        hhead = new JLabel("POLICY HOLDER");
        hhead.setForeground(Color.WHITE);
        hhead.setFont(new Font("Times New Roman", Font.PLAIN, 28));
        hhead.setBounds(20, 0, 300, 50);
        hpanel.add(hhead);

        // Jtable implimentaion
        panel = new JPanel();
        panel.setBounds(255, 150, 900, 400);
        panel.setBackground(new Color(22, 33, 22, 0));
        panel.setLayout(null);
        background.add(panel);


        String[] col = {"Sl No.", "Policy Code", "Policy Name", "Customer Name", "Mobile No", "Applied Date", "Username", "Status", "Action"};
        model = new DefaultTableModel();
        JTable table = new JTable(model) {
            public Class getColumnClass(int column) {
                return getValueAt(0, column).getClass();
            }
        };

        // sets row height
        table.setRowHeight(40);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setFillsViewportHeight(true);

        model.setColumnIdentifiers(col);
        TableColumnModel columnModel = table.getColumnModel();

        columnModel.getColumn(0).setPreferredWidth(50);
        columnModel.getColumn(1).setPreferredWidth(100);
        columnModel.getColumn(2).setPreferredWidth(200);
        columnModel.getColumn(3).setPreferredWidth(200);
        columnModel.getColumn(4).setPreferredWidth(100);
        columnModel.getColumn(5).setPreferredWidth(100);
        columnModel.getColumn(6).setPreferredWidth(100);
        columnModel.getColumn(7).setPreferredWidth(100);
        columnModel.getColumn(8).setPreferredWidth(100);
        JScrollPane pane = new JScrollPane(table);
        pane.setBounds(10, 10, 870, 380);
        pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        panel.add(pane, BorderLayout.CENTER);

        //create button column
        ButtonColumn buttonColumn = new ButtonColumn(table, 8);


        int count = 1;
        //table sql
        try {
            String query1 = "select * from applypolicy";
            ResultSet rs1 = conn.sta.executeQuery(query1);
            int increment = 0;
            while (rs1.next()) {
                int qid = count;
                String adate = rs1.getString(2);
                String pname = rs1.getString(4);
                String pcode = rs1.getString(3);
                String name = rs1.getString(5);
                String status = rs1.getString(11);
                String mob = rs1.getString(6);
                String uname = rs1.getString(12);

                model.addRow(new Object[]{qid, pcode, pname, name, mob, adate, uname, status, "Action"});
                increment++;
                count++;
            }
            if (increment < 1) {
                JOptionPane.showMessageDialog(null, "No Record Found", "Error", JOptionPane.ERROR_MESSAGE);
            }
            if (increment == 1) {
                System.out.println(increment + " Record Found");
            } else {
                System.out.println(increment + " Records Found");
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
        new AdminCurrentPolicy();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    class ButtonColumn extends AbstractCellEditor implements TableCellRenderer, TableCellEditor, ActionListener {
        JTable table;
        JButton renderButton;
        JButton editButton;
        String text;

        public ButtonColumn(JTable table, int column) {
            super();
            this.table = table;
            renderButton = new JButton();

            editButton = new JButton();
            editButton.setFocusPainted(false);
            editButton.addActionListener(this);

            TableColumnModel columnModel = table.getColumnModel();
            columnModel.getColumn(column).setCellRenderer(this);
            columnModel.getColumn(column).setCellEditor(this);
        }

        public Component getTableCellRendererComponent(
                JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            if (hasFocus) {
                renderButton.setForeground(Color.BLACK);
                renderButton.setBackground(Color.ORANGE);
            } else if (isSelected) {
                renderButton.setForeground(Color.BLACK);
                renderButton.setBackground(Color.ORANGE);
            } else {
                renderButton.setForeground(Color.BLACK);
                renderButton.setBackground(Color.RED);
            }

            renderButton.setText((value == null) ? "" : value.toString());
            return renderButton;
        }

        public Component getTableCellEditorComponent(
                JTable table, Object value, boolean isSelected, int row, int column) {
            text = (value == null) ? "" : value.toString();
            editButton.setText(text);
            return editButton;
        }

        public Object getCellEditorValue() {
            return text;
        }


        public void actionPerformed(ActionEvent e)
        {
            fireEditingStopped();
            System.out.println( e.getActionCommand() + " : " + table.getSelectedRow());
            //row fetching from table..
            int rowcount = table.getSelectedRow();
            int colmcode  = 1;
            int coluname = 6;
            String username2 = table.getModel().getValueAt(rowcount,coluname).toString();
            String pcode = table.getModel().getValueAt(rowcount,colmcode).toString();
            System.out.println(pcode);

            String app = "Approved";
            String disapp = "Rejected";
            String[] options = { "Approve", "Reject"};
            String myquery = "select * from information_schema.tables where table_schema='ims' and table_name='applypolicy';";
            try{
                ResultSet rs = conn.sta.executeQuery(myquery);
                if (rs.next()){
                    String query1 = "select * from applypolicy where username='" + username2 + "' and pcode ='" + pcode + "' and status ='"+app+"';";
                    try {
                        ResultSet rs1 = conn.sta.executeQuery(query1);
                        if (rs1.next()) {
                            JOptionPane.showMessageDialog(null, "You have Already Approved", "Error", JOptionPane.ERROR_MESSAGE);
                        }else {
                            var selection = JOptionPane.showOptionDialog(null, "Do you want to", "Policy Action",
                                    0, 2, null, options, options[0]);
                            if (selection == 0) {
                                String query6 = "Update applypolicy set status ='" + app + "' where pcode ='" + pcode + "' and username='" + username2 + "'";
                                try {
                                    int UpdateQuery6 = conn.sta.executeUpdate(query6);
                                    System.out.println(UpdateQuery6 + " Updated");
                                    JOptionPane.showMessageDialog(null, "Approved Successfully !");
                                } catch (SQLException exception) {
                                    throw new RuntimeException(exception);
                                }
                            } else if (selection == 1) {
                                String query44 = "update applypolicy set status = '" + disapp + "' where pcode ='" + pcode + "' and username='" + username2 + "'";
                                try {
                                    int UpdateQuery = conn.sta.executeUpdate(query44);
                                    System.out.println(UpdateQuery + " Updated");
                                    JOptionPane.showMessageDialog(null, "Rejected Successfully!");
                                } catch (SQLException exception) {
//                    exception.printStackTrace();
                                    throw new RuntimeException(exception);
                                }

                            } else {
                            }
                        }
                    }catch (Exception exception){
                        exception.printStackTrace();
                    }
                }

            }catch (Exception ex){
                ex.printStackTrace();

            }
        }
    }
}
