/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package me.mrmordem;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

/**
 *
 * @author Benjamin
 */
public class DiamondDetectorListener implements Listener
{
    DiamondDetectorPlugin plugin;
    
    public DiamondDetectorListener(DiamondDetectorPlugin instance)
    {
        this.plugin = instance;
    }
    
    @EventHandler(priority = EventPriority.NORMAL)
    public void onPlayerInteract(PlayerInteractEvent event)
    {
        Player player = event.getPlayer();
        Action act = event.getAction();
        ItemStack item = event.getItem();
        Block block = event.getClickedBlock();
        
        World world = player.getWorld();
        
        if(block.getType() != Material.AIR)
        {
            int blockClickLocX = block.getLocation().getBlockX();
            int blockClickLocY = block.getLocation().getBlockY();
            int blockClickLocZ = block.getLocation().getBlockZ();
        }
        
        if(act == Action.RIGHT_CLICK_BLOCK & (block.getType() != Material.AIR || block.getType() != null))
        {
            if(item.getTypeId() == 278 & player.getInventory().contains(331))
            {
                int dirInt = 0;
                
                float yaw = player.getLocation().getYaw() / 90;
                yaw = (float)Math.round(yaw);
                
                if(yaw == -4 || yaw == 0 || yaw == 4) 
                {
                    CheckBlock(0, 1, world, player, block);
                }
                if(yaw == 3 || yaw == -1)
                {
                    CheckBlock(1, 0, world, player, block);
                }
                if (yaw == -2 || yaw == 2)
                {
                    CheckBlock(0, -1, world, player, block);
                }
                if (yaw == -3 || yaw == 1)
                {
                    CheckBlock(-1, 0, world, player, block);
                }
            }
            else
            {
                player.sendMessage("Tu n'as pas le matos requis coco !!!");
            }
        }
    }
    
    private void CheckBlock(int directionX, int directionZ, World world, Player player, Block block)
    {
        Material blockMaterial;
        Block blockToCheck = block;
        
        /*if(blockMaterial == Material.DIAMOND_ORE)
        {
            player.sendMessage("Mais c'est déjà du diaman !!!!");
        }*/
        
        for(int z = 1; z < 15; z++)
        {   
            blockToCheck = world.getBlockAt(player.getLocation().getBlockX() + (directionX * z), player.getLocation().getBlockY(), player.getLocation().getBlockZ() + (directionZ * z));
            blockMaterial = blockToCheck.getType();
            
            if(blockMaterial == Material.DIAMOND_ORE)
            {
                player.sendMessage("Il y'a du diaman a " + String.valueOf(z) + " blocks de toi");
            }
        }
    }
}