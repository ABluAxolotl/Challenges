package DistanceConverter;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

public class DistanceConverterSpinner extends JFrame implements ChangeListener {
	private JLabel distanceLabel, kmLabel;
	private JFormattedTextField kmField;
	private JSpinner distanceInput;

	public static void main(String[] args) {
		int WIDTH = 320;
		int HEIGHT = 240;
		new DistanceConverterSpinner(WIDTH, HEIGHT);
	}

	public DistanceConverterSpinner(int WIDTH, int HEIGHT) {
		setTitle("Yearly Salary Calculator");
		setLocationRelativeTo(null);
		getContentPane().setBackground(new Color(0, 136, 170));

		//Labels
		distanceLabel = new JLabel("Distance (mi)");
		kmLabel = new JLabel("Distance (km)");

		SpinnerNumberModel model = new SpinnerNumberModel(0, 0, (int) Double.POSITIVE_INFINITY, 1);
		distanceInput = new JSpinner(model);
		distanceInput.addChangeListener(this);

		kmField = new JFormattedTextField(NumberFormat.getNumberInstance());
		kmField.setEditable(false);
		kmField.setText("0");
		kmField.setColumns(15);

		Insets insets = new Insets(10, 10, 10, 10);

		setLayout(new GridBagLayout());
		addToGrid(1, 0, insets, distanceLabel);
		addToGrid(2, 0, insets, distanceInput);
		addToGrid(1, 1, insets, kmLabel);
		addToGrid(2, 1, insets, kmField);

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

	@Override
	public void stateChanged(ChangeEvent e) {
		int miles = (int) distanceInput.getValue();
		kmField.setText(Double.toString(miles * 1.609));
	}
}