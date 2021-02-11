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
                sender.sendMessage("/hb BJ開始コマンド\r\n/hb ダイスを2回振るコマンド");
                return true;
            }
            if (args[0].equals("invite")) {
                Player p = Bukkit.getPlayer(args[1]);
                if (p == null) {
                    sender.sendMessage("このプレイヤーは存在しません!");
                    return true;
                }

                if (!p.isOnline()) {
                    sender.sendMessage("このプレイヤーはオフラインです！");
                    return true;
                }
                sender.sendMessage(p.getName() + "を招待しました");
                p.sendMessage(sender.getName() + "から招待が届いています");
                return true;
            }
        }
        if (args[0].equals("dice")) {
            int i = r.nextInt(13) + 1;
            int l = r.nextInt(13) + 1;
            int all = i + l;
            Bukkit.broadcastMessage(sender.getName() + "は13面ダイスを2回振って" + i + "と" + l + "が出た" + "先行は" + all + "です");
            return true;
        } else {
            sender.sendMessage("使い方が間違っています");
            return true;
        }
    }
}



