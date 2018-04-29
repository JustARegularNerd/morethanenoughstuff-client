package net.minecraft.src;

import java.util.Random;

public class mod_MoreThanEnough extends BaseMod {
	
	/* Initialize the mod in the default constructor */
	public mod_MoreThanEnough() {
		/* Stone variants */
		ModLoader.RegisterBlock(andesite);
		ModLoader.RegisterBlock(andesiteSmooth);
		ModLoader.RegisterBlock(diorite);
		ModLoader.RegisterBlock(dioriteSmooth);
		ModLoader.RegisterBlock(granite);
		ModLoader.RegisterBlock(graniteSmooth);
		
		ModLoader.AddName(andesite, "Andesite");
		ModLoader.AddName(andesiteSmooth, "Polished Andesite");
		ModLoader.AddName(diorite, "Diorite");
		ModLoader.AddName(dioriteSmooth, "Polished Diorite");
		ModLoader.AddName(granite, "Granite");
		
		
		andesite.blockIndexInTexture = ModLoader.addOverride("/terrain.png", "/jarn/stone_andesite.png");
		andesiteSmooth.blockIndexInTexture = ModLoader.addOverride("/terrain.png", "/jarn/stone_andesite_smooth.png");
		diorite.blockIndexInTexture = ModLoader.addOverride("/terrain.png", "/jarn/stone_diorite.png");
		dioriteSmooth.blockIndexInTexture = ModLoader.addOverride("/terrain.png", "/jarn/stone_diorite_smooth.png");
		granite.blockIndexInTexture = ModLoader.addOverride("/terrain.png", "/jarn/stone_granite.png");
		graniteSmooth.blockIndexInTexture = ModLoader.addOverride("/terrain.png", "/jarn/stone_granite_smooth.png");
		
		/* Other object initializations */		
		world = ModLoader.getMinecraftInstance().theWorld;
		
		/* Raw and cooked chicken items */		
		ModLoader.AddName(chickenRaw, "Raw Chicken");
		ModLoader.AddName(chickenCooked, "Cooked Chicken");
		
		chickenRaw.iconIndex = ModLoader.addOverride("/gui/items.png", "/jarn/chicken_raw.png");
		chickenCooked.iconIndex = ModLoader.addOverride("/gui/items.png", "/jarn/chicken_cooked.png");
		
		/* Prismarine blocks and items */
		ModLoader.RegisterBlock(prismarine);
		ModLoader.RegisterBlock(prismarineSmooth);
		ModLoader.RegisterBlock(prismarineDark);
		ModLoader.RegisterBlock(seaLantern);
		
		ModLoader.AddName(prismarine, "Seashite");
		ModLoader.AddName(prismarineSmooth, "Seashite Bricks");
		ModLoader.AddName(prismarineDark, "Dark Seashite");
		ModLoader.AddName(seaLantern, "Sea Lantern");
		ModLoader.AddName(prismarineShard, "Seashite Shards");
		ModLoader.AddName(prismarineCrystal, "Seashite Crystals");
		
		prismarine.blockIndexInTexture = ModLoader.addOverride("/terrain.png", "/jarn/prismarine.png");
		prismarineSmooth.blockIndexInTexture = ModLoader.addOverride("/terrain.png", "/jarn/prismarine_bricks.png");
		prismarineDark.blockIndexInTexture = ModLoader.addOverride("/terrain.png", "/jarn/prismarine_dark.png");
		seaLantern.blockIndexInTexture = ModLoader.addOverride("/terrain.png", "/jarn/sea_lantern.png");
		prismarineShard.iconIndex = ModLoader.addOverride("/gui/items.png", "/jarn/prismarine_shards.png");
		prismarineCrystal.iconIndex = ModLoader.addOverride("/gui/items.png", "/jarn/prismarine_crystals.png");
		
		/* Recipes */
		
		ModLoader.AddRecipe(new ItemStack(andesiteSmooth, 3), new Object[] {
			"##", "##", Character.valueOf('#'), andesite
		});
		ModLoader.AddRecipe(new ItemStack(dioriteSmooth, 3), new Object[] {
			"##", "##", Character.valueOf('#'), diorite
		});
		ModLoader.AddRecipe(new ItemStack(graniteSmooth, 3), new Object[] {
			"##", "##", Character.valueOf('#'), granite
		});
		ModLoader.AddRecipe(new ItemStack(prismarine, 1), new Object[] {
			"##", "##", Character.valueOf('#'), prismarineShard
		});
		ModLoader.AddRecipe(new ItemStack(prismarineSmooth, 1), new Object[] {
			"###", "###", "###", Character.valueOf('#'), prismarineShard
		});
		ModLoader.AddRecipe(new ItemStack(prismarineDark, 1), new Object[] {
			"###", "#$#", "###", Character.valueOf('#'), prismarineShard, Character.valueOf('$'), new ItemStack(Item.dyePowder, 1, 0)
		});
		ModLoader.AddRecipe(new ItemStack(seaLantern, 1), new Object[] {
			"#$#", "$$$", "#$#", Character.valueOf('#'), prismarineShard, Character.valueOf('$'), prismarineCrystal
		});
	}
	
