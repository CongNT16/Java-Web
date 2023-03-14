/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author sonnt
 */
public class MyPoint {
    private int x;
    private int y;

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
    
    
    public ArrayList<MyPoint> getRandomPoint(int num) {
        ArrayList<MyPoint> list = new ArrayList<>();
        
        int min = 0,max = 100;
        
        for (int i = 0; i< num; ++i) {
            MyPoint p = new MyPoint();
            p.setX((int)(Math.random()*(max-min+1)+min));
            p.setY((int)(Math.random()*(max-min+1)+min));
            
            list.add(p);
        }
        
        return list;
    }
    
    
}
