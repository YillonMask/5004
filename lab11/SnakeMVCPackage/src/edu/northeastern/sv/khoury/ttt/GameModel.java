package edu.northeastern.sv.khoury.ttt;

import java.util.List;

public interface GameModel {
    void updateDirection(int direction);
    void updateGame();
    Coordinate getAppleLocation();
    List<Coordinate> getSnakeLocation();
}
