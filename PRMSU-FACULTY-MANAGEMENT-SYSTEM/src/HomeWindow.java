import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.imageio.ImageIO;
import javax.print.attribute.standard.MediaSize.NA;
import javax.swing.BorderFactory;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

public class HomeWindow {
        JFrame HomeWindow;
        JPanel RootPanel, NaviPanel, HomePanel, DashPanel, ReportPanel;
        JButton HomeButton, ListFacButton, ReportButton, HelpButton, LogoutButton;
        JLabel UnivLogo, HPimage;
        JPanel VideoPanel;
        Canvas canvas;

        //For list of faculty
        JPanel jt,sp;
        DefaultTableModel model;
        JTable table;
        JScrollPane scrollPane;
        JButton button;
        JTextField Search;

        //For Reporting
        JPanel jt2;
        DefaultTableModel model2;
        JTable table2;
        JScrollPane scrollPane2;
        JLabel report;
        JButton button2;
        JTextField Search2;

    
        HomeWindow(){

            //Constant Variables
            int textboxheight = 20;
            Color backgroundColor = new Color(0,0,122);
            Color complimentColor = new Color(0, 122, 122);
            Color TextHighlightColor = new Color(236,189,68);

            //Instantiations
            HomeWindow = new JFrame();

            RootPanel = new JPanel();
            NaviPanel = new JPanel();
            HomePanel = new JPanel();
            DashPanel = new JPanel();
            ReportPanel = new JPanel();

            HomeButton = new JButton();
            ListFacButton = new JButton();
            ReportButton = new JButton();
            HelpButton = new JButton();
            LogoutButton = new JButton();

            UnivLogo = new JLabel();

            //Code of list of faculty

            JPanel jt,sp;
            DefaultTableModel model;
            JTable table;
            JScrollPane scrollPane;
            JButton button;
            JTextField Search;
        
        
        // list of fac
        String[] columnNames = {"Full Name","Department","A.Y.","Semester","Edit"};

        // Data
        Object[][] data = {
            {"Faculty 1", "Computer Engineering", "2023-2024", "1st Semester", "Add, Edit, Delete"}
        };
        
        //table model
        model = new DefaultTableModel(data, columnNames);
        
        class CenterRenderer extends DefaultTableCellRenderer {
             public CenterRenderer() {
        setHorizontalAlignment(JLabel.CENTER);
             }
            };
        
        // table with the model
        table = new JTable(model){
            public TableCellRenderer getCellRenderer(int row, int column) {
                if (column == 4) {
                    return new MultiButtonRenderer();
                }
                return super.getCellRenderer(row, column);
            }
        };
        
        
        table.setBounds(10, 10, 100, 100);
        table.getTableHeader().setBounds(0,0, 50,30);
        table.getTableHeader().setFont(new Font("ARIAL",Font.BOLD,16));
        table.getTableHeader().setBackground(new Color(57, 167, 255));
        table.setGridColor(Color.BLACK);
        table.setShowGrid(true);
        table.setRowHeight(60);
        table.setFont(new Font("ARIAL", Font.PLAIN, 10));
        
        //scroll pane
        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 10, 1145, 400);
        
