import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Carro2 extends Actor {
    private int speed;
    
    public Carro2(int v) {
        speed = v;
    }
    
    public void act() {
        setLocation(getX(), getY() + speed);
        if (getY() >= getWorld().getHeight() - 1) {
            Pista juego = (Pista) getWorld();
            juego.removeObject(this);
            juego.aumentarPuntuacion(10);
            juego.disminuirNumRivales();
            juego.aumentarAdelantamientos();
        }
    }
}
