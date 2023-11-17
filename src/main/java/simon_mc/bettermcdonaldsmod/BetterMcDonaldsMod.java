package simon_mc.bettermcdonaldsmod;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
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
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTab() == ModCreativeModeTabs.BETTER_MCDONALDS_MOD_TAB.get()) {
            event.accept(ModBlocks.SALT_BLOCK);
            event.accept(ModItems.SALT);
            event.accept(ModItems.CHEESE);
            event.accept(ModItems.BEEF_PATTY);
            event.accept(ModItems.COOKED_BEEF_PATTY);
            event.accept(ModItems.MAYONNAISE);
            event.accept(ModItems.SWEET_SOUR_SAUCE);
            event.accept(ModItems.KETCHUP);
            event.accept(ModItems.HAMBURGER);
            event.accept(ModItems.CHEESEBURGER);
            event.accept(ModItems.BIG_MAC);
            event.accept(ModItems.CHICKENBURGER);
            event.accept(ModItems.MCCHICKEN);
            event.accept(ModItems.FILET_O_FISH);
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