/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author Luis Andrés Fallas Valenciano
 */
public class Tommy {

    private String name = "T";
    private int x = 1;
    private int y = 1;
    private int power = 3;
    private int bullets = 6;
    private int teleport = 4;//movimiento circular
    boolean condition = true;

    public Tommy() {
    }

    public Tommy(int x, int y, int power, int bullets, int teleport, boolean condition) {
        this.x = x;
        this.y = y;
        this.power = power;
        this.bullets = bullets;
        this.teleport = teleport;
        this.condition = condition;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getName() {

        return name;
    }

    public void setX(int x) {

        this.x = x;
    }

    public int getX() {

        return x;
    }

    public void setY(int y) {

        this.y = y;
    }

    public int getY() {

        return y;
    }

    public void setPower(int power) {

        this.power = power;
    }

    public int getPower() {

        return power;
    }

    public void setBullets(int bullets) {

        this.bullets = bullets;
    }

    public int getBullets() {

        return bullets;
    }

    public void setTeleport(int teleport) {

        this.teleport = teleport;

    }

    public int getTeleport() {

        return teleport;
    }

    public void setCondition(boolean condition) {

        this.condition = condition;
    }

    public boolean getCondition() {

        return condition;
    }
}
