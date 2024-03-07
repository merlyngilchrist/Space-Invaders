package com.example.spaceinvaders;

public class Projectile {

    private int position;

    Projectile(int position){
        this.position = position;
    }
    public int getPosition(){
        return position;
    }
    public int moveProjectile(int position){
        if (position == 8){
            return position;
        }
        position++;
        return position;
    }

}
