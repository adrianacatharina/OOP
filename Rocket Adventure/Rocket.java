import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Rocket extends Actor
{
    private int targetx = 0, targety = 0;
    private int jeda = 0;
    private boolean toRemove = false;

    public void addedToWorld(World Latar)
    {
        // Initialize target coordinates to the initial position of the Rocket
        targetx = getX();
        targety = getY();
    }

    public void move()
    {
        double rx = targetx - getX();
        double ry = targety - getY();
        double r = Math.sqrt(rx * rx + ry * ry);
        int bts = 5;
        int posx = 0, posy = 0;

        if (r > bts) {
            posx = (int) (getX() + bts * rx / r);
            posy = (int) (getY() + bts * ry / r);
        } else {
            posx = targetx;
            posy = targety;
        }

        setLocation(posx, posy);
    }

    public void act()
    {
        if (Greenfoot.mouseMoved(null)) {
            MouseInfo mouse = Greenfoot.getMouseInfo();
            targetx = mouse.getX();
            targety = mouse.getY();
        }

        move();

        if (jeda > 0) {
            jeda--;
        }

        // Shoot a Laser when the delay (jeda) has passed
        if (jeda == 0) {
            getWorld().addObject(new Laser(), getX() + 100, getY());
            jeda = 40;  // Reset the delay
        }
    }
}
