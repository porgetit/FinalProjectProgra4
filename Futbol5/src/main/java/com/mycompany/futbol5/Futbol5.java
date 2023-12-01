package com.mycompany.futbol5;

import Controllers.MainViewController;
import Models.Match;
import Models.Team;

/**
 *
 * @author Kevin Esguerra Cardona
 */
public class Futbol5 {

    public static void main(String[] args) {
        // Initialize a Match instance (replace with your actual initialization logic)
        Match match = new Match(new Team(), new Team());

        // Instantiate the MainViewController and initialize the main application
        MainViewController mainController = new MainViewController(match);
        mainController.init();
    }
}
