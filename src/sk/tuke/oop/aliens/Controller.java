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
public class Controller extends AbstractActor{
    private Animation switchAnimation;
    private Reactor reactor=new Reactor();
    public Controller(Reactor reactor)
    {
        switchAnimation= new Animation("resources/images/switch.png. ", 16, 16, 10);
        setAnimation(switchAnimation);
        this.reactor=reactor;
    }
    public void toggle()
    {
        if (this.reactor.isRunning() == true) {
            this.reactor.turnOff();
        } else {
            this.reactor.turnOn();
        }
    }
}
