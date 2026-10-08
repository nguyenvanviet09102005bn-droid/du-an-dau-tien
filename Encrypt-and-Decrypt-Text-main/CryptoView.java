package projectmnm;

import javax.swing.*;
import java.awt.*;

public class CryptoView extends JFrame {

    private JTextField filePathField;
    private JTextField keyField;
    private JTextArea statusArea;
    private JButton browseButton, encryptButton, decryptButton;

    public CryptoView() {
        setTitle("Công cụ Mã hóa & Giải mã File");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel controlPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        controlPanel.add(new JLabel("Đường dẫn File:"), gbc);
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        filePathField = new JTextField(25);
        controlPanel.add(filePathField, gbc);
        gbc.gridx = 2;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0;
        browseButton = new JButton("Mở");
        controlPanel.add(browseButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        controlPanel.add(new JLabel("Khóa (16 ký tự):"), gbc);
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        keyField = new JTextField(25);
        controlPanel.add(keyField, gbc);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 5));
        encryptButton = new JButton("Mã Hóa");
        decryptButton = new JButton("Giải Mã");
        buttonPanel.add(encryptButton);
        buttonPanel.add(decryptButton);

        statusArea = new JTextArea(5, 20);
        statusArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(statusArea);

        add(controlPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(scrollPane, BorderLayout.SOUTH);
    }

    public JButton getBrowseButton() { return browseButton; }
    public JButton getEncryptButton() { return encryptButton; }
    public JButton getDecryptButton() { return decryptButton; }
    public String getFilePath() { return filePathField.getText(); }
    public void setFilePath(String path) { filePathField.setText(path); }
    public String getKey() { return keyField.getText(); }
    public void appendStatus(String message) { statusArea.append(message + "\n\n"); }
}