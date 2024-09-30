/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package students;
import student_management.DbConnect;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import com.google.gson.Gson;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import net.glxn.qrgen.core.image.ImageType;
import net.glxn.qrgen.javase.QRCode;
import student_management.DbConnect;
/**
 *
 * @author suhana choudhary
 */
public class ViewStudent extends javax.swing.JFrame {
    String roll;
    /**
     * Creates new form SearchByRollNumber
     */
    public ViewStudent() {
        initComponents();
        
        try{
            Connection con=DbConnect.connect();
            PreparedStatement ps=con.prepareStatement("select * from studdata");
            ResultSet rs=ps.executeQuery();
            
            while(rs.next()){
                c3.addItem(rs.getString(2));
                String name=rs.getString(1);//name
                String rollno=rs.getString(2);//rollno
                String email=rs.getString(3);//email
                String XII=rs.getString(4);//class xii
                String course=rs.getString(5);//course
                
                String aadhar=rs.getString(6);//aadhar
                String address=rs.getString(7);//address
                String fname=rs.getString(8);//father name
                String dob=rs.getString(9);//date of birth
                String phone=rs.getString(10);//phone
                String x=rs.getString(11);//class x
                String branch=rs.getString(12);
                
                String tbData[]={name,rollno, email, XII, course, aadhar, address,fname, dob, phone, x, branch};
                    
                DefaultTableModel tb1Model=(DefaultTableModel)tab.getModel();
                tb1Model.addRow(tbData);
                    }
            }
            catch(Exception e){
                    
            }
        
    }
    
    public void clearTable(JTable table){
        DefaultTableModel model=(DefaultTableModel)table.getModel();
        model.setRowCount(0);
    }
    
    public ImageIcon resizePic(String pic) {
        ImageIcon myimg = new ImageIcon(pic);
        Image img = myimg.getImage().getScaledInstance(myImage.getWidth(), myImage.getHeight(), Image.SCALE_SMOOTH);
        return new ImageIcon(img);
    }
    
    public ImageIcon resizePic(byte[] pic){
        ImageIcon myimg =new ImageIcon(pic);
        Image img = myimg.getImage().getScaledInstance(myImage.getWidth(),myImage.getHeight(),Image.SCALE_SMOOTH);
        return new ImageIcon(img);
    }
    
