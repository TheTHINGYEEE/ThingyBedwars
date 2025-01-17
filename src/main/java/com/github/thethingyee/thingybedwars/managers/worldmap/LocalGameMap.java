package com.github.thethingyee.thingybedwars.managers.worldmap;


import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.util.FileUtil;

import java.io.*;

// Huge thanks to Jordan Osterberg at this part. https://youtu.be/mqoe_9u7qjc
public class LocalGameMap implements GameMap {

    private final File source;
    private File tempActive;

    private World world;

    public LocalGameMap(File worldFolder, String worldName, boolean loadOnInit) {
        this.source = new File(worldFolder, worldName);
        if(loadOnInit) loadWorld();
    }

    @Override
    public boolean loadWorld() {
        if(isLoaded()) return true;
        this.tempActive = new File(Bukkit.getWorldContainer().getParentFile(), source.getName() + "_temp_" + System.currentTimeMillis());
        try {
            this.copy(source, tempActive);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        this.world = Bukkit.createWorld(new WorldCreator(tempActive.getName()));

        if(world != null) world.setAutoSave(false);
        return isLoaded();
    }

    @Override
    public void unloadWorld() {
        if(world != null) Bukkit.unloadWorld(world, false);
        if(tempActive != null) deleteTempDirectory();

        world = null;
        tempActive = null;
    }

    @Override
    public boolean restoreFromSource() {
        unloadWorld();
        return loadWorld();
    }

    @Override
    public boolean isLoaded() {
        return world != null;
    }

    @Override
    public World getWorld() {
        return world;
    }

    private void copy(File source, File dest) throws IOException {
        if(source.isDirectory()) {
            if(!dest.exists()) dest.mkdir();

            String[] files = source.list();
            if(files == null) return;
            for (String file : files) {
                File newSource = new File(source, file);
                File newDest = new File(dest, file);
                copy(newSource, newDest);
            }
            return;
        }
        InputStream in = new FileInputStream(source);
        OutputStream out = new FileOutputStream(dest);

        byte[] buffer = new byte[1024];

        int length;
        while((length = in.read(buffer)) > 0) {
            out.write(buffer, 0, length);
        }
        in.close();
        out.close();
    }

    private void deleteTempDirectory() {
        File[] files = tempActive.listFiles();
        if(files == null) return;
        for (File file : files) {
            file.delete();
        }
    }
}
