import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ViewPassword extends JFrame{

    private Color backColor = new Color(147, 147, 147);
    private Color offsetColor = new Color(192, 192, 192);

    private String websiteName = "randomwebsite.com";
    private String decryptedPassword = "abcdefg";

    JButton closeButton = new JButton("Close");
    JButton editButton = new JButton("Edit");

    public ViewPassword() {

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        initEvent();

        JLabel websiteNameLabel = new JLabel(websiteName, SwingConstants.CENTER);
        websiteNameLabel.setFont(new Font("Calibri", Font.BOLD, 20));
        c.anchor = GridBagConstraints.PAGE_START;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        c.insets = new Insets(5,5,5,5);
        c.fill = GridBagConstraints.HORIZONTAL;
        panel.add(websiteNameLabel, c);

        JTextField field = new JTextField(decryptedPassword,15);
        field.setBackground(offsetColor);
        field.setEditable(false);
        c.insets = new Insets(10,10,10,10);
        c.anchor = GridBagConstraints.PAGE_START;
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 2;
        panel.add(field, c);

        closeButton.setBorderPainted(false);
        closeButton.setFocusPainted(false);
        closeButton.setBackground(offsetColor);
        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 2;
        panel.add(closeButton, c);

        editButton.setBorderPainted(false);
        editButton.setFocusPainted(false);
        editButton.setBackground(offsetColor);
        c.gridx = 1;
        c.gridy = 2;
        c.fill = GridBagConstraints.HORIZONTAL;
        panel.add(editButton, c);

        panel.setBackground(backColor);

        this.getContentPane().add(panel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setTitle("View Password");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void initEvent(){
		this.addWindowListener(new WindowAdapter() {
		  public void windowClosing(WindowEvent e){
		   System.exit(1);
		  }
		});
        closeButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e)
        {
                dispose();
                new MainPage();    
        }
        });

        editButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                    dispose();
                    new EditPassword();    
            }
            });
    }


    public static void main(String[] args) {
        new ViewPassword();
    }
}