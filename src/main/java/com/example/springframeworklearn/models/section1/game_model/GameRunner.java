package com.example.springframeworklearn.models.section1.game_model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GameRunner {

    @Autowired
    private GamingConsole gamingConsole;
    public GameRunner(GamingConsole gamingConsole) {
        this.gamingConsole = gamingConsole;
    }

    public void run() {
        gamingConsole.up();
        gamingConsole.down();
        gamingConsole.right();
        gamingConsole.left();
    }
}
