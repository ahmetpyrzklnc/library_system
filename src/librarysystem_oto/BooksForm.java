package librarysystem_oto;


import LibrarySystem_oto.HomePageForm;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class BooksForm extends javax.swing.JFrame {

    public BooksForm() {
        initComponents();
        PopulateTable();
    }

    DefaultTableModel model;

    public void PopulateTable() {
        model = (DefaultTableModel) tbl_book.getModel();
        model.setRowCount(0);

        try {
            ArrayList<BooksManager> book = getBooksManager();
            for (BooksManager books : book) {
                Object[] row = {books.getBookID(), books.getBookName(),
                    books.getBookNumber_of_Pages(), books.getBook_is_selected(),
                    books.getWriterID(), books.getBookTypeID()};

                model.addRow(row);

            }
        } catch (Exception exception) {

        }

    }

    public ArrayList<BooksManager> getBooksManager() throws SQLException {
        Connection connection = null;
        dbHelper helper = new dbHelper();
        Statement statement = null;
        ResultSet resultSet;

        ArrayList<BooksManager> books = null;

        try {
            connection = helper.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM library_systemdb.books;");

            books = new ArrayList<BooksManager>();

            while (resultSet.next()) {
                books.add(new BooksManager(resultSet.getInt("BookID"),
                        resultSet.getString("BookName"), resultSet.getInt("BookNumber_of_Pages"),
                        resultSet.getBoolean("Book_is_selected"), resultSet.getInt("WriterID"),
                        resultSet.getInt("BookTypeID")));
            }
        } catch (SQLException exception) {
            helper.showErrorMessage(exception);
        } finally {
            statement.close();
            connection.close();
        }

        return books;
    }

    public void Insert() throws SQLException {
        Connection connection = null;
        dbHelper helper = new dbHelper();
        PreparedStatement statement = null;

        try {
            connection = helper.getConnection();
            String sql = "INSERT INTO `library_systemdb`.`books` (`BookName`, `BookNumber_of_Pages`, `Book_is_Selected`, `WriterID`, `BookTypeID`)"
                    + " VALUES (?,?,?,?,?);";

            statement = connection.prepareStatement(sql);
            statement.setString(1, BookName.getText());
            statement.setInt(2, Integer.valueOf(PageOfNumber.getText()));
            statement.setByte(3, Byte.valueOf(txtDurum.getText()));
            statement.setInt(4, Integer.valueOf(txt_WriterID.getText()));
            statement.setInt(5, Integer.valueOf(txt_BookTypeID.getText()));

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

        String id, bookName, page, selected, writerID, BookTypeID;

        id = BookID.getText();
        bookName = BookName.getText();
        page = PageOfNumber.getText();
        selected = txtDurum.getText().toString();
        writerID = txt_WriterID.getText();
        BookTypeID = txt_BookTypeID.getText();

        Connection connection = null;
        dbHelper helper = new dbHelper();
        PreparedStatement statement = null;

        try {
            connection = helper.getConnection();
            String sql = ("UPDATE `library_systemdb`.`books` SET `BookName` = '" + bookName + "', `BookNumber_of_Pages` = '" + page + "', `Book_is_Selected` = '" + selected + "', `WriterID` = '" + writerID + "', `BookTypeID` = '" + BookTypeID + "' WHERE (`BookID` = '" + id + "');");
            statement = connection.prepareStatement(sql);

            int result = statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Kayıt Başarıyla Güncellendi.");
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

        id = BookID.getText();
        Connection connection = null;
        dbHelper helper = new dbHelper();
        PreparedStatement statement = null;

        try {
            connection = helper.getConnection();
            String sql = ("DELETE FROM `library_systemdb`.`books` WHERE `BookID` = '" + id + "'");
            statement = connection.prepareStatement(sql);

            int result = statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Kayıt Başarıyla Silindi.");
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_book = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        BookID = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        BookName = new javax.swing.JTextField();
        txt_BookSearch = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        PageOfNumber = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtDurum = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txt_WriterID = new javax.swing.JTextField();
        btn_Book_Update = new javax.swing.JButton();
        btn_Book_Add = new javax.swing.JButton();
        btn_Book_Delete = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txt_BookTypeID = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btnHome = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(248, 148, 6));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Kitap İşlemleri");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/librarysystem_oto/images/outline_memory_white_24dp.png"))); // NOI18N

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/librarysystem_oto/images/library_books_.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(305, 305, 305)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(44, 62, 80));

        tbl_book.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Kitap ID", "Kitap İsmi", "Sayfa Sayısı", "Durum", "Yazar ID", "Kitap Türü ID"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Boolean.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_book.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_bookMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_book);
        if (tbl_book.getColumnModel().getColumnCount() > 0) {
            tbl_book.getColumnModel().getColumn(0).setResizable(false);
            tbl_book.getColumnModel().getColumn(1).setResizable(false);
            tbl_book.getColumnModel().getColumn(2).setResizable(false);
            tbl_book.getColumnModel().getColumn(3).setResizable(false);
            tbl_book.getColumnModel().getColumn(4).setResizable(false);
            tbl_book.getColumnModel().getColumn(5).setResizable(false);
        }

        jLabel12.setForeground(new java.awt.Color(236, 240, 241));
        jLabel12.setText("ID:");

        BookID.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        BookID.setForeground(new java.awt.Color(255, 250, 240));
        BookID.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BookIDMouseClicked(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(236, 240, 241));
        jLabel7.setText("Kitap İsmi:");

        BookName.setBackground(new java.awt.Color(108, 122, 137));
        BookName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        BookName.setForeground(new java.awt.Color(228, 241, 254));
        BookName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BookNameMouseClicked(evt);
            }
        });
        BookName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BookNameActionPerformed(evt);
            }
        });

        txt_BookSearch.setBackground(new java.awt.Color(255, 250, 240));
        txt_BookSearch.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txt_BookSearch.setText("Aramak istediğiniz metni giriniz.");
        txt_BookSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_BookSearchMouseClicked(evt);
            }
        });
        txt_BookSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_BookSearchActionPerformed(evt);
            }
        });
        txt_BookSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_BookSearchKeyReleased(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(236, 240, 241));
        jLabel8.setText("Sayfa Sayısı:");

        PageOfNumber.setBackground(new java.awt.Color(108, 122, 137));
        PageOfNumber.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        PageOfNumber.setForeground(new java.awt.Color(228, 241, 254));
        PageOfNumber.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PageOfNumberMouseClicked(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(236, 240, 241));
        jLabel9.setText("Durum:");

        txtDurum.setBackground(new java.awt.Color(108, 122, 137));
        txtDurum.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtDurum.setForeground(new java.awt.Color(228, 241, 254));
        txtDurum.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtDurumMouseClicked(evt);
            }
        });
        txtDurum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDurumActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(236, 240, 241));
        jLabel10.setText("YazarID");

        txt_WriterID.setBackground(new java.awt.Color(108, 122, 137));
        txt_WriterID.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_WriterID.setForeground(new java.awt.Color(228, 241, 254));
        txt_WriterID.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_WriterIDMouseClicked(evt);
            }
        });
        txt_WriterID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_WriterIDActionPerformed(evt);
            }
        });

        btn_Book_Update.setBackground(new java.awt.Color(255, 250, 240));
        btn_Book_Update.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_Book_Update.setForeground(new java.awt.Color(44, 62, 80));
        btn_Book_Update.setText("Kayıt Güncelle");
        btn_Book_Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Book_UpdateActionPerformed(evt);
            }
        });

        btn_Book_Add.setBackground(new java.awt.Color(255, 250, 240));
        btn_Book_Add.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_Book_Add.setForeground(new java.awt.Color(44, 62, 80));
        btn_Book_Add.setText("Kayıt Ekle");
        btn_Book_Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Book_AddActionPerformed(evt);
            }
        });

        btn_Book_Delete.setBackground(new java.awt.Color(242, 38, 19));
        btn_Book_Delete.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_Book_Delete.setForeground(new java.awt.Color(255, 255, 255));
        btn_Book_Delete.setText("Kayıt Sil");
        btn_Book_Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Book_DeleteActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(44, 62, 80));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("  Ahmet Kılınç");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Yazılım Geliştiricisi");

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/librarysystem_oto/images/library.png"))); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addGap(17, 17, 17))
                            .addComponent(jLabel13))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Bu sayfada Kitap işlemlerini gerçekleştirebilirsiniz.");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(236, 240, 241));
        jLabel15.setText("Kitap Türü ID:");

        txt_BookTypeID.setBackground(new java.awt.Color(108, 122, 137));
        txt_BookTypeID.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_BookTypeID.setForeground(new java.awt.Color(228, 241, 254));
        txt_BookTypeID.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_BookTypeIDMouseClicked(evt);
            }
        });
        txt_BookTypeID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_BookTypeIDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txt_BookSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 762, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(PageOfNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(38, 38, 38)
                                        .addComponent(txtDurum, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(BookID, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(BookName, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_BookTypeID, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_WriterID, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(btn_Book_Add)
                                .addGap(18, 18, 18)
                                .addComponent(btn_Book_Update)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_Book_Delete, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(167, 167, 167)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BookID, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BookName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PageOfNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDurum))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_WriterID)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_BookTypeID))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Book_Add)
                    .addComponent(btn_Book_Update)
                    .addComponent(btn_Book_Delete)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_BookSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(196, 196, 196)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
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

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        HomePageForm home = new HomePageForm();
        home.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnHomeActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnExitActionPerformed

    private void txt_BookSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_BookSearchMouseClicked
        txt_BookSearch.setText("");
    }//GEN-LAST:event_txt_BookSearchMouseClicked

    private void txt_BookSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_BookSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_BookSearchActionPerformed

    private void txt_BookSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_BookSearchKeyReleased
        String search = txt_BookSearch.getText();
        TableRowSorter<DefaultTableModel> tableRowSorter = new TableRowSorter<>(model);
        tbl_book.setRowSorter(tableRowSorter);
        tableRowSorter.setRowFilter(RowFilter.regexFilter(search));
    }//GEN-LAST:event_txt_BookSearchKeyReleased

    private void BookNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BookNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BookNameActionPerformed

    private void txtDurumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDurumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDurumActionPerformed

    private void txt_WriterIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_WriterIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_WriterIDActionPerformed

    private void btn_Book_UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Book_UpdateActionPerformed
        try {
            Update();
        } catch (SQLException ex) {

        }
    }//GEN-LAST:event_btn_Book_UpdateActionPerformed

    private void btn_Book_AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Book_AddActionPerformed
        try {
            Insert();
        } catch (SQLException ex) {

        }
    }//GEN-LAST:event_btn_Book_AddActionPerformed

    private void btn_Book_DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Book_DeleteActionPerformed
        try {
            Delete();
        } catch (SQLException ex) {

        }
    }//GEN-LAST:event_btn_Book_DeleteActionPerformed

    private void BookIDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BookIDMouseClicked
        BookID.setText("");
    }//GEN-LAST:event_BookIDMouseClicked

    private void BookNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BookNameMouseClicked
        BookName.setText("");
    }//GEN-LAST:event_BookNameMouseClicked

    private void PageOfNumberMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PageOfNumberMouseClicked
        PageOfNumber.setText("");
    }//GEN-LAST:event_PageOfNumberMouseClicked

    private void txtDurumMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDurumMouseClicked
        txtDurum.setText("");
    }//GEN-LAST:event_txtDurumMouseClicked

    private void txt_WriterIDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_WriterIDMouseClicked
        txt_WriterID.setText("");
    }//GEN-LAST:event_txt_WriterIDMouseClicked

    private void tbl_bookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_bookMouseClicked
        BookID.setText(model.getValueAt(tbl_book.getSelectedRow(), 0).toString());
        BookName.setText(model.getValueAt(tbl_book.getSelectedRow(), 1).toString());
        PageOfNumber.setText(model.getValueAt(tbl_book.getSelectedRow(), 2).toString());
        txtDurum.setText(model.getValueAt(tbl_book.getSelectedRow(), 3).toString());
        txt_WriterID.setText(model.getValueAt(tbl_book.getSelectedRow(), 4).toString());
        txt_BookTypeID.setText(model.getValueAt(tbl_book.getSelectedRow(), 5).toString());
    }//GEN-LAST:event_tbl_bookMouseClicked

    private void txt_BookTypeIDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_BookTypeIDMouseClicked
        txt_BookTypeID.setText("");
    }//GEN-LAST:event_txt_BookTypeIDMouseClicked

    private void txt_BookTypeIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_BookTypeIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_BookTypeIDActionPerformed

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
            java.util.logging.Logger.getLogger(BooksForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BooksForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BooksForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BooksForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BooksForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BookID;
    private javax.swing.JTextField BookName;
    private javax.swing.JTextField PageOfNumber;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btn_Book_Add;
    private javax.swing.JButton btn_Book_Delete;
    private javax.swing.JButton btn_Book_Update;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_book;
    private javax.swing.JTextField txtDurum;
    private javax.swing.JTextField txt_BookSearch;
    private javax.swing.JTextField txt_BookTypeID;
    private javax.swing.JTextField txt_WriterID;
    // End of variables declaration//GEN-END:variables
}
