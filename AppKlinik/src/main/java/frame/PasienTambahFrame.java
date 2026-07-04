package frame;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import koneksi.Koneksi;

public class PasienTambahFrame extends javax.swing.JFrame {

    private String idPasien = "";
    public PasienTambahFrame() {
        initComponents();
        setLocationRelativeTo(null);
        setListener();
    }
    public PasienTambahFrame(String id, String nama, String jk, String tgl, String alamat, String telp, String keluhan) {
     initComponents();
     setLocationRelativeTo(null);
     this.idPasien = id;
     txtNama.setText(nama);
     cmbJenisKelamin.setSelectedItem(jk);
     txtTglLahir.setText(tgl);
     txtAlamat.setText(alamat);
     txtNoTelp.setText(telp);
     txtKeluhan.setText(keluhan);

     btnSimpan.setText("Update");
     setListener();
    }
    public void kosongkanForm() {
    txtNama.setText("");
    if (cmbJenisKelamin != null) {
        cmbJenisKelamin.setSelectedIndex(0);
    }
    txtAlamat.setText("");
    txtNoTelp.setText("");
    txtKeluhan.setText(""); 
    txtNama.requestFocus(); 
    }
    public void setListener() {
        btnSimpan.addActionListener((e) -> {
         String nama = txtNama.getText();
         String jk = cmbJenisKelamin.getSelectedItem().toString(); 
         String tglLahir = txtTglLahir.getText(); 
         String alamat = txtAlamat.getText();
         String noTelp = txtNoTelp.getText();
         String keluhan = txtKeluhan.getText();

         if (nama.isEmpty()) {
             JOptionPane.showMessageDialog(null, "Nama pasien wajib diisi!");
             return;
         }

         try {
             Koneksi konek = new Koneksi();
             Connection conn = konek.getConnection();

             if (idPasien.isEmpty()) {
                 // LOGIKA INSERT (TAMBAH DATA BARU)
                 String sql = "INSERT INTO pasien (nama_pasien, jenis_kelamin, tgl_lahir, alamat, no_telp, keluhan) VALUES (?, ?, ?, ?, ?, ?)";
                 PreparedStatement pst = conn.prepareStatement(sql);
                 pst.setString(1, nama);
                 pst.setString(2, jk);
                 pst.setString(3, tglLahir);
                 pst.setString(4, alamat);
                 pst.setString(5, noTelp);
                 pst.setString(6, keluhan);
                 pst.executeUpdate();
                 JOptionPane.showMessageDialog(null, "Data pasien berhasil disimpan!");
             } else {
                 // LOGIKA UPDATE (UBAH DATA LAMA)
                 String sql = "UPDATE pasien SET nama_pasien=?, jenis_kelamin=?, tgl_lahir=?, alamat=?, no_telp=?, keluhan=? WHERE id_pasien=?";
                 PreparedStatement pst = conn.prepareStatement(sql);
                 pst.setString(1, nama);
                 pst.setString(2, jk);
                 pst.setString(3, tglLahir);
                 pst.setString(4, alamat);
                 pst.setString(5, noTelp);
                 pst.setString(6, keluhan);
                 pst.setString(7, idPasien);
                 pst.executeUpdate();
                 JOptionPane.showMessageDialog(null, "Data pasien berhasil diupdate!");
                 kosongkanForm();
             }

             conn.close();
             dispose(); 

         } catch (Exception ex) {
             JOptionPane.showMessageDialog(null, "Gagal memproses data: " + ex.getMessage());
         }
     });

        // Logika Tombol Batal
        btnBatal.addActionListener((e) -> {
            dispose(); // Menutup form tanpa menyimpan
        });
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnSimpan = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();
        txtNama = new javax.swing.JTextField();
        cmbJenisKelamin = new javax.swing.JComboBox<>();
        txtTglLahir = new javax.swing.JTextField();
        txtAlamat = new javax.swing.JTextField();
        txtNoTelp = new javax.swing.JTextField();
        txtKeluhan = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("FORM TAMBAH PASIEN");
        jLabel1.setToolTipText("");

        jLabel2.setText("Nama Pasien   :");

        jLabel3.setText("Jenis Kelamin  :");

        jLabel4.setText("Tgl Lahir          :");

        jLabel5.setText("Alamat            :");

        jLabel6.setText("No Telp           :");

        jLabel7.setText(" Keluhan          :");

        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        btnBatal.setText("Batal");

        txtNama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNamaActionPerformed(evt);
            }
        });

        cmbJenisKelamin.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Laki-laki", "Perempuan" }));

        txtTglLahir.setText("YYYY-MM-DD");
        txtTglLahir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTglLahirActionPerformed(evt);
            }
        });

        txtNoTelp.setText("0812-3456-7890");

        txtKeluhan.setText("...");
        txtKeluhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKeluhanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(256, 256, 256))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNama)
                            .addComponent(cmbJenisKelamin, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtTglLahir)
                            .addComponent(txtAlamat)
                            .addComponent(txtNoTelp, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
                            .addComponent(txtKeluhan)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(205, 205, 205)
                        .addComponent(btnSimpan)
                        .addGap(137, 137, 137)
                        .addComponent(btnBatal)))
                .addContainerGap(67, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cmbJenisKelamin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtTglLahir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtNoTelp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtKeluhan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSimpan)
                    .addComponent(btnBatal))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTglLahirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTglLahirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTglLahirActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void txtNamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNamaActionPerformed

    private void txtKeluhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKeluhanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtKeluhanActionPerformed

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
            java.util.logging.Logger.getLogger(PasienTambahFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PasienTambahFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PasienTambahFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PasienTambahFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PasienTambahFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JComboBox<String> cmbJenisKelamin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField txtAlamat;
    private javax.swing.JTextField txtKeluhan;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtNoTelp;
    private javax.swing.JTextField txtTglLahir;
    // End of variables declaration//GEN-END:variables
}
