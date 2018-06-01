package view;

import javax.swing.JFrame;
import java.io.IOException;

public class Frame {
    public static void main(final String[] arg) throws IOException {
        final JFrame cadre = new javax.swing.JFrame("Lorann");
        cadre.setContentPane(new LorannView());
        cadre.setLocation(400, 300);
        cadre.setSize(526, 294);
        cadre.pack();
        cadre.setVisible(true);
        cadre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

