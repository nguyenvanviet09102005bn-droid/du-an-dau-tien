package projectmnm;

import javax.swing.*;
import java.io.File;

public class CryptoController {

    private CryptoView view;

    public CryptoController(CryptoView view) {
        this.view = view;
        initController();
    }

    private void initController() {
        view.getBrowseButton().addActionListener(e -> browseFile());
        view.getEncryptButton().addActionListener(e -> processFile(true));
        view.getDecryptButton().addActionListener(e -> processFile(false));
    }

    private void browseFile() {
        JFileChooser fileChooser = new JFileChooser();
        int userSelection = fileChooser.showOpenDialog(view);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            view.setFilePath(selectedFile.getAbsolutePath());
        }
    }

    private void processFile(boolean isEncrypt) {
        String filePath = view.getFilePath();
        String key = view.getKey();

        if (filePath.isEmpty() || key.isEmpty()) {
            JOptionPane.showMessageDialog(view, "Vui lòng chọn file và nhập khóa.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        File inputFile = new File(filePath);
        if (!inputFile.exists()) {
            JOptionPane.showMessageDialog(view, "File không tồn tại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        String newFileName = isEncrypt ? inputFile.getName() + ".encrypted" : inputFile.getName().replace(".encrypted", ".decrypted");
        File outputFile = new File(inputFile.getParent(), newFileName);

        try {
            if (isEncrypt) {
                CryptorModel.encrypt(key, inputFile, outputFile);
                view.appendStatus("Mã hóa thành công!\nFile đã mã hóa: " + outputFile.getAbsolutePath());
            } else {
                CryptorModel.decrypt(key, inputFile, outputFile);
                view.appendStatus("Giải mã thành công!\nFile đã giải mã: " + outputFile.getAbsolutePath());
            }
        } catch (Exception ex) {
            view.appendStatus("Lỗi: " + ex.getMessage());
            JOptionPane.showMessageDialog(view, "Đã xảy ra lỗi: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
         
        }
        SwingUtilities.invokeLater(() -> {
            CryptoView view = new CryptoView();
            new CryptoController(view);
            view.setVisible(true);
        });
    }
}
