import javax.swing.*;

import java.util.ArrayList;
import java.util.List;

import UploadDocTreeNodes.*;

import java.awt.*;

public class UploadDocWindow {

    JPanel TreeTablePanel, PreviewPanel, TopPanel;
    JLabel Department;
    JComboBox CFacultyName, CSchoolYear, CSemester;
    
    UploadDocWindow(){

        JFrame UploadDocFrame = new JFrame("Upload Documents");

        TreeTablePanel = new JPanel();
        PreviewPanel = new JPanel();
        TopPanel = new JPanel();

        Department = new JLabel();

        CFacultyName = new JComboBox<>();
        CSchoolYear = new JComboBox<>();
        CSemester = new JComboBox<>();

        TreeTablePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        TreeTablePanel.setBounds(5,100,580, 575);
        TreeTablePanel.setLayout(new BorderLayout());
        //TreeTablePanel.setBackground();

        PreviewPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        PreviewPanel.setBounds(600,100,450, 575);
        PreviewPanel.setLayout(new BorderLayout());
        //PreviewPanel.setBackground();

        //TopPanel.setBorder(BorderFactory.createLineBorder(Color.gold));
        TopPanel.setBounds(0,0,1080, 75);
        TopPanel.setLayout(null);
        TopPanel.setBackground(Color.blue);

        String[] FacultyName = {"Daniel Mercurio", "Danilo Llaga", "Ralph Farinas"};
        String[] SchoolYear = {"2023-2024", "2024-2025", "2025-2026"};
        String[] Semester = {"1st Semester", "2nd Semester", "Mid Year"};

        int topcompwidth = 200, yaxis = 25;


            for (String Name : FacultyName) {
                CFacultyName.addItem(Name);
            }
        CFacultyName.setBounds(5,yaxis, topcompwidth, 25);

            for (String Year : SchoolYear) {
                CSchoolYear.addItem(Year);
            }

        Department.setText("Computer Engineering");
        Department.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        Department.setBackground(Color.white);
        Department.setOpaque(true);
        Department.setLayout(null);
        Department.setHorizontalAlignment(SwingConstants.CENTER);
        Department.setBounds(topcompwidth+30,yaxis,topcompwidth+145, 25);

        CSchoolYear.setBounds((topcompwidth*3),yaxis, topcompwidth, 25);

            for (String Sem : Semester) {
                CSemester.addItem(Sem);
            }
        CSemester.setBounds((topcompwidth*4)+30,yaxis, topcompwidth, 25);

		List<String[]> content = new ArrayList<>();

        //This Section is just temporary placeholder for what the table will contain
        content.add(new String[] { "Load" });
        content.add(new String[] { "Teaching Load", "Uploaded", "04/11/2023" });

		content.add(new String[] { "Syllabus" });
		content.add(new String[] { "Software Design", "Uploaded", "04/11/2023" });
        content.add(new String[] { "Computer Aided Drafting", "Not Uploaded", "04/11/2023" });
        content.add(new String[] { "Programming Logic and Design", "Not Uploaded", "04/11/2023" });

		content.add(new String[] { "Class Record" });
        content.add(new String[] { "Software Design", " " });
		content.add(new String[] { "BSCpE 3A", "Uploaded", "04/11/2023" });
		content.add(new String[] { "BSCpE 3B", "Not Uploaded", "04/11/2023" });
		content.add(new String[] { "Computer Aided Drafting", " " });
		content.add(new String[] { "BSCpE 3A", "Not Uploaded", "04/11/2023" });
		content.add(new String[] { "BSCpE 3B", "Uploaded", "04/11/2023" });

        content.add(new String[] { "Grade Sheet" });
        content.add(new String[] { "Software Design", " " });
		content.add(new String[] { "BSCpE 3A", "Uploaded", "04/11/2023" });
		content.add(new String[] { "BSCpE 3B", "Not Uploaded", "04/11/2023" });
		content.add(new String[] { "Computer Aided Drafting", " " });
		content.add(new String[] { "BSCpE 3A", "Not Uploaded", "04/11/2023" });
		content.add(new String[] { "BSCpE 3B", "Uploaded", "04/11/2023" });
        
        content.add(new String[] { "Exam with Answer Key" });
        content.add(new String[] { "Midterm", " " });
		content.add(new String[] { "Software Design", "Uploaded", "04/11/2023" });
        content.add(new String[] { "Computer Aided Drafting", "Not Uploaded", "04/11/2023" });
        content.add(new String[] { "Programming Logic and Design", "Not Uploaded", "04/11/2023" });
		content.add(new String[] { "Final", " " });
		content.add(new String[] { "Software Design", "Uploaded", "04/11/2023" });
        content.add(new String[] { "Computer Aided Drafting", "Not Uploaded", "04/11/2023" });
        content.add(new String[] { "Programming Logic and Design", "Not Uploaded", "04/11/2023" });

        content.add(new String[] { "Table of Specification" });
        content.add(new String[] { "Midterm", " " });
		content.add(new String[] { "Software Design", "Uploaded", "04/11/2023" });
        content.add(new String[] { "Computer Aided Drafting", "Not Uploaded", "04/11/2023" });
        content.add(new String[] { "Programming Logic and Design", "Not Uploaded", "04/11/2023" });
		content.add(new String[] { "Final", " " });
		content.add(new String[] { "Software Design", "Uploaded", "04/11/2023" });
        content.add(new String[] { "Computer Aided Drafting", "Not Uploaded", "04/11/2023" });
        content.add(new String[] { "Programming Logic and Design", "Not Uploaded", "04/11/2023" });

        content.add(new String[] { "Item Analysis" });
        content.add(new String[] { "Midterm", " " });
		content.add(new String[] { "Software Design", "Uploaded", "04/11/2023" });
        content.add(new String[] { "Computer Aided Drafting", "Not Uploaded", "04/11/2023" });
        content.add(new String[] { "Programming Logic and Design", "Not Uploaded", "04/11/2023" });
		content.add(new String[] { "Final", " " });
		content.add(new String[] { "Software Design", "Uploaded", "04/11/2023" });
        content.add(new String[] { "Computer Aided Drafting", "Not Uploaded", "04/11/2023" });
        content.add(new String[] { "Programming Logic and Design", "Not Uploaded", "04/11/2023" });
        //End of placeholder section

		TreeTable treeTable = new TreeTable(content);
		UploadDocFrame.setLayout(new BorderLayout());

        TreeTablePanel.add(new JScrollPane(treeTable.getTreeTable()), BorderLayout.CENTER);
		//UploadDocFrame.add(new JScrollPane(treeTable.getTreeTable()), BorderLayout.CENTER);
        
        TopPanel.add(Department);
        TopPanel.add(CFacultyName);
        TopPanel.add(CSchoolYear);
        TopPanel.add(CSemester);
        

        UploadDocFrame.add(TreeTablePanel);
        UploadDocFrame.add(PreviewPanel);
        UploadDocFrame.add(TopPanel);

        //Window Essential
        UploadDocFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //UploadDocFrame.setUndecorated(true);
        UploadDocFrame.setSize(1080, 720);
        UploadDocFrame.setResizable(false);
        UploadDocFrame.getContentPane().setLayout(null);    

        //This is the function that is responsible for making the window appear centered on startup
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int w = UploadDocFrame.getSize().width;
        int h = UploadDocFrame.getSize().height;
        int x = (dim.width-w)/2;
        int y = (dim.height-h)/2;
        UploadDocFrame.setLocation(x,y);
        UploadDocFrame.setVisible(true);
		UploadDocFrame.setVisible(true);

    }
    public static void main(String[] args) {
        new UploadDocWindow();
    }
}