	/* Generates custom blocks */
	public void GenerateSurface (World world, Random random, int i, int j) {
		for(int a = 0; a < 30; a++) {
			int posX = i + random.nextInt(16);
			int posY = random.nextInt(128);
			int posZ = j + random.nextInt(16);
			(new WorldGenMinable(andesite.blockID, 32)).generate(world, random, posX, posY, posZ);
		}
		for(int b = 0; b < 30; b++) {
			int posX = i + random.nextInt(16);
			int posY = random.nextInt(128);
			int posZ = j + random.nextInt(16);
			(new WorldGenMinable(diorite.blockID, 32)).generate(world, random, posX, posY, posZ);
		}
		for(int c = 0; c < 30; c++) {
			int posX = i + random.nextInt(16);
			int posY = random.nextInt(128);
			int posZ = j + random.nextInt(16);
			(new WorldGenMinable(granite.blockID, 32)).generate(world, random, posX, posY, posZ);
		}
		for(int d = 0; d < 40; d++) {
			int posX = i + random.nextInt(16);
			int posY = random.nextInt(128);
			int posZ = j + random.nextInt(16);
			(new WorldGenUnderwater(prismarine.blockID, seaLantern.blockID, 15)).generate(world, random, posX, posY, posZ);
		}
	}
	
	/* Returns the mod version */	
	public String Version() {
		return "1.0.5";
	}
	
	/* Custom Blocks */	
	public static final Block andesite;
	public static final Block andesiteSmooth;
	public static final Block diorite;
	public static final Block dioriteSmooth;
	public static final Block granite;
	public static final Block graniteSmooth;
	public static final Block prismarine;
	public static final Block prismarineSmooth;
	public static final Block prismarineDark;
	public static final Block seaLantern;
	
	/* Custom Items */
	public static Item chickenRaw;
	public static Item chickenCooked;
	public static Item prismarineShard;
	public static Item prismarineCrystal;
	
	/* Initialize objects */
	static {
		andesite = (new Block(230, 0, Material.rock)).setHardness(1.4F).setResistance(10F).setStepSound(Block.soundStoneFootstep).setBlockName("andesite");
		andesiteSmooth = (new Block(231, 0, Material.rock).setHardness(1.5F).setResistance(10.1F).setStepSound(Block.soundStoneFootstep).setBlockName("graniteSmooth"));
		diorite = (new Block(232, 0, Material.rock)).setHardness(1.4F).setResistance(10F).setStepSound(Block.soundStoneFootstep).setBlockName("diorite");
		dioriteSmooth = (new Block(233, 0, Material.rock).setHardness(1.5F).setResistance(10.1F).setStepSound(Block.soundStoneFootstep).setBlockName("dioriteSmooth"));
		granite = (new Block(234, 0, Material.rock)).setHardness(1.4F).setResistance(10F).setStepSound(Block.soundStoneFootstep).setBlockName("granite");
		graniteSmooth = (new Block(235, 0, Material.rock).setHardness(1.5F).setResistance(10.1F).setStepSound(Block.soundStoneFootstep).setBlockName("graniteSmooth"));
		prismarine = (new BlockPrismarine(236, 0).setHardness(1.2F).setResistance(30.0F).setStepSound(Block.soundStoneFootstep).setBlockName("prismarine"));
		prismarineSmooth = (new Block(237, 0, Material.rock).setHardness(1.2F).setResistance(30.0F).setStepSound(Block.soundStoneFootstep).setBlockName("prismarineSmooth"));
		prismarineDark = (new Block(238, 0, Material.rock).setHardness(1.2F).setResistance(30.0F).setStepSound(Block.soundStoneFootstep).setBlockName("prismarineDark"));
		seaLantern = (new BlockSeaLantern(239, 0).setHardness(1.0F).setResistance(1.5F).setLightValue(1.0F).setStepSound(Block.soundGlassFootstep).setBlockName("seaLantern"));
		
		chickenRaw = (new ItemFood(240, 2, false).setItemName("chickenRaw"));
		chickenCooked = (new ItemFood(241, 6, false).setItemName("chickenCooked"));
		prismarineShard = (new Item(242).setItemName("prismarineShard"));
		prismarineCrystal = (new Item(243).setItemName("prismarineCrystal"));
	}
	
	/* Other */
	World world;
}
