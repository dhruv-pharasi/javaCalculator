import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class calculator implements ActionListener {

    // Declaring all the GUI elements
    private static JFrame frame;
    private static JPanel panel;
    private static JButton button;
    private static JTextField num1;
    private static JTextField num2;
    private static JLabel label1;
    private static JComboBox<String> box;
    private static JLabel result;

    public static void main(String[] args) {

        // Setting up frame and panel
        frame = new JFrame("Calculator");
        panel = new JPanel();
        frame.setSize(500, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        panel.setLayout(null);

        // Enter operands display text
        label1 = new JLabel("Enter operands");
        label1.setBounds(20, 20, 200, 25);
        panel.add(label1);

        // Calculate button
        button = new JButton("Calculate");
        button.setBounds(60, 100, 150, 30);
        button.addActionListener(new calculator()); // action listener
        panel.add(button);

        // Text fields for numbers
        num1 = new JTextField(10);
        num2 = new JTextField(10);
        num1.setBounds(80, 50, 100, 30);
        num2.setBounds(250, 50, 100, 30);
        panel.add(num1);
        panel.add(num2);

        // Drop-down menu for operations
        String[] operations = { "+", "-", "*", "/" };
        box = new JComboBox<String>(operations);
        box.setBounds(185, 50, 65, 30);
        panel.add(box);

        // Result label
        result = new JLabel("");
        result.setBounds(80, 160, 300, 40);
        panel.add(result);

        // Displaying frame
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);

    }

    // Logic of the calculator
    @Override
    public void actionPerformed(ActionEvent e) {
        if ((num1.getText().equals("")) || (num2.getText().equals(""))) {
            result.setText("Both operands required!");

        } else if (!(num1.getText().matches("[0-9.0-9]+")) || !(num2.getText().matches("[0-9.0-9]+"))) { // find regex
                                                                                                         // that
            // accepts decimals
            // along with numbers
            result.setText("Only numbers are acceptable!");

        } else {
            float number1 = Float.parseFloat(num1.getText().trim());
            float number2 = Float.parseFloat(num2.getText().trim());

            if (box.getSelectedItem().equals("+")) {
                float sum = Float.sum(number1, number2);
                result.setText(number1 + " + " + number2 + " = " + String.valueOf(sum));
            }

            else if (box.getSelectedItem().equals("-")) {
                float subtraction = number1 - number2;
                result.setText(number1 + " - " + number2 + " = " + String.valueOf(subtraction));
            }

            else if (box.getSelectedItem().equals("*")) {
                float multiplication = number1 * number2;
                result.setText(number1 + " * " + number2 + " = " + String.valueOf(multiplication));
            }

            else {
                if (number2 == 0) {
                    result.setText("Divisor cannot be 0");
                } else {
                    float division = number1 / number2;
                    result.setText(number1 + " / " + number2 + " = " + String.valueOf(division));
                }
            }
        }
    }
}
