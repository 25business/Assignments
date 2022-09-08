import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorAction implements ActionListener {

    private String operacija;
    private JTextField text_x;
    private JTextField text_y;
    private JTextField text_result;
    private JComboBox text_operation;


    public CalculatorAction(JComboBox text_operation ,JTextField text_x, JTextField text_y, JTextField text_result) {
        this.text_operation = text_operation;
        this.text_x = text_x;
        this.text_y = text_y;
        this.text_result = text_result;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            double x = Double.parseDouble(text_x.getText());
            double y = Double.parseDouble(text_y.getText());

            String operacija = (String) text_operation.getSelectedItem();

            if(y == 0 && operacija.equals("/") && x == 0 && operacija.equals("/"))
                throw new ArithmeticException();


            double result = switch (operacija) {
                case "+" -> x + y;
                case "-" -> x - y;
                case "*" -> x * y;
                case "/" -> x / y;
                default -> 0;
            };
            text_result.setText(String.valueOf(result));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "You entered a non-number value.", "Error message", JOptionPane.ERROR_MESSAGE);
        } catch(ArithmeticException ex) {
            JOptionPane.showMessageDialog(null, "You can't divide by zero.", "Error message", JOptionPane.ERROR_MESSAGE);
        }
    }
}
