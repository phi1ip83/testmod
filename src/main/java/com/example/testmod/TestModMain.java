package com.example.testmod;

import com.mojang.logging.LogUtils;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import org.slf4j.Logger;

import java.util.Random;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(TestModMain.MODID)
public class TestModMain
{
    // Define mod id in a common place for everything to reference
    public static final String MODID = "testmod";
    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();
    // Create a Deferred Register to hold Blocks which will all be registered under the "examplemod" namespace

    public static Random RAND;
    public TestModMain()
    {
        RAND = new Random();
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();


        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(new JumpEvent());
        MinecraftForge.EVENT_BUS.register(new DragonEvent());
        MinecraftForge.EVENT_BUS.register(new SpellEvent());
        MinecraftForge.EVENT_BUS.register(new CustomSpawnEvent());


    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }


}
