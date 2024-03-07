package com.example.spaceinvaders;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


public class MainActivity extends AppCompatActivity {

    public ImageView shipOneDisplay, shipTwoDisplay, shipThreeDisplay, shipFourDisplay, shipFiveDisplay, shipSixDisplay, alien1ADisplay, alien1BDisplay, alien1CDisplay, alien1DDisplay, alien1EDisplay, alien1FDisplay, alien1GDisplay, alien1HDisplay, alien2ADisplay, alien2BDisplay, alien2CDisplay, alien2DDisplay, alien2EDisplay, alien2FDisplay, alien2GDisplay, alien2HDisplay, alien3ADisplay, alien3BDisplay, alien3CDisplay, alien3DDisplay, alien3EDisplay, alien3FDisplay, alien3GDisplay, alien3HDisplay, alien4ADisplay, alien4BDisplay, alien4CDisplay, alien4DDisplay, alien4EDisplay, alien4FDisplay, alien4GDisplay, alien4HDisplay, alien5ADisplay, alien5BDisplay, alien5CDisplay, alien5DDisplay, alien5EDisplay, alien5FDisplay, alien5GDisplay, alien5HDisplay, alien6ADisplay, alien6BDisplay, alien6CDisplay, alien6DDisplay, alien6EDisplay, alien6FDisplay, alien6GDisplay, alien6HDisplay, projectile1ADisplay, projectile1BDisplay, projectile1CDisplay, projectile1DDisplay, projectile1EDisplay, projectile1FDisplay, projectile1GDisplay, projectile1HDisplay, projectile2ADisplay, projectile2BDisplay, projectile2CDisplay, projectile2DDisplay, projectile2EDisplay, projectile2FDisplay, projectile2GDisplay, projectile2HDisplay, projectile3ADisplay, projectile3BDisplay, projectile3CDisplay, projectile3DDisplay, projectile3EDisplay, projectile3FDisplay, projectile3GDisplay, projectile3HDisplay, projectile4ADisplay, projectile4BDisplay, projectile4CDisplay, projectile4DDisplay, projectile4EDisplay, projectile4FDisplay, projectile4GDisplay, projectile4HDisplay, projectile5ADisplay, projectile5BDisplay, projectile5CDisplay, projectile5DDisplay, projectile5EDisplay, projectile5FDisplay, projectile5GDisplay, projectile5HDisplay, projectile6ADisplay, projectile6BDisplay, projectile6CDisplay, projectile6DDisplay, projectile6EDisplay, projectile6FDisplay, projectile6GDisplay, projectile6HDisplay, life1Display, life2Display, life3Display, alienProjectile1ADisplay, alienProjectile1BDisplay, alienProjectile1CDisplay, alienProjectile1DDisplay, alienProjectile1EDisplay, alienProjectile1FDisplay, alienProjectile1GDisplay, alienProjectile1HDisplay, alienProjectile2ADisplay, alienProjectile2BDisplay, alienProjectile2CDisplay, alienProjectile2DDisplay, alienProjectile2EDisplay, alienProjectile2FDisplay, alienProjectile2GDisplay, alienProjectile2HDisplay, alienProjectile3ADisplay, alienProjectile3BDisplay, alienProjectile3CDisplay, alienProjectile3DDisplay, alienProjectile3EDisplay, alienProjectile3FDisplay, alienProjectile3GDisplay, alienProjectile3HDisplay, alienProjectile4ADisplay, alienProjectile4BDisplay, alienProjectile4CDisplay, alienProjectile4DDisplay, alienProjectile4EDisplay, alienProjectile4FDisplay, alienProjectile4GDisplay, alienProjectile4HDisplay, alienProjectile5ADisplay, alienProjectile5BDisplay, alienProjectile5CDisplay, alienProjectile5DDisplay, alienProjectile5EDisplay, alienProjectile5FDisplay, alienProjectile5GDisplay, alienProjectile5HDisplay, alienProjectile6ADisplay, alienProjectile6BDisplay, alienProjectile6CDisplay, alienProjectile6DDisplay, alienProjectile6EDisplay, alienProjectile6FDisplay, alienProjectile6GDisplay, alienProjectile6HDisplay;
    TextView playerScoreDisplay;
    byte startingShipPosition = 3;
    byte livesLeft = 3;
    byte arraySize = 3;
    int alienXPosition = 1;
    int alienYPosition = 1;
    int projectilePosition = 1;
    int playerScore;
    int numberOfProjectiles = -1;
    int alienPositionY = 1;
    int iterationNumber = -1;
    List<Integer> projpos = new ArrayList<Integer>();
    boolean GameOver = false;
    boolean moveDown = true;
    boolean projectileGone = false;
    public Alien myAlien = new Alien();
    public Ship myShip = new Ship(startingShipPosition, (byte) 1, (byte) 6);
    public Projectile myProjectile = new Projectile(startingShipPosition);
    public List<Projectile> projectiles = new ArrayList<Projectile>();
    private List<Alien> alienList = new ArrayList<Alien>();

    Timer timer = new Timer();





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeComponents();
        shipOneDisplay.setVisibility(View.INVISIBLE);

        timer.scheduleAtFixedRate(new TimerTask(){
            public void run(){
                runOnUiThread(new Runnable() {
                    public void run() {
                        createAliens(arraySize);

                    }
                });
            }

        }, 1000, 4000);

