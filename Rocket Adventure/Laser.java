import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.Color;

public class Laser extends Actor
{
    private boolean toRemove=false;
    private int vx = 3;
    public void addedToWorld(World Latar)
    {
        GreenfootImage image = new GreenfootImage(50, 100);  // Ubah ukuran gambar menjadi 80x100
        image.setColor(Color.RED);
        image.drawLine(0, 5, image.getWidth() - 1, 5);
        setImage(image);
    }

    public void act()
    {
        if(!toRemove) {
            setLocation(getX()+ vx, getY());
            if(getX()>getWorld().getWidth()+200)toRemove=true;
        }else{
            getWorld().removeObject(this);
        }
    }
}

