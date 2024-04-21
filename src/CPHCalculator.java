import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class CPHCalculator extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JPanel loginPanel;
    private JPanel calculatorPanel;
    private JTextField[] hourCasesFields;
    private JLabel resultLabel;

    private Map<String, String> userCredentials;

    public CPHCalculator() {
        setTitle("CPH Calculator");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Inicializar la base de datos de credenciales de usuario
        userCredentials = new HashMap<>();
        userCredentials.put("Admin", "1234");

        // Panel de inicio de sesión
        loginPanel = new JPanel(new GridLayout(3, 2));
        loginPanel.setBackground(Color.LIGHT_GRAY);

        JLabel usernameLabel = new JLabel("Username:");
        loginPanel.add(usernameLabel);
        usernameField = new JTextField();
        loginPanel.add(usernameField);

        JLabel passwordLabel = new JLabel("Password:");
        loginPanel.add(passwordLabel);
        passwordField = new JPasswordField();
        loginPanel.add(passwordField);

        loginButton = new JButton("Login");
        loginButton.addActionListener(e -> authenticate());
        loginPanel.add(loginButton);

        // Panel de la calculadora
        calculatorPanel = new JPanel(new GridLayout(0, 2));
        calculatorPanel.setBackground(Color.LIGHT_GRAY);

        hourCasesFields = new JTextField[8];
        for (int i = 0; i < 8; i++) {
            JLabel label = new JLabel("Hour " + (i + 1) + " Cases:");
            calculatorPanel.add(label);
            hourCasesFields[i] = new JTextField();
            calculatorPanel.add(hourCasesFields[i]);
        }

        JButton calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(e -> calculateCPH());
        calculatorPanel.add(calculateButton);

        resultLabel = new JLabel();
        calculatorPanel.add(resultLabel);

        // Mostrar el panel de inicio de sesión por defecto
        setContentPane(loginPanel);

        setVisible(true);
    }

    private void authenticate() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        if (userCredentials.containsKey(username) && userCredentials.get(username).equals(password)) {
            // Credenciales correctas, mostrar el panel de la calculadora
            setContentPane(calculatorPanel);
            revalidate();
            repaint();
        } else {
            // Credenciales incorrectas, mostrar un mensaje de error
            JOptionPane.showMessageDialog(this, "Invalid username or password", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void calculateCPH() {
        double totalCases = 0;
        double totalHours = 0;
        for (int i = 0; i < hourCasesFields.length; i++) {
            JTextField field = hourCasesFields[i];
            String text = field.getText();
            if (isValidNumber(text)) {
                totalCases += Double.parseDouble(text);
                totalHours++;
            }
        }
        if (totalHours > 0) {
            double cph = totalCases / totalHours;
            Color color = getColorForCPH(cph);
            resultLabel.setText("CPH: " + cph);
            resultLabel.setForeground(color);
        } else {
            JOptionPane.showMessageDialog(this, "No valid data entered", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private Color getColorForCPH(double cph) {
        if (cph < 3.0) {
            return Color.RED;
        } else if (cph < 3.5) {
            return Color.YELLOW;
        } else {
            return Color.GREEN;
        }
    }

    private boolean isValidNumber(String text) {
        return text.matches("^\\d*\\.?\\d+$");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(CPHCalculator::new);
    }
}
