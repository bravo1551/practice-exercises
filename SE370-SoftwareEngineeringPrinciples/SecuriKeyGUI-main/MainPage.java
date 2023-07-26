import java.io.BufferedReader;
import java.io.File; 	
import java.io.FileNotFoundException;
import java.io.FileWriter; 
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import java.io.FileReader;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.*;

public class MainPage extends JFrame{
    public String[] defaultValues =  {
            "amazon.com", "target.com", "clubpenguin.com", "coolmathgames.com", "khanacademy.org", "bankofamerica.com", "lego.com", "nike.com",
    };
    private JList jList = createJList();
    private Color backColor = new Color(147, 147, 147);
    private Color offsetColor = new Color(192, 192, 192);

    JButton editPasswordButton = new JButton("Edit Password");
    JButton addPasswordButton = new JButton("Add Password");
    JButton viewPasswordButton = new JButton("View Password");
    JButton deletePasswordButton = new JButton("Delete Password");


    public MainPage() {

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        initEvent();

        JLabel passwordsLabel = new JLabel("Securi-Key", SwingConstants.CENTER);
        passwordsLabel.setFont(new Font("Calibri", Font.BOLD, 30));
        c.anchor = GridBagConstraints.PAGE_START;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 4;
        c.insets = new Insets(5,5,5,5);
        c.fill = GridBagConstraints.HORIZONTAL;
        panel.add(passwordsLabel, c);

        c.ipady = 100;
        c.gridx = 0;
        c.gridy = 1;
        panel.add(new JScrollPane(jList), c);

        
        viewPasswordButton.setBorderPainted(false);
        viewPasswordButton.setFocusPainted(false);
        viewPasswordButton.setBackground(offsetColor);
        c.gridx = 0;
        c.gridy = 2;
        c.ipady = 0;
        panel.add(viewPasswordButton, c);

        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth = 1;
        c.fill = GridBagConstraints.VERTICAL;
        panel.add(createTextField(), c);


        addPasswordButton.setBorderPainted(false);
        addPasswordButton.setFocusPainted(false);
        addPasswordButton.setBackground(offsetColor);
        c.gridx = 1;
        c.gridy = 3;
        panel.add(addPasswordButton, c);

      
        editPasswordButton.setBorderPainted(false);
        editPasswordButton.setFocusPainted(false);
        editPasswordButton.setBackground(offsetColor);
        c.gridx = 2;
        c.gridy = 3;
        panel.add(editPasswordButton, c);

        
        deletePasswordButton.setBorderPainted(false);
        deletePasswordButton.setFocusPainted(false);
        deletePasswordButton.setBackground(offsetColor);
        c.gridx = 3;
        c.gridy = 3;
        panel.add(deletePasswordButton, c);

        panel.setBackground(backColor);

        this.getContentPane().add(panel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setTitle("Securi-Key Main");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private JTextField createTextField() {
        final JTextField field = new JTextField(15);
        field.setBackground(new Color(192, 192, 192));
        field.getDocument().addDocumentListener(new DocumentListener(){
            @Override public void insertUpdate(DocumentEvent e) { filter(); }
            @Override public void removeUpdate(DocumentEvent e) { filter(); }
            @Override public void changedUpdate(DocumentEvent e) {}
            private void filter() {
                String filter = field.getText();
                filterModel((DefaultListModel<String>)jList.getModel(), filter);
            }
        });
        return field;
    }

    private JList createJList() {
        JList list = new JList(createDefaultListModel());
        list.setBackground(new Color(192, 192, 192));
        list.setVisibleRowCount(6);
        return list;
    }

    private ListModel<String> createDefaultListModel() {
        DefaultListModel<String> model = new DefaultListModel<>();
        for (String s : defaultValues) {
            model.addElement(s);
        }
        return model;
    }

    public void filterModel(DefaultListModel<String> model, String filter) {
        for (String s : defaultValues) {
            if (!s.startsWith(filter)) {
                if (model.contains(s)) {
                    model.removeElement(s);
                }
            } else {
                if (!model.contains(s)) {
                    model.addElement(s);
                }
            }
        }
    }

    private void initEvent(){
		this.addWindowListener(new WindowAdapter() {
		  public void windowClosing(WindowEvent e){
		   System.exit(1);
		  }
		});
        viewPasswordButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e)
        {
                dispose();
                new ViewPassword();    
        }
        });
        addPasswordButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                    dispose();
                    new AddPassword();    
        }
        });
        deletePasswordButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                    dispose();
                    new DeleteConf();    
        }
        });
        editPasswordButton .addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                    dispose();
                    new EditPassword();    
        }
        });
    }

    private static void process(String line) {
        System.out.println(line);
    }

    public static void errorHandle()
	{
		System.out.println("An error has occured.");		
	}

    public static void readFile(String info) throws FileNotFoundException {
        BufferedReader reader = new BufferedReader(new FileReader(info));

        try {
            String line;

            while ((line = reader.readLine()) != null) {
                process(line);
            }
            reader.close();

        } 
        catch (FileNotFoundException e)
        {
            errorHandle();
            e.printStackTrace();
            
        }
        catch(IOException e) {
            errorHandle();
            e.printStackTrace();
        }


	}

    MainPage(String[] defaultValues){
        this.defaultValues = defaultValues;
    }

    public String[] getDefaultValues(){
        return this.defaultValues;
    }

    public void setDefaultValues(String[] newDefaultValues){
        this.defaultValues = newDefaultValues;
    }

    public static void main(String[] args) {
        new MainPage();
    }
}