import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Carro1 extends Actor {
    private int speed;
    
    public Carro1(int v) {
        speed = v;
    }
    
    public void act() {
        if (Greenfoot.isKeyDown("right")) {
            if (getX() < 400)
                setLocation(getX() + speed, getY());
        }
        if (Greenfoot.isKeyDown("left")) {
            if (getX() > 50)
                setLocation(getX() - speed, getY());
        }
        if (Greenfoot.isKeyDown("up")) {
            if (getY() > 0)
                setLocation(getX(), getY() - speed);
        }
        if (Greenfoot.isKeyDown("down")) {
            if (getY() < 640)
                setLocation(getX(), getY() + speed);
        }
        
        checkCollision();
    }
    
    public void checkCollision() {
        Actor collided = getOneIntersectingObject(Carro2.class);
        if (collided != null) {
            getWorld().removeObject(collided);
            getWorld().removeObject(this);
            Greenfoot.stop();
        }
    }
    
    public void aumentaVelocidad() {
        speed++;
    }
}
