/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.aliens;

import sk.tuke.oop.aliens.actor.AbstractActor;
import sk.tuke.oop.framework.Animation;


/**
 *
 * @author galilei-06
 */

public class Reactor extends AbstractActor {
    private int temperature;
    private Animation normalAnimation;
    private Animation brokenAnimation;
    private Animation hotAnimation;
    private Animation offAnimation;
    private int damage;
    private boolean state;
    
    public Reactor()
    {
        temperature = (int) 0;
        damage = 0;
        state=false;
        // create animation object
        normalAnimation = new Animation("resources/images/reactor_on.png", 80, 80, 100);
        offAnimation = new Animation("resources/images/reactor.png", 80, 80, 100);
        setAnimation(offAnimation);
        // play animation repeatedly
        normalAnimation.setPingPong(true);
        // set actor's animation to just created Animation object
        brokenAnimation = new Animation("resources/images/reactor_broken.png", 80, 80, 100);
        brokenAnimation.setPingPong(true);
        hotAnimation = new Animation("resources/images/reactor_hot.png", 80, 80, 50);
        hotAnimation.setPingPong(true);
    }
    public void turnOn(){
        state = true;
        getAnimation().start();
        updateAnimation();
    }
    
    public boolean isRunning()
    {
        if(state==true)
        return true;
        else return false;
    }
    
    public void turnOff(){
        state =false;
        getAnimation().stop();
    }
    public int getTemperature()
    {
        return temperature;
    }
    
    public int getDamage()
    {
        return damage;
    }
    
    public void repair(Hammer hammer)
    {
        System.out.println("volam repait");
        if(hammer==null)
        {
            return;
        }
        else
        {
            if(temperature>1000)
                temperature=1000;
            if(damage>50)
                damage-=50;
            else
                damage=0;
        }
        updateAnimation();
    }
    
    private void updateAnimation()
    {
        if(temperature>=5000)
            setAnimation(brokenAnimation);
        else if(temperature>=4000)
            setAnimation(hotAnimation);
        else
        if(temperature<4000)
            setAnimation(normalAnimation);
    }
    
    public void increaseTemperature(int TemperatureToIncrease)
    {
        if(state==true)
        {
            if(TemperatureToIncrease>0)
            {
                if(getDamage()>50)
            {
                temperature= getTemperature()+ 2*TemperatureToIncrease;
            }
            else 
            {
                temperature= getTemperature()+ TemperatureToIncrease;
            }
                if (getTemperature()>=5000)
                {
                    damage=100;
                }
                else
                    if (getTemperature()>4000)
                    {
                        if(damage<((getTemperature()-2000)/30))
                        {
                        damage=(getTemperature()-2000)/30;
                        }
                    }
                else
                        if(getTemperature()>2000)
                            if(damage<((getTemperature()-2000)/30))
                            {
                                damage=(getTemperature()-2000)/30;
                            }
        } 
        updateAnimation();}
    }
    
    public void decreaseTemperature(int TemperatureToDecrease)
    {
        if(state==true)
        {
        if(TemperatureToDecrease>0)
        {
            if(damage<100)
            {
                if(damage>=50)
                {  
                temperature-=TemperatureToDecrease/2;
                }
                else
                    temperature-=TemperatureToDecrease;
            }
        }  
        updateAnimation();
        }
    }
}
