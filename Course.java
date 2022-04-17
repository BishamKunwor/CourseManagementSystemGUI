/**
 * This class creates instance for Course object and allows access to private attribute by getter method.
 * Only one istance variable can be set by using setter method and the display mehtod represent information
 * about the class.
 *
 * @author (Bisham Kunwor)
 * @version (1.5)
 */

public class Course {
    
    //Creating instance variables
    private String courseID;
    private String courseName;
    private String courseLeader;
    private int duration;
    
    
    //Constructor that accepts three instance variable and sets ("") for courseLeader attribute
    public Course(String courseID, String courseName, int duration) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.duration = duration;
        this.courseLeader = "";
    }
    
    //Getter methods for access to all instance variable starts from here
    public String getCourseID() {
        return this.courseID;
    }

    public String getCourseName() {
        return this.courseName;
    }

    public String getCourseLeader() {
        return this.courseLeader;
    }

    public int getDuration() {
        return this.duration;
    }
    
    //Getter methods ends here.
    
    
    //Setter method for courseleader that sets new value of course leader is declared
    public void setCourseLeader(String courseLeader) {
        this.courseLeader = courseLeader;
    }
    
    
    //The display method concatenates all the instance variable and returns suitable string output
    public void display() {
        
        //String is formatted and stored in formatted variable applying (DRY principle)
        String formatted = String.format("%s: %s%n%s: %s%n%s: %d year", "Course ID", this.getCourseID(), "Course Name",
                                    this.getCourseName(), "Duration", this.getDuration());
                                    
        //Returns formatted variable output if getter method comparision result in true value
        if (getCourseLeader().equals(""))
            System.out.print(formatted);
        else 
        /*if (if statement is false) then
        below return statement returns its value */
        System.out.print(String.format("%s: %s%n%s", "Course Leader", this.getCourseLeader(), formatted));
    }
    
}