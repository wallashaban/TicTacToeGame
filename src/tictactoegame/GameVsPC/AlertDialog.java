package tictactoegame.GameVsPC;

import javax.swing.JOptionPane;

/**
 *
 * @author anasn
 */
public class AlertDialog {


    public static void main(String[] args) {
        showMessageDialog("This is an information message", "Information");

        showWarningDialog("This is a warning message", "Warning");

        showErrorMessage("PleasEnter Your Name Correctly", "Error");

        showOptionDialog("Do you want to continue?", "Confirmation");
    }

    private static void showMessageDialog(String message, String title) {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
    }

    private static void showWarningDialog(String message, String title) {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.WARNING_MESSAGE);
    }

    public static void showErrorMessage(String message, String title) {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.ERROR_MESSAGE);
    }

    private static void showOptionDialog(String message, String title) {
        int result = JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION);
        /* debug the logic <<<>>>
        if (result == JOptionPane.YES_OPTION) {
            System.out.println("User clicked Yes");
        } else {
            System.out.println("User clicked No");
        }
        */
    }
}


