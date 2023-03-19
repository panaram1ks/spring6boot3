package com.in28minutes.learnspringframework.game;

public class PacManGame implements GamingConsole{
    @Override
    public void up() {
        System.out.println("jump");
    }

    @Override
    public void down() {
        System.out.println("sit");
    }

    @Override
    public void left() {
        System.out.println("turn left");
    }

    @Override
    public void right() {
        System.out.println("turn right");
    }
}
