package me.bubbles.circleparticle;

import me.bubbles.circleparticle.commands.Circle;
import me.bubbles.circleparticle.ticker.Ticker;
import me.bubbles.circleparticle.ticker.TimerManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.time.Instant;

public final class CircleParticle extends JavaPlugin {

    private TimerManager timerManager;
    private Ticker ticker;

    @Override
    public void onEnable() {

        // Plugin startup logic
        this.timerManager=new TimerManager();
        this.ticker=new Ticker(this).setEnabled(true);

        getCommand("circle").setExecutor(new Circle(this));

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public void onTick() {
        this.timerManager.onTick();
    }

    public long getEpochTimestamp() {
        return Instant.now().getEpochSecond();
    }
    public TimerManager getTimerManager() {
        return timerManager;
    }

}
