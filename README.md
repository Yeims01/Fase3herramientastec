# Productividad basada en herramientas tec Fase 3

--ARQUITECTURA DE LA APLICACION--

1. **Modelo**: La lógica de negocio y los datos de la aplicación se encuentran en el modelo. 
En este caso, la lógica de cálculo del CPH se encuentra en la clase `SecureCPHCalculator`. 
Esta clase maneja la operacion para calcular el CPH basado en la entrada del usuario y determina el color del resultado en función del valor del CPH.

2. **Vista**: La interfaz de usuario que el usuario ve y con la que interactúa se encuentra en la vista. 
En este caso, la vista está representada por las ventanas y componentes de Swing, como `JFrame`, `JPanel`, `JButton`, `JLabel` y `JTextField`. 
La interfaz de usuario muestra los campos para ingresar los casos por hora y el botón de cálculo del CPH.

3. **Controlador**: El controlador actúa como intermediario entre el modelo y la vista. 
En este caso, la lógica para manejar las interacciones del usuario y actualizar la vista se encuentra en los eventos de acción de los componentes de Swing. 
Por ejemplo, el controlador maneja el evento de clic del botón de cálculo del CPH y llama al método correspondiente en el modelo para realizar el cálculo.

4. **Autenticación**: En la rama "authentication", se agrega una capa adicional para manejar la autenticación de usuarios. 
Esta capa incluye la lógica para verificar las credenciales ingresadas por el usuario y permitir el acceso a la aplicación solo a usuarios autorizados. 
La interfaz de inicio de sesión (`JTextField`, `JPasswordField` y `JButton`) y la lógica para autenticar al usuario se implementan en esta parte de la aplicación.



--CODIGO DE LA APLICACION--



 import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class SecureCPHCalculator extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JPanel loginPanel;
    private JPanel calculatorPanel;
    private JTextField[] hourCasesFields;
    private JLabel resultLabel;

    private Map<String, String> userCredentials;

    public SecureCPHCalculator() {
        setTitle("Secure CPH Calculator");
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
        calculatorPanel.setBackground(Color.BLUE);

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
        for (JTextField field : hourCasesFields) {
            String text = field.getText();
            if (isValidNumber(text)) {
                totalCases += Double.parseDouble(text);
            }
        }
        double cph = totalCases / 8;

        Color color = getColorForCPH(cph);

        resultLabel.setText("CPH: " + cph);
        resultLabel.setForeground(color);
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
        SwingUtilities.invokeLater(SecureCPHCalculator::new);
    }
}

