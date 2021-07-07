package ditto.oof.Overlay.CommandStuff;

import com.pixelmonmod.pixelmon.Pixelmon;
import com.pixelmonmod.pixelmon.api.events.npc.NPCEvent;
import com.pixelmonmod.pixelmon.battles.BattleRegistry;
import com.pixelmonmod.pixelmon.battles.controller.BattleControllerBase;
import com.pixelmonmod.pixelmon.battles.controller.participants.BattleParticipant;
import com.pixelmonmod.pixelmon.battles.controller.participants.PlayerParticipant;
import com.pixelmonmod.pixelmon.battles.controller.participants.TrainerParticipant;
import com.pixelmonmod.pixelmon.battles.rules.BattleRules;
import com.pixelmonmod.pixelmon.entities.npcs.NPCTrainer;
import com.pixelmonmod.pixelmon.entities.npcs.registry.NPCRegistryTrainers;
import com.pixelmonmod.pixelmon.enums.EnumNPCType;
import com.pixelmonmod.pixelmon.enums.EnumTrainerAI;
import com.pixelmonmod.pixelmon.enums.battle.EnumBattleAIMode;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.entity.living.player.User;
import org.spongepowered.api.service.user.UserStorageService;
import org.spongepowered.api.text.Text;

public class SpawnTrainerNPC implements CommandExecutor {
    NPCTrainer TrainerNPC;

    public NPCTrainer SpawnTrainerNPC(NPCTrainer trainer, Player player) {
        trainer.getEntityData().setString("GymLeader", "Ditto's Gym");
        trainer.init(String.valueOf(NPCRegistryTrainers.Steve));
        trainer.setPosition(player.getPosition().getX() + 0.5F, player.getPosition().getY() + 1, player.getPosition().getZ() + 0.5F);
        trainer.setAIMode(EnumTrainerAI.StandStill);
        trainer.ignoreDespawnCounter = true;
        trainer.initAI();
        trainer.initAI();
        Pixelmon.proxy.spawnEntitySafely(trainer, (World) player.getWorld());
        trainer.setPosition(player.getPosition().getX() + 0.5F, player.getPosition().getY() + 1, player.getPosition().getZ() + 0.5F);
        trainer.ignoreDespawnCounter = true;
        trainer.setName("YuhBreh");
        trainer.setLevel(10);
        trainer.setBattleAIMode(EnumBattleAIMode.Tactical);
        String name = trainer.getName();
        TrainerNPC = trainer;
        return trainer;
    }


    @Override
    public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
        Player player = (Player) src;
        SpawnTrainerNPC spawn = new SpawnTrainerNPC();
        NPCTrainer trainer = new NPCTrainer((World) player.getWorld());
        spawn.SpawnTrainerNPC(trainer, player);


       // player.sendMessage(Text.of(Sponge.getServer().getPlayer(28520994-09e0-4d82-885c-a8386d2ac98a).get().getName()));
        return CommandResult.success();
    }

    @SubscribeEvent
    public void onClick(NPCEvent.Interact event) {
        EntityPlayerMP player = (EntityPlayerMP) event.player;
        TextComponentString message = new TextComponentString("Hello");
        if (event.type == EnumNPCType.Trainer) {
            if (event.npc.getName().equals("YuhBreh")) {
                player.sendMessage(message);


            }

        }
    }
}
