package librarysystem_oto;


public class WriterManager {
    private int WriterID;
    private String WriterName;
    private String WriterLastname;

    
    public WriterManager (int WriterID, String WriterName, String WriterLastname){
        this.WriterID = WriterID;
        this.WriterName = WriterName;
        this.WriterLastname = WriterLastname;
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
     * @return the WriterName
     */
    public String getWriterName() {
        return WriterName;
    }

    /**
     * @param WriterName the WriterName to set
     */
    public void setWriterName(String WriterName) {
        this.WriterName = WriterName;
    }

    /**
     * @return the WriterLastname
     */
    public String getWriterLastname() {
        return WriterLastname;
    }

    /**
     * @param WriterLastname the WriterLastname to set
     */
    public void setWriterLastname(String WriterLastname) {
        this.WriterLastname = WriterLastname;
    }
}
