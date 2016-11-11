package com.ohmast.galaxy;

import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Plugin extends JavaPlugin {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String args[]) {
        Player p = (Player) sender;

        if(label.equalsIgnoreCase("createworld")) {
//            World source = Bukkit.getWorld("world");
//            File sourceFolder = source.getWorldFolder();
//
//            WorldCreator wc = new WorldCreator("galaxy");
//            VoidWorld vw = new VoidWorld();
//            ChunkGenerator cg = vw.getDefaultWorldGenerator("", "");
//            wc.generator(cg);
//            World target = wc.createWorld();
//
//            File targetFolder = target.getWorldFolder();
//
//            copyWorld(sourceFolder, targetFolder);

//            WorldCreator first = new WorldCreator("VoidPlot");
//            first.environment(World.Environment.NORMAL);
//            first.generateStructures(false);
//            Bukkit.getServer().createWorld(first);
//
//            World source = Bukkit.getWorld("VoidPlot");
//            File sourceFolder = source.getWorldFolder();
//
//            WorldCreator wc = new WorldCreator("galaxy");
//            wc.environment(World.Environment.NORMAL);
//            wc.generateStructures(false);
//            wc.copy(source);
//            Bukkit.getServer().createWorld(wc);
//
//            World target = Bukkit.getWorld("galaxy");
//            Bukkit.getServer().unloadWorld(target, false);
//
//            File targetFolder = target.getWorldFolder();
//
//            copyWorld(sourceFolder, targetFolder);
//
//            p.sendMessage("Created World!");


//            File f = new File(Bukkit.getWorldContainer().getPath() + File.separator + "galaxy");
//            copyWorld(sourceFolder, f);
        }

        if(label.equalsIgnoreCase("wtp")) {
            World world = Bukkit.getWorld(args[0]);
            p.teleport(new Location(world, -74, 15, -39));
        }

        return true;
    }

    public void copyWorld(File source, File target){
        try {
            ArrayList<String> ignore = new ArrayList<String>(Arrays.asList("uid.dat", "session.dat"));
            if(!ignore.contains(source.getName())) {
                if(source.isDirectory()) {
                    if(!target.exists())
                        target.mkdirs();
                    String files[] = source.list();
                    for (String file : files) {
                        File srcFile = new File(source, file);
                        File destFile = new File(target, file);
                        copyWorld(srcFile, destFile);
                    }
                } else {
                    InputStream in = new FileInputStream(source);
                    OutputStream out = new FileOutputStream(target);
                    byte[] buffer = new byte[1024];
                    int length;
                    while ((length = in.read(buffer)) > 0)
                        out.write(buffer, 0, length);
                    in.close();
                    out.close();
                }
            }
        } catch (IOException e) {

        }
    }
}
