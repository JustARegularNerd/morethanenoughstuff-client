package net.minecraft.src;

import java.util.Random;

public class BlockSeaLantern extends Block {
	
	public BlockSeaLantern(int i, int j)
    {
        super(i, j, Material.glass);
    }

    public int idDropped(int i, Random random)
    {
        return mod_MoreThanEnough.prismarineCrystal.shiftedIndex;
    }
    
    public int quantityDropped(Random random)
    {
        return 5;
    }
}
