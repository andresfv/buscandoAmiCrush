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
public class LaCrush {

    private String name = "C";
    private int x = 0;
    private int y = 0;
    private int invicibility = 3;
    boolean condition = true;

    public LaCrush() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getInvicibility() {
        return invicibility;
    }

    public void setInvicibility(int invicibility) {
        this.invicibility = invicibility;
    }

    public boolean isCondition() {
        return condition;
    }

    public void setCondition(boolean condition) {
        this.condition = condition;
    }

}
