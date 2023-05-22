package com.ProjectLpu;
import javax.swing.*;
import java.util.Random;

public class TextFieldUpdater {
    public static void updateTextField(JTextField textField, String newText) {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890abcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        int length = 3;
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(alphabet.length());
            char randomChar = alphabet.charAt(index);
            sb.append(randomChar);
        }
        String randomString = sb.toString();
        textField.setText("PLY" + randomString);
    }
}
