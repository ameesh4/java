import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;

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

    public School addtField(int width, int height){
        JTextField txtField = new JTextField();
        txtField.setPreferredSize(new Dimension(width, height));
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

    public School addComboBox(ArrayList<String> s){
        s.add(0, "Select");
        Object[] comboboxlist = s.toArray();
        comboBox = new JComboBox(comboboxlist);
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
    static int j = 0;

    static void Refresh(ArrayList<JLabel> label, int startindex, int difference, ArrayList<Students> studentlist, int moveindex) throws Exception{
        if (moveindex == 1){
            j++;
        }else if(moveindex == 0){
            j = 0;
        }
        else if (moveindex == -1){
            j--;
        }
        else{
            throw new IllegalArgumentException("Invalid move index");
        }

        if(j < 0){
            j = 0;
            throw new Exception("No more records");
        }
        else if (j >= studentlist.size()){
            j = studentlist.size() - 1;
            throw new Exception("No more records");
        }

        int i = startindex;
        label.get(i).setText(studentlist.get(j).getStudentId());
        label.get(i + difference).setText(studentlist.get(j).getStudentName());
        label.get(i + difference * 2).setText(studentlist.get(j).getGender());
        label.get(i + difference * 3).setText(studentlist.get(j).getCourse());
        label.get(i + difference * 4).setText(studentlist.get(j).getDepartment());
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
                .addtField(100, 10)
                .addLabel("Student Name:")
                .addtField()
                .addLabel("Gender:")
                .addLabel("")
                .addRadioButton("Male")
                .addRadioButton("Female")
                .addLabel("Course:")
                .addCheckBox("Physics")
                .addLabel("")
                .addCheckBox("Chemistry")
                .addLabel("")
                .addCheckBox("Mathematics")
                .addLabel("Department:")
                .addComboBox(new ArrayList<String>(Arrays.asList("Science", "Arts", "Commerce")));


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
                        JOptionPane.showMessageDialog(studentform, exception.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    } finally{
                        String course = "";
                        for (JCheckBox checkBox : checkBoxes) {
                            if (checkBox.isSelected()) {
                                course += checkBox.getText() + " ";
                            }
                        }
                        if(course == ""){
                            JOptionPane.showMessageDialog(studentform, "Please select a course", "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }

                        student.setCourse(course);

                        student.setDepartment(comboBox.getSelectedItem().toString());
                        studentlist.add(student);
                        JOptionPane.showMessageDialog(studentform, "Student Registered Successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                    }
                });

        School view = new School();
        ArrayList<JLabel> label =  view.getLabel();

        view.addPanel(new BorderLayout(), BorderLayout.NORTH).addLabel("Students");
        view.addPanel(new FlowLayout(), BorderLayout.NORTH)
                .addButton("Previous", (ActionEvent e)->{
                    try{
                        Refresh(label, 4, 2, studentlist, -1);
                    }catch (Exception exception){
                        JOptionPane.showMessageDialog(view, exception.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                })
                .addButton("Next", (ActionEvent e)->{
                    try{
                        Refresh(label, 4, 2, studentlist, 1);
                    }catch (Exception exception){
                        JOptionPane.showMessageDialog(view, exception.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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
                    try{
                        Refresh(label, 4, 2, studentlist, 0);
                    }catch (Exception exception){
                        JOptionPane.showMessageDialog(view, exception.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
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