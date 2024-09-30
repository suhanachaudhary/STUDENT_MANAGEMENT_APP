
package Result;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.awt.Graphics;
import java.awt.PrintJob;
import java.awt.Toolkit;
import student_management.DbConnect;
import java.sql.*;
import java.util.ArrayList;
import org.bridj.util.Pair;

public class Result extends javax.swing.JFrame {
    int x;

    public Result() {
        initComponents();
        try{
            Connection con=DbConnect.connect();
                PreparedStatement ps=con.prepareStatement("select * from studdata");
                ResultSet rs=ps.executeQuery();
                while(rs.next()){
                    c1.addItem(rs.getString("rollno"));
                 }
    }catch(Exception e){
        System.out.println(e);
    }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        c1 = new javax.swing.JComboBox<>();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 102, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 4));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(102, 102, 255));
        jPanel2.setLayout(new java.awt.GridLayout(x, 2, 10, 0));
        jScrollPane1.setViewportView(jPanel2);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 146, 584, 305));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Search by : ");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, 129, 39));

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(51, 51, 255));
        jButton1.setText("Print");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 480, 138, -1));

        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButton2.setForeground(new java.awt.Color(51, 51, 255));
        jButton2.setText("Cancel");
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 480, 133, -1));

        jLabel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 6), "Result", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 0, 36), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 20, 690, 490));

        c1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c1ActionPerformed(evt);
            }
        });
        jPanel1.add(c1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 90, 420, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 741, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        //print button :    
        Toolkit tkp = jPanel2.getToolkit();
       PrintJob pjp = tkp.getPrintJob(this, null, null);
       Graphics g = pjp.getGraphics();                                                                                                                                                                    
       jPanel2.print(g);
       g.dispose();
 pjp.end();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void c1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c1ActionPerformed
        // TODO add your handling code here:
        try {
        Connection con = DbConnect.connect();
        PreparedStatement ps = con.prepareStatement("select * from result where" +
                " rollno = ?");
        ps.setString(1, c1.getSelectedItem().toString());
        
        ResultSet rs = ps.executeQuery();
        
        if (rs.next()) {
            String json = rs.getString("subject"); //[]

            // Convert JSON string back to ArrayList of Pairs
            Gson gson = new Gson(); 
            java.lang.reflect.Type listType = new TypeToken<ArrayList<Pair<String, Integer>>>
        (){}.getType();
            ArrayList<Pair<String, Integer>> p1 = gson.fromJson(json, listType);

            // Remove all existing components from jPanel2
            jPanel2.removeAll();

            // Use p1 as needed
            
            x = 0;
            for (Pair<String, Integer> pair : p1) {
                    x++;
                    javax.swing.JTextField newj=new javax.swing.JTextField();
                    javax.swing.JTextField newm=new javax.swing.JTextField();
                    newj.setEditable(false);
                    newm.setEditable(false);
                    
//                javax.swing.JLabel newj = new javax.swing.JLabel();
//                newj.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
//                newj.setForeground(new java.awt.Color(0, 0, 102));

                newj.setOpaque(true);
                 newm.setOpaque(true);
                newj.setText(pair.getKey() );
                newm.setText(pair.getValue().toString());
                jPanel2.add(newj);
                jPanel2.add(newm);
            }
            
            // Update jPanel2's layout
            jPanel2.setLayout(new java.awt.GridLayout(x, 2, 20, 20));
            jPanel2.revalidate();
            jPanel2.repaint();
        }
    } catch (Exception e) {
        e.printStackTrace();

}
    }//GEN-LAST:event_c1ActionPerformed

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Result().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> c1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
