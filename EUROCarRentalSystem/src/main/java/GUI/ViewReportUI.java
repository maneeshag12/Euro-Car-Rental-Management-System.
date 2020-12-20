/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Roshana Perera
 */
public class ViewReportUI extends javax.swing.JFrame {

    /**
     * Creates new form ViewReportUI
     */
    public ViewReportUI() {
        initComponents();
        VehiTable_Update();
        cusTable_Update();
        userTable_Update();
        EmpTable_Update();
    }

    public void EmpTable_Update()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/euro_db", "root", "");
            PreparedStatement pst = con.prepareStatement("SELECT * FROM employee");
            ResultSet rs = pst.executeQuery();
            ResultSetMetaData rd  = rs.getMetaData();
            int c = rd.getColumnCount();
            DefaultTableModel df  = (DefaultTableModel)tblEreport.getModel();
            
            df.setRowCount(0);
            
            while (rs.next())
            {
                Vector v2 = new Vector();
                for (int i=1; i<=c; i++)
                {
                    v2.add(rs.getString("empID"));
                    v2.add(rs.getString("empName"));
                    v2.add(rs.getString("empAddress"));
                    v2.add(rs.getString("designation"));
                    v2.add(rs.getString("empcontactNo"));
                    v2.add(rs.getString("empEmail"));
                    v2.add(rs.getString("empNIC"));
                    v2.add(rs.getString("empJoinedDate"));
                    v2.add(rs.getString("basicSallary"));
                }
                df.addRow(v2);
            }

