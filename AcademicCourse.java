/**
 * This class object represents AcademicCourse object with information about
 * Academic courses of an Institute
 *
 * @author (Bisham Kunwor)
 * @version (1.8)
 */

//Academic class is inherits Course class represeted by extend keyword
public class AcademicCourse extends Course {
    
    //Declaring instance variables
    private String lecturerName;
    private String level;
    private String credit;
    private String startingDate;
    private String completionDate;
    private int numberOfAssessments;
    private boolean isRegistered;

    /*Constructor that accepts six instance variable and and calls super class with three variable to initalize 
    parent class and finally parameter variable are assigned to instance variable and remaining varable are set to "" or Fasle */
    public AcademicCourse(String courseID, String courseName, int duration, String level, String credit,
            int numberOfAssessments) {
        
        //call to parent class is made with arguments to initalize parent class
        super(courseID, courseName, duration);
        
        //instance variable are assigned
        this.level = level;
        this.credit = credit;
        this.numberOfAssessments = numberOfAssessments;
        
        //default vaues are set as ("") or False
        this.startingDate = "";
        this.completionDate = "";
        this.lecturerName = "";
        this.isRegistered = false;
    }

    //Getter methods for access to all instance variable starts from here
    public String getLecturerName() {
        return this.lecturerName;
    }

    public String getLevel() {
        return this.level;
    }

    public String getCredit() {
        return this.credit;
    }

    public String getStartingDate() {
        return this.startingDate;
    }

    public String getCompletionDate() {
        return this.completionDate;
    }

    public int getNumberOfAssessments() {
        return this.numberOfAssessments;
    }

    public boolean getIsRegistered() {
        return this.isRegistered;
    }
    
    //Getter methods ends here.

    //setter method that accepts string as parameter and assigns to instance variable
    public void setLecturerName(String lecturerName) {
        this.lecturerName = lecturerName;
    }

    //setter method that accepts interger as parameter and assigns to instance variabe 
    public void setNumberOfAssessments(int numberOfAssessments) {
        this.numberOfAssessments = numberOfAssessments;
    }
    
    //This methods sets new course if it is not registered and if registered than displays suitable information 
    public void register(String courseLeader, String lecturerName, String startingDate, String completionDate) {
        if (!getIsRegistered()) {
            
            //courseleader in parent class is set
            super.setCourseLeader(courseLeader);
            this.lecturerName = lecturerName;
            this.startingDate = startingDate;
            this.completionDate = completionDate;
            this.isRegistered = true;
        } else
            System.out.printf(
                    "The course is already registered and is taught by %s. It started on %s and will end on %s.",
                    this.getLecturerName(), this.getStartingDate(), this.getCompletionDate());
    }

    /*override as name suggest overides parent class method and let Academic Course class have its own method that acts 
    differently than inherited parent method */
    @Override
    public void display() {
        if (getIsRegistered()){
            super.display();
            System.out.print(String.format("%n%s: %s%n%s: %s%n%s: %s%n%s: %s%n%s: %s%n%s: %d",
                    "Lecturer Name", this.getLecturerName(), "Level", this.getLevel(), "Credit", this.getCredit(),
                    "Starting Date", this.getStartingDate(), "Completion Date", this.getCompletionDate(),
                    "Number of Assessments", this.getNumberOfAssessments()));
        }else
        /*if (if statement is false) then
        below return statement returns its value */
        super.display();
    }
    
}
