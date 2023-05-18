package com.autumnstudios.libraries.iridescent.api.math;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;


public class SpellCasting {
    public void createCircle(Player player, int radius , int distance)
    {
        Vector dist = player.getEyeLocation().getDirection().multiply(distance);
        //mid is the middle location for the circle
        Location mid=player.getEyeLocation().add(dist);
        int particles = 50;
        for (int i = 0; i < particles; i++)
        {
            double angle, x, y;
            angle = 2 * Math.PI * i / particles;
            x = Math.cos(angle)*radius;
            y = Math.sin(angle)*radius;
            Vector v=rotateAroundAxisX(new Vector(x, y,0),player.getEyeLocation().getPitch());
            v=rotateAroundAxisY(v, player.getEyeLocation().getYaw());
            Location temp=mid.clone().add(v);
            //spawn particles at location temp using any method you like
            player.getWorld().spawnParticle(Particle.REDSTONE, temp, 1);
        }
    }
    private Vector rotateAroundAxisX(Vector v, double angle)
    {
        angle = Math.toRadians(angle);
        double y, z, cos, sin;
        cos = Math.cos(angle);
        sin = Math.sin(angle);
        y = v.getY() * cos - v.getZ() * sin;
        z = v.getY() * sin + v.getZ() * cos;
        return v.setY(y).setZ(z);
    }
    private Vector rotateAroundAxisY(Vector v, double angle)
    {
        angle = -angle;
        angle = Math.toRadians(angle);
        double x, z, cos, sin;
        cos = Math.cos(angle);
        sin = Math.sin(angle);
        x = v.getX() * cos + v.getZ() * sin;
        z = v.getX() * -sin + v.getZ() * cos;
        return v.setX(x).setZ(z);
    }
}
