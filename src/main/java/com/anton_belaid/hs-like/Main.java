package com.anton_belaid.hs_like;

import com.anton_belaid.hs_like.controller.Game;
import com.anton_belaid.hs_like.model.Champion;
import com.anton_belaid.hs_like.utils.ChampionSelector;
import com.anton_belaid.hs_like.utils.LoggerUtils;
import com.anton_belaid.hs_like.utils.LogFileEraser;

public class Main {
    public static void main(String[] args) {
        LogFileEraser.eraseLogFile("C:\\Users\\Anton\\tes\\POO-Java\\Project_v.2\\hs_like\\game.log");
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("\n JAVSTONE, a HeathStone Like Game, made by Anton ADAM and Belaid IOUDJAOUDENE\n\n");
        LoggerUtils.log("Welcome to the JAVSTONE logger !");
        LoggerUtils.log("");
        System.out.println("Hello and welcome to the JAVSTONE game!\n");
        System.out.println("What would you like to do?\n");
        System.out.println("1. Start a new game");
        System.out.println("2. Exit\n");
        int choice = Integer.parseInt(System.console().readLine());
        if (choice == 2) {
            System.exit(0);
        }
        else {
            //erase the terminal
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("Great! Let's start a new game.\n");
            System.out.println("Player 1, please enter your name: ");
            String player1Name = System.console().readLine();
            System.out.println("Player 2, please enter your name: ");
            String player2Name = System.console().readLine();
    
            // Select two random Champion objects
            Champion champion1 = ChampionSelector.selectRandomChampion();
            champion1.setPlayerName(player1Name);
            champion1.setMaster(champion1);
            Champion champion2 = ChampionSelector.selectRandomChampion();
            champion2.setPlayerName(player2Name);
            champion2.setMaster(champion2);
    
            // Print the champions' names
            System.out.println("\n");
            System.out.println(player1Name + ", you've been attributed the following Champion: " + champion1.getName());
            System.out.println(player2Name + ", you've been attributed the following Champion: " + champion2.getName() + "\n");


            System.out.println("Press ENTER twice to continue...");
            System.console().readLine();
            if (System.console().readLine() != null) {
                System.out.print("\033[H\033[2J");
                System.out.flush();
                // Create a new Game object
                Game game = new Game(champion1, champion2);
                LoggerUtils.log("=============================== GAME STARTING ===============================");
                LoggerUtils.log("[INFO] Game created with " + champion1.getName() + " and " + champion2.getName());
    
                // Start the game
                LoggerUtils.log("[INFO] Game started");
                game.start();
            }
    

        }

    }
}