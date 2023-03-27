package librarysystem_oto;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class WriterForm extends javax.swing.JFrame {

    public WriterForm() {
        initComponents();
        PopulateTable();
    }

    DefaultTableModel model;

    public void PopulateTable() {
        model = (DefaultTableModel) tbl_Writer.getModel();
        model.setRowCount(0);

        try {
            ArrayList<WriterManager> writer = getWriterManager();
            for (WriterManager writers : writer) {
                Object[] row = {writers.getWriterID(), writers.getWriterName(),
                    writers.getWriterLastname()};

                model.addRow(row);
            }
        } catch (Exception exception) {
        }

    }

    public ArrayList<WriterManager> getWriterManager() throws SQLException {
        Connection connection = null;
        dbHelper helper = new dbHelper();
        Statement statement = null;
        ResultSet resultSet;

        ArrayList<WriterManager> writer = null;

        try {
            connection = helper.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM library_systemdb.writer;");

            writer = new ArrayList<WriterManager>();

            while (resultSet.next()) {
                writer.add(new WriterManager(resultSet.getInt("WriterID"),
                        resultSet.getString("WriterName"), resultSet.getString("WriterLastname")));
            }

        } catch (SQLException exception) {
            helper.showErrorMessage(exception);
        } finally {
            statement.close();
            connection.close();
        }

        return writer;
    }

    public void Insert() throws SQLException {
        Connection connection = null;
        dbHelper helper = new dbHelper();
        PreparedStatement statement = null;

        try {
            connection = helper.getConnection();
            String sql = "INSERT INTO `library_systemdb`.`writer` (`WriterName`, `WriterLastname`) VALUES (?,?);";

            statement = connection.prepareStatement(sql);
            statement.setString(1, WriterName.getText());
            statement.setString(2, WriterLastName.getText());

            int result = statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Kayıt Başarıyla Oluşturuldu!");

            PopulateTable();

        } catch (SQLException exception) {
            helper.showErrorMessage(exception);
        } finally {
            statement.close();
            connection.close();
        }
    }

    public void Update() throws SQLException {
        String id, name, lastName;

        id = WriterID.getText();
        name = WriterName.getText();
        lastName = WriterLastName.getText();

        Connection connection = null;
        dbHelper helper = new dbHelper();
        PreparedStatement statement = null;

        try {
            connection = helper.getConnection();
            String sql = ("UPDATE `library_systemdb`.`writer` SET `WriterName` = '" + name + "', `WriterLastname` = '" + lastName + "' WHERE (`WriterID` = '" + id + "');");
            statement = connection.prepareStatement(sql);

            int result = statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Kayıt Başarıyla Güncellendi!");
            PopulateTable();
        } catch (SQLException exception) {
            helper.showErrorMessage(exception);
        } finally {
            statement.close();
            connection.close();
        }
    }

    public void Delete() throws SQLException {
        String id;

        id = WriterID.getText();
        Connection connection = null;
        dbHelper helper = new dbHelper();
        PreparedStatement statement = null;

        try {
            connection = helper.getConnection();
            String sql = ("DELETE FROM `library_systemdb`.`writer` WHERE `WriterID` = '" + id + "'");
            statement = connection.prepareStatement(sql);

            int result = statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Kayıt Başarıyla Silindi!");
            PopulateTable();
        } catch (SQLException exception) {
            helper.showErrorMessage(exception);
        } finally {
            statement.close();
            connection.close();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_Writer = new javax.swing.JTable();
        txt_WriterSearch = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        WriterID = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        WriterName = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        WriterLastName = new javax.swing.JTextField();
        btn_Writer_Update = new javax.swing.JButton();
        btn_Writer_Add = new javax.swing.JButton();
        btn_Writer_Delete = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnHome = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(248, 148, 6));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/librarysystem_oto/images/outline_memory_white_24dp.png"))); // NOI18N

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/librarysystem_oto/images/attribution_FILL0_wght400_GRAD0_opsz48.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Yazar İşlemleri");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(395, 395, 395)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(44, 62, 80));

        tbl_Writer.setBackground(new java.awt.Color(255, 250, 240));
        tbl_Writer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Yazar ID", "Yazar İsmi", "Yazar Soyadı"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_Writer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_WriterMouseClicked(evt);
            }
        });
        tbl_Writer.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbl_WriterKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_Writer);
        if (tbl_Writer.getColumnModel().getColumnCount() > 0) {
            tbl_Writer.getColumnModel().getColumn(0).setResizable(false);
            tbl_Writer.getColumnModel().getColumn(1).setResizable(false);
            tbl_Writer.getColumnModel().getColumn(2).setResizable(false);
        }

        txt_WriterSearch.setBackground(new java.awt.Color(255, 250, 240));
        txt_WriterSearch.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txt_WriterSearch.setText("Aramak istediğiniz metni giriniz.");
        txt_WriterSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_WriterSearchMouseClicked(evt);
            }
        });
        txt_WriterSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_WriterSearchActionPerformed(evt);
            }
        });
        txt_WriterSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_WriterSearchKeyReleased(evt);
            }
        });

        jLabel12.setForeground(new java.awt.Color(236, 240, 241));
        jLabel12.setText("ID:");

        WriterID.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        WriterID.setForeground(new java.awt.Color(255, 250, 240));
        WriterID.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                WriterIDMouseClicked(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(236, 240, 241));
        jLabel7.setText("Yazar ismi:");

        WriterName.setBackground(new java.awt.Color(108, 122, 137));
        WriterName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        WriterName.setForeground(new java.awt.Color(228, 241, 254));
        WriterName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                WriterNameMouseClicked(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(236, 240, 241));
        jLabel8.setText("Yazar Soyadı:");

        WriterLastName.setBackground(new java.awt.Color(108, 122, 137));
        WriterLastName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        WriterLastName.setForeground(new java.awt.Color(228, 241, 254));
        WriterLastName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                WriterLastNameMouseClicked(evt);
            }
        });

        btn_Writer_Update.setBackground(new java.awt.Color(255, 250, 240));
        btn_Writer_Update.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_Writer_Update.setForeground(new java.awt.Color(44, 62, 80));
        btn_Writer_Update.setText("Kayıt Güncelle");
        btn_Writer_Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Writer_UpdateActionPerformed(evt);
            }
        });

        btn_Writer_Add.setBackground(new java.awt.Color(255, 250, 240));
        btn_Writer_Add.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_Writer_Add.setForeground(new java.awt.Color(44, 62, 80));
        btn_Writer_Add.setText("Kayıt Ekle");
        btn_Writer_Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Writer_AddActionPerformed(evt);
            }
        });

        btn_Writer_Delete.setBackground(new java.awt.Color(242, 38, 19));
        btn_Writer_Delete.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_Writer_Delete.setForeground(new java.awt.Color(255, 255, 255));
        btn_Writer_Delete.setText("Kayıt Sil");
        btn_Writer_Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Writer_DeleteActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(44, 62, 80));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("  Ahmet Kılınç");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Yazılım Geliştiricisi");

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/librarysystem_oto/images/library.png"))); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(17, 17, 17))
                            .addComponent(jLabel11))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel14.setBackground(new java.awt.Color(255, 250, 240));
        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Bu sayfada sadece görüntüleme, ekleme, silme işlemlerini kolaylıkla yapabilirsiniz.");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btn_Writer_Add, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_Writer_Update, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(WriterID, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(WriterName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(WriterLastName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(345, 345, 345)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(63, 63, 63))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btn_Writer_Delete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(265, 265, 265)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txt_WriterSearch)
                        .addContainerGap())))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(0, 11, Short.MAX_VALUE)
                                .addComponent(jLabel12))
                            .addComponent(WriterID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(WriterName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(WriterLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_Writer_Update)
                            .addComponent(btn_Writer_Add)))
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_Writer_Delete)
                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_WriterSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(248, 148, 6));

        btnHome.setBackground(new java.awt.Color(44, 62, 80));
        btnHome.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnHome.setForeground(new java.awt.Color(248, 148, 6));
        btnHome.setText("Anasayfa");
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });

        btnExit.setBackground(new java.awt.Color(204, 0, 0));
        btnExit.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnExit.setForeground(new java.awt.Color(255, 255, 255));
        btnExit.setText("Çıkış");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(327, 327, 327)
                .addComponent(btnHome, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                .addGap(236, 236, 236)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHome)
                    .addComponent(btnExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_WriterSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_WriterSearchMouseClicked
        txt_WriterSearch.setText("");
    }//GEN-LAST:event_txt_WriterSearchMouseClicked

    private void txt_WriterSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_WriterSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_WriterSearchActionPerformed

    private void txt_WriterSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_WriterSearchKeyReleased
        String search = txt_WriterSearch.getText();
        TableRowSorter<DefaultTableModel> tableRowSorter = new TableRowSorter<>(model);
        tbl_Writer.setRowSorter(tableRowSorter);
        tableRowSorter.setRowFilter(RowFilter.regexFilter(search));
    }//GEN-LAST:event_txt_WriterSearchKeyReleased

    private void btn_Writer_UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Writer_UpdateActionPerformed
        try {
            Update();
        } catch (SQLException ex) {

        }
    }//GEN-LAST:event_btn_Writer_UpdateActionPerformed

    private void btn_Writer_AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Writer_AddActionPerformed
        try {
            Insert();
        } catch (SQLException ex) {

        }
    }//GEN-LAST:event_btn_Writer_AddActionPerformed

    private void btn_Writer_DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Writer_DeleteActionPerformed
        try {
            Delete();
        } catch (SQLException ex) {

        }
    }//GEN-LAST:event_btn_Writer_DeleteActionPerformed

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        HomePageForm home = new HomePageForm();
        home.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnHomeActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnExitActionPerformed

    private void WriterIDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_WriterIDMouseClicked
        WriterID.setText("");
    }//GEN-LAST:event_WriterIDMouseClicked

    private void WriterNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_WriterNameMouseClicked
        WriterName.setText("");
    }//GEN-LAST:event_WriterNameMouseClicked

    private void WriterLastNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_WriterLastNameMouseClicked
        WriterLastName.setText("");
    }//GEN-LAST:event_WriterLastNameMouseClicked

    private void tbl_WriterKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbl_WriterKeyReleased

    }//GEN-LAST:event_tbl_WriterKeyReleased

    private void tbl_WriterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_WriterMouseClicked
        WriterID.setText(model.getValueAt(tbl_Writer.getSelectedRow(), 0).toString());
        WriterName.setText(model.getValueAt(tbl_Writer.getSelectedRow(), 1).toString());
        WriterLastName.setText(model.getValueAt(tbl_Writer.getSelectedRow(), 2).toString());
    }//GEN-LAST:event_tbl_WriterMouseClicked

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WriterForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel WriterID;
    private javax.swing.JTextField WriterLastName;
    private javax.swing.JTextField WriterName;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btn_Writer_Add;
    private javax.swing.JButton btn_Writer_Delete;
    private javax.swing.JButton btn_Writer_Update;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_Writer;
    private javax.swing.JTextField txt_WriterSearch;
    // End of variables declaration//GEN-END:variables
}
