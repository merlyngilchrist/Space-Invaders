package com.example.spaceinvaders;

public class Ship {
    private byte position;
    private byte maximumPosition;
    private byte minimumPosition;

    public Ship(byte shipPosition, byte minimumPosition, byte maximumPosition){
        this.position = shipPosition;
        this.minimumPosition = minimumPosition;
        this.maximumPosition = maximumPosition;
    }

    public byte getPosition(){
        return position;
    }

    public byte shipMovement(boolean isPositive){
        if (isPositive){
            if (position == 6){
                return position;
            }
            position++;

        } else if (!isPositive) {
            if (position == 1){
                return position;
            }
            position--;
        }
        return position;
    }

}
