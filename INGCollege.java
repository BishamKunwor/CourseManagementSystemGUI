
/**
 * This class creates GUI which allows to add new academic or non-academic course
 * 
 *
 * @author (Bisham Kunwor)
 * @version (2.3)
 */

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class INGCollege extends JFrame {
    // The bottom two list contains all the record for each course addition or
    // registration
    private ArrayList<AcademicCourse> academicCourseList = new ArrayList<AcademicCourse>();
    private ArrayList<NonAcademicCourse> nonAcademicCourseList = new ArrayList<NonAcademicCourse>();

    private JPanel leftMenuJPanel, leftMenuLogoContainer, leftMenuButtonContainer, academicFormContainer,
            nonAcademicFormContainer;

    private JLabel collegeLogoJLabel, academicCourseHeadingJLabel, nonAcademicCourseHeadingJLabel;

    private JTextField courseIDField, courseNameField, durationField, levelField, creditField, assessmentField,
            instructorNameField, courseLeaderField, startingDateField, completionDateField, registerCourseID,
            nonAcademicCourseIDField, nonAcademicCourseNameField, prerequisites, nonAcademicDurationField,
            nonAcademicInstructorNameField, nonAcademicCourseLeaderField, nonAcademicStartingDateField,
            nonAcademicCompletionDateField, examDateField, nonAcademicCourseID;

    private JButton academicCourse, nonAcademicCourse, academicAddButton, registerAcademicCourse, display, clear,
            nonAcademicacademicAddButton, nonAcademicregisterAcademicCourse, nonAcademicDisplay, remove;

    private Icon collegeLogo;

    private Font labelFont, nonAcademicLabelFont;

    // INGCollege Constructor starts program execution
    public INGCollege() {
        super("INGCollege Course Management System");
        setSize(1280, 720);
        setResizable(false);
        setLayout(null);

        // Layout contains left and right panel where left panel contains logo and right
        // pane contains form
        // JPanel leftMenuJPanel = new JPanel();
        leftMenuJPanel = new JPanel();
        leftMenuJPanel.setLayout(null);
        leftMenuJPanel.setBounds(0, 0, 350, 720);
        leftMenuJPanel.setBackground(new Color(94, 96, 206));
        add(leftMenuJPanel);

        // Adds logo in a JPanel
        // JPanel leftMenuLogoContainer = new JPanel();
        leftMenuLogoContainer = new JPanel();
        leftMenuLogoContainer.setBounds(0, 0, 350, 250);
        leftMenuLogoContainer.setBackground(new Color(255, 255, 255));
        // Icon collegeLogo = new ImageIcon(getClass().getResource("collegeLogo.png"));

        collegeLogo = new ImageIcon(getClass().getResource("collegeLogo.png"));
        // JLabel collegeLogoJLabel = new JLabel(collegeLogo);

        collegeLogoJLabel = new JLabel(collegeLogo);
        leftMenuLogoContainer.add(collegeLogoJLabel);
        leftMenuJPanel.add(leftMenuLogoContainer);

        // This is the bottom container which contains two butttons (Academic and
        // NonAcademic course)
        // JPanel leftMenuButtonContainer = new JPanel();
        leftMenuButtonContainer = new JPanel();
        leftMenuButtonContainer.setBackground(new Color(94, 96, 206));
        leftMenuButtonContainer.setLayout(null);
        leftMenuButtonContainer.setBounds(0, 400, 350, 470);
        // JButton academicCourse = new JButton("Academic Courses");

        academicCourse = new JButton("Academic Courses");
        academicCourse.setBackground(new Color(255, 92, 138));
        // JButton nonAcademicCourse = new JButton("Non-Academic Courses");

        nonAcademicCourse = new JButton("Non-Academic Courses");
        nonAcademicCourse.setBackground(new Color(189, 178, 255));
        academicCourse.setBounds(60, 10, 200, 40);
        nonAcademicCourse.setBounds(60, 70, 200, 40);
        leftMenuButtonContainer.add(academicCourse);
        leftMenuButtonContainer.add(nonAcademicCourse);
        leftMenuJPanel.add(leftMenuButtonContainer);

        // This is academic course form starting
        // JPanel academicFormContainer = new JPanel();
        academicFormContainer = new JPanel();
        academicFormContainer.setLayout(null);
        academicFormContainer.setBackground(new Color(189, 224, 254));
        academicFormContainer.setBounds(350, 0, 930, 720);
        academicFormContainer.setVisible(true);
        add(academicFormContainer);

        // Font labelFont = new Font("Calibri", Font.BOLD, 20);

        labelFont = new Font("Calibri", Font.BOLD, 20);

        // Labels and TextFields for Academic Courses
        // JLabel academicCourseHeadingJLabel = new JLabel("Academic Course");

        academicCourseHeadingJLabel = new JLabel("Academic Course");
        academicCourseHeadingJLabel.setBounds(360, 60, 930, 40);
        academicCourseHeadingJLabel.setFont(new Font("Calibri", Font.BOLD, 32));

        int leftLabelX = 60;
        int leftLabelY = 150;
        int fieldXAxis = 220;

        // JButton academicAddButton = new JButton("Add");

        academicAddButton = new JButton("Add");
        academicAddButton.setBackground(new Color(72, 191, 227));
        academicAddButton.setBounds(fieldXAxis, 460, 170, 30);

        // JTextField courseIDField = new JTextField();
        // JTextField courseNameField = new JTextField();
        // JTextField durationField = new JTextField();
        // JTextField levelField = new JTextField();
        // JTextField creditField = new JTextField();
        // JTextField assessmentField = new JTextField();

        courseIDField = new JTextField();
        courseNameField = new JTextField();
        durationField = new JTextField();
        levelField = new JTextField();
        creditField = new JTextField();
        assessmentField = new JTextField();
        academicFormContainer.add(academicCourseHeadingJLabel);

        academicFormContainer.add(academicAddButton);

        String[] labelNames = { "CourseID:", "Course Name:", "Duration:", "Level:", "Credit:", "Assessments:" };
        JTextField[] leftTextFields = { courseIDField, courseNameField, durationField, levelField, creditField,
                assessmentField };
        // This loops creates all the textField and text labels
        for (int i = 0; i < 6; i++) {
            JLabel label = new JLabel(labelNames[i]);
            label.setFont(labelFont);
            label.setBounds(leftLabelX, leftLabelY, 150, 40);
            leftTextFields[i].setBounds(fieldXAxis, leftLabelY + 5, 170, 25);
            leftTextFields[i].setName(labelNames[i]);
            academicFormContainer.add(label);
            academicFormContainer.add(leftTextFields[i]);
            leftLabelY += 50;
        }
        // form left side ends here

        // form right side starts here

        int rightLabelX = 500;
        int rightLabelY = 150;
        int rightFieldXAxis = 700;

        // JTextField instructorNameField = new JTextField();
        // JTextField courseLeaderField = new JTextField();
        // JTextField startingDateField = new JTextField();
        // JTextField completionDateField = new JTextField();
        // JTextField registerCourseID = new JTextField();

        instructorNameField = new JTextField();

        courseLeaderField = new JTextField();

        startingDateField = new JTextField();

        completionDateField = new JTextField();

        registerCourseID = new JTextField();

        String[] rightLabelNames = { "CourseID:", "Instructor Name:", "Course Leader:", "Starting Date:",
                "Completion Date:" };
        JTextField[] rightTextFields = { registerCourseID, instructorNameField, courseLeaderField, startingDateField,
                completionDateField };
        // This loops creates all the textField and text labels
        for (int i = 0; i < 5; i++) {
            JLabel label = new JLabel(rightLabelNames[i]);
            label.setFont(labelFont);
            label.setBounds(rightLabelX, rightLabelY, 150, 40);
            rightTextFields[i].setBounds(rightFieldXAxis, rightLabelY, 170, 25);
            rightTextFields[i].setName(rightLabelNames[i]);
            academicFormContainer.add(label);
            academicFormContainer.add(rightTextFields[i]);
            rightLabelY += 50;
        }

        registerAcademicCourse = new JButton("Register");
        // JButton registerAcademicCourse = new JButton("Register");
        registerAcademicCourse.setBackground(new Color(100, 223, 223));
        registerAcademicCourse.setBounds(rightFieldXAxis, 410, 170, 30);
        academicFormContainer.add(registerAcademicCourse);

        // JButton display = new JButton("Display");
        display = new JButton("Display");
        display.setBackground(new Color(224, 170, 255));
        display.setBounds(250, 580, 170, 30);
        // JButton clear = new JButton("Clear");
        clear = new JButton("Clear");
        clear.setBackground(new Color(255, 143, 163));
        clear.setBounds(500, 580, 170, 30);
        academicFormContainer.add(display);
        academicFormContainer.add(clear);

        // This action listener clears all the textfield when pressed
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                for (JTextField buttons : leftTextFields) {
                    buttons.setText("");
                }
                for (JTextField buttons : rightTextFields) {
                    buttons.setText("");
                }
            }
        });
        // Academic course form ending

        // This is Non academic course form starting
        // JPanel nonAcademicFormContainer = new JPanel();
        nonAcademicFormContainer = new JPanel();
        nonAcademicFormContainer.setLayout(null);
        nonAcademicFormContainer.setBackground(new Color(189, 224, 254));
        nonAcademicFormContainer.setBounds(350, 0, 930, 720);
        nonAcademicFormContainer.setVisible(false);
        add(nonAcademicFormContainer);

        // Font nonAcademicLabelFont = new Font("Calibri", Font.BOLD, 20);
        nonAcademicLabelFont = new Font("Calibri", Font.BOLD, 20);

        // Labels and TextFields for Academic Courses
        // JLabel nonAcademicCourseHeadingJLabel = new JLabel("Non-Academic Course");
        nonAcademicCourseHeadingJLabel = new JLabel("Non-Academic Course");
        nonAcademicCourseHeadingJLabel.setBounds(360, 60, 930, 40);
        nonAcademicCourseHeadingJLabel.setFont(new Font("Calibri", Font.BOLD, 32));

        int nonAcademicLeftLabelX = 60;
        int nonAcademicLeftLabelY = 150;
        int nonAcademicFieldXAxis = 220;

        // JButton nonAcademicacademicAddButton = new JButton("Add");
        nonAcademicacademicAddButton = new JButton("Add");

        nonAcademicacademicAddButton.setBackground(new Color(72, 191, 227));

        // JTextField nonAcademicCourseIDField = new JTextField();
        // JTextField nonAcademicCourseNameField = new JTextField();
        // JTextField nonAcademicDurationField = new JTextField();
        // JTextField prerequisites = new JTextField();
        nonAcademicCourseIDField = new JTextField();
        nonAcademicCourseNameField = new JTextField();
        nonAcademicDurationField = new JTextField();
        prerequisites = new JTextField();

        nonAcademicFormContainer.add(nonAcademicCourseHeadingJLabel);

        String[] nonAcademicLabelNames = { "CourseID:", "Course Name:", "Duration:", "Pre-requisites:" };
        JTextField[] nonAcademicLeftTextFields = { nonAcademicCourseIDField, nonAcademicCourseNameField,
                nonAcademicDurationField, prerequisites };
        // This loop generates all the Label and textfield for adding course.
        for (int i = 0; i < 4; i++) {
            JLabel label = new JLabel(nonAcademicLabelNames[i]);
            label.setFont(nonAcademicLabelFont);
            label.setBounds(nonAcademicLeftLabelX, nonAcademicLeftLabelY, 150, 40);
            nonAcademicLeftTextFields[i].setBounds(nonAcademicFieldXAxis, nonAcademicLeftLabelY + 5, 170, 25);
            nonAcademicLeftTextFields[i].setName(nonAcademicLabelNames[i]);
            nonAcademicFormContainer.add(label);
            nonAcademicFormContainer.add(nonAcademicLeftTextFields[i]);
            nonAcademicLeftLabelY += 50;
        }
        nonAcademicacademicAddButton.setBounds(nonAcademicFieldXAxis, nonAcademicLeftLabelY, 170, 30);
        nonAcademicFormContainer.add(nonAcademicacademicAddButton);
        // form left side ends here

        // form right side starts here

        int nonAcademicRightLabelX = 500;
        int nonAcademicRightLabelY = 150;
        int rightnonAcademicFieldXAxis = 700;

        nonAcademicInstructorNameField = new JTextField();
        nonAcademicCourseLeaderField = new JTextField();
        nonAcademicStartingDateField = new JTextField();
        nonAcademicCompletionDateField = new JTextField();
        examDateField = new JTextField();
        nonAcademicCourseID = new JTextField();
        // JTextField nonAcademicInstructorNameField = new JTextField();
        // JTextField nonAcademicCourseLeaderField = new JTextField();
        // JTextField nonAcademicStartingDateField = new JTextField();
        // JTextField nonAcademicCompletionDateField = new JTextField();
        // JTextField examDateField = new JTextField();
        // JTextField nonAcademicCourseID = new JTextField();

        String[] rightnonAcademicLabelNames = { "CourseID:", "Instructor Name:", "Course Leader:", "Starting Date:",
                "Completion Date:", "Exam Date:" };
        JTextField[] nonAcademicRightTextFields = { nonAcademicCourseID, nonAcademicInstructorNameField,
                nonAcademicCourseLeaderField, nonAcademicStartingDateField, nonAcademicCompletionDateField,
                examDateField };

        // This loop generates all the Label and textfield for registering course.
        for (int i = 0; i < 6; i++) {
            JLabel label = new JLabel(rightnonAcademicLabelNames[i]);
            label.setFont(nonAcademicLabelFont);
            label.setBounds(nonAcademicRightLabelX, nonAcademicRightLabelY, 150, 40);
            nonAcademicRightTextFields[i].setBounds(rightnonAcademicFieldXAxis, nonAcademicRightLabelY, 170, 25);
            nonAcademicRightTextFields[i].setName(rightnonAcademicLabelNames[i]);
            nonAcademicFormContainer.add(label);
            nonAcademicFormContainer.add(nonAcademicRightTextFields[i]);
            nonAcademicRightLabelY += 50;
        }

        // JButton nonAcademicregisterAcademicCourse = new JButton("Register");
        nonAcademicregisterAcademicCourse = new JButton("Register");
        nonAcademicregisterAcademicCourse.setBackground(new Color(100, 223, 223));
        nonAcademicregisterAcademicCourse.setBounds(rightnonAcademicFieldXAxis, nonAcademicRightLabelY, 170, 30);
        nonAcademicFormContainer.add(nonAcademicregisterAcademicCourse);

        // JButton nonAcademicDisplay = new JButton("Display");
        nonAcademicDisplay = new JButton("Display");
        nonAcademicDisplay.setBackground(new Color(224, 170, 255));
        nonAcademicDisplay.setBounds(250, 580, 170, 30);
        // JButton remove = new JButton("Remove");
        remove = new JButton("Remove");
        remove.setBackground(new Color(255, 143, 163));
        remove.setBounds(500, 580, 170, 30);
        nonAcademicFormContainer.add(nonAcademicDisplay);
        nonAcademicFormContainer.add(remove);

        // Non Academic course form ending

        // Event Handling starts here
        academicCourse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                nonAcademicFormContainer.setVisible(false);
                academicFormContainer.setVisible(true);
            }
        });

        nonAcademicCourse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                academicFormContainer.setVisible(false);
                nonAcademicFormContainer.setVisible(true);
            }
        });

        academicAddButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {

                if (!isEmpty(leftTextFields)) {
                    String courseID = "";
                    String courseName = "";
                    int duration = -1;
                    String level = "";
                    String credit = "";
                    int noOfAssessments = -1;

                    for (JTextField textField : leftTextFields) {
                        if (textField.getName().equals("CourseID:")) {
                            courseID = textField.getText();
                        } else if (textField.getName().equals("Course Name:")) {
                            courseName = textField.getText();
                        } else if (textField.getName().equals("Duration:")) {

                            String errMessage = String.format("%s field requires a number.", textField.getName());
                            if (numberParse(textField.getText(), errMessage) == -1) {
                                break;
                            }
                            duration = numberParse(textField.getText(), errMessage);

                        } else if (textField.getName().equals("Level:")) {
                            level = textField.getText();
                        } else if (textField.getName().equals("Credit:")) {
                            credit = textField.getText();
                        } else if (textField.getName().equals("Assessments:")) {
                            String errMessage = String.format("%s field requires a number.", textField.getName());
                            noOfAssessments = numberParse(textField.getText(), errMessage);
                        }
                    }

                    if (courseID.equals("") || courseName.equals("") || level.equals("") || credit.equals("")
                            || duration == -1 || noOfAssessments == -1) {
                        // continue;

                    } else if (courseExist(courseID, academicCourseList)) {

                    } else {
                        academicCourseList.add(
                                new AcademicCourse(courseID, courseName, duration, level, credit, noOfAssessments));
                        addedSucessfullyDialog();
                    }

                }

            }

        });

        registerAcademicCourse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                if (!isEmpty(rightTextFields)) {
                    String courseID = "";
                    String instructorName = "";
                    String courseLeader = "";
                    String startingDate = "";
                    String completionDate = "";

                    for (JTextField textField : rightTextFields) {
                        // System.out.println(textField.getName());
                        if (textField.getName().equals("CourseID:")) {
                            courseID = textField.getText();
                        } else if (textField.getName().equals("Instructor Name:")) {
                            instructorName = textField.getText();
                        } else if (textField.getName().equals("Course Leader:")) {
                            courseLeader = textField.getText();
                        } else if (textField.getName().equals("Starting Date:")) {
                            startingDate = textField.getText();
                        } else if (textField.getName().equals("Completion Date:")) {
                            completionDate = textField.getText();
                        }
                    }

                    if (courseID.equals("") || instructorName.equals("") || courseLeader.equals("")
                            || startingDate.equals("") || completionDate.equals("")) {

                    } else if (isCourseRegistered(courseID)) {
                    } else {
                        boolean found = false;
                        for (AcademicCourse course : academicCourseList) {
                            if (course.getCourseID().equals(courseID)) {
                                course.register(courseLeader, instructorName, startingDate, completionDate);
                                courseAddedMessage();
                                found = true;
                            }

                        }
                        if (!found) {
                            courseNotFoundOnRegister();
                        }
                    }
                }
            }
        });

        display.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                String[] columnHeading = { "CourseID", "Course Name", "Duration", "Lecturer Name", "Level", "Credit",
                        "Starting Date", "Completion Date", "No. of Assessment", "Registered" };
                String[][] data = new String[academicCourseList.size()][10];
                int index = 0;
                for (AcademicCourse course : academicCourseList) {
                    // course.display();
                    data[index][0] = course.getCourseID();
                    data[index][1] = course.getCourseName();
                    data[index][2] = String.format("%d", course.getDuration());
                    data[index][3] = course.getLecturerName();
                    data[index][4] = course.getLevel();
                    data[index][5] = course.getCredit();
                    data[index][6] = course.getStartingDate();
                    data[index][7] = course.getCompletionDate();
                    data[index][8] = String.format("%d", course.getNumberOfAssessments());
                    data[index][9] = String.format("%s", course.getIsRegistered());
                    index++;
                }
                JFrame display = new JFrame();
                display.setSize(1280, 720);
                display.setVisible(true);
                JTable table = new JTable(data, columnHeading);
                JScrollPane plane = new JScrollPane(table);
                display.add(plane);

            }
        });
        nonAcademicacademicAddButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                if (!isEmpty(nonAcademicLeftTextFields)) {
                    String courseID = "";
                    String courseName = "";
                    int duration = -1;
                    String prerequisites = "";

                    for (JTextField textField : nonAcademicLeftTextFields) {
                        if (textField.getName().equals("CourseID:")) {
                            courseID = textField.getText();
                        } else if (textField.getName().equals("Course Name:")) {
                            courseName = textField.getText();
                        } else if (textField.getName().equals("Duration:")) {

                            String errMessage = String.format("%s field requires a number.", textField.getName());
                            if (numberParse(textField.getText(), errMessage) == -1) {
                                break;
                            }
                            duration = numberParse(textField.getText(), errMessage);

                        } else if (textField.getName().equals("Pre-requisites:")) {
                            prerequisites = textField.getText();
                        }
                    }

                    if (courseID.equals("") || courseName.equals("") || prerequisites.equals("") || duration == -1) {
                        // continue;

                    } else if (courseExistNonAcademic(courseID, nonAcademicCourseList)) {

                    } else {
                        nonAcademicCourseList.add(new NonAcademicCourse(courseID, courseName, duration, prerequisites));
                        addedSucessfullyDialog();
                    }

                }
            }
        });

        nonAcademicDisplay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {

                String[] columnHeading = { "CourseID", "Course Name", "Duration", "Prerequisites", "Instructor Name",
                        "Starting Date", "Completion Date", "Exam Date", "Registered", "Removed" };
                String[][] data = new String[nonAcademicCourseList.size()][10];
                int index = 0;
                for (NonAcademicCourse course : nonAcademicCourseList) {
                    // course.display();
                    data[index][0] = course.getCourseID();
                    data[index][1] = course.getCourseName();
                    data[index][2] = String.format("%d", course.getDuration());
                    data[index][3] = course.getPrerequisite();
                    data[index][4] = course.getInstructorName();
                    data[index][5] = course.getStartingDate();
                    data[index][6] = course.getCompletionDate();
                    data[index][7] = course.getExamDate();
                    data[index][8] = String.format("%s", course.getIsRegistered());
                    data[index][9] = String.format("%s", course.getIsRemoved());
                    index++;
                }
                JFrame display = new JFrame();
                display.setSize(1280, 720);
                display.setVisible(true);
                JTable table = new JTable(data, columnHeading);
                JScrollPane plane = new JScrollPane(table);
                display.add(plane);
            }
        });

        nonAcademicregisterAcademicCourse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                if (!isEmpty(nonAcademicRightTextFields)) {
                    String courseID = "";
                    String instructorName = "";
                    String courseLeader = "";
                    String startingDate = "";
                    String completionDate = "";
                    String examDate = "";

                    for (JTextField textField : nonAcademicRightTextFields) {
                        // System.out.println(textField.getName());
                        if (textField.getName().equals("CourseID:")) {
                            courseID = textField.getText();
                        } else if (textField.getName().equals("Instructor Name:")) {
                            instructorName = textField.getText();
                        } else if (textField.getName().equals("Course Leader:")) {
                            courseLeader = textField.getText();
                        } else if (textField.getName().equals("Starting Date:")) {
                            startingDate = textField.getText();
                        } else if (textField.getName().equals("Completion Date:")) {
                            completionDate = textField.getText();
                        } else if (textField.getName().equals("Exam Date:")) {
                            examDate = textField.getText();
                        }
                    }

                    if (courseID.equals("") || instructorName.equals("") || courseLeader.equals("")
                            || startingDate.equals("") || completionDate.equals("") || examDate.equals("")) {

                    } else if (isCourseRegisteredNonAcademic(courseID)) {
                    } else {
                        boolean found = false;
                        for (NonAcademicCourse course : nonAcademicCourseList) {
                            if (course.getCourseID().equals(courseID)) {
                                course.register(courseLeader, instructorName, startingDate, completionDate, examDate);
                                courseAddedMessage();
                                found = true;
                            }

                        }
                        if (!found) {
                            courseNotFoundOnRegister();
                        }
                    }
                }
            }
        });

        remove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                boolean isRemoved = false;
                for (int i = 0; i < nonAcademicCourseList.size(); i++) {
                    if (nonAcademicCourseList.get(i).getCourseID().equals(nonAcademicLeftTextFields[0].getText())) {
                        nonAcademicCourseList.remove(i);
                        isRemoved = !isRemoved;
                        removedMessage();
                    }

                }
                if (!isRemoved) {
                    courseNotFoundToRemove();
                }
            }
        });

    }

    public void courseNotFoundToRemove() {
        JOptionPane.showMessageDialog(this, "CourseID did not match in database to remove", "Removal Failed",
                JOptionPane.ERROR_MESSAGE);
    }

    public void removedMessage() {
        JOptionPane.showMessageDialog(this, "Course sucessfully removed.");
    }

    public void courseAddedMessage() {
        JOptionPane.showMessageDialog(this, "The course is registered.", "Registration Successful",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public void courseNotFoundOnRegister() {
        JOptionPane.showMessageDialog(this, "Sorry, The courseID was not found in database.", "Course not Present",
                JOptionPane.PLAIN_MESSAGE);
    }

    public boolean isCourseRegistered(String courseID) {
        for (AcademicCourse course : academicCourseList) {
            if (course.getCourseID().equals(courseID) && course.getIsRegistered()) {
                JOptionPane.showMessageDialog(this, "Sorry, The course is already registered.",
                        "Course Already Registered", JOptionPane.INFORMATION_MESSAGE);
                return true;
            }
        }
        return false;
    }

    public boolean isCourseRegisteredNonAcademic(String courseID) {
        for (NonAcademicCourse course : nonAcademicCourseList) {
            if (course.getCourseID().equals(courseID) && course.getIsRegistered()) {
                JOptionPane.showMessageDialog(this, "Sorry, The course is already registered.",
                        "Course Already Registered", JOptionPane.ERROR_MESSAGE);
                return true;
            }
        }
        return false;
    }

    public boolean courseExist(String courseId, ArrayList<AcademicCourse> coursesList) {
        for (AcademicCourse individualCourse : coursesList) {
            if (individualCourse.getCourseID().equals(courseId)) {
                JOptionPane.showMessageDialog(this, "The course already exists.", "Duplicate Entry Found",
                        JOptionPane.ERROR_MESSAGE);
                return true;
            }
        }
        return false;

    }

    public boolean courseExistNonAcademic(String courseId, ArrayList<NonAcademicCourse> coursesList) {
        for (NonAcademicCourse individualCourse : coursesList) {
            if (individualCourse.getCourseID().equals(courseId)) {
                JOptionPane.showMessageDialog(this, "The course already exists.", "Duplicate Entry Found",
                        JOptionPane.ERROR_MESSAGE);
                return true;
            }
        }
        return false;

    }

    public void addedSucessfullyDialog() {
        JOptionPane.showMessageDialog(this, "Your course was sucessuflly added.");
    }

    public int numberParse(String number, String errMsg) {
        // Takes a string and trys to extract integer from the string
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, errMsg, "Invalid Value Provided", JOptionPane.ERROR_MESSAGE);
            return -1;
        }
    }

    public boolean isEmpty(JTextField[] list) {
        // This function checks if textfield is empty or not. If textfield is found to
        // be empty then a dialog box is displayed
        for (JTextField textField : list) {
            if (textField.getText().equals("")) {
                String data = String.format("%s is found empty", textField.getName());
                JOptionPane.showMessageDialog(this, data, "Empty Field Detected", JOptionPane.ERROR_MESSAGE);
                return true;
            }
        }
        return false;

    }

    public static void main(String[] args) {
        INGCollege window = new INGCollege();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);

    }
}