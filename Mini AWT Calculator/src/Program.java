import javax.swing.*;

public class Program {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("Mini AWT Calculator");
        frame.setSize(350, 250);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);


        JLabel label_x = new JLabel("Enter first number:");
        JLabel label_operation = new JLabel("Choose operation:");
        JLabel label_y = new JLabel("Enter second number:");
        JLabel label_result = new JLabel("Result is:");


        JTextField text_x = new JTextField();
        JTextField text_y = new JTextField();
        JTextField text_result = new JTextField();


        String[] operation = new String[] {
                "+",
                "-",
                "*",
                "/"
        };


        JComboBox<String> operation_combo = new JComboBox<>(operation);
        operation_combo.setBounds(200,51,100,20);
        operation_combo.setSelectedIndex(0);


        JButton button_calculate = new JButton("Calculate");


        label_x.setBounds(10,20,200,25);
        text_x.setBounds(200,20,100,25);
        label_operation.setBounds(10,51,200,20);
        label_y.setBounds(10,80,200,25);
        text_y.setBounds(200,80,100,25);
        button_calculate.setBounds(200,110,100,25);
        label_result.setBounds(10, 137, 200, 25);
        text_result.setBounds(200, 137, 100, 25);


        button_calculate.addActionListener(
                new CalculatorAction(operation_combo, text_x, text_y, text_result)
        );

        
        frame.add(label_x);
        frame.add(label_operation);
        frame.add(label_y);
        frame.add(label_result);
        frame.add(text_x);
        frame.add(text_y);
        frame.add(text_result);
        frame.add(button_calculate);
        frame.add(operation_combo);


        frame.setVisible(true);
    }
}