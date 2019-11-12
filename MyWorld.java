import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World implements IFoodListner
{
    SnakeHead snake;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        super(30, 30, 20, false);
        setBackgroundGrid();
        addSnakeHead();
        addApple();
    }
    
    public void addSnakeHead(){
        int x = Greenfoot.getRandomNumber(getWidth());
        int y = Greenfoot.getRandomNumber(getHeight());
        snake = new SnakeHead();
        addObject(snake, x, y);
        snake.attach(this);
    }
    
    public void setBackgroundGrid(){
        GreenfootImage img = new GreenfootImage(20,20); 
        img.setColor(Color.LIGHT_GRAY);
        img.drawRect(0,0,20,20);
        setBackground(img);
    }
    
    public void addFoodToWorld(){
        if(Greenfoot.getRandomNumber(2) == 1)
        addApple();
        else
        addPizza();
    }
    
    public void addApple(){
     int x = Greenfoot.getRandomNumber(28); 
     int y = Greenfoot.getRandomNumber(28);
     addObject(new Apple(), x, y);
    }
    public void addPizza(){
     int x = Greenfoot.getRandomNumber(28); 
     int y = Greenfoot.getRandomNumber(28);
     addObject(new Pizza(), x, y);
    }
    public void act(){
       
    }
    

}
