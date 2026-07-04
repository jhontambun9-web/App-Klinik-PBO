package frame;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import koneksi.Koneksi;

public class PasienTampilFrame extends javax.swing.JFrame {

    public PasienTampilFrame() {
        initComponents();
        setLocationRelativeTo(null); 
        resetTable("");             
        setListener();
    }
    public void resetTable(String keyword) {
        try {
            Koneksi konek = new Koneksi();
            Connection conn = konek.getConnection();

            DefaultTableModel model = new DefaultTableModel();
            model.setColumnIdentifiers(new String[]{
                "ID Pasien", "Nama Pasien", "Jenis Kelamin", "Tgl Lahir", "Alamat", "No Telp", "Keluhan"
            });

            String sql = "SELECT * FROM pasien" + keyword;
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("id_pasien"),
                    rs.getString("nama_pasien"),
                    rs.getString("jenis_kelamin"),
                    rs.getDate("tgl_lahir"),
                    rs.getString("alamat"),
                    rs.getString("no_telp"),
                    rs.getString("keluhan")
                });
            }

            tabelPasien.setModel(model);
            conn.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal menampilkan data: " + e.getMessage());
        }
    }
    public void setListener() {
        // Logika Tombol Ubah
        btnUbah.addActionListener((e) -> {
            int row = tabelPasien.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(null, "Pilih data yang ingin diubah terlebih dahulu dari tabel!");
                return;
            }
            String id = String.valueOf(tabelPasien.getValueAt(row, 0));
            String nama = String.valueOf(tabelPasien.getValueAt(row, 1));
            String jk = String.valueOf(tabelPasien.getValueAt(row, 2));
            String tgl = String.valueOf(tabelPasien.getValueAt(row, 3));
            String alamat = String.valueOf(tabelPasien.getValueAt(row, 4));
            String telp = String.valueOf(tabelPasien.getValueAt(row, 5));
            String keluhan = String.valueOf(tabelPasien.getValueAt(row, 6));

            // Membuka form Tambah namun menggunakan mode Update (data terisi otomatis)
            PasienTambahFrame ubahFrame = new PasienTambahFrame(id, nama, jk, tgl, alamat, telp, keluhan);
            ubahFrame.setVisible(true);
        });
        
        // Logika Tombol Cari
        btnCari.addActionListener((e) -> {
            resetTable(" WHERE nama_pasien LIKE '%" + txtCari.getText() + "%'");
        });

        // Logika Tombol Batal (Refresh)
        btnBatal.addActionListener((e) -> {
            txtCari.setText("");
            resetTable("");
        });

        // Logika Tombol Tutup
        btnTutup.addActionListener((e) -> {
            dispose();
        });

        // Logika Tombol Hapus
        btnHapus.addActionListener((e) -> {
            int row = tabelPasien.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(null, "Pilih data yang ingin dihapus terlebih dahulu!");
                return;
            }

            int id = Integer.parseInt(tabelPasien.getValueAt(row, 0).toString());
            int konfirmasi = JOptionPane.showConfirmDialog(null, "Yakin ingin menghapus data ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);

            if (konfirmasi == JOptionPane.YES_OPTION) {
                try {
                    Koneksi konek = new Koneksi();
                    Connection conn = konek.getConnection();

                    String sql = "DELETE FROM pasien WHERE id_pasien = ?";
                    PreparedStatement pst = conn.prepareStatement(sql);
                    pst.setInt(1, id);
                    pst.executeUpdate();

                    JOptionPane.showMessageDialog(null, "Data berhasil dihapus!");
                    resetTable("");
                    conn.close();

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Gagal menghapus data: " + ex.getMessage());
                }
            }
        });

        // Logika Tombol Tambah
        btnTambah.addActionListener((e) -> {
            PasienTambahFrame tambahFrame = new PasienTambahFrame();
            tambahFrame.setVisible(true);
        });
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtCari = new javax.swing.JTextField();
        btnCari = new javax.swing.JButton();
        btnTambah = new javax.swing.JButton();
        btnUbah = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();
        btnTutup = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelPasien = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jLabel1.setText("Cari Pasien  :");

        txtCari.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCari.setText("...");
        txtCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCariActionPerformed(evt);
            }
        });

        btnCari.setText("Cari");
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });

        btnTambah.setText("Tambah");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        btnUbah.setText("Ubah");

        btnHapus.setText("Hapus");

        btnBatal.setText("Batal");

        btnTutup.setText("Tutup");

        tabelPasien.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tabelPasien);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCari)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCari, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 629, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnUbah)
                        .addGap(28, 28, 28)
                        .addComponent(btnHapus)
                        .addGap(31, 31, 31)
                        .addComponent(btnBatal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnTutup)))
                .addGap(0, 19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCari))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTambah)
                    .addComponent(btnUbah)
                    .addComponent(btnHapus)
                    .addComponent(btnBatal)
                    .addComponent(btnTutup))
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCariActionPerformed

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCariActionPerformed

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTambahActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
       resetTable("");
    }//GEN-LAST:event_formWindowActivated

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
            java.util.logging.Logger.getLogger(PasienTampilFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PasienTampilFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PasienTampilFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PasienTampilFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PasienTampilFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnTambah;
    private javax.swing.JButton btnTutup;
    private javax.swing.JButton btnUbah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabelPasien;
    private javax.swing.JTextField txtCari;
    // End of variables declaration//GEN-END:variables
}
