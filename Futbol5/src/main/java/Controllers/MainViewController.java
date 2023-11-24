/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Views.MainView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author 57312
 */
public class MainViewController implements ActionListener{
    private MainView view;

    public MainViewController() {
        view = new MainView();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public void init() {
        view.setTitle("Futbol 5");
        view.setResizable(false);
        view.setLocationRelativeTo(null);
        view.setVisible(true);
    }
}
