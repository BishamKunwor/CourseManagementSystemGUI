/**
 * This class object represents NonAcademicCourse object with information about
 * Non Academic courses of an Institute
 *
 * @author (Bisham Kunwor)
 * @version (1.2)
 */

//Non Academic class is inherits Course class represeted by extend keyword
public class NonAcademicCourse extends Course {

    //Declaring instance variables
    private String instructorName;
    private String startingDate;
    private String completionDate;
    private String examDate;
    private String prerequisite;
    private boolean isRegistered;
    private boolean isRemoved;

    /*Constructor that accepts four instance variable and and calls super class with three variable to initalize 
    parent class and finally parameter variable are assigned to instance variable and remaining varable are set to "" or Fasle */
    public NonAcademicCourse(String courseID, String courseName, int duration, String prerequisite) {

        //call to parent class is made with arguments to initalize parent class
        super(courseID, courseName, duration);

         //instance variable are assigned
        this.prerequisite = prerequisite;
        
        //default vaues are set as ("") or False
        this.startingDate = "";
        this.completionDate = "";
        this.examDate = "";
        this.isRegistered = false;
        this.isRemoved = false;
    }

    //Getter methods for access to all instance variable starts from here
    public String getInstructorName() {
        return this.instructorName;
    }

    public String getStartingDate() {
        return this.startingDate;
    }

    public String getCompletionDate() {
        return this.completionDate;
    }

    public String getExamDate() {
        return this.examDate;
    }

    public String getPrerequisite() {
        return this.prerequisite;
    }

    public boolean getIsRegistered() {
        return this.isRegistered;
    }

    public boolean getIsRemoved() {
        return this.isRemoved;
    }
    
    //Getter methods ends here.

    //setter method that accepts string as parameter and assigns to instance variable
    public void setInstructorName(String instructorName) {
        if (!getIsRegistered())
            this.instructorName = instructorName;
        else
            System.out.printf("The course is already registered and instructor name %s cannot be assigned.",
                    instructorName);
    }

    //This methods takes four arguments that helps to register the particular course
    public void register(String courseLeader, String instructorName, String startingDate, String completionDate,
            String examDate) {
                
        if (getIsRegistered())
            System.out.printf("The course was already registered.");
        else {
            this.setInstructorName(instructorName);
            this.isRegistered = true;
            this.startingDate = startingDate;
            super.setCourseLeader(courseLeader);
            this.completionDate = completionDate;
            this.examDate = examDate;
        }
    }

    //This method removes any course if it is not removed and if removed then prints suitable result
    public void remove(){
        if (!getIsRemoved()){
            super.setCourseLeader("");
            this.instructorName = "";
            this.startingDate = "";
            this.completionDate = "";
            this.examDate = "";
            this.isRegistered = false;
            this.isRemoved = true;
        }else 
            System.out.println("The course was already removed.");
    }

    /*override as name suggest overides parent class method and let Non Academic Course class have its own method that acts 
    differently than inherited parent method */
    @Override
    public void display() {
        if (getIsRegistered()){
            super.display();
            System.out.println(String.format("%n%s: %s%n%s: %s%n%s: %s%n%s: %s", "Instructor Name",
                    this.getInstructorName(), "Starting Date", this.getStartingDate(), "Completion Date",
                    this.getCompletionDate(), "Examination Date", this.getExamDate()));
        }else
        /*if (if statement is false) then
        below return statement returns its value */
        super.display();
    }

}
