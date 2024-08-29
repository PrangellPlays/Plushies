package dev.prangellplays.plushies;

import dev.prangellplays.plushies.init.PlushiesBlocks;
import dev.prangellplays.plushies.init.PlushiesItemGroups;
import eu.midnightdust.lib.config.MidnightConfig;
import net.fabricmc.api.ModInitializer;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("unused")
public class Plushies implements ModInitializer {
	public static final String MOD_ID = "plushies";
	public static final Logger LOGGER = LoggerFactory.getLogger("plushies");

	public static final SoundEvent PLUSHIE_SQUEAK = SoundEvent.of(new Identifier("plushies", "sounds.plushies.plushie_squeak"));

	@Override
	public void onInitialize() {
		MidnightConfig.init(MOD_ID, PlushiesConfig.class);
		PlushiesBlocks.init();
		PlushiesItemGroups.init();
		Registry.register(Registries.SOUND_EVENT, PLUSHIE_SQUEAK.getId(), PLUSHIE_SQUEAK);
	}

	public static Identifier id(String path) {
		return new Identifier(MOD_ID, path);
	}
}