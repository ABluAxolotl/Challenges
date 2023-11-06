package SalaryCalculator;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Random;

public class SalaryCalculatorFrame extends JFrame implements ActionListener {
  private JLabel wageLabel, hoursLabel, salaryLabel;
  private JTextField wageInput, hoursInput, salaryField;
  private JButton calculateButton;

  public static void main(String[] args) {
    int WIDTH = 320;
    int HEIGHT = 240;
    new SalaryCalculatorFrame(WIDTH, HEIGHT);
  }

  public SalaryCalculatorFrame(int WIDTH, int HEIGHT) {
    setTitle("Yearly Salary Calculator");
    setLocationRelativeTo(null);
    getContentPane().setBackground(new Color(0, 136, 170));

    //Labels
    wageLabel = new JLabel("Hourly Wage: ");
    hoursLabel = new JLabel("Hours Per Week: ");
    salaryLabel = new JLabel("Yearly Salary: ");

    wageInput = new JTextField(15);
    wageInput.setEditable(true);
    wageInput.setText("0");

    hoursInput = new JTextField(15);
    hoursInput.setEditable(true);
    hoursInput.setText("40");

    salaryField = new JTextField(15);
    salaryField.setEditable(false);

    calculateButton = new JButton("Calculate");
    calculateButton.addActionListener(this);

    Insets insets = new Insets(10, 10, 10, 10);

    setLayout(new GridBagLayout());
    addToGrid(0, 0, insets, wageLabel);
    addToGrid(1, 0, insets, wageInput);
    addToGrid(0, 1, insets, hoursLabel);
    addToGrid(1, 1, insets, hoursInput);
    addToGrid(0, 2, insets, salaryLabel);
    addToGrid(1, 2, insets, salaryField);
    addToGrid(0, 3, insets, calculateButton);

    pack();
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setVisible(true);
  }

  public void addToGrid(int x, int y, Insets insets, JComponent component) {
    GridBagConstraints layout = new GridBagConstraints();
    layout.gridx = x;
    layout.gridy = y;
    layout.insets = insets;
    add(component, layout);
  }

  public void actionPerformed(ActionEvent e) {
    String wage = this.wageInput.getText();
    String hours = this.hoursInput.getText();
    int hourly = Integer.parseInt(wage);
    int perWeek = Integer.parseInt(hours);
    this.salaryField.setText(Integer.toString(hourly * perWeek * 50));
  }

}
