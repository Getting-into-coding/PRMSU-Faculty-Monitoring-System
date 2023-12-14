import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

public class addSection extends JDialog 
{
	
	JButton addBtn;
	JPanel Body;
	addPreparation prep = new addPreparation();
	int currentRow;

	public addSection() 
	{
		getContentPane().setBackground(SystemColor.text);
		
		// Set the dimensions and location of the JFrame to center it
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        int frameWidth = 610;
        int frameHeight = 500;
        int x = (screenWidth - frameWidth) / 2;
        int y = (screenHeight - frameHeight) / 2;

		Image logo;
            try {
                logo = ImageIO.read(addSection.class.getResourceAsStream("/Images/addsubjecticon16x.png"));
                this.setIconImage(logo);
            } catch (IOException e) {
                e.printStackTrace();
            }
        

        setBounds(x, y, frameWidth, frameHeight);
		setTitle("Add Subject");
		getContentPane().setLayout(null);
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(null);
			buttonPane.setBounds(0, 425, 600, 38);
			buttonPane.setBackground(SystemColor.textHighlight);
			getContentPane().add(buttonPane);
			buttonPane.setLayout(null);
			{
				addBtn = new JButton("Add");
				addBtn.setBackground(SystemColor.text);
				addBtn.setForeground(Color.BLACK);
				//addBtn.setBorder(new LineBorder(SystemColor.textText, 1, true));
				addBtn.setFont(new Font("Arial", Font.BOLD, 12));
				addBtn.setBounds(215, 10, 75, 20);
				addBtn.setActionCommand("OK");
				buttonPane.add(addBtn);
				getRootPane().setDefaultButton(addBtn);
			}
			{
				JButton cancelButton = new JButton("Back");
				cancelButton.setBackground(SystemColor.text);
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				//cancelButton.setBorder(new LineBorder(SystemColor.textText, 1, true));
				cancelButton.setFont(new Font("Arial", Font.BOLD, 12));
				cancelButton.setBounds(315, 10, 75, 20);
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		{
			JPanel HeaderPane = new JPanel();
			HeaderPane.setLayout(null);
			HeaderPane.setBorder(null);
			HeaderPane.setBackground(SystemColor.textHighlight);
			HeaderPane.setBounds(0, 0, 600, 40);
			getContentPane().add(HeaderPane);
			{
				JLabel addLbl = new JLabel("Add Section");
				addLbl.setHorizontalAlignment(SwingConstants.CENTER);
				addLbl.setFont(new Font("Arial", Font.BOLD, 17));
				addLbl.setBackground(SystemColor.textHighlight);
				addLbl.setBounds(0, 10, 600, 20);
				HeaderPane.add(addLbl);
			}
		}
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBorder(null);
		scrollPane.setBounds(0, 75, 615, 350);
		scrollPane.getVerticalScrollBar().setUnitIncrement(10);
		getContentPane().add(scrollPane);
		
		Body = new JPanel();
		scrollPane.setViewportView(Body);
		Body.setBorder(null);
		Body.setBackground(SystemColor.text);
		Body.setLayout(new GridLayout(10, 1));
		
		JPanel Panel = new JPanel();
		Panel.setLayout(null);
		Panel.setBorder(null);
		Panel.setBackground(Color.WHITE);
		Panel.setBounds(10, 45, 550, 25);
		getContentPane().add(Panel);
		
		JLabel sectionLbl = new JLabel("Section");
		sectionLbl.setHorizontalAlignment(SwingConstants.CENTER);
		sectionLbl.setFont(new Font("Arial", Font.BOLD, 17));
		sectionLbl.setBorder(null);
		sectionLbl.setBounds(15, 0, 230, 25);
		Panel.add(sectionLbl);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(250, 2, 1, 20);
		Panel.add(separator);
		
		JLabel semesterLbl = new JLabel("Semester");
		semesterLbl.setHorizontalAlignment(SwingConstants.CENTER);
		semesterLbl.setFont(new Font("Arial", Font.BOLD, 17));
		semesterLbl.setBorder(null);
		semesterLbl.setBounds(255, 0, 135, 25);
		Panel.add(semesterLbl);
		
		JSeparator separator2 = new JSeparator();
		separator2.setOrientation(SwingConstants.VERTICAL);
		separator2.setBounds(395, 2, 1, 20);
		Panel.add(separator2);
		
		JLabel academicYearLbl = new JLabel("A.Y.");
		academicYearLbl.setHorizontalAlignment(SwingConstants.CENTER);
		academicYearLbl.setFont(new Font("Arial", Font.BOLD, 17));
		academicYearLbl.setBorder(null);
		academicYearLbl.setBounds(400, 0, 135, 25);
		Panel.add(academicYearLbl);
		
		JSeparator separator3 = new JSeparator();
		separator3.setBounds(10, 70, 580, 1);
		getContentPane().add(separator3);
	}
}
