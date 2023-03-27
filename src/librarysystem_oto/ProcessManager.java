package librarysystem_oto;

public class ProcessManager {

    private int ProcessID;
    private int UserID;
    private int StudentID;
    private int BookID;
    private int WriterID;
    private int BookTypeID;
    private Object ReceivedDate;
    private Object GiveDate;

    public ProcessManager(int ProcessID, int UserID, int StudentID, int BookID, int WriterID, int BookTypeID, Object ReceivedDate, Object GiveDate) {
        this.ProcessID = ProcessID;
        this.UserID = UserID;
        this.StudentID = StudentID;
        this.BookID = BookID;
        this.WriterID = WriterID;
        this.BookTypeID = BookTypeID;
        this.ReceivedDate = ReceivedDate;
        this.GiveDate = GiveDate;

    }

    public int getProcessID() {
        return ProcessID;
    }

    /**
     * @param ProcessID the ProcessID to set
     */
    public void setProcessID(int ProcessID) {
        this.ProcessID = ProcessID;
    }

    /**
     * @return the StudentID
     */
    public int getStudentID() {
        return StudentID;
    }

    /**
     * @param StudentID the StudentID to set
     */
    public void setStudentID(int StudentID) {
        this.StudentID = StudentID;
    }

    /**
     * @return the BookID
     */
    public int getBookID() {
        return BookID;
    }

    /**
     * @param BookID the BookID to set
     */
    public void setBookID(int BookID) {
        this.BookID = BookID;
    }

    /**
     * @return the WriterID
     */
    public int getWriterID() {
        return WriterID;
    }

    /**
     * @param WriterID the WriterID to set
     */
    public void setWriterID(int WriterID) {
        this.WriterID = WriterID;
    }

    /**
     * @return the BookTypeID
     */
    public int getBookTypeID() {
        return BookTypeID;
    }

    /**
     * @param BookTypeID the BookTypeID to set
     */
    public void setBookTypeID(int BookTypeID) {
        this.BookTypeID = BookTypeID;
    }

    /**
     * @return the ReceivedDate
     */
    public Object getReceivedDate() {
        return ReceivedDate;
    }

    /**
     * @param ReceivedDate the ReceivedDate to set
     */
    public void setReceivedDate(Object ReceivedDate) {
        this.ReceivedDate = ReceivedDate;
    }

    /**
     * @return the BookGiveDate
     */
    public Object getGiveDate() {
        return GiveDate;
    }

    /**
     * @param BookGiveDate the BookGiveDate to set
     */
    public void setGiveDate(Object BookGiveDate) {
        this.GiveDate = GiveDate;
    }

    /**
     * @return the UserID
     */
    public int getUserID() {
        return UserID;
    }

    /**
     * @param UserID the UserID to set
     */
    public void setUserID(int UserID) {
        this.UserID = UserID;
    }

}
