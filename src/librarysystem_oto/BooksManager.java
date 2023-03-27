package librarysystem_oto;


public class BooksManager {
    private int BookID;
    private String BookName;
    private int BookNumber_of_Pages;
    private boolean Book_is_selected;
    private int WriterID;
    private int BookTypeID;
    
    public BooksManager (int BookID, String BookName, int BookNumber_of_Pages, boolean Book_is_selected, int WriterID, int BookTypeID) {
        this.BookID = BookID;
        this.BookName = BookName;
        this.BookNumber_of_Pages = BookNumber_of_Pages;
        this.Book_is_selected = Book_is_selected;
        this.WriterID = WriterID;
        this.BookTypeID = BookTypeID;
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
     * @return the BookName
     */
    public String getBookName() {
        return BookName;
    }

    /**
     * @param BookName the BookName to set
     */
    public void setBookName(String BookName) {
        this.BookName = BookName;
    }

    /**
     * @return the BookNumber_of_Pages
     */
    public int getBookNumber_of_Pages() {
        return BookNumber_of_Pages;
    }

    /**
     * @param BookNumber_of_Pages the BookNumber_of_Pages to set
     */
    public void setBookNumber_of_Pages(int BookNumber_of_Pages) {
        this.BookNumber_of_Pages = BookNumber_of_Pages;
    }

    /**
     * @return the Book_is_selected
     */
    public boolean getBook_is_selected() {
        return Book_is_selected;
    }

    /**
     * @param Book_is_selected the Book_is_selected to set
     */
    public void setBook_is_selected(boolean Book_is_selected) {
        this.Book_is_selected = Book_is_selected;
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
            
}
