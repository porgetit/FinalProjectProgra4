/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Views.PopupView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Kevin Esguerra Cardona
 */
public class PopupViewController implements ActionListener {
    private PopupView view;

    public PopupViewController() {
        view = new PopupView();
        view.ButtonAccept.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.ButtonAccept) {
            view.dispose(); // Close the popup
        }
    }

    public void init(String message) {
        view.setTitle("Futbol 5");
        view.setResizable(false);
        view.setLocationRelativeTo(null);
        view.TextArea.setText(message); // Set the message in the TextArea
        view.setVisible(true);
    }
}
