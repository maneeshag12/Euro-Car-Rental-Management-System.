package GUI;

import com.toedter.calendar.JCalendar;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Roshana Perera
 */
public class SalaryManagementUI extends javax.swing.JFrame {

    public SalaryManagementUI() {
        initComponents();
        EmployeeTableUpdate();
        SalaryTableUpdate();
        DateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
        String dateString2 = dateFormat2.format(new Date());
        txtVDate.setText(dateString2);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEmployee = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtEmpID = new javax.swing.JTextField();
        txtEmpName = new javax.swing.JTextField();
        txtEmpDesignation = new javax.swing.JTextField();
        txtEmpBasic = new javax.swing.JTextField();
        txtSalBonus = new javax.swing.JTextField();
        txtSalNetPay = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtSalPayMethod = new javax.swing.JComboBox<>();
        btnCalculate = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSalary = new javax.swing.JTable();
        btnConfirm = new javax.swing.JButton();
        txtAddedSalBonus = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        btnclear = new javax.swing.JButton();
        txtVDate = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(25, 35, 51));
        jPanel1.setPreferredSize(new java.awt.Dimension(900, 600));

        jPanel2.setBackground(new java.awt.Color(71, 120, 217));

        tblEmployee.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Designation", "Joined Date", "Basic Salary"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblEmployee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEmployeeMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblEmployee);
        if (tblEmployee.getColumnModel().getColumnCount() > 0) {
            tblEmployee.getColumnModel().getColumn(0).setPreferredWidth(1);
            tblEmployee.getColumnModel().getColumn(1).setPreferredWidth(100);
        }

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Employee ID");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Employee Name");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Designation");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Payment Date");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Basic Salary");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Bonus (10%)");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Net Pay");

        txtEmpID.setEditable(false);
        txtEmpID.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtEmpName.setEditable(false);
        txtEmpName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtEmpDesignation.setEditable(false);
        txtEmpDesignation.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtEmpBasic.setEditable(false);
        txtEmpBasic.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtSalBonus.setEditable(false);
        txtSalBonus.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtSalNetPay.setEditable(false);
        txtSalNetPay.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Payment Method");

        txtSalPayMethod.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtSalPayMethod.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cash", "Bank", "Cheque" }));

        btnCalculate.setFont(new java.awt.Font("Malgun Gothic", 0, 12)); // NOI18N
        btnCalculate.setText("Calculate");
        btnCalculate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalculateActionPerformed(evt);
            }
        });

        tblSalary.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Payment Date", "Payment Method", "Added Bonuses", "Net Pay"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblSalary);
        if (tblSalary.getColumnModel().getColumnCount() > 0) {
            tblSalary.getColumnModel().getColumn(0).setPreferredWidth(1);
        }

        btnConfirm.setFont(new java.awt.Font("Malgun Gothic", 0, 12)); // NOI18N
        btnConfirm.setText("Confirm Payment");
        btnConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmActionPerformed(evt);
            }
        });

        txtAddedSalBonus.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Added Bonus");

        btnclear.setText("Clear");
        btnclear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnclearActionPerformed(evt);
            }
        });

        txtVDate.setEditable(false);
        txtVDate.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 605, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnCalculate, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtEmpID, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                                    .addComponent(txtEmpName)
                                    .addComponent(txtEmpBasic)
                                    .addComponent(txtSalNetPay)
                                    .addComponent(txtEmpDesignation))
                                .addGap(104, 104, 104)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtSalBonus, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtAddedSalBonus, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(6, 6, 6)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtSalPayMethod, 0, 140, Short.MAX_VALUE)
                                    .addComponent(txtVDate)))
                            .addComponent(btnConfirm, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnclear, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtEmpID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnclear))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtEmpName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtEmpDesignation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmpBasic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(txtSalBonus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtVDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtAddedSalBonus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtSalNetPay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel9)
                                .addComponent(jLabel11)))
                        .addGap(18, 18, 18)
                        .addComponent(btnCalculate))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSalPayMethod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addGap(18, 18, 18)
                        .addComponent(btnConfirm)))
                .addContainerGap(68, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Leelawadee", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Salary Management");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(447, 447, 447)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1116, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tblEmployeeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEmployeeMouseClicked
        // TODO add your handling code here:
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/euro_db", "root", "");
            
            int row = tblEmployee.getSelectedRow();
            String TableClick=(tblEmployee.getModel().getValueAt(row,0).toString());
            
            String sql = ("SELECT * FROM employee WHERE empID = '"+TableClick+"'");
            String sql2 = ("SELECT * FROM salary WHERE empID = '"+TableClick+"'");
            //String sql = ("SELECT * FROM employee e INNER JOIN salary s on e.empID = s.empID WHERE e.empID = '"+TableClick+"'");
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            PreparedStatement ps2 = con.prepareStatement(sql2);
            ResultSet rs2 = ps2.executeQuery();
            
            if (rs.next())
            {
                txtEmpID.setText(rs.getString("empID"));
                txtEmpName.setText(rs.getString("empName"));
                txtEmpDesignation.setText(rs.getString("designation"));
                txtEmpBasic.setText(rs.getString("basicSallary"));    
            }
            float basic = Float.parseFloat(txtEmpBasic.getText());
            float bonus = (basic/100)*10;
            txtSalBonus.setText(String.valueOf(bonus));
            txtSalNetPay.setText(String.valueOf(basic+bonus));
            //JOptionPane.showMessageDialog(this, bonus);
            
            ResultSetMetaData rsmd2 =rs2.getMetaData();
            int c2 = rsmd2.getColumnCount();
            
            DefaultTableModel df2 = (DefaultTableModel)tblSalary.getModel();
            df2.setRowCount(0);
            while (rs2.next())
            {
                Vector v2 = new Vector();
                for (int i=1; i<=c2; i++)
                {
                    v2.add(rs2.getString("paymentID"));
                    v2.add(rs2.getString("paymentDate"));
                    v2.add(rs2.getString("paymentMethod"));
                    v2.add(rs2.getString("bonus"));
                    v2.add(rs2.getString("netPay"));
                }
                df2.addRow(v2);
            }
            con.close();
        }
        catch (ClassNotFoundException | SQLException e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_tblEmployeeMouseClicked

    private void btnCalculateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalculateActionPerformed
        // TODO add your handling code here:
        float basic = Float.parseFloat(txtEmpBasic.getText());
        float bonus = Float.parseFloat(txtSalBonus.getText());
        
        if (txtAddedSalBonus.getText().matches("[0-9]{0,9}"))
        {    
            if (txtAddedSalBonus.getText().equals(""))
            {
                //JOptionPane.showMessageDialog(null, txtAddedSalBonus.getText());
                float netpay = basic + bonus;
                txtSalNetPay.setText(String.valueOf(netpay));
            }
            else
            {
                float addedbonus = Float.parseFloat(txtAddedSalBonus.getText());
                float netpay = basic + bonus + addedbonus;
                txtSalNetPay.setText(String.valueOf(netpay));
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Enter a valid amount !");
        }
    }//GEN-LAST:event_btnCalculateActionPerformed

    private void btnConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmActionPerformed
        // TODO add your handling code here:
        //SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        //String SalPayDate = sdf1.format(txtSalPayDate.getDate());
        
        DateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
        String dateString2 = dateFormat2.format(new Date());
        String SalPayDate = dateString2;
        
        Object selectitem=txtSalPayMethod.getSelectedItem();
        String empid=txtEmpID.getText();
        float basicsalary=Float.parseFloat(txtEmpBasic.getText());
        float salbonus=Float.parseFloat(txtSalBonus.getText());
        float addbonus=Float.parseFloat(txtAddedSalBonus.getText());
        float bonus=Float.sum(salbonus,addbonus);
        float netpay=Float.parseFloat(txtSalNetPay.getText());
        String name=txtEmpName.getText();
        
        Connection conn;
        PreparedStatement ps;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3308/euro_db", "root", "");
            String sql =("INSERT INTO `salary`(`paymentID`, `empID`, `paymentDate`, `paymentMethod`, `basicSal`, `bonus`, `netPay`) VALUES (null,?,?,?,?,?,?)");
            ps = conn.prepareStatement(sql);
            ps.setString(1,empid);
            ps.setString(2,SalPayDate);
            ps.setString(3, (String) selectitem);
            ps.setFloat(4, basicsalary);
            ps.setFloat(5, bonus);
            ps.setFloat(6, netpay);
            
            ps.executeUpdate();

            JOptionPane.showMessageDialog(this, "Salaey details of " + name+" has been successfully update !");
            conn.close();
            EmployeeTableUpdate();
            SalaryTableUpdate();
            
            txtEmpID.setText("");
            txtEmpName.setText("");
            txtEmpDesignation.setText("");
            txtEmpBasic.setText("");
            txtAddedSalBonus.setText("");
            txtSalBonus.setText("");
            txtSalPayMethod.setSelectedIndex(0);
            //txtSalPayDate.setDate(null);
            txtSalNetPay.setText("");
            
            
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
       
        
    }//GEN-LAST:event_btnConfirmActionPerformed

    private void btnclearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnclearActionPerformed
        // TODO add your handling code here:
        
        EmployeeTableUpdate();
            SalaryTableUpdate();
            
            txtEmpID.setText("");
            txtEmpName.setText("");
            txtEmpDesignation.setText("");
            txtEmpBasic.setText("");
            txtAddedSalBonus.setText("");
            txtSalBonus.setText("");
            txtSalPayMethod.setSelectedIndex(0);
            //txtSalPayDate.setDate(null);
            txtSalNetPay.setText("");        
    }//GEN-LAST:event_btnclearActionPerformed

    /**
     * @param args the command line arguments
     */
    
    public void EmployeeTableUpdate()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/euro_db", "root", "");
            
            String sql = ("SELECT * FROM employee");
            PreparedStatement  ps = con.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            ResultSetMetaData rsmd  = rs.getMetaData();
            int c = rsmd.getColumnCount();
            
            DefaultTableModel df  = (DefaultTableModel)tblEmployee.getModel();
            df.setRowCount(0);
            
            while (rs.next())
            {
                Vector v = new Vector();
                for (int i=1; i<=c; i++)
                {
                    v.add(rs.getString("empID"));
                    v.add(rs.getString("empName"));
                    v.add(rs.getString("designation"));
                    v.add(rs.getString("empJoinedDate"));
                    v.add(rs.getString("basicSallary"));
                }
                df.addRow(v);
            }
            con.close();
        }
        catch (ClassNotFoundException | SQLException e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void SalaryTableUpdate()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/euro_db", "root", "");
            
            String sql = ("SELECT * FROM salary");
            PreparedStatement  ps = con.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            ResultSetMetaData rsmd  = rs.getMetaData();
            int c = rsmd.getColumnCount();
            
            DefaultTableModel df  = (DefaultTableModel)tblSalary.getModel();
            df.setRowCount(0);
            
            while (rs.next())
            {
                Vector v = new Vector();
                for (int i=1; i<=c; i++)
                {
                    v.add(rs.getString("paymentID"));
                    v.add(rs.getString("paymentDate"));
                    v.add(rs.getString("paymentMethod"));
                    v.add(rs.getString("bonus"));
                    v.add(rs.getString("netPay"));
                }
                df.addRow(v);
            }
            con.close();
        }
        catch (ClassNotFoundException | SQLException e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        
    }
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SalaryManagementUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SalaryManagementUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SalaryManagementUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SalaryManagementUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SalaryManagementUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCalculate;
    private javax.swing.JButton btnConfirm;
    private javax.swing.JButton btnclear;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblEmployee;
    private javax.swing.JTable tblSalary;
    private javax.swing.JTextField txtAddedSalBonus;
    private javax.swing.JTextField txtEmpBasic;
    private javax.swing.JTextField txtEmpDesignation;
    private javax.swing.JTextField txtEmpID;
    private javax.swing.JTextField txtEmpName;
    private javax.swing.JTextField txtSalBonus;
    private javax.swing.JTextField txtSalNetPay;
    private javax.swing.JComboBox<String> txtSalPayMethod;
    private javax.swing.JTextField txtVDate;
    // End of variables declaration//GEN-END:variables
}
