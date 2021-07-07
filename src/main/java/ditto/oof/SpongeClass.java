package ditto.oof;

import com.google.inject.Inject;
import ditto.oof.Overlay.CommandStuff.*;
import net.minecraft.entity.player.EntityPlayerMP;
import org.slf4j.Logger;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.command.args.GenericArguments;
import org.spongepowered.api.command.spec.CommandSpec;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.state.GameStartedServerEvent;
import org.spongepowered.api.plugin.Dependency;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.plugin.PluginContainer;
import org.spongepowered.api.plugin.PluginManager;
import org.spongepowered.api.text.Text;

@Plugin(id = "work", name = "WORK", version = "1.0", description = "You Know")
public class SpongeClass {
public static int time = 60;

    @Inject
    private Logger logger;
    private EntityPlayerMP PlayerGlobal;

    private PluginManager pluginManager = Sponge.getPluginManager();
    private PluginContainer plugin = pluginManager.getPlugin("work").orElse(null);
    @Listener
    public void onServerStart(GameStartedServerEvent event) {
        logger.info("Successfully running ExamplePlugin!!!");
        CommandSpec NPCSpawn = CommandSpec.builder()
                .description(Text.of("Spawns A NPC"))
                .permission("SpawnNPC.spawn.ditto")
                .arguments(
                        GenericArguments.onlyOne(GenericArguments.player(Text.of("player")))
                )
                .executor(new command())
                .build();

        Sponge.getCommandManager().register(plugin, NPCSpawn, "npcspawn", "nspawn");


        CommandSpec neuter = CommandSpec.builder()
                .description(Text.of("neuter a pokemon"))
                .permission("SpawnNPC.neuter.ditto")
                .arguments(

                )
                .executor(new NeuterCommand())
                .build();

        Sponge.getCommandManager().register(plugin, neuter, "nobreed");
        CommandSpec NPCChatSpawn = CommandSpec.builder()
                .description(Text.of("spawns"))
                .permission("SpawnNPC.spawner.ditto")
                .arguments(

                )
                .executor(new Spawns())
                .build();

        Sponge.getCommandManager().register(plugin, NPCChatSpawn, "cspawn");

        CommandSpec NPCTrainerSpawn = CommandSpec.builder()
                .description(Text.of("spawns"))
                .permission("SpawnNPC.spawner.ditto")
                .arguments(

                )
                .executor(new SpawnTrainerNPC())
                .build();

        Sponge.getCommandManager().register(plugin, NPCTrainerSpawn, "tspawn");
        CommandSpec uuid = CommandSpec.builder()
                .description(Text.of("Checks A Player UUID"))
                .permission("SpawnNPC.checker.ditto")
                .arguments(
                    GenericArguments.onlyOne(GenericArguments.player(Text.of("player")))
                )
                .executor(new UUIDChecker())
                .build();

        Sponge.getCommandManager().register(plugin, uuid, "uuidchecker");

        CommandSpec openinv = CommandSpec.builder()
                .description(Text.of("Opens a inventory"))
                .permission("SpawnNPC.inv.ditto")
                .arguments(

                )
                .executor(new Inventoy())
                .build();

        Sponge.getCommandManager().register(plugin, openinv, "invopen");






    }


}
