package librarysystem_oto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class ProcessFormScreen extends javax.swing.JFrame {

    public ProcessFormScreen() {
        initComponents();
        PopulateProcessTable();
        PopulateBookTypeTable();
        PopulateBooksTable();
        PopulateStudentsTable();
        PopulateWriterTable();
        PopulateUserTable();
    }

    DefaultTableModel model;

    public void PopulateProcessTable() {
        model = (DefaultTableModel) tbl_process.getModel();
        model.setRowCount(0);

        try {
            ArrayList<ProcessManager> process = getProcessManager();
            for (ProcessManager processes : process) {
                Object[] row = {processes.getProcessID(), processes.getUserID(), processes.getStudentID(),
                    processes.getBookID(), processes.getWriterID(), processes.getBookTypeID(),
                    processes.getReceivedDate(), processes.getGiveDate()};

                model.addRow(row);
            }
        } catch (Exception e) {

        }

    }

    public ArrayList<ProcessManager> getProcessManager() throws SQLException {
        Connection connection = null;
        dbHelper helper = new dbHelper();
        Statement statement = null;
        ResultSet resultSet;

        ArrayList<ProcessManager> process = null;

        try {
            connection = helper.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM library_systemdb.process;");

            process = new ArrayList<ProcessManager>();

            while (resultSet.next()) {
                process.add(new ProcessManager(resultSet.getInt("ProcessID"), resultSet.getInt("UserID"),
                        resultSet.getInt("StudentID"),
                        resultSet.getInt("BookID"),
                        resultSet.getInt("WriterID"), resultSet.getInt("BookTypeID"),
                        resultSet.getObject("ReceivedDate"), resultSet.getObject("GiveDate")));
            }
        } catch (SQLException exception) {
            helper.showErrorMessage(exception);
        } finally {
            statement.close();
            connection.close();
        }
        return process;
    }

    //-----
    public void PopulateBookTypeTable() {
        model = (DefaultTableModel) tbl_bookType.getModel();
        model.setRowCount(0);

        try {
            ArrayList<BookTypeManager> booktype = getBookTypeManager();
            for (BookTypeManager booktypes : booktype) {
                Object[] row = {booktypes.getBookTypeID(), booktypes.getBookTypeName()};

                model.addRow(row);
            }
        } catch (Exception exception) {

        }

    }

    public ArrayList<BookTypeManager> getBookTypeManager() throws SQLException {
        Connection connection = null;
        dbHelper helper = new dbHelper();
        Statement statement = null;
        ResultSet resultSet;

        ArrayList<BookTypeManager> booktype = null;

        try {
            connection = helper.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM library_systemdb.booktype");

            booktype = new ArrayList<BookTypeManager>();

            while (resultSet.next()) {
                booktype.add(new BookTypeManager(resultSet.getInt("BookTypeID"), resultSet.getString("BookTypeName")));
            }
        } catch (SQLException exception) {
            helper.showErrorMessage(exception);
        } finally {
            statement.close();
            connection.close();
        }

        return booktype;
    }

    //-----
    public void PopulateBooksTable() {
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

    //-----
    public void PopulateStudentsTable() {
        model = (DefaultTableModel) tbl_Student.getModel();
        model.setRowCount(0);

        try {
            ArrayList<StudentManager> student = getStudentManager();
            for (StudentManager students : student) {
                Object[] row = {students.getStudentID(), students.getStudentName(),
                    students.getStudentLastName(), students.getStudentGender(),
                    students.getStudentBirtday(), students.getStudentPoint()};

                model.addRow(row);
            }
        } catch (Exception exception) {

        }

    }

    public ArrayList<StudentManager> getStudentManager() throws SQLException {
        Connection connection = null;
        dbHelper helper = new dbHelper();
        Statement statement = null;
        ResultSet resultSet;

        ArrayList<StudentManager> student = null;

        try {
            connection = helper.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM library_systemdb.students;");

            student = new ArrayList<StudentManager>();

            while (resultSet.next()) {
                student.add(new StudentManager(resultSet.getInt("StudentID"),
                        resultSet.getString("StudentName"), resultSet.getString("StudentLastName"),
                        resultSet.getString("StudentGender"), resultSet.getObject("StudentBirthday"),
                        resultSet.getInt("StudentPoint")));
            }
        } catch (SQLException exception) {
            helper.showErrorMessage(exception);
        } finally {
            statement.close();
            connection.close();
        }

        return student;

    }

    //-----
    public void PopulateWriterTable() {
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

    //---
    public void PopulateUserTable() {
        model = (DefaultTableModel) tbl_Login.getModel();
        model.setRowCount(0);

        try {
            ArrayList<UserManager> user = getUserManager();
            for (UserManager users : user) {
                Object[] row = {users.getUserID(), users.getUserName(),
                    users.getUserLastName()};

                model.addRow(row);
            }
        } catch (Exception exception) {

        }

    }

    public ArrayList<UserManager> getUserManager() throws SQLException {
        Connection connection = null;
        dbHelper helper = new dbHelper();
        Statement statement = null;
        ResultSet resultSet;

        ArrayList<UserManager> user = null;

        try {
            connection = helper.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM library_systemdb.users;");

            user = new ArrayList<UserManager>();

            while (resultSet.next()) {
                user.add(new UserManager(resultSet.getInt("UserID"),
                        resultSet.getString("UserName"),
                        resultSet.getString("UserLastName"),
                        resultSet.getString("UserPassword")));

            }
        } catch (SQLException exception) {
            helper.showErrorMessage(exception);
        } finally {
            statement.close();
            connection.close();
        }

        return user;

    }

    //------**************** CRUD WORKES *****************---------------//
    public void Insert() throws SQLException {
        Connection connection = null;
        dbHelper helper = new dbHelper();
        PreparedStatement statement = null;

        try {
            connection = helper.getConnection();
            String sql = "INSERT INTO `library_systemdb`.`process` (`UserID`, `StudentID`, `BookID`, `WriterID`, `BookTypeID`, `ReceivedDate`, `GiveDate`)"
                    + "VALUES (?,?,?,?,?,?,?);";

            statement = connection.prepareStatement(sql);
            statement.setString(1, Process_LoginID.getText());
            statement.setString(2, Process_StudentID.getText());
            statement.setString(3, ProcessBookID.getText());
            statement.setString(4, ProcessWriterID.getText());
            statement.setString(5, Process_BookTypeID.getText());
            statement.setString(6, Process_ReceivedDate.getText());
            statement.setString(7, Process_GiveDate.getText());

            int result = statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Kayıt Başarıyla Oluşturuldu!");
            PopulateProcessTable();
        } catch (SQLException exception) {
            helper.showErrorMessage(exception);
        } finally {
            statement.close();
            connection.close();
        }
    }

    public void Update() throws SQLException {

        String process_id, user_id, student_id, book_id, writer_id, bookType_id, received_date, give_date;

        process_id = ProcessID.getText();
        user_id = Process_LoginID.getText();
        student_id = Process_StudentID.getText();
        book_id = ProcessBookID.getText();
        writer_id = ProcessWriterID.getText();
        bookType_id = Process_BookTypeID.getText();
        received_date = Process_ReceivedDate.getText();
        give_date = Process_GiveDate.getText();

        Connection connection = null;
        dbHelper helper = new dbHelper();
        PreparedStatement statement = null;

        try {
            connection = helper.getConnection();
            String sql = ("UPDATE `library_systemdb`.`process` SET `UserID` = '" + user_id + "', `StudentID` = '" + student_id + "', `BookID` = '" + book_id + "',`WriterID` = '" + writer_id + "', `BookTypeID` = '" + bookType_id + "', `ReceivedDate` = '" + received_date + "', `GiveDate` = '" + give_date + "' WHERE (`ProcessID` = '" + process_id + "');");
            statement = connection.prepareStatement(sql);

            int result = statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Kayıt Başarıyla Güncellendi!");
            PopulateProcessTable();
        } catch (SQLException exception) {
            helper.showErrorMessage(exception);
        } finally {
            statement.close();
            connection.close();
        }
    }

    public void Delete() throws SQLException {
        String Process_id;

        Process_id = ProcessID.getText();
        Connection connection = null;
        dbHelper helper = new dbHelper();
        PreparedStatement statement = null;

        try {
            connection = helper.getConnection();
            String sql = ("DELETE FROM `library_systemdb`.`process` WHERE (`ProcessID` = '" + Process_id + "');");
            statement = connection.prepareStatement(sql);
            PopulateProcessTable();

            int result = statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Kayıt Başarıyla Silindi!");
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
        btnHome = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_book = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_bookType = new javax.swing.JTable();
        txt_BookSearch = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_Writer = new javax.swing.JTable();
        txt_WriterSearch = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbl_Login = new javax.swing.JTable();
        txt_LoginSearch = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbl_Student = new javax.swing.JTable();
        txt_StudentSearch = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tbl_process = new javax.swing.JTable();
        txt_processSearch = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btn_Process_Add = new javax.swing.JButton();
        btn_Process_Update = new javax.swing.JButton();
        btn_Process_Delete = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        ProcessID = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        Process_LoginID = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        ProcessBookID = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        ProcessWriterID = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        Process_BookTypeID = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        Process_ReceivedDate = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        Process_GiveDate = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        Process_StudentID = new javax.swing.JTextField();
        txt_BookTypeSearch = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(248, 148, 6));

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(589, 589, 589)
                .addComponent(btnHome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(464, 464, 464)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHome)
                    .addComponent(btnExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(248, 148, 6));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Kütüphane Analizi");

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/librarysystem_oto/images/outline_memory_white_24dp.png"))); // NOI18N

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/librarysystem_oto/images/library_books_.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(957, 957, 957)
                .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                false, false, false, true, false, true
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

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Kitap Listesi");

        tbl_bookType.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Kitap Türü ID", "Kitap Türü İsmi"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_bookType.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_bookTypeMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_bookType);

        txt_BookSearch.setBackground(new java.awt.Color(255, 250, 240));
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

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Kitap Türleri Listesi");

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
        jScrollPane3.setViewportView(tbl_Writer);
        if (tbl_Writer.getColumnModel().getColumnCount() > 0) {
            tbl_Writer.getColumnModel().getColumn(0).setResizable(false);
            tbl_Writer.getColumnModel().getColumn(1).setResizable(false);
            tbl_Writer.getColumnModel().getColumn(2).setResizable(false);
        }

        txt_WriterSearch.setBackground(new java.awt.Color(255, 250, 240));
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

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Yazar Listesi");

        tbl_Login.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Kullanıcı ID", "Kullanıcı Adı", "Kullanıcı Soyadı"
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
        tbl_Login.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_LoginMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tbl_Login);
        if (tbl_Login.getColumnModel().getColumnCount() > 0) {
            tbl_Login.getColumnModel().getColumn(0).setResizable(false);
            tbl_Login.getColumnModel().getColumn(1).setResizable(false);
            tbl_Login.getColumnModel().getColumn(2).setResizable(false);
        }

        txt_LoginSearch.setBackground(new java.awt.Color(255, 250, 240));
        txt_LoginSearch.setText("Aramak istediğiniz metni giriniz.");
        txt_LoginSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_LoginSearchMouseClicked(evt);
            }
        });
        txt_LoginSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_LoginSearchActionPerformed(evt);
            }
        });
        txt_LoginSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_LoginSearchKeyReleased(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Kullanıcı Listesi");

        tbl_Student.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Öğr_ID", "Öğr_İsmi", "Öğr_Soyadı", "Cinsiyet", "Doğum Tarihi", "Öğr_Puanı"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_Student.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_StudentMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tbl_Student);
        if (tbl_Student.getColumnModel().getColumnCount() > 0) {
            tbl_Student.getColumnModel().getColumn(1).setResizable(false);
        }

        txt_StudentSearch.setBackground(new java.awt.Color(255, 250, 240));
        txt_StudentSearch.setText("Aramak istediğiniz metni giriniz.");
        txt_StudentSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_StudentSearchMouseClicked(evt);
            }
        });
        txt_StudentSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_StudentSearchActionPerformed(evt);
            }
        });
        txt_StudentSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_StudentSearchKeyReleased(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Öğrenci Listesi");

        tbl_process.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Kayıt ID", "Kullanıcı ID", "Öğrenci ID", "Kitap ID", "Yazar ID", "Kitap Türü ID", "Alınma Tarihi", "Verilme Tarihi"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_process.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_processMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tbl_process);
        if (tbl_process.getColumnModel().getColumnCount() > 0) {
            tbl_process.getColumnModel().getColumn(0).setResizable(false);
            tbl_process.getColumnModel().getColumn(1).setResizable(false);
            tbl_process.getColumnModel().getColumn(2).setResizable(false);
            tbl_process.getColumnModel().getColumn(3).setResizable(false);
            tbl_process.getColumnModel().getColumn(4).setResizable(false);
            tbl_process.getColumnModel().getColumn(5).setResizable(false);
            tbl_process.getColumnModel().getColumn(6).setResizable(false);
            tbl_process.getColumnModel().getColumn(7).setResizable(false);
        }

        txt_processSearch.setBackground(new java.awt.Color(255, 250, 240));
        txt_processSearch.setText("Aramak istediğiniz metni giriniz.");
        txt_processSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_processSearchMouseClicked(evt);
            }
        });
        txt_processSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_processSearchActionPerformed(evt);
            }
        });
        txt_processSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_processSearchKeyReleased(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(248, 148, 6));
        jLabel7.setText("Kayıt Geçmişi");

        btn_Process_Add.setBackground(new java.awt.Color(255, 250, 240));
        btn_Process_Add.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_Process_Add.setForeground(new java.awt.Color(44, 62, 80));
        btn_Process_Add.setText("Kayıt Ekle");
        btn_Process_Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Process_AddActionPerformed(evt);
            }
        });

        btn_Process_Update.setBackground(new java.awt.Color(255, 250, 240));
        btn_Process_Update.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_Process_Update.setForeground(new java.awt.Color(44, 62, 80));
        btn_Process_Update.setText("Kayıt Güncelle");
        btn_Process_Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Process_UpdateActionPerformed(evt);
            }
        });

        btn_Process_Delete.setBackground(new java.awt.Color(242, 38, 19));
        btn_Process_Delete.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_Process_Delete.setForeground(new java.awt.Color(255, 255, 255));
        btn_Process_Delete.setText("Kayıt Sil");
        btn_Process_Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Process_DeleteActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(236, 240, 241));
        jLabel12.setText("ID:");

        ProcessID.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        ProcessID.setForeground(new java.awt.Color(255, 250, 240));
        ProcessID.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ProcessIDMouseClicked(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(236, 240, 241));
        jLabel8.setText("Kullanıcı ID:");

        Process_LoginID.setBackground(new java.awt.Color(108, 122, 137));
        Process_LoginID.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Process_LoginID.setForeground(new java.awt.Color(228, 241, 254));
        Process_LoginID.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Process_LoginIDMouseClicked(evt);
            }
        });
        Process_LoginID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Process_LoginIDActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(236, 240, 241));
        jLabel9.setText("Kitap ID:");

        ProcessBookID.setBackground(new java.awt.Color(108, 122, 137));
        ProcessBookID.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        ProcessBookID.setForeground(new java.awt.Color(228, 241, 254));
        ProcessBookID.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ProcessBookIDMouseClicked(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(236, 240, 241));
        jLabel10.setText("Yazar ID:");

        ProcessWriterID.setBackground(new java.awt.Color(108, 122, 137));
        ProcessWriterID.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        ProcessWriterID.setForeground(new java.awt.Color(228, 241, 254));
        ProcessWriterID.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ProcessWriterIDMouseClicked(evt);
            }
        });
        ProcessWriterID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProcessWriterIDActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(236, 240, 241));
        jLabel11.setText("Kitap Türü ID:");

        Process_BookTypeID.setBackground(new java.awt.Color(108, 122, 137));
        Process_BookTypeID.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Process_BookTypeID.setForeground(new java.awt.Color(228, 241, 254));
        Process_BookTypeID.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Process_BookTypeIDMouseClicked(evt);
            }
        });
        Process_BookTypeID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Process_BookTypeIDActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(236, 240, 241));
        jLabel13.setText("Alınma Tarihi:");

        Process_ReceivedDate.setBackground(new java.awt.Color(108, 122, 137));
        Process_ReceivedDate.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Process_ReceivedDate.setForeground(new java.awt.Color(228, 241, 254));
        Process_ReceivedDate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Process_ReceivedDateMouseClicked(evt);
            }
        });
        Process_ReceivedDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Process_ReceivedDateActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(236, 240, 241));
        jLabel14.setText("Verilme Tarihi:");

        Process_GiveDate.setBackground(new java.awt.Color(108, 122, 137));
        Process_GiveDate.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Process_GiveDate.setForeground(new java.awt.Color(228, 241, 254));
        Process_GiveDate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Process_GiveDateMouseClicked(evt);
            }
        });
        Process_GiveDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Process_GiveDateActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(236, 240, 241));
        jLabel15.setText("Öğrenci ID:");

        Process_StudentID.setBackground(new java.awt.Color(108, 122, 137));
        Process_StudentID.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Process_StudentID.setForeground(new java.awt.Color(228, 241, 254));
        Process_StudentID.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Process_StudentIDMouseClicked(evt);
            }
        });
        Process_StudentID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Process_StudentIDActionPerformed(evt);
            }
        });

        txt_BookTypeSearch.setBackground(new java.awt.Color(255, 250, 240));
        txt_BookTypeSearch.setText("Aramak istediğiniz metni giriniz.");
        txt_BookTypeSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_BookTypeSearchMouseClicked(evt);
            }
        });
        txt_BookTypeSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_BookTypeSearchActionPerformed(evt);
            }
        });
        txt_BookTypeSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_BookTypeSearchKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_processSearch, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_Process_Add, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(btn_Process_Update, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn_Process_Delete, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(ProcessID, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(ProcessBookID, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(Process_GiveDate, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(15, 15, 15)))
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(Process_StudentID, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Process_LoginID))))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(ProcessWriterID, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Process_BookTypeID, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Process_ReceivedDate, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txt_BookSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txt_BookTypeSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_StudentSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 1, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(txt_WriterSearch)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txt_LoginSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(18, 18, 18))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_StudentSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_BookTypeSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txt_WriterSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(34, 34, 34)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_BookSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_LoginSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(131, 131, 131)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btn_Process_Add)
                                    .addComponent(btn_Process_Update)
                                    .addComponent(btn_Process_Delete))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_processSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(24, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(ProcessID, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(Process_LoginID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Process_StudentID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(ProcessBookID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(ProcessWriterID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(Process_BookTypeID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(Process_ReceivedDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(Process_GiveDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_BookSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_BookSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_BookSearchActionPerformed

    private void txt_WriterSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_WriterSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_WriterSearchActionPerformed

    private void txt_LoginSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_LoginSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_LoginSearchActionPerformed

    private void txt_StudentSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_StudentSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_StudentSearchActionPerformed

    private void txt_processSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_processSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_processSearchActionPerformed

    private void btn_Process_AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Process_AddActionPerformed
        try {
            Insert();
        } catch (SQLException ex) {

        }
    }//GEN-LAST:event_btn_Process_AddActionPerformed

    private void btn_Process_UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Process_UpdateActionPerformed
        try {
            Insert();
        } catch (SQLException ex) {

        }
    }//GEN-LAST:event_btn_Process_UpdateActionPerformed

    private void btn_Process_DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Process_DeleteActionPerformed
        try {
            Delete();
        } catch (SQLException ex) {

        }
    }//GEN-LAST:event_btn_Process_DeleteActionPerformed

    private void ProcessIDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProcessIDMouseClicked
        ProcessID.setText("");
    }//GEN-LAST:event_ProcessIDMouseClicked

    private void Process_LoginIDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Process_LoginIDMouseClicked
        Process_LoginID.setText("");
    }//GEN-LAST:event_Process_LoginIDMouseClicked

    private void ProcessBookIDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProcessBookIDMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_ProcessBookIDMouseClicked

    private void ProcessWriterIDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProcessWriterIDMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_ProcessWriterIDMouseClicked

    private void Process_BookTypeIDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Process_BookTypeIDMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Process_BookTypeIDMouseClicked

    private void Process_ReceivedDateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Process_ReceivedDateMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Process_ReceivedDateMouseClicked

    private void Process_GiveDateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Process_GiveDateMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Process_GiveDateMouseClicked

    private void Process_StudentIDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Process_StudentIDMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Process_StudentIDMouseClicked

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        HomePageForm home = new HomePageForm();
        home.setVisible(true);
        dispose();

    }//GEN-LAST:event_btnHomeActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnExitActionPerformed

    private void Process_BookTypeIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Process_BookTypeIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Process_BookTypeIDActionPerformed

    private void Process_GiveDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Process_GiveDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Process_GiveDateActionPerformed

    private void Process_StudentIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Process_StudentIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Process_StudentIDActionPerformed

    private void Process_ReceivedDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Process_ReceivedDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Process_ReceivedDateActionPerformed

    private void ProcessWriterIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProcessWriterIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ProcessWriterIDActionPerformed

    private void Process_LoginIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Process_LoginIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Process_LoginIDActionPerformed

    private void txt_BookTypeSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_BookTypeSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_BookTypeSearchActionPerformed

    private void txt_BookSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_BookSearchMouseClicked
        txt_BookSearch.setText("");
    }//GEN-LAST:event_txt_BookSearchMouseClicked

    private void txt_BookTypeSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_BookTypeSearchMouseClicked
        txt_BookTypeSearch.setText("");
    }//GEN-LAST:event_txt_BookTypeSearchMouseClicked

    private void txt_StudentSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_StudentSearchMouseClicked
        txt_StudentSearch.setText("");
    }//GEN-LAST:event_txt_StudentSearchMouseClicked

    private void txt_WriterSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_WriterSearchMouseClicked
        txt_WriterSearch.setText("");
    }//GEN-LAST:event_txt_WriterSearchMouseClicked

    private void txt_LoginSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_LoginSearchMouseClicked
        txt_LoginSearch.setText("");
    }//GEN-LAST:event_txt_LoginSearchMouseClicked

    private void txt_processSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_processSearchMouseClicked
        txt_processSearch.setText("");
    }//GEN-LAST:event_txt_processSearchMouseClicked

    private void tbl_processMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_processMouseClicked
        ProcessID.setText(model.getValueAt(tbl_process.getSelectedRow(), 0).toString());

    }//GEN-LAST:event_tbl_processMouseClicked

    private void tbl_LoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_LoginMouseClicked
        Process_LoginID.setText(model.getValueAt(tbl_Login.getSelectedRow(), 0).toString());
    }//GEN-LAST:event_tbl_LoginMouseClicked

    private void tbl_WriterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_WriterMouseClicked
        ProcessWriterID.setText(model.getValueAt(tbl_Writer.getSelectedRow(), 0).toString());
    }//GEN-LAST:event_tbl_WriterMouseClicked

    private void tbl_bookTypeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_bookTypeMouseClicked
        Process_BookTypeID.setText(model.getValueAt(tbl_bookType.getSelectedRow(), 0).toString());
    }//GEN-LAST:event_tbl_bookTypeMouseClicked

    private void tbl_bookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_bookMouseClicked
        ProcessBookID.setText(model.getValueAt(tbl_book.getSelectedRow(), 0).toString());
    }//GEN-LAST:event_tbl_bookMouseClicked

    private void tbl_StudentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_StudentMouseClicked
        Process_StudentID.setText(model.getValueAt(tbl_Student.getSelectedRow(), 0).toString());
    }//GEN-LAST:event_tbl_StudentMouseClicked

    private void txt_BookSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_BookSearchKeyReleased
        String search = txt_BookSearch.getText();
        TableRowSorter<DefaultTableModel> tableRowSorter = new TableRowSorter<>(model);
        tbl_book.setRowSorter(tableRowSorter);
        tableRowSorter.setRowFilter(RowFilter.regexFilter(search));
    }//GEN-LAST:event_txt_BookSearchKeyReleased

    private void txt_BookTypeSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_BookTypeSearchKeyReleased
        String search = txt_BookTypeSearch.getText();
        TableRowSorter<DefaultTableModel> tableRowSorter = new TableRowSorter<>(model);
        tbl_bookType.setRowSorter(tableRowSorter);
        tableRowSorter.setRowFilter(RowFilter.regexFilter(search));
    }//GEN-LAST:event_txt_BookTypeSearchKeyReleased

    private void txt_StudentSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_StudentSearchKeyReleased
        String search = txt_StudentSearch.getText();
        TableRowSorter<DefaultTableModel> tableRowSorter = new TableRowSorter<>(model);
        tbl_Student.setRowSorter(tableRowSorter);
        tableRowSorter.setRowFilter(RowFilter.regexFilter(search));
    }//GEN-LAST:event_txt_StudentSearchKeyReleased

    private void txt_WriterSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_WriterSearchKeyReleased
        String search = txt_WriterSearch.getText();
        TableRowSorter<DefaultTableModel> tableRowSorter = new TableRowSorter<>(model);
        tbl_Writer.setRowSorter(tableRowSorter);
        tableRowSorter.setRowFilter(RowFilter.regexFilter(search));
    }//GEN-LAST:event_txt_WriterSearchKeyReleased

    private void txt_LoginSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_LoginSearchKeyReleased
        String search = txt_LoginSearch.getText();
        TableRowSorter<DefaultTableModel> tableRowSorter = new TableRowSorter<>(model);
        tbl_Login.setRowSorter(tableRowSorter);
        tableRowSorter.setRowFilter(RowFilter.regexFilter(search));
    }//GEN-LAST:event_txt_LoginSearchKeyReleased

    private void txt_processSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_processSearchKeyReleased
        String search = txt_processSearch.getText();
        TableRowSorter<DefaultTableModel> tableRowSorter = new TableRowSorter<>(model);
        tbl_process.setRowSorter(tableRowSorter);
        tableRowSorter.setRowFilter(RowFilter.regexFilter(search));
    }//GEN-LAST:event_txt_processSearchKeyReleased

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProcessFormScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ProcessBookID;
    private javax.swing.JLabel ProcessID;
    private javax.swing.JTextField ProcessWriterID;
    private javax.swing.JTextField Process_BookTypeID;
    private javax.swing.JTextField Process_GiveDate;
    private javax.swing.JTextField Process_LoginID;
    private javax.swing.JTextField Process_ReceivedDate;
    private javax.swing.JTextField Process_StudentID;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btn_Process_Add;
    private javax.swing.JButton btn_Process_Delete;
    private javax.swing.JButton btn_Process_Update;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTable tbl_Login;
    private javax.swing.JTable tbl_Student;
    private javax.swing.JTable tbl_Writer;
    private javax.swing.JTable tbl_book;
    private javax.swing.JTable tbl_bookType;
    private javax.swing.JTable tbl_process;
    private javax.swing.JTextField txt_BookSearch;
    private javax.swing.JTextField txt_BookTypeSearch;
    private javax.swing.JTextField txt_LoginSearch;
    private javax.swing.JTextField txt_StudentSearch;
    private javax.swing.JTextField txt_WriterSearch;
    private javax.swing.JTextField txt_processSearch;
    // End of variables declaration//GEN-END:variables
}
