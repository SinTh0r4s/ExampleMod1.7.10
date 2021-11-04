package com.myname.mymodid.mixins.gregtech;

import com.myname.mymodid.MyMod;
import gregtech.api.items.GT_Generic_Block;
import gregtech.common.blocks.GT_Block_Ores_Abstract;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(value = GT_Block_Ores_Abstract.class, remap = false)
public class GT_Block_Ores_AbstractMixin extends GT_Generic_Block {

    protected GT_Block_Ores_AbstractMixin() {
        super(null, null, null);
    }

    @Override
    public boolean onBlockActivated(World world, int blockX, int blockY, int blockZ, EntityPlayer player, int side, float offsetX, float offsetY, float offsetZ) {
        MyMod.info("You touched a GT Ore!");
        return super.onBlockActivated(world, blockX, blockY, blockZ, player, side, offsetX, offsetY, offsetZ);
    }

    @Override
    public void onBlockClicked(World world, int blockX, int blockY, int blockZ, EntityPlayer player) {
        MyMod.info("You touched a GT Ore!");
        super.onBlockClicked(world, blockX, blockY, blockZ, player);
    }
}
