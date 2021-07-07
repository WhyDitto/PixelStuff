package ditto.oof.Overlay.CommandStuff;

import com.pixelmonmod.pixelmon.Pixelmon;
import com.pixelmonmod.pixelmon.api.dialogue.Choice;
import com.pixelmonmod.pixelmon.api.dialogue.Dialogue;
import com.pixelmonmod.pixelmon.api.events.npc.NPCEvent;
import com.pixelmonmod.pixelmon.api.pokemon.Pokemon;
import com.pixelmonmod.pixelmon.battles.BattleRegistry;
import com.pixelmonmod.pixelmon.battles.controller.participants.BattleParticipant;
import com.pixelmonmod.pixelmon.battles.controller.participants.PlayerParticipant;
import com.pixelmonmod.pixelmon.battles.controller.participants.TrainerParticipant;
import com.pixelmonmod.pixelmon.entities.npcs.NPCChatting;
import com.pixelmonmod.pixelmon.entities.npcs.NPCTrainer;
import com.pixelmonmod.pixelmon.entities.npcs.registry.NPCRegistryTrainers;
import com.pixelmonmod.pixelmon.enums.EnumNPCType;
import com.pixelmonmod.pixelmon.enums.EnumSpecies;
import com.pixelmonmod.pixelmon.enums.EnumTrainerAI;
import com.pixelmonmod.pixelmon.enums.battle.EnumBattleAIMode;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.chat.ChatType;

import java.util.ArrayList;

public class Spawns implements CommandExecutor {
    NPCChatting ChattingNPC;
    NPCTrainer TrainerNPC;
    TextComponentString welcome = new TextComponentString("Welcome to ");
    public NPCChatting SpawnChattingNPC(NPCChatting trainer, Player player){
        ArrayList<String> Chat = new ArrayList<String>();
        trainer.getEntityData().setString("GymLeader", "Ditto GYm");//TODO pixelmon already uses this !?
        trainer.init(String.valueOf(NPCRegistryTrainers.Steve));
        trainer.setPosition(player.getPosition().getX() + 0.5F, player.getPosition().getY() + 1, player.getPosition().getZ() + 0.5F);
        trainer.setAIMode(EnumTrainerAI.StandStill);
        trainer.ignoreDespawnCounter = true;
        trainer.initAI();
        Pixelmon.proxy.spawnEntitySafely(trainer, (World) player.getWorld());
        trainer.setPosition(player.getPosition().getX() + 0.5F, player.getPosition().getY() + 1, player.getPosition().getZ() + 0.5F);
        trainer.setChat(Chat);
        trainer.ignoreDespawnCounter = true;
        trainer.setName("WhyDitto");
        String name = trainer.getName();
        ChattingNPC = trainer;
        return trainer;
    }

    //Command
    @Override
    public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {


        Player player = (Player) src;
        NPCChatting chatting = new NPCChatting((World) player.getWorld());

        Spawns spawning = new Spawns();
        spawning.SpawnChattingNPC(chatting, player);
        player.sendMessage(Text.of("Spawned"));





        return CommandResult.success();
    }

    //Event
    @SubscribeEvent
    public void onClick(NPCEvent.Interact event){
        EntityPlayerMP player = (EntityPlayerMP) event.player;
        ArrayList<Pokemon> pokemon = new ArrayList<Pokemon>();
        pokemon.add(Pixelmon.pokemonFactory.create(EnumSpecies.Rotom));
        if(event.type == EnumNPCType.ChattingNPC){
            NPCTrainer trainerNPC = new NPCTrainer((World) player.getServerWorld());
            if(event.npc.getName().equals("WhyDitto")) {
                TextComponentString welcome = new TextComponentString("Hello");
                Choice.ChoiceBuilder choice1 = new Choice.ChoiceBuilder()
                        .setText("Yes!")
                        .setHandle(handle -> {
                            player.sendMessage(new TextComponentString(TextFormatting.RED + "Yes Battle Me"));
                            BattleParticipant part1 = new PlayerParticipant(player);

                            BattleParticipant participant2 = new TrainerParticipant(trainerNPC, 1);
                            BattleRegistry.startBattle(part1, participant2);
                        });
                Choice.ChoiceBuilder choice2 = new Choice.ChoiceBuilder()
                        .setText("No!")
                        .setHandle(handle ->{
                            player.sendMessage(new TextComponentString(TextFormatting.RED + "You Wouldn't Stand A Chance"));
                        });




                new Dialogue.DialogueBuilder()
                        .setName("Trainer")
                        .setText("Do you wish to fight?")
                        .addChoice(choice1.build())
                        .addChoice(choice2.build())
                        .build()
                        .open((EntityPlayerMP) player);
            }




        }


        }



}
