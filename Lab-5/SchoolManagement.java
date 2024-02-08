import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

class School extends JFrame {
    private JPanel panel;
    private ArrayList<JLabel> label = new ArrayList<>();
    private ArrayList<JTextField> tField = new ArrayList<>();
    private JButton button;
    private ArrayList<JRadioButton> radioButton = new ArrayList<>();
    private ArrayList<JCheckBox> checkBox = new ArrayList<>();
    private ButtonGroup bg = new ButtonGroup();
    private JComboBox comboBox;
    private String[] comboboxlist;



    public School(){
//        this.add(this.panel);
        this(new BorderLayout());
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public School(LayoutManager e){
//        this.add(this.panel);
        this.setLayout(e);
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void setPanel(LayoutManager e){
        panel = new JPanel(e);
        this.add(panel);
    }

    public School addPanel(LayoutManager e, String p){
        panel = new JPanel(e);
        this.add(this.panel, p);
        return this;
    }

    public School addPanel(LayoutManager e){
            JPanel panel = new JPanel(e);
            this.panel.add(panel);
            return this;
    }
    public School addLabel(String s){
        JLabel label = new JLabel(s);
        this.label.add(label);
        panel.add(label);
        return this;
    }

    public School addButton(String s, ActionListener e){
        button = new JButton(s);
        button.addActionListener(e);
        this.panel.add(button);
        return this;
    }

    public School addButton(String s, ActionListener e, int x, int y, int width, int height){
        button = new JButton(s);
        button.addActionListener(e);
        button.setBounds(x, y, width, height);
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

    public ArrayList<JLabel> getLabel(){
        return this.label;
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
    public void setStudentId(String studentId) throws Exception{
        if(studentId.isEmpty()){
            throw new Exception("Student ID cannot be null");
        }
        this.studentId = studentId;
    }
    public String getStudentName(){
        return this.studentName;
    }
    public void setStudentName(String studentName) throws Exception{
        if (studentName.isEmpty()){
            throw new Exception("Student name cannot be Empty");
        }
        this.studentName = studentName;
    }
    public String getGender(){
        return this.gender;
    }
    public void setGender(String gender) throws Exception{
        if (gender.isEmpty()){
            throw new Exception("Please Select a Gender");
        }
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
    static void Refresh(ArrayList<JLabel> label, int startindex, int difference, int getIndex, ArrayList<Students> studentlist){
        int i = startindex;
        label.get(i).setText(studentlist.get(getIndex).getStudentId());
        label.get(i + difference).setText(studentlist.get(getIndex).getStudentName());
        label.get(i + difference * 2).setText(studentlist.get(getIndex).getGender());
        label.get(i + difference * 3).setText(studentlist.get(getIndex).getCourse());
        label.get(i + difference * 4).setText(studentlist.get(getIndex).getDepartment());
    }
    public static void main(String[] args) {
        School school = new School();
        School studentform = new School();
        ArrayList<Students> studentlist = new ArrayList<>();

        studentform.addPanel(new BorderLayout(), BorderLayout.NORTH).addLabel("Student Registration Form: ");
        studentform.addPanel(new BorderLayout(), BorderLayout.WEST).addLabel("      ");
        studentform.addPanel(new BorderLayout(), BorderLayout.EAST).addLabel("      ");

        studentform.addPanel(new GridLayout(8, 2), BorderLayout.CENTER)
                .addLabel("Student ID:")
                .addtField()
                .addLabel("Student Name:")
                .addtField()
                .addLabel("Gender:")
                .addRadioButton("Male")
                .addLabel("")
                .addRadioButton("Female")
                .addLabel("Course:")
                .addCheckBox("Physics")
                .addLabel("")
                .addCheckBox("Chemistry")
                .addLabel("")
                .addCheckBox("Mathematics")
                .addLabel("Department:")
                .addComboBox(new String[]{"Science", "Commerce", "Arts"});

        studentform.addPanel(new FlowLayout(), BorderLayout.SOUTH)
                .addButton("Back", (ActionEvent e) -> {
                    studentform.setVisibility(false);
                    school.setVisibility(true);
                })
                .addButton("Register", (ActionEvent e) -> {
                    Students student = new Students();
                    ArrayList<JTextField> tField = studentform.gettField();
                    ArrayList<JRadioButton> radioButtons = studentform.getRadioButton();
                    ArrayList<JCheckBox> checkBoxes = studentform.getCheckBox();

                    JComboBox comboBox = studentform.getComboBox();

                    try {
                        student.setStudentId(tField.get(0).getText());
                        student.setStudentName(tField.get(1).getText());
                        if (radioButtons.get(0).isSelected()) {
                            student.setGender(radioButtons.get(0).getText());
                        }else{
                            student.setGender(radioButtons.get(1).getText());
                        }

                    } catch (Exception exception) {
                        JOptionPane error = new JOptionPane();
                        error.showMessageDialog(studentform, exception.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }

                    String course = "";
                    for (JCheckBox checkBox : checkBoxes) {
                        if (checkBox.isSelected()) {
                            course += checkBox.getText() + " ";
                        }
                    }
                    if(course == ""){
                        JOptionPane error = new JOptionPane();
                        error.showMessageDialog(studentform, "Please select a course", "Error", JOptionPane.ERROR_MESSAGE);
                    }

                    student.setCourse(course);

                    student.setDepartment(comboBox.getSelectedItem().toString());
                    studentlist.add(student);
                });

        School view = new School();
        int i = 0;
        ArrayList<JLabel> label =  view.getLabel();
        view.addPanel(new BorderLayout(), BorderLayout.NORTH).addLabel("Students");
        view.addPanel(new FlowLayout(), BorderLayout.NORTH)
                .addButton("Next", (ActionEvent e)->{
                    int j = 0;
                    if(j < studentlist.size() - 1){
                        j++;
                    }
                    if (studentlist.size() <= 0){
                        JOptionPane error = new JOptionPane();
                        error.showMessageDialog(view, "No students to display", "Error", JOptionPane.ERROR_MESSAGE);
                    }else {
                        Refresh(label, 4, 2, j, studentlist);
                    }

                });
        view.addPanel(new BorderLayout(), BorderLayout.WEST).addLabel("      ");
        view.addPanel(new BorderLayout(), BorderLayout.EAST).addLabel("      ");

        view.addPanel(new GridLayout(5, 2), BorderLayout.CENTER)
                .addLabel("Student ID:")
                .addLabel("")
                .addLabel("Student Name:")
                .addLabel("")
                .addLabel("Gender")
                .addLabel("")
                .addLabel("Course")
                .addLabel("")
                .addLabel("Department")
                .addLabel("");


        view.addPanel(new FlowLayout(), BorderLayout.SOUTH)
                .addButton("Refresh", (ActionEvent e) -> {
                    Refresh(label, 4, 2, 0, studentlist);
                })
                .addButton("Back", (ActionEvent e) -> {
                    view.setVisibility(false);
                    school.setVisibility(true);
                });


        school.setPanel(null);
        school.addButton("Register", (ActionEvent a) -> {
                    school.setVisibility(false);
                    studentform.setVisibility(true);
                }, 100, 200, 100, 100)
                .addButton("View", (ActionEvent a) -> {
                    school.setVisibility(false);
                    view.setVisibility(true);
                }, 250, 200, 100, 100);


        school.setVisibility(true);
    }
}