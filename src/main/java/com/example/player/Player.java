package com.example.player;

import java.util.List;

public abstract class Player {
    String name;

    public abstract int play(List<String> board);

    public String getName() {
        return name;
    }
}
