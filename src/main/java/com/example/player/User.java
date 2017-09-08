package com.example.player;

import java.util.List;
import java.util.Scanner;

public class User extends Player {

    public User() {
        this.name = "You";
    }

    public int play(List<String> board) {

        Scanner sc = new Scanner(System.in);
        int number;

        do {
            System.out.println("Please enter a number between 1-9 to place on tic tac toe board!");
            while (!sc.hasNextInt()) {
                System.out.println("That's not a number!");
                sc.next();
            }
            number = sc.nextInt();
        } while (number < 1 || number > 9);

        number--;

        if (board.get(number).isEmpty()) {
            board.set(number, "X");
            System.out.println("Your play:");
            System.out.println(board);
            System.out.println("----------------------------");
        } else {
            number = play(board);
        }

        return number;
    }
}
