import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmailGUI extends JFrame {
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JComboBox<String> departmentComboBox;
    private JTextArea outputArea;

    public EmailGUI() {
        setTitle("Email Application");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));

        // First Name
        panel.add(new JLabel("First Name:"));
        firstNameField = new JTextField();
        panel.add(firstNameField);

        // Last Name
        panel.add(new JLabel("Last Name:"));
        lastNameField = new JTextField();
        panel.add(lastNameField);

        // Department
        panel.add(new JLabel("Department:"));
        String[] departments = {"none", "sales", "dev", "acct"};
        departmentComboBox = new JComboBox<>(departments);
        panel.add(departmentComboBox);

        // Generate Button
        JButton generateButton = new JButton("Generate Email");
        panel.add(generateButton);

        // Output Area
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        panel.add(new JScrollPane(outputArea));

        add(panel, BorderLayout.CENTER);

        // Button action
        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generateEmail();
            }
        });
    }

    private void generateEmail() {
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String department = (String) departmentComboBox.getSelectedItem();

        if (firstName.isEmpty() || lastName.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter both first and last name.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Email email = new Email(firstName, lastName, department);
        outputArea.setText(email.showInfo());
    }
}
