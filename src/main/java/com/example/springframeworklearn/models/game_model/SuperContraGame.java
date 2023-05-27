package com.example.springframeworklearn.models.game_model;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class SuperContraGame implements GamingConsole {
    public SuperContraGame() {
    }

    @Override
    public void up() {
        System.out.println("Up Jump");
    }

    @Override
    public void down() {
        System.out.println("Down Into the hole");
    }

    @Override
    public void left() {
        System.out.println("Left");
    }

    @Override
    public void right() {
        System.out.println("Right Direction");
    }
}
