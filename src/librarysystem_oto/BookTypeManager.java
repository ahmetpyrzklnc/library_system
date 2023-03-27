package librarysystem_oto;

public class BookTypeManager {

    private int BookTypeID;
    private String BookTypeName;

    public BookTypeManager(int BookTypeID, String BookTypeName) {
        this.BookTypeID = BookTypeID;
        this.BookTypeName = BookTypeName;
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
     * @return the BookTypeName
     */
    public String getBookTypeName() {
        return BookTypeName;
    }

    /**
     * @param BookTypeName the BookTypeName to set
     */
    public void setBookTypeName(String BookTypeName) {
        this.BookTypeName = BookTypeName;
    }

}
