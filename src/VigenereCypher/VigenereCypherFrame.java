package VigenereCypher;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VigenereCypherFrame extends JFrame implements ActionListener {
	private JButton encodeButton, decodeButton;
	private JLabel inputLabel, keywordLabel, outputLabel;
	private JTextField inputField, keywordField, outputField;

	public VigenereCypherFrame(int WIDTH, int HEIGHT) {
		GridBagConstraints layout = null;
		setTitle("Vigenere Cypher Encoder & Decoder");

		inputLabel = new JLabel("Text:");
		keywordLabel = new JLabel("Keyword:");
		outputLabel = new JLabel("Output:");

		inputField = createFieldComponent(10, true, "INPUT");
		keywordField = createFieldComponent(10, true, "KEY");
		outputField = createFieldComponent(10, false, VigenereCypherManipulator.vEncrypt("input", "key"));

		encodeButton = new JButton("Encode");
		encodeButton.addActionListener(this);
		decodeButton = new JButton("Decode");
		decodeButton.addActionListener(this);

		setLayout(new GridBagLayout());

		Insets insets = new Insets(10, 10, 10, 10);

		addComponent(0, 0, insets, inputLabel);
		addComponent(2, 0, insets, inputField);
		addComponent(0, 1, insets, keywordLabel);
		addComponent(2, 1, insets, keywordField);
		addComponent(0, 2, insets, outputLabel);
		addComponent(2, 2, insets, outputField);
		addComponent(0, 3, insets, encodeButton);
		addComponent(2, 3, insets, decodeButton);

		pack();
		setSize(WIDTH, HEIGHT);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton source = (JButton) e.getSource();
		String input = inputField.getText();
		String key = keywordField.getText();
		if (source == encodeButton) {
			outputField.setText(VigenereCypherManipulator.vEncrypt(input, key));
		} else if (source == decodeButton) {
			outputField.setText(VigenereCypherManipulator.vDecrypt(input, key));
		}
	}

	private JTextField createFieldComponent(int columns, boolean editable, String text) {
		JTextField field = new JTextField(columns);
		field.setEditable(editable);
		field.setText(text);
		return field;
	}

	private void addComponent(int x, int y, Insets insets, JComponent component) {
		GridBagConstraints layout = new GridBagConstraints();
		layout.gridx = x;
		layout.gridy = y;
		layout.insets = insets;
		add(component, layout);
	}
}
