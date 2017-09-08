package com.example.tictactoe;

import com.example.player.User;
import com.example.player.Computer;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import com.example.player.Player;

public class TicTacToe {
    public static void main(String[] args) {

        boolean gameOver = false;
        User user = new User();
        Computer comp = new Computer();
        int lastPlay = 0;
        int plays = 0;
        Player lastPlayer = null;

        ArrayList<Integer> corners = new ArrayList<>(4);
        corners.add(0);
        corners.add(2);
        corners.add(6);
        corners.add(8);

        List<String> board = new ArrayList<>(Arrays.asList("", "", "", "", "", "", "", "", ""));

        while (!gameOver && plays < 9) {
            lastPlay = user.play(board);
            gameOver = isGameOver(board, "X", lastPlay, corners);
            plays++;
            lastPlayer = user;
            if (!gameOver && plays < 9) {
                lastPlay = comp.play(board);
                gameOver = isGameOver(board, "O", lastPlay, corners);
                plays++;
                lastPlayer = comp;
            }
        }
        System.out.println(plays < 9 ? "Game over! " + lastPlayer.getName() + " won!" : "Game over! It's a tie!");
    }

    private static boolean isGameOver(List<String> board, String sign, int lastPlay, ArrayList<Integer> corners) {
        //is the lastPlay in the corners
        if (corners.contains(lastPlay) && (board.get(4) == sign)) {
            if (lastPlay == 0 && board.get(8) == sign) {
                return true;
            }
            if (lastPlay == 8 && board.get(0) == sign) {
                return true;
            }
            if (lastPlay == 2 && board.get(6) == sign) {
                return true;
            }
            if (lastPlay == 6 && board.get(2) == sign) {
                return true;
            }
        }

        //is the lastPlay in top row
        if (0 <= lastPlay && lastPlay <= 2) {
            if (board.get(lastPlay + 3) == sign && board.get(lastPlay + 6) == sign) {
                return true;
            }
        }

        //is the lastPlay in middle (horizontally) row
        if (3 <= lastPlay && lastPlay <= 5) {
            if (board.get(lastPlay + 3) == sign && board.get(lastPlay - 3) == sign) {
                return true;
            }
        }

        //is the lastPlay in bottom row
        if (6 <= lastPlay && lastPlay <= 8) {
            if (board.get(lastPlay - 3) == sign && board.get(lastPlay - 6) == sign) {
                return true;
            }
        }

        //is the lastPlay in right row
        if (lastPlay % 3 == 2) {
            if (board.get(lastPlay - 1) == sign && board.get(lastPlay - 2) == sign) {
                return true;
            }
        }

        //is the lastPlay in middle (vertically) row
        if (lastPlay % 3 == 1) {
            if (board.get(lastPlay - 1) == sign && board.get(lastPlay + 1) == sign) {
                return true;
            }
        }

        //is the lastPlay in left row
        if (lastPlay % 3 == 0) {
            if (board.get(lastPlay + 1) == sign && board.get(lastPlay + 2) == sign) {
                return true;
            }
        }

        return false;
    }
}
