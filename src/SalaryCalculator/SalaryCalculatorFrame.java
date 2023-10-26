package SalaryCalculator;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Random;

public class SalaryCalculatorFrame extends JFrame implements ActionListener {
  private JLabel wageLabel, hoursLabel, salaryLabel, funLabel;
  private JTextField wageInput, hoursInput, salaryField;
  private JButton calculateButton;

  String[] strings = new String[]{"Woo!", "This is fun", "Howdy!", "MC Splash text"};

  public static void main(String[] args) {
    int WIDTH = 320;
    int HEIGHT = 240;
    new SalaryCalculatorFrame(WIDTH, HEIGHT);
  }

  public SalaryCalculatorFrame(int WIDTH, int HEIGHT) {
    setTitle("Yearly Salary Calculator");
    setLocationRelativeTo((Component)null);
    getContentPane().setBackground(new Color(0, 136, 170));
    GridBagConstraints layout = null;

    //Labels
    wageLabel = new JLabel("Hourly Wage: ");
    hoursLabel = new JLabel("Hours Per Week: ");
    salaryLabel = new JLabel("Yearly Salary: ");
    funLabel = new JLabel(this.getRandomString());


    this.wageInput = new JTextField(15);
    this.wageInput.setEditable(true);
    this.wageInput.setText("0");
    this.hoursInput = new JTextField(15);
    this.hoursInput.setEditable(true);
    this.hoursInput.setText("40");
    this.salaryField = new JTextField(15);
    this.salaryField.setEditable(false);
    this.calculateButton = new JButton("Calculate");
    this.calculateButton.addActionListener(this);
    this.setLayout(new GridBagLayout());
    layout = new GridBagConstraints();
    layout.gridx = 0;
    layout.gridy = 0;
    layout.insets = new Insets(10, 10, 10, 10);
    this.add(this.wageLabel, layout);
    layout = new GridBagConstraints();
    layout.gridx = 1;
    layout.gridy = 0;
    layout.insets = new Insets(10, 10, 10, 10);
    this.add(this.wageInput, layout);
    layout = new GridBagConstraints();
    layout.gridx = 0;
    layout.gridy = 1;
    layout.insets = new Insets(10, 10, 10, 10);
    this.add(this.hoursLabel, layout);
    layout = new GridBagConstraints();
    layout.gridx = 1;
    layout.gridy = 1;
    layout.insets = new Insets(10, 10, 10, 10);
    this.add(this.hoursInput, layout);
    layout = new GridBagConstraints();
    layout.gridx = 0;
    layout.gridy = 2;
    layout.insets = new Insets(10, 10, 10, 10);
    this.add(this.salaryLabel, layout);
    layout = new GridBagConstraints();
    layout.gridx = 1;
    layout.gridy = 2;
    layout.insets = new Insets(10, 10, 10, 10);
    this.add(this.salaryField, layout);
    layout = new GridBagConstraints();
    layout.gridx = 0;
    layout.gridy = 3;
    layout.insets = new Insets(10, 10, 10, 10);
    this.add(this.calculateButton, layout);
    layout = new GridBagConstraints();
    layout.gridx = 1;
    layout.gridy = 3;
    layout.insets = new Insets(10, 10, 10, 10);
    this.add(this.fun, layout);
    this.pack();
    this.setSize(WIDTH, HEIGHT);
    this.setDefaultCloseOperation(3);
    this.setVisible(true);
  }

  public void actionPerformed(ActionEvent e) {
    String wage = this.wageInput.getText();
    String hours = this.hoursInput.getText();
    int hourly = Integer.parseInt(wage);
    int perWeek = Integer.parseInt(hours);
    this.fun.setText(this.getRandomString());
    this.salaryField.setText(Integer.toString(hourly * perWeek * 50));
  }

  public String getRandomString() {
    Random rng = new Random();
    return this.strings[Math.abs(rng.nextInt()) % this.strings.length];
  }
}
