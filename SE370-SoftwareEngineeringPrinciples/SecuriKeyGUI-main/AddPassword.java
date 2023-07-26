import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.StandardOpenOption;

public class AddPassword extends JFrame{

    private Color backColor = new Color(147, 147, 147);
    private Color offsetColor = new Color(192, 192, 192);

    JButton cancelButton = new JButton("Cancel");
    JButton saveButton = new JButton("Save");

    JTextField passwordField = new JTextField(15);

    JTextField websiteField = new JTextField(15);

    public AddPassword() {

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        initEvent();

        JLabel websiteNameLabel = new JLabel("Website Name:");
        websiteNameLabel.setFont(new Font("Calibri", Font.BOLD, 20));
        c.anchor = GridBagConstraints.PAGE_START;
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(5,5,5,5);
        c.fill = GridBagConstraints.HORIZONTAL;
        panel.add(websiteNameLabel, c);


        websiteField.setBackground(offsetColor);
        c.gridx = 1;
        c.gridy = 0;
        panel.add(websiteField, c);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(new Font("Calibri", Font.BOLD, 20));
        c.anchor = GridBagConstraints.PAGE_START;
        c.gridx = 0;
        c.gridy = 1;
        panel.add(passwordLabel, c);

 
        passwordField.setBackground(offsetColor);
        c.gridx = 1;
        c.gridy = 1;
        panel.add(passwordField, c);

        cancelButton.setBorderPainted(false);
        cancelButton.setFocusPainted(false);
        cancelButton.setBackground(offsetColor);
        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 3;
        panel.add(cancelButton, c);

        saveButton.setBorderPainted(false);
        saveButton.setFocusPainted(false);
        saveButton.setBackground(offsetColor);
        c.gridx = 1;
        c.gridy = 3;
        c.fill = GridBagConstraints.HORIZONTAL;
        panel.add(saveButton, c);

        panel.setBackground(backColor);

        this.getContentPane().add(panel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setTitle("Add Password");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void initEvent(){
		this.addWindowListener(new WindowAdapter() {
		  public void windowClosing(WindowEvent e){
		   System.exit(1);
		  }
		});
        cancelButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e)
        {
            dispose();
            new MainPage();    
        }
        });
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                String input = passwordField.getText();
                WriteToFile("Passwords.txt", input);
                dispose();
                new MainPage();    
            }
        });
    }

       public static void WriteToFile(String info, String data)
	{
		try {
			FileWriter myWriter = new FileWriter(info);
			myWriter.write(data);
            System.lineSeparator();
			myWriter.close();

		} catch (IOException e)
		{
			errorHandle();
			e.printStackTrace();
		}
	}
    public static void errorHandle()
	{
		System.out.println("An error has occured.");		
	}



    public static void main(String[] args) {
        new AddPassword();
    }
}