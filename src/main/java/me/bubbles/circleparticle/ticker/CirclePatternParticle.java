package me.bubbles.circleparticle.ticker;

import me.bubbles.circleparticle.CircleParticle;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;

public class CirclePatternParticle extends Timer {

    private int degree;
    private int rate;
    private double radius;
    private Player player;
    private Particle particle;

    public CirclePatternParticle(CircleParticle plugin, Particle particle, Player player, int speed, int rate, double radius) {
        super(plugin, speed);
        this.player=player;
        this.radius=radius;
        this.degree=0;
        this.particle=particle;
        this.rate=rate;
    }

    @Override
    public void onComplete() {
        super.onComplete();
        player.spawnParticle(particle, getNextLocation(), 1);
        degree=degree+rate;
        restart();
    }

    private Location getNextLocation() {

        Location location = player.getLocation();

        double radians = degree*(Math.PI/180);
        double cos = Math.cos(radians) * radius;
        double sin = Math.sin(radians) * radius;

        location.setX(
                location.getX()+cos
        );

        location.setZ(
                location.getZ()+sin
        );

        return location;

    }

}
