package hnwblackjack.com.github.roitohnw.Com.github;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
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
        if (command.getLabel().equalsIgnoreCase("hbhelp"))
            // (command.getLabel().equalsIgnoreCase("追加するコマンド"))
            //これで2つ目のコマンドを追加できる
            sender.sendMessage("/shb BJ開始コマンド\r\n/hb ダイスを2回振るコマンド");

        if (command.getLabel().equalsIgnoreCase("shb"))
            sender.sendMessage("対戦相手を招待してください");

        if (command.getLabel().equalsIgnoreCase("invite"))
            sender.sendMessage("を招待しました");

        if (command.getName().equals("hbj")) {
            int i = r.nextInt(13)+1;
            int l = r.nextInt(13)+1;
            int all = i + l;
            Bukkit.broadcastMessage(sender.getName() + "は13面ダイスを2回振って" + i + "と" + l +"が出た" +  "先行は" + all +"です");
            return  true;
        }
        return  true;
    }
}