        //Rendere of each input in table
        CenterRenderer centerRenderer = new CenterRenderer();
        for (int i = 0; i < table.getColumnCount(); i++) {
         table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
       
        //table panel
        jt = new JPanel();
        jt.setBounds(10,70,1165,500);
        jt.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        jt.setLayout(null); 
        jt.add(scrollPane);
        
        //search
        Search = new JTextField("Search");
        Search.setBounds(1020,30,150,30);
        
         // button
         button = new JButton("Add Row");
         button.setBounds(10, 30, 100, 30);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.addRow(new Object[]{" ", " ", " ", " ", "Add, Edit,Delete"});
            }
        });

        //button and search panel
        sp = new JPanel();
        sp.setBounds(10,10,500,100);
        sp.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        sp.setLayout(null);
        sp.add(Search);
        sp.add(button);

        DashPanel.add(jt);
        DashPanel.add(sp);


    class MultiButtonRenderer extends JPanel implements TableCellRenderer {

        public MultiButtonRenderer() {
            setOpaque(true);
            setLayout(new FlowLayout(FlowLayout.CENTER));
        }

        public Component getTableCellRendererComponent(JTable table, Object value,
                                                       boolean isSelected, boolean hasFocus, int row, int column) {
            removeAll(); // Remove all existing components
            if (value != null) {
                String[] labels = value.toString().split(","); // Split the cell value into button labels
                for (String label : labels) {
                    JButton button = new JButton(label.trim());
                    
                    button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Add your custom button behavior here
                        System.out.println("Button " + label + " clicked");
                    }
                });
                    
                    add(button);
                    // Add an action listener to the button here, if needed
                }
            }
            return this;
        }
    }

    
        //For reporting

        String[] columnNames2 = {"Name","Department","File","Semester","Status"};

        // Data
        Object[][] data2 = {
            {"Froilan Cantillo", "Computer Engineering", "COR", "1st Semester", "Not Uploaded"},
            {"Michael Romualdo", "Mechanical Engineering", "Quiz 1", "1st Semester", "Not Uploaded"},
            {"Eloisa Romulo", "Civil Engineering", "Test", "1st Semester", "Not Uploaded"},
            {"Grecelia Dullas", "Electrical Engineering", "Activity 2", "1st Semester", "Not Uploaded"},
        };
        
        //table model
        model2 = new DefaultTableModel(data2, columnNames2);
        
        class CenterRenderer2 extends DefaultTableCellRenderer {
             public CenterRenderer2() {
        setHorizontalAlignment(JLabel.CENTER);
        }
    }
         
        //table with the model
        table2 = new JTable(model2);
        table2.setBounds(10, 10, 100, 100);
        table2.getTableHeader().setBounds(0,0, 50,30);
        table2.getTableHeader().setFont(new Font("ARIAL",Font.BOLD,16));
        table2.getTableHeader().setBackground(new Color(57, 167, 255));
        table2.setGridColor(Color.BLACK);
        table2.setShowGrid(true);
        table2.setRowHeight(60);
        table2.setFont(new Font("ARIAL", Font.PLAIN, 10));
        
        //scroll pane
        scrollPane2 = new JScrollPane(table2);
        scrollPane2.setBounds(10, 50, 1445, 400);
        
        //Rendere of each input in table
        CenterRenderer centerRenderer2 = new CenterRenderer();
        for (int i = 0; i < table2.getColumnCount(); i++) {
         table2.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        
        //report
        report = new JLabel("REPORT");
        report.setBounds(30, 10, 200, 30);
        report.setFont(new Font("ARIAL", Font.BOLD, 30));
        
        //button
        button2 = new JButton("Export");
        button2.setBounds(1320, 460, 100, 30);
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        
        //table panel
        jt2 = new JPanel();
        jt2.setBounds(10,70,1465,800);
        jt2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        jt2.setLayout(null);
        jt2.add(scrollPane2);
        jt2.add(report);
        jt2.add(button2);

        ReportPanel.add(jt2);



            //Root Panel is the master of all sub panels
            RootPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            //RootPanel.setBackground(bgColor);
            RootPanel.setBounds(0,0,1080, 720);
            RootPanel.setLayout(null);

            
            //The Navigation Panel is the Panel for the buttons such as "Home", "List", "Report", etc.
            NaviPanel.setBorder(BorderFactory.createLineBorder(TextHighlightColor));
            NaviPanel.setBounds(0,0,180, 720);
            NaviPanel.setBackground(SystemColor.textHighlight);
            NaviPanel.setLayout(null);

            VideoPanel = new JPanel(new BorderLayout());
            canvas = new Canvas();

            //The Home Panel will host the video slideshow Marlou and Ralph proposed
            //The Color BG is a placeholder
            HomePanel.setBorder(BorderFactory.createLineBorder(TextHighlightColor));
            HomePanel.setBounds(180,0,900, 720);
            HomePanel.setLayout(null);
            DashPanel.setVisible(true);

            VideoPanel.setVisible(true);

            //The Dash Panel will host the List of Faculty and all of its components, tables, etc.
            //The Color BG is a placeholder
            DashPanel.setBorder(BorderFactory.createLineBorder(TextHighlightColor));
            DashPanel.setBounds(180,0,900, 720);
            DashPanel.setLayout(null);
            DashPanel.setVisible(false);

            //The Report Panel will host the Report page and all of its component, tables, etc.
            //The Color BG is a placeholder
            ReportPanel.setBorder(BorderFactory.createLineBorder(TextHighlightColor));
            ReportPanel.setBounds(180,0,900 , 720);
            ReportPanel.setLayout(null);
            ReportPanel.setVisible(false);


            //GUIs of NaviPanel
            //Code for Logo
            UnivLogo = new JLabel();
            Image image;
            try {
                image = ImageIO.read(LoginWindow.class.getResourceAsStream("/Images/UniLogox100.png"));
                 ImageIcon imageIcon = new ImageIcon(image);
                UnivLogo.setIcon(imageIcon);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            UnivLogo.setBounds(40, 20, 100, 100);    

            HomeButton.setText("Home");
            HomeButton.setBorder(BorderFactory.createLineBorder(TextHighlightColor));
            HomeButton.setBackground(complimentColor);
            HomeButton.setForeground(Color.WHITE);
            HomeButton.setBounds(40,150,100,30);
            HomeButton.setFocusable(false);

            ListFacButton.setText("List of Faculty");
            ListFacButton.setBorder(BorderFactory.createLineBorder(TextHighlightColor));
            ListFacButton.setBackground(complimentColor);
            ListFacButton.setForeground(Color.WHITE);
            ListFacButton.setBounds(40,200,100,30);
            ListFacButton.setFocusable(false);

            ReportButton.setText("Report");
            ReportButton.setBorder(BorderFactory.createLineBorder(TextHighlightColor));
            ReportButton.setBackground(complimentColor);
            ReportButton.setForeground(Color.WHITE);
            ReportButton.setBounds(40,250,100,30);
            ReportButton.setFocusable(false);

            HelpButton.setText("Help");
            HelpButton.setBorder(BorderFactory.createLineBorder(TextHighlightColor));
            HelpButton.setBackground(complimentColor);
            HelpButton.setForeground(Color.WHITE);
            HelpButton.setBounds(40,300,100,30);
            HelpButton.setFocusable(false);

            LogoutButton.setText("Logout");
            LogoutButton.setBorder(BorderFactory.createLineBorder(TextHighlightColor));
            LogoutButton.setBackground(complimentColor);
            LogoutButton.setForeground(Color.WHITE);
            LogoutButton.setBounds(40,350,100,30);
            LogoutButton.setFocusable(false);

            NaviPanel.add(UnivLogo);
            NaviPanel.add(HomeButton);
            NaviPanel.add(ListFacButton);
            NaviPanel.add(ReportButton);
            NaviPanel.add(HelpButton);
            NaviPanel.add(LogoutButton);


            //Action listeners of buttons

            HomeButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) 
                {
                        HomePanel.setVisible(true);
                        HomePanel.setEnabled(true);

                        VideoPanel.setVisible(true);
                        VideoPanel.setEnabled(true);

                        DashPanel.setVisible(false);
                        DashPanel.setEnabled(false);

                        ReportPanel.setVisible(false);
                        ReportPanel.setEnabled(false);
                    }
            });

            ListFacButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) 
                {
                        HomePanel.setVisible(false);
                        HomePanel.setEnabled(false);

                        VideoPanel.setVisible(false);
                        VideoPanel.setEnabled(false);

                        DashPanel.setVisible(true);
                        DashPanel.setEnabled(true);

                        ReportPanel.setVisible(false);
                        ReportPanel.setEnabled(false);
                    }
            });

            ReportButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) 
                {
                        HomePanel.setVisible(false);
                        HomePanel.setEnabled(false);

                        VideoPanel.setVisible(false);
                        VideoPanel.setEnabled(false);

                        DashPanel.setVisible(false);
                        DashPanel.setEnabled(false);
                        
                        ReportPanel.setVisible(true);
                        ReportPanel.setEnabled(true);
                    }
            });

            HelpButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) 
                {
                        //Maybe have this button open up the user manual
                        //once we've ever get to making it
                    }
            });

            LogoutButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) 
                {
                        System.out.println("Welcome!");
                        LoginWindow loginWin = new LoginWindow();
                        HomeWindow.dispose();
                        
                    }
            });

            //VLC video player
            VideoPanel.add(canvas);
            VideoPanel.setPreferredSize(new Dimension(900, 720));

            //Adding of Components to the window
            RootPanel.add(NaviPanel);
            //RootPanel.add(HomePanel);
            RootPanel.add(DashPanel);
            RootPanel.add(ReportPanel);
            RootPanel.add(VideoPanel);

            //Window Essentials
            HomeWindow.setTitle("COE Faculty Monitoring System");
            HomeWindow.setLayout(null);
            HomeWindow.setSize(1080, 720);
            HomeWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            HomeWindow.setContentPane(RootPanel);
            
            HomeWindow.setUndecorated(true);
            HomeWindow.setResizable(false);
            HomeWindow.getContentPane().setLayout(null);
            HomeWindow.setVisible(true);

            VideoPanel.setBounds(180, 0, VideoPanel.getPreferredSize().width, VideoPanel.getPreferredSize().height);

            //Responsible for making the window open on the center of the screen on start up
            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
            int w = HomeWindow.getSize().width;
            int h = HomeWindow.getSize().height;
            int x = (dim.width-w)/2;
            int y = (dim.height-h)/2;
            HomeWindow.setLocation(x,y);
                
        
        }

        public static void main(String[] args) {
            new HomeWindow();
        }
}
