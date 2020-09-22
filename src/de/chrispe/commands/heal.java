package de.chrispe.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class heal implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
            Player player = (Player) sender;
            if(player.hasPermission("cloudcraft.heal")){
                if(args.length == 0){
                    player.setHealth(20);
                    player.setFoodLevel(20);
                    player.sendMessage("§b§l[CloudCraft] §9§lDein §c§lLeben und dein §e§lHunger wurde aufgefüllt!");
                    if(args.length == 1){
                        Player target = Bukkit.getPlayer(args[0]);
                        if(target != null){
                            target.setHealth(20);
                            target.setFoodLevel(20);
                            target.sendMessage("§b§l[CloudCraft] §9§lDir wurde dein §c§lLeben und das §6§lHungerlevel von §e§l" + target.getName() + " §9§laufgefüllt!");
                            player.sendMessage("§b§l[CloudCraft] §9§lDu hast das §c§lLeben und das §6§lHungerlevel von §e§l" + target.getName() + " §9§laufgefüllt!");

                        }else
                            player.sendMessage("§b§l[CloudCraft] §e§l" + target.getName() + " §9§list nicht auf dem Server!");
                    }else
                        player.sendMessage("§bl[CloudCraft] bitte benutze §e§l/heal [Spieler] §9§loder wenn du nur dich heilen willst dann benutze §e§l/heal §9§l!");

                }

            }else
                player.sendMessage("§b§lCloudCraft] §9§lDu hast keine Rechte für §e§l/heal §9§l!");

        return false;
    }
}
