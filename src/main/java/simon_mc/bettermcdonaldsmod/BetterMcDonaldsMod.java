package simon_mc.bettermcdonaldsmod;

import net.minecraft.world.level.block.ComposterBlock;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import simon_mc.bettermcdonaldsmod.block.ModBlocks;
import simon_mc.bettermcdonaldsmod.item.ModCreativeModeTabs;
import simon_mc.bettermcdonaldsmod.item.ModItems;

@Mod(BetterMcDonaldsMod.MOD_ID)
public class BetterMcDonaldsMod {
    public static final String MOD_ID = "bettermcdonaldsmod";

    public BetterMcDonaldsMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModBlocks.register(modEventBus);
        ModItems.register(modEventBus);
        ModCreativeModeTabs.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);
        modEventBus.addListener(this::commonSetup);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            ComposterBlock.COMPOSTABLES.put(ModItems.TOMATO.get(), 0.65f);
            ComposterBlock.COMPOSTABLES.put(ModItems.TOMATO_SEEDS.get(), 0.2f);
            ComposterBlock.COMPOSTABLES.put(ModItems.LETTUCE.get(), 0.65f);
            ComposterBlock.COMPOSTABLES.put(ModItems.LETTUCE_SEEDS.get(), 0.2f);
        });
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTab() == ModCreativeModeTabs.BETTER_MCDONALDS_MOD_TAB.get()) {
            event.accept(ModBlocks.SALT_BLOCK);
            event.accept(ModItems.SALT);
            event.accept(ModItems.TOMATO);
            event.accept(ModItems.TOMATO_SEEDS);
            event.accept(ModItems.LETTUCE);
            event.accept(ModItems.LETTUCE_SEEDS);
            event.accept(ModItems.CHEESE);
            event.accept(ModItems.TORTILLA);
            event.accept(ModItems.BEEF_PATTY);
            event.accept(ModItems.COOKED_BEEF_PATTY);
            event.accept(ModItems.RAW_BACON);
            event.accept(ModItems.COOKED_BACON);
            event.accept(ModItems.MAYONNAISE);
            event.accept(ModItems.SWEET_SOUR_SAUCE);
            event.accept(ModItems.KETCHUP);
            event.accept(ModItems.MUSTARD);
            event.accept(ModItems.HAMBURGER);
            event.accept(ModItems.CHEESEBURGER);
            event.accept(ModItems.MCBACON);
            event.accept(ModItems.BIG_MAC);
            event.accept(ModItems.CHICKENBURGER);
            event.accept(ModItems.MCCHICKEN);
            event.accept(ModItems.FILET_O_FISH);
            event.accept(ModItems.MCWRAP);
            event.accept(ModItems.SNACK_SALAD);
            event.accept(ModItems.CHICKEN_MCNUGGETS);
            event.accept(ModItems.FRIES);
            event.accept(ModItems.HAPPY_MEAL);
            event.accept(ModItems.COCA_COLA);
            event.accept(ModItems.FANTA);
            event.accept(ModItems.SPRITE);
            event.accept(ModItems.LIPTON_ICE_TEA_PEACH);
            event.accept(ModItems.MCFLURRY);
            event.accept(ModItems.KNIFE);
        }
    }
}