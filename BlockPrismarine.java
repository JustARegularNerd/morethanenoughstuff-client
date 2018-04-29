package net.minecraft.src;

import java.util.Random;

public class BlockPrismarine extends Block {
	public BlockPrismarine(int i, int j)
    {
        super(i, j, Material.rock);
    }

    public int idDropped(int i, Random random)
    {
        return mod_MoreThanEnough.prismarineShard.shiftedIndex;
    }
    
    public int quantityDropped(Random random)
    {
        return 4 + random.nextInt(1);
    }
    
    public boolean blockActivated(World world, int i, int j, int k, EntityPlayer entityplayer)
    {
    	entityplayer.addChatMessage("\2478Deep inside the seashite, it asks that you read comments here.. redd.it/26m30u");
    	return true;
    }
}
