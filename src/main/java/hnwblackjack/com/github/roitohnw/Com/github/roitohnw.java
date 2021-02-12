package hnwblackjack.com.github.roitohnw.Com.github;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Random;

public final class roitohnw extends JavaPlugin {
    Random r;


    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("HnwBlackjackが起動しました");
        r = new Random();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("HnwBlackjackが停止しました");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("hb")) {
            if (args[0].equals("help")) {
                sender.sendMessage("§e§l/hb BJ開始コマンド\n/hb ダイスを2回振るコマンド");
                return true;
                // ./hb help
            }
            if (args[0].equals("invite")) {
                Player p = Bukkit.getPlayer(args[1]);
                if (p == null) {
                    sender.sendMessage("§4§lこのプレイヤーは存在しません!");
                    return true;
                }

                if (!p.isOnline()) {
                    sender.sendMessage("&4§lこのプレイヤーはオフラインです！");
                    return true;
                }
                sender.sendMessage(p.getName() + "§e§lを招待しました");
                p.sendMessage(sender.getName() + "§e§lから招待が届いています");
                return true;
                // ./hb invite [player]
            }
        }
        if (args[0].equals("dice")) {
            int i = r.nextInt(13) + 1;
            int p = r.nextInt(13) + 1;
            int all = i + p;
            Bukkit.broadcastMessage(§6§l + sender.getName() + "§6§lは13面ダイスを2回振って" + i + "と" + p + "が出た" + "先行は" + all + "です");
            return true;
        } else {
            sender.sendMessage("§4§l使い方が間違っています");
            return true;
            // ./hb dice
        }
    }
}



