package com.example.player;

import java.util.List;
import java.util.Random;

public class Computer extends Player {

    public Computer() {
        this.name = "The Computer";
    }

    public int play(List<String> board) {

        Random rand = new Random();

        int  n = rand.nextInt(8) + 0;

        if (board.get(n).isEmpty()) {
            board.set(n, "O");
            System.out.println("Computer's play:");
            System.out.println(board);
            System.out.println("----------------------------");
        } else {
            n = play(board);
        }
        return n;
    }
}
