package com.example.spaceinvaders;

public class Alien {

    private byte maximumPosition;
    private byte minimumPosition;
    private int xPosition;
    private int yPosition;

    public Alien(int xPosition, int yPosition, byte minimumPosition, byte maximumPosition){
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.minimumPosition = minimumPosition;
        this.maximumPosition = maximumPosition;
    }

    public Alien(){

    }

    public Integer getxPosition(){
        return xPosition;
    }
    public Integer getyPosition(){
        return yPosition;
    }

    public void setxPosition(Integer xPosition) {
        this.xPosition = xPosition;
    }

    public void setyPosition(Integer yPosition) {
        this.yPosition = yPosition;
    }

    public int getIndexNumber(int index) {
//        if (index < 6) {
//            return 1;
//        }
        return index/3;
    }

    public int alienMovement(boolean isPositive){
        if (isPositive){
            if (xPosition == 6){
//                yPosition++;
                return xPosition;
            }
            xPosition++;
        } else if (!isPositive) {
            if (xPosition == 1){
//                yPosition++;
                return xPosition;
            }
            xPosition--;
        }
        return xPosition;

    }



}
