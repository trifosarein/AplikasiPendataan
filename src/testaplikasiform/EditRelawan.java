/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package testaplikasiform;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Basil
 */
public class EditRelawan extends javax.swing.JFrame {
    Connection con;
    Statement stat;
    ResultSet res;
    
    /**
     * Creates new form EditRelawan
     */
    public EditRelawan() {
        initComponents();
        Koneksi DB = new Koneksi();
        DB.config();
        con = DB.con;
        stat = DB.stat;
        tabel_relawan();
        
        //Set rata kanan kiri form //
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = getSize();
        setLocation(
        (screenSize.width - frameSize.width) / 2,
        (screenSize.height - frameSize.height) / 2);
    }
    
    private void Clear(){
        namaRelawan_TF.setText("");
        idRelawan_TF.setText("");
        nohp_TF.setText("");
        alamat_TA.setText("Maks 150 huruf");
        alamat_TA.setForeground(Color.GRAY);
    }
    
    private void tabel_relawan(){
        DefaultTableModel t = new DefaultTableModel();
        t.addColumn("Nama");
        t.addColumn("Telepon");
        relawan_TBL.setModel(t);
        try{
            res=stat.executeQuery("select * from tb_relawan order by nama_relawan asc");
            while(res.next()){
                t.addRow(new Object[]{
                    res.getString("nama_relawan"),
                    res.getString("telp_relawan"),
                });
            }
        } catch(Exception e){
            JOptionPane.showMessageDialog(rootPane, e);
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        edit_BTN = new javax.swing.JButton();
        namaRelawan_TF = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        nohp_TF = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        delete_BTN = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        alamat_TA = new javax.swing.JTextArea();
        idRelawan_TF = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        relawan_TBL = new javax.swing.JTable()
        {
            public boolean isCellEditable(int rowIndex, int colIndex)
            {
                return false; //Disallow the editing of any cell
            }
        };
        clear_BTN = new javax.swing.JButton();
        home_BTN = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Form Edit Data Relawan");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Nama / ID");

        edit_BTN.setText("Edit");
        edit_BTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edit_BTNActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("No HP");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Alamat");

        delete_BTN.setText("Delete");
        delete_BTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_BTNActionPerformed(evt);
            }
        });

        alamat_TA.setColumns(20);
        alamat_TA.setForeground(java.awt.Color.gray);
        alamat_TA.setLineWrap(true);
        alamat_TA.setRows(5);
        alamat_TA.setText("Maks 150 huruf");
        alamat_TA.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                alamat_TAFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                alamat_TAFocusLost(evt);
            }
        });
        alamat_TA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                alamat_TAKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                alamat_TAKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(alamat_TA);

        idRelawan_TF.setEditable(false);

        jLabel5.setText("/");

        relawan_TBL.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        relawan_TBL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                relawan_TBLMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(relawan_TBL);

        clear_BTN.setText("Clear");
        clear_BTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clear_BTNActionPerformed(evt);
            }
        });

        home_BTN.setText("Home");
        home_BTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                home_BTNActionPerformed(evt);
            }
        });

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Tabel Relawan");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(namaRelawan_TF, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(idRelawan_TF))
                            .addComponent(nohp_TF)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
                        .addGap(0, 74, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(home_BTN, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(clear_BTN, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(edit_BTN, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(delete_BTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(namaRelawan_TF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idRelawan_TF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(nohp_TF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(home_BTN, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clear_BTN, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edit_BTN, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(delete_BTN, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void edit_BTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edit_BTNActionPerformed
        // TODO add your handling code here:
        String alamat = "";
        switch (alamat_TA.getText()){
            case "Maks 150 huruf":
                alamat = "";
                break;
            default:
                alamat = alamat_TA.getText();
                break;
        }
        switch (namaRelawan_TF.getText()){
            case "":
                JOptionPane.showMessageDialog(null, "Kolom Nama / ID tidak boleh kosong!");
                break;
            default:
                int ok=JOptionPane.showConfirmDialog(null,"Apakah anda yakin untuk edit data ini?","Confirmation",JOptionPane.YES_NO_OPTION);
                try{
                    String sql="update tb_relawan set nama_relawan=?,telp_relawan=?,alamat_relawan=? where id_relawan='"+idRelawan_TF.getText()+"'";
                    PreparedStatement st=con.prepareStatement(sql);
                    if(ok==0){
                        try{
                            st.setString(1,namaRelawan_TF.getText());
                            st.setString(2,nohp_TF.getText());
                            st.setString(3,alamat);
                            st.executeUpdate();
                            JOptionPane.showMessageDialog(null,"Update Data Berhasil");
                        } catch(Exception e){
                            JOptionPane.showMessageDialog(null, "Update Data Gagal");
                        }
                    }
                } catch (Exception e){}
                break;
        }
        tabel_relawan();
    }//GEN-LAST:event_edit_BTNActionPerformed

    private void delete_BTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_BTNActionPerformed
        // TODO add your handling code here:
        switch(idRelawan_TF.getText()){
            case "":
                JOptionPane.showMessageDialog(null, "Pilih data yang ingin dihapus terlebih dahulu.");
                break;
            default:
                int ok=JOptionPane.showConfirmDialog(null, "Apakah anda yakin untuk hapus data ini?", "Confirmation", JOptionPane.YES_NO_OPTION);
                if(ok==0){
                    try{
                        String sql="delete from tb_relawan where id_relawan='"+idRelawan_TF.getText()+"'";
                        PreparedStatement st=con.prepareStatement(sql);
                        st.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Delete Data Sukses");
                    } catch(Exception e){
                        JOptionPane.showMessageDialog(null, "Delete Data Gagal");
                    }
                    Clear();
                }
                break;
        }
        tabel_relawan();
    }//GEN-LAST:event_delete_BTNActionPerformed

    private void clear_BTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clear_BTNActionPerformed
        // TODO add your handling code here:
        Clear();
    }//GEN-LAST:event_clear_BTNActionPerformed

    private void home_BTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_home_BTNActionPerformed
        // TODO add your handling code here:
        new HOME().setVisible(true);
        dispose();
    }//GEN-LAST:event_home_BTNActionPerformed

    private void relawan_TBLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_relawan_TBLMouseClicked
        // TODO add your handling code here:
        int i = relawan_TBL.getSelectedRow();
        if(i==-1){
            return;
        }
        String code = (String)relawan_TBL.getValueAt(i,0);
        String code1 = (String)relawan_TBL.getValueAt(i,1);
        String code2 = "";
        String code3 = "";
        try{
            res=stat.executeQuery("select * from tb_relawan where nama_relawan='"+code+"' AND telp_relawan='"+code1+"'");
            while(res.next()){
                code2 = res.getString("id_relawan");
                code3 = res.getString("alamat_relawan");
                
            }
        } catch(Exception e){
            JOptionPane.showMessageDialog(rootPane, e);
        }
        namaRelawan_TF.setText(code);
        idRelawan_TF.setText(code2);
        nohp_TF.setText(code1);
        alamat_TA.setText(code3);
        alamat_TA.setForeground(Color.BLACK);
    }//GEN-LAST:event_relawan_TBLMouseClicked

    private void alamat_TAFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_alamat_TAFocusGained
        // TODO add your handling code here:
        if (alamat_TA.getText().equals("Maks 150 huruf")) {
            alamat_TA.setText("");
            alamat_TA.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_alamat_TAFocusGained

    private void alamat_TAFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_alamat_TAFocusLost
        // TODO add your handling code here:
        if (alamat_TA.getText().isEmpty()) {
            alamat_TA.setForeground(Color.GRAY);
            alamat_TA.setText("Maks 150 huruf");
        }
    }//GEN-LAST:event_alamat_TAFocusLost

    private void alamat_TAKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_alamat_TAKeyTyped
        // TODO add your handling code here:
        if(alamat_TA.getText().length()>=150) {  
            evt.consume();
        }
    }//GEN-LAST:event_alamat_TAKeyTyped

    private void alamat_TAKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_alamat_TAKeyPressed
        // TODO add your handling code here:
        if((evt.getKeyCode() == KeyEvent.VK_V) && ((evt.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
            if(alamat_TA.getText().length()>=150) {  
                evt.consume();
            }
        }
    }//GEN-LAST:event_alamat_TAKeyPressed

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
            java.util.logging.Logger.getLogger(EditRelawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditRelawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditRelawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditRelawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditRelawan().setVisible(true);
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea alamat_TA;
    private javax.swing.JButton clear_BTN;
    private javax.swing.JButton delete_BTN;
    private javax.swing.JButton edit_BTN;
    private javax.swing.JButton home_BTN;
    private javax.swing.JTextField idRelawan_TF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField namaRelawan_TF;
    private javax.swing.JTextField nohp_TF;
    private javax.swing.JTable relawan_TBL;
    // End of variables declaration//GEN-END:variables
}
