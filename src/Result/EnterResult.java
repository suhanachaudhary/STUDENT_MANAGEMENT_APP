
package Result;

import java.sql.*;
import javax.swing.JOptionPane;
import student_management.DbConnect;
import java.util.*;
import java.awt.*;
import javax.swing.JTextField;
import com.google.gson.Gson;
import org.bridj.util.Pair;
import javax.swing.JFrame;



public class EnterResult extends javax.swing.JFrame {
int x;
int num;
int s=0;
ArrayList<Pair<String,Integer>> p1;
private ArrayList<Pair<JTextField, JTextField>> jField = new ArrayList<>();
    
    public EnterResult() {
        initComponents();
        try{
            Connection con=DbConnect.connect();
            PreparedStatement ps=con.prepareStatement("select * from studdata");
            ResultSet rs=ps.executeQuery();
            
            while(rs.next()){
                c1.addItem(rs.getString("rollno"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        s1 = new javax.swing.JTextField();
        n1 = new javax.swing.JTextField();
        s2 = new javax.swing.JTextField();
        n2 = new javax.swing.JTextField();
        s3 = new javax.swing.JTextField();
        n3 = new javax.swing.JTextField();
        s4 = new javax.swing.JTextField();
        n4 = new javax.swing.JTextField();
        s5 = new javax.swing.JTextField();
        n5 = new javax.swing.JTextField();
        addMore = new javax.swing.JButton();
        submit = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        c1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 102, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 6));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(102, 102, 255));
        jPanel2.setLayout(new java.awt.GridLayout(x, 2, 10, 10));

        s1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s1ActionPerformed(evt);
            }
        });
        jPanel2.add(s1);

        n1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                n1ActionPerformed(evt);
            }
        });
        jPanel2.add(n1);

        s2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s2ActionPerformed(evt);
            }
        });
        jPanel2.add(s2);

        n2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                n2ActionPerformed(evt);
            }
        });
        jPanel2.add(n2);

        s3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s3ActionPerformed(evt);
            }
        });
        jPanel2.add(s3);

        n3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                n3ActionPerformed(evt);
            }
        });
        jPanel2.add(n3);

        s4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s4ActionPerformed(evt);
            }
        });
        jPanel2.add(s4);

        n4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                n4ActionPerformed(evt);
            }
        });
        jPanel2.add(n4);

        s5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s5ActionPerformed(evt);
            }
        });
        jPanel2.add(s5);

        n5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                n5ActionPerformed(evt);
            }
        });
        jPanel2.add(n5);

        jScrollPane1.setViewportView(jPanel2);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 133, 520, 340));

        addMore.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        addMore.setForeground(new java.awt.Color(51, 102, 255));
        addMore.setText("Add More");
        addMore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addMoreActionPerformed(evt);
            }
        });
        jPanel1.add(addMore, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 490, 150, 50));

        submit.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        submit.setForeground(new java.awt.Color(51, 102, 255));
        submit.setText("Submit");
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });
        jPanel1.add(submit, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 490, 150, 50));

        jButton3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButton3.setForeground(new java.awt.Color(51, 102, 255));
        jButton3.setText("Cancel");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 490, 140, 50));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Search by : ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 130, 40));

        jPanel1.add(c1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, 380, 40));

        jLabel1.setBackground(new java.awt.Color(51, 102, 255));
        jLabel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 4), "Enter Result", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 0, 36), new java.awt.Color(255, 255, 255))); // NOI18N
        jLabel1.setOpaque(true);
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 670, 510));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 709, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 558, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void s1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s1ActionPerformed

    private void n1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_n1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_n1ActionPerformed

    private void s2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s2ActionPerformed

    private void n2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_n2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_n2ActionPerformed

    private void s3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s3ActionPerformed

    private void n3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_n3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_n3ActionPerformed

    private void s4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s4ActionPerformed

    private void n4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_n4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_n4ActionPerformed

    private void s5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s5ActionPerformed

    private void n5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_n5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_n5ActionPerformed

    private void addMoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addMoreActionPerformed
        // TODO add your handling code here:
        try{
            //enter number of additional subject
            num=Integer.parseInt(JOptionPane.showInputDialog("Enter the number of subject you want to add"));
           //increment the rows
            x=5+num;
            //initialize jfield arraylist
            jField=new ArrayList<Pair<javax.swing.JTextField, javax.swing.JTextField>>();
            
            int top=410;
            
            for(int i=0;i<num;i++){
                top+=60;
                javax.swing.JTextField newj;
                javax.swing.JTextField newm;
                
                newj=new javax.swing.JTextField();
                newj.setFont(new  java.awt.Font("Segoe UI",0,10)); 
                newj.setForeground(new java.awt.Color(0,0,102));
                newj.setOpaque(true);
                //add the subject textfiel in panel2 scrollpane
                jPanel2.add(newj,new org.netbeans.lib.awtextra.AbsoluteConstraints(60,top,210,40));
                
                newm=new javax.swing.JTextField();
                newm.setFont(new  java.awt.Font("Segoe UI",0,10)); 
                newm.setForeground(new java.awt.Color(0,0,102));
                newm.setOpaque(true);
                //add the marks textfield in panel 2 scrollpane
                jPanel2.add(newm,new org.netbeans.lib.awtextra.AbsoluteConstraints(340,top,210,40));
               
                
                jField.add(new Pair<javax.swing.JTextField, javax.swing.JTextField>(newj,newm));
            }
            s=num;
            //revalidate and repaint the panel to reflect the new components
            jPanel2.setPreferredSize(new java.awt.Dimension(jPanel2.getWidth(),top+100));
            jPanel2.revalidate();
            jPanel2.repaint();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_addMoreActionPerformed

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
        // TODO add your handling code here:
        try{
                //p1 = new ArrayList<Pair<String,Integer>>();
                p1 = new ArrayList<Pair<String, Integer>>();

               p1.add(new Pair<String,Integer>(s1.getText(),Integer.parseInt(n1.getText())));
               p1.add(new Pair<String,Integer>(s2.getText(),Integer.parseInt(n2.getText())));
               p1.add(new Pair<String,Integer>(s3.getText(),Integer.parseInt(n3.getText())));
               p1.add(new Pair<String,Integer>(s4.getText(),Integer.parseInt(n4.getText())));
               p1.add(new Pair<String,Integer>(s5.getText(),Integer.parseInt(n5.getText())));

             if(jField!=null){
               //    System.out.println(jfield);
               for(Pair<JTextField, JTextField> pair : jField){
                 JTextField sub = pair.getKey(); // key
                 JTextField mark = pair.getValue();//value
                 // Get the text from the JTextField key
                 String subStr = sub.getText();
                 String markStr = mark.getText();
                p1.add(new Pair<String,Integer>(subStr,Integer.parseInt(markStr)));

                 // Print the text from the key JTextField
                 System.out.println("subject : " + subStr);         
                 System.out.println("marks : " + markStr);         
               }
              }
                 System.out.println(p1);
                 Gson gson = new Gson();
                 String json = gson.toJson(p1);
                     Connection con = DbConnect.connect();
                     PreparedStatement ps = con.prepareStatement("insert into result values(?,?)");
                     ps.setString(1,c1.getSelectedItem().toString());
                     ps.setString(2,json);
                     int a = ps.executeUpdate();

                     if(a==1){
                         JOptionPane.showMessageDialog(null, "Result declared Successfully");
                     }
                     else{
                         JOptionPane.showMessageDialog(null, "Some Error ... try again later");
                     }
             }
            catch(Exception e){
                System.out.println(e);
    }
    }//GEN-LAST:event_submitActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EnterResult().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addMore;
    private javax.swing.JComboBox<String> c1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField n1;
    private javax.swing.JTextField n2;
    private javax.swing.JTextField n3;
    private javax.swing.JTextField n4;
    private javax.swing.JTextField n5;
    private javax.swing.JTextField s1;
    private javax.swing.JTextField s2;
    private javax.swing.JTextField s3;
    private javax.swing.JTextField s4;
    private javax.swing.JTextField s5;
    private javax.swing.JButton submit;
    // End of variables declaration//GEN-END:variables
}