    public byte[] convertImageIconToByteArray(Icon icon){
        //buffer image in java is the type of image representation in memory
        BufferedImage bufferedImage=new BufferedImage(
                icon.getIconWidth(),
                icon.getIconHeight(),
                BufferedImage.TYPE_INT_RGB
                
        );
        //paint the image icon to the buffered
        icon.paintIcon(null,bufferedImage.getGraphics(),0,0);
        //convert buffer image to byte[]
        ByteArrayOutputStream baos=new ByteArrayOutputStream();
        
        try{
            //to write the image to output stream
            ImageIO.write(bufferedImage, "png", baos) ;  //change format as needed
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return baos.toByteArray();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        search = new javax.swing.JButton();
        print = new javax.swing.JButton();
        add = new javax.swing.JButton();
        update = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tab = new javax.swing.JTable();
        downloadQR = new javax.swing.JButton();
        back = new javax.swing.JButton();
        c3 = new javax.swing.JComboBox<>();
        myImage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 0), 4));

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel1.setText("Search by Roll number");

        search.setBackground(new java.awt.Color(255, 102, 0));
        search.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        search.setForeground(new java.awt.Color(255, 255, 255));
        search.setText("Search");
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });

        print.setBackground(new java.awt.Color(255, 102, 0));
        print.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        print.setForeground(new java.awt.Color(255, 255, 255));
        print.setText("Print");
        print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printActionPerformed(evt);
            }
        });

        add.setBackground(new java.awt.Color(255, 102, 0));
        add.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        add.setForeground(new java.awt.Color(255, 255, 255));
        add.setText("Add");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        update.setBackground(new java.awt.Color(255, 102, 0));
        update.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        update.setForeground(new java.awt.Color(255, 255, 255));
        update.setText("Update");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        delete.setBackground(new java.awt.Color(255, 102, 0));
        delete.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        delete.setForeground(new java.awt.Color(255, 255, 255));
        delete.setText("Delete");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        tab.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "name", "rollno", "email", "XII(%)", "course", "adhaar no", "address", "fname", "DOB", "phone", "X(%)", "branch"
            }
        ));
        tab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tab);

        downloadQR.setBackground(new java.awt.Color(255, 102, 0));
        downloadQR.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        downloadQR.setForeground(new java.awt.Color(255, 255, 255));
        downloadQR.setText("Download QR");
        downloadQR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                downloadQRActionPerformed(evt);
            }
        });

        back.setBackground(new java.awt.Color(255, 102, 0));
        back.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        back.setForeground(new java.awt.Color(255, 255, 255));
        back.setText("Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        c3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        c3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 0), 2));

        myImage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 0), 2));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 723, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(myImage, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(downloadQR, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(36, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(c3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 148, Short.MAX_VALUE)
                                .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(print, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(253, 253, 253))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(354, 354, 354)
                .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(c3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(search, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(print, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(add, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(update, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(delete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(myImage, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(downloadQR, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(back)
                .addGap(34, 34, 34))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(23, 23, 23))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        // TODO add your handling code here:
        clearTable(tab);
        myImage.setIcon(null);
        try{
            Connection con=DbConnect.connect();
            PreparedStatement ps=con.prepareStatement("select * from studdata where rollno=?");
            ps.setString(1,c3.getSelectedItem().toString());
            ResultSet rs=ps.executeQuery();
            
            while(rs.next()){
                String name=rs.getString(1);  //name
                String rollno=rs.getString(2);  //rollno
                 roll=rs.getString(2);
                 String email=rs.getString(3);  //email
                 String  XII=rs.getString(4);  //xii percentage
                 String course=rs.getString(5);  //course name
                 String aadhar=rs.getString(6); //aadhar no
                  String address=rs.getString(7); //address
                  String fname=rs.getString(8);  //father name
                  String dob=rs.getString(9);  //date of birth
                  String phone=rs.getString(10);  //phone no
                  String x=rs.getString(11);  //x per
                  String branch=rs.getString(12);  //branch of course
                  
                  byte[] img=rs.getBytes(14);
                  myImage.setIcon(resizePic(img));
                  
                  String tbData[]={name,rollno, email, XII, course, aadhar, address,fname, dob, phone, x, branch};
                    
                DefaultTableModel tb1Model=(DefaultTableModel)tab.getModel();
                tb1Model.addRow(tbData);
                 
            }
        }
            catch(Exception e){
                    
            }        
    }//GEN-LAST:event_searchActionPerformed
    
    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        // TODO add your handling code here:
          //delete the data
          new  DeleteStudent().setVisible(true);
    }//GEN-LAST:event_deleteActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        // TODO add your handling code here:
        new AddStudents().setVisible(true);
    }//GEN-LAST:event_addActionPerformed

    private void printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printActionPerformed
        // TODO add your handling code here:
        try{
            tab.print();
        }catch(Exception e){
            System.out.println(e);
        }
    }//GEN-LAST:event_printActionPerformed

    private void downloadQRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_downloadQRActionPerformed
        // TODO add your handling code here:
        try{
            //get the byte form of image
            byte[] img=convertImageIconToByteArray(myImage.getIcon());
            //read the byte data
            ByteArrayInputStream bis=new ByteArrayInputStream(img);
            //convert the data into the buffer-->to hold the pixel data of image
            BufferedImage bImage=ImageIO.read(bis);
            File outputFile =new File("F:/stud/"+".jpeg");
            ImageIO.write(bImage, "pmg", outputFile);
            JOptionPane.showMessageDialog(null, "image saved"+outputFile.getAbsolutePath());
            
        }
        catch(Exception e){
            System.out.println(e);
            //e.printStackTrace();
        }
    }//GEN-LAST:event_downloadQRActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        // TODO add your handling code here:
        new UpdateStudent().setVisible(true);
    }//GEN-LAST:event_updateActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_backActionPerformed

    private void tabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabMouseClicked
        // TODO add your handling code here:
        
            myImage.setIcon(null);
            int index=tab.getSelectedRow();
            TableModel model=tab.getModel();
            String rollno=model.getValueAt(index,1).toString();
            roll=rollno;
            
            try{
                Connection con=DbConnect.connect();
                PreparedStatement ps=con.prepareStatement("select * from studdata where rollno=?");
                ps.setString(1,rollno);
                ResultSet rs=ps.executeQuery();
                
                while(rs.next()){
                    System.out.println(rollno);
                    byte[] img=rs.getBytes("qr");
                    myImage.setIcon(resizePic(img));
                }
            }
            catch(Exception e){
                e.printStackTrace();
            }
    }//GEN-LAST:event_tabMouseClicked

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
            java.util.logging.Logger.getLogger(ViewStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewStudent().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JButton back;
    private javax.swing.JComboBox<String> c3;
    private javax.swing.JButton delete;
    private javax.swing.JButton downloadQR;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel myImage;
    private javax.swing.JButton print;
    private javax.swing.JButton search;
    private javax.swing.JTable tab;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
