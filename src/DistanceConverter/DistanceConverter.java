package DistanceConverter;

import SalaryCalculator.SalaryCalculatorFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

public class DistanceConverter extends JFrame implements ActionListener {
	private JLabel distanceLabel, kmLabel, mLabel, fLabel;
	private JFormattedTextField distanceInput, kmField, mField, fField;
	private JButton calculateButton;

	public static void main(String[] args) {
		int WIDTH = 320;
		int HEIGHT = 240;
		new DistanceConverter(WIDTH, HEIGHT);
	}

	public DistanceConverter(int WIDTH, int HEIGHT) {
		setTitle("Yearly Salary Calculator");
		setLocationRelativeTo(null);
		getContentPane().setBackground(new Color(0, 136, 170));

		//Labels
		distanceLabel = new JLabel("Distance (mi)");
		kmLabel = new JLabel("Distance (km)");
		mLabel = new JLabel("Distance (m)");
		fLabel = new JLabel("Distance (ft)");

		distanceInput = new JFormattedTextField(NumberFormat.getNumberInstance());
		distanceInput.setEditable(true);
		distanceInput.setText("0");
		distanceInput.setColumns(15);

		kmField = new JFormattedTextField(NumberFormat.getNumberInstance());
		kmField.setEditable(false);
		kmField.setText("0");
		kmField.setColumns(10);

		mField = new JFormattedTextField(NumberFormat.getNumberInstance());
		mField.setEditable(false);
		mField.setText("0");
		mField.setColumns(10);

		fField = new JFormattedTextField(NumberFormat.getNumberInstance());
		fField.setEditable(false);
		fField.setText("0");
		fField.setColumns(10);

		calculateButton = new JButton("Calculate");
		calculateButton.addActionListener(this);

		Insets insets = new Insets(10, 10, 10, 10);

		setLayout(new GridBagLayout());
		addToGrid(1, 0, insets, distanceLabel);
		addToGrid(2, 0, insets, distanceInput);
		addToGrid(0, 2, insets, calculateButton);
		addToGrid(1, 1, insets, kmLabel);
		addToGrid(2, 1, insets, mLabel);
		addToGrid(3, 1, insets, fLabel);
		addToGrid(1, 2, insets, kmField);
		addToGrid(2, 2, insets, mField);
		addToGrid(3, 2, insets, fField);

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
		double distMI, distKM, distM, distF;

		distMI = ((Number)distanceInput.getValue()).doubleValue();

		if (distMI <= 0) {
			JOptionPane.showMessageDialog(this, "Error: Distance cannot be negative!");
		} else {
			distKM = distMI * 1.609;
			distM = distMI * 1609;
			distF = distMI * 5280;


			kmField.setText(Double.toString(distKM));
			mField.setText(Double.toString(distM));
			fField.setText(Double.toString(distF));
		}
	}

}