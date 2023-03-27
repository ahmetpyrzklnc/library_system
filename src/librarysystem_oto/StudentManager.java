package librarysystem_oto;

public class StudentManager {

    private int StudentID;
    private String StudentName;
    private String StudentLastName;
    private String StudentGender;
    private Object StudentBirtday;
    private int StudentPoint;

    public StudentManager(int StudentID, String StudentName, String StudentLastName, String StudentGender, Object StudentBirtday, int StudentPoint) {
        this.StudentID = StudentID;
        this.StudentName = StudentName;
        this.StudentLastName = StudentLastName;
        this.StudentGender = StudentGender;
        this.StudentBirtday = StudentBirtday;
        this.StudentPoint = StudentPoint;

    }

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
     * @return the StudentName
     */
    public String getStudentName() {
        return StudentName;
    }

    /**
     * @param StudentName the StudentName to set
     */
    public void setStudentName(String StudentName) {
        this.StudentName = StudentName;
    }

    /**
     * @return the StudentLastName
     */
    public String getStudentLastName() {
        return StudentLastName;
    }

    /**
     * @param StudentLastName the StudentLastName to set
     */
    public void setStudentLastName(String StudentLastName) {
        this.StudentLastName = StudentLastName;
    }

    /**
     * @return the Gender
     */
    public String getStudentGender() {
        return StudentGender;
    }

    /**
     * @param Gender the Gender to set
     */
    public void setStudentGender(String Gender) {
        this.StudentGender = Gender;
    }

    /**
     * @return the StudentBirtday
     */
    public Object getStudentBirtday() {
        return StudentBirtday;
    }

    /**
     * @param StudentBirtday the StudentBirtday to set
     */
    public void setStudentBirtday(Object StudentBirtday) {
        this.StudentBirtday = StudentBirtday;
    }

    /**
     * @return the StudentPoint
     */
    public int getStudentPoint() {
        return StudentPoint;
    }

    /**
     * @param StudentPoint the StudentPoint to set
     */
    public void setStudentPoint(int StudentPoint) {
        this.StudentPoint = StudentPoint;
    }
}
