package Rm;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;
public class loading extends javax.swing.JFrame {
    static db_conn d=new db_conn();
    static loading l=new loading();
    
    public loading() {
        
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pb = new javax.swing.JProgressBar();
        pl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(708, 500));
        setUndecorated(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Rm/Restaurant-Management-System-2.png"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(-360, 0, 1070, 440);
        jPanel1.add(pb);
        pb.setBounds(0, 490, 700, 20);

        pl.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        pl.setHorizontalTextPosition(pl.LEFT);
        pl.setVerticalTextPosition(pl.BOTTOM);
        pl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Rm/30.gif"))); // NOI18N
        jPanel1.add(pl);
        pl.setBounds(0, 450, 692, 40);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
       
    }//GEN-LAST:event_formWindowOpened

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        if(!d.close()){
            JOptionPane.showMessageDialog(null,""+d.error(),"ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_formWindowClosed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(loading.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>
         
        
        boolean r=true;
        l.setVisible(true);
        try
        {
            
            for(int i=0;i<=100;i++)
            {
                Thread.sleep(35);  //35
                l.pb.setValue(i);
                l.pb.setString("LOADING............"+i+"%");
                //l.pl.setText("Please Wait");
                l.pb.setStringPainted(true);
                    if(i==1){
                        l.pl.setText("Please Wait Opening Software");
                    }
                    //for  database Checking 
                   if(i==30){
                       l.pl.setText("Checking Database Connection");
                        if(d.check_conn()==false){
                            r=false;
                            JOptionPane.showMessageDialog(null,""+d.error());
                            l.dispose();
                        }
                    }
                   //for new database making 
                   if(i==40){
                       l.pl.setText("Checking Database");     
                       if(d.check_db()==false){
        
                            d.query="create table waiter(id varchar(50),password varchar(50),name varchar(50),gender varchar(7),address varchar(50),contact Bigint(15))";
                            d.Table();
                            d.query="create table admin(id varchar(50),password varchar(50),name varchar(50),gender varchar(7),address varchar(50),contact Bigint(15))";
                            d.Table();
                            d.query="create table dish(name varchar(50),rupees int)";
                            d.Table();
                            d.query="create table payment(Year int,January int,February int,March int,April int,May int,June int,July int,August int,September int,October int,November int,December int)";
                            d.Table();
                            
                            //inserting Default values
                            d.query="insert into waiter values('w','w','Waiter','Male','Delhi',1234567890)";
                            d.update();
                            d.query="insert into admin values('root','toor','Anonymous','Human','Earth',1234567890)";
                            d.update();
                            d.query="insert into dish values('Pizza',150)";
                            d.update();
                            
                        
                        int date=0,month=0,year=0,tt=1;
                        StringTokenizer t = new StringTokenizer(DateTimeFormatter.ofPattern("dd MM yyyy").format(LocalDate.now())); 
                            
                            while(t.hasMoreTokens()){    
                            switch(tt){
                                case 1:
                                    date=Integer.parseInt(t.nextToken());
                                    tt++;
                                    break;
                                case 2:
                                    month=Integer.parseInt(t.nextToken());
                                    tt++;
                                    break;
                                case 3:
                                    year=Integer.parseInt(t.nextToken());
                                    tt++;
                                    break;
                            }
                            } 
                        // getting all row from payment table
                        d.query="select year from payment";
                        ResultSet rs=d.select();
                        boolean r_s=false;
                        //checking one by one
                        while(rs.next()){
                            if(rs.getInt(1)==year){
                                r_s=true;
                                break;
                            }
                        }
                        
                        if(r_s==false){
                                d.query="insert into payment(year) values(?)";
                                d.a.add(year);
                                d.update();
                        } 
                      }     
                   }
                   if(i==50){
                            
                   }
                   if(i==70){
                         
                   }
                    if(i==85){
                        l.pl.setText("Welcome");
                    }
                    if(i==100){
                        if(r){
                            l.dispose();
                            new home().setVisible(true);
                        }
                    }
                   
            }
        }
        catch(SQLException e){
                            
        }
        catch(InterruptedException e){
            System.out.println(e);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar pb;
    private javax.swing.JLabel pl;
    // End of variables declaration//GEN-END:variables
}
