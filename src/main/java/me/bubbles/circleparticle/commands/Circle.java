package me.bubbles.circleparticle.commands;

import me.bubbles.circleparticle.CircleParticle;
import me.bubbles.circleparticle.ticker.CirclePatternParticle;
import me.bubbles.circleparticle.ticker.PlayerTimerManager;
import org.bukkit.Particle;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Circle implements CommandExecutor {

    private CircleParticle plugin;
    private PlayerTimerManager playerTimerManager;

    public Circle(CircleParticle plugin) {
        this.plugin=plugin;
        this.playerTimerManager=new PlayerTimerManager(plugin);
        plugin.getTimerManager().addTimer(playerTimerManager);
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(!(commandSender instanceof Player)) {
            commandSender.sendMessage("Please do this in game!");
            return true;
        }
        Player player = (Player) commandSender;
        if(playerTimerManager.contains(player)) {
            playerTimerManager.removeTimer(player);
            player.sendMessage("You're particles are gone!");
            return true;
        }
        playerTimerManager.addTimer(player, new CirclePatternParticle(plugin, Particle.LAVA, player, 1, 5,1.2));
        player.sendMessage("You have wings now!");
        return true;
    }

}