        timer.scheduleAtFixedRate(new TimerTask(){

            public void run(){
                runOnUiThread(new Runnable() {
                    public void run() {
                        moveAlien();
                    }
                });
            }
        }, 2000, 1000);

    }

    public  void  initializeComponents(){
        shipOneDisplay = findViewById(R.id.shipPosition1);
        shipTwoDisplay = findViewById(R.id.shipPosition2);
        shipThreeDisplay = findViewById(R.id.shipPosition3);
        shipFourDisplay = findViewById(R.id.shipPosition4);
        shipFiveDisplay = findViewById(R.id.shipPosition5);
        shipSixDisplay = findViewById(R.id.shipPosition6);
        alien1ADisplay = findViewById(R.id.alienPosition1a);
        alien1BDisplay = findViewById(R.id.alienPosition1b);
        alien1CDisplay = findViewById(R.id.alienPosition1c);
        alien1DDisplay = findViewById(R.id.alienPosition1d);
        alien1EDisplay = findViewById(R.id.alienPosition1e);
        alien1FDisplay = findViewById(R.id.alienPosition1f);
        alien1GDisplay = findViewById(R.id.alienPosition1g);
        alien1HDisplay = findViewById(R.id.alienPosition1h);
        alien2ADisplay = findViewById(R.id.alienPosition2a);
        alien2BDisplay = findViewById(R.id.alienPosition2b);
        alien2CDisplay = findViewById(R.id.alienPosition2c);
        alien2DDisplay = findViewById(R.id.alienPosition2d);
        alien2EDisplay = findViewById(R.id.alienPosition2e);
        alien2FDisplay = findViewById(R.id.alienPosition2f);
        alien2GDisplay = findViewById(R.id.alienPosition2g);
        alien2HDisplay = findViewById(R.id.alienPosition2h);
        alien3ADisplay = findViewById(R.id.alienPosition3a);
        alien3BDisplay = findViewById(R.id.alienPosition3b);
        alien3CDisplay = findViewById(R.id.alienPosition3c);
        alien3DDisplay = findViewById(R.id.alienPosition3d);
        alien3EDisplay = findViewById(R.id.alienPosition3e);
        alien3FDisplay = findViewById(R.id.alienPosition3f);
        alien3GDisplay = findViewById(R.id.alienPosition3g);
        alien3HDisplay = findViewById(R.id.alienPosition3h);
        alien4ADisplay = findViewById(R.id.alienPosition4a);
        alien4BDisplay = findViewById(R.id.alienPosition4b);
        alien4CDisplay = findViewById(R.id.alienPosition4c);
        alien4DDisplay = findViewById(R.id.alienPosition4d);
        alien4EDisplay = findViewById(R.id.alienPosition4e);
        alien4FDisplay = findViewById(R.id.alienPosition4f);
        alien4GDisplay = findViewById(R.id.alienPosition4g);
        alien4HDisplay = findViewById(R.id.alienPosition4h);
        alien5ADisplay = findViewById(R.id.alienPosition5a);
        alien5BDisplay = findViewById(R.id.alienPosition5b);
        alien5CDisplay = findViewById(R.id.alienPosition5c);
        alien5DDisplay = findViewById(R.id.alienPosition5d);
        alien5EDisplay = findViewById(R.id.alienPosition5e);
        alien5FDisplay = findViewById(R.id.alienPosition5f);
        alien5GDisplay = findViewById(R.id.alienPosition5g);
        alien5HDisplay = findViewById(R.id.alienPosition5h);
        alien6ADisplay = findViewById(R.id.alienPosition6a);
        alien6BDisplay = findViewById(R.id.alienPosition6b);
        alien6CDisplay = findViewById(R.id.alienPosition6c);
        alien6DDisplay = findViewById(R.id.alienPosition6d);
        alien6EDisplay = findViewById(R.id.alienPosition6e);
        alien6FDisplay = findViewById(R.id.alienPosition6f);
        alien6GDisplay = findViewById(R.id.alienPosition6g);
        alien6HDisplay = findViewById(R.id.alienPosition6h);
        projectile1ADisplay = findViewById(R.id.projectilePosition1a);
        projectile1BDisplay = findViewById(R.id.projectilePosition1b);
        projectile1CDisplay = findViewById(R.id.projectilePosition1c);
        projectile1DDisplay = findViewById(R.id.projectilePosition1d);
        projectile1EDisplay = findViewById(R.id.projectilePosition1e);
        projectile1FDisplay = findViewById(R.id.projectilePosition1f);
        projectile1GDisplay = findViewById(R.id.projectilePosition1g);
        projectile1HDisplay = findViewById(R.id.projectilePosition1h);
        projectile2ADisplay = findViewById(R.id.projectilePosition2a);
        projectile2BDisplay = findViewById(R.id.projectilePosition2b);
        projectile2CDisplay = findViewById(R.id.projectilePosition2c);
        projectile2DDisplay = findViewById(R.id.projectilePosition2d);
        projectile2EDisplay = findViewById(R.id.projectilePosition2e);
        projectile2FDisplay = findViewById(R.id.projectilePosition2f);
        projectile2GDisplay = findViewById(R.id.projectilePosition2g);
        projectile2HDisplay = findViewById(R.id.projectilePosition2h);
        projectile3ADisplay = findViewById(R.id.projectilePosition3a);
        projectile3BDisplay = findViewById(R.id.projectilePosition3b);
        projectile3CDisplay = findViewById(R.id.projectilePosition3c);
        projectile3DDisplay = findViewById(R.id.projectilePosition3d);
        projectile3EDisplay = findViewById(R.id.projectilePosition3e);
        projectile3FDisplay = findViewById(R.id.projectilePosition3f);
        projectile3GDisplay = findViewById(R.id.projectilePosition3g);
        projectile3HDisplay = findViewById(R.id.projectilePosition3h);
        projectile4ADisplay = findViewById(R.id.projectilePosition4a);
        projectile4BDisplay = findViewById(R.id.projectilePosition4b);
        projectile4CDisplay = findViewById(R.id.projectilePosition4c);
        projectile4DDisplay = findViewById(R.id.projectilePosition4d);
        projectile4EDisplay = findViewById(R.id.projectilePosition4e);
        projectile4FDisplay = findViewById(R.id.projectilePosition4f);
        projectile4GDisplay = findViewById(R.id.projectilePosition4g);
        projectile4HDisplay = findViewById(R.id.projectilePosition4h);
        projectile5ADisplay = findViewById(R.id.projectilePosition5a);
        projectile5BDisplay = findViewById(R.id.projectilePosition5b);
        projectile5CDisplay = findViewById(R.id.projectilePosition5c);
        projectile5DDisplay = findViewById(R.id.projectilePosition5d);
        projectile5EDisplay = findViewById(R.id.projectilePosition5e);
        projectile5FDisplay = findViewById(R.id.projectilePosition5f);
        projectile5GDisplay = findViewById(R.id.projectilePosition5g);
        projectile5HDisplay = findViewById(R.id.projectilePosition5h);
        projectile6ADisplay = findViewById(R.id.projectilePosition6a);
        projectile6BDisplay = findViewById(R.id.projectilePosition6b);
        projectile6CDisplay = findViewById(R.id.projectilePosition6c);
        projectile6DDisplay = findViewById(R.id.projectilePosition6d);
        projectile6EDisplay = findViewById(R.id.projectilePosition6e);
        projectile6FDisplay = findViewById(R.id.projectilePosition6f);
        projectile6GDisplay = findViewById(R.id.projectilePosition6g);
        projectile6HDisplay = findViewById(R.id.projectilePosition6h);
        life1Display = findViewById(R.id.life1);
        life2Display = findViewById(R.id.life2);
        life3Display = findViewById(R.id.life3);
        alienProjectile1ADisplay = findViewById(R.id.alienProjectilePosition1a);
        alienProjectile1BDisplay = findViewById(R.id.alienProjectilePosition1b);
        alienProjectile1CDisplay = findViewById(R.id.alienProjectilePosition1c);
        alienProjectile1DDisplay = findViewById(R.id.alienProjectilePosition1d);
        alienProjectile1EDisplay = findViewById(R.id.alienProjectilePosition1e);
        alienProjectile1FDisplay = findViewById(R.id.alienProjectilePosition1f);
        alienProjectile1GDisplay = findViewById(R.id.alienProjectilePosition1g);
        alienProjectile1HDisplay = findViewById(R.id.alienProjectilePosition1h);
        alienProjectile2ADisplay = findViewById(R.id.alienProjectilePosition2a);
        alienProjectile2BDisplay = findViewById(R.id.alienProjectilePosition2b);
        alienProjectile2CDisplay = findViewById(R.id.alienProjectilePosition2c);
        alienProjectile2DDisplay = findViewById(R.id.alienProjectilePosition2d);
        alienProjectile2EDisplay = findViewById(R.id.alienProjectilePosition2e);
        alienProjectile2FDisplay = findViewById(R.id.alienProjectilePosition2f);
        alienProjectile2GDisplay = findViewById(R.id.alienProjectilePosition2g);
        alienProjectile2HDisplay = findViewById(R.id.alienProjectilePosition2h);
        alienProjectile3ADisplay = findViewById(R.id.alienProjectilePosition3a);
        alienProjectile3BDisplay = findViewById(R.id.alienProjectilePosition3b);
        alienProjectile3CDisplay = findViewById(R.id.alienProjectilePosition3c);
        alienProjectile3DDisplay = findViewById(R.id.alienProjectilePosition3d);
        alienProjectile3EDisplay = findViewById(R.id.alienProjectilePosition3e);
        alienProjectile3FDisplay = findViewById(R.id.alienProjectilePosition3f);
        alienProjectile3GDisplay = findViewById(R.id.alienProjectilePosition3g);
        alienProjectile3HDisplay = findViewById(R.id.alienProjectilePosition3h);
        alienProjectile4ADisplay = findViewById(R.id.alienProjectilePosition4a);
        alienProjectile4BDisplay = findViewById(R.id.alienProjectilePosition4b);
        alienProjectile4CDisplay = findViewById(R.id.alienProjectilePosition4c);
        alienProjectile4DDisplay = findViewById(R.id.alienProjectilePosition4d);
        alienProjectile4EDisplay = findViewById(R.id.alienProjectilePosition4e);
        alienProjectile4FDisplay = findViewById(R.id.alienProjectilePosition4f);
        alienProjectile4GDisplay = findViewById(R.id.alienProjectilePosition4g);
        alienProjectile4HDisplay = findViewById(R.id.alienProjectilePosition4h);
        alienProjectile5ADisplay = findViewById(R.id.alienProjectilePosition5a);
        alienProjectile5BDisplay = findViewById(R.id.alienProjectilePosition5b);
        alienProjectile5CDisplay = findViewById(R.id.alienProjectilePosition5c);
        alienProjectile5DDisplay = findViewById(R.id.alienProjectilePosition5d);
        alienProjectile5EDisplay = findViewById(R.id.alienProjectilePosition5e);
        alienProjectile5FDisplay = findViewById(R.id.alienProjectilePosition5f);
        alienProjectile5GDisplay = findViewById(R.id.alienProjectilePosition5g);
        alienProjectile5HDisplay = findViewById(R.id.alienProjectilePosition5h);
        alienProjectile6ADisplay = findViewById(R.id.alienProjectilePosition6a);
        alienProjectile6BDisplay = findViewById(R.id.alienProjectilePosition6b);
        alienProjectile6CDisplay = findViewById(R.id.alienProjectilePosition6c);
        alienProjectile6DDisplay = findViewById(R.id.alienProjectilePosition6d);
        alienProjectile6EDisplay = findViewById(R.id.alienProjectilePosition6e);
        alienProjectile6FDisplay = findViewById(R.id.alienProjectilePosition6f);
        alienProjectile6GDisplay = findViewById(R.id.alienProjectilePosition6g);
        alienProjectile6HDisplay = findViewById(R.id.alienProjectilePosition6h);
        playerScoreDisplay = findViewById(R.id.scoreDisplay);
        hideShips();
        hideAlien();
        hideProjectile();
        hideAlienProjectile();
        showShips(startingShipPosition);

    }

    public List<Alien> createAliens(int size){
        if (GameOver){
            return alienList;
        }
        for (int i = 0; i < size; i++){
            alienList.add(new Alien(alienXPosition, alienYPosition, (byte) 1, (byte) 6));
            iterationNumber ++;
            showAlien(alienXPosition, alienYPosition);
            alienXPosition++;
            if (alienXPosition == 7){
                alienXPosition = 1;
            }
        }
        return alienList;
    }

    public List<Projectile> createProjectiles(int firePosition, int yPosition) {
        if (GameOver) {
            return projectiles;
        }

        projectiles.add(new Projectile(startingShipPosition));
        showProjectile(firePosition, yPosition);
        return projectiles;
    }

    public boolean checkDirection(int yPosition){
        if (isEven(yPosition)){
            return false;
        }
        return true;
    }

    public static boolean isEven(int number){
        return number%2 == 0;
    }


    public void moveLeft(View v){
        if (GameOver){
            return;
        }
        hideShips();
        showShips(myShip.shipMovement(false));
    }

    public  void moveRight(View v){
        if (GameOver){
            return;
        }
        hideShips();
        showShips(myShip.shipMovement(true));
    }

    public int checkIndex(int index) {
        if (index % 3 == 0){
            return 0;
        } else if (index % 3 == 1) {
            return 1;
        }else {
            return 2;
        }
    }

    public int findXValue(int order, int notThis) {
        int index = 0;
        for (int i = 0; i < alienList.size(); i++) {
            if (i == notThis){
                index = -1;
                break;
            }
            if (alienList.get(i).getxPosition() != 0 && i%3 == order && i != notThis) {
                index = i;
                break;
            }else {
                index = -1;
            }
        }
        return index;
    }

    public void moveAlien(){
        if (GameOver){
            return;
        }
        hideAlien();
        outuerloop:
        for (int i = 0; i < alienList.size(); i++){
            Alien thisAlien = alienList.get(i);
            Alien otherAlien = alienList.get(checkIndex(i));
            int indexValue;
            int changeValue = 0;
            boolean isGone = false;
            if (thisAlien.getyPosition() == 0) {
                isGone = true;
            } else if (otherAlien.getyPosition() == 0) {
                switch (checkIndex(i)) {
                    case 0:
                        indexValue = findXValue(0, i);
                        if (indexValue == -1) {
                            indexValue = findXValue(1, i);
                            changeValue = -1;
                            if (indexValue == -1) {
                                indexValue = findXValue(2, i);
                                changeValue = -2;
                                if (indexValue == -1) {
                                    break outuerloop;
                                }
                            }
                        }
                        otherAlien = alienList.get(indexValue);
                        break;
                    case 1:
                        indexValue = findXValue(1, i);
                        if (indexValue == -1) {
                            indexValue = findXValue(0, i);
                            changeValue = 1;
                            if (indexValue == -1) {
                                indexValue = findXValue(2, i);
                                changeValue = -1;
                                if (indexValue == -1) {
                                    break outuerloop;
                                }
                            }
                        }
                        otherAlien = alienList.get(indexValue);
                        break;
                    case 2:
                        indexValue = findXValue(2, 1);
                        if (indexValue == -1) {
                            indexValue = findXValue(1, i);
                            changeValue = 1;
                            if (indexValue == -1) {
                                indexValue = findXValue(0, 1);
                                changeValue = 2;
                                if (indexValue == -1) {
                                    break outuerloop;
                                }
                            }
                        }
                        otherAlien = alienList.get(indexValue);
                        break;
                }
            }

            if (thisAlien.getxPosition() == 1 && isEven(thisAlien.getyPosition()) && moveDown){
                for (Alien anAlien : alienList) {
                    boolean isThere = true;
                    if (anAlien.getxPosition() == 0) {
                        isThere = false;
                    }
                    if (isThere) {
                        anAlien.setyPosition(anAlien.getyPosition()+1);
                    }
                }
                for (Alien alien : alienList) {
                    showAlien(alien.getxPosition(), alien.getyPosition());
                }
                moveDown = false;
                break;
            } else if (alienList.get(iterationNumber).getxPosition() == 6 && moveDown && !isEven(thisAlien.getyPosition())) {
                for (Alien alien : alienList) {
                    boolean isThere = true;
                    if (alien.getxPosition() == 0) {
                        isThere = false;
                    }
                    if (isThere) {
                        alien.setyPosition(alien.getyPosition()+1);
                    }
                }
                moveDown = false;
                for (Alien alien : alienList) {
                   showAlien(alien.getxPosition(), alien.getyPosition());
                }
                break;
            }
            if (i == 0 && !isGone){
              showAlien(thisAlien.alienMovement(checkDirection(thisAlien.getyPosition())), thisAlien.getyPosition());
            } else if (i == 1 && !isGone || i == 2 && !isGone) {
                showAlien(thisAlien.alienMovement(checkDirection(thisAlien.getyPosition())), thisAlien.getyPosition());
            } else if (!isGone) {
                thisAlien.setyPosition(otherAlien.getyPosition() - thisAlien.getIndexNumber(i));
                thisAlien.setxPosition(otherAlien.getxPosition() + changeValue);
                showAlien(thisAlien.getxPosition(), thisAlien.getyPosition());
                if (i == alienList.size() - 1 && alienList.get(0).getxPosition() == 1 || i == alienList.size() - 1 && alienList.get(2).getxPosition() == 6) {
                    moveDown = true;
                }
            }
            if (thisAlien.getyPosition() == 9){
                GameOver = true;
            }
        }
    }

    public int findIndex(int alienXPosition, int alienYPosition) {
        int index = 0;
        for (int i = 0; i < alienList.size(); i++){
            Alien thisAlien = alienList.get(i);
            if (thisAlien.getxPosition() == alienXPosition && thisAlien.getyPosition() == alienYPosition) {
                index = i;
                break;
            }
        }
        return index;
    }

    public int findIndex(int projectilePosition) {
        int index = 0;
        for (int i = 0; i < projectiles.size(); i++){
            Projectile thisProjectile = projectiles.get(i);
            if (thisProjectile.getPosition() == projectilePosition) {
                index = i;
                break;
            }
        }
        return index;
    }

    public void removeAlien(int xPosition, int yPosition) {
        Alien thisAlien = alienList.get(findIndex(xPosition, yPosition));
        thisAlien.setyPosition(0);
        thisAlien.setxPosition(0);
        playerScore += 100;
        projectileGone = true;
    }

    public boolean checkHit(int xPosition, int yPosition) {
        switch (xPosition){
            case 1:
                switch (yPosition){
                    case 1:
                        if (alien1HDisplay.getVisibility() == View.VISIBLE){
                            alien1HDisplay.setVisibility(View.INVISIBLE);
                            projectile1ADisplay.setVisibility(View.INVISIBLE);
                            removeAlien(xPosition, 8);
                        }
                        break;
                    case 2:
                        if (alien1GDisplay.getVisibility() == View.VISIBLE){
                            alien1GDisplay.setVisibility(View.INVISIBLE);
                            projectile1BDisplay.setVisibility(View.INVISIBLE);
                            removeAlien(xPosition, 7);
                        }
                        break;
                    case 3:
                        if (alien1FDisplay.getVisibility() == View.VISIBLE){
                            alien1FDisplay.setVisibility(View.INVISIBLE);
                            projectile1CDisplay.setVisibility(View.INVISIBLE);
                            removeAlien(xPosition, 6);
                        }
                        break;
                    case 4:
                        if (alien1EDisplay.getVisibility() == View.VISIBLE){
                            alien1EDisplay.setVisibility(View.INVISIBLE);
                            projectile1DDisplay.setVisibility(View.INVISIBLE);
                            removeAlien(xPosition, 5);
                        }
                        break;
                    case 5:
                        if (alien1DDisplay.getVisibility() == View.VISIBLE){
                            alien1DDisplay.setVisibility(View.INVISIBLE);
                            projectile1EDisplay.setVisibility(View.INVISIBLE);
                            removeAlien(xPosition, 4);
                        }
                        break;
                    case 6:
                        if (alien1CDisplay.getVisibility() == View.VISIBLE){
                            alien1CDisplay.setVisibility(View.INVISIBLE);
                            projectile1FDisplay.setVisibility(View.INVISIBLE);
                            removeAlien(xPosition, 3);
                        }
                        break;
                    case 7:
                        if (alien1BDisplay.getVisibility() == View.VISIBLE){
                            alien1BDisplay.setVisibility(View.INVISIBLE);
                            projectile1GDisplay.setVisibility(View.INVISIBLE);
                            removeAlien(xPosition, 2);
                        }
                        break;
                    case 8:
                        if (alien1ADisplay.getVisibility() == View.VISIBLE){
                            alien1ADisplay.setVisibility(View.INVISIBLE);
                            projectile1HDisplay.setVisibility(View.INVISIBLE);
                            removeAlien(xPosition, 2);
                        }
                        break;
                }
                break;
            case 2:
                switch (yPosition){
                    case 1:
                        if (alien2HDisplay.getVisibility() == View.VISIBLE){
                            alien2HDisplay.setVisibility(View.INVISIBLE);
                            projectile2ADisplay.setVisibility(View.INVISIBLE);
                            removeAlien(xPosition, 8);
                        }
                        break;
                    case 2:
                        if (alien2GDisplay.getVisibility() == View.VISIBLE){
                            alien2GDisplay.setVisibility(View.INVISIBLE);
                            projectile2BDisplay.setVisibility(View.INVISIBLE);
                            removeAlien(xPosition, 7);
                        }
                        break;
                    case 3:
                        if (alien2FDisplay.getVisibility() == View.VISIBLE){
                            alien2FDisplay.setVisibility(View.INVISIBLE);
                            projectile2CDisplay.setVisibility(View.INVISIBLE);
                            removeAlien(xPosition, 6);
                        }
                        break;
                    case 4:
                        if (alien2EDisplay.getVisibility() == View.VISIBLE){
                            alien2EDisplay.setVisibility(View.INVISIBLE);
                            projectile2DDisplay.setVisibility(View.INVISIBLE);
                            removeAlien(xPosition, 5);
                        }
                        break;
                    case 5:
                        if (alien2DDisplay.getVisibility() == View.VISIBLE){
                            alien2DDisplay.setVisibility(View.INVISIBLE);
                            projectile2EDisplay.setVisibility(View.INVISIBLE);
                            removeAlien(xPosition, 4);
                        }
                        break;
                    case 6:
                        if (alien2CDisplay.getVisibility() == View.VISIBLE){
                            alien2CDisplay.setVisibility(View.INVISIBLE);
                            projectile2FDisplay.setVisibility(View.INVISIBLE);
                            removeAlien(xPosition, 3);
                        }
                        break;
                    case 7:
                        if (alien2BDisplay.getVisibility() == View.VISIBLE){
                            alien2BDisplay.setVisibility(View.INVISIBLE);
                            projectile2GDisplay.setVisibility(View.INVISIBLE);
                            removeAlien(xPosition, 2);
                        }
                        break;
                    case 8:
                        if (alien2ADisplay.getVisibility() == View.VISIBLE){
                            alien2ADisplay.setVisibility(View.INVISIBLE);
                            projectile2HDisplay.setVisibility(View.INVISIBLE);
                            removeAlien(xPosition, 1);
                        }
                        break;
                }
                break;
            case 3:
                switch (yPosition){
                    case 1:
                        if (alien3HDisplay.getVisibility() == View.VISIBLE){
                            alien3HDisplay.setVisibility(View.INVISIBLE);
                            projectile3ADisplay.setVisibility(View.INVISIBLE);
                            removeAlien(xPosition, 8);
                        }
                        break;
                    case 2:
                        if (alien3GDisplay.getVisibility() == View.VISIBLE){
                            alien3GDisplay.setVisibility(View.INVISIBLE);
                            projectile3BDisplay.setVisibility(View.INVISIBLE);
                            removeAlien(xPosition, 7);
                        }
                        break;
                    case 3:
                        if (alien3FDisplay.getVisibility() == View.VISIBLE){
                            alien3FDisplay.setVisibility(View.INVISIBLE);
                            projectile3CDisplay.setVisibility(View.INVISIBLE);
                            removeAlien(xPosition, 6);
                        }
                        break;
                    case 4:
                        if (alien3EDisplay.getVisibility() == View.VISIBLE){
                            alien3EDisplay.setVisibility(View.INVISIBLE);
                            projectile3DDisplay.setVisibility(View.INVISIBLE);
                            removeAlien(xPosition, 5);
                        }
                        break;
                    case 5:
                        if (alien3DDisplay.getVisibility() == View.VISIBLE){
                            alien3DDisplay.setVisibility(View.INVISIBLE);
                            projectile3EDisplay.setVisibility(View.INVISIBLE);
                            removeAlien(xPosition, 4);
                        }
                        break;
                    case 6:
                        if (alien3CDisplay.getVisibility() == View.VISIBLE){
                            alien3CDisplay.setVisibility(View.INVISIBLE);
                            projectile3FDisplay.setVisibility(View.INVISIBLE);
                            removeAlien(xPosition, 3);
                        }
                        break;
                    case 7:
                        if (alien3BDisplay.getVisibility() == View.VISIBLE){
                            alien3BDisplay.setVisibility(View.INVISIBLE);
                            projectile3GDisplay.setVisibility(View.INVISIBLE);
                            removeAlien(xPosition, 2);
                        }
                        break;
                    case 8:
                        if (alien3ADisplay.getVisibility() == View.VISIBLE){
                            alien3ADisplay.setVisibility(View.INVISIBLE);
                            projectile3HDisplay.setVisibility(View.INVISIBLE);
                            removeAlien(xPosition, 1);
                        }
                        break;
                }
                break;
            case 4:
                switch (yPosition){
                    case 1:
                        if (alien4HDisplay.getVisibility() == View.VISIBLE){
                            alien4HDisplay.setVisibility(View.INVISIBLE);
                            projectile4ADisplay.setVisibility(View.INVISIBLE);
                            removeAlien(xPosition, 8);
                        }
                        break;
                    case 2:
                        if (alien4GDisplay.getVisibility() == View.VISIBLE){
                            alien4GDisplay.setVisibility(View.INVISIBLE);
                            projectile4BDisplay.setVisibility(View.INVISIBLE);
                            removeAlien(xPosition, 7);
                        }
                        break;
                    case 3:
                        if (alien4FDisplay.getVisibility() == View.VISIBLE){
                            alien4FDisplay.setVisibility(View.INVISIBLE);
                            projectile4CDisplay.setVisibility(View.INVISIBLE);
                            removeAlien(xPosition, 6);
                        }
                        break;
                    case 4:
                        if (alien4EDisplay.getVisibility() == View.VISIBLE){
                            alien4EDisplay.setVisibility(View.INVISIBLE);
                            projectile4DDisplay.setVisibility(View.INVISIBLE);
                            removeAlien(xPosition, 5);
                        }
                        break;
                    case 5:
                        if (alien4DDisplay.getVisibility() == View.VISIBLE){
                            alien4DDisplay.setVisibility(View.INVISIBLE);
                            projectile4EDisplay.setVisibility(View.INVISIBLE);
                            removeAlien(xPosition, 4);
                        }
                        break;
                    case 6:
                        if (alien4CDisplay.getVisibility() == View.VISIBLE){
                            alien4CDisplay.setVisibility(View.INVISIBLE);
                            projectile4FDisplay.setVisibility(View.INVISIBLE);
                            removeAlien(xPosition, 3);
                        }
                        break;
                    case 7:
                        if (alien4BDisplay.getVisibility() == View.VISIBLE){
                            alien4BDisplay.setVisibility(View.INVISIBLE);
                            projectile4GDisplay.setVisibility(View.INVISIBLE);
                            removeAlien(xPosition, 2);
                        }
                        break;
                    case 8:
                        if (alien4ADisplay.getVisibility() == View.VISIBLE){
                            alien4ADisplay.setVisibility(View.INVISIBLE);
                            projectile4HDisplay.setVisibility(View.INVISIBLE);
                            removeAlien(xPosition, 1);
                        }
                        break;
                }
                break;
            case 5:
                switch (yPosition){
                    case 1:
                        if (alien5HDisplay.getVisibility() == View.VISIBLE){
                            alien5HDisplay.setVisibility(View.INVISIBLE);
                            projectile5ADisplay.setVisibility(View.INVISIBLE);
                            removeAlien(xPosition, 8);
                        }
                        break;
                    case 2:
                        if (alien5GDisplay.getVisibility() == View.VISIBLE){
                            alien5GDisplay.setVisibility(View.INVISIBLE);
                            projectile5BDisplay.setVisibility(View.INVISIBLE);
                            removeAlien(xPosition, 7);
                        }
                        break;
                    case 3:
                        if (alien5FDisplay.getVisibility() == View.VISIBLE){
                            alien5FDisplay.setVisibility(View.INVISIBLE);
                            projectile5CDisplay.setVisibility(View.INVISIBLE);
                            removeAlien(xPosition, 6);
                        }
                        break;
                    case 4:
                        if (alien5EDisplay.getVisibility() == View.VISIBLE){
                            alien5EDisplay.setVisibility(View.INVISIBLE);
                            projectile5DDisplay.setVisibility(View.INVISIBLE);
                            removeAlien(xPosition, 5);
                        }
                        break;
                    case 5:
                        if (alien5DDisplay.getVisibility() == View.VISIBLE){
                            alien5DDisplay.setVisibility(View.INVISIBLE);
                            projectile5EDisplay.setVisibility(View.INVISIBLE);
                            removeAlien(xPosition, 4);
                        }
                        break;
                    case 6:
                        if (alien5CDisplay.getVisibility() == View.VISIBLE){
                            alien5CDisplay.setVisibility(View.INVISIBLE);
                            projectile5FDisplay.setVisibility(View.INVISIBLE);
                            removeAlien(xPosition, 3);
                        }
                        break;
                    case 7:
                        if (alien5BDisplay.getVisibility() == View.VISIBLE){
                            alien5BDisplay.setVisibility(View.INVISIBLE);
                            projectile5GDisplay.setVisibility(View.INVISIBLE);
                            removeAlien(xPosition, 2);
                        }
                        break;
                    case 8:
                        if (alien5ADisplay.getVisibility() == View.VISIBLE){
                            alien5ADisplay.setVisibility(View.INVISIBLE);
                            projectile5HDisplay.setVisibility(View.INVISIBLE);
                            removeAlien(xPosition, 1);
                        }
                        break;
                }
                break;
            case 6:
                switch (yPosition){
                    case 1:
                        if (alien6HDisplay.getVisibility() == View.VISIBLE){
                            alien6HDisplay.setVisibility(View.INVISIBLE);
                            projectile6ADisplay.setVisibility(View.INVISIBLE);
                            removeAlien(xPosition, 8);
                        }
                        break;
                    case 2:
                        if (alien6GDisplay.getVisibility() == View.VISIBLE){
                            alien6GDisplay.setVisibility(View.INVISIBLE);
                            projectile6BDisplay.setVisibility(View.INVISIBLE);
                            removeAlien(xPosition, 7);
                        }
                        break;
                    case 3:
                        if (alien6FDisplay.getVisibility() == View.VISIBLE){
                            alien6FDisplay.setVisibility(View.INVISIBLE);
                            projectile6CDisplay.setVisibility(View.INVISIBLE);
                            removeAlien(xPosition, 6);
                        }
                        break;
                    case 4:
                        if (alien6EDisplay.getVisibility() == View.VISIBLE){
                            alien6EDisplay.setVisibility(View.INVISIBLE);
                            projectile6DDisplay.setVisibility(View.INVISIBLE);
                            removeAlien(xPosition, 5);
                        }
                        break;
                    case 5:
                        if (alien6DDisplay.getVisibility() == View.VISIBLE){
                            alien6DDisplay.setVisibility(View.INVISIBLE);
                            projectile6EDisplay.setVisibility(View.INVISIBLE);
                            removeAlien(xPosition, 4);
                        }
                        break;
                    case 6:
                        if (alien6CDisplay.getVisibility() == View.VISIBLE){
                            alien6CDisplay.setVisibility(View.INVISIBLE);
                            projectile6FDisplay.setVisibility(View.INVISIBLE);
                            removeAlien(xPosition, 3);
                        }
                        break;
                    case 7:
                        if (alien6BDisplay.getVisibility() == View.VISIBLE){
                            alien6BDisplay.setVisibility(View.INVISIBLE);
                            projectile6GDisplay.setVisibility(View.INVISIBLE);
                            removeAlien(xPosition, 2);
                        }
                        break;
                    case 8:
                        if (alien6ADisplay.getVisibility() == View.VISIBLE){
                            alien6ADisplay.setVisibility(View.INVISIBLE);
                            projectile6HDisplay.setVisibility(View.INVISIBLE);
                            removeAlien(xPosition,1);
                        }
                        break;
                }
                break;
            default:
                projectileGone = false;
        }
        return projectileGone;
    }


    public void fireProjectile(View v){
        if (GameOver){
            return;
        }
        Timer projectileTimer = new Timer();
        int xPosition = myShip.getPosition();
        numberOfProjectiles++;
        projpos.add(1);
        createProjectiles(xPosition, projpos.get(numberOfProjectiles));

        projectileTimer.scheduleAtFixedRate(new TimerTask() {

            public void run() {
                runOnUiThread(new Runnable() {
                    public void run() {
                        hideProjectile();
                        int currentPosition = projpos.get(numberOfProjectiles);
                        checkHit(myShip.getPosition(), currentPosition);
                        showProjectile(myShip.getPosition(), currentPosition);
                        playerScoreDisplay.setText("Score: " + playerScore);
                        int newPosition = currentPosition + 1;
                        projpos.set(numberOfProjectiles, newPosition);
                    }
                });
                if (projectileGone) {
                    projectiles.remove(findIndex(projpos.get(numberOfProjectiles)));
                    hideProjectile();
                    projectileGone = false;
                    projectileTimer.cancel();
                } else if (projpos.get(numberOfProjectiles) == 9) {
                    projectiles.remove(findIndex(projpos.get(numberOfProjectiles)));
                    projectileTimer.cancel();
                }
            }

        }, 100, 100);
    }

    public void hideShips(){
        shipOneDisplay.setVisibility(View.INVISIBLE);
        shipTwoDisplay.setVisibility(View.INVISIBLE);
        shipThreeDisplay.setVisibility(View.INVISIBLE);
        shipFourDisplay.setVisibility(View.INVISIBLE);
        shipFiveDisplay.setVisibility(View.INVISIBLE);
        shipSixDisplay.setVisibility(View.INVISIBLE);
    }

    public void hideAlien(){
        alien1ADisplay.setVisibility(View.INVISIBLE);
        alien1BDisplay.setVisibility(View.INVISIBLE);
        alien1CDisplay.setVisibility(View.INVISIBLE);
        alien1DDisplay.setVisibility(View.INVISIBLE);
        alien1EDisplay.setVisibility(View.INVISIBLE);
        alien1FDisplay.setVisibility(View.INVISIBLE);
        alien1GDisplay.setVisibility(View.INVISIBLE);
        alien1HDisplay.setVisibility(View.INVISIBLE);
        alien2ADisplay.setVisibility(View.INVISIBLE);
        alien2BDisplay.setVisibility(View.INVISIBLE);
        alien2CDisplay.setVisibility(View.INVISIBLE);
        alien2DDisplay.setVisibility(View.INVISIBLE);
        alien2EDisplay.setVisibility(View.INVISIBLE);
        alien2FDisplay.setVisibility(View.INVISIBLE);
        alien2GDisplay.setVisibility(View.INVISIBLE);
        alien2HDisplay.setVisibility(View.INVISIBLE);
        alien3ADisplay.setVisibility(View.INVISIBLE);
        alien3BDisplay.setVisibility(View.INVISIBLE);
        alien3CDisplay.setVisibility(View.INVISIBLE);
        alien3DDisplay.setVisibility(View.INVISIBLE);
        alien3EDisplay.setVisibility(View.INVISIBLE);
        alien3FDisplay.setVisibility(View.INVISIBLE);
        alien3GDisplay.setVisibility(View.INVISIBLE);
        alien3HDisplay.setVisibility(View.INVISIBLE);
        alien4ADisplay.setVisibility(View.INVISIBLE);
        alien4BDisplay.setVisibility(View.INVISIBLE);
        alien4CDisplay.setVisibility(View.INVISIBLE);
        alien4DDisplay.setVisibility(View.INVISIBLE);
        alien4EDisplay.setVisibility(View.INVISIBLE);
        alien4FDisplay.setVisibility(View.INVISIBLE);
        alien4GDisplay.setVisibility(View.INVISIBLE);
        alien4HDisplay.setVisibility(View.INVISIBLE);
        alien5ADisplay.setVisibility(View.INVISIBLE);
        alien5BDisplay.setVisibility(View.INVISIBLE);
        alien5CDisplay.setVisibility(View.INVISIBLE);
        alien5DDisplay.setVisibility(View.INVISIBLE);
        alien5EDisplay.setVisibility(View.INVISIBLE);
        alien5FDisplay.setVisibility(View.INVISIBLE);
        alien5GDisplay.setVisibility(View.INVISIBLE);
        alien5HDisplay.setVisibility(View.INVISIBLE);
        alien6ADisplay.setVisibility(View.INVISIBLE);
        alien6BDisplay.setVisibility(View.INVISIBLE);
        alien6CDisplay.setVisibility(View.INVISIBLE);
        alien6DDisplay.setVisibility(View.INVISIBLE);
        alien6EDisplay.setVisibility(View.INVISIBLE);
        alien6FDisplay.setVisibility(View.INVISIBLE);
        alien6GDisplay.setVisibility(View.INVISIBLE);
        alien6HDisplay.setVisibility(View.INVISIBLE);
    }

    public void hideProjectile(){
        projectile1ADisplay.setVisibility(View.INVISIBLE);
        projectile1BDisplay.setVisibility(View.INVISIBLE);
        projectile1CDisplay.setVisibility(View.INVISIBLE);
        projectile1DDisplay.setVisibility(View.INVISIBLE);
        projectile1EDisplay.setVisibility(View.INVISIBLE);
        projectile1FDisplay.setVisibility(View.INVISIBLE);
        projectile1GDisplay.setVisibility(View.INVISIBLE);
        projectile1HDisplay.setVisibility(View.INVISIBLE);
        projectile2ADisplay.setVisibility(View.INVISIBLE);
        projectile2BDisplay.setVisibility(View.INVISIBLE);
        projectile2CDisplay.setVisibility(View.INVISIBLE);
        projectile2DDisplay.setVisibility(View.INVISIBLE);
        projectile2EDisplay.setVisibility(View.INVISIBLE);
        projectile2FDisplay.setVisibility(View.INVISIBLE);
        projectile2GDisplay.setVisibility(View.INVISIBLE);
        projectile2HDisplay.setVisibility(View.INVISIBLE);
        projectile3ADisplay.setVisibility(View.INVISIBLE);
        projectile3BDisplay.setVisibility(View.INVISIBLE);
        projectile3CDisplay.setVisibility(View.INVISIBLE);
        projectile3DDisplay.setVisibility(View.INVISIBLE);
        projectile3EDisplay.setVisibility(View.INVISIBLE);
        projectile3FDisplay.setVisibility(View.INVISIBLE);
        projectile3GDisplay.setVisibility(View.INVISIBLE);
        projectile3HDisplay.setVisibility(View.INVISIBLE);
        projectile4ADisplay.setVisibility(View.INVISIBLE);
        projectile4BDisplay.setVisibility(View.INVISIBLE);
        projectile4CDisplay.setVisibility(View.INVISIBLE);
        projectile4DDisplay.setVisibility(View.INVISIBLE);
        projectile4EDisplay.setVisibility(View.INVISIBLE);
        projectile4FDisplay.setVisibility(View.INVISIBLE);
        projectile4GDisplay.setVisibility(View.INVISIBLE);
        projectile4HDisplay.setVisibility(View.INVISIBLE);
        projectile5ADisplay.setVisibility(View.INVISIBLE);
        projectile5BDisplay.setVisibility(View.INVISIBLE);
        projectile5CDisplay.setVisibility(View.INVISIBLE);
        projectile5DDisplay.setVisibility(View.INVISIBLE);
        projectile5EDisplay.setVisibility(View.INVISIBLE);
        projectile5FDisplay.setVisibility(View.INVISIBLE);
        projectile5GDisplay.setVisibility(View.INVISIBLE);
        projectile5HDisplay.setVisibility(View.INVISIBLE);
        projectile6ADisplay.setVisibility(View.INVISIBLE);
        projectile6BDisplay.setVisibility(View.INVISIBLE);
        projectile6CDisplay.setVisibility(View.INVISIBLE);
        projectile6DDisplay.setVisibility(View.INVISIBLE);
        projectile6EDisplay.setVisibility(View.INVISIBLE);
        projectile6FDisplay.setVisibility(View.INVISIBLE);
        projectile6GDisplay.setVisibility(View.INVISIBLE);
        projectile6HDisplay.setVisibility(View.INVISIBLE);
    }

    public void hideAlienProjectile(){
        alienProjectile1ADisplay.setVisibility(View.INVISIBLE);
        alienProjectile1BDisplay.setVisibility(View.INVISIBLE);
        alienProjectile1CDisplay.setVisibility(View.INVISIBLE);
        alienProjectile1DDisplay.setVisibility(View.INVISIBLE);
        alienProjectile1EDisplay.setVisibility(View.INVISIBLE);
        alienProjectile1FDisplay.setVisibility(View.INVISIBLE);
        alienProjectile1GDisplay.setVisibility(View.INVISIBLE);
        alienProjectile1HDisplay.setVisibility(View.INVISIBLE);
        alienProjectile2ADisplay.setVisibility(View.INVISIBLE);
        alienProjectile2BDisplay.setVisibility(View.INVISIBLE);
        alienProjectile2CDisplay.setVisibility(View.INVISIBLE);
        alienProjectile2DDisplay.setVisibility(View.INVISIBLE);
        alienProjectile2EDisplay.setVisibility(View.INVISIBLE);
        alienProjectile2FDisplay.setVisibility(View.INVISIBLE);
        alienProjectile2GDisplay.setVisibility(View.INVISIBLE);
        alienProjectile2HDisplay.setVisibility(View.INVISIBLE);
        alienProjectile3ADisplay.setVisibility(View.INVISIBLE);
        alienProjectile3BDisplay.setVisibility(View.INVISIBLE);
        alienProjectile3CDisplay.setVisibility(View.INVISIBLE);
        alienProjectile3DDisplay.setVisibility(View.INVISIBLE);
        alienProjectile3EDisplay.setVisibility(View.INVISIBLE);
        alienProjectile3FDisplay.setVisibility(View.INVISIBLE);
        alienProjectile3GDisplay.setVisibility(View.INVISIBLE);
        alienProjectile3HDisplay.setVisibility(View.INVISIBLE);
        alienProjectile4ADisplay.setVisibility(View.INVISIBLE);
        alienProjectile4BDisplay.setVisibility(View.INVISIBLE);
        alienProjectile4CDisplay.setVisibility(View.INVISIBLE);
        alienProjectile4DDisplay.setVisibility(View.INVISIBLE);
        alienProjectile4EDisplay.setVisibility(View.INVISIBLE);
        alienProjectile4FDisplay.setVisibility(View.INVISIBLE);
        alienProjectile4GDisplay.setVisibility(View.INVISIBLE);
        alienProjectile4HDisplay.setVisibility(View.INVISIBLE);
        alienProjectile5ADisplay.setVisibility(View.INVISIBLE);
        alienProjectile5BDisplay.setVisibility(View.INVISIBLE);
        alienProjectile5CDisplay.setVisibility(View.INVISIBLE);
        alienProjectile5DDisplay.setVisibility(View.INVISIBLE);
        alienProjectile5EDisplay.setVisibility(View.INVISIBLE);
        alienProjectile5FDisplay.setVisibility(View.INVISIBLE);
        alienProjectile5GDisplay.setVisibility(View.INVISIBLE);
        alienProjectile5HDisplay.setVisibility(View.INVISIBLE);
        alienProjectile6ADisplay.setVisibility(View.INVISIBLE);
        alienProjectile6BDisplay.setVisibility(View.INVISIBLE);
        alienProjectile6CDisplay.setVisibility(View.INVISIBLE);
        alienProjectile6DDisplay.setVisibility(View.INVISIBLE);
        alienProjectile6EDisplay.setVisibility(View.INVISIBLE);
        alienProjectile6FDisplay.setVisibility(View.INVISIBLE);
        alienProjectile6GDisplay.setVisibility(View.INVISIBLE);
        alienProjectile6HDisplay.setVisibility(View.INVISIBLE);
    }

    public void showShips(byte shipPosition){
        switch (shipPosition){
            case 1:
                shipOneDisplay.setVisibility(View.VISIBLE);
                break;
            case 2:
                shipTwoDisplay.setVisibility(View.VISIBLE);
                break;
            case 3:
                shipThreeDisplay.setVisibility(View.VISIBLE);
                break;
            case 4:
                shipFourDisplay.setVisibility(View.VISIBLE);
                break;
            case 5:
                shipFiveDisplay.setVisibility(View.VISIBLE);
                break;
            case 6:
                shipSixDisplay.setVisibility(View.VISIBLE);
                break;
        }
    }

    public void showProjectile(int projectilePosition, int projectilePositionTwo){
        switch (projectilePosition){
            case 1:
                if (projectilePositionTwo != 1){
                    switch (projectilePositionTwo){
                        case 2:
                            projectile1BDisplay.setVisibility(View.VISIBLE);
                            break;
                        case 3:
                            projectile1CDisplay.setVisibility(View.VISIBLE);
                            break;
                        case 4:
                            projectile1DDisplay.setVisibility(View.VISIBLE);
                            break;
                        case 5:
                            projectile1EDisplay.setVisibility(View.VISIBLE);
                            break;
                        case 6:
                            projectile1FDisplay.setVisibility(View.VISIBLE);
                            break;
                        case 7:
                            projectile1GDisplay.setVisibility(View.VISIBLE);
                            break;
                        case 8:
                            projectile1HDisplay.setVisibility(View.VISIBLE);
                            break;
                    }
                    break;
                }
                projectile1ADisplay.setVisibility(View.VISIBLE);
                break;
            case 2:
                if (projectilePositionTwo != 1){
                    switch (projectilePositionTwo){
                        case 2:
                            projectile2BDisplay.setVisibility(View.VISIBLE);
                            break;
                        case 3:
                            projectile2CDisplay.setVisibility(View.VISIBLE);
                            break;
                        case 4:
                            projectile2DDisplay.setVisibility(View.VISIBLE);
                            break;
                        case 5:
                            projectile2EDisplay.setVisibility(View.VISIBLE);
                            break;
                        case 6:
                            projectile2FDisplay.setVisibility(View.VISIBLE);
                            break;
                        case 7:
                            projectile2GDisplay.setVisibility(View.VISIBLE);
                            break;
                        case 8:
                            projectile2HDisplay.setVisibility(View.VISIBLE);
                            break;
                    }
                    break;
                }
                projectile2ADisplay.setVisibility(View.VISIBLE);
                break;
            case 3:
                if (projectilePositionTwo != 1){
                    switch (projectilePositionTwo){
                        case 2:
                            projectile3BDisplay.setVisibility(View.VISIBLE);
                            break;
                        case 3:
                            projectile3CDisplay.setVisibility(View.VISIBLE);
                            break;
                        case 4:
                            projectile3DDisplay.setVisibility(View.VISIBLE);
                            break;
                        case 5:
                            projectile3EDisplay.setVisibility(View.VISIBLE);
                            break;
                        case 6:
                            projectile3FDisplay.setVisibility(View.VISIBLE);
                            break;
                        case 7:
                            projectile3GDisplay.setVisibility(View.VISIBLE);
                            break;
                        case 8:
                            projectile3HDisplay.setVisibility(View.VISIBLE);
                            break;
                    }
                    break;
                }
                projectile3ADisplay.setVisibility(View.VISIBLE);
                break;
            case 4:
                if (projectilePositionTwo != 1){
                    switch (projectilePositionTwo){
                        case 2:
                            projectile4BDisplay.setVisibility(View.VISIBLE);
                            break;
                        case 3:
                            projectile4CDisplay.setVisibility(View.VISIBLE);
                            break;
                        case 4:
                            projectile4DDisplay.setVisibility(View.VISIBLE);
                            break;
                        case 5:
                            projectile4EDisplay.setVisibility(View.VISIBLE);
                            break;
                        case 6:
                            projectile4FDisplay.setVisibility(View.VISIBLE);
                            break;
                        case 7:
                            projectile4GDisplay.setVisibility(View.VISIBLE);
                            break;
                        case 8:
                            projectile4HDisplay.setVisibility(View.VISIBLE);
                            break;
                    }
                    break;
                }
                projectile4ADisplay.setVisibility(View.VISIBLE);
                break;
            case 5:
                if (projectilePositionTwo != 1){
                    switch (projectilePositionTwo){
                        case 2:
                            projectile5BDisplay.setVisibility(View.VISIBLE);
                            break;
                        case 3:
                            projectile5CDisplay.setVisibility(View.VISIBLE);
                            break;
                        case 4:
                            projectile5DDisplay.setVisibility(View.VISIBLE);
                            break;
                        case 5:
                            projectile5EDisplay.setVisibility(View.VISIBLE);
                            break;
                        case 6:
                            projectile5FDisplay.setVisibility(View.VISIBLE);
                            break;
                        case 7:
                            projectile5GDisplay.setVisibility(View.VISIBLE);
                            break;
                        case 8:
                            projectile5HDisplay.setVisibility(View.VISIBLE);
                            break;
                    }
                    break;
                }
                projectile5ADisplay.setVisibility(View.VISIBLE);
                break;
            case 6:
                if (projectilePositionTwo != 1){
                    switch (projectilePositionTwo){
                        case 2:
                            projectile6BDisplay.setVisibility(View.VISIBLE);
                            break;
                        case 3:
                            projectile6CDisplay.setVisibility(View.VISIBLE);
                            break;
                        case 4:
                            projectile6DDisplay.setVisibility(View.VISIBLE);
                            break;
                        case 5:
                            projectile6EDisplay.setVisibility(View.VISIBLE);
                            break;
                        case 6:
                            projectile6FDisplay.setVisibility(View.VISIBLE);
                            break;
                        case 7:
                            projectile6GDisplay.setVisibility(View.VISIBLE);
                            break;
                        case 8:
                            projectile6HDisplay.setVisibility(View.VISIBLE);
                            break;
                    }
                    break;
                }
                projectile6ADisplay.setVisibility(View.VISIBLE);
                break;
        }
    }

    public void showAlien(int alienXPosition, int alienYPosition){
        switch (alienXPosition) {
            case 1:
                caseOneSwitch(alienYPosition);
                break;
            case 2:
                caseTwoSwitch(alienYPosition);
                break;
            case 3:
                caseThreeSwitch(alienYPosition);
                break;
            case 4:
                caseFourSwitch(alienYPosition);
                break;
            case 5:
                caseFiveSwitch(alienYPosition);
                break;
            case 6:
                caseSixSwitch(alienYPosition);
                break;
        }
    }

    public void caseOneSwitch(int alienYPosition){
        switch (alienYPosition) {
            case 1:
                alien1ADisplay.setVisibility(View.VISIBLE);
                break;
            case 2:
                alien1BDisplay.setVisibility(View.VISIBLE);
                break;
            case 3:
                alien1CDisplay.setVisibility(View.VISIBLE);
                break;
            case 4:
                alien1DDisplay.setVisibility(View.VISIBLE);
                break;
            case 5:
                alien1EDisplay.setVisibility(View.VISIBLE);
                break;
            case 6:
                alien1FDisplay.setVisibility(View.VISIBLE);
                break;
            case 7:
                alien1GDisplay.setVisibility(View.VISIBLE);
                break;
            case 8:
                alien1HDisplay.setVisibility(View.VISIBLE);
                break;
        }
    }
    public void caseTwoSwitch(int alienYPosition){
        switch (alienYPosition) {
            case 1:
                alien2ADisplay.setVisibility(View.VISIBLE);
                break;
            case 2:
                alien2BDisplay.setVisibility(View.VISIBLE);
                break;
            case 3:
                alien2CDisplay.setVisibility(View.VISIBLE);
                break;
            case 4:
                alien2DDisplay.setVisibility(View.VISIBLE);
                break;
            case 5:
                alien2EDisplay.setVisibility(View.VISIBLE);
                break;
            case 6:
                alien2FDisplay.setVisibility(View.VISIBLE);
                break;
            case 7:
                alien2GDisplay.setVisibility(View.VISIBLE);
                break;
            case 8:
                alien2HDisplay.setVisibility(View.VISIBLE);
                break;

        }
    }
    public void caseThreeSwitch(int alienYPosition){
        switch (alienYPosition) {
            case 1:
                alien3ADisplay.setVisibility(View.VISIBLE);
                break;
            case 2:
                alien3BDisplay.setVisibility(View.VISIBLE);
                break;
            case 3:
                alien3CDisplay.setVisibility(View.VISIBLE);
                break;
            case 4:
                alien3DDisplay.setVisibility(View.VISIBLE);
                break;
            case 5:
                alien3EDisplay.setVisibility(View.VISIBLE);
                break;
            case 6:
                alien3FDisplay.setVisibility(View.VISIBLE);
                break;
            case 7:
                alien3GDisplay.setVisibility(View.VISIBLE);
                break;
            case 8:
                alien3HDisplay.setVisibility(View.VISIBLE);
                break;

        }
    }
    public void caseFourSwitch(int alienYPosition){
        switch (alienYPosition) {
            case 1:
                alien4ADisplay.setVisibility(View.VISIBLE);
                break;
            case 2:
                alien4BDisplay.setVisibility(View.VISIBLE);
                break;
            case 3:
                alien4CDisplay.setVisibility(View.VISIBLE);
                break;
            case 4:
                alien4DDisplay.setVisibility(View.VISIBLE);
                break;
            case 5:
                alien4EDisplay.setVisibility(View.VISIBLE);
                break;
            case 6:
                alien4FDisplay.setVisibility(View.VISIBLE);
                break;
            case 7:
                alien4GDisplay.setVisibility(View.VISIBLE);
                break;
            case 8:
                alien4HDisplay.setVisibility(View.VISIBLE);
                break;

        }
    }
    public void caseFiveSwitch(int alienYPosition){
        switch (alienYPosition) {
            case 1:
                alien5ADisplay.setVisibility(View.VISIBLE);
                break;
            case 2:
                alien5BDisplay.setVisibility(View.VISIBLE);
                break;
            case 3:
                alien5CDisplay.setVisibility(View.VISIBLE);
                break;
            case 4:
                alien5DDisplay.setVisibility(View.VISIBLE);
                break;
            case 5:
                alien5EDisplay.setVisibility(View.VISIBLE);
                break;
            case 6:
                alien5FDisplay.setVisibility(View.VISIBLE);
                break;
            case 7:
                alien5GDisplay.setVisibility(View.VISIBLE);
                break;
            case 8:
                alien5HDisplay.setVisibility(View.VISIBLE);
                break;

        }
    }
    public void caseSixSwitch(int alienYPosition){
        switch (alienYPosition) {
            case 1:
                alien6ADisplay.setVisibility(View.VISIBLE);
                break;
            case 2:
                alien6BDisplay.setVisibility(View.VISIBLE);
                break;
            case 3:
                alien6CDisplay.setVisibility(View.VISIBLE);
                break;
            case 4:
                alien6DDisplay.setVisibility(View.VISIBLE);
                break;
            case 5:
                alien6EDisplay.setVisibility(View.VISIBLE);
                break;
            case 6:
                alien6FDisplay.setVisibility(View.VISIBLE);
                break;
            case 7:
                alien6GDisplay.setVisibility(View.VISIBLE);
                break;
            case 8:
                alien6HDisplay.setVisibility(View.VISIBLE);
                break;

        }
    }

}