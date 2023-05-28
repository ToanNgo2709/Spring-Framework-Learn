package com.example.springframeworklearn.models.section1.game_model;

import org.springframework.stereotype.Component;

@Component
public class MarioGame implements GamingConsole {

    public MarioGame() {
    }

    @Override
    public void up() {
        System.out.println("Up");
    }


    @Override
    public void down() {
        System.out.println("Down Into the hole");
    }

    @Override
    public void right() {
        System.out.println("Right");
    }

    @Override
    public void left() {
        System.out.println("Left");
    }
}
