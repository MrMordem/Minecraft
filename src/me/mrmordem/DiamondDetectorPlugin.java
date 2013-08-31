/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package me.mrmordem;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author Benjamin
 */
public class DiamondDetectorPlugin extends JavaPlugin
{
    @Override
    public void onEnable()
    {
        getLogger().info("DetectorDiamond lancer");
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new DiamondDetectorListener(this), this);
    }
    
    @Override
    public void onDisable()
    {
        getLogger().info("DetectorDiamond fermer");
    }
}
