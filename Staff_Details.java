
/**
 *
 * @author HP
 */
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;
public class Staff_Details extends javax.swing.JFrame {

    /**
     * Creates new form Staff_Details
     */
    public Staff_Details() {
        initComponents();
        setDefaultCloseOperation(Staff_Details.DISPOSE_ON_CLOSE);
    }


    @SuppressWarnings("unchecked")
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        b1 = new javax.swing.JButton();
        b2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STAFF ID", "NAME", "CONTACT"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        b1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        b1.setText("FETCH");
        b1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b1ActionPerformed(evt);
            }
        });

        b2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        b2.setText("EXIT");
        b2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addComponent(b1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 116, Short.MAX_VALUE)
                .addComponent(b2, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(91, 91, 91))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }

    private void b1ActionPerformed(java.awt.event.ActionEvent evt) {
       DefaultTableModel model= (DefaultTableModel)jTable1.getModel();
       String url="jdbc:mysql://localhost/library";
       String user="root";
       String pwd= "1234";
       String query= "select * from staffs;";
       try
       {
           Connection conn= DriverManager.getConnection(url,user,pwd);
           Statement stm=conn.createStatement();
           ResultSet rs= stm.executeQuery(query);
           while(rs.next())
           {
               String staffid=rs.getString("STAFF_ID");
               String name=rs.getString("NAME");
               int contact =rs.getInt("CONTACT"); 
               model.addRow(new Object[] {staffid,name,contact}); 
           }
           rs.close();
           stm.close(); 
       }
       catch(Exception e){
           JOptionPane.showMessageDialog(this,e.getMessage()); 
       }  

    }
    private void b2ActionPerformed(java.awt.event.ActionEvent evt) {
    
        this.dispose();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Staff_Details.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Staff_Details.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Staff_Details.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Staff_Details.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Staff_Details().setVisible(true);
            }
        });
    }


    private javax.swing.JButton b1;
    private javax.swing.JButton b2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
}