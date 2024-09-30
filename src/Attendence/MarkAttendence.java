/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Attendence;
import java.lang.reflect.Type; 
import java.sql.*;
import com.github.sarxos.webcam.*;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;
import javax.swing.*;
import student_management.DbConnect;

public class MarkAttendence extends javax.swing.JFrame implements Runnable , ThreadFactory {
   
        private WebcamPanel p1 = null;
        private Webcam w1 = null;
        private ExecutorService  e = Executors.newSingleThreadExecutor(this);    
        private boolean webcamOpen = true;

    public MarkAttendence() {
        initComponents();
        
        initWebcam();
        Timer t = new Timer(1, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                update();
            }
        }); 
        t.start();
    }
    
    //webcam open
    private void initWebcam() {
//         get the webcam object from the camera
        w1 = Webcam.getDefault();
//        checking if there is webcam or not
        if(w1 != null){
//            returns the visible current size that can be captured in pixels
            Dimension[] reso = w1.getViewSizes();
//            get the length
            Dimension maxRes = reso[reso.length - 1];
//            if webcam was open beforehand then close it
            if(w1.isOpen()){
                w1.close();
            }
//            set the size of webcam
System.out.println("webcamera opened............");
            w1.setViewSize(new Dimension(640,480));
//            and then open it
            w1.open();
//            create a panel for the webcam and set its size
            p1 = new WebcamPanel(w1);
            p1.setSize(maxRes);
            p1.setFPSDisplayed(true);  //frame per second display =>display the image
            webPanel.add(p1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0,
                            0,
                            700,
                            700));
            
            
            webcamOpen= true;
            e.execute(this);
        }
        else{
            JOptionPane.showMessageDialog(null,
                    "Some issue arise");
        }
    }
    
    //updation
   public void update(){
       SimpleDateFormat  s = new SimpleDateFormat("yyyy-MM-dd");
       lab1.setText(s.format(new Date()));
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lab = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        stop = new javax.swing.JButton();
        start = new javax.swing.JButton();
        back = new javax.swing.JButton();
        lab1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        webPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 255), 4));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Mark Attendence");

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 255));
        jLabel2.setText("Date   :");

        lab.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        lab.setForeground(new java.awt.Color(0, 51, 255));
        lab.setText("Name  :");

        jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 51, 255));
        jLabel4.setText("Roll No  :");

        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 51, 255));
        jLabel5.setText("------WEBCAM------");

        stop.setBackground(new java.awt.Color(153, 0, 204));
        stop.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        stop.setForeground(new java.awt.Color(255, 255, 255));
        stop.setText("Stop");
        stop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopActionPerformed(evt);
            }
        });

        start.setBackground(new java.awt.Color(153, 0, 204));
        start.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        start.setForeground(new java.awt.Color(255, 255, 255));
        start.setText("Start");
        start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startActionPerformed(evt);
            }
        });

        back.setBackground(new java.awt.Color(153, 0, 204));
        back.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        back.setForeground(new java.awt.Color(255, 255, 255));
        back.setText("Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        lab1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lab1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 102, 255), 2));

        jLabel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 102, 255), 2));

        jLabel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 102, 255), 2));

        webPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 255), 2));

        javax.swing.GroupLayout webPanelLayout = new javax.swing.GroupLayout(webPanel);
        webPanel.setLayout(webPanelLayout);
        webPanelLayout.setHorizontalGroup(
            webPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 349, Short.MAX_VALUE)
        );
        webPanelLayout.setVerticalGroup(
            webPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 296, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lab1, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(webPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(31, 31, 31)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(lab, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(0, 143, Short.MAX_VALUE)
                                        .addComponent(stop, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(103, 103, 103)
                                        .addComponent(start, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(60, 60, 60))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(138, 138, 138))))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(165, 165, 165))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lab1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lab, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(52, 52, 52)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(stop, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(start, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(webPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
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
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void stopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopActionPerformed
        // TODO add your handling code here:   
        w1.close();
        webcamOpen = false; 
    }//GEN-LAST:event_stopActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_backActionPerformed

    private void startActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startActionPerformed
        // TODO add your handling code here:
        
        if (!webcamOpen) {    //start the webcam
                    initWebcam();
                }

    }//GEN-LAST:event_startActionPerformed

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
            java.util.logging.Logger.getLogger(MarkAttendence.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MarkAttendence.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MarkAttendence.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MarkAttendence.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MarkAttendence().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lab;
    private javax.swing.JLabel lab1;
    private javax.swing.JButton start;
    private javax.swing.JButton stop;
    private javax.swing.JPanel webPanel;
    // End of variables declaration//GEN-END:variables

    
    Map<String,String> resultMap = new HashMap<String,String>();

    @Override
    public void run() {   
    do {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            Result res = null;
            BufferedImage image = null;  //bufferedImage=>store image in pixel format

            if (w1.isOpen()) {
                image = w1.getImage();
                if (image == null) {
                    System.out.println("No image captured from webcam");
                    continue;
                }

                LuminanceSource source = new BufferedImageLuminanceSource(image);//capture image and 
                //eliminate the light portion of image and convert it into black and white formate
                
                //remove further color of image and present it into black and white color and convert it into 
                //bit format
                BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source)); 

                try {
                    res = new MultiFormatReader().decode(bitmap);
                    if (res != null) {
                        System.out.println("QR Code Text: " + res.getText());
//                        jLabel4.setText(res.getText());
                       resultMap = convertJsonToMap(res.getText());
                       System.out.println(resultMap.get("rollno"));
                       lab1.setText(resultMap.get("name"));
                       jLabel7.setText(resultMap.get("rollno"));
                        
                        w1.close();
                        webcamOpen = false;
                        presentAttend(resultMap.get("rollno"));
                        System.out.println("QR Code detected and displayed");
                    } else {
                        System.out.println("No QR Code detected");
                    }
                } catch (com.google.zxing.NotFoundException e) {
                    // Handle the case where no QR code is found in the image
                    System.out.println(e);
                    System.out.println("No QR code found in the image");
                } catch (Exception e) {
                    // Print other exceptions for debugging
                    e.printStackTrace();
                }
            } else {
                System.out.println("Webcam is not open");
            }
        } catch (Exception e) {
            // Print the exception stack trace for debugging
            e.printStackTrace();
        }
    } while (true);
 }
    
    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r,"my thread");
        t.setDaemon(true);
        return t;
    }

    private Map<String, String> convertJsonToMap(String json) {
        Gson gson = new Gson();
        
        //type of hashmap
        java.lang.reflect.Type   type = new TypeToken<Map<String, String>>() {}.getType();
        return gson.fromJson(json, type);
    }
    
    public void presentAttend(String rollno){
        try{
            Connection con = DbConnect.connect();
            PreparedStatement p1 = con.prepareStatement("select * from attendence where rollno=? ");
            p1.setString(1,rollno);
            ResultSet rs = p1.executeQuery();
//            System.out.println(rs);
//            if(rs.next()==true){
            while(rs.next()){
     
                    if(rs.getString("pa").equalsIgnoreCase("-") ){
//                        update the attendence of that roll number
                            System.out.println("pa = - ");
                           PreparedStatement a1 = con.prepareStatement("update attendence set date = ? , pa = ? where rollno = ?");
                           
                           a1.setString(1,lab.getText());
                           a1.setString(2,"present");
                           a1.setString(3,rollno);
                           
                            int a = a1.executeUpdate();
                            
                            if(a==1){
                                JOptionPane.showMessageDialog(null,
                                        resultMap.get("name")+" is marked present ");
                            }
                            
                           
                            else{
                                JOptionPane.showMessageDialog(null,"Some Error");
                            }
                    }
                    else if(!rs.getString("date").equalsIgnoreCase(lab1.getText()) ){
                        
                    System.out.println("pa = -       "+rs.getString("date"));

                             String qry = "insert into attendence values(?,?,?)";
                                PreparedStatement ps = con.prepareStatement(qry);
                                
                                ps.setString(1,rollno);
                                ps.setString(2,lab.getText());
                                ps.setString(3,"present");

                                int av = ps.executeUpdate();
                                if(av==1){
                                    JOptionPane.showMessageDialog(null,
                                            resultMap.get("name")+" is marked present ");
                                }
                                else{
                                    JOptionPane.showMessageDialog(null,"Some Error");
                                }
                            }
                    
                    
                    else{
                        JOptionPane.showMessageDialog(null,  resultMap.get("name")+
                       "  is already marked present");
                    }
               }
        }
        catch(Exception e){
            System.out.print(e);
}
}
}