            con.close();
        }
        catch (Exception e)
        {
            
        }
    }
    
    public void VehiTable_Update()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/euro_db", "root", "");
            PreparedStatement pst = con.prepareStatement("SELECT * FROM vehicle v INNER JOIN supplier s on v.vehicleNo = s.vehicleNo");
            ResultSet rs = pst.executeQuery();
            ResultSetMetaData rd  = rs.getMetaData();
            int c = rd.getColumnCount();
            DefaultTableModel df  = (DefaultTableModel)tblSreport.getModel();
            
            df.setRowCount(0);
            
            while (rs.next())
            {
                Vector v2 = new Vector();
                for (int i=1; i<=c; i++)
                {
                    v2.add(rs.getString("supplierName"));
                    v2.add(rs.getString("supplierAddress"));
                    v2.add(rs.getString("supplierNIC"));
                    v2.add(rs.getString("supplierContactNo"));
                    v2.add(rs.getString("supplierEmail"));
                    v2.add(rs.getString("vehicleNo"));
                    v2.add(rs.getString("make"));
                    v2.add(rs.getString("model"));
                    v2.add(rs.getString("pickupDate"));
                    v2.add(rs.getString("returnDate"));
                    v2.add(rs.getString("rate"));
                }
                df.addRow(v2);
            }

            con.close();
        }
        catch (Exception e)
        {
            
        }
    }
    
    public void userTable_Update()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/euro_db", "root", "");
            PreparedStatement pst = con.prepareStatement("SELECT * FROM user");
            ResultSet rs = pst.executeQuery();
            ResultSetMetaData rd  = rs.getMetaData();
            int c = rd.getColumnCount();
            DefaultTableModel df  = (DefaultTableModel)tblUreport.getModel();
            
            df.setRowCount(0);
            
            while (rs.next())
            {
                Vector v2 = new Vector();
                for (int i=1; i<=c; i++)
                {
                    v2.add(rs.getString("userID"));
                    v2.add(rs.getString("username"));
                    v2.add(rs.getString("usertype"));
                    v2.add(rs.getString("displayName"));
                    v2.add(rs.getString("userStatus"));
                }
                df.addRow(v2);
            }

            con.close();
        }
        catch (Exception e)
        {
            
        }
    }
    
    public void cusTable_Update()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/euro_db", "root", "");
            PreparedStatement pst = con.prepareStatement("SELECT * FROM customer c INNER JOIN rental r on r.cusID = c.cusID");
            ResultSet rs = pst.executeQuery();
            ResultSetMetaData rd  = rs.getMetaData();
            int c = rd.getColumnCount();
            DefaultTableModel df  = (DefaultTableModel)tblCreport1.getModel();
            
            df.setRowCount(0);
            
            while (rs.next())
            {
                Vector v2 = new Vector();
                for (int i=1; i<=c; i++)
                {
                    v2.add(rs.getString("cusName"));
                    v2.add(rs.getString("cusAddress"));
                    v2.add(rs.getString("cusNIC"));
                    v2.add(rs.getString("cusContactNo"));
                    v2.add(rs.getString("cusEmail"));
                    v2.add(rs.getString("vehicleNo"));
                    v2.add(rs.getString("renPickupDate"));
                    v2.add(rs.getString("renReturndate"));
                    v2.add(rs.getString("driverID"));
                    v2.add(rs.getString("renTotal"));
                    v2.add(rs.getString("RentalStatus"));
                }
                df.addRow(v2);
            }

            con.close();
        }
        catch (Exception e)
        {
            
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSreport = new javax.swing.JTable();
        btnRReport1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        btnRReport = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblCreport1 = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblUreport = new javax.swing.JTable();
        btnUReport = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblEreport = new javax.swing.JTable();
        btnUReport1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblSreport.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Address", "Suuplier NIC", "ContactNo", "Email", "Vehicle No", "Manufauturer", "Model", "Pickup Date", "Return Date", "Rate"
            }
        ));
        jScrollPane1.setViewportView(tblSreport);

        btnRReport1.setFont(new java.awt.Font("Malgun Gothic", 0, 14)); // NOI18N
        btnRReport1.setText("Generate Supplier Report");
        btnRReport1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnRReport1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRReport1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1017, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRReport1)
                .addGap(420, 420, 420))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(btnRReport1)
                .addContainerGap(83, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Supplier Report", jPanel2);

        btnRReport.setFont(new java.awt.Font("Malgun Gothic", 0, 14)); // NOI18N
        btnRReport.setText("Generate Rental Report");
        btnRReport.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnRReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRReportActionPerformed(evt);
            }
        });

        tblCreport1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Customer Name", "Address", "NIC", "ContactNo", "Email", "Vehicle No", "Pickup Date", "Return Date", "Driver ID", "Total Rental", "Status"
            }
        ));
        jScrollPane2.setViewportView(tblCreport1);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(424, Short.MAX_VALUE)
                .addComponent(btnRReport)
                .addGap(430, 430, 430))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addComponent(btnRReport)
                .addGap(59, 59, 59))
        );

        jTabbedPane1.addTab("Rental Report", jPanel3);

        tblUreport.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "User ID", "Username", "User Type", "Display Name", "User Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblUreport);

        btnUReport.setFont(new java.awt.Font("Malgun Gothic", 0, 14)); // NOI18N
        btnUReport.setText("Generate User Report");
        btnUReport.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnUReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUReportActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 946, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnUReport)
                .addGap(424, 424, 424))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                .addComponent(btnUReport)
                .addGap(63, 63, 63))
        );

        jTabbedPane1.addTab("User Report", jPanel4);

        tblEreport.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Employee ID", "Name", "Address", "Designation", "Contact No", "E-mail", "NIC", "Joined Date", "Basic Salary"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tblEreport);

        btnUReport1.setFont(new java.awt.Font("Malgun Gothic", 0, 14)); // NOI18N
        btnUReport1.setText("Generate Employee Report");
        btnUReport1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnUReport1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUReport1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 946, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(403, 403, 403)
                        .addComponent(btnUReport1)))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                .addComponent(btnUReport1)
                .addGap(67, 67, 67))
        );

        jTabbedPane1.addTab("Employee Report", jPanel5);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUReportActionPerformed
        try {
            // TODO add your handling code here:
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/euro_db", "root", "");
            JasperDesign jasd = JRXmlLoader.load("C:\\Users\\dilum\\Documents\\NetBeansProjects\\EUROCarRentalSystem\\src\\main\\java\\GUI\\UserReport.jrxml");
            String sql = "SELECT * FROM user";
            JRDesignQuery newQuery = new JRDesignQuery();
            newQuery.setText(sql);
            jasd.setQuery(newQuery);
            JasperReport js = JasperCompileManager.compileReport(jasd);
            JasperPrint jp = JasperFillManager.fillReport(js, null, con);
            JasperViewer.viewReport(jp,false);
            
        } catch (JRException ex) {
            Logger.getLogger(ViewReportUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ViewReportUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnUReportActionPerformed

    private void btnRReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRReportActionPerformed
        // TODO add your handling code here:
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/euro_db", "root", "");
            JasperDesign jasd = JRXmlLoader.load("C:\\Users\\dilum\\Documents\\NetBeansProjects\\EUROCarRentalSystem\\src\\main\\java\\GUI\\rental.jrxml");
            String sql = "SELECT * FROM customer c INNER JOIN rental r on r.cusID = c.cusID";
            JRDesignQuery newQuery = new JRDesignQuery();
            newQuery.setText(sql);
            jasd.setQuery(newQuery);
            JasperReport js = JasperCompileManager.compileReport(jasd);
            JasperPrint jp = JasperFillManager.fillReport(js, null, con);
            JasperViewer.viewReport(jp,false);
            
        } catch (JRException ex) {
            Logger.getLogger(ViewReportUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ViewReportUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnRReportActionPerformed

    private void btnRReport1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRReport1ActionPerformed
        // TODO add your handling code here:
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/euro_db", "root", "");
            JasperDesign jasd = JRXmlLoader.load("C:\\Users\\dilum\\Documents\\NetBeansProjects\\EUROCarRentalSystem\\src\\main\\java\\GUI\\supplier.jrxml");
            String sql = "SELECT * FROM vehicle v INNER JOIN supplier s on v.vehicleNo = s.vehicleNo";
            JRDesignQuery newQuery = new JRDesignQuery();
            newQuery.setText(sql);
            jasd.setQuery(newQuery);
            JasperReport js = JasperCompileManager.compileReport(jasd);
            JasperPrint jp = JasperFillManager.fillReport(js, null, con);
            JasperViewer.viewReport(jp,false);
            
        } catch (JRException ex) {
            Logger.getLogger(ViewReportUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ViewReportUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnRReport1ActionPerformed

    private void btnUReport1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUReport1ActionPerformed
        // TODO add your handling code here:
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/euro_db", "root", "");
            JasperDesign jasd = JRXmlLoader.load("C:\\Users\\dilum\\Documents\\NetBeansProjects\\EUROCarRentalSystem\\src\\main\\java\\GUI\\employee.jrxml");
            String sql = "SELECT * FROM employee";
            JRDesignQuery newQuery = new JRDesignQuery();
            newQuery.setText(sql);
            jasd.setQuery(newQuery);
            JasperReport js = JasperCompileManager.compileReport(jasd);
            JasperPrint jp = JasperFillManager.fillReport(js, null, con);
            JasperViewer.viewReport(jp,false);
            
        } catch (JRException ex) {
            Logger.getLogger(ViewReportUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ViewReportUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnUReport1ActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(ViewReportUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewReportUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewReportUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewReportUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewReportUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRReport;
    private javax.swing.JButton btnRReport1;
    private javax.swing.JButton btnUReport;
    private javax.swing.JButton btnUReport1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tblCreport1;
    private javax.swing.JTable tblEreport;
    private javax.swing.JTable tblSreport;
    private javax.swing.JTable tblUreport;
    // End of variables declaration//GEN-END:variables
}
