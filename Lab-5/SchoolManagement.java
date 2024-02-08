import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

class School extends JFrame {
    private JPanel panel;
    private JLabel label;
    private ArrayList<JTextField> tField = new ArrayList<>();
    private JButton button;
    private ArrayList<JRadioButton> radioButton = new ArrayList<>();
    private ArrayList<JCheckBox> checkBox = new ArrayList<>();
    private ButtonGroup bg = new ButtonGroup();
    private JComboBox comboBox;
    private String[] comboboxlist;


    public School(){
//        this.add(this.panel);
//        this.setLayout(e);
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void setPanel(LayoutManager e){
        panel = new JPanel(e);
        this.add(this.panel);
    }

//    public School addPanel(LayoutManager e, String p){
//        panel = new JPanel(e);
//        this.add(this.panel, p);
//        return this;
//    }
    public School addLabel(String s){
        label = new JLabel(s);
        panel.add(label);
        return this;
    }

    public School addButton(String s, ActionListener e){
        button = new JButton(s);
        button.addActionListener(e);
        this.panel.add(button);
        return this;
    }

    public School addButton(String s){
        button = new JButton(s);
        this.panel.add(button);
        return this;
    }

    public School addtField(){
        JTextField txtField = new JTextField();
        panel.add(txtField);
        tField.add(txtField);
        return this;
    }

    public School addRadioButton(String s){
        JRadioButton rButton = new JRadioButton(s);
        bg.add(rButton);
        panel.add(rButton);
        radioButton.add(rButton);
        return this;
    }

    public School addCheckBox(String s){
        JCheckBox cBox = new JCheckBox(s);
        panel.add(cBox);
        checkBox.add(cBox);
        return this;
    }

    public School addComboBox(String[] s){
        comboBox = new JComboBox(s);
        this.comboboxlist = s;
        panel.add(comboBox);
        return this;
    }

    public ArrayList<JTextField> gettField(){
        return this.tField;
    }

    public ArrayList<JRadioButton> getRadioButton(){
        return this.radioButton;
    }

    public ArrayList<JCheckBox> getCheckBox(){
        return this.checkBox;
    }

//    public String[] getComboBoxList(){
//        return this.comboboxlist;
//    }

    public JComboBox getComboBox(){
        return this.comboBox;
    }


    public void setVisibility(boolean b){
        this.setVisible(b);
    }
}

class Students{
    private String studentId;
    private String studentName;
    private String gender;
    private String Course;
    private String Department;
    //getters and setters for Students' attributes
    public String getStudentId(){
        return this.studentId;
    }
    public void setStudentId(String studentId){
        this.studentId = studentId;
    }
    public String getStudentName(){
        return this.studentName;
    }
    public void setStudentName(String studentName){
        this.studentName = studentName;
    }
    public String getGender(){
        return this.gender;
    }
    public void setGender(String gender){
        this.gender = gender;
    }

    public String getCourse(){
        return this.Course;
    }

    public void setCourse(String Course){
        this.Course = Course;
    }

    public String getDepartment(){
        return this.Department;
    }

    public void setDepartment(String Department){
        this.Department = Department;
    }


}

class SchoolManagement{
    public static void main(String[] args) {
        School school = new School();
        School studentform = new School();
        Students student = new Students();
        studentform.setPanel(new GridLayout(9, 2));
        studentform.addLabel("Student ID:")
                .addtField()
                .addLabel("Student Name:")
                .addtField()
                .addLabel("Gender")
                .addRadioButton("Male")
                .addLabel("")
                .addRadioButton("Female")
                .addLabel("Course")
                .addCheckBox("Physics")
                .addLabel("")
                .addCheckBox("Chemistry")
                .addLabel("")
                .addCheckBox("Mathematics")
                .addLabel("Department")
                .addComboBox(new String[]{"Science", "Commerce", "Arts"})
                .addButton("Back", (ActionEvent e) -> {
                    studentform.setVisibility(false);
                    school.setVisibility(true);
                })
                .addButton("Register", (ActionEvent e) -> {
                    ArrayList<JTextField> tField = studentform.gettField();
                    student.setStudentId(tField.get(0).getText());
                    student.setStudentName(tField.get(1).getText());
                    ArrayList<JRadioButton> radioButtons = studentform.getRadioButton();
                    if (radioButtons.get(0).isSelected()) {
                        student.setGender(radioButtons.get(0).getText());
                    }else{
                        student.setGender(radioButtons.get(1).getText());
                    }
                    ArrayList<JCheckBox> checkBoxes = studentform.getCheckBox();
                    String course = "";
                    for (JCheckBox checkBox : checkBoxes) {
                        if (checkBox.isSelected()) {
                            course += checkBox.getText() + " ";
                        }
                    }
                    student.setCourse(course);
                    JComboBox comboBox = studentform.getComboBox();
                    student.setDepartment(comboBox.getSelectedItem().toString());
                });

        School view = new School();
        view.setPanel(new GridLayout(5, 2));
        view.addLabel("Student ID:")
                .addLabel(student.getStudentId())
                .addLabel("Student Name:")
                .addLabel(student.getStudentName())
                .addLabel("Gender")
                .addLabel(student.getGender())
                .addLabel("Course")
                .addLabel(student.getCourse())
                .addLabel("Department")
                .addLabel(student.getDepartment());



        school.setPanel(new GridLayout(1, 1));
        school.addButton("Register", (ActionEvent a) -> {
                    school.setVisibility(false);
                    studentform.setVisibility(true);
                })
                .addButton("View", (ActionEvent a) -> {
                    school.setVisibility(false);
                    view.setVisibility(true);
                });


        school.setVisibility(true);
    }
}